<%-- 
    Document   : admin_reactivos
    Created on : Nov 20, 2016, 6:52:13 PM
    Author     : Cesar
--%>

<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="data.Context" %>
<%@ page import="models.Reactivo" %>
<%@ page import="models.Usuario" %>
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
      <!-- NAVBAR -->
      <!-- Dropdown Menu Structure -->
      <ul id="dropdown1" class="dropdown-content">
        <li><a href="#!">Perfil</a></li>
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
      <nav style="background-color: #ffa000">
    <div class="nav-wrapper center">
      <div class="col s12">
        <a href="#!" class="breadcrumb">Inicio</a>
        <a href="#!" class="breadcrumb">Reactivos</a>
      </div>
    </div>
  </nav>
  <!-- NAVBAR END-->

  
    <div class="section"></div>

    <div class="row">
      <div class="col s2 m3 l4"></div>
      <div class="card col s8 m6 l4">
        <div class="card-content center">
          <span class="card-title activator grey-text text-darken-4">AGREGAR REACTIVO</span>
        </div>
        <div class="card-reveal center">
            <input placeholder="Nombre del reactivo" type="text" class="validate" id="matricula" name="matricula"/>
        </div>
      </div>
    </div>

    <table class="responsive-table striped" style="width: 100%">
        <thead>
          <tr>
              <th data-field="nombre">Nombre</th>
              <th data-field="marca">Marca</th>
              <th data-field="cantidad">Cantidad</th>
              <th data-field="marca">Localización</th>
              <th data-field="marca">Presentación</th>
              <th data-field="marca">Contenido</th>
              <th data-field="modificar">Modificar</th>
              <th data-field="eliminar">Eliminar</th>
          </tr>
        </thead>

        <tbody>
            <%
            LinkedList<Reactivo> reactivos= (LinkedList<Reactivo>)request.getAttribute("reactivos");
            for(int i = 0; i < reactivos.size(); i+=1){

             %>
          <tr>
            <td><%=reactivos.get(i).getNombre()%></td>
            <td><%=reactivos.get(i).getMarca()%></td>
            <td><%=reactivos.get(i).getCantidad()%></td>
            <td><%=reactivos.get(i).getLocalizacion()%></td>
            <td><%=reactivos.get(i).getPresentacion()%></td>
            <td><%=reactivos.get(i).getContenido()%></td>
            <td>
                <a href="modificarReactivo?clave=<%=reactivos.get(i).getClave()%>&action=modificar"><button class="btn waves-effect waves-light" name="action"><i class="material-icons center">mode_edit</i></button></a>
            </td>
            <td>
                <a href="modificarReactivo?clave=<%=reactivos.get(i).getClave()%>&action=borrar"><button class="btn waves-effect waves-light red" name="action"><i class="material-icons center">delete</i></button></a>
            </td>
          </tr>
          <%
            }
            %>
        </tbody>
      </table>

    <!--Import jQuery before materialize.js-->
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="js/materialize.js"></script>
  </body>
</html>