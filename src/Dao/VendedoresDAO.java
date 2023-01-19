/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.ModelVendedores;
import Servicios.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Leon
 */
public class VendedoresDAO {
        
    Conexion Conectar = new Conexion();

    public VendedoresDAO() {
    }
    
    public ArrayList<ModelVendedores> listadoProvedores() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<ModelVendedores> listadoVendedores = new ArrayList<>();
        try {
            con = Conectar.getConnection();
            String sql = "";
            sql = "SELECT * FROM vendedores "
                    + "WHERE estado_vendedor = 'Y' ORDER BY codigo_vendedor";
            pstm = con.prepareStatement(sql);

            rs = pstm.executeQuery();

            ModelVendedores vendedor = null;
            while (rs.next()) {
                vendedor = new ModelVendedores();
                vendedor.setCodigoVendedor(rs.getInt("codigo_vendedor"));
                vendedor.setCedula(rs.getInt("cedula_vendedor"));
                vendedor.setNombre(rs.getString("nombre_vendedor"));
                vendedor.setTelefono(rs.getString("telefono_vendedor"));
                vendedor.setComision(rs.getInt("comision_vendedor"));
                vendedor.setFechaCrea(rs.getString("fecha_crea"));
                vendedor.setEstadoVendedor(rs.getString("estado_vendedor"));
                listadoVendedores.add(vendedor);
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
        return listadoVendedores;
    }
    
    public void crearVendedores(int cedula_vendedor, String nombre_vendedor, String telefono_vendedor, 
            int comision_vendedor) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = Conectar.getConnection();
            String sql = "";
            sql = "INSERT INTO vendedores (cedula_vendedor, nombre_vendedor, "
                    + "telefono_vendedor, comision_vendedor, fecha_crea, estado_vendedor) VALUES "
                    + "("+cedula_vendedor+", '" + nombre_vendedor + "', '" + telefono_vendedor + "',"
                    + comision_vendedor + "," + " CURDATE(), 'Y')";
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
    
    public void modificarVendedores(int cedula, String nombre, String telefono,
            int comision) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = Conectar.getConnection();
            String sql = "";
            sql ="UPDATE vendedores SET "
                    + "cedula_vendedor=" + cedula + ", nombre_vendedor='"+ nombre
                    + "', telefono_vendedor=" + telefono + ", comision_vendedor="+ comision
                    + " WHERE cedula_vendedor=" + cedula + "";
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
    
     public void eliminarVendedores(int codigo) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = Conectar.getConnection();
            String sql = "";
            sql = "UPDATE vendedores SET "
                    + "estado_vendedor='N' WHERE codigo_vendedor = " + codigo + ""
                    + " and estado_vendedor = 'Y'";
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
            sql = "SELECT COUNT(*) FROM vendedores WHERE estado_vendedor = 'Y'";
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
