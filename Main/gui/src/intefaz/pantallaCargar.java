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
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import CargaDatos.controlDatos;
import inicio.Main;
import oracle.net.jdbc.TNSAddress.AddressList;

public class pantallaCargar extends JFrame {

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
		textofacil.setText("Partidas Guardadas Modo - ");
		descFacil.add(textofacil);

		JLabel textofacil2 = new JLabel();
		textofacil2.setForeground(new Color(79, 240, 100));
		textofacil2.setFont(controlDatos.fuenteTexto(15f));
		textofacil2.setText("Chupetes");

		descFacil.add(textofacil2);
		
		dificultadEz.add(descFacil, gbcEasyAbajo);

		gbcEasyAbajo.gridy = 2;
		gbcEasyAbajo.insets = new Insets(10, 10, 10, 10);
		
		
		JPanel Partidas = new JPanel(new GridBagLayout());
		GridBagConstraints gbcpartidas = new GridBagConstraints();
		
		gbcpartidas.gridx = 0;
		gbcpartidas.gridy = 0;
				
		for (int i = 0; i < controlDatos.numeroPartidas(0); i++) {
			
			
		}
		

		easyGeneral.add(dificultadEz, gbcEasy);
		
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

		// agregar layout de dificultad
		gbcNormal.gridy = 1;

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
		textonormal.setText("Partidas Guardadas Modo - ");
		descNormal.add(textonormal);

		JLabel textonormal2 = new JLabel();
		textonormal2.setForeground(new Color(173, 216, 240));
		textonormal2.setFont(controlDatos.fuenteTexto(15f));
		textonormal2.setText("Normal");

		descNormal.add(textonormal2);

		dificultadNormal.add(descNormal, gbcNormalAbajo);

		gbcNormalAbajo.gridy = 2;
		gbcNormalAbajo.fill = GridBagConstraints.BOTH; // Expande vertical y horizontalmente
		gbcNormalAbajo.weightx = 1.0; // Peso horizontal (para expandirse horizontalmente)
		gbcNormalAbajo.weighty = 1.0; // Peso vertical (para expandirse verticalmente)

//		JLabel desc2 = new JLabel();
//
//		desc2.setPreferredSize(mundo);
//		desc2.setText("<html><div style='text-align: center; margin-left: 32px; margin-right: 10px; padding-bottom:"
//				+ pixel
//				+ ";'><br><br>¡Salva ciudades y detén pandemias en este desafiante juego de estrategia global! Como líder de un equipo de expertos en salud, tu misión es desarrollar una cura y proteger a la población.");
//		desc2.setForeground(Color.white);
//		desc2.setOpaque(false);
//		desc2.setFont(controlDatos.fuenteMC(15.5f));

//		dificultadNormal.add(desc2, gbcNormalAbajo);

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

		// agregar layout de dificultad
		gbcDificil.gridy = 1;

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
		textoDificil.setText("Partidas Guardadas Modo - ");
		descDificil.add(textoDificil);

		JLabel textoDificil2 = new JLabel();
		textoDificil2.setForeground(new Color(230, 70, 79));
		textoDificil2.setFont(controlDatos.fuenteTexto(15f));
		textoDificil2.setText("Crisis");

		descDificil.add(textoDificil2);

		dificultadDif.add(descDificil, gbcDificilAbajo);

		gbcDificilAbajo.gridy = 2;
		gbcDificilAbajo.fill = GridBagConstraints.BOTH; 
		gbcDificilAbajo.weightx = 1.0; 
		gbcDificilAbajo.weighty = 1.0; 

		JLabel desc3 = new JLabel();

//		desc3.setPreferredSize(mundo);
//		desc3.setText(
//				"<html><body><div style='text-align: center; margin-left: 32px; margin-right: 10px; padding-bottom:"
//						+ pixel
//						+ ";'><br><br>¡La situación es crítica! Tu tarea es urgente: contener la pandemia, distribuir recursos y salvar ciudades. ¿Tienes lo necesario para liderar la respuesta mundial?");
//		desc3.setForeground(Color.white);
//		desc3.setOpaque(false);
//		desc3.setFont(controlDatos.fuenteMC(15.5f));

		dificultadDif.add(desc3, gbcDificilAbajo);

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
						Main.cargarParty.setVisible(false);
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
		panelgeneral.add(normalGeneral,gbcGeneral);
		
		gbcGeneral.gridx = 2;
		panelgeneral.add(dificilGeneral,gbcGeneral);
		

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
	
	public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new pantallaCargar().setVisible(true);
            }
        });
		System.out.print(controlDatos.numeroPartidas(0));
    }
	
}
