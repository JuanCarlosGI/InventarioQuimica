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
import models.Consumible;
import models.Usuario;

/**
 *
 * @author Cesar
 */
@WebServlet(name = "addConsumible", urlPatterns = {"/addConsumible"})
public class addConsumible extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*String marca = request.getParameter("clave");
        String marca = request.getParameter("marca");
        String nombre = request.getParameter("nombre");
        String cantidad = request.getParameter("cantidad");
        String presentacion = request.getParameter("presentacion");
        String contenido = request.getParameter("contenido");
        String localizacion = request.getParameter("localizacion");

        String url = "/login.html";
        Usuario user = (Usuario) request.getSession().getAttribute("usuario");
        if (user != null && user.getRol().equals("Administrador")
                && marca != null && nombre != null && cantidad != null
                && presentacion != null && contenido != null && localizacion != null) {
            Consumible con = new Consumible();
            con.setMarca(marca);
            lab.setNombre(nombre);

            Context.insertarLaboratorio(lab);
            
            request.setAttribute("laboratorios", Context.getLaboratorios());
            url = "/admin_laboratorio.jsp";
        }

        RequestDispatcher dispatcher =
                 getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);*/
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("consumibles", Context.getConsumibles());
        String url = "/admin_consumibles.jsp";
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
