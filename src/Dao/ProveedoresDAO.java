package Dao;

import Model.FactorMateria;
import Model.ModeloProveedores;
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
public class ProveedoresDAO {
    
    Conexion Conectar = new Conexion();
    
    public ProveedoresDAO(){
        
    }
    
    public ArrayList<ModeloProveedores> listadoProvedores() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<ModeloProveedores> listadoProveedores = new ArrayList<>();
        try {
            con = Conectar.getConnection();
            String sql = "";
            sql = "SELECT * FROM proveedores "
                    + "WHERE estado_proveedor = 'Y' ORDER BY codigo_proveedores";
            pstm = con.prepareStatement(sql);

            rs = pstm.executeQuery();

            ModeloProveedores proveedor = null;
            while (rs.next()) {
                proveedor = new ModeloProveedores();
                proveedor.setCodigo(rs.getInt("codigo_proveedores"));
                proveedor.setNombre(rs.getString("nombre_proveedores"));
                proveedor.setNit(rs.getInt("nit_proveedores"));
                proveedor.setTelefono(rs.getInt("telefono_proveedores"));
                proveedor.setFechaCrea(rs.getString("fecha_crea"));
                proveedor.setEstadoFactor(rs.getString("estado_proveedor"));
                listadoProveedores.add(proveedor);
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
        return listadoProveedores;
    }
    
    public void crearProovedores(String nombre_proveedores,int nit_proveerdores, 
            int telefono_proveedores) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = Conectar.getConnection();
            String sql = "";
            sql = "INSERT INTO proveedores (nombre_proveedores, "
                    + "nit_proveedores, telefono_proveedores, fecha_crea, estado_proveedor) VALUES "
                    + "('" + nombre_proveedores + "','" + nit_proveerdores + "','"
                    + telefono_proveedores + "'," + " CURDATE(), 'Y')";
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
    
     public void modificarProveedores(int codigo, String nombreProvedor,
             int nit, int telefono) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = Conectar.getConnection();
            String sql = "";
            sql = "UPDATE proveedores SET "
                    + "nombre_proveedores='" + nombreProvedor + "', nit_proveedores="+ nit
                    + ", telefono_proveedores=" + telefono
                    + " WHERE codigo_proveedores=" + codigo + "";
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
     
     public void eliminarProveedores(int codigo) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = Conectar.getConnection();
            String sql = "";
            sql = "UPDATE proveedores SET "
                    + "estado_proveedor='N' WHERE codigo_proveedores = " + codigo + ""
                    + " and estado_proveedor = 'Y'";
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
            sql = "SELECT COUNT(*) FROM proveedores fm WHERE estado_proveedor = 'Y'";
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
