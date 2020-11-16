/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.rest.alanissimoes.modelo;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author Alanis
 */
public class InitServletContextListenerBBDD implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("ServletContextListener destroyed");
    }

    /**
     * Se ejecuta nada más ejecutar el proyecto automaticamente
     * @param arg0 
     */
    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println("Creando bbdd y sus tablas jugador y palabra");
        ConexionInicioAhorcadoBBDD.openConnectSQLite();
        ConexionInicioAhorcadoBBDD.crearTablaPalabra();
        ConexionInicioAhorcadoBBDD.crearTablaJugador();
        
    }

}
