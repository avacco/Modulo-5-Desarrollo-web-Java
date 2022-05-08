<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body class="bg-light">
<%@include file="includes/navbar.jsp" %>
<div class="my-3 p-3 bg-body rounded shadow-sm">
	<h1>Nueva orden</h1>
	<div class="container">
	
		<h2>Datos de electrodomestico</h2>
		<div class="col mb-6">
			<form method="POST" action="Controller?accion=addElectrodomestico">
			
			  <input type=hidden class="form-control" id="id" name="id" value="${cliente.id}">
			  		
			  <div class="mb-3">
			    <label class="form-label">Nombre Cliente</label>
			    <input type="text" class="form-control" id="nombre" name="nombre" disabled value="${cliente.nombre}">
			  </div>
			  <div class="mb-3">
			    <label class="form-label">Nombre producto</label>
			    <input type="text" class="form-control" id="nombreProducto" name="nombreProducto">
			  </div>
			  <div class="mb-3">
			    <label class="form-label">Detalle de la falla</label>
			    <input type="text" class="form-control" id="fallaProducto" name="fallaProducto">
			  </div>
			  <button type="submit" class="btn btn-primary">Agregar producto</button><br>
			 </form>
			  <form method="POST" action="Controller?accion=finalizar">
			  <input type="hidden" class="form-control" id="id" name="id" value="${cliente.id}">
			  <button type="submit" class="btn btn-danger">Finalizar</button>
			  <div class="form-text">Agregue al menos un producto antes de finalizar.</div>
			  <div class="form-text">Finalizar sin agregar ningun producto cancelará la orden.</div>
			</form>
		</div>
	</div>
</div>
</body>
</html>