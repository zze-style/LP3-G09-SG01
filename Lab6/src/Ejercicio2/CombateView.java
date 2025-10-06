package Ejercicio2;

import java.util.List;

public class CombateView {
    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }

    public void mostrarEstado(Jugador jugador, List<Enemigo> enemigos) {
        System.out.println("Estado del Jugador: " + jugador.getNombre() + " - Salud: " + jugador.getSalud());
        for (Enemigo e : enemigos) {
            System.out.println("Enemigo: " + e.getNombre() + " - Salud: " + e.getSalud());
        }
        System.out.println("--------------------------");
    }
}
