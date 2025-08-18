package Prac1;

public class ejercicio4 {

	public static double menorde(double num1, double num2, double num3) {
		double menor = num1;
		if (num2 < menor) {
			menor = num2;
		}
		if (num3 < menor) {
			menor = num3;
		}
		return menor;
	}
	
	public static void main(String[] args) {
		double resultado = menorde(1.70, 1.23, 1.11);
		System.out.println("El número menor es " + resultado);
	}
}
