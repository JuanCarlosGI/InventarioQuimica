package models;

/**
 * @author Juan Carlos Guzmán Islas
 */
public class DetalleMaterial {
    /**
     * Cantidad de unidades que se estan pidiendo.
     */
    private int cantidad;

    /**
     * Observaciones sobre el equipo que se pide.
     */
    private String observaciones;

    /**
     * Cantidad que fue regresada con el pedido.
     */
    private int cantidadRegresada;

    /**
     * ID del pedido al que el detalle pertenece.
     */
    private int pedidoId;

    /**
     * Clave del material al que se hace referencia.
     */
    private String materialId;

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
     * Regresa el valor de cantidadRegresada.
     * @return El valor de cantidadRegresada.
     */
    public final int getCantidadRegresada() {
        return cantidadRegresada;
    }

    /**
     * Asigna el valor de cantidadRegresada.
     * @param nuevaCantidadRegresada El nuevo valor de cantidadRegresada.
     */
    public final void setCantidadRegresada(final int nuevaCantidadRegresada) {
        this.cantidadRegresada = nuevaCantidadRegresada;
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
     * Regresa el valor de materialId.
     * @return El valor de materialId.
     */
    public final String getMaterialId() {
        return materialId;
    }

    /**
     * Asigna el valor de materialId.
     * @param nuevoMaterialId En nuevo valor de materialId.
     */
    public final void setMaterialId(final String nuevoMaterialId) {
        this.materialId = nuevoMaterialId;
    }
}