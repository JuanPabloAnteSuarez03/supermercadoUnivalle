/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Leon
 */
public class PagoComisiones {
    
    private int codigoPago;
    private int codigoVendedor;
    private String nombreVendedor;
    private int comision;
    private String fechaPago;
    private String estado;

    public PagoComisiones() {
    }

    public PagoComisiones(int codigoPago, int codigoVendedor, String nombreVendedor, int comision, String fechaPago, String estado) {
        this.codigoPago = codigoPago;
        this.codigoVendedor = codigoVendedor;
        this.nombreVendedor = nombreVendedor;
        this.comision = comision;
        this.fechaPago = fechaPago;
        this.estado = estado;
    }

    public int getCodigoPago() {
        return codigoPago;
    }

    public void setCodigoPago(int codigoPago) {
        this.codigoPago = codigoPago;
    }

    public int getCodigoVendedor() {
        return codigoVendedor;
    }

    public void setCodigoVendedor(int codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
    }

    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public int getComision() {
        return comision;
    }

    public void setComision(int comision) {
        this.comision = comision;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
