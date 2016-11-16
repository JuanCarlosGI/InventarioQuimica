package models;

/**
 * Clase que representa a un laboratorio
 * @author Juan Carlos Guzmán Islas
 */
public class Laboratorio {
    /**
     * La clave del laboratorio.
     */
    private String clave;

    /**
     * El nombre del laboratorio.
     */
    private String nombre;

    /**
     * Regresa la clave del laboratorio.
     * @return La clave del laboratorio.
     */
    public final String getClave() {
        return clave;
    }

    /**
     * Le asigna al laboratorio una nueva clave.
     * @param nuevaClave La nueva clave del laboratorio.
     */
    public final void setClave(final String nuevaClave) {
        this.clave = nuevaClave;
    }

    /**
     * Regresa el nombre del laboratorio.
     * @return El nombre del laboratorio.
     */
    public final String getNombre() {
        return nombre;
    }

    /**
     * Le asigna al laboratorio un nuevo nombre.
     * @param nuevoNombre El nuevo nombre del laboratorio.
     */
    public final void setNombre(final String nuevoNombre) {
        this.nombre = nuevoNombre;
    }
}
