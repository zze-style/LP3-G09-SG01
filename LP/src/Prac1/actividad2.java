package Prac1;
import java.util.Scanner;

public class actividad2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Introduce un número entero: ");
		int numero = scanner.nextInt();
		int original = numero;
		int inverso = 0;
		
		while (numero != 0) { 
			inverso = inverso * 10 + (numero % 10);
			numero /= 10;
		}
		
		if (original == inverso) {
			System.out.println(original + " es un palíndromo.");
		} 
		else {
			System.out.println(original + " no es un palíndromo.");
			}
	}


}
