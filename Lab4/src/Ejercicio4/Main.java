package Ejercicio4;

import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        RegistroEstudiantes registro = new RegistroEstudiantes(5);

        try {
            registro.agregarEstudiante("Luis");
            registro.agregarEstudiante("Diago");
            registro.agregarEstudiante("");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al agregar: " + e.getMessage());
        }

        try {
            String encontrado = registro.buscarEstudiante("Luis");
            System.out.println("Estudiante encontrado: " + encontrado);

            registro.buscarEstudiante("Maria");
        } catch (NoSuchElementException e) {
            System.out.println("Error al buscar: " + e.getMessage());
        }
    }
}
