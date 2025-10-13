package Ejercicio4;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class ContadorPalabras {

    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccione un archivo de texto");

        int seleccion = fileChooser.showOpenDialog(null);
        if (seleccion != JFileChooser.APPROVE_OPTION) {
            System.out.println("No se seleccionó ningún archivo. Saliendo...");
            return;
        }

        File archivo = fileChooser.getSelectedFile();

        if (!archivo.exists() || !archivo.isFile()) {
            System.out.println("Archivo no válido. Intente de nuevo.");
            return;
        }

        int totalLineas = 0;
        int totalPalabras = 0;
        int totalCaracteres = 0;
        Map<String, Integer> frecuencia = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                totalLineas++;
                totalCaracteres += linea.length();

                StringBuilder palabra = new StringBuilder();

                for (int i = 0; i < linea.length(); i++) {
                    char c = linea.charAt(i);
                    if (Character.isLetterOrDigit(c)) {
                        palabra.append(Character.toLowerCase(c));
                    } else {
                        if (palabra.length() > 0) {
                            String palabraFinal = palabra.toString();
                            totalPalabras++;
                            frecuencia.put(palabraFinal, frecuencia.getOrDefault(palabraFinal, 0) + 1);
                            palabra.setLength(0);
                        }
                    }
                }

                if (palabra.length() > 0) {
                    String palabraFinal = palabra.toString();
                    totalPalabras++;
                    frecuencia.put(palabraFinal, frecuencia.getOrDefault(palabraFinal, 0) + 1);
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        double promedioPalabras = (totalLineas > 0) ? (double) totalPalabras / totalLineas : 0;

        System.out.println("\n===== RESULTADOS =====");
        System.out.println("Total de líneas: " + totalLineas);
        System.out.println("Total de palabras: " + totalPalabras);
        System.out.println("Total de caracteres: " + totalCaracteres);
        System.out.printf("Promedio de palabras por línea: %.2f%n", promedioPalabras);

        // Palabras más frecuentes
        System.out.println("\nPalabras más frecuentes:");
        List<Map.Entry<String, Integer>> lista = new ArrayList<>(frecuencia.entrySet());
        lista.sort((a, b) -> b.getValue() - a.getValue());

        int limite = Math.min(10, lista.size()); // mostrar top 10
        for (int i = 0; i < limite; i++) {
            Map.Entry<String, Integer> e = lista.get(i);
            System.out.printf("%-12s -> %d veces%n", e.getKey(), e.getValue());
        }
    }
}
