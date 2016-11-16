package models;

/**
 * Clase que representa a un material del laboratorio.
 * @author Juan Carlos Guzmán Islas
 */
public class Material {
    /**
     * La clave del material.
     */
    private String clave;

    /**
     * El nombre del material.
     */
    private String nombre;

    /**
     * La marca del material.
     */
    private String marca;

    /**
     * La capacidad del material.
     */
    private String capacidad;

    /**
     * La localización del material.
     */
    private String localizacion;

    /**
     * La cantidad disponible del material.
     */
    private int cantidad;

    /**
     * La descripcion del material.
     */
    private String descripcion;

    /**
     * Regresa la clave del material.
     * @return La clave del maerial.
     */
    public final String getClave() {
        return clave;
    }

    /**
     * Le asigna una nueva clave al material.
     * @param nuevaClave La nueva clave del material.
     */
    public final void setClave(final String nuevaClave) {
        this.clave = nuevaClave;
    }

    /**
     * Regresa el nombre del material.
     * @return El nombre del material.
     */
    public final String getNombre() {
        return nombre;
    }

    /**
     * Le assigna un nuevo nombre al material.
     * @param nuevoNombre El nuevo nombre del material.
     */
    public final void setNombre(final String nuevoNombre) {
        this.nombre = nuevoNombre;
    }

    /**
     * Regresa la marca del material.
     * @return La marca del material.
     */
    public final String getMarca() {
        return marca;
    }

    /**
     * Le asigna una nueva marca al material.
     * @param nuevaMarca La nueva marca del material.
     */
    public final void setMarca(final String nuevaMarca) {
        this.marca = nuevaMarca;
    }

    /**
     * Regresa la capacidad del material.
     * @return La capacidad del material.
     */
    public final String getCapacidad() {
        return capacidad;
    }

    /**
     * Le asigna una nueva capacidad al material.
     * @param nuevaCapacidad La nueva capacidad del material.
     */
    public final void setCapacidad(final String nuevaCapacidad) {
        this.capacidad = nuevaCapacidad;
    }

    /**
     * Regresa la localización del material.
     * @return La localización del material.
     */
    public final String getLocalizacion() {
        return localizacion;
    }

    /**
     * Le asigna una nueva localización al material.
     * @param nuevaLocalizacion La nueva localización del material.
     */
    public final void setLocalizacion(final String nuevaLocalizacion) {
        this.localizacion = nuevaLocalizacion;
    }

    /**
     * Regresa la cantidad que hay del material.
     * @return La cantidad que hay del material.
     */
    public final int getCantidad() {
        return cantidad;
    }

    /**
     * Le asigna una nueva cantidad al material.
     * @param nuevaCantidad La nueva cantidad del material.
     */
    public final void setCantidad(final int nuevaCantidad) {
        this.cantidad = nuevaCantidad;
    }

    /**
     * Regresa la descripcion del material.
     * @return La descripcion del material.
     */
    public final String getDescripcion() {
        return descripcion;
    }

    /**
     * Le asigna una nueva descripcion al material.
     * @param nuevaDescripcion La nueva descripcion del material.
     */
    public final void setDescripcion(final String nuevaDescripcion) {
        this.descripcion = nuevaDescripcion;
    }
}