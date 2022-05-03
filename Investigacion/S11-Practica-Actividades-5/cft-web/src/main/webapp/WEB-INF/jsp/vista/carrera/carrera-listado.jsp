<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Listado carreras</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

	<h1>Carreras</h1>	
	<table class="table table-stripped">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Acciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="carrera" items="${carreras}">
				<tr>
					<td><c:out value="${carrera.id}"></c:out></td>
					<td><c:out value="${carrera.nombre}"></c:out></td>
					<td>
						<a href="${pageContext.request.contextPath}/CarreraController?accion=editar&amp;id=${carrera.id}">Editar</a>
						<a href="${pageContext.request.contextPath}/CarreraController?accion=eliminar&amp;id=${carrera.id}">Eliminar</a>
					</td>
				</tr>			
			</c:forEach>
		</tbody>
	</table>

</body>
</html>