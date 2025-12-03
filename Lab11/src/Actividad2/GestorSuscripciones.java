package Actividad2;

public class GestorSuscripciones {
	public EstrategiaSuscripcion estrategia;
	
	public void setEstrategia (EstrategiaSuscripcion estrategia) {
		this.estrategia = estrategia;
	}
	
	public void calcularPrecioFinal(Suscripcion suscripcion) {
		if (estrategia == null) {
			System.out.println("No se ha determinado ninguna estrategia");
		}
		System.out.println("Se está aplicando " + suscripcion.getPlanActual());
		this.estrategia.aplicarEstrategia(suscripcion);
	}

}
