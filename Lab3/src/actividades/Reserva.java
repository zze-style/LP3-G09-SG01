package actividades;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reserva {
	
	private int idReserva;
    private Cliente cliente;
    private Habitacion habitacion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double precioFinal;
    private IPoliticasCancelacion politicaCancelacion;

    public Reserva(int idReserva, Cliente cliente, Habitacion habitacion,
                   LocalDate fechaInicio, LocalDate fechaFin,
                   Promocion promocion, IPoliticasCancelacion politicaCancelacion) {
        this.idReserva = idReserva;
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.politicaCancelacion = politicaCancelacion;

        long noches = ChronoUnit.DAYS.between(fechaInicio, fechaFin);
        double precioBase = habitacion.getPrecioHabitacion() * noches;

        if (promocion != null && promocion.esValidoPara(cliente, fechaInicio)) {
            precioFinal = promocion.aplicarDescuento(precioBase);
        } else {
            precioFinal = precioBase;
        }

        new GestorDisponibilidadHabitacion().reservar(habitacion);
    }

    public double cancelar(LocalDate fechaCancelacion) {
        if (politicaCancelacion != null && politicaCancelacion.puedeCancelar(this)) {
            return politicaCancelacion.calcularReembolso(this);
        } else {
            System.out.println("No se puede cancelar según la política aplicada");
            return 0;
        }
    }

	
	public int getIdReserva() {
		return idReserva;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public Habitacion getHabitacion() {
		return habitacion;
	}
	
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	
	public LocalDate getfechaFin() {
		return fechaFin;
	}
	
	public double getPrecioFinal() {
		return precioFinal;
	}

}
