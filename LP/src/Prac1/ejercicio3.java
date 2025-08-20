package Prac1;
import java.util.Random;
	public class ejercicio3 {
		public static void main(String[] args) {
			int[] frecuencia = new int[7];
			for (int i = 0; i < 20000; i++) {
				int dado = (int)((Math.random() * 6) + 1);
				frecuencia[dado]++;
			}

				for (int i = 1; i < frecuencia.length; i++)
					System.out.println("Cara " + i + ": " + frecuencia[i] + " veces");
		}
}
