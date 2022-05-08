<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<!-- Incluye facilitador de Table Sort -->
	<%@ include file="includes/tablesort.jsp" %>	
	<meta charset="ISO-8859-1">
	<title>Listado</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body class="bg-light">
<%@include file="includes/navbar.jsp" %>
<div class="my-3 p-3 bg-body rounded shadow-sm">
	<h1>Electrodomesticos</h1>	
	<table id="sortTable" class="table table-striped">
		<thead>
			<tr>
				<th class="col">ID</th>
				<th class="col">Nombre</th>
				<th class="col">Falla</th>
				<th class="col">Cliente asociado</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="electrodomesticos" items="${electrodomesticos}">
				<tr>
					<td><c:out value="${electrodomesticos.id}"></c:out></td>
					<td><c:out value="${electrodomesticos.nombre}"></c:out></td>
					<td><c:out value="${electrodomesticos.falla}"></c:out></td>
					<td><c:out value="${electrodomesticos.cliente_id.nombre}"></c:out></td>
				</tr>			
			</c:forEach>
		</tbody>
	</table>
		<a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-primary" role="button" data-bs-toggle="button">Volver</a>
</div>
</body>

	<!-- Llama las funciones de sort de DataTable -->
	<%@ include file="includes/tablesorttrad.jsp" %>

</html>