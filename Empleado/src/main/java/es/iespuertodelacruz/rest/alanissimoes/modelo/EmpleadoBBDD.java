package es.iespuertodelacruz.rest.alanissimoes.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpleadoBBDD {

    public static Empleados selectAll() {
        String sql = "SELECT * FROM empleado";
        //ArrayList<Empleado> empleados = new ArrayList<>();
        
        Empleados empleados = InitServletContextListenerBBDD.getEmpleados();
        
        try {
            Connection conn = ConexionInicioEmpleadosBBDD.openConnectSQLite();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                Empleado empleado = new Empleado();
                empleado.setDni(resultSet.getString("dni"));
                empleado.setNombre(resultSet.getString("Nombre"));
                empleado.setApellidos(resultSet.getString("apellidos"));
                empleados.setEmpleados(empleado);
            }

        } catch (SQLException e) {
            System.out.println("Error al seleccionar todos los empleados: " + e.getMessage());
            ConexionInicioEmpleadosBBDD.closeConnectSQLite();

        }
        return empleados;
    }

    public static Empleado selectEmpleado(String dni) {
        String sql = "SELECT * FROM empleado WHERE dni == ?";

        Empleado empleado = new Empleado();
        try {
            Connection conn = ConexionInicioEmpleadosBBDD.openConnectSQLite();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dni);
            ResultSet resultSet = pstmt.executeQuery();

            empleado.setDni(resultSet.getString("dni"));
            empleado.setNombre(resultSet.getString("Nombre"));
            empleado.setApellidos(resultSet.getString("apellidos"));
        } catch (SQLException e) {
            empleado = null;
            System.out.println("Error al obtener empleado: " + e.getMessage());
        } finally {
            ConexionInicioEmpleadosBBDD.closeConnectSQLite();
        }
        return empleado;

    }

    public static void insert(String dni, String nombre, String apellidos) {
        String sql = "INSERT INTO  empleado (dni, nombre, apellidos) VALUES (?,?,?)";

        try {
            Connection conn = ConexionInicioEmpleadosBBDD.openConnectSQLite();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, dni);
            pstmt.setString(2, nombre);
            pstmt.setString(3, apellidos);

            pstmt.executeUpdate();
            System.out.println("Empleado almacenado en la base de datos EMPLEADOS");
        } catch (SQLException ex) {
            System.out.println("Error al almacenar empleado: " + ex.getMessage());
        } finally {
            ConexionInicioEmpleadosBBDD.closeConnectSQLite();
        }
    }

    public static void delete(String dni) {
        String sql = "DELETE FROM empleado WHERE dni = ?";
        try {
            Connection conn = ConexionInicioEmpleadosBBDD.openConnectSQLite();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dni);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar empleado: " + ex.getMessage());
        }
    }

    public static void updateEmpleado(String dni, String nombre, String apellidos) {
        String sql = "UPDATE empleado SET nombre = ?, apellidos = ? WHERE dni = ?";
        try {
            Connection conn = ConexionInicioEmpleadosBBDD.openConnectSQLite();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellidos);
            pstmt.setString(3, dni);
            pstmt.executeUpdate();
            System.out.println("Empleado actualizado");
        } catch (SQLException e) {
            System.out.println("No se actualiza el empleado: " + e.getMessage());
        } finally {
            ConexionInicioEmpleadosBBDD.closeConnectSQLite();
        }
    }

}
