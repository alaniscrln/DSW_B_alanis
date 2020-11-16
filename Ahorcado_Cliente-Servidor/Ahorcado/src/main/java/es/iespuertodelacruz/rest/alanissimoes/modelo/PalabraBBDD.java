package es.iespuertodelacruz.rest.alanissimoes.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PalabraBBDD {

    /**
     * Insertar palabra en la bbdd palabras
     *
     * @param palabra palabra a insertar
     * @param haSidoUsada saber si ha sido usada antes
     * @throws java.lang.Exception
     */
    public static void insert(String palabra, int haSidoUsada) throws Exception {
        String sql = "INSERT INTO palabras (palabra, haSidoUsada) VALUES(?,?)";

        try {
            Connection conn = ConexionInicioAhorcadoBBDD.openConnectSQLite();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, palabra);
            pstmt.setInt(2, haSidoUsada);
            pstmt.executeUpdate();
            System.out.println("Palabra almacenada en la BBDD");
        } catch (SQLException e) {
            System.out.println("Se ha producido un error almacenando en la tabla palabra:" + e.getMessage() + "-------" + e.getSQLState());
        } finally {
            ConexionInicioAhorcadoBBDD.closeConnectSQLite();
        }
    }

    /**
     * Seleccionar una palabra aleatoria de la bbdd palabras
     *
     * @return palabra seleccionada
     * @throws java.lang.Exception
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
            System.out.println("Palabra aleatoria obtenida");
        } catch (Exception e) {
            palabra = null;
            System.out.println("Error al obtener palabra aleatoria: " + e.getMessage());
        } finally {
            ConexionInicioAhorcadoBBDD.closeConnectSQLite();
            return palabra;
        }
    }

    /**
     * Actualizar 'haSidoUsada' en la bbdd palabras
     *
     * @param palabra
     * @throws java.lang.Exception
     */
    public static void updateHaSidoUsada(String palabra) throws Exception {

        String sql = "UPDATE palabras SET haSidoUsada = ? WHERE palabra = ?";
        try {
            Connection conn = ConexionInicioAhorcadoBBDD.openConnectSQLite();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 1);
            pstmt.setString(2, palabra);
            pstmt.executeUpdate();
            System.out.println("Actualizar haSidoUsada en palabra");
        } catch (Exception e) {
            System.out.println("No se actualiza haSidoUsada en palabra: " + e.getMessage());
        } finally {
            ConexionInicioAhorcadoBBDD.closeConnectSQLite();
        }
    }

    /**
     * Obtener palabra de la bbdd palabras
     * @param palabra atributo palabra de la palabra a obtener
     * @return objeto palabra
     * @throws Exception 
     */
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
            System.out.println("Palabra obtenida");
        } catch (Exception e) {
            p = null;
            System.out.println("Error al obtener palabra: " + e.getMessage());
        } finally {
            ConexionInicioAhorcadoBBDD.closeConnectSQLite();
            return p;
        }
    }
    
    /**
     * Establecer 'haSidoUsada' a '0' en todas las palabras de la BBDD palabras
     * @throws java.lang.Exception
     */
    public static void updateResetPalabras() throws Exception{
        String sql = "UPDATE palabras SET haSidoUsada = 0 WHERE haSidoUsada = 1";
        try {
            Connection conn = ConexionInicioAhorcadoBBDD.openConnectSQLite();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            System.out.println("Palabras reestablecidas a no usadas.");
        } catch (Exception e) {
            System.out.println("Error al reestablecer las palabras: " + e.getMessage());
        } finally {
            ConexionInicioAhorcadoBBDD.closeConnectSQLite();
        }
    }

}
