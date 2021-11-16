<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>

<!DOCTYPE html>

<html>
<head>

</head>

	<title modelAttribute="theAuthor">${theAuthor.name}</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

<body>

	<h2>${theAuthor.name} books:</h2>

	<table>
	<th>Book</th>
	<th>Status</th>
	
	<!-- looping over books list -->
	<c:forEach var="tempBook" items="${authorsBooks}">
	
	<!-- book link creation -->
	<c:url var="detailsLink" value="showDetails">
		<c:param name="bookId" value="${tempBook.id}" />
	</c:url>
	
	<tr>
		<td><a href="${detailsLink}">${tempBook.title}</a></td>
		<td>${tempBook.displayStatus()}</td>
	</tr>
	
	</c:forEach>
	
	</table>
	
		<p>
		<a href="${pageContext.request.contextPath}/library/list">Back to main List</a>
	</p>

	
</body>

</html>