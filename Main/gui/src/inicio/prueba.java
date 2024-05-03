package inicio;

import javax.swing.*;
import javax.swing.border.*;

import CargaDatos.controlDatos;
import controladores.controlPartida;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class prueba {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        	JFrame iniciarPartida = new JFrame();
        	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
            JPanel panelgeneral = new JPanel(new FlowLayout()) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // Dibuja la imagen de fondo
                    ImageIcon iconoFondo = new ImageIcon("src\\img\\nuevaPartida\\fondo.jpg");
                    Image imagenFondo = iconoFondo.getImage();
                    g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
                }
            };
            
            Border EmptyBorder = new EmptyBorder(25,25,25,25);
            
            ImageIcon mundoFacil = new ImageIcon("src\\img\\nuevaPartida\\facil.gif");  //115 px y 300fps
            Image mundoFaciles = mundoFacil.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
            ImageIcon facil = new ImageIcon(mundoFaciles);
            
            ImageIcon mundoNormal = new ImageIcon("src\\img\\nuevaPartida\\normal.gif");
            Image mundoNormales = mundoNormal.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
            ImageIcon normal = new ImageIcon(mundoNormales);
            
            ImageIcon mundoDificil = new ImageIcon("src\\img\\nuevaPartida\\dificil.gif");
            Image mundoDificiles = mundoDificil.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
            ImageIcon dificil = new ImageIcon(mundoDificiles);
            
            
            ImageIcon iconoIcono = new ImageIcon("src\\img\\main\\icono.png");
            Image imagenIcono = iconoIcono.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
            ImageIcon imgFinalIcono = new ImageIcon(imagenIcono);
            
            ImageIcon iconoFondo = new ImageIcon("src\\img\\nuevaPartida\\marcoFacil.png");
            Image marcoEz = iconoFondo.getImage().getScaledInstance(screen.width/2, screen.height-50, Image.SCALE_SMOOTH);
            
            JPanel easyGeneral = new JPanel();
            
            GridBagConstraints gbcEasy = new GridBagConstraints();
            
            easyGeneral.setBorder(EmptyBorder);
            easyGeneral.setPreferredSize(new Dimension (screen.width/3, screen.height));
            easyGeneral.setOpaque(false);
            
            JLabel imgEz = new JLabel(new ImageIcon(marcoEz));
            imgEz.setBounds(0,0, screen.width/3, screen.height-50);
            
            easyGeneral.add(imgEz);
            panelgeneral.add(easyGeneral);
            
            
            
            JLabel gifLabel2 = new JLabel(normal);
            gifLabel2.setHorizontalAlignment(JLabel.CENTER); 
            panelgeneral.add(gifLabel2);
            
            JLabel gifLabel3 = new JLabel(dificil);
            gifLabel3.setHorizontalAlignment(JLabel.CENTER); 
            panelgeneral.add(gifLabel3);

            JPanel panel1 = new JPanel(new BorderLayout());
            panel1.setBorder(new LineBorder(Color.white, 5, true));
            JLabel label1 = new JLabel("<html><div style='text-align: center; padding-top: 20px; font-size: 18px;'>¡Bienvenido al modo Chupete! Aquí, las epidemias se manejan con facilidad y los desafíos son prácticamente inexistentes. ¡Relájate mientras te paseas por el jardín de infancia del juego y crees que eres un héroe!");
            label1.setForeground(new Color(137,5,78));
            JButton button1 = new JButton("JUGAR");
            button1.setOpaque(false);
            button1.setContentAreaFilled(false);
            button1.setBorderPainted(false);
            button1.setFocusPainted(false);
            button1.setForeground(new Color(137,5,78));
            panel1.setOpaque(false);
            panel1.add(label1, BorderLayout.NORTH); // Cambié panel1 a label1
            panel1.add(button1, BorderLayout.CENTER);
            label1.setHorizontalAlignment(SwingConstants.CENTER); // Establezco la alineación en label1
            panelgeneral.add(panel1);
            
            button1.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		iniciarPartida.setVisible(true);
        	    	
        	        Timer timer = new Timer(300, new ActionListener() {
        	            public void actionPerformed(ActionEvent e) {
        	            	Main.cargarParty.setVisible(false);
        	            }
        	        });
        	        timer.setRepeats(false);
        	        timer.start();
            		
            		controlDatos.controlDificultad(0);
            		controlPartida.iniciar_Partida();
            		
        	    }
        	});
            
            
            JPanel panel2 = new JPanel(new BorderLayout());
            JLabel label2 = new JLabel("<html><div style='text-align: center; padding-top: 20px; font-size: 18px;'>Enfréntate a la pandemia como un adulto decente. Este modo es para aquellos que necesitan un poco de emoción en sus vidas, pero aún así no quieren demasiado estrés. Vamos, ¡ponte los pantalones grandes y afronta el desafío!");
            label2.setForeground(new Color(137,5,78));
            JButton button2 = new JButton("JUGAR");
            button2.setOpaque(false);
            button2.setContentAreaFilled(false);
            button2.setBorderPainted(false);
            button2.setFocusPainted(false);
            button2.setForeground(new Color(137,5,78));
            panel2.setOpaque(false);
            panel2.add(label2, BorderLayout.NORTH);
            panel2.add(button2, BorderLayout.CENTER);
            label2.setHorizontalAlignment(JLabel.CENTER);
            panelgeneral.add(panel2);
            
            button2.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		iniciarPartida.setVisible(true);
        	    	
        	        Timer timer = new Timer(300, new ActionListener() {
        	            public void actionPerformed(ActionEvent e) {
        	            	Main.cargarParty.setVisible(false);
        	            }
        	        });
        	        timer.setRepeats(false);
        	        timer.start();
            		
            		controlDatos.controlDificultad(1);
            		controlPartida.iniciar_Partida();
            		
        	    }
        	});
            
            JPanel panel3 = new JPanel(new BorderLayout());
            JLabel label3 = new JLabel("<html><div style='text-align: center; padding-top: 20px; font-size: 18px;'>¿Crees que eres lo suficientemente rudo para este juego? Bienvenido al modo Patea-Traseros, donde cada decisión puede ser tu última. Si quieres jugar con los grandes, prepárate para sufrir, ¡porque aquí solo los más duros sobreviven!");
            label3.setForeground(new Color(137,5,78));
            JButton button3 = new JButton("JUGAR");
            button3.setOpaque(false);
            button3.setContentAreaFilled(false);
            button3.setBorderPainted(false);
            button3.setFocusPainted(false);
            button3.setForeground(new Color(137,5,78));
            panel3.add(label3, BorderLayout.NORTH);
            panel3.add(button3, BorderLayout.CENTER);
            panel3.setOpaque(false);
            label3.setHorizontalAlignment(JLabel.CENTER);
            panelgeneral.add(panel3);
            
            button3.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		
            		iniciarPartida.setVisible(true);
        	    	
        	        Timer timer = new Timer(300, new ActionListener() {
        	            public void actionPerformed(ActionEvent e) {
        	            	Main.cargarParty.setVisible(false);
        	            }
        	        });
        	        timer.setRepeats(false);
        	        timer.start();
            		
            		controlDatos.controlDificultad(2);
            		controlPartida.iniciar_Partida();
            		
        	    }
        	});
            
            JButton volver = new JButton("VOLVER");
    	      volver.setPreferredSize(new Dimension(150,50));
    	      volver.setBackground(new Color(0,0,0,0));
    	      volver.setOpaque(false);
    	      volver.setContentAreaFilled(false);
    	      volver.setBorderPainted(false);
    	      volver.setFocusPainted(false);
    	      volver.setFont(new Font("Arial", Font.BOLD, 20));
    	      volver.setForeground(new Color(137,5,78));
    	      volver.setPreferredSize(new Dimension(screen.width,50));
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
    	      botonVolver.setBackground(Color.black);
    	      botonVolver.add(volver);
    	      
    	    iniciarPartida.add(botonVolver, BorderLayout.SOUTH);
            
    	    iniciarPartida.getContentPane().add(panelgeneral, BorderLayout.CENTER);

    	    iniciarPartida.setSize(screen.width, screen.height);
    	    iniciarPartida.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	    iniciarPartida.setLocationRelativeTo(null); // siempre centro
    	    iniciarPartida.setResizable(false); // no se puede ajustar
    	    iniciarPartida.setExtendedState(JFrame.MAXIMIZED_BOTH); // pantalla completa
    	    iniciarPartida.setUndecorated(true); // quita la barra de arriba
    	    iniciarPartida.setVisible(true);
    	    iniciarPartida.setTitle("Pandemic @Kader, @Liqi");
    	    iniciarPartida.setIconImage(imgFinalIcono.getImage());
        });
    }
}
