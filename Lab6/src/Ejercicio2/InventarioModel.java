package Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class InventarioModel {
    private List<Item> items = new ArrayList<>();

    public void agregarItem(Item item) { items.add(item); }
    public void eliminarItem(Item item) { items.remove(item); }
    public List<Item> getItems() { return items; }

    public Item buscarItem(String nombre) {
        for (Item i : items) {
            if (i.getNombre().equalsIgnoreCase(nombre)) {
                return i;
            }
        }
        return null;
    }
}
