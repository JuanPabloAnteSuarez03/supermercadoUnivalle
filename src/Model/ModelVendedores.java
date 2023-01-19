/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Leon
 */
public class ModelVendedores {
    
    private int codigoVendedor;
    private int cedula;
    private String nombre;
    private String telefono;
    private int comision;
    private String fechaCrea;
    private String estadoVendedor;

    public ModelVendedores() {
    }

    public ModelVendedores(int codigoVendedor, int cedula, String nombre, String telefono, int comision, String fechaCrea, String estadoVendedor) {
        this.codigoVendedor = codigoVendedor;
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.comision = comision;
        this.fechaCrea = fechaCrea;
        this.estadoVendedor = estadoVendedor;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getCodigoVendedor() {
        return codigoVendedor;
    }

    public void setCodigoVendedor(int codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getComision() {
        return comision;
    }

    public void setComision(int comision) {
        this.comision = comision;
    }

    public String getFechaCrea() {
        return fechaCrea;
    }

    public void setFechaCrea(String fechaCrea) {
        this.fechaCrea = fechaCrea;
    }

    public String getEstadoVendedor() {
        return estadoVendedor;
    }

    public void setEstadoVendedor(String estadoVendedor) {
        this.estadoVendedor = estadoVendedor;
    }
    

}
