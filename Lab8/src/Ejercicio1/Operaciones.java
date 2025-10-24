package Ejercicio1;

import java.sql.*;
import java.util.Scanner;

public class Operaciones {

    public void crearTabla() {
        String sql = "CREATE TABLE IF NOT EXISTS producto (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                     "nombre TEXT NOT NULL," +
                     "marca TEXT NOT NULL," +
                     "precio REAL NOT NULL)";
        try (Connection conn = Conexion.conectar();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabla 'producto' verificada o creada.");
        } catch (SQLException e) {
            System.out.println("Error al crear la tabla: " + e.getMessage());
        }
    }

    public void insertarProducto(Scanner sc) {
        String sql = "INSERT INTO producto(nombre, marca, precio) VALUES(?, ?, ?)";
        try (Connection conn = Conexion.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            conn.setAutoCommit(false);
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Marca: ");
            String marca = sc.nextLine();
            System.out.print("Precio: ");
            double precio = sc.nextDouble();
            sc.nextLine();

            pstmt.setString(1, nombre);
            pstmt.setString(2, marca);
            pstmt.setDouble(3, precio);
            pstmt.executeUpdate();

            confirmarOperacion(conn);
        } catch (SQLException e) {
            System.out.println("Error al insertar producto: " + e.getMessage());
        }
    }

    public void mostrarProductos() {
        String sql = "SELECT * FROM producto";
        try (Connection conn = Conexion.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n-LISTA DE PRODUCTO-");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                                   ", Nombre: " + rs.getString("nombre") +
                                   ", Marca: " + rs.getString("marca") +
                                   ", Precio: " + rs.getDouble("precio"));
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar productos: " + e.getMessage());
        }
    }

    public void actualizarProducto(Scanner sc) {
        String sql = "UPDATE producto SET nombre = ?, marca = ?, precio = ? WHERE id = ?";
        try (Connection conn = Conexion.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            conn.setAutoCommit(false);
            System.out.print("ID del producto a actualizar: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Nuevo nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Nueva marca: ");
            String marca = sc.nextLine();
            System.out.print("Nuevo precio: ");
            double precio = sc.nextDouble();
            sc.nextLine();

            pstmt.setString(1, nombre);
            pstmt.setString(2, marca);
            pstmt.setDouble(3, precio);
            pstmt.setInt(4, id);
            pstmt.executeUpdate();

            confirmarOperacion(conn);
        } catch (SQLException e) {
            System.out.println("Error al actualizar producto: " + e.getMessage());
        }
    }

    public void borrarProducto(Scanner sc) {
        String sql = "DELETE FROM producto WHERE id = ?";
        try (Connection conn = Conexion.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            conn.setAutoCommit(false);
            System.out.print("ID del producto a borrar: ");
            int id = sc.nextInt();
            sc.nextLine();

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            confirmarOperacion(conn);
        } catch (SQLException e) {
            System.out.println("Error al borrar producto: " + e.getMessage());
        }
    }

    private void confirmarOperacion(Connection conn) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese clave para confirmar (1234): ");
        String clave = sc.nextLine();
        if (clave.equals("1234")) {
            conn.commit();
            System.out.println("Operación confirmada.");
        } else {
            conn.rollback();
            System.out.println("Clave incorrecta. Cambios revertidos.");
        }
    }
}
