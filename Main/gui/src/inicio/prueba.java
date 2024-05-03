package inicio;

import javax.swing.*;
import javax.swing.border.*;

import CargaDatos.controlDatos;
import controladores.controlPartida;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Flow;


public class prueba {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        	JFrame iniciarPartida = new JFrame();
        	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
            JPanel panelgeneral = new JPanel(new FlowLayout(10,10,10)) {
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
            Image mundoFaciles = mundoFacil.getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT);
            ImageIcon facil = new ImageIcon(mundoFaciles);
            
            ImageIcon mundoNormal = new ImageIcon("src\\img\\nuevaPartida\\normal.gif");
            Image mundoNormales = mundoNormal.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
            ImageIcon normal = new ImageIcon(mundoNormales);
            
            ImageIcon mundoDificil = new ImageIcon("src\\img\\nuevaPartida\\dificil.gif");
            Image mundoDificiles = mundoDificil.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
            ImageIcon dificil = new ImageIcon(mundoDificiles);
            
            ImageIcon imgFacil = new ImageIcon("src\\img\\nuevaPartida\\imgFacil.png");  //115 px y 300fps
            Image imgEs = imgFacil.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
            ImageIcon mundoimgFacil = new ImageIcon(imgEs);
            
            ImageIcon imgNormal = new ImageIcon("src\\img\\nuevaPartida\\imgNormal.png");  //115 px y 300fps
            Image imgNormales = imgNormal.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
            ImageIcon mundoimgNormal = new ImageIcon(imgNormales);
            
            ImageIcon imgDificil = new ImageIcon("src\\img\\nuevaPartida\\imgDificil.png");  //115 px y 300fps
            Image imgdificiles = imgDificil.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
            ImageIcon mundoimgdificil = new ImageIcon(imgdificiles);
            
            ImageIcon imgNormalOP = new ImageIcon("src\\img\\nuevaPartida\\imgNormalOP.png");  //115 px y 300fps
            Image imgNormalesOP = imgNormalOP.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
            ImageIcon mundoimgNormalOP = new ImageIcon(imgNormalesOP);
            
            ImageIcon imgDificilOP = new ImageIcon("src\\img\\nuevaPartida\\imgDificilOP.png");  //115 px y 300fps
            Image imgdificilesOP = imgDificilOP.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
            ImageIcon mundoimgdificilOP = new ImageIcon(imgdificilesOP);
            
            ImageIcon iconoIcono = new ImageIcon("src\\img\\main\\icono.png");
            Image imagenIcono = iconoIcono.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
            ImageIcon imgFinalIcono = new ImageIcon(imagenIcono);
            
            JPanel easyGeneral = new JPanel(new GridBagLayout()){
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // Dibuja la imagen de fondo
                    ImageIcon iconoFondo = new ImageIcon("src\\img\\nuevaPartida\\marcoFacil.jpg");
                    Image imagenFondo = iconoFondo.getImage();
                    g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
                }
            }; 
            easyGeneral.setBorder(new LineBorder(Color.LIGHT_GRAY, 10, false));
            easyGeneral.setPreferredSize(new Dimension (screen.width/3, screen.height-70));
            easyGeneral.setOpaque(false);
            
            GridBagConstraints gbcEasy = new GridBagConstraints();
            
            gbcEasy.gridx = 0;
            gbcEasy.gridy = 0;
            
            Dimension mundo = new Dimension(450,450);
            
            JPanel mundoEz = new JPanel();
            mundoEz.setOpaque(false);
            mundoEz.setPreferredSize(mundo);
            JLabel mundoIcon = new JLabel(facil);
            mundoEz.add(mundoIcon);
            	
            easyGeneral.add(mundoEz,gbcEasy);
            
            gbcEasy.gridy = 1;
            
            JPanel dificultadEz =  new JPanel(new GridBagLayout());
            
            GridBagConstraints gbcEasyAbajo = new GridBagConstraints();
            
            gbcEasyAbajo.gridx = 0;
            gbcEasyAbajo.gridy = 0;
            
            dificultadEz.setOpaque(true);
            dificultadEz.setBackground(new Color(0,0,0,128));
            dificultadEz.setBorder(new EtchedBorder(EtchedBorder.RAISED));
            
            JPanel dificultad = new JPanel(new FlowLayout());
            dificultad.setOpaque(false);
            
            JLabel dificultadIm = new JLabel("Dificultad - ");
            dificultadIm.setFont(fuente());
            dificultadIm.setForeground(new Color(79,164,184));
            dificultad.add(dificultadIm);
            //mirar panel princpal y ponerle wl width
            JLabel mundoF = new JLabel(mundoimgFacil);
            dificultad.add(mundoF);
            
            JLabel mundoN = new JLabel(mundoimgNormalOP);
            dificultad.add(mundoN);
            
            JLabel mundoD = new JLabel(mundoimgdificilOP);
            dificultad.add(mundoD);
            
            dificultadEz.add(dificultad, gbcEasyAbajo);
            
            gbcEasyAbajo.gridy = 1;
            
            JPanel descFacil = new JPanel(new FlowLayout());
            descFacil.setOpaque(false);
            
            JLabel textofacil = new JLabel();
            textofacil.setForeground(Color.white);
            textofacil.setFont(fuenteTexto());
            textofacil.setText("Bienvenido al modo");
            descFacil.add(textofacil);
            
            JLabel textofacil2 = new JLabel();
            textofacil2.setForeground(new Color(79,164,184));
            textofacil2.setFont(fuenteTexto());
            textofacil2.setText("Chupete");
            
            
            descFacil.add(textofacil2);
            
            dificultadEz.add(descFacil, gbcEasyAbajo);
            
            gbcEasyAbajo.gridy = 2;
            
            JTextArea desc = new JTextArea();
            desc.setSize(screen.width/3 - 20, 400);
            desc.setText("Este es un texto largo que no debería ser cortado si el área de texto es lo suficientemente grande.");
            desc.setEditable(false);
            desc.setForeground(Color.white);
            desc.setOpaque(false);
            desc.setLineWrap(true);
            desc.setWrapStyleWord(true);
            desc.setFont(fuenteTextoDesc());
            desc.setAlignmentX(0);
            desc.setMargin(new Insets(10,10,10,10));
            
            
            dificultadEz.add(desc, gbcEasyAbajo);
            
            easyGeneral.add(dificultadEz, gbcEasy);
            
            
            
            panelgeneral.add(easyGeneral);
            
            
            
            JLabel gifLabel2 = new JLabel(normal);
            gifLabel2.setHorizontalAlignment(JLabel.CENTER); 
            panelgeneral.add(gifLabel2);
            
            JLabel gifLabel3 = new JLabel(dificil);
            gifLabel3.setHorizontalAlignment(JLabel.CENTER); 
            panelgeneral.add(gifLabel3);

            
            
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
    private static Font fuente() {
		try {
        	File fuente = new File("src\\fuente\\fuenteTitulo.ttf");
            
            Font font = Font.createFont(Font.TRUETYPE_FONT, fuente);
            
            // Tamaño de la fuente (en puntos)
            float fontSize = 25;
            
            font = font.deriveFont(fontSize);
            return font;

        } catch (IOException | FontFormatException e) {
        	Font defaultFont = new Font("Arial", Font.PLAIN, 30);
            e.printStackTrace();
            return defaultFont;
        }
	}
    private static Font fuenteTexto() {
		try {
        	File fuente = new File("src\\fuente\\fuenteTexto.ttf");
            
            Font font = Font.createFont(Font.TRUETYPE_FONT, fuente);
            
            // Tamaño de la fuente (en puntos)
            float fontSize = 15;
            
            font = font.deriveFont(fontSize);
            return font;

        } catch (IOException | FontFormatException e) {
        	Font defaultFont = new Font("Arial", Font.PLAIN, 15);
            e.printStackTrace();
            return defaultFont;
        }
	}
    private static Font fuenteTextoDesc() {
		try {
        	File fuente = new File("src\\fuente\\fuenteTexto.ttf");
            
            Font font = Font.createFont(Font.TRUETYPE_FONT, fuente);
            
            // Tamaño de la fuente (en puntos)
            float fontSize = 13.5f;
            
            font = font.deriveFont(fontSize);
            return font;

        } catch (IOException | FontFormatException e) {
        	Font defaultFont = new Font("Arial", Font.PLAIN, 15);
            e.printStackTrace();
            return defaultFont;
        }
	}
    
    
    public static void lol () {
    	JPanel panel1 = new JPanel(new BorderLayout());
        panel1.setBorder(new LineBorder(Color.white, 5, true));
        JLabel label1 = new JLabel("<html><div style='text-align: center; padding-top: 20px; font-size: 18px;'>¡");
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
    }
}
