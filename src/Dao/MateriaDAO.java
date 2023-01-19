/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.FactorMateria;
import Model.Materia;
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
 * @author User
 */
public class MateriaDAO {

    Conexion Conectar = new Conexion();

    public MateriaDAO() {
    }

    public ArrayList<Materia> listadoMateriar() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Materia> listadoMateria = new ArrayList<>();
        try {
            con = Conectar.getConnection();
            String sql = "";
            sql = "SELECT * "
                    + "FROM materia_prima_mast "
                    + "WHERE estado_mast  = 'Y' "
                    + "ORDER BY codigo_mast";
            pstm = con.prepareStatement(sql);

            rs = pstm.executeQuery();

            Materia materia = null;
            while (rs.next()) {
                materia = new Materia();
                materia.setId(rs.getInt("id_mast"));
                materia.setNombre(rs.getString("descripcion_mast"));
                materia.setCodigo(rs.getInt("codigo_mast"));
                materia.setIdPresentacion(rs.getInt("codigo_factor"));
                materia.setCantidad(rs.getFloat("cantidad_mast"));
                materia.setIdProveedor(rs.getInt("id_proveedor_mast"));
                materia.setPrecio(rs.getFloat("precio_mast"));
                materia.setPrecioTotal(rs.getFloat("precio_total_mast"));
                materia.setFecha(rs.getString("fecha_crea_mast"));
                materia.setEstado(rs.getString("estado_mast"));
                listadoMateria.add(materia);
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
        return listadoMateria;
    }

    public void crearProductoFactor(String descripcion, int codigo, int factor, 
            int cantidad, int proveedor, float precio) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = Conectar.getConnection();
            String sql = "";
            sql = "INSERT INTO materia_prima_mast "
                    + "(descripcion_mast, codigo_mast, codigo_factor, "
                    + "cantidad_mast, id_proveedor_mast, precio_mast, "
                    + "precio_total_mast, fecha_crea_mast, estado_mast) "
                    + "VALUES ('"+descripcion+"', "+codigo+", "+factor+", "
                    + ""+cantidad+", "+proveedor+", "+precio+", "
                    + ""+cantidad * precio+", CURDATE(), 'Y')";
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

    public void modificarProductoFactor(int id, String descripcion, int codigo, int factor, 
            int cantidad, int proveedor, float precio) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = Conectar.getConnection();
            String sql = "";
            sql = "UPDATE materia_prima_mast SET descripcion_mast='"+descripcion+"', "
                    + "codigo_mast="+codigo+", codigo_factor="+factor+", "
                    + "cantidad_mast="+cantidad+", id_proveedor_mast="+proveedor+", "
                    + "precio_mast="+precio+", precio_total_mast="+cantidad * precio+" "
                    + "WHERE id_mast = "+id+"";
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
            sql = "UPDATE materia_prima_mast SET "
                    + "estado_mast='N' WHERE id_mast = " + codigo + ""
                    + " and estado_mast = 'Y'";
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
            sql = "SELECT COUNT(*) FROM materia_prima_mast WHERE estado_mast = 'Y'";
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
    
    public ArrayList<ModeloProveedores> listadoProvedores() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<ModeloProveedores> listadoProveedores = new ArrayList<>();
        try {
            con = Conectar.getConnection();
            String sql = "";
            sql = "SELECT * FROM proveedores "
                    + " ORDER BY codigo_proveedores";
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
    
    public ArrayList<FactorMateria> listadoMateriaFactor() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<FactorMateria> listadoMateria = new ArrayList<>();
        try {
            con = Conectar.getConnection();
            String sql = "";
            sql = "SELECT * FROM factores_materia "
                    + " ORDER BY codigo_factor";
            pstm = con.prepareStatement(sql);

            rs = pstm.executeQuery();

            FactorMateria materia = null;
            while (rs.next()) {
                materia = new FactorMateria();
                materia.setCodigoFactor(rs.getInt("codigo_factor"));
                materia.setDescripcionFactor(rs.getString("descripcion_factor"));
                materia.setFechaCrea(rs.getString("fecha_crea"));
                materia.setEstadoFactor(rs.getString("estado_factor"));
                listadoMateria.add(materia);
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
        return listadoMateria;
    }
    
    public ArrayList<ModeloProveedores> listadoComboProvedores() {
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
    
    public ArrayList<FactorMateria> listadoComboMateriaFactor() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<FactorMateria> listadoMateria = new ArrayList<>();
        try {
            con = Conectar.getConnection();
            String sql = "";
            sql = "SELECT * FROM factores_materia "
                    + "WHERE estado_factor = 'Y' ORDER BY codigo_factor";
            pstm = con.prepareStatement(sql);

            rs = pstm.executeQuery();

            FactorMateria materia = null;
            while (rs.next()) {
                materia = new FactorMateria();
                materia.setCodigoFactor(rs.getInt("codigo_factor"));
                materia.setDescripcionFactor(rs.getString("descripcion_factor"));
                materia.setFechaCrea(rs.getString("fecha_crea"));
                materia.setEstadoFactor(rs.getString("estado_factor"));
                listadoMateria.add(materia);
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
        return listadoMateria;
    }

}
