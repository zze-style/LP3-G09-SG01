package Ejercicio2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Jugador jugador = new Jugador("Héctor");
        Item espada = new Item("Espada", 1, "Arma", "Espada de acero");
        Item pocion = new Item("Poción de Vida", 2, "Poción", "Recupera salud");
        jugador.getInventario().agregarItem(espada);
        jugador.getInventario().agregarItem(pocion);
        jugador.equipar(espada);

        List<Enemigo> enemigos = new ArrayList<>();
        enemigos.add(new Enemigo("Orco", "Bestia", 1));
        enemigos.add(new Enemigo("Bandido", "Humano", 2));

        CombateView vista = new CombateView();
        CombateController controller = new CombateController(jugador, enemigos, vista);

        controller.iniciarCombate();
    }
}


