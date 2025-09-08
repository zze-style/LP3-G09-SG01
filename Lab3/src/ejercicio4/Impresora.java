package ejercicio4;

public class Impresora implements Imprimible{

	public void escanear() {
		throw new UnsupportedOperationException("La impresora no puede escanear");
	}

	public void imprimir() {
		System.out.println("Imprimiendo documento");
		
	}
}
