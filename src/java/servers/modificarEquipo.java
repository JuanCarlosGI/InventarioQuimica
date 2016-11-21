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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Equipo;
import models.Usuario;

/**
 *
 * @author Cesar
 */
@WebServlet(name = "modificarEquipo", urlPatterns = {"/modificarEquipo"})
public class modificarEquipo extends HttpServlet {


    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String clave = request.getParameter("clave");
        String action = request.getParameter("action");

        String url = "/login.html";
        request.getSession().setAttribute("clave", clave);
        Usuario user = (Usuario) request.getSession().getAttribute("usuario");
        if (user != null && user.getRol().equals("Administrador")) {
                if(action.equals("modificar")){
                    request.getSession().setAttribute("clave", clave);
                    request.setAttribute("equipo", Context.getEquipo(clave));
                    url = "/admin_editarEquipo.jsp";
            }else{
                Context.eliminarEquipo(clave);
                request.setAttribute("equipos", Context.getEquipos());
                url = "/admin_equipos.jsp";
            }
        }
        System.out.println(url);
        RequestDispatcher dispatcher =
                 getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        String clave = request.getParameter("clave");
        String marca = request.getParameter("marca");
        String nombre = request.getParameter("nombre");
        String cantidad = request.getParameter("cantidad");
        String localizacion = request.getParameter("localizacion");
        String descripcion = request.getParameter("descripcion");
        clave = (String)request.getSession().getAttribute("clave");
        String url = "/login.html";
        Usuario user = (Usuario) request.getSession().getAttribute("usuario");
        
        System.out.println(clave);
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
            System.out.println(clave);
            
            Context.actualizarEquipo(eq);

            request.setAttribute("equipos", Context.getEquipos());
            url = "/admin_equipos.jsp";
        }        
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
