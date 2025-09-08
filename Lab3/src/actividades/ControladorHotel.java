package actividades;

import java.time.LocalDate;
import java.util.Scanner;

public class ControladorHotel {
	
	public void solicitarServicios(Habitacion habitacion) {
        System.out.println("\n--- Servicios disponibles para la habitación " + habitacion.getIdHabitacion() + " ---");

        if (habitacion instanceof ServicioLimpieza) {
            ((ServicioLimpieza) habitacion).solicitarLimpieza();
        }

        if (habitacion instanceof ServicioComida) {
            ((ServicioComida) habitacion).solicitarComida("Lomo Saltado");
        }

        if (habitacion instanceof ServicioLavanderia) {
            ((ServicioLavanderia) habitacion).solicitarLavanderia(5);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Cliente cliente = new Cliente(1, "Luis Savina", "999", "Regular");
        Habitacion habitacion = new Habitacion(101, "Doble", 120);

        LocalDate inicio = LocalDate.of(2025, 9, 15);
        LocalDate fin = LocalDate.of(2025, 9, 18);

        System.out.println("Seleccione la política de cancelación:");
        System.out.println("1. Flexible (hasta 24h antes sin penalización)");
        System.out.println("2. Moderada (72h antes con 50% penalización)");
        System.out.println("3. Estricta (no permite cancelación)");

        int opcion = sc.nextInt();
        IPoliticasCancelacion politica = null;

        switch (opcion) {
            case 1:
                politica = new PoliticaCancelacionFlexible();
                break;
            case 2:
                politica = new PoliticaCancelacionModerada();
                break;
            case 3:
                politica = new PoliticaCancelacionEstricta();
                break;
            default:
                System.out.println("Opción inválida, se asigna política estricta.");
                politica = new PoliticaCancelacionEstricta();
        }

        Reserva reserva = new Reserva(1, cliente, habitacion, inicio, fin, null, politica);

        System.out.println("Reserva creada con la política: " + politica.getClass().getSimpleName());

        System.out.println("\n¿Desea cancelar la reserva? (1=Sí, 0=No)");
        int cancelar = sc.nextInt();

        if (cancelar == 1) {
            LocalDate fechaCancelacion = LocalDate.of(2025, 9, 13); // ejemplo: cancela 2 días antes
            double reembolso = reserva.cancelar(fechaCancelacion);
            System.out.println("Reembolso otorgado: " + reembolso);
        } else {
            System.out.println("La reserva sigue activa.");
        }

        sc.close();
    }
}
