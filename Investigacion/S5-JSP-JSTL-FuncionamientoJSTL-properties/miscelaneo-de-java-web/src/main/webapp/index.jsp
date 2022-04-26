<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<!-- Codifica una url  -->
	<h2>Generar URL</h2>
	<c:url value="/miscelaneo-de-java-web/index.jsp">
		<c:param name="nombre" value="Andres"></c:param>
		<c:param name="activo" value="true"></c:param>
	</c:url>
	
	<!-- Utiliza [param.name} para obtener un valor de un parametro name dado  -->		
	<h2>Output</h2>
	<c:out value="${param.nombre}" default="Sin nombre"></c:out> <br/> <!--	Previene ataques XSS -->
	${param.nombre} <br/> <!-- Por si solo es vulnerable -->
	${fn:escapeXml(param.nombre)} <br/> <!-- Otro metodo para proteger el codigo -->

	<!--  -->
	<h2>Condicionales</h2>
	<c:if test="${param.activo == 'true' }">
		<p>El usuario esta activo</p>
	</c:if>
	
	<h2>Bucle forTokens</h2>
	<c:forTokens items="uno,dos,tres,cuatro" delims="," var="numero">
		<li>${fn:escapeXml(numero)}</li>
	</c:forTokens>
	
	<h2>Bucle forEach</h2>
	<c:forEach items="${paramValues}" var="parametro">
		<li>${parametro.key}</li>
	</c:forEach>
	
	<!-- trae datos de un sitio-->
	<h2>Import</h2>
		<p>Comentado por conveniencia</p>
<%--	<textarea rows="10" cols="20">
 	<c:import url="https://mindicador.cl/api"></c:import>   --%>
	</textarea>
	
	
	
	<h2>Formato de fechas</h2>
	<%-- Utiliza un scriptlet para ejecutar codigo java  --%>
	<c:set var="ahora" value="<%=new java.util.Date() %>"/> 
	<fmt:formatDate value="${ahora}" pattern="yyyy-MM-dd"/><br/>
	<fmt:formatDate value="${ahora}" type="date"/><br/>
	<fmt:formatDate value="${ahora}" type="time"/><br/>
	<fmt:formatDate value="${ahora}" type="both"/>

	<h2>Internacionalizacion (i18n)</h2>
	Pasos:
	<ol>
		<li>Crear archivo messages.properties en la carpeta src/main/java</li>
		<li>Crear archivo messages_en.properties en la carpeta src/main/java</li>
		<li>Crear archivo messages_es.properties en la carpeta src/main/java</li>
		<li>Definir label.saludo en cada uno con un valor distinto</li>
		<li>Definir label.stock en el primer properties con una llave de parametro</li>
	</ol>
	<%-- setea el valor "locale" --%>
	<fmt:setLocale value="es"/>
	<%-- messages es el nombre del archivo properties, tomara el español o ingles dependiendo del locale definido antes --%>
	<fmt:setBundle basename="messages"/>
	<%-- busca en el archivo la propiedad correspondiente --%>
	<fmt:message key="label.saludo"/> <br/>
	<%-- define parametros en archivos .properties. si no encuentra una propiedad en el archivo del locale correspondiente, buscara en el default --%>
	<fmt:message key="label.stock"> 
		<fmt:param>50</fmt:param>
	</fmt:message>
	
	<form method="GET" action="AlumnosController">
	  <button type="submit" class="btn btn-primary">Clickeame</button>
	</form>
	
	
	
</body>
</html>