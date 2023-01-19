/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Dao.FactorMateriaDAO;
import Model.FactorMateria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vista.Pmt;

/**
 *
 * @author juanp
 */
public class ControladorFactorMateria {

    private FactorMateriaDAO sql;
    private Pmt vista;
    List<FactorMateria> factorMateria;

    DefaultTableModel model = new DefaultTableModel();

    public ControladorFactorMateria(FactorMateriaDAO sql, Pmt vista) {
        this.sql = sql;
        this.vista = vista;

        vista.setVisible(true);
        vista.setLocationRelativeTo(null);

        this.vista.addBtnAgregar(new CalculateListener());
        this.vista.addBtnEditar(new CalculateListener());
        this.vista.addBtnEliminar(new CalculateListener());
        
        model.addColumn("Codigo");
        model.addColumn("Descripcion");
        model.addColumn("Fecha Creacion");
        
        listarMeteriaFactor();
    }

    public ControladorFactorMateria() {
    }

    public void listarMeteriaFactor() {
        try {
            vista.limpiarListadoTabla();
            factorMateria = sql.listadoMateriaFactor();

            for (int i = 0; i < factorMateria.size(); i++) {
                model.addRow(new Object[]{factorMateria.get(i).getCodigoFactor(),
                    factorMateria.get(i).getDescripcionFactor(),
                    factorMateria.get(i).getFechaCrea()});
            }

            vista.jTableFactorMateria.setModel(model);
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
                sql.crearMateriaFactor(descripcion);
                listarMeteriaFactor();
            }

            if (e.getActionCommand().equalsIgnoreCase("Editar")) {
                int codigo = vista.codigo;
                String descripcion = vista.getjTextDescripcion().getText();
                if (codigo != 0) {
                    sql.modificarMateriaFactor(codigo, descripcion);
                    listarMeteriaFactor();
                } else {
                    JOptionPane.showMessageDialog(null, "Por favot seleccione el registro a editar");
                }
            }

            if (e.getActionCommand().equalsIgnoreCase("Eliminar")) {
                int codigo = vista.codigo;
                if (codigo != 0) {
                    sql.eliminarMateriaFactor(codigo);
                    listarMeteriaFactor();
                    vista.setCodigo(0);
                } else {
                    JOptionPane.showMessageDialog(null, "Por favot seleccione el registro a eliminar");
                }
            }
        }
    }

}
