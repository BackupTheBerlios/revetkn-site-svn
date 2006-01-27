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

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.revetkn.site.model.dao.Dao;

/**
 * Superclass for Hibernate DAOs.
 * @author <a href="mailto:mark.a.allen@gmail.com">Mark Allen</a>
 * @version $Id$
 * @since 0.1
 */
public abstract class AbstractHibernateDao<T, ID extends Serializable> extends
        HibernateDaoSupport implements Dao<T, ID>
{
    /**
     * Initializes the persistent domain object class type that this DAO accesses.
     */
    public AbstractHibernateDao()
    {
        persistentClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * @see com.revetkn.site.model.dao.Dao#findAll()
     */
    @SuppressWarnings("unchecked")
    public List<T> findAll() throws DataAccessException
    {
        return findByCriteria();
    }

    /**
     * @see com.revetkn.site.model.dao.Dao#findById(ID)
     */
    @SuppressWarnings("unchecked")
    public T findById(ID id) throws DataAccessException
    {
        return (T) getSession().load(getPersistentClass(), id);
    }

    /**
     * @see com.revetkn.site.model.dao.Dao#makePersistent(T)
     */
    public T makePersistent(T entity) throws DataAccessException
    {
        getSession().saveOrUpdate(entity);

        return entity;
    }

    /**
     * @see com.revetkn.site.model.dao.Dao#makeTransient(T)
     */
    public void makeTransient(T entity) throws DataAccessException
    {
        getSession().delete(entity);
    }

    /**
     * @see com.revetkn.site.model.dao.Dao#findByExample(T, java.lang.String...)
     */
    @SuppressWarnings("unchecked")
    public List<T> findByExample(final T example, final String... propertiesToExclude)
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
                Criteria criteria = session.createCriteria(getPersistentClass());
                Example exampleInstance = Example.create(example);

                for (String propertyToExclude : propertiesToExclude)
                {
                    exampleInstance.excludeProperty(propertyToExclude);
                }

                criteria.add(exampleInstance);

                return criteria.list();
            }
        });
    }

    /**
     * Finds persistent objects that match a set of criteria.
     * @param criterion Any number of criteria for which persistent objects are filtered.
     * @return A list of persistent objects, or an empty list if none were found.
     */
    @SuppressWarnings("unchecked")
    protected List<T> findByCriteria(Criterion... criterion)
    {
        Criteria crit = getSession().createCriteria(getPersistentClass());

        for (Criterion c : criterion)
        {
            crit.add(c);
        }

        return crit.list();
    }

    /**
     * Gets the persistentClass.
     * @return Returns the persistentClass.
     */
    public Class<T> getPersistentClass()
    {
        return persistentClass;
    }

    private Class<T> persistentClass;
}
