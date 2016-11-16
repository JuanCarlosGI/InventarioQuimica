package models;

import java.sql.Date;

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
    private Date fecha;

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
    public final void setId(int nuevoId) {
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
     * Regresa la fecha en la que el pedido fue creado.
     * @return La fecha en la que el pedido fue creado.
     */
    public final Date getFecha() {
        return fecha;
    }

    /**
     * Le asigna una nueva fecha al pedido.
     * @param nuevaFecha La nueva fecha del pedido.
     */
    public final void setFecha(final Date nuevaFecha) {
        this.fecha = nuevaFecha;
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
}
