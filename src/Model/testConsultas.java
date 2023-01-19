/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Dao.ProductoDao;
import Dao.VendedoresDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author juanp
 */
public class testConsultas {
    
    private int id = 24;
    private int codigo = 1437;
    private String descripcion = "Buñuelo";
    private int factor = 3;
    private int cantidad = 10;
    private int proveedor = 3;
    private int precio = 600;
    private int cedula = 2536;
    public testConsultas() {
        
    }    
    
    public void imprimir(){
        String sql = "UPDATE materia_prima_mast SET descripcion_mast='"+descripcion+"', "
                    + "codigo_mast="+codigo+", codigo_factor="+factor+", "
                    + "cantidad_mast="+cantidad+", id_proveedor_mast="+proveedor+", "
                    + "precio_mast="+precio+", precio_total_mast="+cantidad * precio+" "
                    + "WHERE id_mast = "+id+"";
        JOptionPane.showMessageDialog(null, sql);
    }   
    
    
    public void ejecutar(){
        ProductoDao a = new ProductoDao();
        a.eliminarProductosFactor(id);
    }

    
}
