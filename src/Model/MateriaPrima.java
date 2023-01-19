/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Leon
 */
public class MateriaPrima {
    
    private int codigoMateria;
    private String descripcion;
    private int cantidadMateria;
    private int consumido;

    public MateriaPrima() {
    }

    public MateriaPrima(int codigoMateria, String descripcion, int cantidadMateria, int consumido) {
        this.codigoMateria = codigoMateria;
        this.descripcion = descripcion;
        this.cantidadMateria = cantidadMateria;
        this.consumido = consumido;
    }

    public int getCodigoMateria() {
        return codigoMateria;
    }

    public void setCodigoMateria(int codigoMateria) {
        this.codigoMateria = codigoMateria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidadMateria() {
        return cantidadMateria;
    }

    public void setCantidadMateria(int cantidadMateria) {
        this.cantidadMateria = cantidadMateria;
    }

    public int getConsumido() {
        return consumido;
    }

    public void setConsumido(int consumido) {
        this.consumido = consumido;
    }
    
    
    
}
