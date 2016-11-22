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
import models.Pedido;
import models.Usuario;

/**
 *
 * @author JuanCarlos
 */
@WebServlet(name = "adminDetalleVale", urlPatterns = {"/adminDetalleVale"})
public class adminDetalleVale extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String idString = request.getParameter("id");

        String url = "/login.html";
        Usuario user = (Usuario) request.getSession().getAttribute("usuario");
        if (user != null && idString != null) {
            Pedido pedido = Context.getPedido(Integer.parseInt(idString));
            
            request.setAttribute("pedido", pedido);
            url = "/admin_detalleVale.jsp";
            if (user.getRol().equals("Profesor")) url = "/profesor_detalleVale.jsp";
            if (user.getRol().equals("Alumno")) url = "/alumno_detalleVale.jsp";
        }

        RequestDispatcher dispatcher =
                 getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
