package Ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    public void eliminarProducto(int id) {
        productos.removeIf(p -> p.getId() == id);
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public double calcularTotal(double descuento, double envio) {
        double subtotal = 0;
        for (Producto p : productos) {
            subtotal += p.getPrecio();
        }
        subtotal -= subtotal * descuento;
        subtotal += envio;
        return subtotal;
    }

    public void vaciar() {
        productos.clear();
    }

    public boolean estaVacio() {
        return productos.isEmpty();
    }
}

