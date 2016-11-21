/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Laboratorio;
import models.Usuario;
import data.Context;
import javax.servlet.RequestDispatcher;

@WebServlet(name = "addLaboratorio", urlPatterns = {"/addLaboratorio"})
public class addLaboratorio extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String clave = request.getParameter("clave");
        String nombre = request.getParameter("nombre");

        String url = "/login.html";
        Usuario user = (Usuario) request.getSession().getAttribute("usuario");
        if (user != null && user.getRol().equals("Administrador")
                && clave != null && nombre != null) {
            Laboratorio lab = new Laboratorio();
            lab.setClave(clave);
            lab.setNombre(nombre);

            Context.insertarLaboratorio(lab);

            url = "/admin_laboratorio.html";
        }

        RequestDispatcher dispatcher =
                 getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
