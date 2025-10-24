package Actividad;

public class Main {
    public static void main(String[] args) {
        Operaciones.crearTabla();

        Operaciones.insertar("Juan", "Pérez");
        Operaciones.insertar("Ana", "López");

        Operaciones.mostrar();

        Operaciones.actualizar(1, "Carlos", "Ramirez");
        Operaciones.mostrar();

        Operaciones.eliminar(2);
        Operaciones.mostrar();
    }
}
