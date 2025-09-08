package actividades;

public class HabitacionSuite extends Habitacion implements ServicioLimpieza, ServicioComida, ServicioLavanderia {

    public HabitacionSuite(int id, String tipo, int precio) {
        super(id, tipo, precio);
    }

    @Override
    public void solicitarLimpieza() {
        System.out.println("Se solicitó limpieza para la suite: " + getIdHabitacion());
    }

    @Override
    public void solicitarComida(String plato) {
        System.out.println("Se solicitó " + plato + " a la suite: " + getIdHabitacion());
    }

    @Override
    public void solicitarLavanderia(int cantidadPrendas) {
        System.out.println("Se solicitó lavandería para " + cantidadPrendas + " prendas en la suite: " + getIdHabitacion());
    }
}