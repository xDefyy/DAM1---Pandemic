package intefaz;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import javax.swing.*;

import controladores.controlPartida;
import inicio.Main;

public class Reglas extends JFrame {
    
    public Reglas() {
    	
      Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
      
      String texto = "<html><div>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do";
      String texto20 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do ";
      
      ImageIcon iconoIcono = new ImageIcon("src\\img\\main\\icono.png");
      Image imagenIcono = iconoIcono.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
      ImageIcon imgFinalIcono = new ImageIcon(imagenIcono);

      JPanel panelgeneral = new JPanel();
      // Establecer un GridLayout de 2x2
      panelgeneral.setLayout(new GridLayout(0, 2)); // Se establece 0 para que las filas se vayan ajustando automáticamente
      
   // Bloque 1
      ImageIcon icon1 = new ImageIcon("src\\img\\reglas\\fondo.png");
      Image imagenIcono1 = icon1.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
      ImageIcon imgFinalIcono1 = new ImageIcon(imagenIcono1);
      JLabel imagen1 = new JLabel(imgFinalIcono1);
      panelgeneral.add(imagen1);
      
      JLabel texto1 = new JLabel(texto+texto20);
      texto1.setHorizontalAlignment(JLabel.CENTER);
      texto1.setVerticalAlignment(JLabel.CENTER);
      panelgeneral.add(texto1);

      // Bloque 2
      ImageIcon icon2 = new ImageIcon("src\\img\\reglas\\fondo.png");
      Image imagenIcono2 = icon2.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
      ImageIcon imgFinalIcono2 = new ImageIcon(imagenIcono2);
      JLabel imagen2 = new JLabel(imgFinalIcono2);
      panelgeneral.add(imagen2);
      
      JLabel texto2 = new JLabel(texto);
      texto2.setHorizontalAlignment(JLabel.CENTER);
      texto2.setVerticalAlignment(JLabel.CENTER);
      panelgeneral.add(texto2);

      // Bloque 3
      ImageIcon icon3 = new ImageIcon("src\\img\\reglas\\fondo.png");
      Image imagenIcono3 = icon3.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
      ImageIcon imgFinalIcono3 = new ImageIcon(imagenIcono3);
      JLabel imagen3 = new JLabel(imgFinalIcono3);
      panelgeneral.add(imagen3);
      
      JLabel texto3 = new JLabel(texto);
      texto3.setHorizontalAlignment(JLabel.CENTER);
      texto3.setVerticalAlignment(JLabel.CENTER);
      panelgeneral.add(texto3);

      // Bloque 4
      ImageIcon icon4 = new ImageIcon("src\\img\\reglas\\fondo.png");
      Image imagenIcono4 = icon4.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
      ImageIcon imgFinalIcono4 = new ImageIcon(imagenIcono4);
      JLabel imagen4 = new JLabel(imgFinalIcono4);
      panelgeneral.add(imagen4);
      
      JLabel texto4 = new JLabel(texto);
      texto4.setHorizontalAlignment(JLabel.CENTER);
      texto4.setVerticalAlignment(JLabel.CENTER);
      panelgeneral.add(texto4);

      // Bloque 5
      ImageIcon icon5 = new ImageIcon("src\\img\\reglas\\fondo.png");
      Image imagenIcono5 = icon5.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
      ImageIcon imgFinalIcono5 = new ImageIcon(imagenIcono5);
      JLabel imagen5 = new JLabel(imgFinalIcono5);
      panelgeneral.add(imagen5);

      JLabel texto5 = new JLabel(texto);
      texto5.setHorizontalAlignment(JLabel.CENTER);
      texto5.setVerticalAlignment(JLabel.CENTER);
      panelgeneral.add(texto5);
      
      // Bloque 6
      ImageIcon icon6 = new ImageIcon("src\\img\\reglas\\fondo.png");
      Image imagenIcono6 = icon6.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
      ImageIcon imgFinalIcono6 = new ImageIcon(imagenIcono6);
      JLabel imagen6 = new JLabel(imgFinalIcono6);
      panelgeneral.add(imagen6);
      
      JLabel texto6 = new JLabel(texto);
      texto6.setHorizontalAlignment(JLabel.CENTER);
      texto6.setVerticalAlignment(JLabel.CENTER);
      panelgeneral.add(texto6);

      // Bloque 7
      ImageIcon icon7 = new ImageIcon("src\\img\\reglas\\fondo.png");
      Image imagenIcono7 = icon7.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
      ImageIcon imgFinalIcono7 = new ImageIcon(imagenIcono7);
      JLabel imagen7 = new JLabel(imgFinalIcono7);
      panelgeneral.add(imagen7);
      
      JLabel texto7 = new JLabel(texto);
      texto7.setHorizontalAlignment(JLabel.CENTER);
      texto7.setVerticalAlignment(JLabel.CENTER);
      panelgeneral.add(texto7);

      // Bloque 8
      ImageIcon icon8 = new ImageIcon("src\\img\\reglas\\fondo.png");
      Image imagenIcono8 = icon8.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
      ImageIcon imgFinalIcono8 = new ImageIcon(imagenIcono8);
      JLabel imagen8 = new JLabel(imgFinalIcono8);
      panelgeneral.add(imagen8);
      
      JLabel texto8 = new JLabel(texto);
      texto8.setHorizontalAlignment(JLabel.CENTER);
      texto8.setVerticalAlignment(JLabel.CENTER);
      panelgeneral.add(texto8);

      // Bloque 9
      ImageIcon icon9 = new ImageIcon("src\\img\\reglas\\fondo.png");
      Image imagenIcono9 = icon9.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
      ImageIcon imgFinalIcono9 = new ImageIcon(imagenIcono9);
      JLabel imagen9 = new JLabel(imgFinalIcono9);
      panelgeneral.add(imagen9);
      
      JLabel texto9 = new JLabel(texto);
      texto9.setHorizontalAlignment(JLabel.CENTER);
      texto9.setVerticalAlignment(JLabel.CENTER);
      panelgeneral.add(texto9);

      // Bloque 10
      ImageIcon icon10 = new ImageIcon("src\\img\\reglas\\fondo.png");
      Image imagenIcono10 = icon10.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
      ImageIcon imgFinalIcono10 = new ImageIcon(imagenIcono10);
      JLabel imagen10 = new JLabel(imgFinalIcono10);
      panelgeneral.add(imagen10);
      
      JLabel texto10 = new JLabel(texto);
      texto10.setHorizontalAlignment(JLabel.CENTER);
      texto10.setVerticalAlignment(JLabel.CENTER);
      panelgeneral.add(texto10);

      // Establecer el tamaño preferido del panel general
      panelgeneral.setPreferredSize(new Dimension(400, panelgeneral.getComponentCount() * 150)); // Ajustar el ancho según el número de componentes

      JScrollPane scrollPane = new JScrollPane(panelgeneral);
      scrollPane.getVerticalScrollBar().setUnitIncrement(20); // Ajustar la velocidad de desplazamiento (en píxeles)
      
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
    	                Main.CargarReglas.setVisible(false);
    	            }
    	        });
    	        timer.setRepeats(false);
    	        timer.start();
    	    }
    	});	
      
      JPanel botonVolver = new JPanel();
      botonVolver.add(volver);
      
      this.add(botonVolver, BorderLayout.SOUTH);
      this.add(scrollPane, BorderLayout.CENTER);
      
       

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