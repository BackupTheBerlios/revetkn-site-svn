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

package com.revetkn.site.model.dao.hibernate;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.annotations.NamedQuery;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.revetkn.site.model.dao.SiteVisitDao;
import com.revetkn.site.model.domain.SiteVisit;

/**
 * Hibernate implementation of a <tt>SiteVisitDao</tt>.
 * @author <a href="mailto:mark.a.allen@gmail.com">Mark Allen</a>
 * @version $Id$
 * @since 0.1
 */
@NamedQuery(name = "siteVisit.recentFirst", queryString = "select s from SiteVisit s order by s.date desc")
public class HibernateSiteVisitDao extends AbstractHibernateDao<SiteVisit, Long>
        implements SiteVisitDao
{
    /**
     * @see com.revetkn.site.model.dao.SiteVisitDao#findRecentVisits(java.lang.Integer)
     */
    @SuppressWarnings("unchecked")
    public List<SiteVisit> findRecentVisits(final Integer maxResults)
            throws DataAccessException
    {
        return getHibernateTemplate().executeFind(new HibernateCallback()
        {
            /**
             * @see org.springframework.orm.hibernate3.HibernateCallback#doInHibernate(org.hibernate.Session)
             */
            public Object doInHibernate(Session session) throws HibernateException,
                    SQLException
            {
                Query query = session.getNamedQuery("siteVisit.recentFirst");

                if (maxResults != null)
                {
                    query.setMaxResults(maxResults);
                }

                return query.list();
            }
        });
    }
}
