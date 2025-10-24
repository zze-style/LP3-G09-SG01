package Ejercicio1;

import java.sql.*;
import java.util.*;

public class Main {
    private static final String CLAVE = "hectorluis";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:sqlite:productos.db");
            crearTablaSiNoExiste(conn);

            Gestor gestor = new Gestor();
            boolean salir = false;

            while (!salir) {
                System.out.println("\n--- MENÚ ---");
                System.out.println("1. Ingresar producto");
                System.out.println("2. Mostrar productos");
                System.out.println("3. Actualizar producto");
                System.out.println("4. Borrar producto");
                System.out.println("5. Consulta avanzada (Gestor)");
                System.out.println("6. Salir");
                System.out.print("Elija una opción: ");
                int opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        conn.setAutoCommit(false);
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();
                        System.out.print("Marca: ");
                        String marca = sc.nextLine();
                        System.out.print("Precio: ");
                        double precio = sc.nextDouble();
                        sc.nextLine();

                        System.out.print("Ingrese clave para confirmar: ");
                        String claveInsert = sc.nextLine();

                        if (claveInsert.equals(CLAVE)) {
                            PreparedStatement ps = conn.prepareStatement(
                                "INSERT INTO producto (nombre, marca, precio) VALUES (?, ?, ?)");
                            ps.setString(1, nombre);
                            ps.setString(2, marca);
                            ps.setDouble(3, precio);
                            ps.executeUpdate();
                            conn.commit();
                            System.out.println("Producto insertado correctamente.");
                        } else {
                            conn.rollback();
                            System.out.println("Clave incorrecta. Operación cancelada.");
                        }
                        conn.setAutoCommit(true);
                        break;

                    case 2:
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM producto");
                        while (rs.next()) {
                            System.out.println(
                                rs.getInt("id") + " | " +
                                rs.getString("nombre") + " | " +
                                rs.getString("marca") + " | " +
                                rs.getDouble("precio")
                            );
                        }
                        rs.close();
                        break;

                    case 3:
                        conn.setAutoCommit(false);
                        System.out.print("ID del producto a actualizar: ");
                        int idAct = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Nuevo nombre: ");
                        String nuevoNombre = sc.nextLine();
                        System.out.print("Nueva marca: ");
                        String nuevaMarca = sc.nextLine();
                        System.out.print("Nuevo precio: ");
                        double nuevoPrecio = sc.nextDouble();
                        sc.nextLine();

                        System.out.print("Ingrese clave para confirmar: ");
                        String claveAct = sc.nextLine();

                        if (claveAct.equals(CLAVE)) {
                            PreparedStatement ps = conn.prepareStatement(
                                "UPDATE producto SET nombre=?, marca=?, precio=? WHERE id=?");
                            ps.setString(1, nuevoNombre);
                            ps.setString(2, nuevaMarca);
                            ps.setDouble(3, nuevoPrecio);
                            ps.setInt(4, idAct);
                            ps.executeUpdate();
                            conn.commit();
                            System.out.println("Producto actualizado correctamente.");
                        } else {
                            conn.rollback();
                            System.out.println("Clave incorrecta. Operación cancelada.");
                        }
                        conn.setAutoCommit(true);
                        break;

                    case 4:
                        conn.setAutoCommit(false);
                        System.out.print("ID del producto a borrar: ");
                        int idDel = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Ingrese clave para confirmar: ");
                        String claveDel = sc.nextLine();

                        if (claveDel.equals(CLAVE)) {
                            PreparedStatement ps = conn.prepareStatement(
                                "DELETE FROM producto WHERE id=?");
                            ps.setInt(1, idDel);
                            ps.executeUpdate();
                            conn.commit();
                            System.out.println("Producto borrado correctamente.");
                        } else {
                            conn.rollback();
                            System.out.println("Clave incorrecta. Operación cancelada.");
                        }
                        conn.setAutoCommit(true);
                        break;

                    case 5:
                        gestor.cargarDesdeBD(conn);
                        gestor.consultar(sc);
                        break;

                    case 6:
                        salir = true;
                        System.out.println("Saliendo del programa.");
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
    }

    private static void crearTablaSiNoExiste(Connection conn) {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("""
                CREATE TABLE IF NOT EXISTS producto (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    nombre TEXT NOT NULL,
                    marca TEXT NOT NULL,
                    precio REAL NOT NULL
                )
            """);
        } catch (SQLException e) {
            System.out.println("Error al crear tabla: " + e.getMessage());
        }
    }
}
