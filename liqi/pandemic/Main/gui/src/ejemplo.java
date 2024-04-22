import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.desktop.ScreenSleepEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ejemplo {
    
    public static void main(String args[]){
    	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    	
        JFrame frame1 = new JFrame();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLocationRelativeTo(null);
        frame1.setResizable(false);
        frame1.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame1.setUndecorated(true);
        
        ImageIcon playButtom = new ImageIcon("play.png");
		ImageIcon rulesButtom = new ImageIcon("rules.png");
        
        JPanel panelright = new JPanel(new BorderLayout());
        panelright.setBackground(Color.gray);
        panelright.setPreferredSize(new Dimension(screen.width,screen.height));
        
        ImageIcon iconoFondo = new ImageIcon("FondoJuego.jpg");
        Image imagenFondo = iconoFondo.getImage().getScaledInstance(800, 650, Image.SCALE_SMOOTH);
        ImageIcon imgFinalFondo = new ImageIcon(imagenFondo);
        JLabel labelFondo = new JLabel(imgFinalFondo);
        panelright.add(labelFondo, BorderLayout.CENTER);
        
        JPanel panelleft = new JPanel();
        panelleft.setBackground(Color.black);
        panelleft.setPreferredSize(new Dimension(200, 300));
        
        frame1.add(panelleft, BorderLayout.WEST);
        frame1.add(panelright, BorderLayout.EAST);
        
        // Icono
        ImageIcon iconoIcono = new ImageIcon("virus.png");
        Image imagenIcono = iconoIcono.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon imgFinalIcono = new ImageIcon(imagenIcono);
        JLabel labelIcono = new JLabel(imgFinalIcono);
        
        frame1.setIconImage(imgFinalIcono.getImage());
        
        panelleft.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        
        panelleft.add(labelIcono, gbc);
        
        gbc.gridy++;
        JLabel titulo = new JLabel("PANDEMIC");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setForeground(Color.WHITE);
        panelleft.add(titulo, gbc);
        
        gbc.gridy++;
        JButton button1 = new JButton();
        button1.setIcon(playButtom);
        button1.setBackground(new Color(0,0,0,0));
        button1.setOpaque(false);
        button1.setContentAreaFilled(false);
        button1.setBorderPainted(false);
        button1.setFocusPainted(false);
        panelleft.add(button1, gbc);
        
        gbc.gridy++;
        JButton button2 = new JButton();
        button2.setIcon(rulesButtom);
        button2.setBackground(new Color(0,0,0,0));
        button2.setOpaque(false);
        button2.setContentAreaFilled(false);
        button2.setBorderPainted(false);
        button2.setFocusPainted(false);
        panelleft.add(button2, gbc);
        
        gbc.gridy++;
        JButton button3 = new JButton();
        button3.setIcon(rulesButtom);
        button3.setBackground(new Color(0,0,0,0));
        button3.setOpaque(false);
        button3.setContentAreaFilled(false);
        button3.setBorderPainted(false);
        button3.setFocusPainted(false);
        panelleft.add(button3, gbc);
        
//        try {
//            File soundFile = new File("King.wav");
//            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
//            Clip clip = AudioSystem.getClip();
//            clip.open(audioIn);
//            clip.start();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        
        frame1.setVisible(true);
    }
}
