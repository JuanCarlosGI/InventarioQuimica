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
 * @author JuanCarlos
 */
@WebServlet(name = "addMaestroLaboratorio", urlPatterns = {"/addMaestroLaboratorio"})
public class addMaestroLaboratorio extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String clave = request.getParameter("clave");
        String nomina = request.getParameter("nomina");

        String url = "/login.html";
        Usuario user = (Usuario) request.getSession().getAttribute("usuario");
        if (user != null && user.getRol().equals("Administrador")
                && clave != null && nomina != null) {
            Usuario maestro = Context.getUsuario(nomina);
            if (Context.getLaboratorio(clave) != null &&
                    maestro != null && maestro.getRol().equals("Profesor"))
            {
                Context.insertarMaestroLaboratorio(nomina, clave);
            }
            
            request.setAttribute("laboratorios", Context.getLaboratorios());
            url = "/admin_laboratorio.jsp";
        }

        RequestDispatcher dispatcher =
                 getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("clave", request.getParameter("clave"));
        String url = "/admin_profesorLaboratorio.jsp";
        RequestDispatcher dispatcher =
                 getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
            
    }

}
