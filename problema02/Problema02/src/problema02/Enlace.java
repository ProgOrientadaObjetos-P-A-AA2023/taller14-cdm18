/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package problema02;

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
import problema02.Alumno;
/**
 *
 * @author reroes
 */
public class Enlace {
    private Connection conn;
       
    public void establecerConexion() {  

        try {  
            // db parameters  
            String url = "jdbc:sqlite:bd/base001.base";  
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
    
    public void insertarAlumno(Alumno alumno) {  
  
        try{  
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format("INSERT INTO base001 (placa,"
                    + "valor_matricula) "
                    + "values ('%s', '%s', %s, %s, %s, %s)", 
                    alumno.obtenerNombre(), 
                    alumno.obtenerApellido(),
                    alumno.obtenerNota1(),
                    alumno.obtenerNota2(),
                    alumno.obtenerNota3(),
                    alumno.obtenerPromedio());
            
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {  
             System.out.println("Exception:");
             System.out.println(e.getMessage());  
             
        }  
    }
    
    public ArrayList<Alumno> obtenerDataAlumno() {  
        ArrayList<Alumno> lista = new ArrayList<>();
        try{  
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from estudiante;";
            
            ResultSet rs = statement.executeQuery(data);
            while(rs.next()){
                Alumno alumno = new Alumno();
                alumno.establecerNombre(rs.getString("nombre"));
                alumno.establecerApellido(rs.getString("apellido"));
                alumno.establecerNota1(rs.getDouble("calificacion1"));
                alumno.establecerNota2(rs.getDouble("calificacion2"));
                alumno.establecerNota3(rs.getDouble("calificacion3"));
                alumno.calcularPromedio();
                lista.add(alumno);
            }
            
            obtenerConexion().close(); 
        } catch (SQLException e) {  
             System.out.println("Exception: insertarCiudad");
             System.out.println(e.getMessage());  
             
        }  
        return lista;
    }
     
}
