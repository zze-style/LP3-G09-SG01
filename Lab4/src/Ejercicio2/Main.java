package Ejercicio2;
import Ejercicio2.Calculadora;
import Ejercicio2.DivisionPorCeroException;

public class Main {

	public static void main(String[] args) {
		
		try {
			Calculadora calculadora = new Calculadora();
			
			System.out.println(calculadora.sumar(10,2));
			System.out.println(calculadora.dividir(10, -2));
			
		} catch (DivisionPorCeroException e) {
			System.err.println("Error de división: " + e.getMessage());
		} catch (IllegalArgumentException e) {
			System.err.println("Error de argumento: "+ e.getMessage());
		} catch (Exception e) {
			System.err.println("Error general: "+e.getMessage());
		}

	}

}
