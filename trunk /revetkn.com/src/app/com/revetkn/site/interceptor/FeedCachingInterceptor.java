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

/**
 * @author <a href="mailto:mark.a.allen@gmail.com">Mark Allen</a>
 * @version $Id$
 * @since 0.1
 */
public class FeedCachingInterceptor implements MethodInterceptor
{
    /**
     * @see org.aopalliance.intercept.MethodInterceptor#invoke(org.aopalliance.intercept.MethodInvocation)
     */
    public Object invoke(MethodInvocation methodInvocation) throws Throwable
    {
        String cacheKey = buildCacheKey(methodInvocation);
        
        Element element = cache.get(cacheKey);
        
        if (element == null)
        {
            Object result = methodInvocation.proceed();
            
            element = new Element(cacheKey, (Serializable) result);
            
            cache.put(element);
        }
        
        return element.getValue();
    }

    protected String buildCacheKey(MethodInvocation methodInvocation)
    {
        String targetName = methodInvocation.getThis().getClass().getName();
        String methodName = methodInvocation.getMethod().getName();
        Object[] arguments = methodInvocation.getArguments();

        StringBuffer buffer = new StringBuffer();

        buffer.append(targetName).append(".").append(methodName);

        if ((arguments != null) && (arguments.length != 0))
        {
            for (int i = 0; i < arguments.length; i++)
            {
                buffer.append(".").append(arguments[i]);
            }
        }

        return buffer.toString();
    }

    /**
     * Sets the cache.
     * @param cache The cache to set.
     */
    public void setCache(Cache cache)
    {
        this.cache = cache;
    }

    private Cache cache;
}
