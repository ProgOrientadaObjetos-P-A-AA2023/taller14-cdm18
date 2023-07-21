/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package problema01;

/**
 *
 * @author carlo
 */
public class Trabajador {

    private String nombres;
    private String cedula;
    private String correo;
    private String mesSueldo;
    private int sueldo;

    public void establecerNombres(String n) {
        nombres = n;
    }

    public void establecerCedula(String c) {
        cedula = c;
    }

    public void establecerCorreo(String c) {
        correo = c;
    }

    public void establecerMesSueldo(String mes) {
        mesSueldo = mes;
    }

    public void establecerSueldo(int s) {
        sueldo = s;
    }

    public String obtenerNombres() {
        return nombres;
    }

    public String obtenerCedula() {
        return cedula;
    }

    public String obtenerCorreo() {
        return correo;
    }

    public String obtenerMesSueldo() {
        return mesSueldo;
    }

    public int obtenerSueldo() {
        return sueldo;
    }

    @Override
    public String toString() {
        return String.format("\tTrabajador\n"
                + "Nombres: %s\n"
                + "Cedula: %s\n"
                + "Correo: %s\n"
                + "Mes del sueldo: %s\n"
                + "Sueldo: $%d\n",
                nombres,
                cedula,
                correo,
                mesSueldo,
                sueldo);
    }

}
