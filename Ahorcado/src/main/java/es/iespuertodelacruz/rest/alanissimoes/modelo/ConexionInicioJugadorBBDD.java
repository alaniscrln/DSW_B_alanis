package es.iespuertodelacruz.rest.alanissimoes.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Alanis
 */
public class ConexionInicioJugadorBBDD {

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

            String url = "jdbc:sqlite:memory:jugador";
            conn = DriverManager.getConnection(url);

            System.out.println("Se ha establecido la conexion con la BBDD jugador correctamente");

        } catch (Exception exception) {
            System.out.println("Se ha producido un error realizando la conexion con la BBDD jugador:" + exception.getMessage());
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
            System.out.println("Se ha producido un error cerrando la conexion con la BBDD jugador:" + exception.getMessage());

        }

    }

    public static void crearTabla() {

        String sql = "CREATE TABLE IF NOT EXISTS jugador (\n"
                + "id INTEGER NOT NULL PRIMARY KEY, \n"
                + "nombre VARCHAR(10),\n" // sqlite no tiene boolean, se utiliza un int: 0 false, 1 true
                + "puntos INTEGER"
                + ");";

        try {
            Connection conn = openConnectSQLite();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnectSQLite();
        }
    }
}
