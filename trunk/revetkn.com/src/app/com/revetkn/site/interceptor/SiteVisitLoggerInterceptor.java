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

package com.revetkn.site.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.revetkn.site.model.domain.SiteVisit;
import com.revetkn.site.model.service.LoggingService;

/**
 * Interceptor that logs HTTP requests.
 * @author <a href="mailto:mark.a.allen@gmail.com">Mark Allen</a>
 * @version $Id$
 * @since 0.1
 */
public class SiteVisitLoggerInterceptor extends HandlerInterceptorAdapter
{
    /**
     * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse, java.lang.Object)
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception
    {
        SiteVisit siteVisit = new SiteVisit();

        siteVisit.setUrl(request.getRequestURI());
        siteVisit.setIpAddress(request.getRemoteAddr());
        siteVisit.setHostname(request.getRemoteHost());
        siteVisit.setDate(new Date());

        loggingService.saveSiteVisit(siteVisit);

        // Move on to the next interceptor in the chain [if any]
        return true;
    }

    /**
     * Sets the loggingService.
     * @param loggingService The loggingService to set.
     */
    public void setLoggingService(LoggingService loggingService)
    {
        this.loggingService = loggingService;
    }

    private LoggingService loggingService;
}
