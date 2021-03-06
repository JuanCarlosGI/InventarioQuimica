<%@page import="java.util.LinkedList"%>
<%@page import="models.Laboratorio"%>
<!DOCTYPE html>
  <html>
    <head>
      <!--Import Google Icon Font-->
      <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

      <!--Import materialize.css-->
      <link type="text/css" rel="stylesheet" href="css/materialize.css"  media="screen,projection"/>

      <script type="text/javascript" src="js/crearVale.js"></script>

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
          <a href="./admin_login.jsp" class="brand-logo center">Almac�n de Qu�mica</a>
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
      <nav style="background-color: #00bcd4">
    <div class="nav-wrapper center">
      <div class="col s12">
        <a href="./admin_login.jsp" class="breadcrumb">Inicio</a>
        <a class="breadcrumb">Laboratorios</a>
      </div>
    </div>
  </nav>
  <!-- NAVBAR END-->

<body>
<div class="row">
  <div class="container">
    <div class='section'></div>

    <form action="addLaboratorio" method="POST">
      <div class="row">
        <div class="input-field col s6">
          <input placeholder="Qu�mica Org�nica" type="text" class="validate" id="nombreLaboratorio" name="nombre"/>
          <label for="nombreLaboratorio">Nombre</label>
        </div>
        <div class="input-field col s6">
          <input required placeholder="HE123003" type="text" class="validate" id="claveLaboratorio" name="clave"/>
          <label for="claveLaboratorio">Clave</label>
        </div><br><br>

      <div class='section'>
        <div class="row center">
        <button class="btn waves-effect waves-light" type="submit" name="action">Crear Laboratorio
          <i class="material-icons right">send</i>
        </button>
        </div>
      </div>
    </form>
  </div>
  </div>

<div class="row">
  <table class="responsive-table striped centered">
      <thead>
        <tr>
            <th data-field="nombreLaboratorio">Nombre Laboratorio</th>
            <th data-field="claveLaboratorio">Clave Laboratorio</th>
            <th data-field="profesores">Profesores Inscritos</th>
            <th data-field="profesores">Agregar Profesores</th>
            <th data-field="eliminar">Eliminar</th>
        </tr>
      </thead>

      <tbody>
          <%
            LinkedList<Laboratorio> labs = (LinkedList<Laboratorio>)request.getAttribute("laboratorios");
                for (Laboratorio lab : labs)
              {
              %>
              <tr>
                  <td><%=lab.getNombre()%></td>
                  <td><%=lab.getClave()%></td>
                  <td>TO DO</td>
                  <td>
                      <a href="addMaestroLaboratorio?clave=<%=lab.getClave()%>"><button class="btn waves-effect waves-light green" name="action" ><i class="material-icons center">add</i></button><a href="addMaestroLaboratorio?clave=<%=lab.getClave()%>">
                  </td>
                 
                  <td>
                  <button class="btn waves-effect waves-light red" name="action"><i class="material-icons center">delete</i></button>
                  </td>
              </tr>
              <%
              }
          %>
      </tbody>
    </table>
  </div>

    <!--Import jQuery before materialize.js-->
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="js/materialize.js"></script>
    <script type="text/javascript">
      $(document).ready(function() {
        $('select').material_select();
      });
    </script>
  </body>
</html>