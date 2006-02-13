<%--
	Copyright (c) 2006 Mark Allen [mark.a.allen@gmail.com]
	
	Permission is hereby granted, free of charge, to any person obtaining a
	copy of this software and associated documentation files (the "Software"), 
	to deal in the Software without restriction, including without limitation
	the rights to use, copy, modify, merge, publish, distribute, sublicense,
	and/or sell copies of the Software, and to permit persons to whom the
	Software is furnished to do so, subject to the following conditions:
	
	The above copyright notice and this permission notice shall be included in
	all copies or substantial portions of the Software.
	
	THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
	IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
	FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
	THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
	LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
	FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
	DEALINGS IN THE SOFTWARE.
	
	@author Mark Allen mark.a.allen@gmail.com
	@version $Id$
	@since 0.1
	--%>

<%@ include file="/WEB-INF/jsp/taglibs.jsp"%>

<h2>About This Site</h2>

<div id="center"><img class="bordered"
	src="<c:url value="/images/me.jpg"/>" /></div>

<p>My name is <a href="mailto:mark.a.allen@gmail.com">Mark Allen</a>,
and I work as a software engineer for large Pharma. AIM SN is <tt>RevetKN</tt>.</p>

<p>The code that powers this site is open source - feel free to download
it and <a href="<c:url value="/open-source.url#licensing"/>">use it as
you wish</a>.</p>

<p>Hosting is provided by <a href="http://www.dailyrazor.com/" />DailyRazor</a>
- they have a Java 5/private Tomcat plan and quick support response
times [they fixed my setup within a half hour of my posting a ticket].</p>
