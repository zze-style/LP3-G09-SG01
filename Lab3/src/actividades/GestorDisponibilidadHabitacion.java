package actividades;

import java.time.LocalDate;
import java.util.List;

public class GestorDisponibilidadHabitacion {

    public boolean estaDisponibleEnRango(Habitacion habitacion, LocalDate inicio, LocalDate fin, List<Reserva> reservas) {
        for (Reserva r : reservas) {
            if (r.getHabitacion().getIdHabitacion() == habitacion.getIdHabitacion()) {
                boolean seCruzan = !(fin.isBefore(r.getFechaInicio()) || inicio.isAfter(r.getfechaFin()));
                if (seCruzan) {
                    return false;
                }
            }
        }
        return true;
    }

    public void reservar(Habitacion habitacion) {
        habitacion.setDisponibilidadHabitacion(false);
        System.out.println("La habitación con ID: " + habitacion.getIdHabitacion() + " se ha reservado con éxito");
    }

    public void liberar(Habitacion habitacion) {
        habitacion.setDisponibilidadHabitacion(true);
        System.out.println("Se ha liberado la habitación con ID: " + habitacion.getIdHabitacion());
    }
}
