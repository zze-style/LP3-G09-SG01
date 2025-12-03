package Ejercicio2;

public class Producto {
	public String nombre;
	public double precioBase;
	public double precioFinal;
	public int cantidad;
	
	public Producto(String nombre, double precioBase, int cantidad) {
		this.nombre = nombre;
		this.precioBase = precioBase;
		this.precioFinal = precioBase * cantidad;
		this.cantidad = cantidad;
	}

	public double getPrecioFinal() {
		return precioFinal;
	}

	public void setPrecioFinal(double precioFinal) {
		this.precioFinal = precioFinal;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPrecioBase() {
		return precioBase;
	}

	public int getCantidad() {
		return cantidad;
	}
	
	
}
