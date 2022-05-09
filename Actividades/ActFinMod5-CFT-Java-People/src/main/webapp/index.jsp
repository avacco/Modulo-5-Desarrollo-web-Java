<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!doctype html>
<html lang="es">
  <head>
    <meta charset="utf-8">
    <title>Indice</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/offcanvas-navbar/">

    <!-- Bootstrap core CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>    
    
  </head>
<body class="bg-light">
    <!--  incluye el navbar -->
<%@include file="/WEB-INF/jsp/vista/includes/navbar.jsp" %>

	<!-- alertas  -->
	<c:if test="${success == 2}">
	<div class="alert alert-success" role="alert">
	  POR IMPLEMENTAR.
	</div>
	</c:if>


	<c:if test="${success == 1}">
	<div class="alert alert-success" role="alert">
	  POR IMPLEMENTAR.
	</div>
	</c:if>
	
	<c:if test="${success == 0}">
	<div class="alert alert-danger" role="alert">
	  POR IMPLEMENTAR.
	</div>
	</c:if>


  <div class="my-3 p-3 bg-body rounded shadow-sm">
    <h4 class="border-bottom pb-2 mb-0">Listado de estudiantes</h4>
    <div class="d-flex text-muted pt-3">
      <svg class="bd-placeholder-img flex-shrink-0 me-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 32x32" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#007bff"/><text x="50%" y="50%" fill="#007bff" dy=".3em">32x32</text></svg>
      <div class="pb-3 mb-0 small lh-sm border-bottom w-100">
        <a href="CFTController?accion=listar"><b>Estudiantes</b></a>
      </div>
    </div>
  </div>

  <div class="my-3 p-3 bg-body rounded shadow-sm">
    <h4 class="border-bottom pb-2 mb-0">Registro de estudiantes</h4>
    <div class="d-flex text-muted pt-3">
      <svg class="bd-placeholder-img flex-shrink-0 me-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 32x32" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#6f42c1"/><text x="50%" y="50%" fill="#6f42c1" dy=".3em">32x32</text></svg>
      <div class="pb-3 mb-0 small lh-sm border-bottom w-100">
        <div class="d-flex justify-content-between">
          <a href="CFTController?accion=formulario"><b>Registrar nuevo estudiante</b></a>  
        </div>
      </div>
    </div>
  </div>
</main>
</body>
</html>
 