package Ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Controlador {
    private List<Producto> productosDisponibles = new ArrayList<>();
    private Carrito carrito = new Carrito();
    private List<Compra> historial = new ArrayList<>();
    private VistaConsola vista = new VistaConsola();
    private double descuento = 0;
    private double envio = 0;

    public Controlador() {
        productosDisponibles.add(new Producto(1, "Laptop", 1200));
        productosDisponibles.add(new Producto(2, "Celular", 800));
        productosDisponibles.add(new Producto(3, "Audífonos", 100));
        productosDisponibles.add(new Producto(4, "Mouse", 50));
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1:
                    vista.mostrarProductos(productosDisponibles);
                    break;
                case 2:
                    int idAgregar = vista.pedirId();
                    productosDisponibles.stream()
                        .filter(p -> p.getId() == idAgregar)
                        .findFirst()
                        .ifPresent(carrito::agregarProducto);
                    vista.mostrarMensaje("Producto agregado.");
                    break;
                case 3:
                    int idEliminar = vista.pedirId();
                    carrito.eliminarProducto(idEliminar);
                    vista.mostrarMensaje("Producto eliminado.");
                    break;
                case 4:
                    vista.mostrarCarrito(carrito.getProductos());
                    break;
                case 5:
                    descuento = vista.pedirDescuento();
                    vista.mostrarMensaje("Descuento aplicado.");
                    break;
                case 6:
                    envio = vista.pedirEnvio();
                    vista.mostrarMensaje("Costo de envío aplicado.");
                    break;
                case 7:
                    if (carrito.estaVacio()) {
                        vista.mostrarMensaje("El carrito está vacío.");
                    } else {
                        double total = carrito.calcularTotal(descuento, envio);
                        Compra compra = new Compra(new ArrayList<>(carrito.getProductos()), total);
                        historial.add(compra);
                        carrito.vaciar();
                        vista.mostrarMensaje("Compra realizada por $" + total);
                    }
                    break;
                case 8:
                    vista.mostrarHistorial(historial);
                    break;
                case 0:
                    vista.mostrarMensaje("Saliendo...");
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida.");
            }
        } while (opcion != 0);
    }
}

