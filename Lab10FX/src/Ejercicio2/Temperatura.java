package Ejercicio2;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;


public class Temperatura extends JPanel {

    private double[] temperaturas = {0, 0, 0, 0, 0, 0, 0};
    private final String[] dias = {"Lun", "Mar", "Mié", "Jue", "Vie", "Sáb", "Dom"};
    

    private final int MARGEN = 50;
    private final int MAX_ALTURA_GRAFICO = 200;


    public void setTemperaturas(double[] nuevasTemperaturas) {
        if (nuevasTemperaturas.length == 7) {
            this.temperaturas = nuevasTemperaturas;
            repaint(); 
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setFont(new Font("Arial", Font.PLAIN, 12));

        int w = getWidth();
        int h = getHeight();

        double maxTemp = 0;
        for (double temp : temperaturas) {
            if (temp > maxTemp) {
                maxTemp = temp;
            }
        }
        if (maxTemp == 0) maxTemp = 1; 

        int x0 = MARGEN;
        int y0 = h - MARGEN;

        g2d.setColor(Color.DARK_GRAY);
        g2d.drawLine(x0, y0, w - MARGEN, y0);
        g2d.drawLine(x0, y0, x0, y0 - MAX_ALTURA_GRAFICO);

        g2d.drawString("Días de la Semana", w / 2 - 40, y0 + 30);
        
        g2d.rotate(-Math.PI / 2);
        g2d.drawString("Temperatura (°C)", -h / 2 - 30, x0 - 30);
        g2d.rotate(Math.PI / 2);

        Point2D.Double[] puntos = new Point2D.Double[temperaturas.length];
        int separacionX = (w - 2 * MARGEN) / (temperaturas.length - 1); 

        g2d.setColor(Color.BLUE);
        g2d.setStroke(new BasicStroke(2)); 

        for (int i = 0; i < temperaturas.length; i++) {
            int x = x0 + i * separacionX;
            int y = y0 - (int) ((temperaturas[i] / maxTemp) * MAX_ALTURA_GRAFICO);
            
            puntos[i] = new Point2D.Double(x, y);

            int radio = 5;
            g2d.fillOval(x - radio / 2, y - radio / 2, radio, radio);
            
            g2d.drawString(dias[i], x - 10, y0 + 15);
            String tempStr = String.format("%.1f", temperaturas[i]);
            g2d.drawString(tempStr + "°C", x - 15, y - 10);
        }

        g2d.setColor(new Color(255, 69, 0));
        g2d.setStroke(new BasicStroke(3)); 

        for (int i = 0; i < puntos.length - 1; i++) {
            g2d.drawLine((int) puntos[i].getX(), (int) puntos[i].getY(),
                         (int) puntos[i+1].getX(), (int) puntos[i+1].getY());
        }
    }
}