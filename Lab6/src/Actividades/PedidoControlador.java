package Actividades;

import java.util.List;

public class PedidoControlador {
    private PedidoModelo modelo;
    private PedidoVista vista;

    public PedidoControlador(PedidoModelo modelo, PedidoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        String opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.solicitarOpcion();

            switch (opcion) {
                case "1":
                    String nombre = vista.solicitarNombrePlato();
                    String tipo = vista.solicitarTipoPlato();
                    modelo.agregarPedido(new Pedido(nombre, tipo));
                    vista.mostrarMensaje("Pedido agregado.");
                    break;

                case "2":
                    vista.mostrarPedidos(modelo.getPedidos());
                    break;

                case "3":
                    String eliminar = vista.solicitarNombrePlato();
                    modelo.eliminarPedido(eliminar);
                    vista.mostrarMensaje("Pedido eliminado.");
                    break;

                case "4":
                    String viejo = vista.solicitarNombrePlato();
                    String nuevo = vista.solicitarNombrePlato();
                    modelo.actualizarPedido(viejo, nuevo);
                    vista.mostrarMensaje("Pedido actualizado.");
                    break;

                case "5":
                    String buscar = vista.solicitarNombrePlato();
                    Pedido encontrado = modelo.buscarPedido(buscar, null);
                    if (encontrado != null)
                        vista.mostrarMensaje("Encontrado: " + encontrado);
                    else
                        vista.mostrarMensaje("Pedido no encontrado.");
                    break;

                case "6":
                    vista.mostrarMensaje("Total pedidos: " + modelo.contarPedidos());
                    break;

                case "7":
                    String completo = vista.solicitarNombrePlato();
                    modelo.marcarComoCompleto(completo);
                    vista.mostrarMensaje("Pedido marcado como completo.");
                    break;

                case "8":
                    String estado = vista.solicitarTipoPlato();
                    List<Pedido> pedidosEstado = modelo.getPedidosPorEstado(estado);
                    vista.mostrarPedidos(pedidosEstado);
                    break;

                case "9":
                    vista.mostrarMensaje("Pedidos pendientes: " + modelo.contarPendientes());
                    break;

                case "10":
                    vista.mostrarPedidos(modelo.getHistorial());
                    break;

                case "11":
                    vista.mostrarMensaje("Saliendo...");
                    break;

                default:
                    vista.mostrarMensaje("Opción no válida.");
            }
        } while (!opcion.equals("11"));

        vista.cerrarScanner();
    }
}
