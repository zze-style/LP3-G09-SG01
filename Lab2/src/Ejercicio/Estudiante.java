package Ejercicio;

class Estudiante extends Persona{
	private String codigoEstudiante;
	private String[] cursosInscritos;
	private int cantidadCursos;
	public static final int maxCursos = 6;
	protected static int totalEstudiantes = 0;
	
	public Estudiante(String nombre, String apellido, String dni, int edad, String codigoEstudiante) {
		super(nombre, apellido, dni, edad);
		this.codigoEstudiante = codigoEstudiante;
		this.cursosInscritos = new String[maxCursos];
		this.cantidadCursos = 0;
		totalEstudiantes++;
	}
	
	@Override
	public String rol() {
		return "Estudiante";
	}
	
	public void matricularCurso(String curso) {
		if (cantidadCursos < maxCursos) {
			cursosInscritos[cantidadCursos++] = curso;
		} else {
			System.out.println("Se ha pasado el límite, no puede inscribirse en más cursos.");
		}
		
	}
	
	@Override
	public void mostrarInfo() {
		super.mostrarInfo();
		System.out.println("Código de estudiante: "+codigoEstudiante);
		System.out.println("Cursos inscritos: "+cantidadCursos);
	}
	
	public static void mostrarTotalEstudiantes() {
		System.out.println("El total de estudiantes es : "+totalEstudiantes);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
