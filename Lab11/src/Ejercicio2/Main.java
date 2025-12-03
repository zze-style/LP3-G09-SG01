package Ejercicio2;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalculadoraDePrecios calculadora = new CalculadoraDePrecios();
        
        List<Producto> cesta = new ArrayList<>();
        cesta.add(new Producto("Laptop", 1200.00, 1));
        cesta.add(new Producto("Mouse Inalámbrico", 25.00, 3)); // 3 unidades
        cesta.add(new Producto("Teclado Mecánico", 75.00, 1));

        System.out.println("      SISTEMA DE DESCUENTOS (STRATEGY)   ");
        System.out.println("Productos en la Cesta:");
        for (Producto p : cesta) {
            System.out.println("- " + p.getNombre() + " (x" + p.getCantidad() + "): $" + p.getPrecioBase());
        }
        System.out.println("-----------------------------------------");
        
        EstrategiaDescuento estrategiaSeleccionada = null;

        while (estrategiaSeleccionada == null) {
            System.out.println("\nElija una estrategia de descuento:");
            System.out.println("1. Sin Descuento");
            System.out.println("2. Descuento Fijo (10% al Total)");
            System.out.println("3. Descuento Porcentual (30% si >= 2 unid. iguales)");
            System.out.println("4. Descuento Acumulado (50% al producto más bajo si >= 3 productos en total)");
            System.out.print("Opción: ");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    estrategiaSeleccionada = new SinDescuento();
                    break;
                case "2":
                    estrategiaSeleccionada = new DescuentoFijo();
                    break;
                case "3":
                    estrategiaSeleccionada = new DescuentoPorcentual();
                    break;
                case "4":
                    estrategiaSeleccionada = new DescuentoPorcentualAcumulado();
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }

        // Aplicar la estrategia seleccionada
        calculadora.setEstrategia(estrategiaSeleccionada);
        double totalFinal = calculadora.calcularTotal(cesta);

        System.out.println("TOTAL FINAL DE LA COMPRA: $" + String.format("%.2f", totalFinal));
        
        scanner.close();
    }
}
