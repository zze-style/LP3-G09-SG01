package ejercicio4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Impresora impresora = new Impresora();
        ImpresoraMultifuncional impresoram = new ImpresoraMultifuncional();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Elige una opción:");
        System.out.println("1. Usar la impresora");
        System.out.println("2. Usar la impresora multifuncional");

        int opcion = scanner.nextInt();
        switch (opcion) {

            case 1:
                System.out.println("Elige una acción con la impresora:");
                System.out.println("1. Imprimir");
                System.out.println("2. Escanear");
                int opcion2 = scanner.nextInt();
                switch (opcion2) {
                    case 1:
                        impresora.imprimir();
                        break;
                    case 2:
                        impresora.escanear();
                        break;
                    default:
                        System.out.println("Opción inválida");
                }
                break;

            case 2:
                System.out.println("Elige una acción con la impresora multifuncional:");
                System.out.println("1. Imprimir");
                System.out.println("2. Escanear");
                int opcion3 = scanner.nextInt();
                switch (opcion3) {
                    case 1:
                        impresoram.imprimir();
                        break;
                    case 2:
                        impresoram.escanear();
                        break;
                    default:
                        System.out.println("Opción inválida");
                }
                break;

            default:
                System.out.println("Opcion inválida");
        }

        scanner.close();
    }
}
