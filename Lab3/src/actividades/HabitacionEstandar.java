package actividades;

public class HabitacionEstandar extends Habitacion implements ServicioLimpieza {

    public HabitacionEstandar(int id, String tipo, int precio) {
        super(id, tipo, precio);
    }

    @Override
    public void solicitarLimpieza() {
        System.out.println("Se solicitó limpieza para la habitación estándar: " + getIdHabitacion());
    }
}


