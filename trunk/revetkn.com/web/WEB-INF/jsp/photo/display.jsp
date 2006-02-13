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

<h2>Various Photos</h2>

These are pulled from my
<a href="http://www.flickr.com/photos/revetkn/">Flickr</a>
account.

<div id="center">

<table class="photoTable">

	<c:forEach items="${photos}" var="photo" varStatus="status">

		<c:choose>

			<c:when test="${status.index % 2 == 0}">
				<tr>
					<c:choose>
						<c:when test="${status.last}">
							<td colspan="2">
							<p><span class="date"><fmt:formatDate value="${photo.date}"
								pattern="MMMM d, yyyy 'at' h:mm a" /></span></p>
							${photo.description}</td>
				</tr>
			</c:when>

			<c:otherwise>
				<td>
				<p><span class="date"><fmt:formatDate value="${photo.date}"
					pattern="MMMM d, yyyy 'at' h:mm a" /></span></p>
				${photo.description}</td>
			</c:otherwise>

		</c:choose>

		</c:when>

		<c:otherwise>
			<td>
			<p><span class="date"><fmt:formatDate value="${photo.date}"
				pattern="MMMM d, yyyy 'at' h:mm a" /></span></p>
			${photo.description}</td>
			</tr>
		</c:otherwise>

		</c:choose>

	</c:forEach>

</table>

</div>
