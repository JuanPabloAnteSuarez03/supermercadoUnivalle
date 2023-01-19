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
 * @author User
 */
public class ProductoDao {

    Conexion Conectar = new Conexion();

    public ProductoDao() {
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

    public void crearProducto(String descripcion, int codigo, float precio) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = Conectar.getConnection();
            String sql = "";
            sql = "INSERT INTO productos(fecha_crea, descripcion_producto, "
                    + "codigo_presentacion, precio_producto, estado_producto) "
                    + "VALUES (CURDATE(), '" + descripcion + "', '" + codigo + "', "
                    + "'" + precio + "', 'Y')";
            pstm = con.prepareStatement(sql);

            pstm.executeUpdate();

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

        JOptionPane.showMessageDialog(null, "Se ha insertado con exito el registro");
    }

    public void modificarProducto(int id, String descripcion, int codigo, float precio) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = Conectar.getConnection();
            String sql = "";
            sql = "UPDATE productos SET descripcion_producto = '"+ descripcion +"', "
                    + "codigo_presentacion = "+ codigo +", precio_producto = "+ precio +""
                    + "WHERE codigo_producto = "+ id +"";

            pstm = con.prepareStatement(sql);

            pstm.executeUpdate();

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

        JOptionPane.showMessageDialog(null, "Se ha modificado con exito el registro");
    }

    public void eliminarProductosFactor(int codigo) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = Conectar.getConnection();
            String sql = "";
            sql = "UPDATE productos SET "
                    + "estado_producto = 'N' WHERE codigo_producto = " + codigo + ""
                    + " and estado_producto = 'Y'";
            pstm = con.prepareStatement(sql);

            pstm.executeUpdate();

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

        JOptionPane.showMessageDialog(null, "Se ha eliminado con exito el registro");
    }

    private int registros;

    public int registrosActual() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = Conectar.getConnection();
            String sql = "";
            sql = "SELECT COUNT(*) FROM productos WHERE codigo_producto = 'Y'";
            pstm = con.prepareStatement(sql);

            rs = pstm.executeQuery();

            if (rs.next()) {
                //Si hay resultados obtengo el valor. 
                registros = rs.getInt(1);
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
            System.out.println(registros);
        }
        return registros;
    }

    public ArrayList<FactorProducto> listadoComboProductoFactor() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<FactorProducto> listadoProducto = new ArrayList<>();
        try {
            con = Conectar.getConnection();
            String sql = "";
            sql = "SELECT * FROM factores_productos "
                    + "WHERE estado_factor = 'Y' ORDER BY codigo_factor";
            pstm = con.prepareStatement(sql);

            rs = pstm.executeQuery();

            FactorProducto producto = null;
            while (rs.next()) {
                producto = new FactorProducto();
                producto.setCodigoFactor(rs.getInt("codigo_factor"));
                producto.setDescripcionFactor(rs.getString("descripcion_factor"));
                producto.setFechaCrea(rs.getString("fecha_crea"));
                producto.setEstadoFactor(rs.getString("estado_factor"));
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
