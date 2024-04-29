package intefaz;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import inicio.Main;

public class CargarParty extends JFrame {
    
    public CargarParty() {
    	
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        
        JPanel panelgeneral = new JPanel(new GridLayout(2, 3));
        
        ImageIcon gifIcon = new ImageIcon("src\\img\\nuevaPartida\\giftry.gif");
        ImageIcon iconoIcono = new ImageIcon("src\\img\\main\\icono.png");
        Image imagenIcono = iconoIcono.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        ImageIcon imgFinalIcono = new ImageIcon(imagenIcono);
        
        JLabel gifLabel1 = new JLabel(gifIcon);   
        gifLabel1.setHorizontalAlignment(JLabel.CENTER); // Centrar la imagen horizontalmente
        panelgeneral.add(gifLabel1);

        JLabel gifLabel2 = new JLabel(gifIcon);
        gifLabel2.setHorizontalAlignment(JLabel.CENTER); // Centrar la imagen horizontalmente
        panelgeneral.add(gifLabel2);
        
        JLabel gifLabel3 = new JLabel(gifIcon);
        gifLabel3.setHorizontalAlignment(JLabel.CENTER); // Centrar la imagen horizontalmente
        panelgeneral.add(gifLabel3);

        JPanel panel1 = new JPanel(new BorderLayout());
        JLabel label1 = new JLabel("<html><div style='text-align: center; padding-top: 20px; font-size: 18px;'>¡Bienvenido al modo Chupete! Aquí, las epidemias se manejan con facilidad y los desafíos son prácticamente inexistentes. ¡Relájate mientras te paseas por el jardín de infancia del juego y crees que eres un héroe!");
        JButton button1 = new JButton("JUGAR");
        button1.setOpaque(false);
        button1.setContentAreaFilled(false);
        button1.setBorderPainted(false);
        button1.setFocusPainted(false);
        panel1.add(label1, BorderLayout.NORTH); // Cambié panel1 a label1
        panel1.add(button1, BorderLayout.CENTER);
        label1.setHorizontalAlignment(SwingConstants.CENTER); // Establezco la alineación en label1
        panelgeneral.add(panel1);
        
        JPanel panel2 = new JPanel(new BorderLayout());
        JLabel label2 = new JLabel("<html><div style='text-align: center; padding-top: 20px; font-size: 18px;'>Enfréntate a la pandemia como un adulto decente. Este modo es para aquellos que necesitan un poco de emoción en sus vidas, pero aún así no quieren demasiado estrés. Vamos, ¡ponte los pantalones grandes y afronta el desafío!");
        JButton button2 = new JButton("JUGAR");
        button2.setOpaque(false);
        button2.setContentAreaFilled(false);
        button2.setBorderPainted(false);
        button2.setFocusPainted(false);
        panel2.add(label2, BorderLayout.NORTH);
        panel2.add(button2, BorderLayout.CENTER);
        label2.setHorizontalAlignment(JLabel.CENTER);
        panelgeneral.add(panel2);

        JPanel panel3 = new JPanel(new BorderLayout());
        JLabel label3 = new JLabel("<html><div style='text-align: center; padding-top: 20px; font-size: 18px;'>¿Crees que eres lo suficientemente rudo para este juego? Bienvenido al modo Patea-Traseros, donde cada decisión puede ser tu última. Si quieres jugar con los grandes, prepárate para sufrir, ¡porque aquí solo los más duros sobreviven!");
        JButton button3 = new JButton("JUGAR");
        button3.setOpaque(false);
        button3.setContentAreaFilled(false);
        button3.setBorderPainted(false);
        button3.setFocusPainted(false);
        panel3.add(label3, BorderLayout.NORTH);
        panel3.add(button3, BorderLayout.CENTER);
        label3.setHorizontalAlignment(JLabel.CENTER);
        panelgeneral.add(panel3);
        
        JButton volver = new JButton("VOLVER");
	      volver.setPreferredSize(new Dimension(150,50));
	      volver.setBackground(new Color(0,0,0,0));
	      volver.setOpaque(false);
	      volver.setContentAreaFilled(false);
	      volver.setBorderPainted(false);
	      volver.setFocusPainted(false);
	      volver.setFont(new Font("Arial", Font.BOLD, 10));
	      volver.setForeground(new Color(137,5,78));
	      
	      volver.addActionListener(new ActionListener() {
	    	    public void actionPerformed(ActionEvent e) {
	    	    	Main.cargarPrincipal.setVisible(true);
	    	        Timer timer = new Timer(300, new ActionListener() {
	    	            public void actionPerformed(ActionEvent e) {
	    	                Main.cargarParty.setVisible(false);
	    	            }
	    	        });
	    	        timer.setRepeats(false);
	    	        timer.start();
	    	    }
	    	});	
	      
	      JPanel botonVolver = new JPanel();
	      botonVolver.add(volver);
	      
	      this.add(botonVolver, BorderLayout.SOUTH);
        
        this.getContentPane().add(panelgeneral, BorderLayout.CENTER);

        this.setSize(screen.width, screen.height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null); // siempre centro
		this.setResizable(false); // no se puede ajustar
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); // pantalla completa
		this.setUndecorated(true); // quita la barra de arriba
		this.setVisible(false);
		this.setTitle("Pandemic @Kader, @Liqi");
		this.setIconImage(imgFinalIcono.getImage());
    }
}
