package Ejercicio3;

public class Numero {
	private double valor;

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		if (valor < 0) {
			throw new IllegalArgumentException("No puede ser un número negativo");
		}
		this.valor = valor;
	}
	
	
	
}
