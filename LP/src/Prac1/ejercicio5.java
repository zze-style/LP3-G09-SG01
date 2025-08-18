package Prac1;
import java.util.Scanner;

public class ejercicio5 {
	
	public static double costoTotal(double horas) {
		final double inicial = 3.00;
		final double cadahora = 0.50;
		final double maximo = 12.00;
		double costo = 0.0;
		
		if (horas <= 1) {
			costo = inicial;
		} else {
			costo = inicial + (cadahora * (Math.round(horas) - 1));
		}
		
		if (costo > maximo) {
			costo = maximo;
		}
		return costo;
	}

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		double tiempo;
		
		do {
			System.out.print("Ingrese la cantidad de horas a quedarse (Se considera una hora pasados los 30 minutos): ");
			tiempo = scanner.nextDouble();
			
			if (tiempo <= 0.4) {
				System.out.println("Se ha ingresado un número válido. Inténtalo de nuevo.");
			}
			
		} while(tiempo <= 0.4);
		
		double costoFinal = costoTotal(tiempo);
		System.out.println("BOLETA FINAL");
		System.out.println("El cargo es de S/. " + costoFinal);
		
		}

}
