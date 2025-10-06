package Ejercicio2;

import java.util.List;
import java.util.Random;

public class CombateController {
    private Jugador jugador;
    private List<Enemigo> enemigos;
    private CombateView vista;

    public CombateController(Jugador jugador, List<Enemigo> enemigos, CombateView vista) {
        this.jugador = jugador;
        this.enemigos = enemigos;
        this.vista = vista;
    }

    public void iniciarCombate() {
        Random r = new Random();
        vista.mostrarMensaje("¡Comienza el combate!");

        while (jugador.estaVivo() && enemigos.stream().anyMatch(Enemigo::estaVivo)) {
            Enemigo objetivo = enemigos.get(r.nextInt(enemigos.size()));
            if (objetivo.estaVivo()) {
                jugador.atacar(objetivo);
                vista.mostrarEstado(jugador, enemigos);
            }

            for (Enemigo e : enemigos) {
                if (e.estaVivo()) {
                    e.atacar(jugador);
                    vista.mostrarEstado(jugador, enemigos);
                }
            }
        }

        if (jugador.estaVivo()) {
            vista.mostrarMensaje("¡El jugador ha ganado!");
        } else {
            vista.mostrarMensaje("El jugador ha sido derrotado.");
        }
    }
}
