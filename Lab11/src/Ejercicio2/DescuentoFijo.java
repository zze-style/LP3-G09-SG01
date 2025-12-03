package Ejercicio2;

import java.util.List;

class DescuentoFijo implements EstrategiaDescuento {
	private static final double PORCENTAJE_DESCUENTO = 0.10;
	
	@Override
	public double aplicarDescuento(List<Producto> productos) {
		double totalBase = 0;
		for (Producto p : productos) {
			double precioItem = p.getPrecioBase()*p.getCantidad();
			totalBase += precioItem;
			p.setPrecioFinal(totalBase);
		}
		
		double descuento = totalBase * PORCENTAJE_DESCUENTO;
		double totalFinal = totalBase - descuento;
		
		System.out.println("Descuento fijo (10%) aplicado. El precio ahora es: " + totalFinal);
		return totalFinal;
	}
} 

