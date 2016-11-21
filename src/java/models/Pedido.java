package models;

import data.Context;
import java.sql.Date;
import java.util.LinkedList;

/**
 * Clase que representa a un pedido generado en el sistema.
 * @author Juan Carlos Guzmán Islas
 */
public class Pedido {
    /**
     * id del pedido.
     */
    private int id;

    /**
     * ID del usuario que generó el pedido.
     */
    private String usuarioId;

    /**
     * Estatus actual del pedido.
     */
    private int status;

    /**
     * Fecha en la cual se generó el pedido.
     */
    private Date fechaEmision;
    
    private Date fechaEntrega;
    
    private Date fechaDevolucion;

    /**
     * ID del profesor que imparte el laboratorio.
     */
    private String profesorId;

    /**
     * Clave del laboratorio para el cual se pide el material.
     */
    private String laboratorioId;

    /**
     * Regresa el ID del pedido.
     * @return El ID del pedido.
     */
    public final int getId() {
        return id;
    }

    /**
     * Le asigna un nuevo ID al pedido.
     * @param nuevoId El nuevo ID del pedido.
     */
    public final void setId(final int nuevoId) {
        this.id = nuevoId;
    }

    /**
     * Regresa el ID del usuario que generó el pedido.
     * @return El ID del usuario que generó el pedido.
     */
    public final String getUsuarioId() {
        return usuarioId;
    }

    /**
     * Le asigna un nuevo ID de usuario al pedido.
     * @param nuevoUsuarioId El nuevo ID de usuario del pedido.
     */
    public final void setUsuarioId(final String nuevoUsuarioId) {
        this.usuarioId = nuevoUsuarioId;
    }

    /**
     * Regresa el estatus del pedido.
     * @return El estatus del pedido.
     */
    public final int getStatus() {
        return status;
    }

    /**
     * Le asugna un nuevo estatus al pedido.
     * @param nuevoStatus El nuevo estatus del pedido.
     */
    public final void setStatus(final int nuevoStatus) {
        this.status = nuevoStatus;
    }

    /**
     * Regresa la fechaEmision en la que el pedido fue creado.
     * @return La fechaEmision en la que el pedido fue creado.
     */
    public final Date getFechaEmision() {
        return fechaEmision;
    }

    /**
     * Le asigna una nueva fechaEmision al pedido.
     * @param nuevaFecha La nueva fechaEmision del pedido.
     */
    public final void setFechaEmision(final Date nuevaFecha) {
        this.fechaEmision = nuevaFecha;
    }

    /**
     * Regresa el ID del profesor.
     * @return El ID del profesor.
     */
    public final String getProfesorId() {
        return profesorId;
    }

    /**
     * Le asigna un nuevo ID de profesor al pedido.
     * @param nuevoProfesorId El nuevo ID de profesor.
     */
    public final void setProfesorId(final String nuevoProfesorId) {
        this.profesorId = nuevoProfesorId;
    }

    /**
     * Regresa el ID del laboratorio.
     * @return El ID del laboratorio.
     */
    public final String getLaboratorioId() {
        return laboratorioId;
    }

    /**
     * Le asigna un nuevo ID de laboratorio al pedido.
     * @param nuevoLaboratorioId El nuevo ID de laboratorio.
     */
    public final void setLaboratorioId(final String nuevoLaboratorioId) {
        this.laboratorioId = nuevoLaboratorioId;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
    
    public Usuario getUsuario()
    {
        return Context.getUsuario(usuarioId);
    }
    
    public Laboratorio getLaboratorio()
    {
        return Context.getLaboratorio(laboratorioId);
    }
    
    public Usuario getMaestro() {
        return Context.getUsuario(profesorId);
    }
    
    public LinkedList<DetalleMaterial> getDetallesMaterial(){
        return Context.getDetalleMaterial(id);
    }
    
    public LinkedList<DetalleEquipo> getDetallesEquipo(){
        return Context.getDetalleEquipo(id);
    }
    
    public LinkedList<DetalleReactivo> getDetallesReactivo(){
        return Context.getDetalleReactivo(id);
    }
    
    public LinkedList<DetalleConsumible> getDetalleConsumible(){
        return Context.getDetalleConsumible(id);
    }
}
