package Actividades;

import java.util.List;
import java.util.Scanner;

public class PedidoVista {
    private Scanner sc = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("\n--- MENÚ ---");
        System.out.println("1. Agregar Pedido");
        System.out.println("2. Mostrar Pedidos");
        System.out.println("3. Eliminar Pedido");
        System.out.println("4. Actualizar Pedido");
        System.out.println("5. Buscar Pedido");
        System.out.println("6. Contar Pedidos");
        System.out.println("7. Marcar Pedido como Completo");
        System.out.println("8. Mostrar Pedidos por Estado");
        System.out.println("9. Contador de Pendientes");
        System.out.println("10. Ver Historial");
        System.out.println("11. Salir");
        System.out.print("Opción: ");
    }

    public String solicitarOpcion() {
        return sc.nextLine();
    }

    public String solicitarNombrePlato() {
        System.out.print("Ingrese nombre del plato: ");
        return sc.nextLine();
    }

    public String solicitarTipoPlato() {
        System.out.print("Ingrese tipo del plato: ");
        return sc.nextLine();
    }

    public void mostrarPedidos(List<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos.");
        } else {
            for (Pedido p : pedidos) {
                System.out.println(p);
            }
        }
    }

    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }

    public void cerrarScanner() {
        sc.close();
    }
}
