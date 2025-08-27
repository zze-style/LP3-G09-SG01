package Actividad3;

public class TestAgregacion {

	public static void main(String[] args) {
		
		Motor m1 = new Motor(1001,7000);
		Automovil a1 = new Automovil("123 ASD",4,"Ford","Taurus", m1);
		
		
		System.out.println(a1);

	}

}
