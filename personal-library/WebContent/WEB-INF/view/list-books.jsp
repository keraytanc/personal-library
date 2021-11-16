<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>

<!DOCTYPE html>

<html>

<head>

	<title>Personal Library</title>
	
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">
		 

</head>

<body>

	<h2>My Library!</h2>
	<input align="center" type="button" value="Add new book"
		onclick="window.location.href='details'; return false;" />
		<br>
		<br>

		
	<!-- table with books -->
	<table>
		<th>Title</th>
		<th>Author</th>
		<th>Status</th>
		<th>More</th>	
	
	<!-- looping over books list -->
	<c:forEach var="tempBook" items="${books}">
	
	<!-- Update and delete links creation -->
	<c:url var="detailsLink" value="showDetails">
		<c:param name="bookId" value="${tempBook.id}" />
	</c:url>
	<c:url var="deleteLink" value="delete">
		<c:param name="bookId" value="${tempBook.id}" />
	</c:url>
	<c:url var="authorLink" value="author">
		<c:param name="authorId" value="${tempBook.author.id}" />
	</c:url>
	
		<tr>
			<td> ${tempBook.title} </td>
			<td> <a href="${authorLink}">${tempBook.author.name}</a></td>
			<td> ${tempBook.displayStatus()} </td>
			<td>
			<a href="${detailsLink}">Details</a>
			|
			<a href="${deleteLink}">Delete</a>
			</td>
		</tr>
	
	</c:forEach>
	</table>


</body>
</html>