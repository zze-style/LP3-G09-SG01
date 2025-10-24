package Actividad;

import java.sql.*;

public class Operaciones {

    public static void crearTabla() {
        String sql = "CREATE TABLE IF NOT EXISTS persona (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                     "nombre TEXT NOT NULL," +
                     "apellido TEXT NOT NULL)";
        try (Connection conn = ConexionBD.conectar();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabla creada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al crear tabla: " + e.getMessage());
        }
    }

    public static void insertar(String nombre, String apellido) {
        String sql = "INSERT INTO persona(nombre, apellido) VALUES (?, ?)";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            conn.setAutoCommit(false);
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellido);
            pstmt.executeUpdate();
            conn.commit();

            System.out.println("Registro insertado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }

    public static void mostrar() {
        String sql = "SELECT * FROM persona";
        try (Connection conn = ConexionBD.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n Registros en la tabla persona:");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                                   rs.getString("nombre") + " | " +
                                   rs.getString("apellido"));
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar: " + e.getMessage());
        }
    }

    public static void actualizar(int id, String nuevoNombre, String nuevoApellido) {
        String sql = "UPDATE persona SET nombre=?, apellido=? WHERE id=?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            conn.setAutoCommit(false);
            pstmt.setString(1, nuevoNombre);
            pstmt.setString(2, nuevoApellido);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
            conn.commit();

            System.out.println(" Registro actualizado correctamente.");
        } catch (SQLException e) {
            System.out.println(" Error al actualizar: " + e.getMessage());
        }
    }

    public static void eliminar(int id) {
        String sql = "DELETE FROM persona WHERE id=?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            conn.setAutoCommit(false);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            conn.commit();

            System.out.println("Registro eliminado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }
}


