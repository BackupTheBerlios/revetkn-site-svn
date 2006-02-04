/**
 * Copyright (c) 2005-2006 Mark Allen [mark.a.allen@gmail.com]
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

package com.revetkn.site.model.domain;

import java.util.Date;

/**
 * Domain object representing a blog entry.
 * @author <a href="mailto:mark.a.allen@gmail.com">Mark Allen</a>
 * @version $Id$
 * @since 0.1
 */
public class BlogEntry
{
    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        StringBuffer buffer = new StringBuffer();

        buffer.append("author=[");
        buffer.append(author);
        buffer.append("], title=[");
        buffer.append(title);
        buffer.append("], date=[");
        buffer.append(date);
        buffer.append("], url=[");
        buffer.append(url);
        buffer.append("], content=[");
        buffer.append(content);
        buffer.append("]");

        return buffer.toString();
    }

    /**
     * Gets the content.
     * @return Returns the content.
     */
    public String getContent()
    {
        return content;
    }

    /**
     * Sets the content.
     * @param content The content to set.
     */
    public void setContent(String content)
    {
        this.content = content;
    }

    /**
     * Gets the title.
     * @return Returns the title.
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Sets the title.
     * @param title The title to set.
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * Gets the date.
     * @return Returns the date.
     */
    public Date getDate()
    {
        return date;
    }

    /**
     * Sets the date.
     * @param date The date to set.
     */
    public void setDate(Date date)
    {
        this.date = date;
    }

    /**
     * Gets the url.
     * @return Returns the url.
     */
    public String getUrl()
    {
        return url;
    }

    /**
     * Sets the url.
     * @param url The url to set.
     */
    public void setUrl(String url)
    {
        this.url = url;
    }

    /**
     * Gets the author.
     * @return Returns the author.
     */
    public String getAuthor()
    {
        return author;
    }

    /**
     * Sets the author.
     * @param author The author to set.
     */
    public void setAuthor(String author)
    {
        this.author = author;
    }

    private String title;

    private String content;

    private Date date;

    private String url;

    private String author;
}
