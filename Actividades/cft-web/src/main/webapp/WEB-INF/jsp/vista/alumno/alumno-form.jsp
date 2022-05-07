<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Alumno</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container">
	<div class="row">
		<h1>Formulario Alumno</h1>
		
		<c:if test="${not empty validador }">
		<div style="background: red; color: yellow; padding: 15px; margin-bottom: 5px;">
			${validador.errores}
		</div>
		</c:if>
		
		<form method="POST" action="/cft-web/AlumnoController">
		<input type="hidden" name="id" value="${alumno.id}" />
			<div class="col mb-3">
				<label class="form-label">Nombre:</label>
				<input class="form-control" type="text" id="nombre" name="nombre" value="${alumno.nombre}"/>
			</div>
			<div class="col mb-3">
				<label class="form-label">Carrera:</label>
				<select class="form-select" name="carrera_id" id="carrera_id">
					<c:forEach var="carrera" items="${carreras}">
						<c:choose>
							<c:when test="${carrera.id == alumno.carrera.id}">
								<option selected="selected" value="${carrera.id}">${carrera.nombre}</option>						
							</c:when>
							<c:otherwise>
								<option value="${carrera.id}">${carrera.nombre}</option>						
							</c:otherwise>				
						</c:choose>
					</c:forEach>
				</select>
			</div>
			<div class="col mb-3">
				<label class="form-label">Fecha de Nacimiento:</label>
				<input class="form-control" type="date" id="nacimiento" name="nacimiento" value="${alumno.fechaNacimiento}" />
			</div>
			<button class="btn btn-primary" type="submit">Guardar alumno</button>
		</form>
	</div>
</div>
</body>
</html>