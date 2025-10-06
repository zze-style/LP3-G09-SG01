package Ejercicio1;

import java.util.List;
import java.util.Scanner;

public class VistaConsola {
    private Scanner sc = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n--- MENÚ ---");
        System.out.println("1. Listar productos");
        System.out.println("2. Agregar producto al carrito");
        System.out.println("3. Eliminar producto del carrito");
        System.out.println("4. Ver carrito");
        System.out.println("5. Aplicar descuento");
        System.out.println("6. Calcular envío");
        System.out.println("7. Realizar compra");
        System.out.println("8. Ver historial de compras");
        System.out.println("0. Salir");
        System.out.print("Opción: ");
        return sc.nextInt();
    }

    public void mostrarProductos(List<Producto> productos) {
        for (Producto p : productos) {
            System.out.println(p);
        }
    }

    public void mostrarCarrito(List<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("El carrito está vacío.");
        } else {
            System.out.println("Carrito:");
            for (Producto p : productos) {
                System.out.println(p);
            }
        }
    }

    public void mostrarHistorial(List<Compra> compras) {
        if (compras.isEmpty()) {
            System.out.println("No hay compras registradas.");
        } else {
            for (Compra c : compras) {
                System.out.println(c);
            }
        }
    }

    public int pedirId() {
        System.out.print("Ingrese ID del producto: ");
        return sc.nextInt();
    }

    public double pedirDescuento() {
        System.out.print("Ingrese descuento (ej: 0.1 para 10%): ");
        return sc.nextDouble();
    }

    public double pedirEnvio() {
        System.out.print("Ingrese costo de envío: ");
        return sc.nextDouble();
    }

    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }
}

