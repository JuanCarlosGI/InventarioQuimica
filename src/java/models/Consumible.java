package models;

import data.Context;
import java.util.List;

/**
 * Clase representando un consumible del laboratorio.
 * @author Juan Carlos Guzmán Islas
 */
public class Consumible {
    /**
     * La clave del consumible.
     */
    private String clave;

    /**
     * El nombre del consumible.
     */
    private String nombre;

    /**
     * La marca del consumible.
     */
    private String marca;

    /**
     * La presentación del consumible.
     */
    private String presentacion;

    /**
     * El contenido del consumible.
     */
    private String contenido;

    /**
     * La localizacion del consumible.
     */
    private String localizacion;

    /**
     * La descripción del consumible.
     */
    private String descripcion;

    /**
     * La cantidad disponible que se tiene.
     */
    private int cantidad;

    /**
     * Getter de clave.
     * @return La clave.
     */
    public final String getClave() {
        return clave;
    }

    /**
     * Setter de clave.
     * @param nuevaClave La nueva clave.
     */
    public final void setClave(final String nuevaClave) {
        this.clave = nuevaClave;
    }

    /**
     * Getter de nombre.
     * @return El nombre.
     */
    public final String getNombre() {
        return nombre;
    }

    /**
     * Setter de nombre.
     * @param nuevoNombre El nuevo nombre.
     */
    public final void setNombre(final String nuevoNombre) {
        this.nombre = nuevoNombre;
    }

    /**
     * Getter de marca.
     * @return La marca.
     */
    public final String getMarca() {
        return marca;
    }

    /**
     * Setter de marca.
     * @param nuevaMarca La nueva marca.
     */
    public final void setMarca(final String nuevaMarca) {
        this.marca = nuevaMarca;
    }

    /**
     * Getter de presentacion.
     * @return La presentacion.
     */
    public final String getPresentacion() {
        return presentacion;
    }

    /**
     * Setter de presentacion.
     * @param nuevaPresentacion La nueva presentacion.
     */
    public final void setPresentacion(final String nuevaPresentacion) {
        this.presentacion = nuevaPresentacion;
    }

    /**
     * Getter de contenido.
     * @return El contenido.
     */
    public final String getContenido() {
        return contenido;
    }

    /**
     * Setter de contenido.
     * @param nuevoContenido El nuevo contenido.
     */
    public final void setContenido(final String nuevoContenido) {
        this.contenido = nuevoContenido;
    }

    /**
     * Getter de localizacion.
     * @return La localizacion.
     */
    public final String getLocalizacion() {
        return localizacion;
    }

    /**
     * Setter de localizacion.
     * @param nuevaLocalizacion La nueva localizacion.
     */
    public final void setLocalizacion(final String nuevaLocalizacion) {
        this.localizacion = nuevaLocalizacion;
    }

    /**
     * Getter de descripcion.
     * @return La descripcion.
     */
    public final String getDescripcion() {
        return descripcion;
    }

    /**
     * Setter de descripcion.
     * @param nuevaDescripcion La nueva descripcion.
     */
    public final void setDescripcion(final String nuevaDescripcion) {
        this.descripcion = nuevaDescripcion;
    }

    /**
     * Getter de cantidad.
     * @return La cantidad.
     */
    public final int getCantidad() {
        return cantidad;
    }

    /**
     * Setter de cantidad.
     * @param nuevaCantidad La nueva cantidad.
     */
    public final void setCantidad(final int nuevaCantidad) {
        this.cantidad = nuevaCantidad;
    }

    /**
     * Obtiene la lista de detalleConsumible que tienen como consumible a este
     * consumible.
     * @return La lista de detalles.
     *
    public final List<DetalleConsumible> getDetalleConsumibles() {
        return Context.getDetallesConsumibles().removeIf(c -> c.getConsumibleId() != clave);
    }*/
}
