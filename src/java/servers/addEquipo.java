/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servers;

import data.Context;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Equipo;
import models.Usuario;

/**
 *
 * @author armando
 */
@WebServlet(name = "addEquipo", urlPatterns = {"/addEquipo"})
public class addEquipo extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String clave = request.getParameter("clave");
        String marca = request.getParameter("marca");
        String nombre = request.getParameter("nombre");
        String cantidad = request.getParameter("cantidad");
        String localizacion = request.getParameter("localizacion");
        String descripcion = request.getParameter("descripcion");

        String url = "/login.html";
        Usuario user = (Usuario) request.getSession().getAttribute("usuario");
        if (user != null && user.getRol().equals("Administrador")
                && marca != null && nombre != null && cantidad != null
               && localizacion != null
                && descripcion != null && clave != null) {
            int cant = Integer.parseInt(cantidad);
            Equipo eq = new Equipo();
            eq.setMarca(marca);
            eq.setNombre(nombre);
            eq.setCantidad(cant);
            eq.setClave(clave);
            eq.setDescripcion(descripcion);
            eq.setLocalizacion(localizacion);
            
            
            Context.insertarEquipo(eq);

            request.setAttribute("equipos", Context.getEquipos());
            url = "/admin_equipos.jsp";
        }        
        RequestDispatcher dispatcher =
                 getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("equipos", Context.getEquipos());
        String url = "/admin_equipos.jsp";
        RequestDispatcher dispatcher =
                 getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
            
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
