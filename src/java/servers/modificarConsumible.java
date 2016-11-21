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
import models.Usuario;

/**
 *
 * @author Cesar
 */
@WebServlet(name = "modificarConsumible", urlPatterns = {"/modificarConsumible"})
public class modificarConsumible extends HttpServlet {

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
        Usuario user = (Usuario) request.getSession().getAttribute("usuario");
        if (user != null && user.getRol().equals("Administrador")) {
            if(action.equals("modificar")){
                url = "/admin_modificarConsumible.jsp";
            }else{
                Context.eliminarConsumible(clave);
                request.setAttribute("consumibles", Context.getConsumibles());
                url = "/admin_consumibles.jsp";
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
