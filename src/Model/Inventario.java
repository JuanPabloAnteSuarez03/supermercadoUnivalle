/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Leon
 */
public class Inventario {
    
    private int codigoInventario;
    private int codigoProducto;
    private String producto;
    private int codigoPresentacion;
    private String presentacion;
    private String fechaCrea;
    private int cantidad;
    private String estado;

    public Inventario() {
    }

    public Inventario(int codigoInventario, int codigoProducto, String producto, int codigoPresentacion, String presentacion, String fechaCrea, int cantidad, String estado) {
        this.codigoInventario = codigoInventario;
        this.codigoProducto = codigoProducto;
        this.producto = producto;
        this.codigoPresentacion = codigoPresentacion;
        this.presentacion = presentacion;
        this.fechaCrea = fechaCrea;
        this.cantidad = cantidad;
        this.estado = estado;
    }

    public int getCodigoInventario() {
        return codigoInventario;
    }

    public void setCodigoInventario(int codigoInventario) {
        this.codigoInventario = codigoInventario;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCodigoPresentacion() {
        return codigoPresentacion;
    }

    public void setCodigoPresentacion(int codigoPresentacion) {
        this.codigoPresentacion = codigoPresentacion;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getFechaCrea() {
        return fechaCrea;
    }

    public void setFechaCrea(String fechaCrea) {
        this.fechaCrea = fechaCrea;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
