package Actividades;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

public class EjemploBinding {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo de Binding de Producto");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300); 
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        Producto producto1 = new Producto("Laptop", 3600.50, 5);

        JTextField nombreField = new JTextField(producto1.getNombre(), 15);
        JTextField precioField = new JTextField(String.valueOf(producto1.getPrecio()), 15);
        JTextField cantidadField = new JTextField(String.valueOf(producto1.getCantidad()), 15);
        JButton button = new JButton("Actualizar Producto");

        frame.add(new JLabel("Nombre:"));
        frame.add(nombreField);
        frame.add(new JLabel("Precio:"));
        frame.add(precioField);
        frame.add(new JLabel("Cantidad:"));
        frame.add(cantidadField);
        frame.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                producto1.setNombre(nombreField.getText());
                
                try {
                    double precio = Double.parseDouble(precioField.getText());
                    producto1.setPrecio(precio);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingrese un número válido para el precio.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
                }
                
                try {
                    int cantidad = Integer.parseInt(cantidadField.getText());
                    producto1.setCantidad(cantidad);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingrese un número entero válido para la cantidad.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
                }

                System.out.println("- Modelo Producto actualizado -");
                System.out.println("Nombre: " + producto1.getNombre());
                System.out.println("Precio: " + producto1.getPrecio());
                System.out.println("Cantidad: " + producto1.getCantidad());
            }
        });

        frame.setVisible(true);
    }
}


class Producto {
    private String nombre;
    private double precio;
    private int cantidad;

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}