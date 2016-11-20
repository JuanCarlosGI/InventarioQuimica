package models;

/**
 * @author Juan Carlos Guzmán Islas
 */
public class DetalleConsumible {
    /**
     * Cantidad de unidades que se estan pidiendo.
     */
    private int cantidad;

    /**
     * Observaciones sobre el consumible que se pide.
     */
    private String observaciones;

    /**
     * ID del pedido al que el detalle pertenece.
     */
    private int pedidoId;

    /**
     * Clave del consumible al que se hace referencia.
     */
    private String consumibleId;

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
     * Regresa el valor de consumibleId.
     * @return El valor de consumibleId.
     */
    public final String getConsumibleId() {
        return consumibleId;
    }

    /**
     * Asigna el valor de consumibleId.
     * @param nuevoConsumibleId En nuevo valor de consumibleId.
     */
    public final void setconsumibleId(final String nuevoConsumibleId) {
        this.consumibleId = nuevoConsumibleId;
    }
}