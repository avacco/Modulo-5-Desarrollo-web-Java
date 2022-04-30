1. Descargar e instalar Tomcat 10 (https://tomcat.apache.org/download-10.cgi)
2. Descargar driver JDBC de PostgreSQL (https://jdbc.postgresql.org)
3. Colocar .JAR en la carpeta lib de Tomcat
4. Editar archivo de configuracion de Tomcat en eclipse llamado context.xml. Agregar la etiqueta Resource con los datos de conexion.
5. Crear proyecto java web
6. Agregar los 2 .JAR para soporte de JSTL
7. Editar web.xml para referenciar la piscina de conexiones.
8. Crear JSP para consultar tablas.
9. Crear formulario con campos nombre y carrera. El formulario debe enviar los datos por POST.
10. Crear Servlet para procesar los datos del formulario.
11. Insertar los datos a la tabla.
12. Redirigir a pagina que muestra todos los datos de la tabla.
