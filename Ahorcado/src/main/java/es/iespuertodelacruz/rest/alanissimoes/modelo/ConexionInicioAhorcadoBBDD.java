package es.iespuertodelacruz.rest.alanissimoes.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConexionInicioAhorcadoBBDD {

    static Connection conn = null;

    /**
     * Metodo que realiza la conexion con la BBDD
     *
     * @return
     */
    public static Connection openConnectSQLite() {

        try {
            Class.forName("org.sqlite.JDBC");
            if (conn != null && !conn.isClosed()) {
                return conn;
            }

            String url = "jdbc:sqlite:ahorcado.db";
            conn = DriverManager.getConnection(url);

            System.out.println("Se ha establecido la conexion con la BBDD ahorcado correctamente");

        } catch (Exception exception) {
            System.out.println("Se ha producido un error realizando la conexion con la BBDD palabras:" + exception.getMessage());
        }
        return conn;
    }

    /**
     * Metodo que finaliza la conexion con la BBDD
     */
    public static void closeConnectSQLite() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception exception) {
            System.out.println("Se ha producido un error cerrando la conexion con la BBDD palabras:" + exception.getMessage());
        }
    }

    /**
     * Metodo que cre la tabla palabras
     */
    public static void crearTablaPalabra() {

        String sql = "CREATE TABLE IF NOT EXISTS palabras (\n"
                + "palabra VARCHAR(100) PRIMARY KEY, \n"
                + " haSidoUsada INTEGER NOT NULL\n"
                + ");";

        try {
            Connection conn = openConnectSQLite();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("Tabla palabras creada.");

        } catch (Exception e) {
            System.out.println("Fallo en crear tabla palabra: " + e.getMessage());
        } finally {
            closeConnectSQLite();
        }
    }

    /**
     * Metodo que crea la tabla jugador
     */
    public static void crearTablaJugador() {

        String sql = "CREATE TABLE IF NOT EXISTS jugador (\n"
                + "nombre VARCHAR(100) PRIMARY KEY,\n"
                + "puntos INTEGER"
                + ");";

        try {
            Connection conn = openConnectSQLite();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("Tabla jugador creada.");
        } catch (Exception e) {
            System.out.println("Fallo en crear tabla jugador: " + e.getMessage());
        } finally {
            closeConnectSQLite();
        }
    }
}
