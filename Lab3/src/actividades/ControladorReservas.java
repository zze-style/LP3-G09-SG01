package actividades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControladorReservas {
    private List<Habitacion> habitaciones;
    private List<Reserva> reservas;
    private GestorDisponibilidadHabitacion gestorDisponibilidad;

    public ControladorReservas() {
        this.habitaciones = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.gestorDisponibilidad = new GestorDisponibilidadHabitacion();
    }

    public void registrarHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
    }

    public List<Habitacion> consultarDisponibles(LocalDate inicio, LocalDate fin) {
        List<Habitacion> disponibles = new ArrayList<>();
        for (Habitacion h : habitaciones) {
            if (gestorDisponibilidad.estaDisponibleEnRango(h, inicio, fin, reservas)) {
                disponibles.add(h);
            }
        }
        return disponibles;
    }

    public Reserva crearReserva(int idReserva, Cliente cliente, Habitacion habitacion,
                                LocalDate inicio, LocalDate fin, Promocion promo) {
        if (gestorDisponibilidad.estaDisponibleEnRango(habitacion, inicio, fin, reservas)) {
            Reserva nueva = new Reserva(idReserva, cliente, habitacion, inicio, fin, promo, null);
            reservas.add(nueva);
            gestorDisponibilidad.reservar(habitacion);
            cliente.agregarReserva(nueva);
            System.out.println("Reserva creada con éxito para el cliente: " + cliente.getNombreCliente());
            return nueva;
        } else {
            System.out.println("La habitación no está disponible en esas fechas.");
            return null;
        }
    }

    public void cancelarReserva(Reserva reserva, LocalDate fechaCancelacion) {
        double reembolso = reserva.cancelar(fechaCancelacion);
        gestorDisponibilidad.liberar(reserva.getHabitacion());
        reservas.remove(reserva);
        System.out.println("Reserva cancelada. Reembolso: " + reembolso);
    }
}
