/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.rest.alanissimoes.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Alanis
 */
public class JugadorBBDD {

    /**
     * Insertar palabra en la bbdd jugador
     *
     * @param id número identificador del jugador en la bbdd
     * @param nombre nombre del jugador
     * @param puntos puntos del jugador en la partida actual
     */
    public static void insert(int id, String nombre, int puntos) {
        String sql = "INSERT INTO jugador (id, nombre, puntos) VALUES(?,?,?)";

        try {
            Connection conn = ConexionInicioPalabraBBDD.openConnectSQLite();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, nombre);
            pstmt.setInt(3, puntos);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Se ha producido un error almacenando en la BBDD jugador:" + e.getMessage());
        } finally {
            ConexionInicioPalabraBBDD.closeConnectSQLite();
        }
    }

    // me falta selectjugador y deletejugador
}
