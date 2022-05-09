<nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">Java People</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/index.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="Controller?accion=listar">Listado estudiantes</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="Controller?accion=formulario">Registrar estudiante</a>
        </li>
      </ul>
    </div>
  </div>
</nav>

<main class="container">
  <div class="d-flex align-items-center p-3 my-3 bg-purple rounded shadow-sm">
    <img class="me-3" src="img/ico.png" alt="" width="80" height="120">
    <div class="lh-1">
      <h1 class="h1 mb-0 lh-1">Java People</h1>
    </div>
  </div>