/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Leon
 */
public class MateriaProducto {
    
    private int idMateria;
    private int codigoProducto;
    private int codigoMateria;
    private String descripcionMateria;
    private int cantidad;
    private int presentacion;

    public MateriaProducto() {
    }

    public MateriaProducto(int idMateria, int codigoProducto, int codigoMateria, String descripcionMateria, int cantidad, int presentacion) {
        this.idMateria = idMateria;
        this.codigoProducto = codigoProducto;
        this.codigoMateria = codigoMateria;
        this.descripcionMateria = descripcionMateria;
        this.cantidad = cantidad;
        this.presentacion = presentacion;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public int getCodigoMateria() {
        return codigoMateria;
    }

    public void setCodigoMateria(int codigoMateria) {
        this.codigoMateria = codigoMateria;
    }

    public String getDescripcionMateria() {
        return descripcionMateria;
    }

    public void setDescripcionMateria(String descripcionMateria) {
        this.descripcionMateria = descripcionMateria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(int presentacion) {
        this.presentacion = presentacion;
    }
    
    
    
}
