package Ejercicio3;

class UsuarioFrecuenteStrategy implements EstrategiaDescuento {
	public double aplicarDescuento(double precio) {
		return precio * 0.80;
	}
} 

