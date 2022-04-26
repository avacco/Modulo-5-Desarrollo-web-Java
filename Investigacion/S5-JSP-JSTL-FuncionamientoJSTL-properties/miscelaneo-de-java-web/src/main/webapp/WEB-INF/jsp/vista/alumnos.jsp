<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<h1>Alumnos</h1>
	<table class="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Direccion</th>
				<th>Comuna</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${alumnos}" var="alumno">
			<tr>
				<td><c:out value="${alumno.id}" default="X"></c:out></td>
				<td><c:out value="${alumno.nombre}" default="X"></c:out></td>
				<td><c:out value="${alumno.direccion}" default="X"></c:out></td>
				<td><c:out value="${alumno.comuna}" default="X"></c:out></td>
			</tr>
		
		</c:forEach>
		</tbody>
	</table>

</body>
</html>