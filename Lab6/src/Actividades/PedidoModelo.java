package Actividades;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoModelo {
    private List<Pedido> pedidos;
    private List<Pedido> historial;

    public PedidoModelo() {
        pedidos = new ArrayList<>();
        historial = new ArrayList<>();
    }

    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void eliminarPedido(String nombre) {
        for (Pedido p : pedidos) {
            if (p.getNombrePlato().equalsIgnoreCase(nombre)) {
                p.setEstado(Pedido.ESTADO_ELIMINADO);
                historial.add(p);
                pedidos.remove(p);
                break;
            }
        }
    }

    public void actualizarPedido(String nombreViejo, String nombreNuevo) {
        for (Pedido p : pedidos) {
            if (p.getNombrePlato().equalsIgnoreCase(nombreViejo)) {
                p.setNombrePlato(nombreNuevo);
                break;
            }
        }
    }

    public Pedido buscarPedido(String nombre, String tipo) {
        for (Pedido p : pedidos) {
            if ((nombre != null && p.getNombrePlato().equalsIgnoreCase(nombre)) ||
                (tipo != null && p.getTipoPlato().equalsIgnoreCase(tipo))) {
                return p;
            }
        }
        return null;
    }

    public int contarPedidos() {
        return pedidos.size();
    }

    public int contarPedidosPorTipo(String tipo) {
        int contador = 0;
        for (Pedido p : pedidos) {
            if (p.getTipoPlato().equalsIgnoreCase(tipo)) {
                contador++;
            }
        }
        return contador;
    }

    public void marcarComoCompleto(String nombre) {
        for (Pedido p : pedidos) {
            if (p.getNombrePlato().equalsIgnoreCase(nombre)) {
                p.setEstado(Pedido.ESTADO_COMPLETO);
                historial.add(p);
                break;
            }
        }
    }

    public List<Pedido> getPedidosPorEstado(String estado) {
        return pedidos.stream()
                .filter(p -> p.getEstado().equals(estado))
                .collect(Collectors.toList());
    }

    public int contarPendientes() {
        int contador = 0;
        for (Pedido p : pedidos) {
            if (p.getEstado().equals(Pedido.ESTADO_PENDIENTE)) {
                contador++;
            }
        }
        return contador;
    }

    public List<Pedido> getHistorial() {
        return historial;
    }
}
