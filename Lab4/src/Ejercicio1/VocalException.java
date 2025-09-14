package Ejercicio1;

public class VocalException extends Exception {
	public VocalException(char c) {
		super("Se ingresó la vocal: "+c);
	}
}
