/*
 * $Header$
 * $Revision$
 * $Date$
 * ====================================================================
 *
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 1999 The Apache Software Foundation.  All rights
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowlegement:
 *       "This product includes software developed by the
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowlegement may appear in the software itself,
 *    if and wherever such third-party acknowlegements normally appear.
 *
 * 4. The names "The Jakarta Project", "Tomcat", and "Apache Software
 *    Foundation" must not be used to endorse or promote products derived
 *    from this software without prior written permission. For written
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache"
 *    nor may "Apache" appear in their names without prior written
 *    permission of the Apache Group.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 * [Additional notices, if required by prior licensing conditions]
 *
 */

package org.apache.commons.httpclient;

import java.io.Serializable;

/**
 * <p>A simple class encapsulating a name/value pair.</p>
 *
 * @author <a href="mailto:bcholmes@interlog.com">B.C. Holmes</a>
 * @version $Revision$ $Date$
 */
public class NameValuePair implements Serializable {

    // ----------------------------------------------------------- Constructors

    /**
     * Default constructor.
     */
    public NameValuePair() {
        this(null, null);
    }

    /**
     * Constructor.
     */
    public NameValuePair(String name, String value) {

        this.name = name;
        this.value = value;

    }

    // ----------------------------------------------------- Instance Variables

    /**
     * Name.
     */
    private String name = null;

    /**
     * Value.
     */
    private String value = null;

    // ------------------------------------------------------------- Properties

    /**
     * Name property setter.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Name property getter.
     *
     * @return name
     */
    public String getName() {
        return name;
    }


    /**
     * Value property setter.
     *
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }


    /**
     * Value property getter.
     *
     * @return value
     */
    public String getValue() {
        return value;
    }

    // --------------------------------------------------------- Public Methods

    /**
     * Get a String representation of this pair.
     */
    public String toString() {
        return ("name=" + name + ", " + "value=" + value);
    }

    /**
     * Test if the given <i>object</i> is equal to me.
     * In this implementation, an <i>object</i> is
     * equal to me iff it has the same runtime
     * type and the <i>name</i> and <i>value</i> attributes
     * are both <tt>equal</tt> (or <tt>==</tt>).
     *
     * @param object the {@link Object} to compare to
     */
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        else if (this.getClass().equals(object.getClass())) {
            NameValuePair pair = (NameValuePair) object;
            return ((null == name ? null == pair.name : name.equals(pair.name))
                    && (null == value ? null == pair.value : value.equals(pair.value)));
        }
        else {
            return false;
        }
    }

    /**
     * Returns a hash code for this object such that
     * if <tt>a.{@link #equals equals}(b)</tt> then
     * <tt>a.hashCode() == b.hashCode()</tt>.
     */
    public int hashCode() {
        return (this.getClass().hashCode() ^
                (null == name ? 0 : name.hashCode()) ^
                (null == value ? 0 : value.hashCode()));
    }

    /*
    public Object clone() {
        try {
            NameValuePair that = (NameValuePair)(super.clone());
            that.setName(this.getName());
            that.setValue(this.getValue());
            return that;
        } catch(CloneNotSupportedException e) {
            // this should never happen
            throw new RuntimeException("Panic. super.clone not supported in NameValuePair.");
        }
    }
    */
}
