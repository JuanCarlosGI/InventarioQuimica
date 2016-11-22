<%@page import="java.util.LinkedList"%>
<%@page import="models.Laboratorio"%>
<!DOCTYPE html>
  <html>
    <head>
      <!--Import Google Icon Font-->
      <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

      <!--Import materialize.css-->
      <link type="text/css" rel="stylesheet" href="css/materialize.css"  media="screen,projection"/>

      <script type="text/javascript" src="js/agregarLaboratorio.js"></script>

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
      <nav style="background-color: #00bcd4">
    <div class="nav-wrapper center">
      <div class="col s12">
        <a href="#!" class="breadcrumb">Inicio</a>
        <a href="#!" class="breadcrumb">Asignar Laboratorio</a>
      </div>
    </div>
  </nav>
  <!-- NAVBAR END-->

  <body>
    <div class="container">
    <div class='section'></div>

    <div class='section'></div>

      <form action="asignarLaboratorio" method="POST">
        <div class="row">
          <div class="input-field col s6">
            <input required placeholder="36" type="text" class="validate" id="numeroAlumnos" name="numeroAlumnos" onchange="nuevosAlumnos(this)"/>
            <label for="numeroAlumnos">Cantidad de alumnos por inscribir</label>
          </div>
          <div class="input-field col s6" >
            <select required name="laboratorioId">
              <option value="" disabled selected>Laboratorio</option>
              <%
                  LinkedList<Laboratorio> labs = (LinkedList<Laboratorio>)request.getAttribute("laboratorios");
                for (Laboratorio lab : labs)
                {
                %>
                <option value="<%=lab.getClave()%>"><%= lab.getNombre() %></option>
                <%
                    }
                    %>
            </select>
          </div>
        </div><br>

        <div class="row center">
          <div class="col s12">
            <h5>Matriculas</h5>
          </div>
          <div class="col s1 m3"></div>
          <div id="alumnos" class="input-field col s10 m6">
            <input disabled type="text"/>
            <label>Definir cantidad de alumnos</label>
          </div>
        </div>


        <div class='section'>
          <div class="row center">
          <button class="btn waves-effect waves-light" type="submit" name="action">Asignar alumnos<i class="material-icons right">send</i>
          </button>
          </div>
        </div>
      </form>
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