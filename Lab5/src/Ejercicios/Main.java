package Ejercicios;
public class Main {
    public static <F, S> void imprimirPar(Par<F, S> par) {
        System.out.println(par);
    }

    public static void main(String[] args) {
        Par<String, Integer> par1 = new Par<>("Edad", 25);
        Par<Double, Boolean> par2 = new Par<>(3.14, true);
        Par<Persona, Integer> par3 = new Par<>(new Persona("Carlos"), 30);

        imprimirPar(par1);
        imprimirPar(par2);
        imprimirPar(par3);
        
        Contenedor<String, Integer> contenedor = new Contenedor<>();

        contenedor.agregarPar("Edad", 25);
        contenedor.agregarPar("Altura", 180);
        contenedor.agregarPar("Peso", 75);

        System.out.println("Par en índice 1: " + contenedor.obtenerPar(1));

        System.out.println("\nTodos los pares:");
        contenedor.mostrarPares();
    }
}
