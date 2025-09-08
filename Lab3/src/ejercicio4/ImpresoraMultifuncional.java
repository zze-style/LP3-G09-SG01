package ejercicio4;

public class ImpresoraMultifuncional implements Imprimible, Escaneable{
	
	@Override
	public void imprimir() {
		System.out.println("Imprimiento documento");
	}
	
	@Override
	public void escanear() {
		System.out.println("Escaneando documento");
	}

}
