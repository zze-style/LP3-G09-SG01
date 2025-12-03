package Ejercicio2;

import java.util.List;

class DescuentoPorcentual implements EstrategiaDescuento {
	private static final double DESCUENTO_PORCENTUAL = 0.30;
	
	@Override
	public double aplicarDescuento(List<Producto> productos) {
		double total = 0;
		double totalDescuento = 0;
		for (Producto p : productos) {
			double precioPorItem = p.getPrecioBase()*p.getCantidad();
			
			if(p.getCantidad() >= 2) {
				double descuento = precioPorItem * DESCUENTO_PORCENTUAL;
				p.setPrecioFinal(precioPorItem - descuento);
				totalDescuento += descuento;
			} else {
				p.setPrecioFinal(precioPorItem);
			}
			total += p.getPrecioFinal();
		}
		System.out.println("Descuento porcentual (30%) aplicado. El nuevo precio es " + totalDescuento);
		return total;
	}
} 
