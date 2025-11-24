package Actividades;

import javax.sound.sampled.*;
import javax.swing.*;

import java.awt.FlowLayout;
import java.io.File;
import java.io.IOException;

public class AudioWAVEjemplo {
	
	private static Clip clip;
	 
    public static void main(String[] args) {
        JFrame frame = new JFrame("Reproducción de Audio");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

        JButton playButton = new JButton("Reproducir Audio");
        playButton.addActionListener(e -> playAudio("C:\\Users\\Sebastian\\Downloads\\testwefoundlove.wav"));	
        JButton stopButton = new JButton("Detener Audio");
        stopButton.addActionListener(e -> {
        	if (clip != null && clip.isRunning()) {
        		clip.stop();
        		System.out.println("El audio fue detenido");
        	}
        });
        frame.add(playButton);
        frame.add(stopButton);
        frame.setVisible(true);
    }

    public static void playAudio(String filePath) {
    	
    	if (clip != null && clip.isRunning()) {
    		clip.stop();
    		clip.close();
    	}
    	
        try {
            File audioFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            
            audioStream.close();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
