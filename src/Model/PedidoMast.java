/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Leon
 */
public class PedidoMast {
    
    private int codigoPedido;
    private int codigoCliente;
    private int codigoVendedor;
    private String fechaCrea;
    private int totalPedido;
    private String estadoComision;
    private int comision;
    private String lugar;
    private String observacion;
    private String estadoPedido;

    public PedidoMast() {
    }

    public PedidoMast(int codigoPedido, int codigoCliente, int codigoVendedor, String fechaCrea, int totalPedido, String estadoComision, int comision, String lugar, String observacion, String estadoPedido) {
        this.codigoPedido = codigoPedido;
        this.codigoCliente = codigoCliente;
        this.codigoVendedor = codigoVendedor;
        this.fechaCrea = fechaCrea;
        this.totalPedido = totalPedido;
        this.estadoComision = estadoComision;
        this.comision = comision;
        this.lugar = lugar;
        this.observacion = observacion;
        this.estadoPedido = estadoPedido;
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public int getCodigoVendedor() {
        return codigoVendedor;
    }

    public void setCodigoVendedor(int codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
    }

    public String getFechaCrea() {
        return fechaCrea;
    }

    public void setFechaCrea(String fechaCrea) {
        this.fechaCrea = fechaCrea;
    }

    public int getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(int totalPedido) {
        this.totalPedido = totalPedido;
    }

    public String getEstadoComision() {
        return estadoComision;
    }

    public void setEstadoComision(String estadoComision) {
        this.estadoComision = estadoComision;
    }

    public int getComision() {
        return comision;
    }

    public void setComision(int comision) {
        this.comision = comision;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(String estadoPedido) {
        this.estadoPedido = estadoPedido;
    }
       
}
