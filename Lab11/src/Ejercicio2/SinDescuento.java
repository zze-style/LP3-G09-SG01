package Ejercicio2;

import java.util.List;

class SinDescuento implements EstrategiaDescuento {
	
	@Override
	public double aplicarDescuento(List<Producto> productos) {
		double total = 0;
		for (Producto p : productos) {
			p.setPrecioFinal(p.getPrecioBase()*p.getCantidad());
			total += p.getPrecioFinal();
		}
		System.out.println("Total sin descuento: $" + total);
		return total;
	}
} 

