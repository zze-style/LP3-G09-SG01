package Actividades;

public class Pedido {

    public static final String ESTADO_PENDIENTE = "Pendiente";
    public static final String ESTADO_COMPLETO = "Completo";
    public static final String ESTADO_ELIMINADO = "Eliminado";

    private String nombrePlato;
    private String tipoPlato;
    private String estado;

    public Pedido(String nombrePlato, String tipoPlato) {
        this.nombrePlato = nombrePlato;
        this.tipoPlato = tipoPlato;
        this.estado = ESTADO_PENDIENTE;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public String getTipoPlato() {
        return tipoPlato;
    }

    public void setTipoPlato(String tipoPlato) {
        this.tipoPlato = tipoPlato;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        if (estado.equals(ESTADO_PENDIENTE) ||
            estado.equals(ESTADO_COMPLETO) ||
            estado.equals(ESTADO_ELIMINADO)) {
            this.estado = estado;
        }
    }

    @Override
    public String toString() {
        return "Plato: " + nombrePlato + " | Tipo: " + tipoPlato + " | Estado: " + estado;
    }
}
