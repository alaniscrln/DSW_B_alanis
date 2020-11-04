package es.iespuertodelacruz.rest.alanissimoes.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class AlumnoBBDD {
    

    public static void insert(int id, String nombre, String apellidos, int nota) {
        
        String sql = "INSERT INTO alumnos (id, nombre, apellidos, nota) VALUES(?,?,?,?)";

        try{
            Connection conn = ConexionInicioBBDD.openConnectSQLite();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, nombre);
            pstmt.setString(3, apellidos);
            pstmt.setInt(4, nota);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Se ha producido un error almacenando en la BBDD:" + e.getMessage());
        } finally {

            ConexionInicioBBDD.closeConnectSQLite();
        }
    }
    
    public static Alumno select(int id){
        String sql = "SELECT * FROM alumnos WHERE id == '" + id + "'";
        try {
            Connection conn = ConexionInicioBBDD.openConnectSQLite();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.getResultSet(); // no se si puedo parsearlo a alumno
        } catch (Exception e) {
        }
    }
}