import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class partida extends JFrame {	
	public static JProgressBar Alfa = new JProgressBar();
	public static JProgressBar Beta = new JProgressBar();
	public static JProgressBar Gamma = new JProgressBar();
	public static JProgressBar Delta = new JProgressBar();
	partida() {
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		ImageIcon iconoIcono = new ImageIcon("src\\img\\inGame\\icono.png");
	    Image imagenIcono = iconoIcono.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
	    Image IconPersonaje = iconoIcono.getImage().getScaledInstance(screen.height/7, screen.height/7, Image.SCALE_SMOOTH);
	    ImageIcon imgFinalIcono = new ImageIcon(imagenIcono);
	    ImageIcon personajeIcon = new ImageIcon(IconPersonaje);
		LineBorder borderRojo = new LineBorder(new Color(137,5,78),3);

	    //pabel principal
		JPanel game = new JPanel() {
			@Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            // Dibuja la imagen de fondo
	            ImageIcon iconoFondo = new ImageIcon("src\\img\\inGame\\FondoJuego.jfif");
	            Image imagenFondo = iconoFondo.getImage();
	            g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
	        }
		};
		game.setLayout(new BorderLayout());
		
		//panel izquierdo botones
		JPanel botonesTexto = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Dibuja la imagen de fondo
                ImageIcon barraIcono = new ImageIcon("src\\img\\inGame\\barra_Juego.jpg");
                Image imagenFondo = barraIcono.getImage();
                g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
            }
        };
		botonesTexto.setLayout(new FlowLayout());
		botonesTexto.setOpaque(false);
		botonesTexto.setPreferredSize(new Dimension (screen.width, screen.height / 6));
		botonesTexto.setBorder(borderRojo);
		
		JPanel botonCurarFinalizar = new JPanel();
		botonCurarFinalizar.setOpaque(false);
		botonCurarFinalizar.setLayout(new GridLayout(2,1,10,10));
		
		JButton curar = new JButton("Curar");
		curar.setPreferredSize(new Dimension(150,50));
		curar.setBackground(new Color(0,0,0,0));
		curar.setOpaque(false);
		curar.setContentAreaFilled(false);
		curar.setBorderPainted(false);
		curar.setFocusPainted(false);
		curar.setFont(new Font("Arial", Font.BOLD, 10));
		curar.setForeground(new Color(137,5,78));
		
		JButton finalizarRonda = new JButton("Finalizar Ronda");
		finalizarRonda.setPreferredSize(new Dimension(150,50));
		finalizarRonda.setBackground(new Color(0,0,0,0));
        finalizarRonda.setOpaque(false);
        finalizarRonda.setContentAreaFilled(false);
        finalizarRonda.setBorderPainted(false);
        finalizarRonda.setFocusPainted(false);
        finalizarRonda.setFont(new Font("Arial", Font.BOLD, 10));
        finalizarRonda.setForeground(new Color(137,5,78));
		
		botonCurarFinalizar.add(curar);
		botonCurarFinalizar.add(finalizarRonda);
		
		botonesTexto.add(botonCurarFinalizar);
		
		JLabel personaje = new JLabel();
		personaje.setBorder(borderRojo);
		personaje.setIcon(personajeIcon);
		
		botonesTexto.add(personaje);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false); // No editable
		textArea.setPreferredSize(new Dimension(screen.width/2, screen.height/7));
		
		// Tipo de letra personalizado
		textArea.setFont(new Font("Arial", Font.ITALIC, 15));

		// Color de fondo y texto
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setForeground(new Color(137,5,78));

		// Bordes personalizados
		Border border = BorderFactory.createLineBorder(Color.GRAY, 2);
		textArea.setBorder(BorderFactory.createCompoundBorder(border,
		        BorderFactory.createEmptyBorder(5, 5, 5, 5))); // Agrega un borde compuesto con un borde de línea gris y un relleno interno de 5 píxeles

		// Espaciado interno
		textArea.setMargin(new Insets(5, 5, 5, 5)); // Ajusta el margen interno del JTextArea

		// Agrega el JTextArea a tu panel o contenedor


        // Redirigir la salida de la consola al JTextArea
        OutputStream outputStream = new OutputStream() {
            @Override
            public void write(int b) {
                textArea.append(String.valueOf((char) b));
            }
        };
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        
        botonesTexto.add(textArea);
        
        JPanel DesarrollarCura = new JPanel();
        DesarrollarCura.setLayout(new GridLayout(2,2,10,10));
        DesarrollarCura.setOpaque(false);
        
        JButton DAlfa = new JButton("Desarrollar Alfa");
        DAlfa.setPreferredSize(new Dimension(150,50));
        DAlfa.setBackground(new Color(0,0,0,0));
        DAlfa.setOpaque(false);
        DAlfa.setContentAreaFilled(false);
        DAlfa.setBorderPainted(false);
        DAlfa.setFocusPainted(false);
        DAlfa.setFont(new Font("Arial", Font.BOLD, 10));
        DAlfa.setForeground(new Color(137,5,78));
        JButton DBeta = new JButton("Desarrollar Beta");
        DBeta.setPreferredSize(new Dimension(150,50));
        DBeta.setBackground(new Color(0,0,0,0));
        DBeta.setOpaque(false);
        DBeta.setContentAreaFilled(false);
        DBeta.setBorderPainted(false);
        DBeta.setFocusPainted(false);
        DBeta.setFont(new Font("Arial", Font.BOLD, 10));
        DBeta.setForeground(new Color(137,5,78));
        JButton DGamma = new JButton("Desarrollar Gamma");
        DGamma.setPreferredSize(new Dimension(150,50));
        DGamma.setBackground(new Color(0,0,0,0));
        DGamma.setOpaque(false);
        DGamma.setContentAreaFilled(false);
        DGamma.setBorderPainted(false);
        DGamma.setFocusPainted(false);
        DGamma.setFont(new Font("Arial", Font.BOLD, 10));
        DGamma.setForeground(new Color(137,5,78));
        JButton DDelta = new JButton("Desarrollar Delta");
        DDelta.setPreferredSize(new Dimension(150,50));
        DDelta.setBackground(new Color(0,0,0,0));
        DDelta.setOpaque(false);
        DDelta.setContentAreaFilled(false);
        DDelta.setBorderPainted(false);
        DDelta.setFocusPainted(false);
        DDelta.setFont(new Font("Arial", Font.BOLD, 10));
        DDelta.setForeground(new Color(137,5,78));

        DesarrollarCura.add(DAlfa);
        DesarrollarCura.add(DBeta);
        DesarrollarCura.add(DGamma);
        DesarrollarCura.add(DDelta);
        
        botonesTexto.add(DesarrollarCura);
        
        //panel derecha
		JPanel stats = new JPanel();
		stats.setPreferredSize(new Dimension (screen.width/7, screen.height));
		stats.setLayout(new GridBagLayout());
		
		
		
		GridBagConstraints gbcStats = new GridBagConstraints();
		gbcStats.gridx = 0;
		gbcStats.gridy = 0;
		gbcStats.insets = new Insets(10, 10, 10, 10);
		
		JLabel score = new JLabel();
		score.setText("Puntos: 0"); //TODO METER VARIABLE DE SCORE
		score.setFont(new Font("Arial", Font.BOLD, 20));
		
		stats.add(score, gbcStats);
		
		gbcStats.gridy = 1;
		JLabel ciudadesInf = new JLabel();
		ciudadesInf.setText("Ciudades Infectadas: 0"); //TODO METER VARIABLE DE SCORE
		ciudadesInf.setFont(new Font("Arial", Font.BOLD, 15));
		
		stats.add(ciudadesInf, gbcStats);
		
		gbcStats.gridy = 2;
		JLabel brotes = new JLabel();
		brotes.setText("Brotes: 0"); //TODO METER VARIABLE DE SCORE
		brotes.setFont(new Font("Arial", Font.BOLD, 15));
		
		stats.add(brotes, gbcStats);
		
		
		Alfa.setStringPainted(true); // Muestra el valor actual de la barra de progreso
		Alfa.setString("Progreso Alfa = " + Alfa.getValue());
		Alfa.setMinimum(0); // Valor mínimo de la barra de progreso
		Alfa.setMaximum(100); // Valor máximo de la barra de progreso
		Alfa.setValue(0);
		
		Alfa.setUI(new javax.swing.plaf.basic.BasicProgressBarUI() {
            protected Color getSelectionBackground() { 
                return Color.BLUE; // Cambia el color de la barra cuando progresa
            }
        });
		gbcStats.gridy = 3;
		stats.add(Alfa,gbcStats);

		gbcStats.gridy = 4;		
		Beta.setStringPainted(true); // Muestra el valor actual de la barra de progreso
		Beta.setString("Progreso Beta = " + Beta.getValue());
		Beta.setMinimum(0); // Valor mínimo de la barra de progreso
		Beta.setMaximum(100); // Valor máximo de la barra de progreso
		Beta.setValue(0);
		
		Beta.setUI(new javax.swing.plaf.basic.BasicProgressBarUI() {
            protected Color getSelectionBackground() { 
                return Color.red; // Cambia el color de la barra cuando progresa
            }
        });
		
		stats.add(Beta,gbcStats);

		gbcStats.gridy = 5;		
		Gamma.setStringPainted(true); // Muestra el valor actual de la barra de progreso
		Gamma.setString("Progreso Gamma = " + Gamma.getValue());
		Gamma.setMinimum(0); // Valor mínimo de la barra de progreso
		Gamma.setMaximum(100); // Valor máximo de la barra de progreso
		Gamma.setValue(0);
		
		Gamma.setUI(new javax.swing.plaf.basic.BasicProgressBarUI() {
            protected Color getSelectionBackground() { 
                return Color.green; // Cambia el color de la barra cuando progresa
            }
        });
		
		stats.add(Gamma,gbcStats);
		
		gbcStats.gridy = 6;
		Delta.setStringPainted(true); // Muestra el valor actual de la barra de progreso
		Delta.setString("Progreso Delta = " + Delta.getValue());
		Delta.setMinimum(0); // Valor mínimo de la barra de progreso
		Delta.setMaximum(100); // Valor máximo de la barra de progreso
		Delta.setValue(0);
		
		Delta.setUI(new javax.swing.plaf.basic.BasicProgressBarUI() {
            protected Color getSelectionBackground() { 
                return new Color(255,254,124); // Cambia el color de la barra cuando progresa
            }
        });
		
		stats.add(Delta,gbcStats);

		gbcStats.gridy = 7;
		JButton opciones = new JButton("OPCIONES");
		opciones.setPreferredSize(new Dimension(150,50));
		opciones.setBackground(new Color(0,0,0,0));
		opciones.setOpaque(false);
		opciones.setContentAreaFilled(false);
		opciones.setBorderPainted(false);
		opciones.setFocusPainted(false);
		opciones.setFont(new Font("Arial", Font.BOLD, 20));
		opciones.setForeground(new Color(137,5,78));

		stats.add(opciones, gbcStats);
		
		
		
		//FUNCIONES DE LOS BOTONES
		curar.addActionListener(new ActionListener() {  //Esto hace que el boton este a la espera para hacer la funcion de abajo
            public void actionPerformed(ActionEvent e) {
            	controlPartida.gestionar_Cura();
            }
        });
		
		finalizarRonda.addActionListener(new ActionListener() {  //Esto hace que el boton este a la espera para hacer la funcion de abajo
            public void actionPerformed(ActionEvent e) {
            	controlPartida.gestionar_Turno();
            }
        });
		
		DAlfa.addActionListener(new ActionListener() {  //Esto hace que el boton este a la espera para hacer la funcion de abajo
            public void actionPerformed(ActionEvent e) {
            	controlPartida.gestionar_Vacuna(0);
            }
        });
		
		DBeta.addActionListener(new ActionListener() {  //Esto hace que el boton este a la espera para hacer la funcion de abajo
            public void actionPerformed(ActionEvent e) {
            	controlPartida.gestionar_Vacuna(1);
            }
        });
		
		DGamma.addActionListener(new ActionListener() {  //Esto hace que el boton este a la espera para hacer la funcion de abajo
            public void actionPerformed(ActionEvent e) {
            	controlPartida.gestionar_Vacuna(2);
            }
        });
		
		DDelta.addActionListener(new ActionListener() {  //Esto hace que el boton este a la espera para hacer la funcion de abajo
            public void actionPerformed(ActionEvent e) {
            	controlPartida.gestionar_Vacuna(3);
            }
        });
		
		opciones.addActionListener(new ActionListener() {  //Esto hace que el boton este a la espera para hacer la funcion de abajo
            public void actionPerformed(ActionEvent e) {
            	//menu para guardar partida
            }
        });
		
		
		
		
		
		
		
		this.add(game, BorderLayout.CENTER);
		this.add(stats, BorderLayout.EAST);
		this.add(botonesTexto, BorderLayout.SOUTH);
		
		this.setSize(screen.width, screen.height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null); // siempre centro
		this.setResizable(false); // no se puede ajustar
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); // pantalla completa
		this.setUndecorated(true); // quita la barra de arriba
		this.setVisible(true);
		this.setTitle("Pandemic @Kader, @Liqi");
		this.setIconImage(imgFinalIcono.getImage());
		
		
		
		
	}
	
}
