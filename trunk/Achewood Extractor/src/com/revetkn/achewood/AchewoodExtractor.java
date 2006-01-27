/**
 * Copyright (c) 2006 Mark Allen [mark.a.allen@gmail.com]
 *
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files (the "Software"), 
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package com.revetkn.achewood;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.Random;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Extracts <a href="http://www.achewood.com">Achewood</a> comics from the web.
 * <p>
 * Waits a few seconds between requests to be 'nice' to the server.
 * <p>
 * It's trivial to extend this to take command-line arguments [initial strip date, for
 * example], but since standard usage is not frequent enough to warrant that, all
 * configuration is done via constants.
 * <p>
 * Note: since this is not an interactive application, the implementation strives for
 * clarity - not speed.
 * @author <a href="mailto:mark.a.allen@gmail.com">Mark Allen</a>
 * @version $Id$
 * @since 0.1
 */
public class AchewoodExtractor
{
    /**
     * Runs the extractor application.
     * @param args Command-line arguments [ignored].
     */
    public static void main(String[] args)
    {
        try
        {
            new AchewoodExtractor().execute();
        }
        catch (IOException e)
        {
            System.err.println("An I/O error occurred during execution: " + e);
        }
    }

    /**
     * Pulls strips from the web and saves them locally, starting with
     * <tt>INITIAL_STRIP_DATE</tt> and ending with today's date.
     * @throws IOException If an error occurs during processing.
     */
    public void execute() throws IOException
    {
        int stripsRead = 0;
        int totalAttempts = 0;
        DateTime stripDate = ACHEWOOD_DATE_FORMATTER.parseDateTime(INITIAL_STRIP_DATE);

        while (stripDate.isBeforeNow())
        {
            System.out.print("Checking " + LONG_DATE_FORMATTER.print(stripDate) + "...");

            ++totalAttempts;

            byte[] strip = retrieveStrip(stripDate);

            // Only process if we find a strip
            if (strip != null)
            {
                System.out.println("found a strip.");

                saveStrip(strip, stripDate);
                
                ++stripsRead;
            }
            else
            {
                System.out.println("no strip exists for that day.");
            }

            stripDate = stripDate.plusDays(1);
            
            waitAFewSeconds();
        }

        System.out
                .println(stripsRead + " strips read in " + totalAttempts + " attempts.");
    }

    /**
     * Retrieves a strip from the web.
     * @param stripDate The date of the strip to retrieve.
     * @return Raw bytes of the strip image, or <tt>null</tt> if no image was found.
     * @throws IOException If an error occurs while talking to achewood.com.
     */
    protected byte[] retrieveStrip(DateTime stripDate) throws IOException
    {
        HttpClient httpClient = new HttpClient();
        GetMethod getMethod = new GetMethod(BASE_STRIP_URL
                + ACHEWOOD_DATE_FORMATTER.print(stripDate));

        byte[] responseBody = null;

        try
        {
            httpClient.executeMethod(getMethod);
            responseBody = getMethod.getResponseBody();
        }
        finally
        {
            getMethod.releaseConnection();
        }

        if (getMethod.getStatusCode() != 200)
        {
            return null;
        }

        return responseBody;
    }

    /**
     * Saves a strip to disk, using its date to figure out where to put it.
     * @param image The raw strip image to save.
     * @see #createStripFilename(DateTime)
     * @see #createStorageDirectoriesIfNeeded(DateTime)
     * @param stripDate The date of the strip to save.
     * @throws IOException If an error occurs while saving the strip.
     */
    protected void saveStrip(byte[] image, DateTime stripDate) throws IOException
    {
        FileOutputStream os = null;

        createStorageDirectoriesIfNeeded(stripDate);

        try
        {
            os = new FileOutputStream(createStripFilename(stripDate));
            os.write(image);
            os.flush();
        }
        finally
        {
            if (os != null)
            {
                os.close();
            }
        }
    }

    /**
     * Helper method to build an 'organized' storage path for saved strips by examining
     * the strip's date.
     * <p>
     * General format is <tt>BASE_SAVED_DIRECTORY</tt>/Year/Month.
     * @param stripDate Date from which the directory structure is built.
     * @return A storage path for the given strip date.
     */
    protected String createStoragePath(DateTime stripDate)
    {
        return BASE_SAVED_DIRECTORY + File.separator + stripDate.getYear()
                + File.separator + MONTH_ONLY_DATE_FORMATTER.print(stripDate);
    }

    /**
     * Helper method to create a strip filename given the strip's date.
     * @see #createStoragePath(DateTime)
     * @param stripDate Date from which the strip filename is built.
     * @return A filename for the given strip date.
     */
    protected String createStripFilename(DateTime stripDate)
    {
        return createStoragePath(stripDate) + File.separator
                + DAY_ONLY_DATE_FORMATTER.print(stripDate) + ".gif";
    }

    /**
     * Creates directories as necessary to organize locally-stored strips.
     * @see #createStoragePath(DateTime)
     * @param stripDate Date from which the directory structure is built.
     * @throws IOException If an error occurs while creating directories.
     */
    protected void createStorageDirectoriesIfNeeded(DateTime stripDate)
            throws IOException
    {
        File directories = new File(createStoragePath(stripDate));

        if (!directories.exists())
        {
            if (!directories.mkdirs())
            {
                throw new IOException("Could not create directories: " + directories);
            }
        }
    }

    /**
     * Makes the current thread sleep for a bit.
     */
    protected void waitAFewSeconds()
    {
        try
        {
            Thread.sleep((1 + new Random().nextInt(MAX_SECONDS_TO_WAIT)) * 1000);
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * Achewood date formatter.
     */
    private static final DateTimeFormatter ACHEWOOD_DATE_FORMATTER = DateTimeFormat
            .forPattern("MMddyyyy");

    /**
     * Human-friendly date formatter [for display].
     */
    private static final DateTimeFormatter LONG_DATE_FORMATTER = DateTimeFormat
            .forPattern("MMMM d, yyyy");

    /**
     * Month-only date formatter [for display].
     */
    private static final DateTimeFormatter MONTH_ONLY_DATE_FORMATTER = DateTimeFormat
            .forPattern("MMMM");

    /**
     * Day-only date formatter [for display].
     */
    private static final DateTimeFormatter DAY_ONLY_DATE_FORMATTER = DateTimeFormat
            .forPattern("dd");

    /**
     * The date on which to start retrieving strips.
     */
    private static final String INITIAL_STRIP_DATE = "10012001";

    /**
     * The base URL used to retrieve a strip.
     */
    private static final String BASE_STRIP_URL = "http://www.achewood.com/comic.php?date=";

    /**
     * The base directory into which saved strips are written.
     */
    private static final String BASE_SAVED_DIRECTORY = "achewood";

    /**
     * Upper bound - 1, in seconds, for random wait time between strip retrieval.
     */
    private static final int MAX_SECONDS_TO_WAIT = 4;
}
