package Ejercicio4;
import java.util.NoSuchElementException;

public class RegistroEstudiantes {
	private String[] estudiantes;
	private int contador;
	
	public RegistroEstudiantes(int capacidad) {
		estudiantes = new String[capacidad];
		contador = 0;
	}
	
	
	public void agregarEstudiante(String nombre) {
		if (nombre == null || nombre.trim().isEmpty()) {
			throw new IllegalArgumentException("El nombre no puede estar vacío");
		}
		if (contador >= estudiantes.length) {
			throw new IllegalStateException("No hay espacio");
		}
		estudiantes[contador++] = nombre;
	}
	
	public String buscarEstudiante(String nombre) {
		for (int i = 0; i < contador; i++) {
			if (estudiantes[i].equalsIgnoreCase(nombre)) {
				return estudiantes[i];
			}
		}
		throw new NoSuchElementException("No se encontró al estudiante:"+nombre);
	}
}
