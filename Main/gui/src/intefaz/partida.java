package intefaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.plaf.basic.BasicProgressBarUI;

import CargaDatos.controlDatos;
import controladores.controlPartida;
import inicio.Main;

public class partida extends JFrame implements ActionListener  {
	public static JProgressBar Alfa = new JProgressBar();
	public static JProgressBar Beta = new JProgressBar();
	public static JProgressBar Gamma = new JProgressBar();
	public static JProgressBar Delta = new JProgressBar();
	public static JButton DAlfa = new JButton("Desarrollar VIH");
	public static JButton DBeta = new JButton("Desarrollar CANCER");
	public static JButton DGamma = new JButton("Desarrollar SARS");
	public static JButton DDelta = new JButton("Desarrollar NIGGA");
	public static JButton finalizarRonda = new JButton("Finalizar Ronda");
	public static JButton curar = new JButton("Curar");
	public static JLabel rondas = new JLabel();
	public static JTextArea textArea = new JTextArea();
	public static JLabel acciones = new JLabel();

	public partida()  {
		SoftBevelBorder softBevelBorder = new SoftBevelBorder(SoftBevelBorder.LOWERED);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		ImageIcon iconoIcono = new ImageIcon("src\\img\\inGame\\icono.png");
		Image imagenIcono = iconoIcono.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
		ImageIcon imgFinalIcono = new ImageIcon(imagenIcono);

		ImageIcon personajes = new ImageIcon("src\\img\\inGame\\hitler.jpg");
		Image IconPersonaje = personajes.getImage().getScaledInstance(screen.height / 7, screen.height / 7,
				Image.SCALE_SMOOTH);
		ImageIcon personajeIcon = new ImageIcon(IconPersonaje);

		LineBorder borderRojo = new LineBorder(new Color(137, 5, 78), 3);

		// pabel principal
		JPanel game = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				// Dibuja la imagen de fondo
				ImageIcon iconoFondo = new ImageIcon("src\\img\\inGame\\mapa_acabado.png");
				Image imagenFondo = iconoFondo.getImage();
				g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
			}
		};
		game.setLayout(null);
		addButton(game, "San Francisco", 170, 250);
        addButton(game, "Chicago", 270, 220);
        addButton(game, "Atlanta", 320, 320);
        addButton(game, "Montreal", 350, 280);
        addButton(game, "Nueva York", 455, 260);
        addButton(game, "Washington", 450, 370);
        addButton(game, "Londres", 700, 230);
        addButton(game, "Madrid", 650, 345);
        addButton(game, "Paris", 740, 300);
        addButton(game, "Essen", 755, 190);
        addButton(game, "Milan", 805, 265);
        addButton(game, "San Petersburgo", 915, 180);
        addButton(game, "Los Angeles", 170, 370);
        addButton(game, "Miami", 370, 390);
        addButton(game, "Mexico DF", 290, 425);
        addButton(game, "Bogota", 400, 570);
        addButton(game, "Lima", 350, 650);
        addButton(game, "Santiago de Chile", 380, 750);
        addButton(game, "Buenos Aires", 483, 730);
        addButton(game, "Sao Paulo", 520, 680);
        addButton(game, "Lagos", 710, 530);
        addButton(game, "Kinsasa", 830, 540);
        addButton(game, "Jartum", 815, 620);
        addButton(game, "Johannesburgo", 815, 730);
        addButton(game, "Argel", 730, 430);
        addButton(game, "El Cairo", 820, 450);
        addButton(game, "Riad", 895, 485);
        addButton(game, "Estambul", 830, 345);
        addButton(game, "Bagdad", 920, 370);
        addButton(game, "Moscu", 925, 285);
        addButton(game, "Teheran", 1040, 280);
        addButton(game, "Karachi", 1010, 395);
        addButton(game, "Bombay", 1045, 505);
        addButton(game, "Nueva Delhi", 1125, 350);
        addButton(game, "Calcuta", 1195, 400);
        addButton(game, "Madras", 1085, 545);
        addButton(game, "Yakarta", 1200, 620);
        addButton(game, "Bangkok", 1200, 490);
        addButton(game, "Hong Kong", 1265, 450);
        addButton(game, "Shanghai", 1265, 340);
        addButton(game, "Pekin", 1265, 270);
        addButton(game, "Seul", 1375, 250);
        addButton(game, "Tokio", 1390, 315);
        addButton(game, "Osaka", 1430, 400);
        addButton(game, "Taipei", 1360, 430);
        addButton(game, "Ho Chi Minh", 1270, 580);
        addButton(game, "Manila", 1350, 560);
        addButton(game, "Sidney", 1350, 730);
		// panel izquierdo botones
		JPanel botonesTexto = new JPanel();
		botonesTexto.setLayout(new FlowLayout());
		botonesTexto.setOpaque(false);
		botonesTexto.setPreferredSize(new Dimension(screen.width, screen.height / 6));
		botonesTexto.setBorder(borderRojo);

		JPanel botonCurarFinalizar = new JPanel();
		botonCurarFinalizar.setOpaque(false);
		botonCurarFinalizar.setLayout(new GridLayout(2, 1, 10, 10));

		
		curar.setPreferredSize(new Dimension(150, 50));
		curar.setBackground(new Color(0, 0, 0, 0));
		curar.setOpaque(false);
		curar.setContentAreaFilled(false);
		curar.setBorderPainted(false);
		curar.setFocusPainted(false);
		curar.setFont(new Font("Arial", Font.BOLD, 10));
		curar.setForeground(new Color(137, 5, 78));

		finalizarRonda.setPreferredSize(new Dimension(150, 50));
		finalizarRonda.setBackground(new Color(0, 0, 0, 0));
		finalizarRonda.setOpaque(false);
		finalizarRonda.setContentAreaFilled(false);
		finalizarRonda.setBorderPainted(false);
		finalizarRonda.setFocusPainted(false);
		finalizarRonda.setFont(new Font("Arial", Font.BOLD, 10));
		finalizarRonda.setForeground(new Color(137, 5, 78));

		botonCurarFinalizar.add(curar);
		botonCurarFinalizar.add(finalizarRonda);

		botonesTexto.add(botonCurarFinalizar);

		JLabel personaje = new JLabel();
		personaje.setBorder(borderRojo);
		personaje.setIcon(personajeIcon);

		botonesTexto.add(personaje);

		textArea.setEditable(false); // No editable
		textArea.setPreferredSize(new Dimension(screen.width / 2, screen.height / 7));

		// Tipo de letra personalizado
		textArea.setFont(controlDatos.fuenteMC());

		// Color de fondo y texto
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setForeground(new Color(137, 5, 78));

		// Bordes personalizados
		Border border = BorderFactory.createLineBorder(Color.GRAY, 2);
		textArea.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(5, 5, 5, 5))); // Agrega
																														// un																											// píxeles

		// Espaciado interno
		textArea.setMargin(new Insets(5, 5, 5, 5)); // Ajusta el margen interno del JTextArea

		// Agrega el JTextArea a tu panel o contenedor

		// Redirigir la salida de la consola al JTextArea

		botonesTexto.add(textArea);

		JPanel DesarrollarCura = new JPanel();
		DesarrollarCura.setLayout(new GridLayout(2, 2, 10, 10));
		DesarrollarCura.setOpaque(false);

		DAlfa.setPreferredSize(new Dimension(150, 50));
		DAlfa.setBackground(new Color(0, 0, 0, 0));
		DAlfa.setOpaque(false);
		DAlfa.setContentAreaFilled(false);
		DAlfa.setBorderPainted(false);
		DAlfa.setFocusPainted(false);
		DAlfa.setFont(new Font("Arial", Font.BOLD, 10));
		DAlfa.setForeground(new Color(137, 5, 78));

		DBeta.setPreferredSize(new Dimension(150, 50));
		DBeta.setBackground(new Color(0, 0, 0, 0));
		DBeta.setOpaque(false);
		DBeta.setContentAreaFilled(false);
		DBeta.setBorderPainted(false);
		DBeta.setFocusPainted(false);
		DBeta.setFont(new Font("Arial", Font.BOLD, 10));
		DBeta.setForeground(new Color(137, 5, 78));

		DGamma.setPreferredSize(new Dimension(150, 50));
		DGamma.setBackground(new Color(0, 0, 0, 0));
		DGamma.setOpaque(false);
		DGamma.setContentAreaFilled(false);
		DGamma.setBorderPainted(false);
		DGamma.setFocusPainted(false);
		DGamma.setFont(new Font("Arial", Font.BOLD, 10));
		DGamma.setForeground(new Color(137, 5, 78));

		DDelta.setPreferredSize(new Dimension(150, 50));
		DDelta.setBackground(new Color(0, 0, 0, 0));
		DDelta.setOpaque(false);
		DDelta.setContentAreaFilled(false);
		DDelta.setBorderPainted(false);
		DDelta.setFocusPainted(false);
		DDelta.setFont(new Font("Arial", Font.BOLD, 10));
		DDelta.setForeground(new Color(137, 5, 78));

		DesarrollarCura.add(DAlfa);
		DesarrollarCura.add(DBeta);
		DesarrollarCura.add(DGamma);
		DesarrollarCura.add(DDelta);
		
		
		botonesTexto.add(DesarrollarCura);

		// panel derecha
		JPanel stats = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				// Dibuja la imagen de fondo
				ImageIcon iconoFondo = new ImageIcon("src\\img\\inGame\\fondoStats.png");
				Image imagenFondo = iconoFondo.getImage();
				g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
			}
		};
		stats.setPreferredSize(new Dimension(screen.width / 7, screen.height));
		stats.setLayout(new GridBagLayout());

		GridBagConstraints gbcStats = new GridBagConstraints();
		gbcStats.gridx = 0;
		gbcStats.gridy = 0;
		gbcStats.insets = new Insets(10, 10, 10, 10);

		JLabel score = new JLabel();
		score.setText("Puntos: 0"); // TODO METER VARIABLE DE SCORE
		score.setFont(new Font("Arial", Font.BOLD, 20));

		stats.add(score, gbcStats);

		gbcStats.gridy = 1;
		JLabel ciudadesInf = new JLabel();
		ciudadesInf.setText("Ciudades Infectadas: "); // TODO METER VARIABLE DE SCORE
		ciudadesInf.setFont(new Font("Arial", Font.BOLD, 15));

		stats.add(ciudadesInf, gbcStats);

		gbcStats.gridy = 2;
		JLabel brotes = new JLabel();
		brotes.setText("Brotes: 0"); // TODO METER VARIABLE DE SCORE
		brotes.setFont(new Font("Arial", Font.BOLD, 15));

		stats.add(brotes, gbcStats);

		gbcStats.gridy = 3;

		rondas.setFont(new Font("Arial", Font.BOLD, 15));

		stats.add(rondas, gbcStats);


		Alfa.setUI(new javax.swing.plaf.basic.BasicProgressBarUI() {
			protected Color getSelectionForeground() {
				return Color.black; // Cambia el color de la barra cuando progresa
			}
		});

		Alfa.setStringPainted(true); // Muestra el valor actual de la barra de progreso
		Alfa.setString("Progreso VIH = " + Alfa.getValue());
		Alfa.setMinimum(0); // Valor mínimo de la barra de progreso
		Alfa.setMaximum(100); // Valor máximo de la barra de progreso
		Alfa.setValue(0);
		Alfa.setBorder(softBevelBorder);

		gbcStats.gridy = 4;
		stats.add(Alfa, gbcStats);

		gbcStats.gridy = 5;
		Beta.setStringPainted(true); // Muestra el valor actual de la barra de progreso
		Beta.setString("Progreso CANCER = " + Beta.getValue());
		Beta.setMinimum(0); // Valor mínimo de la barra de progreso
		Beta.setMaximum(100); // Valor máximo de la barra de progreso
		Beta.setValue(0);
		Beta.setBorder(softBevelBorder);
		Beta.setUI(new javax.swing.plaf.basic.BasicProgressBarUI() {
			protected Color getSelectionForeground() {
				return Color.black; // Cambia el color de la barra cuando progresa
			}
		});

		stats.add(Beta, gbcStats);

		gbcStats.gridy = 6;
		Gamma.setStringPainted(true); // Muestra el valor actual de la barra de progreso
		Gamma.setString("Progreso SARS = " + Gamma.getValue());
		Gamma.setMinimum(0); // Valor mínimo de la barra de progreso
		Gamma.setMaximum(100); // Valor máximo de la barra de progreso
		Gamma.setValue(0);
		Gamma.setBorder(softBevelBorder);
		Gamma.setUI(new javax.swing.plaf.basic.BasicProgressBarUI() {
			protected Color getSelectionForeground() {
				return Color.black; // Cambia el color de la barra cuando progresa
			}
		});

		stats.add(Gamma, gbcStats);

		gbcStats.gridy = 7;
		Delta.setStringPainted(true); // Muestra el valor actual de la barra de progreso
		Delta.setString("Progreso NIGGA = " + Delta.getValue());
		Delta.setMinimum(0); // Valor mínimo de la barra de progreso
		Delta.setMaximum(100); // Valor máximo de la barra de progreso
		Delta.setValue(0);
		Delta.setBorder(softBevelBorder);
		Delta.setUI(new javax.swing.plaf.basic.BasicProgressBarUI() {
			protected Color getSelectionForeground() {
				return Color.black; // Cambia el color de la barra cuando progresa
			}
		});

		stats.add(Delta, gbcStats);

		gbcStats.gridy = 8;

		acciones.setText("Acciones : 4");

		stats.add(acciones, gbcStats);

		gbcStats.gridy = 9;
		JButton opciones = new JButton("OPCIONES");
		opciones.setPreferredSize(new Dimension(150, 50));
		opciones.setBackground(new Color(0, 0, 0, 0));
		opciones.setOpaque(false);
		opciones.setContentAreaFilled(false);
		opciones.setBorderPainted(false);
		opciones.setFocusPainted(false);
		opciones.setFont(new Font("Arial", Font.BOLD, 20));
		opciones.setForeground(new Color(137, 5, 78));

		JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setPreferredSize(new Dimension(screen.width / 6, screen.height / 4));
		popupMenu.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		popupMenu.setLayout(new FlowLayout());

		JMenuItem menuItem1 = new JMenuItem("Opción 1");
		
		menuItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Adios");
			}
		});
		
		JMenuItem menuItem2 = new JMenuItem("Opción 2");
		JMenuItem menuItem3 = new JMenuItem("Opción 3");

		menuItem1.setBackground(new Color(137, 5, 78));

		menuItem2.setBackground(new Color(137, 5, 78));

		menuItem3.setBackground(new Color(137, 5, 78));

		popupMenu.add(menuItem1);
		popupMenu.add(menuItem2);
		popupMenu.add(menuItem3);

		opciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				popupMenu.show(CargarParty.iniciarPartida, (screen.width - screen.width / 6) / 2,
						(screen.height - screen.height / 4) / 2);
			}
		});
		
		
		stats.add(opciones, gbcStats);


		opciones.addActionListener(new ActionListener() { 
			
			public void actionPerformed(ActionEvent e) {
				// menu para guardar partida
			}
		});

		PrintStream printStream = new PrintStream(new OutputStream() {
			@Override
			public void write(int b) throws IOException {
				new Thread(() -> {
					textArea.append(String.valueOf((char) b));
					int lineCount = textArea.getLineCount();
					if (lineCount > 7) {
						try {
							int endOfFirstLine = textArea.getLineEndOffset(0);
							textArea.replaceRange("", 0, endOfFirstLine);
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
					textArea.setCaretPosition(textArea.getDocument().getLength());
				}).start();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		System.setOut(printStream);
		System.setErr(printStream);
		
		
		DAlfa.addActionListener(this);
		DBeta.addActionListener(this);
		DGamma.addActionListener(this);
		DDelta.addActionListener(this);
		finalizarRonda.addActionListener(this);
		curar.addActionListener(this);
		
		this.add(game, BorderLayout.CENTER);
		this.add(stats, BorderLayout.EAST);
		this.add(botonesTexto, BorderLayout.SOUTH);
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
	

	@Override
	public void actionPerformed(ActionEvent e) {
	    Object source = e.getSource(); // Obtiene el objeto que generó el evento

	    if (source == DAlfa) {
	        Thread vac = new Thread(new Runnable() {
				
				@Override
				public void run() {
					controlPartida.gestionar_Vacuna(0);
					
				}
	        });
	        vac.start();
	    } else if (source == DBeta) {
	    	Thread vac = new Thread(new Runnable() {
				
				@Override
				public void run() {
					controlPartida.gestionar_Vacuna(1);
					
				}
	        });
	        vac.start();
	        
	        
	    } else if (source == DGamma) {
	    	Thread vac = new Thread(new Runnable() {
				
				@Override
				public void run() {
					controlPartida.gestionar_Vacuna(2);
					
				}
	        });
	        vac.start();

	    } else if (source == DDelta) {
	    	Thread vac = new Thread(new Runnable() {
				
				@Override
				public void run() {
					controlPartida.gestionar_Vacuna(3);
					
				}
	        });
	        vac.start();

	    } else if (source == finalizarRonda) {
	        controlPartida.gestionar_Turno();
	    } else if (source == curar) {
	    	controlPartida.gestionar_Cura(1);
	    } else {
	        System.out.println("Se presionó un botón no identificado");
	    }
	}

	private void addButton(Container container, String nombre, int x, int y) {
        JButton button = new JButton(nombre);
        button.setBounds(x, y, 100, 30); // Establecer el tamaño del botón
        container.add(button);
    }

}
