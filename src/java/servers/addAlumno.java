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
import models.Usuario;

/**
 *
 * @author armando
 */
@WebServlet(name = "addAlumno", urlPatterns = {"/addAlumno"})
public class addAlumno extends HttpServlet {

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
        
        request.setAttribute("alumnos", Context.getUsuarios());
        Usuario user = (Usuario)request.getSession().getAttribute("usuario");
        String url = "/admin_editarAlumnos.jsp";
        if (user.getRol().equals("Profesor")) {
            url = "/profesor_editarAlumnos.jsp";
        }
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
        
        String mat = request.getParameter("matricula");
        ServletContext context = getServletContext();
        Usuario usuario = new Usuario();
        usuario.setMatricula(mat);
        usuario.setNombre(mat);
        usuario.setPassword(mat);
        usuario.setRol("Alumno");
        usuario.setCreadorId(null);
        usuario.setCorreo(mat+"@itesm.mx");
        if(Context.insertarUsuario(usuario)){
            System.out.println("se inserto");
        }
        else{
            System.out.println("No se inserto");
        }
        
        // forward request and response objects to JSP page
        request.setAttribute("alumnos", Context.getUsuarios());
        String url = "/admin_editarAlumnos.jsp";
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
