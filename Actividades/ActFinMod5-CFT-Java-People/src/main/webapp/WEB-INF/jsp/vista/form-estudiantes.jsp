<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!doctype html>
<html lang="es">
  <head>
    <meta charset="utf-8">
	<title>Registro de estudiante</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body class="bg-light">

<%@include file="includes/navbar.jsp" %>

<!-- alertas  -->
	<c:if test="${success == 0}">
	<div class="alert alert-danger" role="alert">
	  Seleccione su genero.
	</div>
	</c:if>
	
	<c:if test="${success == 0}">
	<div class="alert alert-danger" role="alert">
	  Elija el curso.
	</div>
	</c:if>

<div class="my-3 p-3 bg-body rounded shadow-sm">
	<h1>Registro de estudiante</h1>
	<div class="container">
	
		<h2>Datos del estudiante</h2>
		<div class="col-mb-6">
			<form method="POST" action="Controller?accion=addEstudiante">
			  <div class="mb-3">
			    <label class="form-label">Primer Nombre</label>
			    <input required type="text" class="form-control" id="nombre1" name="nombre1">
			  </div>
			  <div class="mb-3">
			    <label class="form-label">Segundo Nombre</label>
			    <input required type="text" class="form-control" id="nombre2" name="nombre2">
			  </div>
			  <div class="mb-3">
			    <label class="form-label">Apellido Paterno</label>
			    <input required type="text" class="form-control" id="apellidoPaterno" name="apellidoPaterno">
			  </div>
			  <div class="mb-3">
			    <label class="form-label">Apellido Materno</label>
			    <input required type="text" class="form-control" id="apellidoMaterno" name="apellidoMaterno">
			  </div>
			  <div class="mb-3">
			    <label class="form-label">Genero</label>
			    <select class="form-select" name="curso" id="curso">
			    	<option selected="selected" value="none">Seleccione su genero</option>
			    	<option value="Masculino">Masculino</option>
			    	<option value="Femenino">Femenino</option>
			    	<option value="No binario">No binario</option>
			    	<option value="Otro">Otro</option>
			    </select>
			  </div>
			  <div class="mb-3">
			    <label class="form-label">Fono contacto</label>
			    <input required type="text" class="form-control" id="fono" name="fono">
			  </div>
			  <div class="mb-3">
			    <label class="form-label">Curso</label>
			    <select class="form-select" name="curso" id="curso">
			    	<option selected="selected" value="none">Elija un curso</option>
					<c:forEach var="asignaturas" items="${asignaturas}">					
						<option value="${asignaturas.id_asignatura}">${asignaturas.nombre}</option>						
					</c:forEach>
			    </select>
			  </div>
			  <button type="submit" class="btn btn-success">Registrar</button> 
			  <a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-primary" role="button" data-bs-toggle="button">Volver</a>
			</form>
		</div>
	</div>
</div>
</body>
</html>