package Ejercicio2;

import java.util.Random;

public class Enemigo {
    private String nombre;
    private int salud;
    private int nivel;
    private String tipo;

    public Enemigo(String nombre, String tipo, int nivel) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = nivel;
        this.salud = 50 + (nivel * 10);
    }

    public String getNombre() { return nombre; }
    public int getSalud() { return salud; }
    public boolean estaVivo() { return salud > 0; }

    public void recibirDaño(int daño) {
        salud -= daño;
        if (salud < 0) salud = 0;
    }

    public void atacar(Jugador jugador) {
        Random r = new Random();
        int daño = r.nextInt(10) + 5;
        jugador.recibirDaño(daño);
        System.out.println(nombre + " atacó a " + jugador.getNombre() + " causando " + daño + " de daño.");
    }
}
