package es.iespuertodelacruz.rest.alanissimoes.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConexionInicioBBDD {

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
//            String url = "jdbc:sqlite::memory::db";
            //String url = "jdbc:sqlite:C:\\Users\\Alanis\\Desktop\\proyecto:alumnos.db";
            String url = "jdbc:sqlite:memory:db";
            conn = DriverManager.getConnection(url);

            System.out.println("Se ha establecido la conexion con la BBDD correctamente");

        } catch (Exception exception) {
            System.out.println("Se ha producido un error realizando la conexion con la BBDD:" + exception.getMessage());
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
            System.out.println("Se ha producido un error cerrando la conexion con la BBDD:" + exception.getMessage());

        }

    }

    public static void crearTabla() {

        String sql = "CREATE TABLE IF NOT EXISTS alumnos (\n"
                + "id INTEGER PRIMARY KEY, \n"
                + " nombre VARCHAR(100) NOT NULL,\n"
                + " apellidos VARCHAR(100) NOT NULL,\n"
                + " nota DOUBLE NOT NULL\n"
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
