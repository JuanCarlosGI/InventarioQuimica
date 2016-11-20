<%-- 
    Document   : admin_listaVales
    Created on : Nov 20, 2016, 1:56:10 PM
    Author     : Cesar
--%>

<%@page import="java.util.LinkedList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="data.Context" %>
<%@ page import="models.Pedido" %>
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
      <nav style="background-color: #3f51b5">
    <div class="nav-wrapper center">
      <div class="col s12">
        <a href="#!" class="breadcrumb">Inicio</a>
        <a href="#!" class="breadcrumb">Lista Vales</a>
      </div>
    </div>
  </nav>
  <!-- NAVBAR END-->

  <body>
    <table class='responsive-table striped centered'>
        <thead>
          <tr>
              <th data-field="folio">Folio</th>
              <th data-field="fecha_emision">Fecha de Emision</th>
              <th data-field="fecha_entrega">Fecha de Entrega</th>
              <th data-field="fecha_entrega">Fecha de Devolución</th>
              <th data-field="profesor">Matricula/Nomina</th>
              <th data-field="profesor">Nombre</th>
              <th data-field="vale">Vale</th>
          </tr>
        </thead>
        
        

        <tbody>
            <%
            LinkedList<Pedido> pedidos= Context.getPedidos();
            for(int i = 0; i < pedidos.size(); i+=1){
                System.out.println(pedidos.get(i).getId());
                System.out.println(pedidos.get(i).getFechaEmision());
                System.out.println(pedidos.get(i).getFechaEntrega());
                System.out.println(pedidos.get(i).getFechaDevolucion());
                System.out.println(pedidos.get(i).getUsuarioId());

             %>
          <tr>
            <td><%=pedidos.get(i).getId()%></td>
            <td><%=pedidos.get(i).getFechaEmision()%></td>
            <td>
              <%=pedidos.get(i).getFechaEntrega()%>
            </td>
            <td>
              <%=pedidos.get(i).getFechaDevolucion()%>
            </td>
            <td><%=pedidos.get(i).getUsuarioId()%></td>
            <%
            Usuario usuario = Context.getUsuario(pedidos.get(i).getUsuarioId());
            
            %>
            <td><%=usuario.getNombre()%></td>
            <td>
              <button class="btn waves-effect waves-light" name="action" ><i class="material-icons center">description</i></button>
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