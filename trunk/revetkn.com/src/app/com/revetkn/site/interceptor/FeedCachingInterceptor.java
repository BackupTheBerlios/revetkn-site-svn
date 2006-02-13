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

import java.io.Serializable;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Intercepts method calls to retrieve feeds [really, any method whose first
 * parameter is a unique <tt>String</tt> such as a URL] and caches the
 * results.
 * <p>
 * Thanks to <a
 * href="http://opensource2.atlassian.com/confluence/spring/display/DISC/Caching+the+result+of+methods+using+Spring+and+EHCache">Omar
 * Irbouh</a> for the groundwork for this interceptor.
 * @author <a href="mailto:mark.a.allen@gmail.com">Mark Allen</a>
 * @version $Id$
 * @since 0.1
 */
public class FeedCachingInterceptor implements MethodInterceptor
{
    /**
     * @see org.aopalliance.intercept.MethodInterceptor#invoke(org.aopalliance.intercept.MethodInvocation)
     * @throws IllegalArgumentException If applied to a method whose first
     * argument is not of type <tt>String</tt>, or if the method result to
     * cache does not implement <tt>Serializable</tt>.
     */
    public Object invoke(MethodInvocation methodInvocation) throws Throwable
    {
        Object[] arguments = methodInvocation.getArguments();

        if (arguments == null || arguments.length == 0
                || !(arguments[0] instanceof String))
        {
            throw new IllegalArgumentException(
                    "This interceptor is only applicable for methods whose "
                            + "first parameter is of type String");
        }

        String cacheKey = (String) arguments[0];

        Element element = cache.get(cacheKey);

        if (element == null)
        {
            if (logger.isDebugEnabled())
            {
                logger.debug("Cache miss for feed '" + cacheKey + "'");
            }

            Object result = methodInvocation.proceed();

            if (!(result instanceof Serializable))
            {
                throw new IllegalArgumentException(
                        "This interceptor is only applicable for methods which "
                                + "implement Serializable");
            }

            element = new Element(cacheKey, (Serializable) result);

            cache.put(element);
        }
        else
        {
            if (logger.isDebugEnabled())
            {
                logger.debug("Feed '" + cacheKey
                        + "' is cached, using local copy");
            }
        }

        return element.getValue();
    }

    /**
     * Sets the method result cache.
     * @param cache The method result cache.
     */
    public void setCache(Cache cache)
    {
        this.cache = cache;
    }

    /**
     * The cache in which method results are stored.
     */
    private Cache cache;

    /**
     * Logger.
     */
    private static final Log logger = LogFactory
            .getLog(FeedCachingInterceptor.class);
}
