package Vista;

import Controlador.ControladorEmpleado;
import Modelo.Empleado;
import java.util.*;

public class VistaEmpleado {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ControladorEmpleado ctrl = new ControladorEmpleado();
        int opcion;

        do {
            System.out.println("\n--- MENÚ EMPLEADOS ---");
            System.out.println("1. Listar empleados");
            System.out.println("2. Agregar empleado");
            System.out.println("3. Buscar empleado");
            System.out.println("4. Eliminar empleado");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> ctrl.leerEmpleados().forEach(System.out::println);
                case 2 -> {
                    System.out.print("Número: "); int num = sc.nextInt(); sc.nextLine();
                    System.out.print("Nombre: "); String nom = sc.nextLine();
                    System.out.print("Sueldo: "); double sue = sc.nextDouble();
                    ctrl.agregarEmpleado(new Empleado(num, nom, sue));
                }
                case 3 -> {
                    System.out.print("Número a buscar: "); int num = sc.nextInt();
                    Empleado e = ctrl.buscarEmpleado(num);
                    System.out.println(e != null ? e : "Empleado no encontrado.");
                }
                case 4 -> {
                    System.out.print("Número a eliminar: "); int num = sc.nextInt();
                    ctrl.eliminarEmpleado(num);
                }
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }
}

