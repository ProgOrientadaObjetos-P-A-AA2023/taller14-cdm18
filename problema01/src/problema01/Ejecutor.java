package problema01;

import java.util.Locale;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author carlo
 */
public class Ejecutor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Enlace c = new Enlace();
        String cedula, nombres, mesSueldo, correo;
        String opcion;
        int sueldo;
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        boolean bandera = true;
        
        c.establecerConexion();
        while (bandera) {
            System.out.println("------------------INGRESO A BASE DE DATOS DE "
                    + "CORPORACION X------------------");

            System.out.println("A continuacion ingresar los datos solicitados "
                    + "para registrar un trabajador:");

            System.out.println("Ingrese los nombres del trabajador"
                    + " (Ex. Juan Salinas):");
            nombres = sc.nextLine();

            System.out.println("Ingrese la cedula del trabajador");
            cedula = sc.nextLine();

            System.out.println("Ingrese el correo del trabajador");
            correo = sc.nextLine();

            System.out.println("Ingrese el mes del sueldo del trabajador"
                    + " (Ex. Abril):");
            mesSueldo = sc.nextLine();

            System.out.println("Ingrese el valor del sueldo del trabajador:");
            sueldo = sc.nextInt();

            Trabajador trab = new Trabajador();
            trab.establecerNombres(nombres);
            trab.establecerCedula(cedula);
            trab.establecerCorreo(correo);
            trab.establecerSueldo(sueldo);
            trab.establecerMesSueldo(mesSueldo);

            c.insertarTrabajador(trab);
            
            sc.nextLine();
            
            System.out.println("Deseas terminar de ingresar trabajadores?"
                    + " Si es asi, ingresa la letra x");
            
            opcion = sc.nextLine().toUpperCase();
            
            if (opcion.equals("X")) {
                bandera = false;
            }
            

        }
        
        for (int i = 0; i < c.obtenerDataAlumno().size(); i++) {
            System.out.println(c.obtenerDataAlumno().get(i));
        }

    }

}
