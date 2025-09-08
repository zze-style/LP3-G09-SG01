package actividades;

public class PoliticasDeCancelacion {
    private String nombre;
    private int diasAnticipacion;
    private double porcentajeReembolso;
    
    public PoliticasDeCancelacion(String nombre, int diasAnticipacion, double porcentajeRembolso) {
        this.nombre = nombre;
        this.diasAnticipacion = diasAnticipacion;
        this.porcentajeReembolso = porcentajeRembolso;
    }
    
    public double calcularReembolso(double precioReserva, long diasAnticipacion) {
        if (diasAnticipacion >= this.diasAnticipacion) {
            return precioReserva * porcentajeReembolso;
        }
        return 0;
    }
    
    public String getNombre() {
        return nombre;
    }

    public int getDiasAnticipacion() {
        return diasAnticipacion;
    }
    
    public double getPorcentajeRembolso() {
        return porcentajeReembolso;
    }
}
