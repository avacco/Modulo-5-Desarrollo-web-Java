<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="ISO-8859-1">
    <title>Listado de Calificaciones</title>

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
	<h1>Listado de Calificaciones</h1>	
	<table id="sortTable" class="table table-striped">
		<thead>
			<tr>
				<th class="col">Nombre</th>
				<th class="col">Asignatura</th>
				<th class="col">Nota</th>
				<th class="col">Numero de evaluacion</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="calificaciones" items="${calificaciones}">
				<tr>
					<td><c:out value="${calificaciones.estudiante.nombre1} ${calificaciones.estudiante.nombre2} ${calificaciones.estudiante.apellidoPaterno} ${calificaciones.estudiante.apellidoMaterno}"></c:out></td>
					<td><c:out value="${calificaciones.asignatura.nombre}"></c:out></td>
					<td><c:out value="${calificaciones.nota}"></c:out></td>
					<td><c:out value="${calificaciones.numeroEvaluacion}"></c:out></td>
				</tr>			
			</c:forEach>
		</tbody>
	</table>
</div>		
<a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-primary" role="button" >Volver</a>
	
	<!-- Llama las funciones de sort de DataTable -->
	<%@ include file="includes/tablesorttrad.jsp" %>

</body>
</html>