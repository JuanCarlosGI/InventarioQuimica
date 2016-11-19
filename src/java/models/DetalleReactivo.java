package models;

/**
 * @author Juan Carlos Guzmán Islas
 */
public class DetalleReactivo {
    /**
     * Cantidad de unidades que se estan pidiendo.
     */
    private int cantidad;

    /**
     * Observaciones sobre el equipo que se pide.
     */
    private String observaciones;

    /**
     * ID del pedido al que el detalle pertenece.
     */
    private int pedidoId;

    /**
     * Clave del material al que se hace referencia.
     */
    private String reactivoId;

    /**
     * Cantidad de unidades que se regresaron.
     */
    private int cantidadRegresada;

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
     * Regresa el valor de observaciones.
     * @return El valor de observaciones.
     */
    public final String getObservaciones() {
        return observaciones;
    }

    /**
     * Asigna el valor de observaciones.
     * @param nuevasObservaciones El nuevo valor de observaciones.
     */
    public final void setObservaciones(final String nuevasObservaciones) {
        this.observaciones = nuevasObservaciones;
    }

    /**
     * Regresa el valor de pedidoId.
     * @return El valor de pedidoId.
     */
    public final int getPedidoId() {
        return pedidoId;
    }

    /**
     * Asigna el valor de pedidoId.
     * @param nuevoPedidoId El nuevo valor de pedidoID.
     */
    public final void setPedidoId(final int nuevoPedidoId) {
        this.pedidoId = nuevoPedidoId;
    }

    /**
     * Regresa el valor de reactivoId.
     * @return El valor de reactivoId.
     */
    public final String getReactivoId() {
        return reactivoId;
    }

    /**
     * Asigna el valor de reactivoId.
     * @param nuevoReactivoId En nuevo valor de reactivoId.
     */
    public final void setReactivoId(final String nuevoReactivoId) {
        this.reactivoId = nuevoReactivoId;
    }

    /**
     * Getter de cantidadRegesada.
     * @return La cantidad regresada.
     */
    public final int getCantidadRegresada() {
        return cantidadRegresada;
    }

    /**
     * Setter de cantidadRegresada.
     * @param nuevaCantidadRegresada La nueva cantidad regresada.
     */
    public final void setCantidadRegresada(final int nuevaCantidadRegresada) {
        cantidadRegresada = nuevaCantidadRegresada;
    }
}