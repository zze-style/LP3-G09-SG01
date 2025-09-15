package Ejercicio2;
import Ejercicio2.DivisionPorCeroException;

public class Calculadora {
	
	public double sumar(double a, double b) {
		return a + b;
	}
	
	public double restar(double a, double b) {
		return a - b;
	}
	
	public double multiplicar(double a, double b) {
		return a * b;
	}
	
	public double dividir(double a, double b) throws DivisionPorCeroException {
		
		if (a < 0 || b < 0) {
			throw new IllegalArgumentException("Los argumentos no pueden ser negativos");
		}
		
		if (b == 0 ) {
			throw new DivisionPorCeroException("No se puede dividir entre 0");
			}
		return a/b;
	}
}
