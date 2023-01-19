/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import Controlador.*;
import Dao.*;
import Vista.Clientes;
import vista.*;

/**
 *
 * @author juanp
 */
public class Navegacion {

    private int inicio = 0;

    public Navegacion() {
    }

    public void inicio() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    public void llamarClientes() {
        Clientes vista = new Clientes();
        ClientesDAO clientes = new ClientesDAO();
        ControladorClientes controladorClientes = new ControladorClientes(clientes, vista);
    }

    public void llamarFactorMateria() {
        Pmt vista = new Pmt();
        FactorMateriaDAO factorMateria = new FactorMateriaDAO();
        ControladorFactorMateria controladorFactorMateria = new ControladorFactorMateria(factorMateria, vista);
    }

    public void llamarFactorProductos() {
        PresentacionProducto vista = new PresentacionProducto();
        FactorProductoDAO producto = new FactorProductoDAO();
        ControladorFactorProducto controladorFactorProducto = new ControladorFactorProducto(producto, vista);
    }

    public void llamarMateriaMast() {
        MateriaPrima vista = new MateriaPrima();
        MateriaDAO materia = new MateriaDAO();
        ControladorMateriaMast controladorMateriaMast = new ControladorMateriaMast(materia, vista);
    }

    public void llamarProducto() {
        Productos vista = new Productos();
        ProductoDao producto = new ProductoDao();
        ControladorProducto controladorProducto = new ControladorProducto(producto, vista);
    }

    public void llamarProveedores() {
        Proveedores vista = new Proveedores();
        ProveedoresDAO producto = new ProveedoresDAO();
        ControladorProveedores controladorProducto = new ControladorProveedores(producto, vista);
    }

    public void llamarVendedores() {
        Vendedores vista = new Vendedores();
        VendedoresDAO vendedores = new VendedoresDAO();
        ControladorVendedores controladorVendedores = new ControladorVendedores(vendedores, vista);
    }

}
