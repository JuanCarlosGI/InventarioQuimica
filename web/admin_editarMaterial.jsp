<%-- 
    Document   : admin_editarMaterial
    Created on : Nov 21, 2016, 2:06:50 PM
    Author     : Cesar
--%>

<%@page import="models.Material"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
            Material mat = (Material)request.getAttribute("material");
        %>
  <html>
    <head>
      <!--Import Google Icon Font-->
      <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

      <!--Import materialize.css-->
      <link type="text/css" rel="stylesheet" href="css/materialize.css"  media="screen,projection"/>

      <script type="text/javascript" src="js/agregarLaboratorio.js"></script>

      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
      <meta charset="UTF-8">
      <meta http-equiv="Content-type" content="text/html; charset=UTF-8">
    </head>

    <body>
      <!-- NAVBAR -->
      <!-- Dropdown Menu Structure -->
      <ul id="dropdown1" class="dropdown-content">
        <li><a href="admin_editarPerfil.jsp">Perfil</a></li>
        <li class="divider"></li>
        <li><a href="#!">Salir</a></li>
      </ul>

      <nav>
        <div class="nav-wrapper">
          <a href="./admin_login.jsp" class="brand-logo center">Almacén de Química</a>
          <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
          <ul class="right hide-on-med-and-down">
          <!-- Dropdown Trigger -->
          <li><a class="dropdown-button" href="#!" data-activates="dropdown1">USUARIO<i class="material-icons right">arrow_drop_down</i></a></li>
        </ul>
          <ul class="side-nav" id="mobile-demo">
            <li><a href="./admin_editarPerfil.jsp">Perfil</a></li>
            <li><a href="#">Salir</a></li>
          </ul>
        </div>
      </nav>
      <nav style="background-color: #ffa000">
    <div class="nav-wrapper center">
      <div class="col s12">
        <a href="./admin_login.jsp" class="breadcrumb">Inicio</a>
        <a href="./admin_editarMaterial.jsp" class="breadcrumb">Materiales</a>
        <a class="breadcrumb">Editar <%=mat.getNombre()%></a>
      </div>
    </div>
  </nav>
  <!-- NAVBAR END-->

  <body>
    <div class='section'></div>
    <div class='section'></div>

    <div class="row">
      <div class="container">


        <form action="modificarMaterial" method = "post">
          <div class="row">
            <div class="input-field col s6">
              <input disabled type="text" class="validate" id="clave" name="clave" value="<%=mat.getClave()%>"/>
              <label for="clave">Clave</label>
            </div>
            <div class="input-field col s6">
              <input required type="text" class="validate" id="nombre" name="nombre" value="<%=mat.getNombre()%>"/>
              <label for="nombre">Nombre</label>
            </div>
            <div class="input-field col s6">
              <input required  type="text" class="validate" id="marca" name="marca" value="<%=mat.getMarca()%>"/>
              <label for="marca">Marca</label>
            </div>
            <div class="input-field col s6">
              <input required type="text" class="validate" id="capacidad" name="capacidad" value="<%=mat.getCapacidad()%>"/>
              <label for="capacidad">Capacidad</label>
            </div>
            <div class="input-field col s6">
              <input required type="text" class="validate" id="cantidad" name="cantidad" value="<%=mat.getCantidad()%>"/>
              <label for="cantidad">Cantidad</label>
            </div>
            <div class="input-field col s6">
              <input required type="text" class="validate" id="localizacion" name="localizacion" value="<%=mat.getLocalizacion()%>"/>
              <label for="localizacion">Localizacion</label>
            </div>
            <div class="input-field col s6">
              <input required type="text" class="validate" id="descripcion" name="descripcion" value="<%=mat.getDescripcion()%>"/>
              <label for="descripcion">Descripción</label>
            </div>
          </div>

          <div class='section'>
            <div class="row center">
            <button class="btn waves-effect waves-light" type="submit" name="action">Guardar Cambios
              <i class="material-icons right">send</i>
            </button>
            </div>
          </div>
        </form>
      </div>
    </div>

    <!--Import jQuery before materialize.js-->
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="js/materialize.js"></script>
  </body>
</html>