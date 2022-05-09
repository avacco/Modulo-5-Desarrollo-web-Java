<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="ISO-8859-1">
    <title>Lista de alumnos</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/offcanvas-navbar/">

	<!-- Incluye facilitador de Table Sort -->
	<%@ include file="includes/tablesort.jsp" %>	
    <!-- Bootstrap core CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>    
    
  </head>
<body class="bg-light">
    <!--  incluye el navbar -->
<%@include file="includes/navbar.jsp" %>


<div class="my-3 p-3 bg-body rounded shadow-sm">
	<h1>Estudiantes</h1>	
	<table id="sortTable" class="table table-striped">
		<thead>
			<tr>
				<th class="col">ID</th>
				<th class="col">RUT</th>
				<th class="col">Nombre</th>
				<th class="col">Genero</th>
				<th class="col">Fono</th>
				<th class="col">Curso</th>
				<th class="col">Acciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="estudiantes" items="${estudiantes}">
				<tr>
					<td><c:out value="${estudiantes.id}"></c:out></td>
					<td><c:out value="${estudiantes.rut}-${estudiantes.dv}"></c:out></td>
					<td><c:out value="${estudiantes.nombre1} ${estudiantes.nombre2} ${estudiantes.apellidoPaterno} ${estudiantes.apellidoMaterno}"></c:out></td>
					<td><c:out value="${estudiantes.genero}"></c:out></td>
					<td><c:out value="${estudiantes.fono}"></c:out></td>
					<td><c:out value="${estudiantes.curso}"></c:out></td>
					<td>
						<a href="CFTController?accion=consultar&amp;id=${estudiantes.id}">Consultar</a>
						<a href="CFTController?accion=addNota&amp;id=${estudiantes.id}">Agregar nota</a>
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