package actividades;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private int idCliente;
    private String nombreCliente;
    private String numeroContactoCliente;
    private String tipoCliente;
    private List historialReservas;

    public Cliente(int idCliente, String nombreCliente, String numeroContactoCliente, String tipoCliente) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.numeroContactoCliente = numeroContactoCliente;
        this.tipoCliente = tipoCliente;
        this.historialReservas = new ArrayList<>();
    }

    public void agregarReserva(Reserva reserva) {
        historialReservas.add(reserva);
    }
    
    public int getIdCliente() {
    	return idCliente;
    }

    public List getHistorialReserva() {
        return historialReservas;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }
    
    public String getTipoCliente() {
        return tipoCliente;
    }

    public String getNumeroContactoCliente() {
        return numeroContactoCliente;
    }
}