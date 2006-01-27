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

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.NotNull;

/**
 * Domain object representing a website visit.
 * @author <a href="mailto:mark.a.allen@gmail.com">Mark Allen</a>
 * @version $Id$
 * @since 0.1
 */
@Entity
public class SiteVisit implements Serializable
{
    /**
     * Gets the id.
     * @return Returns the id.
     */
    @Id
    public Long getId()
    {
        return id;
    }

    /**
     * Sets the id.
     * @param id The id to set.
     */
    public void setId(Long id)
    {
        this.id = id;
    }

    /**
     * Gets the date.
     * @return Returns the date.
     */
    @NotNull
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
     * Gets the hostname.
     * @return Returns the hostname.
     */
    public String getHostname()
    {
        return hostname;
    }

    /**
     * Sets the hostname.
     * @param hostname The hostname to set.
     */
    public void setHostname(String hostname)
    {
        this.hostname = hostname;
    }

    /**
     * Gets the ipAddress.
     * @return Returns the ipAddress.
     */
    @NotNull
    public String getIpAddress()
    {
        return ipAddress;
    }

    /**
     * Sets the ipAddress.
     * @param ipAddress The ipAddress to set.
     */
    public void setIpAddress(String ipAddress)
    {
        this.ipAddress = ipAddress;
    }

    /**
     * Gets the url.
     * @return Returns the url.
     */
    @NotNull
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

    private String ipAddress;

    private String hostname;

    private Date date;

    private Long id;
}
