/**
 * Copyright (c) 2005 Mark Allen [mark.a.allen@gmail.com]
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

package com.revetkn.site.model.service.flickr;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.revetkn.site.model.domain.WebImage;
import com.revetkn.site.model.service.WebImageException;
import com.revetkn.site.model.service.WebImageService;

import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;

/**
 * @author <a href="mailto:mark.a.allen@gmail.com">Mark Allen</a>
 * @version $Id$
 * @since 0.1
 */
public class FlickrWebImageService implements WebImageService
{
    /**
     * @see com.revetkn.site.model.service.WebImageService#findImages(java.lang.String)
     */
    public List<WebImage> findImages(String feedUrl) throws WebImageException
    {
        try
        {
            URL url = new URL(feedUrl);
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new InputStreamReader(url.openStream()));

            System.out.println(feed);

            return extractWebImages(feed.getEntries());
        }
        catch (FeedException e)
        {
            throw new WebImageException(e);
        }
        catch (IOException e)
        {
            throw new WebImageException(e);
        }
    }

    protected List<WebImage> extractWebImages(List rawEntries)
    {
        List<WebImage> webImages = new ArrayList<WebImage>();

        for (Iterator i = rawEntries.iterator(); i.hasNext();)
        {
            // SyndEntry syndEntry = (SyndEntry) i.next();
            WebImage webImage = new WebImage();

            /*
             * blogEntry.setAuthor(syndEntry.getAuthor());
             * blogEntry.setContent(syndEntry.getDescription().getValue().trim());
             * blogEntry.setUrl(syndEntry.getLink());
             * blogEntry.setTitle(syndEntry.getTitle());
             * blogEntry.setDate(syndEntry.getPublishedDate());
             */

            webImages.add(webImage);
        }

        return webImages;
    }
}
