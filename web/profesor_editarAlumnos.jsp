<%-- 
    Document   : admin_editarAlumnos
    Created on : 20-nov-2016, 13:26:04
    Author     : armando
--%>

<%@page import="models.Laboratorio"%>
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
      <%@ page import="models.Usuario" %>
        <%@ page import="data.Context" %>
        <%@ page import="java.util.LinkedList"%>
        <jsp:useBean id = "usuario" class="models.Usuario" scope = "session"/>
        <% 
            LinkedList<Usuario> usuarios = (LinkedList<Usuario>)request.getAttribute("alumnos");    
        %>
      <ul id="dropdown1" class="dropdown-content">
        <li><a href="admin_editarPerfil.jsp">Perfil</a></li>
        <li class="divider"></li>
        <li><a href="#!">Salir</a></li>
      </ul>

      <nav>
        <div class="nav-wrapper">
          <a href="./profesor_login.jsp" class="brand-logo center">Almacén de Química</a>
          <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
          <ul class="right hide-on-med-and-down">
          <!-- Dropdown Trigger -->
          <li><a class="dropdown-button" href="#!" data-activates="dropdown1">${usuario.nombre}<i class="material-icons right">arrow_drop_down</i></a></li>
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
        <a href="./profesor_login.jsp" class="breadcrumb">Inicio</a>
        <a class="breadcrumb">Editar Alumnos</a>
      </div>
    </div>
  </nav>
  <!-- NAVBAR END-->
    <form action="addAlumno" method="post">
        <div class="section"></div>
        <div class="row">
          <div class="col s2 m3 l4"></div>
          <div class="card col s8 m6 l4">
            <div class="card-content center">
              <span class="card-title activator grey-text text-darken-4">AGREGAR ALUMNO</span>
            </div>
            <div class="card-reveal center">
                <input placeholder="Matricula" type="text" class="validate" id="matricula" name="matricula"/>
            </div>
          </div>
        </div>
    </form>

    <table class="responsive-table striped">
        <thead>
          <tr>
              <th data-field="matriucla">Matricula</th>
              <th data-field="nombre">Nombre</th>
              <th data-field="correo">Correo</th>
              <th data-field="laboratorio">Laboratorio</th>
              <th data-field="eliminar">Eliminar</th>
          </tr>
        </thead>

        <tbody>
              <%
                  LinkedList<Laboratorio> labos = new LinkedList<>();
                  for(int i=0; i<usuarios.size(); i++){
                      
                      
                      if(usuarios.get(i).getRol().equals("Alumno")){ 
                        labos=usuarios.get(i).getCursaLaboratorios();
                        String laborat = "";
                        for(int j=0; j<labos.size();j++){
                          laborat += labos.get(j).getNombre()+",\n";
                        }
                        if(!laborat.equals(""))
                        laborat=laborat.substring(0,laborat.length()-2);
                        out.println("<tr>");
                        out.println("<td>"+usuarios.get(i).getMatricula()+"</td>");
                        out.println("<td>"+usuarios.get(i).getNombre()+"</td>");
                        out.println("<td>"+usuarios.get(i).getCorreo()+"</td>");
                        out.println("<td>"+ laborat +"</td>");
                      
                      
                  
              %>
            <td>
                <a href="deleteThis?id=<%=usuarios.get(i).getMatricula()%>" <button class="btn waves-effect waves-light red" name="action"><i class="material-icons center">delete</i></button> </a>
            </td>
          </tr>
          <%
              }
              }
          %>
          
        </tbody>
      </table>

    <!--Import jQuery before materialize.js-->
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="js/materialize.js"></script>
  </body>
</html>
