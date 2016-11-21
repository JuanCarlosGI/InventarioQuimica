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
import models.Material;
import models.Usuario;

/**
 *
 * @author Cesar
 */
@WebServlet(name = "addMaterial", urlPatterns = {"/addMaterial"})
public class addMaterial extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String clave = request.getParameter("clave");
        String marca = request.getParameter("marca");
        String nombre = request.getParameter("nombre");
        String cantidad = request.getParameter("cantidad");
        String localizacion = request.getParameter("localizacion");
        String descripcion = request.getParameter("descripcion");
        String capacidad = request.getParameter("capacidad");

        String url = "/login.html";
        Usuario user = (Usuario) request.getSession().getAttribute("usuario");
        if (user != null && user.getRol().equals("Administrador")
                && marca != null && nombre != null && cantidad != null
               && localizacion != null
                && descripcion != null && clave != null) {
            int cant = Integer.parseInt(cantidad);
            Material mat = new Material();
            mat.setMarca(marca);
            mat.setNombre(nombre);
            mat.setCantidad(cant);
            mat.setClave(clave);
            mat.setCapacidad(capacidad);
            mat.setDescripcion(descripcion);
            mat.setLocalizacion(localizacion);
            
            
            Context.insertarMaterial(mat);

            request.setAttribute("materiales", Context.getMateriales());
            url = "/admin_materiales.jsp";
        }        
        RequestDispatcher dispatcher =
                 getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         request.setAttribute("materiales", Context.getMateriales());
         String url = "/admin_materiales.jsp";
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
