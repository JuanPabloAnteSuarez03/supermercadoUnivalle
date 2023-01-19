/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Dao.ProveedoresDAO;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import vista.Proveedores;
import Model.ModeloProveedores;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Leon
 */
public class ControladorProveedores {
    
    private ProveedoresDAO sql;
    private Proveedores vista;
 
 
    List<ModeloProveedores> proveedores;
    
    DefaultTableModel model = new DefaultTableModel();

    public ControladorProveedores() {
    }
    

    public ControladorProveedores(ProveedoresDAO sql, Proveedores vista) {
        this.sql = sql;
        this.vista = vista;
        
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        
        this.vista.addBtnAgregar(new CalculateListener());
        this.vista.addBtnEditar(new CalculateListener());
        this.vista.addBtnEliminar(new CalculateListener());
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Nit");
        model.addColumn("Telefono");
        listarProveedores();
        
    }

    public void listarProveedores() {
        try {
            vista.limpiarListadoTabla();
            proveedores = sql.listadoProvedores();

            for (int i = 0; i < proveedores.size(); i++) {
                model.addRow(new Object[]{proveedores.get(i).getCodigo(),
                    proveedores.get(i).getNombre(),
                    proveedores.get(i).getNit(), 
                    proveedores.get(i).getTelefono()});
            }

            vista.jTableProveedores.setModel(model);
        } catch (Exception ex) {
            vista.displayErrorMessage("Error en la consulta");
        }
    }
    
    class CalculateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getActionCommand().equalsIgnoreCase("Agregar")) {
                
                String nombre;    
                String nit;
                String telefono;
                 
                nombre = vista.getjTextNombre().getText();
                nit = vista.getjTextNit().getText();
                telefono = vista.getjTextTelefono().getText();
                
                int nitNum = Integer.parseInt(nit);
                int telefonoNum = Integer.parseInt(telefono);
                
                sql.crearProovedores(nombre, nitNum , telefonoNum);
                listarProveedores();
            }

            if (e.getActionCommand().equalsIgnoreCase("Editar")) {
                int codigo = vista.codigo;
                String nombre = vista.getjTextNombre().getText();
                String nit = vista.getjTextNit().getText();
                String telefono = vista.getjTextTelefono().getText();
                
                int nitNum = Integer.parseInt(nit);
                int telefonoNum = Integer.parseInt(telefono);
                
                if (codigo != 0) {
                    sql.modificarProveedores(codigo, nombre, nitNum, telefonoNum);
                    listarProveedores();
                } else {
                    JOptionPane.showMessageDialog(null, "Por favot seleccione el registro a editar");
                }
            }

            if (e.getActionCommand().equalsIgnoreCase("Eliminar")) {
                int codigo = vista.codigo;
                if (codigo != 0) {
                    sql.eliminarProveedores(codigo);
                    listarProveedores();
                    vista.setCodigo(0);
                } else {
                    JOptionPane.showMessageDialog(null, "Por favot seleccione el registro a eliminar");
                }
            }
        }
    }

}
