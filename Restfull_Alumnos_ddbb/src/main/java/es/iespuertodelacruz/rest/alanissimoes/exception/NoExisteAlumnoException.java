/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.rest.alanissimoes.exception;

/**
 *
 * @author Alanis
 */
public class NoExisteAlumnoException extends Exception{
        
    public NoExisteAlumnoException() {
    
        super("El alumno no existe");
    
    }
    
    
}
