package actividades;

public class PoliticaCancelacionEstricta implements IPoliticasCancelacion {

    @Override
    public boolean puedeCancelar(Reserva reserva) {
        return false;
    }

    @Override
    public double calcularReembolso(Reserva reserva) {
        return 0;
    }
}
