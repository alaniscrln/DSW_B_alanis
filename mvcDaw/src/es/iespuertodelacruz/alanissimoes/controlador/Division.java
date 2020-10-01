/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.alanissimoes.controlador;

/**
 *
 * @author Alanis
 */
public class Division {

    public Division() {
    }

    public double dividir(double num1, double num2) {

        if (num1 == 0)
            return (Double.NaN);
        
        return num1 / num2;
    }
}
