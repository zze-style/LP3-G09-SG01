package Ejercicio3; 

class EstudianteStrategy implements EstrategiaDescuento {
	public double aplicarDescuento(double precio) {
		return precio * 0.50;
	}
} 