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
<%@ include file="includes/navbar.jsp" %>
<div class="my-3 p-3 bg-body rounded shadow-sm">
	<h1>Ordenes de trabajo</h1>	
	<table id="sortTable" class="table table-striped">
		<thead>
			<tr>
				<th class="col">ID</th>
				<th class="col">Objeto</th>
				<th class="col">Estado</th>
				<th class="col">Cliente asociado</th>
				<th class="col">Fecha Solicitud</th>
				<th class="col">Fecha Ultima Actualizacion</th>
				<th class="col">Acciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="odt" items="${odt}">
				<tr>
					<td><c:out value="${odt.id}"></c:out></td>
					<td><c:out value="${odt.electrodomestico_id.nombre}"></c:out></td>
					<td><c:out value="${odt.estado}"></c:out></td>
					<td><c:out value="${odt.electrodomestico_id.cliente_id.nombre}"></c:out></td>
					<td><c:out value="${odt.fechaSolicitud}"></c:out></td>
					<td><c:out value="${odt.fechaActualizacionOrden}"></c:out></td>
					<td>
						<a href="Controller?accion=editar&amp;id=${odt.id}">Modificar</a>
						<a href="Controller?accion=verODT&amp;id=${odt.id}">Ver ODT</a>
					</td>
				</tr>			
			</c:forEach>
		</tbody>
	</table>
	<a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-primary" role="button" data-bs-toggle="button">Volver</a>
</div>		
	
	<!-- Llama las funciones de sort de DataTable -->
	<%@ include file="includes/tablesorttrad.jsp" %>
</body>
</html>