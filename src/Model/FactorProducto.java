/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author User
 */
public class FactorProducto {
    private int codigoFactor;
    private String descripcionFactor;
    private String fechaCrea;
    private String estadoFactor;

    public FactorProducto() {
    }

    public FactorProducto(int codigoFactor, String descripcionFactor) {
        this.codigoFactor = codigoFactor;
        this.descripcionFactor = descripcionFactor;
    }

    public int getCodigoFactor() {
        return codigoFactor;
    }

    public void setCodigoFactor(int codigoFactor) {
        this.codigoFactor = codigoFactor;
    }

    public String getDescripcionFactor() {
        return descripcionFactor;
    }

    public void setDescripcionFactor(String descripcionFactor) {
        this.descripcionFactor = descripcionFactor;
    }

    public String getFechaCrea() {
        return fechaCrea;
    }

    public void setFechaCrea(String fechaCrea) {
        this.fechaCrea = fechaCrea;
    }

    public String getEstadoFactor() {
        return estadoFactor;
    }

    public void setEstadoFactor(String estadoFactor) {
        this.estadoFactor = estadoFactor;
    }
    
    
    
}
