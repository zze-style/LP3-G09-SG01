package Actividades;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MainReportes {

    public static void main(String[] args) {
        CuentaBancaria cuentaVacia = new CuentaBancaria("001", "Hector", 0);
        CuentaBancaria cuentaConSaldo = new CuentaBancaria("002", "Luis", 500);

        String archivo = "reporte.txt";

        System.out.println("CUENTA VACÍA ");
        try {
            ReporteTransacciones.generarReporte(cuentaVacia, archivo);
        } catch (HistorialVacioException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }

        System.out.println("CUENTA CON SALDO");
        try {
            ReporteTransacciones.generarReporte(cuentaConSaldo, archivo);
            System.out.println("Reporte generado correctamente.");
        } catch (HistorialVacioException | IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("REPORTE EXISTENTE");
        try {
            ReporteTransacciones.leerReporte(archivo);
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        }

        System.out.println("REPORTE INEXISTENTE");
        try {
            ReporteTransacciones.leerReporte("archivo_noexiste.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }
    }
}
