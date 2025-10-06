package Ejercicio2;

public class Jugador {
    private String nombre;
    private int salud;
    private int nivel;
    private InventarioModel inventario;
    private Item equipado;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.salud = 100;
        this.nivel = 1;
        this.inventario = new InventarioModel();
    }

    public String getNombre() { return nombre; }
    public int getSalud() { return salud; }
    public InventarioModel getInventario() { return inventario; }

    public void recibirDaño(int daño) {
        salud -= daño;
        if (salud < 0) salud = 0;
    }

    public void recibirCura(int cura) {
        salud += cura;
        if (salud > 100) salud = 100;
    }

    public void equipar(Item item) {
        this.equipado = item;
        System.out.println(nombre + " ha equipado " + item.getNombre());
    }

    public void atacar(Enemigo enemigo) {
        int daño = 5;
        if (equipado != null && equipado.getTipo().equalsIgnoreCase("Arma")) {
            daño = 20;
        }
        enemigo.recibirDaño(daño);
        System.out.println(nombre + " atacó a " + enemigo.getNombre() + " causando " + daño + " de daño.");
    }

    public void usarObjeto(String nombreItem) {
        Item i = inventario.buscarItem(nombreItem);
        if (i != null) {
            i.usarItem(this);
        } else {
            System.out.println("Objeto no encontrado en el inventario.");
        }
    }

    public boolean estaVivo() {
        return salud > 0;
    }
}
