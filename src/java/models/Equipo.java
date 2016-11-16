package models;

/**
 * Clase que representaa una pieza de equipo.
 * @author Juan Carlos Guzmán Islas
 */
public class Equipo {
    /**
     * Clave del equipo.
     */
    private String clave;

    /**
     * Nombre del equipo.
     */
    private String nombre;

    /**
     * Marca del equipo.
     */
    private String marca;

    /**
     * Cantidad de este equipo que se tiene.
     */
    private int cantidad;

    /**
     * Descripción del equipo.
     */
    private String descripcion;

    /**
     * Regresa el valor de clave.
     * @return El valor de clave.
     */
    public final String getClave() {
        return clave;
    }

    /**
     * Asigana el valor de clave.
     * @param nuevaClave El nuevo valor de clave.
     */
    public final void setClave(final String nuevaClave) {
        this.clave = nuevaClave;
    }

    /**
     * Regresa el valor de nombre.
     * @return El valor de nombre.
     */
    public final String getNombre() {
        return nombre;
    }

    /**
     * Agigna el vaolor de nombre.
     * @param nuevoNombre El nuevo valor de nombre.
     */
    public final void setNombre(final String nuevoNombre) {
        this.nombre = nuevoNombre;
    }

    /**
     * Regresa el valor de marca.
     * @return El valor de marca.
     */
    public final String getMarca() {
        return marca;
    }

    /**
     * Asigna el valor de marca.
     * @param nuevaMarca El nevo valor de marca.
     */
    public final void setMarca(final String nuevaMarca) {
        this.marca = nuevaMarca;
    }

    /**
     * Regresa el valor de cantidad.
     * @return El valor de cantidad.
     */
    public final int getCantidad() {
        return cantidad;
    }

    /**
     * Asigna el valor de cantidad.
     * @param nuevaCantidad El nuevo valor de cantidad.
     */
    public final void setCantidad(final int nuevaCantidad) {
        this.cantidad = nuevaCantidad;
    }

    /**
     * Regresa el valor de descripcion.
     * @return El valor de descripcion.
     */
    public final String getDescripcion() {
        return descripcion;
    }

    /**
     * Asigna el valor de descripcion.
     * @param nuevaDescripcion El nuevo valor de descripcion.
     */
    public final void setDescripcion(final String nuevaDescripcion) {
        this.descripcion = nuevaDescripcion;
    }
}