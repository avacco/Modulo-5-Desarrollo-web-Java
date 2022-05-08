<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body class="bg-light">
<%@include file="includes/navbar.jsp" %>
<div class="my-3 p-3 bg-body rounded shadow-sm">
	<h1>Nueva orden</h1>
	<div class="container">
	
		<h2>Datos de cliente</h2>
		<div class="col mb-6">
			<form method="POST" action="Controller?accion=addCliente">
			  <div class="mb-3">
			    <label class="form-label">Nombre</label>
			    <input type="text" class="form-control" id="nombre" name="nombre">
			  </div>
			  <div class="mb-3">
			    <label class="form-label">Telefono</label>
			    <input type="text" class="form-control" id="telefono" name="telefono">
			  </div>
			  <div class="mb-3">
			    <label class="form-label">Direcci�n</label>
			    <input type="text" class="form-control" id="direccion" name="direccion">
			  </div>
			  <button type="submit" class="btn btn-primary">Pasar a productos</button> 
			  <a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-primary" role="button" data-bs-toggle="button">Volver</a>
			</form>

		</div>
	</div>
</div>
</body>
</html>