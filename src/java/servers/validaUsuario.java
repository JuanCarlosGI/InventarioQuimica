package servers;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import data.Context;
import models.Usuario;

public class validaUsuario extends HttpServlet
{    
    protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response) 
                          throws ServletException, IOException
    {
        String login = request.getParameter("username");
        System.out.println(login);
        String pass = request.getParameter("password");
        Usuario usuario = Context.getUsuario(login);
        
        if (usuario != null && usuario.getPassword().contentEquals(pass)) {
            if (usuario.getRol().equals("Administrador")) {
                HttpSession session = request.getSession();
                session.setAttribute("usuario", usuario);
                String url = "/admin_login.html";
                RequestDispatcher dispatcher =
                 getServletContext().getRequestDispatcher(url);
                dispatcher.forward(request, response); 
            } else if (usuario.getRol().equals("Maestro")) {
                HttpSession session = request.getSession();
                session.setAttribute("usuario", usuario);
                String url = "/profesor_login.html";
                RequestDispatcher dispatcher =
                 getServletContext().getRequestDispatcher(url);
                dispatcher.forward(request, response); 
            } else if (usuario.getRol().equals("Alumno")) {
                HttpSession session = request.getSession();
                session.setAttribute("usuario", usuario);
                String url = "/alumno_login.jsp";
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
