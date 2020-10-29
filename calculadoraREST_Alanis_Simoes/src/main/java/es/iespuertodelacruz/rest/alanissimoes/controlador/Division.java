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
public class Division extends Operacion {

    //--------------------------------------------------------------------------
    public Division() {

    }

    //--------------------------------------------------------------------------
    public double dividir(String num1, String num2) {

        double resultado, numero1, numero2;

        if (this.sonNumeros(num1, num2)) {

            numero1 = Double.parseDouble(num1);
            numero2 = Double.parseDouble(num2);
            
        }else{
            numero1 = Double.NaN;
            numero2 = Double.NaN;
        }
        
        if (numero2 == 0) {
            numero2 = Double.NaN;
        }
        
        resultado = numero1 / numero2;

        return resultado;

    }

}