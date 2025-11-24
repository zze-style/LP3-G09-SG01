package Ejercicio2;

import javax.swing.*;
import java.awt.*;

public class Main {
    
    private final String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
    private JTextField[] camposTemp = new JTextField[7];
    private Temperatura graficoPanel; 

    public Main() {
        JFrame frame = new JFrame("Registro de Temperatura Semanal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 500);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        
        for (int i = 0; i < 7; i++) {
            inputPanel.add(new JLabel(dias[i] + " (°C):"));
            camposTemp[i] = new JTextField("25.0", 4);
            inputPanel.add(camposTemp[i]);
        }

        JButton botonGrafico = new JButton("Mostrar Gráfico");
        inputPanel.add(botonGrafico);

        inputPanel.setPreferredSize(new Dimension(frame.getWidth(), 80));

        graficoPanel = new Temperatura(); 
        graficoPanel.setBackground(Color.WHITE);
        
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(graficoPanel, BorderLayout.CENTER);

        botonGrafico.addActionListener(e -> actualizarGrafico());

        frame.setVisible(true);
        frame.pack();
        frame.setSize(750, 500); 
    }
    
    private void actualizarGrafico() {
        double[] nuevasTemperaturas = new double[7];
        boolean error = false;

        for (int i = 0; i < 7; i++) {
            try {
                nuevasTemperaturas[i] = Double.parseDouble(camposTemp[i].getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(graficoPanel, 
                    "Error: Ingrese un número válido para la temperatura del " + dias[i] + ".", 
                    "Error de Entrada", JOptionPane.ERROR_MESSAGE);
                error = true;
                break;
            }
        }

        if (!error) {
            graficoPanel.setTemperaturas(nuevasTemperaturas);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main());
    }
}