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
import inicio.Main;
import oracle.net.jdbc.TNSAddress.AddressList;

public class pantallaCargar extends JFrame implements ActionListener {

	public static JButton play;
	public static JButton playNor;
	public static JButton playDif;

	public static JButton eliminar;
	public static JButton eliminarNor;
	public static JButton eliminarDif;
	
	public static ArrayList<String[]> info = new ArrayList<>(controlDatos.mostrarInfoCargar(0));
	public static ArrayList<String[]> infoNor = new ArrayList<>(controlDatos.mostrarInfoCargar(1));
	public static ArrayList<String[]> infoDif = new ArrayList<>(controlDatos.mostrarInfoCargar(2));
	
	public static JScrollPane scrollNor = new JScrollPane();
	public static JScrollPane scroll = new JScrollPane();
	public static JScrollPane scrollDif = new JScrollPane();
	
	public static JPanel Partidas;
	
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

		ImageIcon botonPlay = new ImageIcon("src\\img\\partidasGuardadas\\botonPlay.png");
		Image botonPlayES = botonPlay.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon botonPlayFin = new ImageIcon(botonPlayES);

		ImageIcon botonPlayOP = new ImageIcon("src\\img\\partidasGuardadas\\botonPlayOP.png");
		Image botonPlayESOP = botonPlayOP.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon botonPlayFinOP = new ImageIcon(botonPlayESOP);

		ImageIcon botonEliminar = new ImageIcon("src\\img\\partidasGuardadas\\botonEliminar.png");
		Image botonEliminarES = botonEliminar.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon botonEliminarFIN = new ImageIcon(botonEliminarES);

		ImageIcon botonEliminarOP = new ImageIcon("src\\img\\partidasGuardadas\\botonEliminarOP.png");
		Image botonEliminarOPES = botonEliminarOP.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon botonEliminarFINOP = new ImageIcon(botonEliminarOPES);

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

		JPanel dificultadEz = new JPanel(new GridBagLayout()) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setColor(new Color(0, 0, 0, 128));
				g2d.fillRect(0, 0, getWidth(), getHeight());
				g2d.dispose();
			}
		};

		GridBagConstraints gbcEasyAbajo = new GridBagConstraints();

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

		Partidas = new JPanel(new GridBagLayout()) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setColor(new Color(0, 0, 0, 0));
				g2d.fillRect(0, 0, getWidth(), getHeight());
				g2d.dispose();
			}
		};
		Partidas.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		Partidas.setOpaque(false);
		GridBagConstraints gbcpartidas = new GridBagConstraints();

		gbcpartidas.gridx = 0;
		gbcpartidas.gridy = 0;

		

		for (int i = 0; i < info.size(); i++) {

			JPanel partidaPanel = new JPanel(new GridBagLayout()) {
				@Override
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					Graphics2D g2d = (Graphics2D) g.create();
					g2d.setColor(new Color(0, 51, 102, 128));
					g2d.fillRect(0, 0, getWidth(), getHeight());
					g2d.dispose();
				}
			};
			partidaPanel.setPreferredSize(new Dimension(375, 100));
			partidaPanel.setOpaque(false);
			partidaPanel.setBorder(new LineBorder(Color.LIGHT_GRAY));

			GridBagConstraints gbcPartidaPanel = new GridBagConstraints();

			gbcPartidaPanel.gridx = 0;
			gbcPartidaPanel.gridy = 0;
			gbcPartidaPanel.weighty = 1.0;
			gbcPartidaPanel.gridheight = 4;
			gbcPartidaPanel.fill = GridBagConstraints.VERTICAL;

			eliminar = new JButton(botonEliminarFIN);
			eliminar.setName("XEZ " + i);
			eliminar.setContentAreaFilled(false);
			eliminar.setFocusPainted(false);
			eliminar.setBorderPainted(false);

			eliminar.addActionListener(this);

			partidaPanel.add(eliminar, gbcPartidaPanel);

			final JButton eliminarFinal = eliminar;
			
			eliminar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					eliminarFinal.setIcon(botonEliminarFINOP);
					partidaPanel.setBorder(new LineBorder(Color.pink, 2));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					eliminarFinal.setIcon(botonEliminarFIN);
					partidaPanel.setBorder(new LineBorder(Color.lightGray, 2));
				}
			});

			gbcPartidaPanel.weighty = 0.0;
			gbcPartidaPanel.gridheight = 1;
			gbcPartidaPanel.fill = GridBagConstraints.NONE;

			for (int j = 0; j < info.get(i).length + 1; j++) {

				switch (j) {
				case 0:
					JPanel usuarioPanel = new JPanel(new FlowLayout());
					usuarioPanel.setOpaque(false);

					JLabel jugador = new JLabel("Jugador: ");
					jugador.setFont(controlDatos.fuenteMC(15f));
					jugador.setForeground(Color.white);

					JLabel username = new JLabel("" + info.get(i)[j].toUpperCase());
					username.setFont(controlDatos.fuenteMC(15f));
					username.setForeground(new Color(79, 240, 100));

					usuarioPanel.add(jugador);
					usuarioPanel.add(username);
					gbcPartidaPanel.gridy = 0;
					gbcPartidaPanel.gridx = 1;
					partidaPanel.add(usuarioPanel, gbcPartidaPanel);
					break;
				case 1:
					JPanel rondasPanel = new JPanel(new FlowLayout());
					rondasPanel.setOpaque(false);

					JLabel rondas = new JLabel("N. Ronda: ");
					rondas.setFont(controlDatos.fuenteMC(12f));
					rondas.setForeground(Color.lightGray);

					int rondasNum = Integer.valueOf(info.get(i)[j]);
					JLabel num = new JLabel("" + rondasNum);
					num.setFont(controlDatos.fuenteMC(12f));
					num.setForeground(Color.lightGray);

					rondasPanel.add(rondas);
					rondasPanel.add(num);

					gbcPartidaPanel.gridy = 1;
					gbcPartidaPanel.gridx = 1;
					partidaPanel.add(rondasPanel, gbcPartidaPanel);
					break;
				case 2:
					int puntuacionNum = Integer.valueOf(info.get(i)[j]);
					JLabel puntuacion = new JLabel("Puntos: " + puntuacionNum);
					puntuacion.setFont(controlDatos.fuenteMC(12f));
					puntuacion.setForeground(Color.lightGray);
					gbcPartidaPanel.gridy = 2;
					gbcPartidaPanel.gridx = 1;
					partidaPanel.add(puntuacion, gbcPartidaPanel);
					break;
				case 3:
					JLabel dia = new JLabel("Ult. Jugado: (" + info.get(i)[j] + ")");
					dia.setFont(controlDatos.fuenteMC(10f));
					dia.setForeground(Color.lightGray);
					gbcPartidaPanel.gridy = 3;
					gbcPartidaPanel.gridx = 1;
					partidaPanel.add(dia, gbcPartidaPanel);
					break;
				}

			}

			gbcPartidaPanel.gridx = 2;
			gbcPartidaPanel.gridy = 0;
			gbcPartidaPanel.weighty = 1.0;
			gbcPartidaPanel.gridheight = 4;
			gbcPartidaPanel.fill = GridBagConstraints.VERTICAL;

			play = new JButton(botonPlayFin);
			play.setName("EZ " + i);
			play.setContentAreaFilled(false);
			play.setFocusPainted(false);
			play.setBorderPainted(false);

			play.addActionListener(this);

			partidaPanel.add(play, gbcPartidaPanel);

			final JButton playFinal = play;
			
			play.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					playFinal.setIcon(botonPlayFinOP);
					partidaPanel.setBorder(new LineBorder(Color.green, 2));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					playFinal.setIcon(botonPlayFin);
					partidaPanel.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
				}
			});

			gbcPartidaPanel.weighty = 0.0;
			gbcPartidaPanel.gridheight = 1;
			gbcPartidaPanel.fill = GridBagConstraints.NONE;

			gbcpartidas.insets = new Insets(10, 10, 10, 10);

			Partidas.add(partidaPanel, gbcpartidas);
			gbcpartidas.gridy++;
		}

		scroll.setOpaque(false);

		

		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		JViewport viewport = scroll.getViewport();
		viewport.setOpaque(false);

		GridBagConstraints gbcScroll = new GridBagConstraints();

		gbcScroll.gridx = 0;
		gbcScroll.gridy = 2; // o la posición que desees
		gbcScroll.weightx = 1.0;
		gbcScroll.weighty = 1.0;
		gbcScroll.fill = GridBagConstraints.BOTH;
		
		
		if (info.size() == 0) {
			JPanel noGameEz = new JPanel() {
				@Override
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					Graphics2D g2d = (Graphics2D) g.create();
					g2d.setColor(new Color(0, 0, 0, 0));
					g2d.fillRect(0, 0, getWidth(), getHeight());
					g2d.dispose();
				}
			};
			noGameEz.setPreferredSize(new Dimension(300, 75));
			noGameEz.setOpaque(false);
			noGameEz.setBorder(new LineBorder(Color.LIGHT_GRAY));

			JLabel noGameText = new JLabel("NO HAY PARTIDAS GUARDADAS");
			noGameText.setVerticalAlignment(JLabel.CENTER);
			noGameText.setHorizontalAlignment(JLabel.CENTER);
			noGameText.setFont(controlDatos.fuentecargar(30f));
			noGameText.setForeground(Color.white);

			noGameEz.add(noGameText);

			scroll.setViewportView(noGameEz);
		} else {
			scroll.setViewportView(Partidas);
		}
		
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

		JPanel dificultadNormal = new JPanel(new GridBagLayout()) {
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

		JPanel PartidasNormal = new JPanel(new GridBagLayout()) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setColor(new Color(0, 0, 0, 0));
				g2d.fillRect(0, 0, getWidth(), getHeight());
				g2d.dispose();
			}
		};
		PartidasNormal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		PartidasNormal.setOpaque(false);
		GridBagConstraints gbcPartidasNor = new GridBagConstraints();

		gbcPartidasNor.gridx = 0;
		gbcPartidasNor.gridy = 0;

		

		for (int i = 0; i < infoNor.size(); i++) {

			JPanel partidaPanel = new JPanel(new GridBagLayout()) {
				@Override
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					Graphics2D g2d = (Graphics2D) g.create();
					g2d.setColor(new Color(0, 51, 102, 128));
					g2d.fillRect(0, 0, getWidth(), getHeight());
					g2d.dispose();
				}
			};
			partidaPanel.setPreferredSize(new Dimension(375, 100));
			partidaPanel.setOpaque(false);
			partidaPanel.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));

			GridBagConstraints gbcPartidaPanel = new GridBagConstraints();

			gbcPartidaPanel.gridx = 0;
			gbcPartidaPanel.gridy = 0;
			gbcPartidaPanel.weighty = 1.0;
			gbcPartidaPanel.gridheight = 4;
			gbcPartidaPanel.fill = GridBagConstraints.VERTICAL;

			eliminarNor = new JButton(botonEliminarFIN);
			eliminarNor.setName("XNOR " + i);
			eliminarNor.setContentAreaFilled(false);
			eliminarNor.setFocusPainted(false);
			eliminarNor.setBorderPainted(false);

			eliminarNor.addActionListener(this);

			partidaPanel.add(eliminarNor, gbcPartidaPanel);
			
			final JButton eliminarNorFinal = eliminarNor;
			
			eliminarNor.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					eliminarNorFinal.setIcon(botonEliminarFINOP);
					partidaPanel.setBorder(new LineBorder(Color.pink, 2));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					eliminarNorFinal.setIcon(botonEliminarFIN);
					partidaPanel.setBorder(new LineBorder(Color.lightGray, 2));
				}
			});

			eliminarNor.addActionListener(this);

			gbcPartidaPanel.weighty = 0.0;
			gbcPartidaPanel.gridheight = 1;
			gbcPartidaPanel.fill = GridBagConstraints.NONE;

			for (int j = 0; j < infoNor.get(i).length + 1; j++) {

				switch (j) {
				case 0:
					JPanel usuarioPanel = new JPanel(new FlowLayout());
					usuarioPanel.setOpaque(false);

					JLabel jugador = new JLabel("Jugador: ");
					jugador.setFont(controlDatos.fuenteMC(15f));
					jugador.setForeground(Color.white);

					JLabel username = new JLabel("" + infoNor.get(i)[j].toUpperCase());
					username.setFont(controlDatos.fuenteMC(15f));
					username.setForeground(new Color(79, 240, 100));

					usuarioPanel.add(jugador);
					usuarioPanel.add(username);
					gbcPartidaPanel.gridy = 0;
					gbcPartidaPanel.gridx = 1;
					partidaPanel.add(usuarioPanel, gbcPartidaPanel);
					break;
				case 1:
					JPanel rondasPanel = new JPanel(new FlowLayout());
					rondasPanel.setOpaque(false);

					JLabel rondas = new JLabel("N. Ronda: ");
					rondas.setFont(controlDatos.fuenteMC(12f));
					rondas.setForeground(Color.lightGray);

					int rondasNum = Integer.valueOf(infoNor.get(i)[j]);
					JLabel num = new JLabel("" + rondasNum);
					num.setFont(controlDatos.fuenteMC(12f));
					num.setForeground(Color.lightGray);

					rondasPanel.add(rondas);
					rondasPanel.add(num);

					gbcPartidaPanel.gridy = 1;
					gbcPartidaPanel.gridx = 1;
					partidaPanel.add(rondasPanel, gbcPartidaPanel);
					break;
				case 2:
					int puntuacionNum = Integer.valueOf(infoNor.get(i)[j]);
					JLabel puntuacion = new JLabel("Puntos: " + puntuacionNum);
					puntuacion.setFont(controlDatos.fuenteMC(12f));
					puntuacion.setForeground(Color.lightGray);
					gbcPartidaPanel.gridy = 2;
					gbcPartidaPanel.gridx = 1;
					partidaPanel.add(puntuacion, gbcPartidaPanel);
					break;
				case 3:
					JLabel dia = new JLabel("Ult. Jugado: (" + infoNor.get(i)[j] + ")");
					dia.setFont(controlDatos.fuenteMC(10f));
					dia.setForeground(Color.lightGray);
					gbcPartidaPanel.gridy = 3;
					gbcPartidaPanel.gridx = 1;
					partidaPanel.add(dia, gbcPartidaPanel);
					break;
				}

			}

			gbcPartidaPanel.gridx = 2;
			gbcPartidaPanel.gridy = 0;
			gbcPartidaPanel.weighty = 1.0;
			gbcPartidaPanel.gridheight = 4;
			gbcPartidaPanel.fill = GridBagConstraints.VERTICAL;

			playNor = new JButton(botonPlayFin);
			playNor.setName("NOR " + i);
			playNor.setContentAreaFilled(false);
			playNor.setFocusPainted(false);
			playNor.setBorderPainted(false);

			playNor.addActionListener(this);

			partidaPanel.add(playNor, gbcPartidaPanel);
			
			final JButton playNorFinal = playNor;
			
			playNor.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					playNorFinal.setIcon(botonPlayFinOP);
					partidaPanel.setBorder(new LineBorder(Color.green, 2));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					playNorFinal.setIcon(botonPlayFin);
					partidaPanel.setBorder(new LineBorder(Color.lightGray, 2));
				}
			});

			gbcPartidaPanel.weighty = 0.0;
			gbcPartidaPanel.gridheight = 1;
			gbcPartidaPanel.fill = GridBagConstraints.NONE;

			gbcPartidasNor.insets = new Insets(10, 10, 10, 10);

			PartidasNormal.add(partidaPanel, gbcPartidasNor);
			gbcPartidasNor.gridy++;
		}

		scrollNor.setOpaque(false);

		if (infoNor.size() == 0) {
			JPanel noGameEz = new JPanel() {
				@Override
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					Graphics2D g2d = (Graphics2D) g.create();
					g2d.setColor(new Color(0, 0, 0, 0));
					g2d.fillRect(0, 0, getWidth(), getHeight());
					g2d.dispose();
				}
			};
			noGameEz.setPreferredSize(new Dimension(300, 75));
			noGameEz.setOpaque(false);
			noGameEz.setBorder(new LineBorder(Color.LIGHT_GRAY));

			JLabel noGameText = new JLabel("NO HAY PARTIDAS GUARDADAS");
			noGameText.setVerticalAlignment(JLabel.CENTER);
			noGameText.setHorizontalAlignment(JLabel.CENTER);
			noGameText.setFont(controlDatos.fuentecargar(30f));
			noGameText.setForeground(Color.white);

			noGameEz.add(noGameText);

			scrollNor.setViewportView(noGameEz);
		} else {
			scrollNor.setViewportView(PartidasNormal);
		}

		scrollNor.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollNor.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

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

		JPanel dificultadDif = new JPanel(new GridBagLayout()) {
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

		JPanel PartidasDificil = new JPanel(new GridBagLayout()) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setColor(new Color(0, 0, 0, 0));
				g2d.fillRect(0, 0, getWidth(), getHeight());
				g2d.dispose();
			}
		};
		PartidasDificil.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		PartidasDificil.setOpaque(false);
		GridBagConstraints gbcpartidasDif = new GridBagConstraints();

		gbcpartidasDif.gridx = 0;
		gbcpartidasDif.gridy = 0;

		

		for (int i = 0; i < infoDif.size(); i++) {

			JPanel partidaPanel = new JPanel(new GridBagLayout()) {
				@Override
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					Graphics2D g2d = (Graphics2D) g.create();
					g2d.setColor(new Color(0, 51, 102, 128));
					g2d.fillRect(0, 0, getWidth(), getHeight());
					g2d.dispose();
				}
			};
			partidaPanel.setPreferredSize(new Dimension(375, 100));
			partidaPanel.setOpaque(false);
			partidaPanel.setBorder(new LineBorder(Color.LIGHT_GRAY));

			GridBagConstraints gbcPartidaPanel = new GridBagConstraints();

			gbcPartidaPanel.gridx = 0;
			gbcPartidaPanel.gridy = 0;
			gbcPartidaPanel.weighty = 1.0;
			gbcPartidaPanel.gridheight = 4;
			gbcPartidaPanel.fill = GridBagConstraints.VERTICAL;

			eliminarDif = new JButton(botonEliminarFIN);
			eliminarDif.setName("XDIF " + i);
			eliminarDif.setContentAreaFilled(false);
			eliminarDif.setFocusPainted(false);
			eliminarDif.setBorderPainted(false);

			eliminarDif.addActionListener(this);

			partidaPanel.add(eliminarDif, gbcPartidaPanel);

			final JButton finalEliminarDif = eliminarDif;
			
			eliminarDif.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					finalEliminarDif.setIcon(botonEliminarFINOP);
					partidaPanel.setBorder(new LineBorder(Color.pink, 2));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					finalEliminarDif.setIcon(botonEliminarFIN);
					partidaPanel.setBorder(new LineBorder(Color.lightGray, 2));
				}
			});

			gbcPartidaPanel.weighty = 0.0;
			gbcPartidaPanel.gridheight = 1;
			gbcPartidaPanel.fill = GridBagConstraints.NONE;

			for (int j = 0; j < infoDif.get(i).length + 1; j++) {

				switch (j) {
				case 0:
					JPanel usuarioPanel = new JPanel(new FlowLayout());
					usuarioPanel.setOpaque(false);

					JLabel jugador = new JLabel("Jugador: ");
					jugador.setFont(controlDatos.fuenteMC(15f));
					jugador.setForeground(Color.white);

					JLabel username = new JLabel("" + infoDif.get(i)[j].toUpperCase());
					username.setFont(controlDatos.fuenteMC(15f));
					username.setForeground(new Color(79, 240, 100));

					usuarioPanel.add(jugador);
					usuarioPanel.add(username);
					gbcPartidaPanel.gridy = 0;
					gbcPartidaPanel.gridx = 1;
					partidaPanel.add(usuarioPanel, gbcPartidaPanel);
					break;
				case 1:
					JPanel rondasPanel = new JPanel(new FlowLayout());
					rondasPanel.setOpaque(false);

					JLabel rondas = new JLabel("N. Ronda: ");
					rondas.setFont(controlDatos.fuenteMC(12f));
					rondas.setForeground(Color.lightGray);

					int rondasNum = Integer.valueOf(infoDif.get(i)[j]);
					JLabel num = new JLabel("" + rondasNum);
					num.setFont(controlDatos.fuenteMC(12f));
					num.setForeground(Color.lightGray);

					rondasPanel.add(rondas);
					rondasPanel.add(num);

					gbcPartidaPanel.gridy = 1;
					gbcPartidaPanel.gridx = 1;
					partidaPanel.add(rondasPanel, gbcPartidaPanel);
					break;
				case 2:
					int puntuacionNum = Integer.valueOf(infoDif.get(i)[j]);
					JLabel puntuacion = new JLabel("Puntos: " + puntuacionNum);
					puntuacion.setFont(controlDatos.fuenteMC(12f));
					puntuacion.setForeground(Color.lightGray);
					gbcPartidaPanel.gridy = 2;
					gbcPartidaPanel.gridx = 1;
					partidaPanel.add(puntuacion, gbcPartidaPanel);
					break;
				case 3:
					JLabel dia = new JLabel("Ult. Jugado: (" + infoDif.get(i)[j] + ")");
					dia.setFont(controlDatos.fuenteMC(10f));
					dia.setForeground(Color.lightGray);
					gbcPartidaPanel.gridy = 3;
					gbcPartidaPanel.gridx = 1;
					partidaPanel.add(dia, gbcPartidaPanel);
					break;
				}

			}

			gbcPartidaPanel.gridx = 2;
			gbcPartidaPanel.gridy = 0;
			gbcPartidaPanel.weighty = 1.0;
			gbcPartidaPanel.gridheight = 4;
			gbcPartidaPanel.fill = GridBagConstraints.VERTICAL;

			playDif = new JButton(botonPlayFin);
			playDif.setName("DIF " + i);
			playDif.setContentAreaFilled(false);
			playDif.setFocusPainted(false);
			playDif.setBorderPainted(false);

			playDif.addActionListener(this);

			partidaPanel.add(playDif, gbcPartidaPanel);
			
			final JButton finalPlayDif = playDif;
			
			playDif.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					finalPlayDif.setIcon(botonPlayFinOP);
					partidaPanel.setBorder(new LineBorder(Color.green, 2));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					finalPlayDif.setIcon(botonPlayFin);
					partidaPanel.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
				}
			});

			gbcPartidaPanel.weighty = 0.0;
			gbcPartidaPanel.gridheight = 1;
			gbcPartidaPanel.fill = GridBagConstraints.NONE;

			gbcpartidasDif.insets = new Insets(10, 10, 10, 10);

			PartidasDificil.add(partidaPanel, gbcpartidasDif);
			gbcpartidasDif.gridy++;
		}

		scrollDif.setOpaque(false);
		if (infoDif.size() == 0) {
			JPanel noGameEz = new JPanel() {
				@Override
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					Graphics2D g2d = (Graphics2D) g.create();
					g2d.setColor(new Color(0, 0, 0, 0));
					g2d.fillRect(0, 0, getWidth(), getHeight());
					g2d.dispose();
				}
			};
			noGameEz.setPreferredSize(new Dimension(300, 75));
			noGameEz.setOpaque(false);
			noGameEz.setBorder(new LineBorder(Color.LIGHT_GRAY));

			JLabel noGameText = new JLabel("NO HAY PARTIDAS GUARDADAS");
			noGameText.setVerticalAlignment(JLabel.CENTER);
			noGameText.setHorizontalAlignment(JLabel.CENTER);
			noGameText.setFont(controlDatos.fuentecargar(30f));
			noGameText.setForeground(Color.white);

			noGameEz.add(noGameText);

			scrollDif.setViewportView(noGameEz);
		} else {
			scrollDif.setViewportView(PartidasDificil);
		}

		scrollDif.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollDif.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		JViewport viewport3 = scrollDif.getViewport();
		viewport3.setOpaque(false);

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
		JButton botonPresionado = (JButton) e.getSource();

		String nombreBoton = botonPresionado.getName();

		String[] botonPos = new String[2];

		botonPos = nombreBoton.split(" ");

		

		switch (botonPos[0]) {
		case "DIF":
			System.out.println(botonPos[0]);
			System.out.println(botonPos[1]);
			break;
		case "NOR":
			System.out.println(botonPos[0]);
			System.out.println(botonPos[1]);
			break;
		case "EZ":
			System.out.println(botonPos[0]);
			System.out.println(botonPos[1]);
			break;
		case "XDIF":
			System.out.println(botonPos[0]);
			System.out.println(botonPos[1]);
			break;
		case "XNOR":
			System.out.println(botonPos[0]);
			System.out.println(botonPos[1]);
			break;
		case "XEZ":
			System.out.println(botonPos[0]);
			System.out.println(botonPos[1]);
			break;

		}


	}

}
