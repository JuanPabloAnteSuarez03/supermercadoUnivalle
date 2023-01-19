/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Leon
 */
public class ModeloProveedores {
    
    private int codigo;
    private String nombre;
    private String fechaCrea;
    private int nit;
    private int telefono;
    private String estadoFactor;

    public ModeloProveedores() {
    }

    public ModeloProveedores(int codigo, String fechaCrea, int nit, int telefono, String estadoFactor) {
        this.codigo = codigo;
        this.fechaCrea = fechaCrea;
        this.nit = nit;
        this.telefono = telefono;
        this.estadoFactor = estadoFactor;
    }



    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaCrea() {
        return fechaCrea;
    }

    public void setFechaCrea(String fechaCrea) {
        this.fechaCrea = fechaCrea;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEstadoFactor() {
        return estadoFactor;
    }

    public void setEstadoFactor(String estadoFactor) {
        this.estadoFactor = estadoFactor;
    }
    
}
