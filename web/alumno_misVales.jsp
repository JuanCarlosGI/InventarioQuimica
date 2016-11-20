<%@page import="java.util.LinkedList"%>
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
<%@ page import="models.Usuario" %>
        <jsp:useBean id = "usuario" class="models.Usuario" scope = "session"/>
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
          <li><a class="dropdown-button" href="#!" data-activates="dropdown1">${usuario.nombre}<i class="material-icons right">arrow_drop_down</i></a></li>
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
        <a href="#!" class="breadcrumb">Mis Vales</a>
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
              <th data-field="vale">Vale</th>
          </tr>
        </thead>

        <tbody>
            <%@ page import="models.Pedido" %>
            <%
                LinkedList<Pedido> pedidos = usuario.getPedidos();
                for (Pedido pedido : pedidos)
                {
            %>
            <tr>
                <td><%=pedido.getId()%></td>
                <td><%=pedido.getFechaEmision()%></td>
                <td><%=pedido.getStatus() >= 1 ? pedido.getFechaEntrega() : ""%></td>
                <td><%=pedido.getStatus() >= 2 ? pedido.getFechaDevolucion() : ""%></td>
                <td><button class="btn waves-effect waves-light" name="action"><i class="material-icons center">description</i></button></td>
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