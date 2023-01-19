/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_pi;

import Controlador.*;
import Dao.*;
import Model.*;
import Servicios.Navegacion;
import vista.*;


/**
 *
 * @author juanp
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //testConsultas a = new testConsultas();
        //a.ejecutar(); 
        
        Navegacion iniciaNavegacion = new Navegacion();
        iniciaNavegacion.inicio();
        
    }
    
}
