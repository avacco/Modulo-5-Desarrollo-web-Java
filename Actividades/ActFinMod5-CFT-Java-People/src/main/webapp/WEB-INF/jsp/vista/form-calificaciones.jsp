<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!doctype html>
<html lang="es">
  <head>
    <meta charset="utf-8">
	<title>Calificaciones</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body class="bg-light">

<%@include file="includes/navbar.jsp" %>


<div class="my-3 p-3 bg-body rounded shadow-sm">
	<h1>Calificaciones</h1>
	<div class="container">
	
		<h2>Agregar calificaciones</h2>
		<div class="col-mb-6">
			<form method="POST" action="CFTController?accion=addNota">
			  <div class="mb-3">
			    <label class="form-label">Estudiante</label>
			    <input type="hidden" name="idEstudiante" value="${estudiante.id}">
			    <input disabled type="text" class="form-control" id="nombre" name="nombre" value="${estudiante.nombre1} ${estudiante.apellidoPaterno}">
			  </div>
			  <div class="mb-3">
			    <label class="form-label">Curso</label>
			    <input disabled type="text" class="form-control" id="curso" name="curso" value="${estudiante.curso}">
			  </div>
			  <div class="mb-3">
			    <label class="form-label">Asignatura</label>
			    <select class="form-select" name="asignatura" id="asignatura">
			    	<option selected="selected" value="none">Elija una asignatura</option>
					<c:forEach var="asignaturas" items="${asignaturas}">					
						<option value="${asignaturas.id_asignatura}">${asignaturas.nombre}</option>						
					</c:forEach>
			    </select>
			  </div>
			  <div class="col-sm-1 mb-3">
			    <label class="form-label">Nota</label>
			    <input type="text" class="form-control" id="nota" name="nota" placeholder="7.0">
			  </div>
			  <button type="submit" class="btn btn-success">Registrar</button> 
			  <a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-primary" role="button" data-bs-toggle="button">Volver</a>
			</form>

		</div>
	</div>
</div>
</body>
</html>