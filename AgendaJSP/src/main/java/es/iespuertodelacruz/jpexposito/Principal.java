/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.jpexposito;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import es.iespuertodelacruz.jpexposito.controlador.UsuarioControlador;
import es.iespuertodelacruz.jpexposito.exception.DatosIncorrectosException;
import es.iespuertodelacruz.jpexposito.exception.FicheroNoExisteException;
import es.iespuertodelacruz.jpexposito.exception.UsuarioExisteException;
import es.iespuertodelacruz.jpexposito.modelo.Usuario;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jpexposito
 */
public class Principal {

    /**
     * @param args the command line arguments
     * @throws
     * es.iespuertodelacruz.jpexposito.exception.FicheroNoExisteException
     */
    public static void main(String[] args) throws FicheroNoExisteException, UsuarioExisteException, DatosIncorrectosException {

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        UsuarioControlador uc = new UsuarioControlador();
        int opcion; //Guardaremos la opcion del usuario

        while (!salir) {

            System.out.println("\n1. Introducir Usuario");
            System.out.println("2. Modificar Usuario");
            System.out.println("3. Eliminar Usuario");
            System.out.println("4. Buscar Usuario");
            System.out.println("5. Mostrar todos");
            System.out.println("6. Salir ");

            System.out.println("Escribe una de las opciones");
            opcion = sn.nextInt();
            sn.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Introduzca los datos Usuario");
                    System.out.println("Indique el dni del usuario:");
                    String dni = sn.nextLine();
                    System.out.println("Indique el nombre del usuario:");
                    String nombre = sn.nextLine();
                    System.out.println("Indique el apellidos del usuario:");
                    String apellido = sn.nextLine();

                    try {
                        uc.insertar(dni, nombre, apellido);
                    } catch (DatosIncorrectosException ex) {
                        System.out.println("error datos: " + ex.getMessage());
                    }catch(Exception ex){
                        System.out.println("error insertar: " + ex.getMessage());
                    }

                    break;
//
//                case 2:
//                    System.out.println("Introduzca el dni del usuario a modificar:");
//                    dni = sn.nextLine();
//                    System.out.println("NUEVOS DATOS");
//                    System.out.println("Indique el nuevo dni del usuario:");
//                    String dniNuevo = sn.nextLine();
//                    System.out.println("Indique el nuevo nombre del usuario:");
//                    String nombreNuevo = sn.nextLine();
//                    System.out.println("Indique los nuevos apellidos del usuario:");
//                    String apellidoNuevo = sn.nextLine();
//                    try{
//                    uc.modificar(dni, nombreNuevo, apellidoNuevo);   
//                    }catch(DatosIncorrectosException ex){
//                        System.out.println("error modificar: " + ex.getMessage());
//                    }
//                    break;

//                case 3:
//                    System.out.println("Introduzca el dni: ");
//                    dni = sn.nextLine();
//                    usuarioFile.eliminar(dni);
//                    break;
//                case 4:
//                    System.out.println("Introduzca el dni: ");
//                    dni = sn.nextLine();
//                    usuarioFile.buscar(dni);
//                    break;
//                case 5:
//                    usuarioFile.buscarTodos();
//                    break;
                case 6:
                    salir = true;
                    break;
                default:
                    System.out.println("Solo números entre 1 y 5");
            }

        }
    }

}
