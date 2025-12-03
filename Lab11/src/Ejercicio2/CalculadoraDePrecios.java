package Ejercicio2;

import java.util.List;

public class CalculadoraDePrecios {
    private EstrategiaDescuento estrategia;

    public void setEstrategia(EstrategiaDescuento estrategia) {
        this.estrategia = estrategia;
    }

    public double calcularTotal(List<Producto> productos) {
        if (estrategia == null) {
            System.err.println("No se ha establecido una estrategia de descuento.");
            return 0;
        }
        System.out.println("Aplicando Estrategia: " + estrategia.getClass().getSimpleName());
        return this.estrategia.aplicarDescuento(productos);
    }
}
