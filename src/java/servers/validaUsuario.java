package servers;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import dal.Context;
import models.Usuario;

public class validaUsuario extends HttpServlet
{    
    protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response) 
                          throws ServletException, IOException
    {
        String login = request.getParameter("username");
        String pass = request.getParameter("password");
        Usuario usuario = Context.getUsuario(login);
        
        if (usuario != null || usuario.getPassword().contentEquals(pass)) {
            if (usuario.getRol().equals("Administrador")) {
                String url = "/loginAdmin.html";
                RequestDispatcher dispatcher =
                 getServletContext().getRequestDispatcher(url);
                dispatcher.forward(request, response); 
            } else if (usuario.getRol().equals("Maestro")) {
                String url = "/loginMaestro.html";
                RequestDispatcher dispatcher =
                 getServletContext().getRequestDispatcher(url);
                dispatcher.forward(request, response); 
            } else if (usuario.getRol().equals("Alumno")) {
                String url = "/loginAlumno.html";
                RequestDispatcher dispatcher =
                 getServletContext().getRequestDispatcher(url);
                dispatcher.forward(request, response); 
            }
        } else {
            String url = "/login.html";
                RequestDispatcher dispatcher =
                 getServletContext().getRequestDispatcher(url);
                dispatcher.forward(request, response); 
        
        }       
    }    
}
