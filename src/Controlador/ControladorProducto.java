/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Dao.ProductoDao;
import Model.FactorMateria;
import Model.FactorProducto;
import java.util.List;
import vista.Productos;
import Model.Producto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juanp
 */
public class ControladorProducto {

    private Productos vista;
    private ProductoDao sql;
    List<Producto> producto;
    List<FactorProducto> factorProductoCombo;

    DefaultTableModel model = new DefaultTableModel();

    public ControladorProducto() {
    }

    public ControladorProducto(ProductoDao sql, Productos vista) {
        this.vista = vista;
        this.sql = sql;

        vista.setVisible(true);
        vista.setLocationRelativeTo(null);

        this.vista.addBtnAgregar(new CalculateListener());
        this.vista.addBtnEditar(new CalculateListener());
        this.vista.addBtnEliminar(new CalculateListener());
        this.vista.addBtnMateria(new CalculateListener());

        model.addColumn("ID");
        model.addColumn("Fecha");
        model.addColumn("Nombre");
        model.addColumn("Presentacion");
        model.addColumn("Precio");

        listarMateria();
        rellenarCombo();
    }

    public void listarMateria() {
        try {
            vista.limpiarListadoTabla();
            producto = sql.listadoProducto();

            for (int i = 0; i < producto.size(); i++) {
                model.addRow(new Object[]{producto.get(i).getCodigo(),
                    producto.get(i).getFecha(), producto.get(i).getDescripcion(),
                    producto.get(i).getPresentacion(), producto.get(i).getPrecio()});
            }

            vista.jTableProducto.setModel(model);
        } catch (Exception ex) {
            vista.displayErrorMessage("Error en la consulta");
        }

    }

    class CalculateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("Agregar")) {
                String nombre = vista.getjTextNombre().getText();
                float precio = Float.parseFloat(vista.getjTextPrecio().getText());
                int posicionPresentacion = vista.jComboPresentacion.getSelectedIndex();
                int idPresentacion = factorProductoCombo.get(posicionPresentacion).getCodigoFactor();
                sql.crearProducto(nombre, idPresentacion, precio);
                listarMateria();
            }
            if (e.getActionCommand().equalsIgnoreCase("Editar")) {
                String nombre = vista.getjTextNombre().getText();
                float precio = Float.parseFloat(vista.getjTextPrecio().getText());
                int id = Integer.parseInt(vista.getjTextId().getText());
                int posicionPresentacion = vista.jComboPresentacion.getSelectedIndex();
                int idPresentacion = factorProductoCombo.get(posicionPresentacion).getCodigoFactor();
                sql.modificarProducto(id, nombre, idPresentacion, precio);
                listarMateria();
            }
            if (e.getActionCommand().equalsIgnoreCase("Eliminar")) {
                int id = Integer.parseInt(vista.getjTextId().getText());
                sql.eliminarProductosFactor(id);
                listarMateria();
            }
            if (e.getActionCommand().equalsIgnoreCase("Materia Prima")) {

            }
        }

    }

    public void rellenarCombo() {
        String nombre;
        try {
            vista.jComboPresentacion.removeAllItems();
            factorProductoCombo = sql.listadoComboProductoFactor();
            for (int i = 0; i < factorProductoCombo.size(); i++) {
                nombre = factorProductoCombo.get(i).getDescripcionFactor();
                vista.jComboPresentacion.addItem(nombre);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar ComboBox" + e);
        }
    }

}
