/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servers;

import data.Context;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Consumible;
import models.Equipo;
import models.Material;
import models.Reactivo;
import models.Usuario;

/**
 *
 * @author JuanCarlos
 */
@WebServlet(name = "getFiltro", urlPatterns = {"/getFiltro"})
public class getFiltro extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String url;
        String tipo = request.getParameter("tipo");
        switch(tipo) {
            case("materiales"):
                String nombreMaterial = request.getParameter("nombre");
                String marcaMaterial = request.getParameter("marca");
                LinkedList<Material> materiales = Context.filtrarMateriales(nombreMaterial, marcaMaterial);
                request.setAttribute("materiales", materiales);
                url = marcaMaterial == null ? "/ajaxMaterialesMarca.jsp" : "/ajaxMaterialesCapacidad.jsp";
                break;
            case("equipos"):
                String nombreEquipo = request.getParameter("nombre");
                LinkedList<Equipo> equipos = Context.filtrarEquipos(nombreEquipo);
                request.setAttribute("equipos", equipos);
                url = "/ajaxEquiposMarca.jsp";
                break;
            default:
                String nombre = request.getParameter("nombre");
                String marca = request.getParameter("marca");
                String presentacion = request.getParameter("presentacion");
                
                if (tipo.equals("reactivo")){
                    LinkedList<Reactivo> reactivos = Context.filtrarReactivos(nombre, marca, presentacion);
                    request.setAttribute("reactivos", reactivos);
                    
                    if (marca == null) url = "/ajaxReactivosMarca.jsp";
                    else if (presentacion == null) url = "/ajaxReactivosPresentacion.jsp";
                    else url = "/ajaxReactivosContenido.jsp";
                }
                else {
                    LinkedList<Consumible> consumibles = Context.filtrarConsumibles(nombre, marca, presentacion);
                    request.setAttribute("consumibles", consumibles);
                    
                    if (marca == null) url = "/ajaxConsumiblesMarca.jsp";
                    else if (presentacion == null) url = "/ajaxConsumiblesPresentacion.jsp";
                    else url = "/ajaxConsumiblesContenido.jsp";
                }
        }
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }
}