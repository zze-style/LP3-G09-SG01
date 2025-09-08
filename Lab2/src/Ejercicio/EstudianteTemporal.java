package Ejercicio;

public class EstudianteTemporal extends Estudiante {
	
	private int cantidadDias;
	
	public EstudianteTemporal(String nombre, String apellido, String dni, int edad, String codigoEstudiante, int cantidadDias) {
		super(nombre, apellido, dni, edad, codigoEstudiante);
		this.cantidadDias = cantidadDias;
	}
	
	@Override
	public void mostrarInfo() {
		super.mostrarInfo();
		System.out.println("Tipo: Estudiante temporal, Cantidad de dias: "+cantidadDias);
	}
	
	@Override
	public String rol() {
		return "Estudiante temporal";
	}

	public static void main(String[] args) {
		
		Estudiante e12 = new Estudiante("Adrian","Mendoza", "752912", 20, "2024001913");
		EstudianteTemporal e13 = new EstudianteTemporal("Mateo","Martinez", "7421291", 18, "2024001913", 40);
		Profesor p1 = new Profesor("Carlos","Rodriguez", "453693", 51, "453693", "Informática");
		
	
	}

}
