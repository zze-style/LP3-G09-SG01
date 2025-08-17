package Prac1;
import java.util.Scanner;

public class actividad1 {

	public static void main(String[] args) { //Función main para ejecutar el código
		Scanner scanner = new Scanner(System.in);
		System.out.print("Introduce un número: ");
		int n = scanner.nextInt();
		imprimirNumerosPrimos(n); //Llamado a la función imprimirNumerosPrimos, entregando la variable "n"
	}
	
	public static boolean esPrimo(int num) {
		if (num <= 1) {
			return false;
		}
		for (int i = 2; i <= num / 2; i++){ 
			if (num % i == 0) { 
				return false;
			}
		}
		
		return true;
	}
	
	public static void imprimirNumerosPrimos(int n){ 
		for (int num = 2; num <= n; num++) { 
			if (esPrimo(num)) {
					System.out.println(num + " es primo.");
					}
		}
	}
}
