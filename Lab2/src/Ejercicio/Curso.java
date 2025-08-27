package Ejercicio;

public class Curso {
	private String nombreCurso;
	private String codigoCurso;
	private int creditosCurso;
	private Profesor profesor;
	private Estudiante[] estudiantes;
	private int cantidadEstudiantes;
	
	public Curso(String nombre, String codigo, int creditos) {
		this.nombreCurso = nombre;
		this.codigoCurso = codigo;
		this.creditosCurso = creditos;
		this.estudiantes = new Estudiante[18];
		this.cantidadEstudiantes = 0;
	}
	
	public void asignarProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	
	public void agregarEstudiante(Estudiante e) {
		if (cantidadEstudiantes < estudiantes.length) {
			estudiantes[cantidadEstudiantes++] = e;
		}
	}
	
	public void mostrarCurso() {
		System.out.println("Curso: "+nombreCurso);
		System.out.println("Código del curso: "+codigoCurso);
		System.out.println("Creditos del curso: "+creditosCurso);
		if (profesor != null) {
			System.out.println("Docente asignado: "+profesor.nombre +" "+profesor.apellido);
		} else {
			System.out.println("Aún no hay un docente asignado");
		}
		System.out.println("Estudiantes inscritos: "+cantidadEstudiantes);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
