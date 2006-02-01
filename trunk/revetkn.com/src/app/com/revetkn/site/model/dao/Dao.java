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

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

/**
 * Persistence-strategy independent contract for generic data access operations.
 * <p>
 * Follows the <a href="http://www.hibernate.org/328.html">Generic DAO</a> pattern.
 * <p>
 * All exceptions thrown are run-time exceptions.
 * @see org.springframework.dao.DataAccessException
 * @author <a href="mailto:mark.a.allen@gmail.com">Mark Allen</a>
 * @version $Id$
 * @since 0.1
 */
public interface Dao<T, ID extends Serializable>
{
    /**
     * Retrieves a persistent object.
     * @param id The ID of the persistent object to retrieve.
     * @return The persistent object, or <tt>null</tt> if it was not found.
     * @throws DataAccessException If an error occurs in the persistent store.
     */
    T findById(ID id) throws DataAccessException;

    /**
     * Finds all instances of a persistent object.
     * @return All instances of a persistent object, or an empty list if none were found.
     * @throws DataAccessException If an error occurs in the persistent store.
     */
    List<T> findAll() throws DataAccessException;

    /**
     * Finds persistent objects matching the criteria specified by an 'example' instance.
     * @param example The entities that match the example criteria.
     * @param propertiesToExclude Properties to exclude from the example criteria.
     * @return All instances, or an empty list if none were found.
     * @throws DataAccessException If an error occurs in the persistent store.
     */
    List<T> findByExample(T example, String... propertiesToExclude)
            throws DataAccessException;

    /**
     * Saves an object to the persistent store.
     * @param entity The object to save to the persistent store.
     * @return The persisted object.
     * @throws DataAccessException If an error occurs in the persistent store.
     */
    T makePersistent(T entity) throws DataAccessException;

    /**
     * Removes an object from the persistent store.
     * @param entity The object to remove from the persistent store.
     * @throws DataAccessException If an error occurs in the persistent store.
     */
    void makeTransient(T entity) throws DataAccessException;
}
