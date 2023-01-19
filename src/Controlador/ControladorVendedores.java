/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Dao.VendedoresDAO;
import vista.Vendedores;
import Model.ModelVendedores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juanp
 */
public class ControladorVendedores {
    
    private VendedoresDAO sql;
    private Vendedores vista;
    List<ModelVendedores> vendedores;
    
    DefaultTableModel model = new DefaultTableModel();

    public ControladorVendedores(VendedoresDAO sql, Vendedores vista) {
        this.sql = sql;
        this.vista = vista;
        
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        
        this.vista.addBtnAgregar(new CalculateListener());
        this.vista.addBtnEditar(new CalculateListener());
        this.vista.addBtnEliminar(new CalculateListener());
        
        model.addColumn("ID");
        model.addColumn("Cedula");
        model.addColumn("Nombre");
        model.addColumn("Telefono");
        model.addColumn("Comision");
        
        listarVendedores();
    }

    public ControladorVendedores() {
    }
    
    public void listarVendedores() {
        try {
            vista.limpiarListadoTabla();
            vendedores = sql.listadoProvedores();

            for (int i = 0; i < vendedores.size(); i++) {
                model.addRow(new Object[]{vendedores.get(i).getCodigoVendedor(),
                    vendedores.get(i).getCedula(), vendedores.get(i).getNombre(), 
                    vendedores.get(i).getTelefono(), vendedores.get(i).getComision()});
            }

            vista.jTableVendedores.setModel(model);
        } catch (Exception ex) {
            vista.displayErrorMessage("Error en la consulta");
        }
    }
    
    class CalculateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getActionCommand().equalsIgnoreCase("Agregar")) {
                int cedula = Integer.parseInt(vista.getjTextCedula().getText());
                String nombre = vista.getjTextNombre().getText();
                int comision = Integer.parseInt(vista.getjTextComision().getText());
                String telefono = vista.getjTextTelefono().getText();
                sql.crearVendedores(cedula, nombre, telefono, comision);
                listarVendedores();
            }

            if (e.getActionCommand().equalsIgnoreCase("Editar")) {
                int codigo = vista.codigo;
                int cedula = Integer.parseInt(vista.getjTextCedula().getText());
                String nombre = vista.getjTextNombre().getText();
                int comision = Integer.parseInt(vista.getjTextComision().getText());
                String telefono = vista.getjTextTelefono().getText();
                System.out.println(cedula);
                if (codigo != 0) {
                    sql.modificarVendedores( cedula, nombre, telefono, comision);
                    listarVendedores();
                } else {
                    JOptionPane.showMessageDialog(null, "Por favot seleccione el registro a editar");
                }
            }

            if (e.getActionCommand().equalsIgnoreCase("Eliminar")) {
                int codigo = vista.codigo;
                if (codigo != 0) {
                    sql.eliminarVendedores(codigo);
                    listarVendedores();
                    vista.setCodigo(0);
                } else {
                    JOptionPane.showMessageDialog(null, "Por favot seleccione el registro a eliminar");
                }
            }
        }
    }
    
}
