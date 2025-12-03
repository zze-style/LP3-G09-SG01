package Actividad2;

public class EstrategiaSuscripcionPremium implements EstrategiaSuscripcion{
	private static final double PRECIO_PREMIUM = 19.99;
	
	@Override
	public void aplicarEstrategia(Suscripcion suscripcion) {
		suscripcion.setPrecioFinal(PRECIO_PREMIUM);
		System.out.println("Se ha aplicado el escuento PREMIUM, el precio es: " + PRECIO_PREMIUM);
	}
}
