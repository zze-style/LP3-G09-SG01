package actividades;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
    	GestorHotel hotel = new GestorHotel();

        Habitacion h1 = new Habitacion(1, "Individual", 50);
        Habitacion h2 = new Habitacion(2, "Doble", 80);
        Habitacion h3 = new Habitacion(3, "Suite", 150);
        hotel.registrarHabitacion(h1);
        hotel.registrarHabitacion(h2);
        hotel.registrarHabitacion(h3);

        PoliticasDeCancelacion politicaFlexible = new PoliticasDeCancelacion("Flexible", 2, 0.8);
        h1.setPoliticaCancelacion(politicaFlexible);
        h2.setPoliticaCancelacion(politicaFlexible);
        h3.setPoliticaCancelacion(new PoliticasDeCancelacion("Estricta", 5, 0.5));

        Cliente c1 = new Cliente(1, "Juan Pérez", "987654321", "Regular");
        Cliente c2 = new Cliente(2, "María Gómez", "123456789", "VIP");
        hotel.registrarCliente(c1);
        hotel.registrarCliente(c2);

        Promocion promoVIP = new Promocion(1, "Descuento clientes VIP", 0.2,
                LocalDate.of(2025, 9, 1),
                LocalDate.of(2025, 9, 30),
                "VIP");

        Reserva r1 = hotel.crearReserva(1, c1, h1,
                LocalDate.of(2025, 9, 10),
                LocalDate.of(2025, 9, 12),
                null,
                new PoliticaCancelacionFlexible());

        Reserva r2 = hotel.crearReserva(2, c2, h3,
                LocalDate.of(2025, 9, 15),
                LocalDate.of(2025, 9, 20),
                promoVIP,
                new PoliticaCancelacionEstricta());

        System.out.println("\nHabitaciones disponibles entre 2025-09-10 y 2025-09-12:");
        for (Habitacion h : hotel.consultarDisponibles(LocalDate.of(2025, 9, 10), LocalDate.of(2025, 9, 12))) {
            System.out.println("Habitación " + h.getIdHabitacion() + " (" + h.getTipoHabitacion() + ")");
        }

        hotel.informeOcupacion(LocalDate.of(2025, 9, 1), LocalDate.of(2025, 9, 30));

        hotel.cancelarReserva(r1, LocalDate.of(2025, 9, 9));

        hotel.informeIngresos(LocalDate.of(2025, 9, 1), LocalDate.of(2025, 9, 30));
        
        Habitacion estandar = new HabitacionEstandar(101, "Estandar", 80);
        Habitacion suite = new HabitacionSuite(202, "Suite", 200);

        ControladorHotel controlador = new ControladorHotel();

        controlador.solicitarServicios(estandar);
        controlador.solicitarServicios(suite);
    	
    }
}