package Actividad2;

public class Suscripcion {
	public String planActual;
	public double precioBase;
	public double precioFinal;

	public Suscripcion(String planActual, int precioBase) {
		this.planActual = planActual;
		this.precioBase = precioBase;
		this.precioFinal = precioBase;
	}

	public String getPlanActual() {
		return planActual;
	}

	public void setPlanActual(String planActual) {
		this.planActual = planActual;
	}

	public double getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(int precioBase) {
		this.precioBase = precioBase;
	}

	public double getPrecioFinal() {
		return precioFinal;
	}

	public void setPrecioFinal(double precioPremium) {
		this.precioFinal = precioPremium;
	}
	
	
}
