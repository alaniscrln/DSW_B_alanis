package es.iespuertodelacruz.rest.alanissimoes.modelo;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class InitServletContextListenerBBDD implements ServletContextListener {

    private static Empleados empleados;
    
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
        System.out.println("Creando bbdd EMPLEADO y su tabla EMPLEADOS");
        ConexionInicioEmpleadosBBDD.openConnectSQLite();
        ConexionInicioEmpleadosBBDD.crearTablaEmpleado();
        InitServletContextListenerBBDD.empleados = new Empleados();
    }

    public static Empleados getEmpleados() {
        return empleados;
    }
    

}
