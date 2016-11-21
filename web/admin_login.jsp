<%-- 
    Document   : admin_login
    Created on : 20-nov-2016, 13:08:36
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

      <script>
        function validate() {
          var check = prompt("¿Estás seguro? \n Escribe 'borrar alumnos del semestre'");
          
          if (check == "borrar alumnos del semestre") {
              alert("boom");
          }
          else {
            alert("No se borro información");
          }
        }
      </script>
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
        <li><a href="admin_editarPerfil.jsp">Perfil</a></li>
        <li class="divider"></li>
        <li><a href="#!">Salir</a></li>
      </ul>

      <nav>
        <div class="nav-wrapper">
          <a href="#" class="brand-logo center">Almacén de Química</a>
          <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
          <ul class="right hide-on-med-and-down">
          <!-- Dropdown Trigger -->
          <li><a class="dropdown-button" href="#!" data-activates="dropdown1">USUARIO<i class="material-icons right">arrow_drop_down</i></a></li>
        </ul>
          <ul class="side-nav" id="mobile-demo">
            <li><a href="#">Perfil</a></li>
            <li><a href="#">Salir</a></li>
          </ul>
        </div>
      </nav>

      <!-- NAVBAR END-->
      <!-- <div class="row"></div>
      <div class="row">
        <div class="col s1"><a href="#">Inicio</a></div>-->

      <!-- ALERTAS DE INVENTARIO-->
      <!--
        <div class="row">
          <div class="col s12">
            <div class="card red darken-4">
              <div class="card-content white-text">
                <span class="card-title">Aviso</span>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce turpis.</p>
              </div>
              <div class="card-action">
                <a href="#">Actualizar Inventario</a>
              </div>
            </div>
          </div>
        -->
      <!-- ALERTAS DE INVENTARIO END-->
      <div class="section">
        <div class="row">
          <div class="col s12">
            <div class="card blue">
              <div class="card-content white-text">
                <span class="card-title">Bienvenido ${usuario.nombre}</span>
                <p>Vales atrasados: 1</p>
                <p>Vales activos: 3</p>
                <p>Total de vales del semestre: 20</p>
              </div>
            </div>
          </div>
        

        <div class="row">
          <div class="col s12 m6 l4">
            <h5 class="center"><i class="material-icons">assignment_ind</i> Usuarios</h5>
            <div class="section center">
              <a href="addAdministrador" class="waves-effect waves-light btn-large" style="width: 80%; background-color: #00bcd4">Editar Alumnos</a><br><br>
              <a href="admin_editarProfesores.jsp" class="waves-effect waves-light btn-large" style="width: 80%; background-color: #00bcd4">Editar Maestros</a><br><br>
              <a href="admin_editarAdministradores.jsp" class="waves-effect waves-light btn-large" style="width: 80%; background-color: #00bcd4">Editar Administradores</a><br><br>
              <a href="addLaboratorio" class="waves-effect waves-light btn-large" style="width: 80%; background-color: #00bcd4">Editar Laboratorios</a>
            </div>
          </div>
          <div class="col s12 m6 l4">
            <h5 class="center"><i class="material-icons">view_list</i> Inventario</h5>
            <div class="section center">
              <a href="admin_materiales.jsp" class="waves-effect waves-light btn-large" style="width: 80%; background-color: #ffa000">Materiales</a><br><br>
              <a href="admin_equipos.jsp" class="waves-effect waves-light btn-large" style="width: 80%; background-color: #ffa000">Equipos</a><br><br>
              <a href="admin_reactivos.jsp" class="waves-effect waves-light btn-large" style="width: 80%; background-color: #ffa000">Reactivos</a><br><br>
              <a href="addConsumible" class="waves-effect waves-light btn-large" style="width: 80%; background-color: #ffa000">Consumibles</a>
            </div>
          </div>
          <div class="col s12 m6 l4">
            <h5 class="center"><i class="material-icons">description</i> Vales</h5>
            <div class="section center">
              <a href="#" class="waves-effect waves-light btn-large" style="width: 80%; background-color: #3f51b5">Entregar productos</a><br><br>
              <a href="admin_listaVales.jsp" class="waves-effect waves-light btn-large" style="width: 80%; background-color: #3f51b5">Lista de Vales</a><br><br>
              <a href="#" class="waves-effect waves-light btn-large" style="width: 80%; background-color: #3f51b5">Crear Vale</a><br><br>
              <a href="#" class="waves-effect waves-light btn-large" style="width: 80%; background-color: #3f51b5">Detalle Vale</a>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col s12">
          <div class="section center">
            <a onclick="validate()" class="waves-effect waves-light btn-large red" style="width: 80%">Borrar alumnos del Semestre</a><br><br>
            </div>
          </div>
        </div>
      </div>


      <!--Import jQuery before materialize.js-->
      <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
      <script type="text/javascript" src="js/materialize.js"></script>
    </body>
  </html>
