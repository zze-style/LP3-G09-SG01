package Ejercicio2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Gestor g = new Gestor();
        Scanner sc = new Scanner(System.in);
        int op;

        do {
            System.out.println("\n=== GESTOR DE PERSONAJES ===");
            System.out.println("1. Mostrar personajes");
            System.out.println("2. Agregar personaje");
            System.out.println("3. Eliminar personaje");
            System.out.println("4. Actualizar atributo");
            System.out.println("5. Filtrar por atributo");
            System.out.println("6. Mostrar estadísticas");
            System.out.println("7. Cargar personajes aleatorios");
            System.out.println("8. Importar desde archivo");
            System.out.println("9. Subir nivel");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            op = sc.nextInt(); sc.nextLine();

            switch (op) {
                case 1 -> g.mostrar();
                case 2 -> {
                    System.out.print("Nombre: "); String n = sc.nextLine();
                    System.out.print("Vida: "); int v = sc.nextInt();
                    System.out.print("Ataque: "); int a = sc.nextInt();
                    System.out.print("Defensa: "); int d = sc.nextInt();
                    System.out.print("Alcance: "); int al = sc.nextInt();
                    g.agregar(new Personaje(n, v, a, d, al));
                }
                case 3 -> {
                    System.out.print("Nombre a eliminar: ");
                    g.eliminar(sc.nextLine());
                }
                case 4 -> {
                    System.out.print("Nombre: "); String n = sc.nextLine();
                    System.out.print("Atributo (vida, ataque, defensa, alcance): ");
                    String atr = sc.nextLine();
                    System.out.print("Nuevo valor: "); int val = sc.nextInt();
                    g.actualizarAtributo(n, atr, val);
                }
                case 5 -> {
                    System.out.print("Atributo para filtrar: ");
                    g.filtrarPor(sc.nextLine());
                }
                case 6 -> g.mostrarEstadisticas();
                case 7 -> g.cargarAleatorios();
                case 8 -> {
                    System.out.print("Archivo a importar (ej: personajes.txt): ");
                    g.importarDesdeArchivo(sc.nextLine());
                }
                case 9 -> {
                    System.out.print("Nombre del personaje: ");
                    g.subirNivel(sc.nextLine());
                }
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (op != 0);
    }
}
