/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.rest.alanissimoes.controlador;

/**
 *
 * @author Alanis
 */
public abstract class Operacion {
    
    public boolean sonNumeros(String num1, String num2){
        
        boolean sonNumeros;
        double numero1, numero2;
        
        try{
        
            numero1 = Double.parseDouble(num1);
            numero2 = Double.parseDouble(num2);
            sonNumeros = true;
        
        }catch (Exception ex) {
            
            sonNumeros = false;
            
        }
        
        return sonNumeros;
    }
    
}
