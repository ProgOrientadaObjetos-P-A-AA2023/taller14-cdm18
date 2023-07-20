package problema02;

import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author cdm124
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Enlace c = new Enlace();
        
        c.establecerConexion();
        
        for (int i = 0; i < c.obtenerDataAlumno().size(); i++) {
            System.out.println(c.obtenerDataAlumno().get(i));
        }
        
    }
    
}
