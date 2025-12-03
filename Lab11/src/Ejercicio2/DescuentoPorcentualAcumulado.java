package Ejercicio2;

import java.util.Comparator;
import java.util.List;

class DescuentoPorcentualAcumulado implements EstrategiaDescuento {
	private static final double PORCENTAJE_ACUMULADO = 0.50;

	@Override
	public double aplicarDescuento(List<Producto> productos) {
		double totalBase = 0;
		for (Producto p : productos) {
			totalBase += p.getPrecioBase() * p.getCantidad();
			p.setPrecioFinal(p.getPrecioBase()*p.getCantidad());
		}

		if (productos.stream().mapToInt(Producto::getCantidad).sum() >= 3) {

			Producto productoMasBajo = productos.stream()
					.min(Comparator.comparing(Producto::getPrecioBase))
					.orElse(null);

			if (productoMasBajo != null) {
				double precioMasBajo = productoMasBajo.getPrecioBase();
				double descuentoAplicado = precioMasBajo * PORCENTAJE_ACUMULADO;
				double totalFinal = totalBase - descuentoAplicado;

				System.out.println("  Descuento Acumulado (50%) Producto más bajo: " + productoMasBajo.getNombre() + "): $" + String.format("%.2f", precioMasBajo));
				System.out.println("  Descuento aplicado: $" + String.format("%.2f", descuentoAplicado));

				return totalFinal;
			}
		}
		return totalBase;
	}
}