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
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Carrera</th>
				<th>Acciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="alumno" items="${alumnos}">
				<tr>
					<td><c:out value="${alumno.id}"></c:out></td>
					<td><c:out value="${alumno.nombre}"></c:out></td>
					<td><c:out value="${alumno.carrera}"></c:out></td>
					<td>
						<a href="#">Editar</a>
						<a href="#">Eliminar</a>
					</td>
				</tr>			
			</c:forEach>
		</tbody>
	</table>

</body>
</html>