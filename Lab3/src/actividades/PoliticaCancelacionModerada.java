package actividades;

import java.time.temporal.ChronoUnit;
import java.time.LocalDate;

public class PoliticaCancelacionModerada implements IPoliticasCancelacion {

    @Override
    public boolean puedeCancelar(Reserva reserva) {
        long horasAnticipacion = ChronoUnit.HOURS.between(
            LocalDate.now().atStartOfDay(), 
            reserva.getFechaInicio().atStartOfDay()
        );
        return horasAnticipacion >= 72;
    }

    @Override
    public double calcularReembolso(Reserva reserva) {
        return reserva.getPrecioFinal() * 0.5;
    }
}
