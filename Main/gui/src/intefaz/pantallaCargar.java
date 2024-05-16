package intefaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import CargaDatos.controlDatos;
import controladores.controlPartida;
import inicio.Main;
import oracle.net.jdbc.TNSAddress.AddressList;

public class pantallaCargar extends JFrame implements ActionListener {

	public static JButton play;
	public static JButton playNor;
	public static JButton playDif;

	public static JButton eliminar;
	public static JButton eliminarNor;
	public static JButton eliminarDif;
	
	public static JScrollPane scrollNor = new JScrollPane();
	public static JScrollPane scroll = new JScrollPane();
	public static JScrollPane scrollDif = new JScrollPane();
	
	public static JPanel dificultadEz;
	public static JPanel dificultadNormal;
	public static JPanel dificultadDif;
	
	public static GridBagConstraints gbcEasyAbajo = new GridBagConstraints();
	public static GridBagConstraints gbcPartidasNor = new GridBagConstraints();
	public static GridBagConstraints gbcpartidasDif = new GridBagConstraints();
	
	public static JPanel Partidas = new JPanel();
	public static JPanel PartidasNormal = new JPanel();
	public static JPanel PartidasDificil = new JPanel();
	
	public pantallaCargar() {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		JPanel panelgeneral = new JPanel(new GridBagLayout()) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				// Dibuja la imagen de fondo
				ImageIcon iconoFondo = new ImageIcon("src\\img\\nuevaPartida\\fondo.jpg");
				Image imagenFondo = iconoFondo.getImage();
				g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
			}
		};
		double widthScreen = screen.width / 3.07;

		ImageIcon mundoFacil = new ImageIcon("src\\img\\nuevaPartida\\facil.gif"); // 115 px y 300fps
		Image mundoFaciles = mundoFacil.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
		ImageIcon facil = new ImageIcon(mundoFaciles);

		ImageIcon mundoNormal = new ImageIcon("src\\img\\nuevaPartida\\normal.gif");
		Image mundoNormales = mundoNormal.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
		ImageIcon normal = new ImageIcon(mundoNormales);

		ImageIcon mundoDificil = new ImageIcon("src\\img\\nuevaPartida\\dificil.gif");
		Image mundoDificiles = mundoDificil.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
		ImageIcon dificil = new ImageIcon(mundoDificiles);

		ImageIcon imgFacil = new ImageIcon("src\\img\\nuevaPartida\\imgFacil.png"); // 115 px y 300fps
		Image imgEs = imgFacil.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		ImageIcon mundoimgFacil = new ImageIcon(imgEs);

		ImageIcon imgNormal = new ImageIcon("src\\img\\nuevaPartida\\imgNormal.png"); // 115 px y 300fps
		Image imgNormales = imgNormal.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		ImageIcon mundoimgNormal = new ImageIcon(imgNormales);

		ImageIcon imgDificil = new ImageIcon("src\\img\\nuevaPartida\\imgDificil.png"); // 115 px y 300fps
		Image imgdificiles = imgDificil.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		ImageIcon mundoimgdificil = new ImageIcon(imgdificiles);

		ImageIcon imgNormalOP = new ImageIcon("src\\img\\nuevaPartida\\imgNormalOP.png"); // 115 px y 300fps
		Image imgNormalesOP = imgNormalOP.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		ImageIcon mundoimgNormalOP = new ImageIcon(imgNormalesOP);

		ImageIcon imgDificilOP = new ImageIcon("src\\img\\nuevaPartida\\imgDificilOP.png"); // 115 px y 300fps
		Image imgdificilesOP = imgDificilOP.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		ImageIcon mundoimgdificilOP = new ImageIcon(imgdificilesOP);

		ImageIcon iconoIcono = new ImageIcon("src\\img\\main\\icono.png");
		Image imagenIcono = iconoIcono.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
		ImageIcon imgFinalIcono = new ImageIcon(imagenIcono);

		JPanel easyGeneral = new JPanel(new GridBagLayout()) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				// Dibuja la imagen de fondo
				ImageIcon iconoFondo = new ImageIcon("src\\img\\nuevaPartida\\marcoFacil.jpg");
				Image imagenFondo = iconoFondo.getImage();
				g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
			}
		};
		easyGeneral.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, false));
		easyGeneral.setPreferredSize(new Dimension((int) widthScreen, screen.height - 70));
		easyGeneral.setOpaque(false);

		GridBagConstraints gbcEasy = new GridBagConstraints();

		gbcEasy.gridx = 0;
		gbcEasy.gridy = 0;

		Dimension mundo = new Dimension(275, 275);
		// agregar mundo
		JPanel mundoEz = new JPanel();
		mundoEz.setOpaque(false);
		mundoEz.setPreferredSize(mundo);
		JLabel mundoIcon = new JLabel(facil);
		mundoEz.add(mundoIcon);

		easyGeneral.add(mundoEz, gbcEasy);

		gbcEasy.gridy = 1;
		gbcEasy.gridheight = 2;
		gbcEasy.weighty = 1.0;
		gbcEasy.fill = GridBagConstraints.VERTICAL;

		dificultadEz = new JPanel(new GridBagLayout()) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setColor(new Color(0, 0, 0, 128));
				g2d.fillRect(0, 0, getWidth(), getHeight());
				g2d.dispose();
			}
		};

		

		gbcEasyAbajo.gridx = 0;
		gbcEasyAbajo.gridy = 0;

		dificultadEz.setPreferredSize(new Dimension((int) widthScreen - 4, 250));
		dificultadEz.setOpaque(false);
		dificultadEz.setBorder(new EtchedBorder(EtchedBorder.RAISED));

		JPanel dificultad = new JPanel(new FlowLayout());
		dificultad.setOpaque(false);

		JLabel dificultadIm = new JLabel("Dificultad -");
		dificultadIm.setFont(controlDatos.fuentecargar(45f));
		dificultadIm.setForeground(Color.LIGHT_GRAY);
		dificultad.add(dificultadIm);

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
		textofacil.setFont(controlDatos.fuenteTexto(15f));
		textofacil.setText("Partidas del Modo - ");
		descFacil.add(textofacil);

		JLabel textofacil2 = new JLabel();
		textofacil2.setForeground(new Color(79, 240, 100));
		textofacil2.setFont(controlDatos.fuenteTexto(15f));
		textofacil2.setText("Chupetes");

		descFacil.add(textofacil2);

		dificultadEz.add(descFacil, gbcEasyAbajo);

		gbcEasyAbajo.gridy = 2;
		gbcEasyAbajo.insets = new Insets(10, 10, 10, 10);
		
		
		GridBagConstraints gbcScroll = new GridBagConstraints();

		gbcScroll.gridx = 0;
		gbcScroll.gridy = 2; // o la posición que desees
		gbcScroll.weightx = 1.0;
		gbcScroll.weighty = 1.0;
		gbcScroll.fill = GridBagConstraints.BOTH;
		
		dificultadEz.add(scroll, gbcScroll);

		easyGeneral.add(dificultadEz, gbcEasy);

		// PANEL NORMAL
		JPanel normalGeneral = new JPanel(new GridBagLayout()) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				// Dibuja la imagen de fondo
				ImageIcon iconoFondo = new ImageIcon("src\\img\\nuevaPartida\\marcoNormal.jpeg");
				Image imagenFondo = iconoFondo.getImage();
				g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
			}
		};
		normalGeneral.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, false));
		normalGeneral.setPreferredSize(new Dimension((int) widthScreen, screen.height - 70));
		normalGeneral.setOpaque(false);

		GridBagConstraints gbcNormal = new GridBagConstraints();

		gbcNormal.gridx = 0;
		gbcNormal.gridy = 0;

		// agregar mundo
		JPanel mundoNor = new JPanel();
		mundoNor.setOpaque(false);
		mundoNor.setPreferredSize(mundo);
		JLabel normalIcon = new JLabel(normal);
		mundoNor.add(normalIcon);

		normalGeneral.add(mundoNor, gbcNormal);

		gbcNormal.gridy = 1;
		gbcNormal.gridheight = 2;
		gbcNormal.weighty = 1.0;
		gbcNormal.fill = GridBagConstraints.VERTICAL;

		dificultadNormal = new JPanel(new GridBagLayout()) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setColor(new Color(0, 0, 0, 128));
				g2d.fillRect(0, 0, getWidth(), getHeight());
				g2d.dispose();
			}
		};

		GridBagConstraints gbcNormalAbajo = new GridBagConstraints();

		gbcNormalAbajo.gridx = 0;
		gbcNormalAbajo.gridy = 0;

		dificultadNormal.setPreferredSize(new Dimension((int) widthScreen - 4, 250));
		dificultadNormal.setOpaque(false);
		dificultadNormal.setBorder(new EtchedBorder(EtchedBorder.RAISED));

		JPanel dificultad2 = new JPanel(new FlowLayout());
		dificultad2.setOpaque(false);

		JLabel dificultadIm2 = new JLabel("Dificultad - ");
		dificultadIm2.setFont(controlDatos.fuentecargar(45f));
		dificultadIm2.setForeground(Color.LIGHT_GRAY);
		dificultad2.add(dificultadIm2);

		JLabel mundoF2 = new JLabel(mundoimgFacil);
		dificultad2.add(mundoF2);

		JLabel mundoN2 = new JLabel(mundoimgNormal);
		dificultad2.add(mundoN2);

		JLabel mundoD2 = new JLabel(mundoimgdificilOP);
		dificultad2.add(mundoD2);

		dificultadNormal.add(dificultad2, gbcNormalAbajo);

		gbcNormalAbajo.gridy = 1;

		JPanel descNormal = new JPanel(new FlowLayout());
		descNormal.setOpaque(false);

		JLabel textonormal = new JLabel();
		textonormal.setForeground(Color.white);
		textonormal.setFont(controlDatos.fuenteTexto(15f));
		textonormal.setText("Partidas del Modo - ");
		descNormal.add(textonormal);

		JLabel textonormal2 = new JLabel();
		textonormal2.setForeground(new Color(173, 216, 240));
		textonormal2.setFont(controlDatos.fuenteTexto(15f));
		textonormal2.setText("Normal");

		descNormal.add(textonormal2);

		dificultadNormal.add(descNormal, gbcNormalAbajo);

		gbcNormalAbajo.gridy = 2;
		gbcNormalAbajo.insets = new Insets(10, 10, 10, 10);

		

		gbcPartidasNor.gridx = 0;
		gbcPartidasNor.gridy = 0;

		

		

		JViewport viewport2 = scrollNor.getViewport();
		viewport2.setOpaque(false);

		dificultadNormal.add(scrollNor, gbcScroll);

		normalGeneral.add(dificultadNormal, gbcNormal);

		JPanel dificilGeneral = new JPanel(new GridBagLayout()) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				// Dibuja la imagen de fondo
				ImageIcon iconoFondo = new ImageIcon("src\\img\\nuevaPartida\\marcoDificil.jpeg");
				Image imagenFondo = iconoFondo.getImage();
				g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
			}
		};
		dificilGeneral.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, false));
		dificilGeneral.setPreferredSize(new Dimension((int) widthScreen, screen.height - 70));
		dificilGeneral.setOpaque(false);

		GridBagConstraints gbcDificil = new GridBagConstraints();

		gbcDificil.gridx = 0;
		gbcDificil.gridy = 0;

		// agregar mundo
		JPanel mundoDif = new JPanel();
		mundoDif.setOpaque(false);
		mundoDif.setPreferredSize(mundo);
		JLabel mundoIcon3 = new JLabel(dificil);
		mundoDif.add(mundoIcon3);

		dificilGeneral.add(mundoDif, gbcDificil);

		gbcDificil.gridy = 1;
		gbcDificil.gridheight = 2;
		gbcDificil.weighty = 1.0;
		gbcDificil.fill = GridBagConstraints.VERTICAL;

		dificultadDif = new JPanel(new GridBagLayout()) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setColor(new Color(0, 0, 0, 128));
				g2d.fillRect(0, 0, getWidth(), getHeight());
				g2d.dispose();
			}
		};

		GridBagConstraints gbcDificilAbajo = new GridBagConstraints();

		gbcDificilAbajo.gridx = 0;
		gbcDificilAbajo.gridy = 0;

		dificultadDif.setPreferredSize(new Dimension((int) widthScreen - 4, 250));
		dificultadDif.setOpaque(false);
		dificultadDif.setBorder(new EtchedBorder(EtchedBorder.RAISED));

		JPanel dificultad3 = new JPanel(new FlowLayout());
		dificultad3.setOpaque(false);

		JLabel dificultadIm3 = new JLabel("Dificultad - ");
		dificultadIm3.setFont(controlDatos.fuentecargar(45f));
		dificultadIm3.setForeground(Color.LIGHT_GRAY);
		dificultad3.add(dificultadIm3);

		JLabel mundoF3 = new JLabel(mundoimgFacil);
		dificultad3.add(mundoF3);

		JLabel mundoN3 = new JLabel(mundoimgNormal);
		dificultad3.add(mundoN3);

		JLabel mundoD3 = new JLabel(mundoimgdificil);
		dificultad3.add(mundoD3);

		dificultadDif.add(dificultad3, gbcDificilAbajo);

		gbcDificilAbajo.gridy = 1;

		JPanel descDificil = new JPanel(new FlowLayout());
		descDificil.setOpaque(false);

		JLabel textoDificil = new JLabel();
		textoDificil.setForeground(Color.white);
		textoDificil.setFont(controlDatos.fuenteTexto(15f));
		textoDificil.setText("Partidas del Modo - ");
		descDificil.add(textoDificil);

		JLabel textoDificil2 = new JLabel();
		textoDificil2.setForeground(new Color(230, 70, 79));
		textoDificil2.setFont(controlDatos.fuenteTexto(15f));
		textoDificil2.setText("Crisis");

		descDificil.add(textoDificil2);

		dificultadDif.add(descDificil, gbcDificilAbajo);

		gbcDificilAbajo.gridy = 2;
		gbcDificilAbajo.insets = new Insets(10, 10, 10, 10);

		
		

		gbcpartidasDif.gridx = 0;
		gbcpartidasDif.gridy = 0;

		

		

		dificultadDif.add(scrollDif, gbcScroll);

		dificilGeneral.add(dificultadDif, gbcDificil);

		JButton volver = new JButton("VOLVER");
		volver.setBackground(new Color(0, 0, 0, 0));
		volver.setOpaque(false);
		volver.setContentAreaFilled(false);
		volver.setBorderPainted(false);
		volver.setFocusPainted(false);
		volver.setFont(new Font("Arial", Font.BOLD, 20));
		volver.setForeground(new Color(137, 5, 78));
		volver.setPreferredSize(new Dimension(screen.width, 50));
		volver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				volver.setForeground(new Color(200, 5, 78));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				volver.setForeground(new Color(137, 5, 78));
			}
		});
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.cargarPrincipal.setVisible(true);
				Timer timer = new Timer(300, new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Main.partidas.setVisible(false);
					}
				});
				timer.setRepeats(false);
				timer.start();
			}
		});

		GridBagConstraints gbcGeneral = new GridBagConstraints();
		gbcGeneral.gridx = 0;
		gbcGeneral.insets = new Insets(2, 2, 2, 2);

		panelgeneral.add(easyGeneral, gbcGeneral);

		gbcGeneral.gridx = 1;
		panelgeneral.add(normalGeneral, gbcGeneral);

		gbcGeneral.gridx = 2;
		panelgeneral.add(dificilGeneral, gbcGeneral);

		JPanel botonVolver = new JPanel();
		botonVolver.setBackground(Color.black);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		//TODO ERROR VACUNA, ERROR CIUDADES INFECTADAS, IMAGENES CIUDADES INFECTADAS, datos todavia no creado 	
		JButton botonPresionado = (JButton) e.getSource();

		String nombreBoton = botonPresionado.getName();

		int idp = controlDatos.selectIDPartida(nombreBoton);
		
		System.out.println(idp);
		
		controlDatos.controlDificultad(controlDatos.dificultad);
		
		controlPartida.iniciar_Partida_Guardada();
		
		controlDatos.selectPartida(idp, controlDatos.con);
		
		controlPartida.actualizarGuiPartidaCargado();
		
		Main.partidas.setVisible(false);
		CargarParty.game.setVisible(true);
		
		
		
	}

}
