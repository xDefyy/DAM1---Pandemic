import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class main {
    
    public static void main(String args[]){
        
        JFrame frame1 = new JFrame();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(700, 550);
        frame1.setLocationRelativeTo(null);
        frame1.setResizable(false);
        
        JPanel panelright = new JPanel();
        panelright.setBackground(Color.gray);
        panelright.setPreferredSize(new Dimension(500,500));
        
        JPanel panelleft = new JPanel();
        panelleft.setBackground(Color.black);
        panelleft.setPreferredSize(new Dimension(200, 300));
        
        frame1.add(panelleft, BorderLayout.WEST);
        frame1.add(panelright, BorderLayout.EAST);
        
        // Configuración del panel izquierdo con GridBagLayout
        panelleft.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); // Espacio entre componentes
        
        JLabel titulo = new JLabel("PANDEMIC");
        titulo.setFont(new Font("Arial", Font.BOLD, 18)); // Tamaño de fuente reducido
        titulo.setForeground(Color.WHITE);
        panelleft.add(titulo, gbc);
        
        gbc.gridy++;
        JButton button1 = new JButton("JUGAR");
        button1.setOpaque(false); // Hacer el botón transparente
        button1.setContentAreaFilled(false); // No rellenar el área del contenido
        button1.setBorderPainted(false); // No pintar el borde del botón
        button1.setFocusPainted(false);
        button1.setForeground(Color.WHITE);
        panelleft.add(button1, gbc);
        
        gbc.gridy++;
        JButton button2 = new JButton("REGLAS");
        button2.setOpaque(false); // Hacer el botón transparente
        button2.setContentAreaFilled(false); // No rellenar el área del contenido
        button2.setBorderPainted(false); // No pintar el borde del botón
        button2.setFocusPainted(false);
        button2.setForeground(Color.WHITE);
        panelleft.add(button2, gbc);
        
        gbc.gridy++;
        JButton button3 = new JButton("SALIR");
        button3.setOpaque(false);
        button3.setContentAreaFilled(false);
        button3.setBorderPainted(false);
        button3.setFocusPainted(false);
        button3.setForeground(Color.WHITE);
        panelleft.add(button3, gbc);
        
        try {
            File file = new File("von3.jpg"); // Ruta de la imagen
            Image img = ImageIO.read(file);
            ImageIcon icon = new ImageIcon(img);
            JLabel imagenLabel = new JLabel(icon);
            panelright.add(imagenLabel);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try {
            File soundFile = new File("MexicanTrap.wav"); // Ruta del archivo de audio
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        frame1.setVisible(true);
    }
}
