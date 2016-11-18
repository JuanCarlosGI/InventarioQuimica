package models;

/**
 * Clase representando un reactivo del laboratorio.
 * @author Juan Carlos Guzmán Islas
 */
public class Reactivo {
    /**
     * La clave del reactivo.
     */
    private String clave;

    /**
     * El nombre del reactivo.
     */
    private String nombre;

    /**
     * La marca del reactivo.
     */
    private String marca;

    /**
     * La presentación del reactivo.
     */
    private String presentacion;

    /**
     * El contenido del reactivo.
     */
    private String contenido;

    /**
     * La localizacion del reactivo.
     */
    private String localizacion;

    /**
     * La descripción del reactivo.
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
}
