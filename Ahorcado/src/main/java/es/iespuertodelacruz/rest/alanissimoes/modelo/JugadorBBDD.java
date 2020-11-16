package es.iespuertodelacruz.rest.alanissimoes.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JugadorBBDD {

    /**
     * Insertar jugador en la bbdd jugador
     *
     * @param nombre nombre del jugador
     * @throws java.lang.Exception
     */
    public static void insert(String nombre) throws Exception{
        String sql = "INSERT INTO jugador (nombre, puntos) VALUES(?,?)";

        try {
            Connection conn = ConexionInicioAhorcadoBBDD.openConnectSQLite();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nombre);
            pstmt.setInt(2, 0);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Se ha producido un error almacenando en la BBDD jugador:" + e.getMessage());
        } finally {
            ConexionInicioAhorcadoBBDD.closeConnectSQLite();
        }
    }

    /**
     * Eliminar jugador de la bbdd jugador
     *
     * @throws java.lang.Exception
     */
    public static void deleteJugadores() throws Exception{
        String sql = "DELETE FROM jugador";
        try {
            Connection conn = ConexionInicioAhorcadoBBDD.openConnectSQLite();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            System.out.println("jugadores eliminados");
        } catch (Exception e) {
            System.out.println("no se eliminan los jugadores correctamente. " + e.getMessage());
        } finally {
            ConexionInicioAhorcadoBBDD.closeConnectSQLite();
        }
    }

    /**
     * Actualizar los puntos del jugador en la bbdd jugador
     *
     * @param nombre nombre del jugador
     * @throws java.lang.Exception
     */
    public static void updatePuntos(String nombre) throws Exception{
        String sql = "UPDATE jugador SET puntos = ? WHERE nombre = ?";
        try {
            Connection conn = ConexionInicioAhorcadoBBDD.openConnectSQLite();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            int puntos = selectPuntos(nombre) + 1;
            pstmt.setInt(1, puntos);
            pstmt.setString(2, nombre);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("no se actualiza el jugador: " + e.getMessage());
        } finally {
            ConexionInicioAhorcadoBBDD.closeConnectSQLite();
        }
    }

    /**
     * Seleccionar los puntos de un jugador
     * @param nombre nombre del jugador
     * @return puntos del jugador
     * @throws Exception 
     */
    private static int selectPuntos(String nombre) throws Exception{
        String sql = "SELECT puntos FROM jugador WHERE nombre = ?";
        int puntos = 0;

        try {
            Connection conn = ConexionInicioAhorcadoBBDD.openConnectSQLite();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nombre);
            ResultSet resultSet = pstmt.executeQuery();
            puntos = resultSet.getInt("puntos");
        } catch (SQLException e) {
            System.out.println("error al obtener puntos del jugador: " + e.getMessage());
            ConexionInicioAhorcadoBBDD.closeConnectSQLite();

        }
        return puntos;
    }
    
    /**
     * Obtiene el jugador indicado de la BBDD
     * @param nombre nombre del jugador
     * @return objeto del jugador solicitado
     * @throws Exception 
     */
    public static Jugador selectJugador(String nombre) throws Exception {
        String sql = "SELECT * FROM jugador WHERE nombre = ?";

        Jugador jugador = new Jugador();
        try {
            Connection conn = ConexionInicioAhorcadoBBDD.openConnectSQLite();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nombre);
            ResultSet resultSet = pstmt.executeQuery();

            jugador.setNombre(resultSet.getString("nombre"));
            jugador.setPuntos(resultSet.getInt("puntos"));
            
        } catch (Exception e) {
            jugador = null;
            System.out.println("Error en selectPalabra: " + e.getMessage());
        } finally {
            ConexionInicioAhorcadoBBDD.closeConnectSQLite();
            return jugador;
        }
    }

}
