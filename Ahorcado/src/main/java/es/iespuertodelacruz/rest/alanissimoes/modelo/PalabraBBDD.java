package es.iespuertodelacruz.rest.alanissimoes.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Alanis
 */
public class PalabraBBDD {
    
    public static void insert(String palabra, int haSidoUsada){
        String sql = "INSERT INTO palabra (palabra, haSidoUsada) VALUES(?,?)";

        try {
            Connection conn = ConexionInicioPalabraBBDD.openConnectSQLite();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, palabra);
            pstmt.setInt(2, haSidoUsada);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Se ha producido un error almacenando en la BBDD:" + e.getMessage());
        } finally {

            ConexionInicioPalabraBBDD.closeConnectSQLite();
        }
    }
    
    public static Palabra selectRandom(){
        String sql = "SELECT * FROM table ORDER BY RANDOM() LIMIT 1";
        Palabra palabra = new Palabra();
        
        
        return palabra;
    }
}
