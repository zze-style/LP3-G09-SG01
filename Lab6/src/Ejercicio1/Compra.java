package Ejercicio1;

import java.util.List;

public class Compra {
    private List<Producto> productos;
    private double total;

    public Compra(List<Producto> productos, double total) {
        this.productos = productos;
        this.total = total;
    }

    public double getTotal() { return total; }
    public List<Producto> getProductos() { return productos; }

    @Override
    public String toString() {
        return "Compra: " + productos.size() + " productos - Total: $" + total;
    }
}

