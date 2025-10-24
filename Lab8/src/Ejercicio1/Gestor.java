package Ejercicio1;

import java.sql.*;
import java.util.*;

public class Gestor {
    private ArrayList<Producto> listaProductos = new ArrayList<>();

    public void cargarDesdeBD(Connection conn) {
        listaProductos.clear();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM producto")) {
            while (rs.next()) {
                Producto p = new Producto(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("marca"),
                    rs.getDouble("precio")
                );
                listaProductos.add(p);
            }
            System.out.println("Productos cargados en memoria (" + listaProductos.size() + ")");
        } catch (SQLException e) {
            System.out.println("Error al cargar productos: " + e.getMessage());
        }
    }

    public void consultar(Scanner sc) {
        if (listaProductos.isEmpty()) {
            System.out.println("No hay productos cargados para mostrar.");
            return;
        }

        System.out.println("CONSULTA PERSONALIZADA");

        System.out.print("Mostrar campos (id,nombre,marca,precio separados por coma): ");
        String[] campos = sc.nextLine().toLowerCase().split(",");

        System.out.print("¿Desea aplicar una condición? (s/n): ");
        String aplicarCond = sc.nextLine();
        String campoCond = "";
        String valorCond = "";
        if (aplicarCond.equalsIgnoreCase("s")) {
            System.out.print("Campo de condición (nombre/marca/precio): ");
            campoCond = sc.nextLine().toLowerCase();
            System.out.print("Valor a comparar: ");
            valorCond = sc.nextLine();
        }

        System.out.print("¿Desea ordenar los resultados? (s/n): ");
        String ordenar = sc.nextLine();
        String campoOrden = "";
        boolean ascendente = true;
        if (ordenar.equalsIgnoreCase("s")) {
            System.out.print("Campo de orden (id/nombre/marca/precio): ");
            campoOrden = sc.nextLine().toLowerCase();
            System.out.print("Orden ascendente (s) o descendente (n): ");
            ascendente = sc.nextLine().equalsIgnoreCase("s");
        }

        System.out.print("¿Desea limitar cantidad de resultados? (s/n): ");
        String limitar = sc.nextLine();
        int limite = listaProductos.size();
        if (limitar.equalsIgnoreCase("s")) {
            System.out.print("Cantidad máxima de registros: ");
            limite = sc.nextInt();
            sc.nextLine();
        }

        List<Producto> resultado = new ArrayList<>(listaProductos);

        if (!campoCond.isEmpty()) {
            final String campoFinal = campoCond;
            final String valorFinal = valorCond;
            resultado.removeIf(p -> !cumpleCondicion(p, campoFinal, valorFinal));
        }

        if (!campoOrden.isEmpty()) {
            Comparator<Producto> comp = obtenerComparador(campoOrden);
            if (comp != null) {
                if (ascendente)
                    resultado.sort(comp);
                else
                    resultado.sort(comp.reversed());
            }
        }

        if (resultado.size() > limite) {
            resultado = resultado.subList(0, limite);
        }

        System.out.println("\n--- RESULTADOS ---");
        for (Producto p : resultado) {
            mostrarCamposSeleccionados(p, campos);
        }
    }

    private boolean cumpleCondicion(Producto p, String campo, String valor) {
        switch (campo) {
            case "nombre": return p.getNombre().equalsIgnoreCase(valor);
            case "marca": return p.getMarca().equalsIgnoreCase(valor);
            case "precio":
                try {
                    return p.getPrecio() == Double.parseDouble(valor);
                } catch (NumberFormatException e) { return false; }
            default: return false;
        }
    }

    private Comparator<Producto> obtenerComparador(String campo) {
        switch (campo) {
            case "id": return Comparator.comparingInt(Producto::getId);
            case "nombre": return Comparator.comparing(Producto::getNombre);
            case "marca": return Comparator.comparing(Producto::getMarca);
            case "precio": return Comparator.comparingDouble(Producto::getPrecio);
            default: return null;
        }
    }

    private void mostrarCamposSeleccionados(Producto p, String[] campos) {
        StringBuilder sb = new StringBuilder();
        for (String campo : campos) {
            campo = campo.trim();
            switch (campo) {
                case "id": sb.append("ID: ").append(p.getId()).append(" "); break;
                case "nombre": sb.append("Nombre: ").append(p.getNombre()).append(" "); break;
                case "marca": sb.append("Marca: ").append(p.getMarca()).append(" "); break;
                case "precio": sb.append("Precio: ").append(p.getPrecio()).append(" "); break;
            }
        }
        System.out.println(sb.toString());
    }
}
