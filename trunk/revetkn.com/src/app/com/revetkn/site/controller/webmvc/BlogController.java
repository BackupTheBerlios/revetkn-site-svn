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

package com.revetkn.site.controller.webmvc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.revetkn.site.model.domain.BlogEntry;
import com.revetkn.site.model.service.BlogService;

/**
 * Web controller that finds blog feed data and places it in the request.
 * @author <a href="mailto:mark.a.allen@gmail.com">Mark Allen</a>
 * @version $Id$
 * @since 0.1
 */
public class BlogController implements Controller
{
    /**
     * @see org.springframework.web.servlet.mvc.Controller#handleRequest(
     * javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse)
     */
    public ModelAndView handleRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        List<BlogEntry> blogEntries = blogService
                .findBlogEntries(feedUrl);

        return new ModelAndView(".blog-display", "blogEntries", blogEntries);
    }

    /**
     * Sets the blogService.
     * @param blogService The blogService to set.
     */
    public void setBlogService(BlogService blogService)
    {
        this.blogService = blogService;
    }

    /**
     * Sets the feedUrl.
     * @param feedUrl The feedUrl to set.
     */
    public void setFeedUrl(String feedUrl)
    {
        this.feedUrl = feedUrl;
    }
    
    /**
     * Used to retrieve blog information.
     */
    private BlogService blogService;
    
    /**
     * The URL of the feed to retrieve.
     */
    private String feedUrl;
}
