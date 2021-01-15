/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.jpexposito.exception;

/**
 *
 * @author Alanis
 */
public class UsuarioNoInsertadoException extends Exception {

    public UsuarioNoInsertadoException( String dni ) {
        super("Error de entrada: No se pudo insertar el usuario con dni: " + dni);
    }
    
    
    
}
