package Ejercicio2;

import java.io.Serializable;

public class Personaje implements Serializable {
    private String nombre;
    private int vida;
    private int ataque;
    private int defensa;
    private int alcance;
    private int nivel;

    public Personaje(String nombre, int vida, int ataque, int defensa, int alcance) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.alcance = alcance;
        this.nivel = 1;
    }

    public String getNombre() { return nombre; }
    public int getVida() { return vida; }
    public int getAtaque() { return ataque; }
    public int getDefensa() { return defensa; }
    public int getAlcance() { return alcance; }
    public int getNivel() { return nivel; }

    public void setVida(int vida) { this.vida = vida; }
    public void setAtaque(int ataque) { this.ataque = ataque; }
    public void setDefensa(int defensa) { this.defensa = defensa; }
    public void setAlcance(int alcance) { this.alcance = alcance; }
    public void setNivel(int nivel) { this.nivel = nivel; }

    public void subirNivel() {
        nivel++;
        vida += 1;
        ataque += 1;
        defensa += 1;
        alcance += 1;
    }

    @Override
    public String toString() {
        return String.format("%-12s Vida:%d  Ataque:%d  Defensa:%d  Alcance:%d  Nivel:%d",
                nombre, vida, ataque, defensa, alcance, nivel);
    }
}

