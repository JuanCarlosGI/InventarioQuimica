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
          <a href="./profesor_login.jsp" class="brand-logo center">Almacén de Química</a>
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
                <span class="card-title">Bienvenido NOMBRE</span>
                <p>Alumnos registrados: 60</p>
                <p>Laboratorios: 3</p>
                <p>Vales activos: 1</p>
              </div>
            </div>
          </div>
        

        <div class="row">
          <div class="col s12 m6">
            <h5 class="center"><i class="material-icons">assignment_ind</i> Laboratorio</h5>
            <div class="section center">
              <a href="addAlumno" class="waves-effect waves-light btn-large" style="width: 80%; background-color: #00bcd4">Editar Alumnos</a><br><br>
              <a href="asignarLaboratorio" class="waves-effect waves-light btn-large" style="width: 80%; background-color: #00bcd4">Asignar Laboratorio</a>
            </div>
          </div>
          <div class="col s12 m6">
            <h5 class="center"><i class="material-icons">description</i> Vales</h5>
            <div class="section center">
              <a href="addPedido" class="waves-effect waves-light btn-large" style="width: 80%; background-color: #3f51b5">Crear Vale</a><br><br>
              <a href="./profesor_misVales.jsp" class="waves-effect waves-light btn-large" style="width: 80%; background-color: #3f51b5">Mis Vales</a>
            </div>
          </div>
        </div>
      </div>


      <!--Import jQuery before materialize.js-->
      <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
      <script type="text/javascript" src="js/materialize.js"></script>
    </body>
  </html>