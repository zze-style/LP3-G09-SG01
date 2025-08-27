package Actividad2;

public class Contador {

	static int acumulador = 0;
	final static int VALOR_INICIAL = 10;
	private int valor;
	private static int nContadores = 0;
	private static int ultimoContador = 0;
	
	public static int acumulador() {
		return acumulador;
	}
	
	public Contador(int valor) {
		this.valor = valor;
		Contador.ultimoContador = this.valor;
		Contador.acumulador += valor;
		nContadores++;
	}
	
	public Contador(){
		new Contador(Contador.VALOR_INICIAL);
	}
	
	public static int getNContadores() {
		return nContadores;
	}
	
	public void inc() {
		this.valor++;
		acumulador++;
	}
	
	public int getValor() {
		return this.valor;
	}
	
	public static int getUltimoContador() {
		return Contador.ultimoContador;
	}

}

