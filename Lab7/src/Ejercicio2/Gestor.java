package Ejercicio2;


import java.io.*;
import java.util.*;

public class Gestor {
    private List<Personaje> lista = new ArrayList<>();
    private final String archivo = "personajes.dat";

    public Gestor() {
        cargar();
    }

    public void agregar(Personaje p) {
        if (buscar(p.getNombre()) != null) {
            System.out.println("El personaje ya existe.");
            return;
        }
        lista.add(p);
        guardar();
        System.out.println("Personaje agregado.");
    }

    public void mostrar() {
        if (lista.isEmpty()) {
            System.out.println("No hay personajes.");
        } else {
            lista.forEach(System.out::println);
        }
    }

    public Personaje buscar(String nombre) {
        for (Personaje p : lista) {
            if (p.getNombre().equalsIgnoreCase(nombre))
                return p;
        }
        return null;
    }

    public void eliminar(String nombre) {
        Personaje p = buscar(nombre);
        if (p != null) {
            lista.remove(p);
            guardar();
            System.out.println("Personaje eliminado.");
        } else {
            System.out.println("No encontrado.");
        }
    }

    public void actualizarAtributo(String nombre, String atributo, int nuevoValor) {
        Personaje p = buscar(nombre);
        if (p == null) {
            System.out.println("No existe ese personaje.");
            return;
        }
        switch (atributo.toLowerCase()) {
            case "vida" -> p.setVida(nuevoValor);
            case "ataque" -> p.setAtaque(nuevoValor);
            case "defensa" -> p.setDefensa(nuevoValor);
            case "alcance" -> p.setAlcance(nuevoValor);
            default -> { System.out.println("Atributo no válido."); return; }
        }
        guardar();
        System.out.println("Atributo actualizado.");
    }

    public void filtrarPor(String atributo) {
        Comparator<Personaje> comp;
        switch (atributo.toLowerCase()) {
            case "vida" -> comp = Comparator.comparing(Personaje::getVida);
            case "ataque" -> comp = Comparator.comparing(Personaje::getAtaque);
            case "defensa" -> comp = Comparator.comparing(Personaje::getDefensa);
            case "alcance" -> comp = Comparator.comparing(Personaje::getAlcance);
            default -> { System.out.println("Atributo no válido."); return; }
        }
        lista.stream().sorted(comp.reversed()).forEach(System.out::println);
    }

    public void mostrarEstadisticas() {
        if (lista.isEmpty()) {
            System.out.println("No hay personajes para calcular estadísticas.");
            return;
        }
        double total = lista.size();
        double promVida = lista.stream().mapToInt(Personaje::getVida).average().orElse(0);
        double promAtaque = lista.stream().mapToInt(Personaje::getAtaque).average().orElse(0);
        double promDefensa = lista.stream().mapToInt(Personaje::getDefensa).average().orElse(0);
        double promAlcance = lista.stream().mapToInt(Personaje::getAlcance).average().orElse(0);

        System.out.println("Total de personajes: " + (int) total);
        System.out.printf("Promedio Vida: %.2f, Ataque: %.2f, Defensa: %.2f, Alcance: %.2f%n",
                promVida, promAtaque, promDefensa, promAlcance);
    }

    public void cargarAleatorios() {
        String[] nombres = {"Caballero", "Guerrero", "Arquero", "Mago", "Ladrón"};
        Random r = new Random();
        for (String n : nombres) {
            if (buscar(n) == null) {
                int vida = r.nextInt(5) + 1;
                int ataque = r.nextInt(5) + 1;
                int defensa = r.nextInt(5) + 1;
                int alcance = r.nextInt(5) + 1;
                lista.add(new Personaje(n, vida, ataque, defensa, alcance));
            }
        }
        guardar();
        System.out.println("Personajes aleatorios cargados.");
    }

    public void importarDesdeArchivo(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 5) {
                    String nom = datos[0];
                    int vida = Integer.parseInt(datos[1]);
                    int ataque = Integer.parseInt(datos[2]);
                    int defensa = Integer.parseInt(datos[3]);
                    int alcance = Integer.parseInt(datos[4]);
                    if (buscar(nom) == null) {
                        lista.add(new Personaje(nom, vida, ataque, defensa, alcance));
                    }
                }
            }
            guardar();
            System.out.println("Importación completada.");
        } catch (IOException e) {
            System.out.println("Error al importar: " + e.getMessage());
        }
    }

    public void subirNivel(String nombre) {
        Personaje p = buscar(nombre);
        if (p != null) {
            p.subirNivel();
            guardar();
            System.out.println("¡" + p.getNombre() + " subió al nivel " + p.getNivel() + "!");
        } else {
            System.out.println("Personaje no encontrado.");
        }
    }

    private void guardar() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(lista);
        } catch (Exception e) {
            System.out.println("Error al guardar.");
        }
    }

    private void cargar() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            lista = (List<Personaje>) ois.readObject();
        } catch (FileNotFoundException e) {
            lista = new ArrayList<>();
        } catch (Exception e) {
            System.out.println("Error al cargar archivo.");
        }
    }
}
