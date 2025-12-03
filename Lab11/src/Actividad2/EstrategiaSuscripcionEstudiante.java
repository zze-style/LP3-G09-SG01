package Actividad2;

public class EstrategiaSuscripcionEstudiante implements EstrategiaSuscripcion{
	public static final double DESCUENTO = 0.50;
	
	@Override
	public void aplicarEstrategia(Suscripcion suscripcion) {
		double precioBase = suscripcion.getPrecioBase();
		double precioFinal = precioBase * DESCUENTO;
		suscripcion.setPrecioFinal(precioFinal);
		System.out.println("Se ha aplicado un descuento de estudiante (50%). El precio base es: " + precioBase + ". El nuevo precio es: " + precioFinal);
		
	}
}
