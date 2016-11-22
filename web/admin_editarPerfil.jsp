<%-- 
    Document   : admin_editarPerfil
    Created on : 20-nov-2016, 18:58:22
    Author     : armando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
  <html>
    <head>
      <!--Import Google Icon Font-->
      <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

      <!--Import materialize.css-->
      <link type="text/css" rel="stylesheet" href="css/materialize.css"  media="screen,projection"/>

      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
      <meta charset="UTF-8">
      <meta http-equiv="Content-type" content="text/html; charset=UTF-8">
    </head>

    <body>
        <%@ page import="models.Usuario" %>
        <%@ page import="data.Context" %>
        <%@ page import="java.util.LinkedList"%>
        <jsp:useBean id = "usuario" class="models.Usuario" scope = "session"/>
        <% 
            LinkedList<Usuario> usuarios = new LinkedList<>();
            usuarios = Context.getUsuarios();    
        %>
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
          <li><a class="dropdown-button" href="#!" data-activates="dropdown1">${usuario.nombre}<i class="material-icons right">arrow_drop_down</i></a></li>
        </ul>
          <ul class="side-nav" id="mobile-demo">
            <li><a href="./admin_editarPerfil.jsp">Perfil</a></li>
            <li><a href="#">Salir</a></li>
          </ul>
        </div>
      </nav>
      <nav>
    <div class="nav-wrapper center">
      <div class="col s12">
        <a href="./admin_login.jsp" class="breadcrumb">Inicio</a>
        <a class="breadcrumb">Perfil</a>
      </div>
    </div>
  </nav>
  <!-- NAVBAR END-->

  <body>
    <div class="container">
    <div class='section'></div>

    <div class='section'></div>

      <form action="editAdministrador" method="post">
        <div class="row">
          <div class="input-field col s6">
            <input disabled placeholder=${usuario.matricula} type="text" class="validate" id="matricula" name="matricula" value="${usuario.matricula}" />
            <label for="matricula">Matricula/Nómina</label>
          </div>
          <div class="input-field col s6">
            <input required placeholder="David" type="text" class="validate" id="nombre" name="nombre"/>
            <label for="nombre">Nombre</label>
          </div>
          <div class="input-field col s6">
            <input required placeholder="A00000000@itesm.mx" type="email" class="validate" id="email" name="email"/>
            <label for="email">Correo</label>
          </div>
          <div class="input-field col s6">
            <input required placeholder="A00000000" type="password" class="validate" id="password" name="password"/>
            <label for="password">Contrasena</label>
          </div>
          <div class="input-field col s6">
            <input required placeholder="A00000000" type="password" class="validate" id="password_confirm" name="password_confirm"/>
            <label for="password_confirm">Confirmar Contrasena</label>
          </div>
        </div><br>


        <div class='section'>
          <div class="row center">
          <button class="btn waves-effect waves-light" type="submit" name="action">Guardar cambios
            <i class="material-icons right">send</i>
          </button>
          </div>
        </div>
      </form>
    </div>

    <!--Import jQuery before materialize.js-->
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="js/materialize.js"></script>
  </body>
</html>
