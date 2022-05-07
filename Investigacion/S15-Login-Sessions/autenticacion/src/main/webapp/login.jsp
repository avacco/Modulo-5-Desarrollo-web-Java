<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/includes/menu.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Iniciar sesion</title>
</head>
<body>
	<h1>Ingreso</h1>
	
	<c:if test="${not empty errorSesion}">
		<div style="background: red; color: white; padding: 15px;">
		${errorSesion}
		</div>
	</c:if>
	
	<%-- Nunca utilizar method=GET cuando se trate con contraseñas --%>
	<form method="POST" action="${pageContext.request.contextPath}/autenticacion">
		Usuario <input type="text" name="usuario"/>
		Contraseña <input type="password" name="pass"/>
		<button type="submit">Ingresar</button>
		

	</form>
	
</body>
</html>