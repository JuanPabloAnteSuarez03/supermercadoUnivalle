/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Leon
 */
public class PedidoItem {
    
    private int codigoItem;
    private int codigoProducto;
    private int cantidad;
    private int codigoPresentacion;
    private int precioUnidad;
    private int totalPrecio;
    private String estadoItem;

    public PedidoItem() {
    }

    public PedidoItem(int codigoItem, int codigoProducto, int cantidad, int codigoPresentacion, int precioUnidad, int totalPrecio, String estadoItem) {
        this.codigoItem = codigoItem;
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
        this.codigoPresentacion = codigoPresentacion;
        this.precioUnidad = precioUnidad;
        this.totalPrecio = totalPrecio;
        this.estadoItem = estadoItem;
    }

    public int getCodigoItem() {
        return codigoItem;
    }

    public void setCodigoItem(int codigoItem) {
        this.codigoItem = codigoItem;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCodigoPresentacion() {
        return codigoPresentacion;
    }

    public void setCodigoPresentacion(int codigoPresentacion) {
        this.codigoPresentacion = codigoPresentacion;
    }

    public int getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(int precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public int getTotalPrecio() {
        return totalPrecio;
    }

    public void setTotalPrecio(int totalPrecio) {
        this.totalPrecio = totalPrecio;
    }

    public String getEstadoItem() {
        return estadoItem;
    }

    public void setEstadoItem(String estadoItem) {
        this.estadoItem = estadoItem;
    }  
        
}
