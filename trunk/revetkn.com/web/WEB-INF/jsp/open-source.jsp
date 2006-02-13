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

<h2>Open Source Software</h2>

In my free time, I use and work on various open source software
projects.
<a href="http://www.berlios.de">BerliOS</a>
graciously provides free project management and Subversion hosting for
my code.

<h3>revetkn.com</h3>

<p>This website is written in Java 5 to the Servlet 2.4 spec and can be
backed by any relational database whose SQL dialect is supported by
Hibernate. Some features include transparent threadpool-backed logging,
RSS/Atom feed consumption with transparent caching, and generified
annotation-based persistence [non-EJB3].</p>

<p>Anonymous SVN access is available through both <tt>svnserve</tt> and
HTTP.</p>
<p><tt>svnserve</tt>:</p>
<pre>
svn checkout svn://svn.berlios.de/revetkn-site/trunk/revetkn.com
</pre>

HTTP:
<pre>
svn checkout http://svn.berlios.de/svnroot/repos/revetkn-site/trunk/revetkn.com
</pre>

You can also
<a
	href="http://svn.berlios.de/wsvn/revetkn-site/trunk/revetkn.com/?rev=0&sc=0">view
the latest version through your web browser</a>
.

<p>Java technologies used:</p>

<ul>
	<li><a href="http://www.springframework.org">Spring</a> for application
	configuration, AOP support, and Web MVC</li>
	<li><a href="http://www.hibernate.org">Hibernate</a> for
	object-relational mapping</li>
	<li><a href="https://rome.dev.java.net/">Rome</a> for RSS/Atom feed
	parsing</li>
	<li><a href="http://testng.org">TestNG</a> for automated unit and
	integration tests</li>
	<li><a href="http://ant.apache.org/">Ant</a> for automated building and
	deployment</li>
</ul>


<div id="center">

<table class="imageTable">
	<tr>
		<td class="imageTable"><img
			src="<c:url value="/images/tech/java.jpg"/>" /></td>
		<td class="imageTable"><img
			src="<c:url value="/images/tech/spring_white.png"/>" /></td>
		<td class="imageTable"><img
			src="<c:url value="/images/tech/hibernate_logo.gif"/>" /></td>
		<td class="imageTable"><img
			src="<c:url value="/images/tech/rome.png"/>" /></td>
	</tr>
</table>

<table class="imageTable">
	<tr>
		<td class="imageTable"><img
			src="<c:url value="/images/tech/logo_tomcat.png"/>" /></td>
		<td class="imageTable"><img
			src="<c:url value="/images/tech/mysql.gif"/>" /></td>
		<td class="imageTable"><img
			src="<c:url value="/images/tech/ant_logo_large.gif"/>" /></td>
	</tr>
</table>

<table class="imageTable">
	<tr>
		<td class="imageTable"><img
			src="<c:url value="/images/tech/berliOS_logo.png"/>" /></td>
		<td class="imageTable"><img
			src="<c:url value="/images/tech/subversion_logo.png"/>" /></td>
	</tr>
</table>

</div>

<h3>Achewood Extractor</h3>

<p><a href="http://www.achewood.com" />Achewood</a> is a web comic
written by Chris Onstad. <i>Achewood Extractor</i>, given a start date,
retrieves and writes to disk every comic written since then [categorized
hierarchically according to date]. HTTP requests are staggered to be
nice to the Achewood webserver. The excellent <a
	href="http://joda-time.sourceforge.net/index.html">Joda Time</a> API is
used instead of <tt>java.util.Calendar</tt>, making the code easy to
write and read.</p>

<p>Anonymous SVN access is available through both <tt>svnserve</tt> and
HTTP.</p>
<p><tt>svnserve</tt>:</p>
<pre>
svn checkout svn://svn.berlios.de/revetkn-site/trunk/Achewood%20Extractor
</pre>

HTTP:
<pre>
svn checkout http://svn.berlios.de/svnroot/repos/revetkn-site/trunk/Achewood%20Extractor
</pre>

You can also
<a
	href="http://svn.berlios.de/wsvn/revetkn-site/trunk/Achewood%20Extractor/?rev=0&sc=0">view
the latest version through your web browser</a>
.

<h2><a class="undecorated-completely" name="licensing">Licensing</a></h2>


All software is released under the terms of the
<a href="http://www.opensource.org/licenses/mit-license.php">MIT license</a>
:

<pre>
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
</pre>
