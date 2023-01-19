/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Dao.MateriaDAO;
import Model.FactorMateria;
import Model.Materia;
import Model.ModeloProveedores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vista.MateriaPrima;

/**
 *
 * @author juanc
 */
public class ControladorMateriaMast {

    private MateriaDAO sql;
    private MateriaPrima vista;
    List<Materia> materia;
    List<ModeloProveedores> proveedor;
    List<FactorMateria> factorMateria;
    List<ModeloProveedores> proveedorCombo;
    List<FactorMateria> factorMateriaCombo;

    DefaultTableModel model = new DefaultTableModel();

    public ControladorMateriaMast(MateriaDAO sql, MateriaPrima vista) {
        
        materia = sql.listadoMateriar();
        
        this.sql = sql;
        this.vista = vista;
        
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        
        this.vista.addBtnAgregar(new CalculateListener());
        this.vista.addBtnEditar(new CalculateListener());
        this.vista.addBtnEliminar(new CalculateListener());
        
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Codigo");
        model.addColumn("Presentacion");
        model.addColumn("Cantidad");
        model.addColumn("Proveedor");
        model.addColumn("Precio C/U");
        model.addColumn("Precio Total");
        model.addColumn("Fecha");
        
        listar();
        set();
        listarMateria();
        rellenarCombo();
    }

    public ControladorMateriaMast() {
    }

    public void listarMateria() {
        try {
            vista.limpiarListadoTabla();
            materia = sql.listadoMateriar();
            set();

            for (int i = 0; i < materia.size(); i++) {
                model.addRow(new Object[]{materia.get(i).getId(),
                    materia.get(i).getNombre(), materia.get(i).getCodigo(),
                    materia.get(i).getPresentacion(), materia.get(i).getCantidad(),
                    materia.get(i).getProveedor(), materia.get(i).getPrecio(),
                    materia.get(i).getPrecioTotal(), materia.get(i).getFecha()});
            }

            vista.jTableMateria.setModel(model);
        } catch (Exception ex) {
            vista.displayErrorMessage("Error en la consulta");
        }

    }

    class CalculateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("Agregar")) {
                String nombre = vista.getjTextNombre().getText();
                int codigo = Integer.parseInt(vista.getjTextCodigo().getText());
                float precio = Float.parseFloat(vista.getjTextPrecio().getText());
                int cantidad = Integer.parseInt(vista.getjTextCantidad().getText());
                int posicionPresentacion = vista.jComboPresentacion.getSelectedIndex();
                int idPresentacion = factorMateriaCombo.get(posicionPresentacion).getCodigoFactor();
                int posicionProveedor = vista.jComboProveedor.getSelectedIndex();
                int idProveedor = proveedorCombo.get(posicionProveedor).getCodigo();
                sql.crearProductoFactor(nombre, codigo, idPresentacion, cantidad, idProveedor, precio);
                listarMateria();
            }
            if (e.getActionCommand().equalsIgnoreCase("Editar")) {
                int id = Integer.parseInt(vista.getjTextId().getText());
                String nombre = vista.getjTextNombre().getText();
                int codigo = Integer.parseInt(vista.getjTextCodigo().getText());
                float precio = Float.parseFloat(vista.getjTextPrecio().getText());
                int cantidad = Integer.parseInt(vista.getjTextCantidad().getText());
                int posicionPresentacion = vista.jComboPresentacion.getSelectedIndex();
                int idPresentacion = factorMateriaCombo.get(posicionPresentacion).getCodigoFactor();
                int posicionProveedor = vista.jComboProveedor.getSelectedIndex();
                int idProveedor = proveedorCombo.get(posicionProveedor).getCodigo();
                sql.modificarProductoFactor(id, nombre, codigo, idPresentacion, cantidad, idProveedor, precio);
                listarMateria();
            }
            if (e.getActionCommand().equalsIgnoreCase("Eliminar")) {
                int id = Integer.parseInt(vista.getjTextId().getText());
                sql.eliminarProductosFactor(id);
                listarMateria();
            }
            if (e.getActionCommand().equalsIgnoreCase("Ver Inventario")) {

            }
        }
    }

    public void set() {
        for (int i = 0; i < materia.size(); i++) {
            for (int j = 0; j < proveedor.size(); j++) {
                if (materia.get(i).getIdProveedor() == proveedor.get(j).getCodigo()) {
                    materia.get(i).setProveedor(proveedor.get(j).getNombre());
                }
            }
            for (int l = 0; l < factorMateria.size(); l++) {
                if (materia.get(i).getIdPresentacion() == factorMateria.get(l).getCodigoFactor()) {
                    materia.get(i).setPresentacion(factorMateria.get(l).getDescripcionFactor());
                }
            }
        }
    }

    public void rellenarCombo() {
        String nombre;
        try {
            vista.jComboProveedor.removeAllItems();
            vista.jComboPresentacion.removeAllItems();
            proveedorCombo = sql.listadoComboProvedores();
            factorMateriaCombo = sql.listadoComboMateriaFactor();
            for (int i = 0; i < proveedorCombo.size(); i++) {
                nombre = proveedorCombo.get(i).getNombre();
                vista.jComboProveedor.addItem(nombre);
            }
            for (int i = 0; i < factorMateriaCombo.size(); i++) {
                nombre = factorMateriaCombo.get(i).getDescripcionFactor();
                vista.jComboPresentacion.addItem(nombre);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar ComboBox" + e);
        }
    }

    public void listar() {

        factorMateria = sql.listadoMateriaFactor();
        proveedor = sql.listadoProvedores();

    }

}
