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
import models.Laboratorio;
import models.Usuario;

/**
 *
 * @author JuanCarlos
 */
@WebServlet(name = "asignarLaboratorio", urlPatterns = {"/asignarLaboratorio"})
public class asignarLaboratorio extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String clave = request.getParameter("laboratorioId");
        String[] matriculas = request.getParameterValues("matricula");

        String url = "/login.html";
        Usuario user = (Usuario) request.getSession().getAttribute("usuario");
        if (user != null && user.getRol().equals("Profesor")
                && clave != null && matriculas != null) {
            
            String nomina = user.getMatricula();
            String aux = "hola";
            for (String matricula : matriculas) {
                Context.insertarRegistroLaboratorio(nomina, clave, matricula);
            }
            
            request.setAttribute("laboratorios", user.getImparteLaboratorios());
            url = "/profesor_asignarLaboratorio.jsp";
        }

        RequestDispatcher dispatcher =
                 getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario user = (Usuario) request.getSession().getAttribute("usuario");
        String url = "/login.html";
        if (user != null && user.getRol().equals("Profesor"))
        {
            request.setAttribute("laboratorios", user.getImparteLaboratorios());
            url = "/profesor_asignarLaboratorio.jsp";   
        }
        RequestDispatcher dispatcher =
                 getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
            
    }
}
