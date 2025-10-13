package Controlador;

import Modelo.Empleado;
import java.io.*;
import java.util.*;

public class ControladorEmpleado {
    private final String archivo = "empleados.dat";

    public List<Empleado> leerEmpleados() {
        List<Empleado> lista = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            lista = (List<Empleado>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado. Se creará uno nuevo al guardar.");
        } catch (Exception e) {
            System.out.println("Error al leer empleados.");
        }
        return lista;
    }

    public void guardarEmpleados(List<Empleado> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(lista);
            System.out.println("Archivo guardado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al guardar empleados.");
        }
    }

    public void agregarEmpleado(Empleado e) {
        List<Empleado> lista = leerEmpleados();
        lista.add(e);
        guardarEmpleados(lista);
    }

    public Empleado buscarEmpleado(int numero) {
        for (Empleado e : leerEmpleados()) {
            if (e.getNumero() == numero) return e;
        }
        return null;
    }

    public void eliminarEmpleado(int numero) {
        List<Empleado> lista = leerEmpleados();
        boolean eliminado = lista.removeIf(e -> e.getNumero() == numero);
        if (eliminado) {
            guardarEmpleados(lista);
            System.out.println("Empleado eliminado.");
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }
}
