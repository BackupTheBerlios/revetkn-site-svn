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

package com.revetkn.site.model.domain;

import java.util.Date;

/**
 * @author <a href="mailto:mark.a.allen@gmail.com">Mark Allen</a>
 * @version $Id$
 * @since 0.1
 */
public class WebImage
{
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
     * Gets the description.
     * @return Returns the description.
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Sets the description.
     * @param description The description to set.
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * Gets the name.
     * @return Returns the name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name.
     * @param name The name to set.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the thumbnailUrl.
     * @return Returns the thumbnailUrl.
     */
    public String getThumbnailUrl()
    {
        return thumbnailUrl;
    }

    /**
     * Sets the thumbnailUrl.
     * @param thumbnailUrl The thumbnailUrl to set.
     */
    public void setThumbnailUrl(String thumbnailUrl)
    {
        this.thumbnailUrl = thumbnailUrl;
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

    private String url;

    private String name;

    private String description;

    private Date date;

    private String thumbnailUrl;
}
