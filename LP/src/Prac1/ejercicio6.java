package Prac1;
import java.util.Scanner;

public class ejercicio6 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int horas, minutos, segundos;
		
		do {
			System.out.print("Ingrese las horas: ");
			horas = scanner.nextInt();
			
			if (horas < 0) {
				System.out.println("Ingrese una cantidad válida.");
			}
		} while (horas < 0);
		
		do {
			System.out.print("Ingrese los minutos: ");
			minutos = scanner.nextInt();
			
			if (minutos < 0) {
				System.out.println("Ingrese una cantidad válida.");
			}
		} while (minutos < 0);
		
		do {
			System.out.print("Ingrese los segundos: ");
			segundos = scanner.nextInt();
			
			if (segundos < 0) {
				System.out.println("Ingrese una cantidad válida");
			}
		} while (segundos < 0);

		int totalSegundos = ((horas*3600) + (minutos * 60) + segundos);
		System.out.println("El total de segundos es: " + totalSegundos);
	}

}
