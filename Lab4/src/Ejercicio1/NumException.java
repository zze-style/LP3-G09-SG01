package Ejercicio1;

public class NumException extends Exception{
	public NumException (char c) {
		super("Se ingresó el número: "+c);
	}
}
