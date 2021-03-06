<%-- 
    Document   : admin_editarReactivo
    Created on : Nov 21, 2016, 2:07:08 PM
    Author     : Cesar
--%>

<%@page import="models.Reactivo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
            Reactivo rea = (Reactivo)request.getAttribute("reactivo");
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
        <li><a href="./admin_editarPerfil.jsp">Perfil</a></li>
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
<<<<<<< HEAD
        <a href="#!" class="breadcrumb">Inicio</a>
        <a href="#!" class="breadcrumb">Reactivos</a>
        <a href="#!" class="breadcrumb">Editar <%=rea.getNombre()%></a>
=======
        <a href="./admin_login.jsp" class="breadcrumb">Inicio</a>
        <a href="./admin_editarMaterial.jsp" class="breadcrumb">Materiales</a>
        <a class="breadcrumb">Editar <%=rea.getNombre()%></a>
>>>>>>> 8a91d0094c641ff515f391744b58ee6c2697b14e
      </div>
    </div>
  </nav>
  <!-- NAVBAR END-->

  <body>
    <div class='section'></div>
    <div class='section'></div>

    <div class="row">
      <div class="container">

        <form action="modificarReactivo" method="post">
          <div class="row">
            <div class="input-field col s6">
              <input required type="text" class="validate" id="clave" name="clave" value="<%=rea.getClave()%>"/>
              <label for="clave">Clave</label>
            </div>
            <div class="input-field col s6">
              <input required type="text" class="validate" id="nombre" name="nombre" value="<%=rea.getNombre()%>"/>
              <label for="nombre">Nombre</label>
            </div>
            <div class="input-field col s6">
              <input required type="text" class="validate" id="marca" name="marca" value="<%=rea.getMarca()%>"/>
              <label for="marca">Marca</label>
            </div>
            <div class="input-field col s6">
              <input required type="text" class="validate" id="cantidad" name="cantidad" value="<%=rea.getCantidad()%>"/>
              <label for="cantidad">Cantidad</label>
            </div>
            <div class="input-field col s6">
              <input required type="text" class="validate" id="presentacion" name="presentacion" value="<%=rea.getPresentacion()%>"/>
              <label for="presentacion">Presentación</label>
            </div>
            <div class="input-field col s6">
              <input required type="text" class="validate" id="contenido" name="contenido" value="<%=rea.getContenido()%>"/>
              <label for="contenido">Contenido</label>
            </div>
            <div class="input-field col s6">
              <input required type="text" class="validate" id="localizacion" name="localizacion" value="<%=rea.getLocalizacion()%>"/>
              <label for="localizacion">Localización</label>
            </div>
            <div class="input-field col s6">
              <input required type="text" class="validate" id="descripcion" name="descripcion" value="<%=rea.getDescripcion()%>"/>
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