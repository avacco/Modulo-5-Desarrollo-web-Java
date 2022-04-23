<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Circulo</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>    
<%@ include file="/WEB-INF/jsp/includes/header.jsp" %>
<body>
<div class="container">
	<!-- con "action='' envia el method al servlet de url correspondiente en web.xml" -->
	<form method="GET" action="CirculoControllerServlet">
	  <div class="mb-3">
	  	<h1>Calculo Circulo</h1>
		  	<select name="operacion" class="form-select" >
			  <option selected>Seleccione una operacion</option>
			  <option value="area">Calcular area</option>
			  <option value="perimetro">Calcular perimetro</option>
			</select>
	    <label for="exampleInputEmail1" class="form-label">Diametro</label>
	    <input type="text" class="form-control" id="idDiametro" name="diametro">
	  </div>
	  <button type="submit" class="btn btn-primary">Calcular area</button>
	</form>
</div>
</body>
</html>