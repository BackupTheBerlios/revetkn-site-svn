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

package com.revetkn.site.model.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author <a href="mailto:mark.a.allen@gmail.com">Mark Allen</a>
 * @version $Id$
 * @since 0.1
 */
@Entity
public class User implements Serializable
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

    private Long id;

    private String name;
}
