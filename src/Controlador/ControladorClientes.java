/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Dao.ClientesDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Model.ModeloClientes;
import Vista.Clientes;

/**
 *
 * @author juanc
 */
public class ControladorClientes {

    private ClientesDAO sql;
    private Clientes vista;
    List<ModeloClientes> clientes;

    DefaultTableModel model = new DefaultTableModel();

    public ControladorClientes(ClientesDAO sql, Clientes vista) {
        this.sql = sql;
        this.vista = vista;

        vista.setVisible(true);
        vista.setLocationRelativeTo(null);

        this.vista.addBtnAgregar(new CalculateListener());
        this.vista.addBtnEditar(new CalculateListener());
        this.vista.addBtnEliminar(new CalculateListener());
        model.addColumn("NIT");
        model.addColumn("Nombre");
        model.addColumn("Direccion");
        model.addColumn("Telefono");
        listarClientes();
    }

    public ControladorClientes() {
    }

    public void listarClientes() {
        try {
            vista.limpiarListadoTabla();
            clientes = sql.listadoClientes();

            for (int i = 0; i < clientes.size(); i++) {
                model.addRow(new Object[]{clientes.get(i).getCodigoCliente(),
                    clientes.get(i).getNombre(),
                    clientes.get(i).getDireccion(),
                    clientes.get(i).getTelefono()});
            }

            vista.jTableClientes.setModel(model);
        } catch (Exception ex) {
            vista.displayErrorMessage("Error en la consulta");
        }
    }

    class CalculateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getActionCommand().equalsIgnoreCase("Agregar")) {

                int nit;
                String nombre;
                String direccion;
                String telefono;

                nit = Integer.parseInt(vista.getjTextNit().getText());
                nombre = vista.getjTextNombre().getText();
                direccion = vista.getjTextDireccion().getText();
                telefono = vista.getjTextTelefono().getText();
                sql.crearClientes(nit, nombre, direccion,telefono);
                listarClientes();
            }

            if (e.getActionCommand().equalsIgnoreCase("Editar")) {
                int codigo = vista.codigo;
                int nit = Integer.parseInt(vista.getjTextNit().getText());
                String nombre = vista.getjTextNombre().getText();
                String direccion = vista.getjTextDireccion().getText();
                String telefono = vista.getjTextTelefono().getText();
                if (codigo != 0) {
                    sql.modificarClientes(nit, nombre, direccion, telefono);
                    listarClientes();
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor seleccione el registro a editar");
                }
            }

            if (e.getActionCommand().equalsIgnoreCase("Eliminar")) {
                int codigo = vista.codigo;
                if (codigo != 0) {
                    sql.eliminarClientes(codigo);
                    listarClientes();
                    vista.setCodigo(0);
                } else {
                    JOptionPane.showMessageDialog(null, "Por favot seleccione el registro a eliminar");
                }
            }
        }
    }
}
