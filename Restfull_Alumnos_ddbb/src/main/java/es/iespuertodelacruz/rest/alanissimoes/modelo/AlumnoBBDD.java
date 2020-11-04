package es.iespuertodelacruz.rest.alanissimoes.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlumnoBBDD {

    public static void insert(int id, String nombre, String apellidos, int nota) {

        String sql = "INSERT INTO alumnos (id, nombre, apellidos, nota) VALUES(?,?,?,?)";

        try {
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

           // ConexionInicioBBDD.closeConnectSQLite();
        }
    }

    public static Alumno select(int id) {
        String sql = "SELECT * FROM alumnos WHERE id == ?";
        Alumno alumno = new Alumno();

        try {
            Connection conn = ConexionInicioBBDD.openConnectSQLite();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet resultSet = pstmt.executeQuery();

            alumno.setId(resultSet.getInt("id"));
            alumno.setNombre(resultSet.getString("nombre"));
            alumno.setApellidos(resultSet.getString("apellidos"));
            alumno.setNota(resultSet.getInt("nota"));

            System.out.println("Si me lees es porq se guardaron bn los datos");
        } catch (Exception e) {
            alumno = null;
            System.out.println("si me lees es porq no se guardaron los datos");
        } finally {
          //  ConexionInicioBBDD.closeConnectSQLite();
            return alumno;
        }
    }
}
