package es.iespuertodelacruz.rest.alanissimoes.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConexionInicioEmpleadosBBDD {

    static Connection conn = null;

    public static Connection openConnectSQLite() {

        try {
            Class.forName("org.sqlite.JDBC");
            if (conn != null && !conn.isClosed()) {
                return conn;
            }

            String url = "jdbc:sqlite:empleados.db";
            conn = DriverManager.getConnection(url);

            System.out.println("Se ha establecido la conexion con la BBDD");

        } catch (Exception exception) {
            System.out.println("Se ha producido un error realizando la conexion con la BBDD :" + exception.getMessage());
        }
        return conn;
    }

    
    public static void closeConnectSQLite() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception exception) {
            System.out.println("Se ha producido un error cerrando la conexion con la BBDD:" + exception.getMessage());
        }
    }

   
    public static void crearTablaEmpleado() {

        String sql = "CREATE TABLE IF NOT EXISTS empleado (\n"
                + "dni VARCHAR(9) PRIMARY KEY, \n"
                + "nombre VARCHAR(100) NOT NULL, \n"
                + " apellidos VARCHAR(100) NOT NULL\n"
                + ");";

        try {
            Connection conn = openConnectSQLite();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("Tabla EMPLEADO creada.");

        } catch (Exception e) {
            System.out.println("Fallo en crear tabla: " + e.getMessage());
        } finally {
            closeConnectSQLite();
        }
    }

}
