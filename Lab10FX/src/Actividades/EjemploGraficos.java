package Actividades;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class EjemploGraficos extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g); 

        Graphics2D g2d = (Graphics2D) g; 

        g2d.setColor(Color.BLUE); 
        g2d.drawLine(10, 10, 100, 100); 

        g2d.setColor(Color.RED); 
        g2d.drawRect(50, 50, 100, 50);

        g2d.setColor(Color.GREEN);
        g2d.drawOval(150, 50, 100, 50);
        
        g2d.setColor(Color.ORANGE);
        g2d.fillOval(200, 150, 50, 50);

        g2d.setColor(Color.BLACK);
        g2d.drawString("Gráficos Simples", 10, 200);


        g2d.setColor(new Color(153, 51, 255));
        g2d.fillArc(280, 10, 80, 80, 0, 135); 
        g2d.drawString("Sector Circular", 280, 100);


        g2d.setColor(Color.MAGENTA);

        g2d.setStroke(new BasicStroke(5)); 
        g2d.drawLine(10, 120, 150, 120);
        g2d.drawString("Línea Gruesa", 10, 140);
        

        int[] puntosX = {200, 250, 300, 250};
        int[] puntosY = {230, 200, 230, 260};
        g2d.setColor(Color.BLUE.darker());
        g2d.fillPolygon(puntosX, puntosY, 4);
        g2d.drawString("Polígono", 200, 280);


        g2d.setStroke(new BasicStroke(1)); 
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo de Gráficos Simples y Avanzados");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 350);
        
        EjemploGraficos panel = new EjemploGraficos();
        frame.add(panel);

        frame.setVisible(true);
    }
}