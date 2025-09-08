package actividades;

public class Habitacion {
    private int idHabitacion;
    private String tipoHabitacion;
    private int precioHabitacion;
    private boolean disponibilidadHabitacion;
    private double precio;
    private PoliticasDeCancelacion politicaCancelacion;
    private GestorDisponibilidadHabitacion gestorDisponibilidad;


    public Habitacion(int idHabitacion, String tipoHabitacion, int precioHabitacion) {
        this.idHabitacion = idHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.precioHabitacion = precioHabitacion;
        this.disponibilidadHabitacion = true;
        this.gestorDisponibilidad = new GestorDisponibilidadHabitacion();

    }
    
    public double calcularPrecio() {
        return precio;
    }
    
    public void reservar() {
        gestorDisponibilidad.reservar(this);
    }

    public void liberar() {
        gestorDisponibilidad.liberar(this);
    }

    public boolean isDisponible() {
        return disponibilidadHabitacion;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public int getPrecioHabitacion() {
        return precioHabitacion;
    }

    public PoliticasDeCancelacion getPoliticaCancelacion() {
        return politicaCancelacion;
    }

    public void setPoliticaCancelacion(PoliticasDeCancelacion politica) {
        this.politicaCancelacion = politica;
    }

    public void setDisponibilidadHabitacion(boolean disponible) {
        this.disponibilidadHabitacion = disponible;
    }

	public void solicitarLimpieza() {
	}
}