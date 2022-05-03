<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Carrera</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container">
	<div class="row">
		<h1>Formulario Carrera</h1>
		<form method="POST" action="/cft-web/CarreraController">
		<input type="hidden" name="id" value="${carrera.id}" />
			<div class="col mb-3">
				<label class="form-label">Nombre carrera:</label>
				<input class="form-control" type="text" id="nombre" name="nombre" value="${carrera.nombre}"/>
			</div>
			<button class="btn btn-primary" type="submit">Guardar carrera</button>
		</form>
	</div>
</div>

</body>
</html>