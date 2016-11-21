/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servers;

import data.Context;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Material;
import models.Pedido;
import models.Usuario;
import models.Reactivo;
import models.Consumible;
import models.Equipo;

/**
 *
 * @author JuanCarlos
 */
@WebServlet(name = "addPedido", urlPatterns = {"/addPedido"})
public class addPedido extends HttpServlet {

        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] materialIds = request.getParameterValues("materialId");
        String[] materialCantidades = request.getParameterValues("materialCantidad");
        String[] materialesObservaciones = request.getParameterValues("materialObservaciones");
        
        String[] reactivoIds = request.getParameterValues("reactivoId");
        String[] reactivoCantidades = request.getParameterValues("reactivoCantidad");
        String[] reactivosObservaciones = request.getParameterValues("reactivoObservaciones");
        
        String[] consumibleIds = request.getParameterValues("consumibleId");
        String[] consumibleCantidades = request.getParameterValues("consumibleCantidad");
        String[] consumiblesObservaciones = request.getParameterValues("consumibleObservaciones");
        
        String[] equipoIds = request.getParameterValues("equipoId");
        String[] equipoCantidades = request.getParameterValues("equipoCantidad");
        String[] equiposObservaciones = request.getParameterValues("equipoObservaciones");
        
        Usuario user = (Usuario)request.getSession().getAttribute("usuario");
        
        String profesorId = request.getParameter("profesorId");
        String laboratorioId = request.getParameter("laboratorioId");
        
        Date fechaEmision = Date.valueOf(LocalDate.now());
        Date fechaDevolucion = fechaEmision;
        Date fechaEntrega = fechaEmision;
        
        if (user != null) {
            Pedido pedido = new Pedido();
            
            int max = 0;
            for (Pedido aux : Context.getPedidos()) {
                if (aux.getId() > max) max = aux.getId();
            }
            int pedidoId = max + 1;
            pedido.setId(pedidoId);
            pedido.setLaboratorioId(laboratorioId);
            pedido.setProfesorId(profesorId);
            pedido.setFechaEmision(fechaEmision);
            pedido.setFechaEntrega(fechaEntrega);
            pedido.setFechaDevolucion(fechaDevolucion);
            pedido.setStatus(0);
            pedido.setUsuarioId(user.getMatricula());
            
            Context.insertarPedido(pedido);
            
            if (materialIds != null && materialCantidades != null && materialesObservaciones != null &&
                    materialIds.length == materialCantidades.length && materialIds.length == materialesObservaciones.length) {
                for (int i = 0; i < materialIds.length; i++) {
                    Material material = Context.getMaterial(materialIds[i]);
                    if (material.getCantidad() < Integer.parseInt(materialCantidades[i])) {    
                        Context.insertarDetalleMaterial(Integer.parseInt(materialCantidades[i]), 0, materialesObservaciones[i], materialIds[i], pedidoId);
                        material.setCantidad(material.getCantidad() - Integer.parseInt(materialCantidades[i]));
                        Context.actualizarMaterial(material);
                    }
                }
            }
            
            if (reactivoIds != null && reactivoCantidades != null && reactivosObservaciones != null &&
                    reactivoIds.length == reactivoCantidades.length && reactivoIds.length == reactivosObservaciones.length) {
                for (int i = 0; i < reactivoIds.length; i++) {
                    Reactivo reactivo = Context.getReactivo(reactivoIds[i]);
                    if (reactivo.getCantidad() < Integer.parseInt(reactivoCantidades[i])) {    
                        Context.insertarDetalleReactivo(Integer.parseInt(reactivoCantidades[i]), 0, reactivosObservaciones[i], reactivoIds[i], pedidoId);
                        reactivo.setCantidad(reactivo.getCantidad() - Integer.parseInt(reactivoCantidades[i]));
                        Context.actualizarReactivo(reactivo);
                    }
                }
            }
            
            if (consumibleIds != null && consumibleCantidades != null && consumiblesObservaciones != null &&
                    consumibleIds.length == consumibleCantidades.length && consumibleIds.length == consumiblesObservaciones.length) {
                for (int i = 0; i < consumibleIds.length; i++) {
                    Consumible consumible = Context.getConsumible(consumibleIds[i]);
                    if (consumible.getCantidad() < Integer.parseInt(consumibleCantidades[i])) {    
                        Context.insertarDetalleConsumible(Integer.parseInt(consumibleCantidades[i]), consumiblesObservaciones[i], consumibleIds[i], pedidoId);
                        consumible.setCantidad(consumible.getCantidad() - Integer.parseInt(consumibleCantidades[i]));
                        Context.actualizarConsumible(consumible);
                    }
                }
            }
            
            if (equipoIds != null && equipoCantidades != null && equiposObservaciones != null &&
                    equipoIds.length == equipoCantidades.length && equipoIds.length == equiposObservaciones.length) {
                for (int i = 0; i < equipoIds.length; i++) {
                    Equipo equipo = Context.getEquipo(equipoIds[i]);
                    if (equipo.getCantidad() < Integer.parseInt(equipoCantidades[i])) {    
                        Context.insertarDetalleEquipo(Integer.parseInt(equipoCantidades[i]), 0, equiposObservaciones[i], equipoIds[i], pedidoId);
                        equipo.setCantidad(equipo.getCantidad() - Integer.parseInt(equipoCantidades[i]));
                        Context.actualizarEquipo(equipo);
                    }
                }
            }
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario user = (Usuario) request.getSession().getAttribute("usuario");
        String url = "/login.html";
        if (user != null)
        {
            request.setAttribute("materiales", Context.getMateriales());
            request.setAttribute("equipos", Context.getEquipos());
            
            if (user.getRol().equals("Alumno")) {
                url = "alumno_crearVale";
                
            }  
            else {
                request.setAttribute("reactivos", Context.getReactivos());
                request.setAttribute("consumibles", Context.getConsumibles());
                
                url = "profesor_crearVale";
            }
        }
        RequestDispatcher dispatcher =
                 getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
