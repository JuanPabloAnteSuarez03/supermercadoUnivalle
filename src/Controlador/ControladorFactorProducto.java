/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Dao.FactorMateriaDAO;
import Dao.FactorProductoDAO;
import Model.FactorMateria;
import Model.FactorProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vista.Pmt;
import vista.PresentacionProducto;

/**
 *
 * @author joset
 */

  public class ControladorFactorProducto {

    private FactorProductoDAO sql;
    private PresentacionProducto vista;
    List<FactorProducto> factorProducto;

    DefaultTableModel model = new DefaultTableModel();

    public ControladorFactorProducto(FactorProductoDAO sql, PresentacionProducto vista) {
        this.sql = sql;
        this.vista = vista;

        vista.setVisible(true);
        vista.setLocationRelativeTo(null);

        this.vista.addBtnAgregar(new Controlador.ControladorFactorProducto.CalculateListener());
        this.vista.addBtnEditar(new Controlador.ControladorFactorProducto.CalculateListener());
        this.vista.addBtnEliminar(new Controlador.ControladorFactorProducto.CalculateListener());
        model.addColumn("Codigo");
        model.addColumn("Descripcion");
        model.addColumn("Fecha Creacion");
        listarProductoFactor();
    }

     public ControladorFactorProducto() {
    }

    public void listarProductoFactor() {
        try {
            vista.limpiarListadoTabla();
            factorProducto = sql.listadoProductoFactor();

            for (int i = 0; i < factorProducto.size(); i++) {
                model.addRow(new Object[]{factorProducto.get(i).getCodigoFactor(),
                    factorProducto.get(i).getDescripcionFactor(),
                    factorProducto.get(i).getFechaCrea()});
            }

            vista.jTablePresentacionProducto.setModel(model);
        } catch (Exception ex) {
            vista.displayErrorMessage("Error en la consulta");
        }
    }

    class CalculateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getActionCommand().equalsIgnoreCase("Agregar")) {

                String descripcion;

                descripcion = vista.getjTextDescripcion().getText();
                sql.crearProductoFactor(descripcion);
                listarProductoFactor();
            }

            if (e.getActionCommand().equalsIgnoreCase("Editar")) {
                int codigo = vista.codigo;
                String descripcion = vista.getjTextDescripcion().getText();
                if (codigo != 0) {
                    sql.modificarProductoFactor(codigo, descripcion);
                    listarProductoFactor();
                } else {
                    JOptionPane.showMessageDialog(null, "Por favot seleccione el registro a editar");
                }
            }

            if (e.getActionCommand().equalsIgnoreCase("Eliminar")) {
                int codigo = vista.codigo;
                if (codigo != 0) {
                    sql.eliminarProductosFactor(codigo);
                    listarProductoFactor();
                  //  vista.setCodigo(0);
                } else {
                    JOptionPane.showMessageDialog(null, "Por favot seleccione el registro a eliminar");
                }
            }
        }
    }
    
    
    
    
}
