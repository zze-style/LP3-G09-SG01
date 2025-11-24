package Ejercicio4;

import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class ReproductorMusica extends JFrame implements ActionListener {

    private JButton botonPlay;
    private JButton botonPausa;
    private JButton botonReanudar;
    private Clip audioClip;
    private long clipTiempo;

    public ReproductorMusica() {
        super("Reproductor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        botonPlay = new JButton("Reproducir");
        botonPausa = new JButton("Pausar");
        botonReanudar = new JButton("Reanudar");

        botonPlay.addActionListener(this);
        botonPausa.addActionListener(this);
        botonReanudar.addActionListener(this);

        botonPausa.setEnabled(false);
        botonReanudar.setEnabled(false);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(botonPlay);
        buttonPanel.add(botonPausa);
        buttonPanel.add(botonReanudar);

        add(buttonPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        cargarAudio("C:\\Users\\Sebastian\\git\\LP3\\Lab10FX\\src\\Ejercicio4\\musica.wav");
    }

    private void cargarAudio(String filePath) {
        try {
            File audioFile = new File(filePath);
            if (!audioFile.exists()) {
                JOptionPane.showMessageDialog(this, "Error, no se encontró el audio en " + filePath);
                return;
            }
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            audioClip = AudioSystem.getClip();
            audioClip.open(audioStream);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar el audio: " + e.getMessage());
            audioClip = null;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (audioClip == null) {
            JOptionPane.showMessageDialog(this, "No se ha cargado ningún archivo de audio.");
            return;
        }

        if (e.getSource() == botonPlay) {
            reproducirClip();
        } else if (e.getSource() == botonPausa) {
            pausarClip();
        } else if (e.getSource() == botonReanudar) {
            reanudarClip();
        }
    }

    private void reproducirClip() {
        if (audioClip.isRunning()) {
            audioClip.stop();
        }
        audioClip.setFramePosition(0);
        audioClip.start();
        clipTiempo = 0;
        botonPlay.setEnabled(false);
        botonPausa.setEnabled(true);
        botonReanudar.setEnabled(false);
    }

    private void pausarClip() {
        clipTiempo = audioClip.getMicrosecondPosition();
        audioClip.stop();
        botonPlay.setEnabled(true);
        botonPausa.setEnabled(false);
        botonReanudar.setEnabled(true);
    }

    private void reanudarClip() {
        audioClip.setMicrosecondPosition(clipTiempo);
        audioClip.start();
        botonPlay.setEnabled(false);
        botonPausa.setEnabled(true);
        botonReanudar.setEnabled(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ReproductorMusica());
    }
}