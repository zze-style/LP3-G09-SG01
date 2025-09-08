package actividades;

public class HabitacionDoble extends Habitacion {

    public HabitacionDoble(int idHabitacion, String tipoHabitacion, int precioHabitacion) {
		super(idHabitacion, tipoHabitacion, precioHabitacion);
	}

	@Override
    public double calcularPrecio() {
        return super.getPrecioHabitacion();
    }
}
