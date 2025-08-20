package Prac1;

public class ejercicio1 {

	public static int sumaArreglo(int[] arr) {
		int suma = 0;
		for (int i = 0; i < arr.length; i++) {
			suma += arr[i];
		}
		return suma;
	}
	
	public static void main(String[] args) {
	       int[] numeros = {1, 2, 2, 3, 5};
	       System.out.println("La suma es: " + sumaArreglo(numeros));
	   }

}
