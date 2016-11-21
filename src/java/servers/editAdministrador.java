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
import javax.servlet.http.HttpSession;
import models.Usuario;

/**
 *
 * @author Cesar
 */
@WebServlet(name = "editAdministrador", urlPatterns = {"/editAdministrador"})
public class editAdministrador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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
        processRequest(request, response);
        ServletContext context = getServletContext();
        Usuario usuario = new Usuario();
        String mat = request.getParameter("matricula");
        String nom = request.getParameter("nombre");
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        String passcon = request.getParameter("password_confirm");
        HttpSession session = request.getSession();
        usuario = (Usuario)session.getAttribute("usuario");
   
        if(pass.equals(passcon)){
            usuario.setNombre(nom);
            usuario.setCorreo(email);
            usuario.setPassword(pass);
            if(Context.actualizarUsuario(usuario)){
                String url = "login.html";
                if(usuario.getRol().equals("Administrador")){
                 url = "/admin_login.jsp";
                }else if(usuario.getRol().equals("Profesor")){
                     url = "/profesor_login.jsp";
                }else if(usuario.getRol().equals("Alumno")){
                     url = "/alumno_login.jsp";
                }
                
                RequestDispatcher dispatcher =
                    getServletContext().getRequestDispatcher(url);
                dispatcher.forward(request, response);
            }
            else{
                System.out.println("No se actualizo");
            }
        }
        else{
            String url = "/admin_editarPerfil.jsp";
            RequestDispatcher dispatcher =
                    getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
        }
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
