<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<title>Book details</title>
	
	<link type="text/css"
		 rel="stylesheet"
		 href="${pageContext.request.contextPath}/resources/css/style.css">

</head>

<body>

	<h2>Book details:</h3>
	
	<form:form action="saveBook" modelAttribute="book" method="POST">
	<form:hidden path="id" />
	
	<table>
		<tbody>
			<tr>
				<td><label>Title</label></td>
				<td><form:input path="title" /></td>
			</tr>
			<tr>
				<td><label>Author</label></td>
				<td><form:input path="author.name" /></td>
			</tr>
			<tr>
				<td><label>Status</label></td>
				<td> 
					<select name="status">
						<option value="false">To read</option>
						<option value="true">Finished</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><label>Notes</label></td>
				<td><form:input path="notes" /></td>
			</tr>
		</tbody>
	</table>
	<br>
	<tr>
		<td><input type="submit" value="save" /></td>
	</tr>
	
	</form:form>
	
	<p>
		<a href="${pageContext.request.contextPath}/library/list">Back to main List</a>
	</p>



</body>

</html>

