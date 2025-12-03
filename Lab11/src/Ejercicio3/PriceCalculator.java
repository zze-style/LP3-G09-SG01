package Ejercicio3;

class PriceCalculator {
	private EstrategiaDescuento estrategiaDescuento;
	public void setEstrategiaDescuento(EstrategiaDescuento estrategiaDescuento) {
		this.estrategiaDescuento = estrategiaDescuento;
	}
	public double calcularPrecio(double precio) {
		return estrategiaDescuento.aplicarDescuento(precio);
	}
} 
