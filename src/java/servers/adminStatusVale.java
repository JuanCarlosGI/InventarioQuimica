/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servers;

import data.Context;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.DetalleEquipo;
import models.DetalleMaterial;
import models.DetalleReactivo;
import models.Equipo;
import models.Material;
import models.Pedido;
import models.Reactivo;

/**
 *
 * @author Cesar
 */
@WebServlet(name = "adminStatusVale", urlPatterns = {"/adminStatusVale"})
public class adminStatusVale extends HttpServlet {

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
       String status = request.getParameter("status");
       String id = request.getParameter("id");
       int idP = Integer.parseInt(id);
       Pedido pedido = Context.getPedido(idP);
       if(status.equals("1")){
           Context.aceptarPedido(pedido);
       }else if(status.equals("2")){
           Context.regresarPedido(pedido);
           LinkedList<DetalleEquipo> de = Context.getDetalleEquipo(pedido.getId());
           LinkedList<DetalleMaterial> dm = Context.getDetalleMaterial(pedido.getId());
           LinkedList<DetalleReactivo> dr = Context.getDetalleReactivo(pedido.getId());
           LinkedList<Equipo> equipos = Context.getEquipos();
           LinkedList<Material> materiales = Context.getMateriales();
           LinkedList<Reactivo> reactivos = Context.getReactivos();
           for(int i=0; i<de.size(); i++){
               for(int j=0; j<equipos.size(); j++){
                    if(de.get(i).getEquipoId()==equipos.get(j).getClave()){
                        int cant = de.get(i).getCantidad()+equipos.get(j).getCantidad();
                        Equipo eq = equipos.get(j);
                       eq.setCantidad(cant);
                       Context.actualizarEquipo(eq);
                    }
                }
           }
           
           for(int i=0; i<dm.size(); i++){
               for(int j=0; j<materiales.size(); j++){
                    if(dm.get(i).getMaterialId()==materiales.get(j).getClave()){
                        int cant = dm.get(i).getCantidad()+materiales.get(j).getCantidad();
                        Material eq = materiales.get(j);
                       eq.setCantidad(cant);
                       Context.actualizarMaterial(eq);
                    }
                }
           }
           
           for(int i=0; i<dr.size(); i++){
               for(int j=0; j<reactivos.size(); j++){
                    if(dr.get(i).getReactivoId()==reactivos.get(j).getClave()){
                        int cant = dr.get(i).getCantidad()+reactivos.get(j).getCantidad();
                        Reactivo eq = reactivos.get(j);
                       eq.setCantidad(cant);
                       Context.actualizarReactivo(eq);
                    }
                }
           }
       }else if(status.equals("3")){
           Context.denegarPedido(pedido);
           LinkedList<DetalleEquipo> de = Context.getDetalleEquipo(pedido.getId());
           LinkedList<DetalleMaterial> dm = Context.getDetalleMaterial(pedido.getId());
           LinkedList<DetalleReactivo> dr = Context.getDetalleReactivo(pedido.getId());
           LinkedList<Equipo> equipos = Context.getEquipos();
           LinkedList<Material> materiales = Context.getMateriales();
           LinkedList<Reactivo> reactivos = Context.getReactivos();
           for(int i=0; i<de.size(); i++){
               for(int j=0; j<equipos.size(); j++){
                    if(de.get(i).getEquipoId()==equipos.get(j).getClave()){
                        int cant = de.get(i).getCantidad()+equipos.get(j).getCantidad();
                        Equipo eq = equipos.get(j);
                       eq.setCantidad(cant);
                       Context.actualizarEquipo(eq);
                    }
                }
           }
           
           for(int i=0; i<dm.size(); i++){
               for(int j=0; j<materiales.size(); j++){
                    if(dm.get(i).getMaterialId()==materiales.get(j).getClave()){
                        int cant = de.get(i).getCantidad()+materiales.get(j).getCantidad();
                        Material eq = materiales.get(j);
                       eq.setCantidad(cant);
                       Context.actualizarMaterial(eq);
                    }
                }
           }
           
           for(int i=0; i<dr.size(); i++){
               for(int j=0; j<reactivos.size(); j++){
                    if(dr.get(i).getReactivoId()==reactivos.get(j).getClave()){
                        int cant = dr.get(i).getCantidad()+reactivos.get(j).getCantidad();
                        Reactivo eq = reactivos.get(j);
                       eq.setCantidad(cant);
                       Context.actualizarReactivo(eq);
                    }
                }
           }
       }
       String url = "/admin_listaVales.jsp";
       
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
