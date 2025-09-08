package actividades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestorHotel {
    private List<Habitacion> habitaciones;
    private List<Cliente> clientes;
    private List<Reserva> reservas;
    private List<PersonalLimpieza> personal;

    public GestorHotel() {
        habitaciones = new ArrayList<>();
        clientes = new ArrayList<>();
        reservas = new ArrayList<>();
        personal = new ArrayList<>();
    }

    public void registrarHabitacion(Habitacion h) {
        habitaciones.add(h);
    }

    public List<Habitacion> consultarDisponibles(LocalDate inicio, LocalDate fin) {
        List<Habitacion> disponibles = new ArrayList<>();
        for (Habitacion h : habitaciones) {
            boolean ocupada = false;
            for (Reserva r : reservas) {
                if (r.getHabitacion().equals(h)) {
                    if (!(fin.isBefore(r.getFechaInicio()) || inicio.isAfter(r.getfechaFin()))) {
                        ocupada = true;
                        break;
                    }
                }
            }
            if (!ocupada && h.isDisponible()) {
                disponibles.add(h);
            }
        }
        return disponibles;
    }

    public void registrarCliente(Cliente c) {
        clientes.add(c);
    }
    public Reserva crearReserva(
            int idReserva,
            Cliente cliente,
            Habitacion habitacion,
            LocalDate inicio,
            LocalDate fin,
            Promocion promo,
            IPoliticasCancelacion politica
    ) {
        Reserva r = new Reserva(idReserva, cliente, habitacion, inicio, fin, promo, politica);
        reservas.add(r);
        cliente.agregarReserva(r);
        return r;
    }


    public void cancelarReserva(Reserva r, LocalDate fechaCancelacion) {
        r.cancelar(fechaCancelacion);
        reservas.remove(r);
    }
    
    public void registrarPersonal(PersonalLimpieza p) {
        personal.add(p);
    }

    public void informeOcupacion(LocalDate inicio, LocalDate fin) {
        System.out.println("== Informe de Ocupación ==");
        for (Habitacion h : habitaciones) {
            boolean ocupada = false;
            for (Reserva r : reservas) {
                if (r.getHabitacion().equals(h)) {
                    if (!(fin.isBefore(r.getFechaInicio()) || inicio.isAfter(r.getfechaFin()))) {
                        ocupada = true;
                        break;
                    }
                }
            }
            System.out.println("Habitación " + h.getIdHabitacion() + " (" + h.getTipoHabitacion() + "): "
                    + (ocupada ? "Ocupada" : "Libre"));
        }
    }

    public void informeIngresos(LocalDate inicio, LocalDate fin) {
        double total = 0;
        for (Reserva r : reservas) {
            if (!(fin.isBefore(r.getFechaInicio()) || inicio.isAfter(r.getfechaFin()))) {
                total += r.getHabitacion().getPrecioHabitacion()
                        * (r.getfechaFin().toEpochDay() - r.getFechaInicio().toEpochDay());
            }
        }
        System.out.println("== Informe de Ingresos ==");
        System.out.println("Ingresos desde " + inicio + " hasta " + fin + ": " + total);
    }
}
