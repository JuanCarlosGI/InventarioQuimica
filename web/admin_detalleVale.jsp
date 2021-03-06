<%@page import="data.Context"%>
<%@page import="models.DetalleMaterial"%>
<%@page import="models.Material"%>
<%@page import="models.DetalleReactivo"%>
<%@page import="models.Reactivo"%>
<%@page import="models.DetalleConsumible"%>
<%@page import="models.Consumible"%>
<%@page import="models.DetalleEquipo"%>
<%@page import="models.Equipo"%>
<%@page import="models.Usuario"%>
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
          <a href="admin_login.jsp" class="brand-logo center">Almac�n de Qu�mica</a>
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
      <nav style="background-color: #3f51b5">
    <div class="nav-wrapper center">
      <div class="col s12">
        <a href="admin_login.jsp" class="breadcrumb">Inicio</a>
        <a href="admin_listaVales.jsp" class="breadcrumb">Mis Vales</a>
        <a class="breadcrumb">Ver Vale</a>
      </div>
    </div>
  </nav>
  <!-- NAVBAR END-->

<body>
  <div class="container">
  <div class='section'></div>

  <div class='section'></div>

  <div class="col s12">
      <%@ page import="models.Pedido" %>
        <jsp:useBean id = "pedido" class="models.Pedido" scope = "request"/>
  </div>
    <div class="row">
        <div class="input-field col s6">
      <input disabled type="text" class="validate" id="folio" name="folio" value="${pedido.id}"/>
      <label for="folio">Folio</label>
    </div>
      <div class="input-field col s6">
          <input disabled type="text" class="validate" id="matricula" name="matricula" value="${pedido.usuarioId}"/>
        <label for="matricula">Matricula/N�mina</label>
      </div>
      <div class="input-field col s6">
        <input disabled type="text" class="validate" id="nombre" name="nombre" value="${pedido.getUsuario().getNombre()}"/>
        <label for="nombre">Nombre</label>
      </div>
      <div class="input-field col s6">
          <input disabled type="email" class="validate" id="email" name="email" value="${pedido.getUsuario().getCorreo()}"/>
        <label for="email">Correo</label>
      </div>
    </div><br>

    <div class="row">
      <div class="input-field col s6">
          <input disabled type="text" class="validate" id="laboratorio" name="laboratorio" value="${pedido.getLaboratorio().getNombre()}"/>
        <label for="laboratorio">Laboratorio</label>
      </div>
      <div class="input-field col s6">
        <input disabled type="text" class="validate" id="profesor" name="profesor" value="${pedido.getMaestro().getNombre()}"/>
        <label for="profesor">Profesor</label>
      </div>
    </div><br>

    <h5>Productos</h5>

    <table class="responsive-table striped" id="vale">
        <tr>
            <th>Nombre</th>
            <th>Marca</th>
            <th>Cantidad</th>
            <th>Localizaci�n</th>
        </tr>
        <tbody>
            <%;
                for (DetalleMaterial detalle : pedido.getDetallesMaterial()){
    %>
    <tr>
        <td><%= Context.getMaterial(detalle.getMaterialId()).getNombre()%></td>
        <td><%= Context.getMaterial(detalle.getMaterialId()).getMarca()%></td>
        <td><%= detalle.getCantidad()%></td>
        <td><%= Context.getMaterial(detalle.getMaterialId()).getLocalizacion()%></td>
    </tr>
            <%}%>
            
            <%;
                for (DetalleEquipo detalle : pedido.getDetallesEquipo()){
    %>
    <tr>
        <td><%= Context.getEquipo(detalle.getEquipoId()).getNombre()%></td>
        <td><%= Context.getEquipo(detalle.getEquipoId()).getMarca()%></td>
        <td><%= detalle.getCantidad()%></td>
        <td><%= Context.getEquipo(detalle.getEquipoId()).getLocalizacion()%></td>
    </tr>
            <%}%>
            
            <%;
                for (DetalleConsumible detalle : pedido.getDetalleConsumible()){
    %>
    <tr>
        <td><%= Context.getConsumible(detalle.getConsumibleId()).getNombre()%></td>
        <td><%= Context.getConsumible(detalle.getConsumibleId()).getMarca()%></td>
        <td><%= detalle.getCantidad()%></td>
        <td><%= Context.getConsumible(detalle.getConsumibleId()).getLocalizacion()%></td>
    </tr>
            <%}%>
            
            <%;
                for (DetalleReactivo detalle : pedido.getDetallesReactivo()){
    %>
    <tr>
        <td><%= Context.getReactivo(detalle.getReactivoId()).getNombre()%></td>
        <td><%= Context.getReactivo(detalle.getReactivoId()).getMarca()%></td>
        <td><%= detalle.getCantidad()%></td>
        <td><%= Context.getReactivo(detalle.getReactivoId()).getLocalizacion()%></td>
    </tr>
            <%}%>
            
        </tbody>
        
    </table>

    <div class='section'></div>
    <div class='section'></div>
  </div>

    <!--Import jQuery before materialize.js-->
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="js/materialize.js"></script>
    <script type="text/javascript">
      $('.datepicker').pickadate({
        selectMonths: true, // Creates a dropdown to control month
        selectYears: 0, // Creates a dropdown of 0 years to control year
        selectDays: 2
      });

      $(document).ready(function() {
        $('select').material_select();
      });
    </script>
  </body>
</html>