package actividades;

public interface IPoliticasCancelacion {
    double calcularReembolso(Reserva reserva);
    boolean puedeCancelar(Reserva reserva);
}
