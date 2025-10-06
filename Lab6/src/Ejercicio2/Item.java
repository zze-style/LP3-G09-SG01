package Ejercicio2;

public class Item {
    private String nombre;
    private int cantidad;
    private String tipo;
    private String descripcion;

    public Item(String nombre, int cantidad, String tipo, String descripcion) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public void usarItem(Jugador jugador) {
        if (tipo.equalsIgnoreCase("Poción") && cantidad > 0) {
            jugador.recibirCura(20);
            cantidad--;
            System.out.println(jugador.getNombre() + " usó una poción y recuperó salud.");
        }
    }

    @Override
    public String toString() {
        return nombre + " (" + tipo + ") x" + cantidad;
    }
}
