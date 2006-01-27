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

package com.revetkn.site.model.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.revetkn.site.model.domain.SiteVisit;

/**
 * Data access object contract for <tt>SiteVisit</tt>s.
 * @see com.revetkn.site.model.domain.SiteVisit
 * @author <a href="mailto:mark.a.allen@gmail.com">Mark Allen</a>
 * @version $Id$
 * @since 0.1
 */
public interface SiteVisitDao extends Dao<SiteVisit, Long>
{
    /**
     * Finds recent site visits.
     * @param maxResults The maximum number of site visits to find [use <tt>null</tt> to
     * find all visits].
     * @return Recent site visits, or an empty list if none were found.
     * @throws DataAccessException If an error occurs in the persistent store.
     */
    public List<SiteVisit> findRecentVisits(Integer maxResults)
            throws DataAccessException;
}