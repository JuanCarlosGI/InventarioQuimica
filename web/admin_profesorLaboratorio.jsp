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
      <nav style="background-color: #00bcd4">
    <div class="nav-wrapper center">
      <div class="col s12">
        <a href="./admin_login.jsp" class="breadcrumb">Inicio</a>
        <a href="./admin_laboratorio.jsp" class="breadcrumb">Laboratorios</a>
        <a class="breadcrumb">Agregar Profesor</a>
      </div>
    </div>
  </nav>
  <!-- NAVBAR END-->

  <body>
    <div class="container">
    <div class='section'></div>

    <div class='section'></div>

    <form action="addMaestroLaboratorio" method="post">
        <div class="row">
          <div class="input-field col s12">
              <input type="hidden" value="<%=(String)request.getAttribute("clave")%>" name="clave" />
            <input placeholder="N00000000" type="text" class="validate" id="nomina" name="nomina"/>
            <label for="nomina">Nómina</label>
          </div>
        </div><br>


        <div class='section'>
          <div class="row center">
          <button class="btn waves-effect waves-light" type="submit" name="action">Agregar Profesor
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