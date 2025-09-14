package Actividades;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReporteTransacciones {

    public static void generarReporte(CuentaBancaria cuenta, String rutaArchivo)
            throws HistorialVacioException, IOException {

        if (cuenta.getSaldo() == 0) {
            throw new HistorialVacioException("La cuenta no tiene transacciones para reportar");
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(rutaArchivo))) {
            writer.println("Número de cuenta: " + cuenta.getNumCuenta());
            writer.println("Titular: " + cuenta.getTitular());
            writer.println("Saldo actual: " + cuenta.getSaldo());
            writer.println("----------");
            writer.println("Reporte generado exitosamente");
        }
    }

    public static void leerReporte(String rutaArchivo) throws FileNotFoundException {
        File archivo = new File(rutaArchivo);

        try (Scanner scanner = new Scanner(archivo)) {
            System.out.println("=== Contenido del reporte ===");
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        }
    }
}
