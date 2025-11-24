package Ejercicio1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

public class BindingEj1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Gestión de Producto");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 350); 
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        Producto producto1 = new Producto("Refrigeradora", 1500, 5, "Cocina");

        JTextField nombreField = new JTextField(producto1.getNombre(), 15);
        JTextField precioField = new JTextField(String.valueOf(producto1.getPrecio()), 15);
        JTextField cantidadField = new JTextField(String.valueOf(producto1.getCantidadStock()), 15);
        JTextField categoriaField = new JTextField(producto1.getCategoria(), 15);
        
        JButton button = new JButton("Actualizar Producto");
        
        JLabel infoLabel = new JLabel(producto1.obtenerInfo()); 
        infoLabel.setVerticalAlignment(SwingConstants.TOP);
        infoLabel.setHorizontalAlignment(SwingConstants.LEFT);

        frame.add(new JLabel("Nombre:"));
        frame.add(nombreField);
        frame.add(new JLabel("Precio:"));
        frame.add(precioField);
        frame.add(new JLabel("Cantidad:"));
        frame.add(cantidadField);
        frame.add(new JLabel("Categoría:"));
        frame.add(categoriaField);
        
        frame.add(button);
        
        frame.add(new JSeparator(SwingConstants.HORIZONTAL));
        frame.add(new JLabel("<html><B>Información Actualizada:</B></html>"));
        frame.add(infoLabel); 

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                String categoria = categoriaField.getText();
                double precio = 0.0;
                int cantidad = 0;
                boolean esValido = true;

                try {
                    precio = Double.parseDouble(precioField.getText());
                    if (precio < 0) {
                        throw new NumberFormatException();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Error: Ingrese un número positivo y válido para el precio.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
                    esValido = false;
                }
                
                if (esValido) {
                    try {
                        cantidad = Integer.parseInt(cantidadField.getText());
                        if (cantidad < 0) {
                            throw new NumberFormatException();
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Error: Ingrese un número entero positivo y válido para la cantidad.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
                        esValido = false;
                    }
                }
                
                if (esValido) {
                    producto1.setNombre(nombre);
                    producto1.setPrecio(precio);
                    producto1.setCantidadStock(cantidad);
                    producto1.setCategoria(categoria);

                    infoLabel.setText(producto1.obtenerInfo());
                    
                    System.out.println("- Modelo Producto actualizado -");
                }
            }
        });

        frame.setVisible(true);
    }
}


class Producto {
    private String nombre;
    private double precio;
    private int cantidadStock;
	private String categoria;

    public Producto(String nombre, double precio, int cantidadStock, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
        this.categoria = categoria;
    }

    public String obtenerInfo() {
        return String.format(
            "<html>" +
            "<b>Nombre:</b> %s<br>" +
            "<b>Precio:</b> %.2f<br>" +
            "<b>Stock:</b> %d unidades<br>" +
            "<b>Categoría:</b> %s" +
            "</html>", 
            nombre, precio, cantidadStock, categoria);
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }
    
    public String getCategoria() {
		return categoria;
	}

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}