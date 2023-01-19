/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import java.beans.Statement;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author User
 */
public class Conexion {
    
    Connection conexion;

    public Conexion() {
    }
    
    

    public Connection getConnection() {

        try {

            try { 
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al registrar el driver de MySql: " + ex);
            }
            conexion = null;
          conexion = DriverManager.getConnection(
                    "jdbc:mysql://us-cdbr-east-06.cleardb.net:3306/heroku_b7c180e5090e4f7?sslmode=require&user=b8bb919e6bc30e&password=a09870f5",
                    "b8bb919e6bc30e" , "a09870f5");
 
            boolean valid = conexion.isValid(50000);
            System.out.println(valid ? "TEST OK" : "TEST FAIL");

        } catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);

        }
          return conexion;
    } 

    public void cerrarConexion() throws SQLException{
    conexion.close();
    }
    
}
