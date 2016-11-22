<%@page import="models.Equipo"%>
<%@page import="models.Material"%>
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
            <li><a href="./alumno_editarPerfil.html">Perfil</a></li>
            <li class="divider"></li>
            <li><a href="#!">Salir</a></li>
        </ul>

        <nav>
            <div class="nav-wrapper">
                <a href="./alumno_login.jsp" class="brand-logo center">Almac�n de Qu�mica</a>
                <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
                <ul class="right hide-on-med-and-down">
                    <!-- Dropdown Trigger -->
                    <li><a class="dropdown-button" href="#!" data-activates="dropdown1">USUARIO<i class="material-icons right">arrow_drop_down</i></a></li>
                </ul>
                <ul class="side-nav" id="mobile-demo">
                    <li><a href="./alumno_editarPerfil.html">Perfil</a></li>
                    <li><a href="#">Salir</a></li>
                </ul>
            </div>
        </nav>
        <nav style="background-color: #3f51b5">
            <div class="nav-wrapper center">
                <div class="col s12">
                    <a href="./alumno_login.jsp" class="breadcrumb">Inicio</a>
                    <a class="breadcrumb">Crear vale</a>
                </div>
            </div>
        </nav>
        <!-- NAVBAR END-->

    <body>
        <div class="container">
            <div class='section'></div>

            <div class='section'></div>

            <form action="addPedidoAlumno" method="POST">

                <div class="row">
                    <div class="input-field col s12">
                        <select required name="laboratorioId">
                            <option value="" disabled selected>Laboratorio</option>

                            <% for (Laboratorio lab : (LinkedList<Laboratorio>) request.getAttribute("laboratorios")) {%>
                            <option value="<%=lab.getClave()%>"><%=lab.getNombre()%></option>
                            <%}%>
                        </select>
                    </div>
                </div><br>

                <h5>Productos</h5>

                <table class="responsive-table" id="vale" onload="agregarFila()">
                </table>

                <div class='section'>
                    <div class='row right'>
                        <a onclick="agregarFila(true)" class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">add</i></a>
                    </div>
                </div>

                <div class='section'></div>
                <div class='section'></div>

                <div class='section'>
                    <div class="row center">
                        <button class="btn waves-effect waves-light" type="submit" name="action">Crear Vale
                            <i class="material-icons right">send</i>
                        </button>
                    </div>
                </div>
            </form>
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

            $(document).ready(function () {
                $('select').material_select();
            });
        </script>
        <%
            String arregloMateriales = "";
            for (Material material : (LinkedList<Material>) request.getAttribute("materiales")) {
                arregloMateriales += ", \"" + material.getNombre() + "\"";
            }
            arregloMateriales = arregloMateriales.length() > 0 ? arregloMateriales.substring(2) : "";
            
            String arregloEquipos = "";
            for (Equipo equipo : (LinkedList<Equipo>) request.getAttribute("equipos")) {
                arregloEquipos += ", \"" + equipo.getNombre() + "\"";
            }
            arregloEquipos = arregloEquipos.length() > 0 ? arregloEquipos.substring(2) : "";
        %>
        <script type="text/javascript">
            var nombresMateriales = [<%=arregloMateriales%>];
            var nombresEquipos = [<%=arregloEquipos%>];
            var nombresReactivos = [];
            var nombresConsumibles = [];
        </script>
        <script src="js/ajaxCrearVale.js" type="text/javascript"></script>
    </body>
</html>