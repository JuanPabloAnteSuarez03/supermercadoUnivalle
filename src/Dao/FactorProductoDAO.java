/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.FactorProducto;
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
public class FactorProductoDAO {

    Conexion Conectar = new Conexion();

    public FactorProductoDAO() {
    }

    public ArrayList<FactorProducto> listadoProductoFactor() {
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

    public void crearProductoFactor(String descripcion) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = Conectar.getConnection();
            String sql = "";
            sql = "INSERT INTO factores_productos (descripcion_factor, "
                    + "fecha_crea, estado_factor) VALUES "
                    + "('" + descripcion + "', CURDATE(), 'Y')";
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

    public void modificarProductoFactor(int codigo, String descripcion) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = Conectar.getConnection();
            String sql = "";
            sql = "UPDATE factores_productos SET "
                    + "descripcion_factor='" + descripcion + "' "
                    + "WHERE codigo_factor = " + codigo + "";
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
            sql = "UPDATE factores_productos SET "
                    + "estado_factor='N' WHERE codigo_factor = " + codigo + ""
                    + " and estado_factor = 'Y'";
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
            sql = "SELECT COUNT(*) FROM factores_productos WHERE estado_factor = 'Y'";
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

}
