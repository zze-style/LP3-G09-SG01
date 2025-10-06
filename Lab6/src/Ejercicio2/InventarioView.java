package Ejercicio2;

import java.util.List;

public class InventarioView {
    public void mostrarInventario(List<Item> items) {
        System.out.println("Inventario:");
        for (Item i : items) {
            System.out.println("- " + i);
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarDetalleItem(Item item) {
        if (item != null) {
            System.out.println("Item: " + item.getNombre() + " | Tipo: " + item.getTipo() + " | Cantidad: " + item.getCantidad());
        } else {
            System.out.println("El item no existe.");
        }
    }
}
