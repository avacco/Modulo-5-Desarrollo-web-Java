<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Listado</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body class="bg-light">
<%@include file="includes/navbar.jsp" %>
<div class="my-3 p-3 bg-body rounded shadow-sm">
	<h1>Clientes</h1>	
	<table class="table table-striped">
		<thead>
			<tr>
				<th class="col">ID</th>
				<th class="col">Nombre</th>
				<th class="col">Telefono</th>
				<th class="col">Direccion</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="clientes" items="${clientes}">
				<tr>
					<td><c:out value="${clientes.id}"></c:out></td>
					<td><c:out value="${clientes.nombre}"></c:out></td>
					<td><c:out value="${clientes.telefono}"></c:out></td>
					<td><c:out value="${clientes.direccion}"></c:out></td>
				</tr>			
			</c:forEach>
		</tbody>
	</table>
		<a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-primary" role="button" data-bs-toggle="button">Volver</a>
</div>		
	
		
</body>
</html>