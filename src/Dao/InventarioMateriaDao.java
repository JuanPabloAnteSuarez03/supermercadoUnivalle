/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.FactorProducto;
import Model.Producto;
import Servicios.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author juanp
 */
public class InventarioMateriaDao {
    Conexion Conectar = new Conexion();

    public InventarioMateriaDao() {
    }
    
    public ArrayList<Producto> listadoProducto() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        PreparedStatement pstm2 = null;
        ResultSet rs2 = null;
        ArrayList<Producto> listadoProducto = new ArrayList<>();
        ArrayList<FactorProducto> listadoFactorProducto = new ArrayList<>();
        try {
            con = Conectar.getConnection();
            String sql = "";
            String sql2 = "";
            sql = "SELECT * FROM productos "
                    + "WHERE estado_producto  = 'Y' "
                    + "ORDER BY codigo_producto ";

            sql2 = "SELECT * FROM factores_productos "
                    + " ORDER BY codigo_factor";

            pstm = con.prepareStatement(sql);
            pstm2 = con.prepareStatement(sql2);

            rs = pstm.executeQuery();
            rs2 = pstm2.executeQuery();

            Producto producto = null;
            FactorProducto factor = null;
            
            while (rs2.next()) {
                factor = new FactorProducto();
                factor.setCodigoFactor(rs2.getInt("codigo_factor"));
                factor.setDescripcionFactor(rs2.getString("descripcion_factor"));
                factor.setFechaCrea(rs2.getString("fecha_crea"));
                factor.setEstadoFactor(rs2.getString("estado_factor"));
                listadoFactorProducto.add(factor);
            }
            while (rs.next()) {
                producto = new Producto();
                producto.setCodigo(rs.getInt("codigo_producto"));
                producto.setFecha(rs.getString("fecha_crea"));
                producto.setDescripcion(rs.getString("descripcion_producto"));
                producto.setIdPresentacion(rs.getInt("codigo_presentacion"));
                producto.setPrecio(rs.getFloat("precio_producto"));
                producto.setEstado(rs.getString("estado_producto"));
                for (int i = 0; i < listadoFactorProducto.size(); i++) {
                    if (producto.getIdPresentacion() == listadoFactorProducto.get(i).getCodigoFactor()) {
                        producto.setPresentacion(listadoFactorProducto.get(i).getDescripcionFactor());
                        System.out.println("entre");
                    }
                }
                listadoProducto.add(producto);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Código : "
                        + ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return listadoProducto;
    }
}
