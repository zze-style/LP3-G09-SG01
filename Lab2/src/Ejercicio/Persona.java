package Ejercicio;

abstract class Persona {
	protected String nombre;
	protected String apellido;
	protected String dni;
	protected int edad;
	private static int contadorPersonas = 0;
	
	public Persona(String nombre, String apellido, String dni, int edad) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.edad = edad;
		contadorPersonas++;
	}
	
	public void mostrarInfo() {
		System.out.println("Nombre: "+nombre);
		System.out.println("Apellido: "+apellido);
		System.out.println("DNI: "+dni);
		System.out.println("Edad: "+edad);
	}
	
	public abstract String rol();
	
	public static void mostrarTotalPersonas() {
		System.out.println("El total de personas registradas es: "+contadorPersonas);
	}
	public static void main(String[] args) {

		Persona.mostrarTotalPersonas();
	}

}
