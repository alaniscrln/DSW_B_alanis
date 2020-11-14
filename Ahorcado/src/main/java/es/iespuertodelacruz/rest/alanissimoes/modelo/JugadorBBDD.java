/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.rest.alanissimoes.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Alanis
 */
public class JugadorBBDD {

    /**
     * Insertar jugador en la bbdd jugador
     *
     * @param id número identificador del jugador en la bbdd
     * @param nombre nombre del jugador
     */
    public static void insert(int id, String nombre) {
        String sql = "INSERT INTO jugador (id, nombre, puntos) VALUES(?,?,?)";

        try {
            Connection conn = ConexionInicioAhorcadoBBDD.openConnectSQLite();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, nombre);
            pstmt.setInt(3, 0);
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
     * @param id id del jugador a eliminar
     */
    public static void delete(int id) {
        String sql = "DELETE FROM jugador WHERE id = ?";
        try {
            Connection conn = ConexionInicioAhorcadoBBDD.openConnectSQLite();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("jugador eliminado");
        } catch (Exception e) {
            System.out.println("no se elimina correctamente. " + e.getMessage());
        } finally {
            ConexionInicioAhorcadoBBDD.closeConnectSQLite();
        }
    }

    /**
     * Actualizar los puntos del jugador en la bbdd jugador
     *
     * @param id id del jugador a actualizar los datos
     */
    public static void updatePuntos(int id) {
        String sql = "UPDATE jugador SET puntos = ? WHERE id = ?";
        try {
            Connection conn = ConexionInicioAhorcadoBBDD.openConnectSQLite();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            int puntos = selectPuntos(id) + 1;
            pstmt.setInt(1, puntos);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("no se actualiza el jugador: " + e.getMessage());
        } finally {
            ConexionInicioAhorcadoBBDD.closeConnectSQLite();
        }
    }

    /**
     * Conocer los puntos actuales del jugador
     * @param id id del jugador
     * @return puntos actuales del jugador
     */
    private static int selectPuntos(int id) {
        String sql = "SELECT puntos FROM jugador WHERE id = ?";
        int puntos = 0;

        try {
            Connection conn = ConexionInicioAhorcadoBBDD.openConnectSQLite();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet resultSet = pstmt.executeQuery();
            puntos = resultSet.getInt("puntos");
        } catch (Exception e) {
            System.out.println("error al obtener puntos del jugador: " + e.getMessage());
            ConexionInicioAhorcadoBBDD.closeConnectSQLite();

        }
        return puntos;
    }

}
