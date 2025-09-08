package Ejercicio;

class Gestion {
	private Estudiante[] listaEstudiantes;
	private Profesor[] listaProfesores;
	private Curso[] listaCursos;
	private int cantEstudiantes, cantProfesores, cantCursos;
	
	public Gestion() {
		listaEstudiantes = new Estudiante[50];
		listaProfesores = new Profesor[20];
		listaCursos = new Curso[50];
		cantEstudiantes = cantProfesores = cantCursos = 0;
	}
	
	public void registrarEstudiante(Estudiante e) {
		listaEstudiantes[cantEstudiantes++] = e;
	}
	
	public void registrarProfesor(Profesor p) {
		listaProfesores[cantProfesores++] = p;
	}
	
	public void registrarCurso(Curso c) {
		listaCursos[cantCursos++] = c;
	}
	
	public void mostrar() {
		System.out.println("Resumen");
		System.out.println("Estudiantes: "+ cantEstudiantes);
		System.out.println("Profesores: "+ cantProfesores);
		System.out.println("Cursos: "+cantCursos);
		
	}
	
	public static void main(String[] args) {
		Gestion sistema = new Gestion();
		
		Estudiante e1 = new Estudiante("Adrian","Mendoza", "752912", 20, "2024001913");
		Estudiante e2 = new Estudiante("Mateo","Martinez", "492064", 21, "2024001932");
		Profesor p1 = new Profesor("Carlos","Rodriguez", "453693", 51, "453693", "Informática");
		Curso c1 = new Curso("LP100","LENGUAJES DE PROGRAMACIÓN",4);
		
		sistema.registrarEstudiante(e1);
		sistema.registrarEstudiante(e2);
		sistema.registrarProfesor(p1);
		sistema.registrarCurso(c1);
		
		c1.asignarProfesor(p1);
		c1.agregarEstudiante(e1);
		c1.agregarEstudiante(e2);
		
		e1.matricularCurso("LENGUAJES DE PROGRAMACIÓN");
		e2.matricularCurso("LENGUAJES DE PROGRAMACIÓN");
		p1.asignarCurso("LENGUAJES DE PROGRAMACIÓN");
		
		sistema.mostrar();
		
		System.out.println("---------------------");
		e1.mostrarInfo();
		System.out.println("---------------------");
		e2.mostrarInfo();
		System.out.println("---------------------");
		p1.mostrarInfo();
		System.out.println("---------------------");
		c1.mostrarCurso();
		System.out.println("---------------------");
		Persona.mostrarTotalPersonas();
		
		
		
		/*
		e1.mostrarInfo();
		System.out.println("----------------------------------------------------");
		p1.mostrarInfo();
		System.out.println("----------------------------------------------------");
		e2.mostrarInfo();
		*/
	}

}
