<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Formulario editar orden</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body class="bg-light">
<%@include file="includes/navbar.jsp" %>
<div class="my-3 p-3 bg-body rounded shadow-sm">
	<h1>Editar Orden de Trabajo</h1>
	<div class="container">
	
		<div class="col mb-6">
			<form method="POST" action="Controller?accion=finalizarEdit">
			<!-- toma los id, pero estos no seran editables, ni siquiera visibles, se utilizaran para los edit mas tarde en el servlet  -->
			  <input type=hidden class="form-control" id="idOdt" name="idOdt" value="${odt.id}">
			  <input type=hidden class="form-control" id="idCliente" name="idCliente" value="${odt.electrodomestico_id.cliente_id.id}">
			  <input type=hidden class="form-control" id="idElectrodomestico" name="idElectrodomestico" value="${odt.electrodomestico_id.id}">
			  
			  <h3>Detalles del producto</h3>
			  <div class="mb-3">
			    <label class="form-label">Nombre del producto: </label>
			    <input type="text" class="form-control" id="nombreProducto" name="nombreProducto" value="${odt.electrodomestico_id.nombre}">
			  </div>
			  <div class="mb-3">
			    <label class="form-label">Falla del producto</label>
			    <input type="text" class="form-control" id="fallaProducto" name="fallaProducto" value="${odt.electrodomestico_id.falla}">
			  </div>
			  <div class="mb-3">
			    <label class="form-label">Estado de la orden</label>
			    <select class="form-select" name="estadoOrden" id="estadoOrden">
		    		<c:choose>
						<c:when test="${odt.estado eq 'Pendiente'}">
							<option selected="selected" value="Pendiente">Pendiente</option>
							<option value="En reparacion">En reparacion</option>
							<option value="Reparado">Reparado</option>
							<option value="Orden cerrada">Orden cerrada</option>
							<option value="Sin arreglo">Sin arreglo</option>
						</c:when>
						<c:when test="${odt.estado eq 'En reparacion'}">
							<option value="Pendiente">Pendiente</option>
							<option selected="selected" value="En reparacion">En reparacion</option>
							<option value="Reparado">Reparado</option>
							<option value="Orden cerrada">Orden cerrada</option>
							<option value="Sin arreglo">Sin arreglo</option>
						</c:when>
						<c:when test="${odt.estado eq 'Reparado'}">
							<option value="Pendiente">Pendiente</option>
							<option value="En reparacion">En reparacion</option>
							<option selected="selected" value="Reparado">Reparado</option>
							<option value="Orden cerrada">Orden cerrada</option>
							<option value="Sin arreglo">Sin arreglo</option>
						</c:when>
						<c:when test="${odt.estado eq 'Orden cerrada'}">
							<option value="Pendiente">Pendiente</option>
							<option value="En reparacion">En reparacion</option>
							<option value="Reparado">Reparado</option>
							<option selected="selected" value="Orden cerrada">Orden cerrada</option>
							<option value="Sin arreglo">Sin arreglo</option>
						</c:when>
						<c:otherwise>
							<option value="Pendiente">Pendiente</option>
							<option value="En reparacion">En reparacion</option>
							<option value="Reparado">Reparado</option>
							<option value="Orden cerrada">Orden cerrada</option>
							<option selected="selected" value="Sin arreglo">Sin arreglo</option>						
						</c:otherwise>				
					</c:choose>
			    </select>
			  </div>
			  
			  <h3>Detalles del cliente</h3>
			  <div class="form-text">Cambiar los datos del cliente reflejará el cambio en todas las ordenes de trabajo asociadas al mismo.</div>
			  <div class="mb-3">
			    <label class="form-label">Nombre del cliente</label>
			    <input type="text" class="form-control" id="nombreCliente" name="nombreCliente" value="${odt.electrodomestico_id.cliente_id.nombre}">
			  </div>
			  <div class="mb-3">
			    <label class="form-label">Telefono del cliente</label>
			    <input type="text" class="form-control" id="telefonoCliente" name="telefonoCliente" value="${odt.electrodomestico_id.cliente_id.telefono}">
			  </div>
			  <div class="mb-3">
			    <label class="form-label">Direccion del cliente</label>
			    <input type="text" class="form-control" id="direccionCliente" name="direccionCliente" value="${odt.electrodomestico_id.cliente_id.direccion}">
			  </div>
			  
			  <button type="submit" class="btn btn-success">Finalizar edicion</button> 
			  <a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-primary" role="button" data-bs-toggle="button">Volver</a>
			</form>

		</div>
	</div>
</div>

</body>
</html>