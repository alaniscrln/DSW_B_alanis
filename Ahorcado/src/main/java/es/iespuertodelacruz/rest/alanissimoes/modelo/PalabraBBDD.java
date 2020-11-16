package es.iespuertodelacruz.rest.alanissimoes.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Alanis
 */
public class PalabraBBDD {

    /**
     * Insertar palabra en la bbdd palabras
     *
     * @param palabra palabra a insertar
     * @param haSidoUsada saber si ha sido usada antes
     */
    public static void insert(String palabra, int haSidoUsada) throws Exception {
        String sql = "INSERT INTO palabras (palabra, haSidoUsada) VALUES(?,?)";

        try {
            Connection conn = ConexionInicioAhorcadoBBDD.openConnectSQLite();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, palabra);
            pstmt.setInt(2, haSidoUsada);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Se ha producido un error almacenando en la BBDD palabra:" + e.getMessage() + "-------" + e.getSQLState());
        } finally {
            ConexionInicioAhorcadoBBDD.closeConnectSQLite();
        }
    }

    /**
     * Seleccionar una palabra aleatoria de la bbdd palabras
     *
     * @return palabra seleccionada
     */
    public static Palabra selectRandom() throws Exception {
        String sql = "SELECT * FROM palabras WHERE haSidoUsada = 0 ORDER BY RANDOM() LIMIT 1";
        Palabra palabra = new Palabra();

        try {
            Connection conn = ConexionInicioAhorcadoBBDD.openConnectSQLite();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet resultSet = pstmt.executeQuery();

            palabra.setPalabra(resultSet.getString("palabra"));
            palabra.setHaSidoUsada(resultSet.getInt("haSidoUsada"));

        } catch (Exception e) {
            palabra = null;
            System.out.println("Error en selectRandom: " + e.getMessage());
        } finally {
            ConexionInicioAhorcadoBBDD.closeConnectSQLite();
            return palabra;
        }
    }

    /**
     * Actualizar 'haSidoUsada' en la bbdd palabras
     *
     * @param palabra
     */
    public static void updateHaSidoUsada(String palabra) throws Exception {

        String sql = "UPDATE palabras SET haSidoUsada = ? WHERE palabra = ?";
        try {
            Connection conn = ConexionInicioAhorcadoBBDD.openConnectSQLite();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 1);
            pstmt.setString(2, palabra);
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("no se actualiza la palabra: " + e.getMessage());
        } finally {
            ConexionInicioAhorcadoBBDD.closeConnectSQLite();
        }
    }

    public static Palabra selectPalabra(String palabra) throws Exception {
        String sql = "SELECT * FROM palabras WHERE palabra = ?";

        Palabra p = new Palabra();
        try {
            Connection conn = ConexionInicioAhorcadoBBDD.openConnectSQLite();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, palabra);
            ResultSet resultSet = pstmt.executeQuery();

            p.setPalabra(resultSet.getString("palabra"));
            p.setHaSidoUsada(resultSet.getInt("haSidoUsada"));

        } catch (Exception e) {
            p = null;
            System.out.println("Error en selectPalabra: " + e.getMessage());
        } finally {
            ConexionInicioAhorcadoBBDD.closeConnectSQLite();
            return p;
        }
    }
    
    public static void updateResetPalabras(){
        String sql = "UPDATE palabras SET haSidoUsada = 0 WHERE haSidoUsada = 1";
        try {
            Connection conn = ConexionInicioAhorcadoBBDD.openConnectSQLite();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            System.out.println("Palabras reseteadas.");
        } catch (Exception e) {
            System.out.println("no se resetean las palabras: " + e.getMessage());
        } finally {
            ConexionInicioAhorcadoBBDD.closeConnectSQLite();
        }
    }

}
