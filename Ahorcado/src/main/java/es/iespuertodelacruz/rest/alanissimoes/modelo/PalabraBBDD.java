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
     * Insertar palabra en la bbdd palabra
     * @param palabra palabra a insertar
     * @param haSidoUsada saber si ha sido usada antes
     */
    public static void insert(String palabra, int haSidoUsada){
        String sql = "INSERT INTO palabras (palabra, haSidoUsada) VALUES(?,?)";

        try {
            Connection conn = ConexionInicioPalabraBBDD.openConnectSQLite();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, palabra);
            pstmt.setInt(2, haSidoUsada);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Se ha producido un error almacenando en la BBDD palabra:" + e.getMessage() + "-------" + e.getSQLState());
        } finally {

            ConexionInicioPalabraBBDD.closeConnectSQLite();
        }
    }
    
    /**
     * Seleccionar una palabra aleatoria de la bbdd palabra
     * @return palabra seleccionada
     */
    public static Palabra selectRandom(){
        String sql = "SELECT * FROM palabras ORDER BY RANDOM() LIMIT 1";
        Palabra palabra = new Palabra();
        
        try {
            Connection conn = ConexionInicioPalabraBBDD.openConnectSQLite();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet resultSet = pstmt.executeQuery();

            palabra.setPalabra(resultSet.getString("palabra"));
            palabra.setHaSidoUsada(resultSet.getInt("haSidoUsada"));
           
        } catch (Exception e) {
            palabra = null;
            System.out.println("Error en selectRandom: " + e.getMessage());
        } finally {
            ConexionInicioPalabraBBDD.closeConnectSQLite();
            return palabra;
        }
    }
    
}
