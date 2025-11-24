package Ejercicio3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class Reproductor extends JFrame {

    public Reproductor() {
        super("Reproductor de efectos");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 150);
        this.setLocationRelativeTo(null); 
        
        JPanel panel = new JPanel();
        
        JButton botonAplausos = new JButton("Aplausos");
        JButton botonCampana = new JButton("Campana");
        JButton botonExplosion = new JButton("Explosión");
        
        panel.add(botonAplausos);
        panel.add(botonCampana);
        panel.add(botonExplosion);
        
        botonAplausos.addActionListener(new SoundPlayerListener("C:\\Users\\Sebastian\\Downloads\\campana.wav"));
        botonCampana.addActionListener(new SoundPlayerListener("C:\\Users\\Sebastian\\Downloads\\aplausos.wav"));
        botonExplosion.addActionListener(new SoundPlayerListener("C:\\Users\\Sebastian\\Downloads\\explosion.wav"));
        
        this.add(panel);
    }
    
    private class SoundPlayerListener implements ActionListener {
        private String soundFileName;
        
        public SoundPlayerListener(String fileName) {
            this.soundFileName = fileName;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            reproducirSonido(soundFileName);
        }
        
        private void reproducirSonido(String filePath) {
            try {
                File soundFile = new File(filePath);
                if (!soundFile.exists()) {
                    JOptionPane.showMessageDialog(null, "Error: Archivo de sonido " + filePath + " no encontrado.", "Error de Archivo", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start();
                
            } catch (UnsupportedAudioFileException ex) {
            } catch (LineUnavailableException ex) {
            } catch (IOException ex) {
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Reproductor().setVisible(true);
        });
    }
}