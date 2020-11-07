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

            ConexionInicioBBDD.closeConnectSQLite();
        }
    }

    public static Alumno select(int id) {
        String sql = "SELECT * FROM alumnos WHERE id = ?";
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
        } catch (Exception e) {
            alumno = null;
        } finally {
            ConexionInicioBBDD.closeConnectSQLite();
            return alumno;
        }
    }

    public static String selectAll() {
        String sql = "SELECT * FROM alumnos";
        Alumno alumno = new Alumno();
        String result = "";

        try {
            Connection conn = ConexionInicioBBDD.openConnectSQLite();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                alumno.setId(resultSet.getInt("id"));
                alumno.setNombre(resultSet.getString("nombre"));
                alumno.setApellidos(resultSet.getString("apellidos"));
                alumno.setNota(resultSet.getInt("nota"));
                result += alumno.toString() + "\n";
            }

        } catch (Exception e) {
            result = "ERROR";
        } finally {
            ConexionInicioBBDD.closeConnectSQLite();
            return result;

        }

    }

    public static boolean delete(int id) {
        boolean eliminado = true;
        String sql = "DELETE FROM alumnos WHERE id = ?";
        try {
            Connection conn = ConexionInicioBBDD.openConnectSQLite();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            eliminado = false;
            System.out.println("no se elimina correctamente. " + e.getMessage());
        } finally {
            ConexionInicioBBDD.closeConnectSQLite();
            return eliminado;

        }
    }

    public static boolean updateNombre(String nombre, int id) {
        boolean actualizado = true;
        String sql = "UPDATE alumnos SET nombre = ? WHERE id = ?";
        try {
            Connection conn = ConexionInicioBBDD.openConnectSQLite();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nombre);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("no se actualiza :c. " + e.getMessage());
            actualizado = false;
        } finally {
            ConexionInicioBBDD.closeConnectSQLite();
            return actualizado;

        }
    }

    public static boolean updateApellidos(String apellidos, int id) {
        boolean actualizado = true;
        String sql = "UPDATE alumnos SET apellidos = ? WHERE id = ?";
        try {
            Connection conn = ConexionInicioBBDD.openConnectSQLite();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, apellidos);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            actualizado = false;
        } finally {
            ConexionInicioBBDD.closeConnectSQLite();
            return actualizado;

        }
    }

    public static boolean updateNota(int nota, int id) {
        boolean actualizado = true;
        String sql = "UPDATE alumnos SET nota = ? WHERE id = ?";
        try {
            Connection conn = ConexionInicioBBDD.openConnectSQLite();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, nota);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            actualizado = false;
        } finally {
            ConexionInicioBBDD.closeConnectSQLite();
            return actualizado;
        }

    }

}
