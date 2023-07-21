/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package problema01;

/**
 *
 * @author cdm / italo
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author reroes
 */
public class Enlace {
    private Connection conn;
       
    public void establecerConexion() {  

        try {  
            // db parameters  
            String url = "jdbc:sqlite:bd/base001.db";  
            // create a connection to the database  
            conn = DriverManager.getConnection(url);  
            // System.out.println(conn.isClosed());
            // System.out.println("Connection to SQLite has been established.");  
              
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }   
        
    } 
    
    public Connection obtenerConexion(){
        return conn;
    }
    
    public void insertarTrabajador(Trabajador trab) {  
  
        try{  
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format("INSERT INTO trabajador (nombres,"
                    + "cedula, correo, sueldo, mesSueldo) "
                    + "values ('%s', '%s', '%s', %d, '%s')", 
                    trab.obtenerNombres(), 
                    trab.obtenerCedula(),
                    trab.obtenerCorreo(),
                    trab.obtenerSueldo(),
                    trab.obtenerMesSueldo());
            
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {  
             System.out.println("Exception:");
             System.out.println(e.getMessage());  
             
        }  
    }
    
    public ArrayList<Trabajador> obtenerDataAlumno() {  
        ArrayList<Trabajador> lista = new ArrayList<>();
        try{  
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from trabajador;";
            
            ResultSet rs = statement.executeQuery(data);
            while(rs.next()){
                Trabajador empleado = new Trabajador();
                empleado.establecerNombres(rs.getString("nombres"));
                empleado.establecerCedula(rs.getString("cedula"));
                empleado.establecerCorreo(rs.getString("correo"));
                empleado.establecerSueldo(rs.getInt("sueldo"));
                empleado.establecerMesSueldo(rs.getString("mesSueldo"));
                lista.add(empleado);
            }
            
            obtenerConexion().close(); 
        } catch (SQLException e) {  
             System.out.println("Exception: insertarTrabajador");
             System.out.println(e.getMessage());  
             
        }  
        return lista;
    }
     
}
