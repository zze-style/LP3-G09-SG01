package Prac1;
import java.util.Scanner;

public class ejercicio2 {

	public static void main(String[] args) {
		int[] arreglo = new int[10];
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Ingrese el número 1: ");
		arreglo[0] = scanner.nextInt();
		
		for(int i = 1; i < 10; i++) {
			System.out.print("Ingrese el número " + (i+1) + ": ");
			int numeroact = scanner.nextInt();
			
			if (numeroact > arreglo[i-1]) {
				arreglo[i] = numeroact;
			}
			else {
				System.out.println("El número ingresado no es mayor que el anterior. Intente nuevamente.");
				i--;
			}
		}
		
		System.out.println("Se guardaron todos los números correctamente.");
		
		System.out.print("El arreglo es [");
		for (int i = 0; i < 10 ; i++) {
			System.out.print(arreglo[i]);
			if (i < 9) {
				System.out.print(", ");
			}
		}
		System.out.print("]");
	}
	
	

}
