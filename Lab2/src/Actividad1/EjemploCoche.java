package Actividad1;

public class EjemploCoche{

	
	public static void main(String[] args) {
		Coche cocheDeportivo = new Coche("Ferrari","F8", 2022, 250000);
		Coche cocheTodoTerreno = new Coche("Ford", "Explorer", 2020, 60000);
		
		cocheDeportivo.encender();
		cocheDeportivo.acelerar(70);
		cocheDeportivo.frenar(50);
		
		cocheTodoTerreno.encender();
		cocheTodoTerreno.acelerar(40);
		cocheTodoTerreno.frenar(30);
		cocheTodoTerreno.frenar(40);
	}

}
