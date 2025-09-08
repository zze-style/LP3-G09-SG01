package actividades;

import java.time.LocalDate;

public class Promocion {
	private int idPromocion;
	private String descripcion;
	private double porcentajeDescuento;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private String tipoCliente;
	
	public Promocion(int idPromocion, String descripcion, double porcentajeDescuento, LocalDate fechaInicio,
			LocalDate fechaFin, String tipoCliente) {
		this.idPromocion = idPromocion;
		this.descripcion = descripcion;
		this.porcentajeDescuento = porcentajeDescuento;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.tipoCliente = tipoCliente;
	}
	
	public boolean esValidoPara(Cliente cliente, LocalDate fechaReserva) {
		boolean enRango = !fechaReserva.isBefore(fechaInicio) &&  !fechaReserva.isAfter(fechaFin);
		boolean tipoCoincide = (tipoCliente == null)|| tipoCliente.equalsIgnoreCase(cliente.getTipoCliente());
		return enRango && tipoCoincide;
	}
	
	public double aplicarDescuento(double precioBase) {
		return precioBase - (precioBase * porcentajeDescuento);
	}
	
	
}
