package Ejercicio2;

public class InventarioController {
    private InventarioModel modelo;
    private InventarioView vista;

    public InventarioController(InventarioModel modelo, InventarioView vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void agregarItem(Item item) {
        modelo.agregarItem(item);
        vista.mostrarMensaje("Item agregado: " + item.getNombre());
    }

    public void eliminarItem(Item item) {
        modelo.eliminarItem(item);
        vista.mostrarMensaje("Item eliminado: " + item.getNombre());
    }

    public void verInventario() {
        vista.mostrarInventario(modelo.getItems());
    }

    public void mostrarDetalles(String nombre) {
        Item item = modelo.buscarItem(nombre);
        vista.mostrarDetalleItem(item);
    }

    public Item buscarItem(String nombre) {
        return modelo.buscarItem(nombre);
    }
}
