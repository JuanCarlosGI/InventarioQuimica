<%-- 
    Document   : admin_consumibles
    Created on : Nov 20, 2016, 7:00:45 PM
    Author     : Cesar
--%>

<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="data.Context" %>
<%@ page import="models.Consumible" %>
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
        <li><a href="admin_editarPerfil.jsp">Perfil</a></li>
        <li class="divider"></li>
        <li><a href="#!">Salir</a></li>
      </ul>

      <nav>
        <div class="nav-wrapper">
          <a href="admin_login.jsp" class="brand-logo center">Almacén de Química</a>
          <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
          <ul class="right hide-on-med-and-down">
          <!-- Dropdown Trigger -->
          <li><a class="dropdown-button" href="#!" data-activates="dropdown1">USUARIO<i class="material-icons right">arrow_drop_down</i></a></li>
        </ul>
          <ul class="side-nav" id="mobile-demo">
            <li><a href="admin_editarPerfil.jsp">Perfil</a></li>
            <li><a href="#">Salir</a></li>
          </ul>
        </div>
      </nav>
      <nav style="background-color: #ffa000">
    <div class="nav-wrapper center">
      <div class="col s12">
        <a href="./admin_login.jsp" class="breadcrumb">Inicio</a>
        <a href="#!" class="breadcrumb">Consumibles</a>
      </div>
    </div>
  </nav>
  <!-- NAVBAR END-->

  <body>
    <div class="section"></div>

    <div class="row">
      <div class="container">

        <form action="addConsumible" method="post">
          <div class="row">
            <div class="input-field col s6">
              <input required type="text" class="validate" id="clave" name="clave"/>
              <label for="clave">Clave</label>
            </div>
            <div class="input-field col s6">
              <input required type="text" class="validate" id="nombre" name="nombre"/>
              <label for="nombre">Nombre</label>
            </div>
            <div class="input-field col s6">
              <input required type="text" class="validate" id="marca" name="marca"/>
              <label for="marca">Marca</label>
            </div>
            <div class="input-field col s6">
              <input required type="text" class="validate" id="cantidad" name="cantidad"/>
              <label for="cantidad">Cantidad</label>
            </div>
            <div class="input-field col s6">
              <input required type="text" class="validate" id="presentacion" name="presentacion"/>
              <label for="presentacion">Presentación</label>
            </div>
            <div class="input-field col s6">
              <input required type="text" class="validate" id="contenido" name="contenido"/>
              <label for="contenido">Contenido</label>
            </div>
            <div class="input-field col s6">
              <input required type="text" class="validate" id="localizacion" name="localizacion"/>
              <label for="localizacion">Localización</label>
            </div>
            <div class="input-field col s6">
              <input required type="text" class="validate" id="descripcion" name="descripcion"/>
              <label for="descripcion">Descripcion</label>
            </div>
          </div>
          <div class='section'>
            <div class="row center">
            <button class="btn waves-effect waves-light" type="submit" name="action">Agregar Consumible
              <i class="material-icons right">send</i>
            </button>
            </div>
          </div>
        </form>
      </div>
    </div>
    <table class="responsive-table striped" style="width: 100%">
        <thead>
          <tr>
              <th data-field="clave">Clave</th>
              <th data-field="nombre">Nombre</th>
              <th data-field="marca">Marca</th>
              <th data-field="cantidad">Cantidad</th>
              <th data-field="marca">Localización</th>
              <th data-field="marca">Presentación</th>
              <th data-field="marca">Contenido</th>
              <th data-field="descripcion">Descripción</th>
              <th data-field="modificar">Modificar</th>
              <th data-field="eliminar">Eliminar</th>
          </tr>
        </thead>

        <tbody>
            <%
            LinkedList<Consumible> consumibles= (LinkedList<Consumible>)request.getAttribute("consumibles");
            for(int i = 0; i < consumibles.size(); i+=1){

             %>
          <tr>
            <td><%=consumibles.get(i).getClave()%></td>
            <td><%=consumibles.get(i).getNombre()%></td>
            <td><%=consumibles.get(i).getMarca()%></td>
            <td><%=consumibles.get(i).getCantidad()%></td>
            <td><%=consumibles.get(i).getLocalizacion()%></td>
            <td><%=consumibles.get(i).getPresentacion()%></td>
            <td><%=consumibles.get(i).getContenido()%></td>
            <td><%=consumibles.get(i).getDescripcion()%></td>
            <td>
                <a href="modificarConsumible?clave=<%=consumibles.get(i).getClave()%>&action=modificar"><button class="btn waves-effect waves-light" name="action"><i class="material-icons center">mode_edit</i></button><a href="modificarConsumible?clave=<%=consumibles.get(i).getClave()%>&action=modificar">
            </td>
            <td>
                <a href="modificarConsumible?clave=<%=consumibles.get(i).getClave()%>&action=borrar"><button class="btn waves-effect waves-light red" name="action"><i class="material-icons center">delete</i></button></a>
            </td>
            <%
            }
            %>
          </tr>
        </tbody>
      </table>

    <!--Import jQuery before materialize.js-->
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="js/materialize.js"></script>
  </body>
</html>
