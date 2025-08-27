package Ejercicio;

class Profesor extends Persona {
	private String especialidad;
	private String codigoProfesor;
	private String[] cursosAsignados;
	private int cantidadCursos;
	
	public Profesor(String nombre, String apellido, String dni, int edad, String codigoProfesor, String especialidad) {
		super(nombre, apellido, dni, edad);
		this.especialidad = especialidad;
		this.codigoProfesor = codigoProfesor;
		this.cursosAsignados = new String[10];
		this.cantidadCursos = 0;
	}
	
	@Override
	public String rol() {
		return "Profesor";
	}
	
	public void asignarCurso(String curso) {
		cursosAsignados[cantidadCursos++] = curso;
	}
	
	@Override
	public void mostrarInfo() {
		super.mostrarInfo();
		System.out.println("Especialidad del docente: "+ especialidad);
		System.out.println("Código de profesor: "+codigoProfesor);
		System.out.println("Cursos asignados: "+cantidadCursos);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
