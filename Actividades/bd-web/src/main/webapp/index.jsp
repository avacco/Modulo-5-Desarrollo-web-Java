<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Acceso a BD</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<%-- Toma el dataSource de web.xml, en resource ref name --%>
	
	<h1>Alumnos</h1>
	<sql:query var="rs" dataSource="jdbc/postgres">
		SELECT * FROM alumnos
	</sql:query>

	<ol>
	<c:forEach var="alumno" items="${rs.rows}">
		<li>${alumno.nombre} | ${alumno.carrera }</li>
	</c:forEach>
	</ol>

	<h1>Profesores</h1>
	<sql:query var="rs" dataSource="jdbc/postgres">
		SELECT * FROM profesores
	</sql:query>

	<ol>
	<c:forEach var="profesor" items="${rs.rows}">
		<li>${profesor.nombre} | ${profesor.rut}</li>
	</c:forEach>
	</ol>

</body>
</html>