package intefaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicButtonUI;

import CargaDatos.controlDatos;
import controladores.controlPartida;
import inicio.Main;

public class CargarParty extends JFrame implements ActionListener {
	public static partida game = new partida();
	public static JButton bNormal;
	public static JButton bFacil; 
	public static JButton bDificil; 
	private CardLayout cards;
	public CargarParty() {

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
		Image mundoFaciles = mundoFacil.getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT);
		ImageIcon facil = new ImageIcon(mundoFaciles);

		ImageIcon mundoNormal = new ImageIcon("src\\img\\nuevaPartida\\normal.gif");
		Image mundoNormales = mundoNormal.getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT);
		ImageIcon normal = new ImageIcon(mundoNormales);

		ImageIcon mundoDificil = new ImageIcon("src\\img\\nuevaPartida\\dificil.gif");
		Image mundoDificiles = mundoDificil.getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT);
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
		
		bFacil = new JButton("JUGAR");
		bNormal = new JButton("JUGAR");
		bDificil = new JButton("JUGAR");
		
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

		Dimension mundo = new Dimension(450, 450);
		// agregar mundo
		JPanel mundoEz = new JPanel();
		mundoEz.setOpaque(false);
		mundoEz.setPreferredSize(mundo);
		JLabel mundoIcon = new JLabel(facil);
		mundoEz.add(mundoIcon);

		easyGeneral.add(mundoEz, gbcEasy);

		// agregar layout de dificultad
		gbcEasy.gridy = 1;

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

		JLabel dificultadIm = new JLabel("Dificultad - ");
		dificultadIm.setFont(controlDatos.fuentecargar());
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
		textofacil.setFont(controlDatos.fuenteTexto15());
		textofacil.setText("Bienvenido al modo");
		descFacil.add(textofacil);

		JLabel textofacil2 = new JLabel();
		textofacil2.setForeground(new Color(79, 240, 100));
		textofacil2.setFont(controlDatos.fuenteTexto15());
		textofacil2.setText("Chupete");

		descFacil.add(textofacil2);

		dificultadEz.add(descFacil, gbcEasyAbajo);

		gbcEasyAbajo.gridy = 2;
		gbcEasyAbajo.fill = GridBagConstraints.BOTH; // Expande vertical y horizontalmente
		gbcEasyAbajo.weightx = 1.0; // Peso horizontal (para expandirse horizontalmente)
		gbcEasyAbajo.weighty = 1.0; // Peso vertical (para expandirse verticalmente)

		JLabel desc = new JLabel();
		FontMetrics metrics = desc.getFontMetrics(controlDatos.fuenteMC());
		int textocupado = metrics.getHeight() + screen.height / 12;
		String pixel = textocupado + "px";
		desc.setPreferredSize(mundo);
		desc.setText("<html><div style='text-align: center; margin-left: 32px; margin-right: 10px; padding-bottom:"
				+ pixel
				+ ";'><br><br>Aquí, las epidemias se manejan con facilidad y los desafíos son prácticamente inexistentes. ¡Relájate mientras te paseas por el jardín de infancia del juego salvando vidas...");
		desc.setForeground(Color.white);
		desc.setOpaque(false);
		desc.setFont(controlDatos.fuenteMC());

		dificultadEz.add(desc, gbcEasyAbajo);

		easyGeneral.add(dificultadEz, gbcEasy);

		bFacil.setPreferredSize(new Dimension((int) widthScreen - 4, 90));
		bFacil.setOpaque(true);
		bFacil.setBorder(new LineBorder(Color.white));
		bFacil.setBackground(Color.gray);
		bFacil.setFont(controlDatos.fuentecargar());
		bFacil.setContentAreaFilled(true);
		bFacil.setBorderPainted(true);
		bFacil.setFocusPainted(false);
		bFacil.setForeground(new Color(79, 220, 100));
		bFacil.setUI(new BasicButtonUI() {
			@Override
			protected void paintButtonPressed(Graphics g, AbstractButton b) {
				// No hace nada para evitar el cambio de color al presionar
			}
		});

		bFacil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bFacil.setForeground(new Color(79, 230, 100));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				bFacil.setForeground(new Color(79, 192, 100));
			}
		});
		gbcEasy.gridy++;
		gbcEasy.weighty = 1.0;
		gbcEasy.fill = GridBagConstraints.BOTH;
		easyGeneral.add(bFacil, gbcEasy);

		

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
		dificultadIm2.setFont(controlDatos.fuentecargar());
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
		textonormal.setFont(controlDatos.fuenteTexto15());
		textonormal.setText("Bienvenido al modo");
		descNormal.add(textonormal);

		JLabel textonormal2 = new JLabel();
		textonormal2.setForeground(new Color(173, 216, 240));
		textonormal2.setFont(controlDatos.fuenteTexto15());
		textonormal2.setText("Normal");

		descNormal.add(textonormal2);

		dificultadNormal.add(descNormal, gbcNormalAbajo);

		gbcNormalAbajo.gridy = 2;
		gbcNormalAbajo.fill = GridBagConstraints.BOTH; // Expande vertical y horizontalmente
		gbcNormalAbajo.weightx = 1.0; // Peso horizontal (para expandirse horizontalmente)
		gbcNormalAbajo.weighty = 1.0; // Peso vertical (para expandirse verticalmente)

		JLabel desc2 = new JLabel();

		desc2.setPreferredSize(mundo);
		desc2.setText("<html><div style='text-align: center; margin-left: 32px; margin-right: 10px; padding-bottom:"
				+ pixel
				+ ";'><br><br>¡Salva ciudades y detén pandemias en este desafiante juego de estrategia global! Como líder de un equipo de expertos en salud, tu misión es desarrollar una cura y proteger a la población.");
		desc2.setForeground(Color.white);
		desc2.setOpaque(false);
		desc2.setFont(controlDatos.fuenteMC());

		dificultadNormal.add(desc2, gbcNormalAbajo);

		normalGeneral.add(dificultadNormal, gbcNormal);

		
		bNormal.setPreferredSize(new Dimension((int) widthScreen - 4, 90));
		bNormal.setOpaque(true);
		bNormal.setBorder(new LineBorder(Color.white));
		bNormal.setBackground(Color.gray);
		bNormal.setFont(controlDatos.fuentecargar());
		bNormal.setContentAreaFilled(true);
		bNormal.setBorderPainted(true);
		bNormal.setFocusPainted(false);
		bNormal.setForeground(new Color(79, 164, 184));
		bNormal.setUI(new BasicButtonUI() {
			@Override
			protected void paintButtonPressed(Graphics g, AbstractButton b) {
				// No hace nada para evitar el cambio de color al presionar
			}
		});

		bNormal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bNormal.setForeground(new Color(79, 164, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				bNormal.setForeground(new Color(79, 164, 184));
			}
		});
		gbcNormal.gridy++;
		gbcNormal.weighty = 1.0;
		gbcNormal.fill = GridBagConstraints.BOTH;
		normalGeneral.add(bNormal, gbcNormal);
		

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
		dificultadIm3.setFont(controlDatos.fuentecargar());
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
		textoDificil.setFont(controlDatos.fuenteTexto15());
		textoDificil.setText("Bienvenido al modo");
		descDificil.add(textoDificil);

		JLabel textoDificil2 = new JLabel();
		textoDificil2.setForeground(new Color(230, 70, 79));
		textoDificil2.setFont(controlDatos.fuenteTexto15());
		textoDificil2.setText("Crisis");

		descDificil.add(textoDificil2);

		dificultadDif.add(descDificil, gbcDificilAbajo);

		gbcDificilAbajo.gridy = 2;
		gbcDificilAbajo.fill = GridBagConstraints.BOTH; 
		gbcDificilAbajo.weightx = 1.0; 
		gbcDificilAbajo.weighty = 1.0; 

		JLabel desc3 = new JLabel();

		desc3.setPreferredSize(mundo);
		desc3.setText(
				"<html><body><div style='text-align: center; margin-left: 32px; margin-right: 10px; padding-bottom:"
						+ pixel
						+ ";'><br><br>¡La situación es crítica! Tu tarea es urgente: contener la pandemia, distribuir recursos y salvar ciudades. ¿Tienes lo necesario para liderar la respuesta mundial?");
		desc3.setForeground(Color.white);
		desc3.setOpaque(false);
		desc3.setFont(controlDatos.fuenteMC());

		dificultadDif.add(desc3, gbcDificilAbajo);

		dificilGeneral.add(dificultadDif, gbcDificil);

		bDificil.setPreferredSize(new Dimension((int) widthScreen - 4, 90));
		bDificil.setOpaque(true);
		bDificil.setBorder(new LineBorder(Color.white));
		bDificil.setBackground(Color.gray);
		bDificil.setFont(controlDatos.fuentecargar());
		bDificil.setContentAreaFilled(true);
		bDificil.setBorderPainted(true);
		bDificil.setFocusPainted(false);
		bDificil.setForeground(new Color(230, 70, 79));
		bDificil.setUI(new BasicButtonUI() {
			@Override
			protected void paintButtonPressed(Graphics g, AbstractButton b) {
				// No hace nada para evitar el cambio de color al presionar
			}
		});

		bDificil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bDificil.setForeground(new Color(230, 70, 79));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				bDificil.setForeground(new Color(200, 70, 79));
			}
		});
		gbcDificil.gridy++;
		gbcDificil.weighty = 1.0;
		gbcDificil.fill = GridBagConstraints.BOTH;
		dificilGeneral.add(bDificil, gbcDificil);
		
		GridBagConstraints gbcGeneral = new GridBagConstraints();
		
		JPanel hoverDif = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				// Dibuja la imagen de fondo
				ImageIcon iconoFondo = new ImageIcon("src\\img\\nuevaPartida\\marcoDificilOP.png");
				Image imagenFondo = iconoFondo.getImage();
				g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
			}
		};
		
		
		
		
		JPanel hoverNor = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				// Dibuja la imagen de fondo
				ImageIcon iconoFondo = new ImageIcon("src\\img\\nuevaPartida\\marcoNormalOP.png");
				Image imagenFondo = iconoFondo.getImage();
				g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
			}
		};

		
		JPanel hoverEz = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				// Dibuja la imagen de fondo
				ImageIcon iconoFondo = new ImageIcon("src\\img\\nuevaPartida\\marcoFacilOP.png");
				Image imagenFondo = iconoFondo.getImage();
				g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
			}
		};

		
		Dimension paneles = new Dimension ((int) widthScreen, screen.height - 70);
		hoverEz.setPreferredSize(paneles);
		hoverNor.setPreferredSize(paneles);
		hoverDif.setPreferredSize(paneles);
		hoverEz.setOpaque(false);
		hoverNor.setOpaque(false);
		hoverDif.setOpaque(false);
		hoverDif.setBorder(new LineBorder(Color.LIGHT_GRAY, 3, false));
		hoverNor.setBorder(new LineBorder(Color.LIGHT_GRAY, 3, false));
		hoverEz.setBorder(new LineBorder(Color.LIGHT_GRAY, 3, false));
		
		hoverEz.setLayout(new BorderLayout());
		
		JPanel hoverContentEz = new JPanel(new GridBagLayout()) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setColor(new Color(0, 0, 0, 128));
				g2d.fillRect(0, 0, getWidth(), getHeight());
				g2d.dispose();
			}
		};
		hoverContentEz.setOpaque(false);

		GridBagConstraints gbchoverContentEz = new GridBagConstraints();
		gbchoverContentEz.gridx = 0;
		gbchoverContentEz.gridy = 0;
		gbchoverContentEz.anchor = GridBagConstraints.CENTER;
		JLabel mundoHover1 = new JLabel(facil);
		hoverContentEz.add(mundoHover1, gbchoverContentEz);
		
		hoverEz.add(hoverContentEz, BorderLayout.CENTER);
		
		hoverNor.setLayout(new BorderLayout());
		
		JPanel hoverContentNor = new JPanel(new GridBagLayout()) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setColor(new Color(0, 0, 0, 128));
				g2d.fillRect(0, 0, getWidth(), getHeight());
				g2d.dispose();
			}
		};
		hoverContentNor.setOpaque(false);
		GridBagConstraints gbchoverContentNor = new GridBagConstraints();
		gbchoverContentNor.gridx = 0;
		gbchoverContentNor.gridy = 0;
		gbchoverContentNor.anchor = GridBagConstraints.CENTER;
		JLabel mundoHover2 = new JLabel(normal);
		hoverContentNor.add(mundoHover2, gbchoverContentNor);
		
		hoverNor.add(hoverContentNor, BorderLayout.CENTER);
		
		hoverDif.setLayout(new BorderLayout());
		
		JPanel hoverContentDif = new JPanel(new GridBagLayout()) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setColor(new Color(0, 0, 0, 128));
				g2d.fillRect(0, 0, getWidth(), getHeight());
				g2d.dispose();
			}
		};
		hoverContentDif.setOpaque(false);
		GridBagConstraints gbchoverContentDif = new GridBagConstraints();
		gbchoverContentDif.gridx = 0;
		gbchoverContentDif.gridy = 0;
		gbchoverContentDif.anchor = GridBagConstraints.CENTER;
		JLabel mundoHover3 = new JLabel(dificil);
		hoverContentDif.add(mundoHover3, gbchoverContentDif);
		
		hoverDif.add(hoverContentDif, BorderLayout.CENTER);
		
		
		cards = new CardLayout();
		
		JPanel card1 = new JPanel();
		card1.setLayout(cards);
		
		JPanel card2 = new JPanel();
		card2.setLayout(cards);
		
		JPanel card3 = new JPanel();
		card3.setLayout(cards);
		
		card1.add(easyGeneral, "CardMundo1");
		card1.add(hoverEz, "CardMundo1Hover");
		
		card2.add(normalGeneral, "CardMundo2");
		card2.add(hoverNor, "CardMundo2Hover");

		card3.add(dificilGeneral, "CardMundo3");
		card3.add(hoverDif, "CardMundo3Hover");
		
		gbcGeneral.gridx = 0;
		gbcGeneral.gridy = 0;
		gbcGeneral.insets = new Insets (5,5,5,5);

		bFacil.addMouseListener(new MouseAdapter() {
			Timer timer;
		    
		    @Override
		    public void mouseEntered(MouseEvent e) {
		        timer = new Timer(250, new ActionListener() { 
		            public void actionPerformed(ActionEvent e) {
		                cards.show(card2, "CardMundo2Hover");
		                cards.show(card3, "CardMundo3Hover");
		                easyGeneral.setBorder(new LineBorder(Color.PINK, 2, false));
		            }
		        });
		        timer.setRepeats(false); // Solo se ejecuta una vez
		        timer.start();
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		        if (timer != null) {
		            timer.stop(); // Detiene el timer si se sale antes de que se complete el retraso
		        }
		        cards.show(card2, "CardMundo2");
		        cards.show(card3, "CardMundo3");
		        easyGeneral.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, false));
		    }
		});

		bNormal.addMouseListener(new MouseAdapter() {
			private Timer timer;

		    @Override
		    public void mouseEntered(MouseEvent e) {
		        if (timer != null && timer.isRunning()) {
		            timer.stop();
		        }
		        timer = new Timer(250, new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                cards.show(card1, "CardMundo1Hover");
		                cards.show(card3, "CardMundo3Hover");
		                normalGeneral.setBorder(new LineBorder(Color.pink, 2, false));
		            }
		        });
		        timer.setRepeats(false);
		        timer.start();
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		        if (timer != null && timer.isRunning()) {
		            timer.stop();
		        }
		        timer = new Timer(250, new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                cards.show(card1, "CardMundo1");
		                cards.show(card3, "CardMundo3");
		                normalGeneral.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, false));
		            }
		        });
		        timer.setRepeats(false);
		        timer.start();
		    }
		});

		bDificil.addMouseListener(new MouseAdapter() {
			private Timer timer;

		    @Override
		    public void mouseEntered(MouseEvent e) {
		        if (timer == null) {
		            timer = new Timer(250, new ActionListener() {
		                @Override
		                public void actionPerformed(ActionEvent e) {
		                    cards.show(card1, "CardMundo1Hover");
		                    cards.show(card2, "CardMundo2Hover");
		                    timer = null;
		                    dificilGeneral.setBorder(new LineBorder(Color.pink, 2, false));
		                }
		            });
		            timer.setRepeats(false);
		            timer.start();
		        }
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		        if (timer != null) {
		            timer.stop();
		            timer = null;
		        }
		        cards.show(card1, "CardMundo1");
		        cards.show(card2, "CardMundo2");
		        dificilGeneral.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, false));
		    }
		});
		
		panelgeneral.add(card1, gbcGeneral);
		
		gbcGeneral.gridx = 1;
		panelgeneral.add(card2,gbcGeneral);
		
		gbcGeneral.gridx = 2;
		panelgeneral.add(card3,gbcGeneral);

		

		
		//boton volver
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

		JPanel botonVolver = new JPanel();
		botonVolver.setBackground(Color.black);
		botonVolver.add(volver);
		
		
		//añadir botones como listeners
		bFacil.addActionListener(this);
		bNormal.addActionListener(this);
		bDificil.addActionListener(this);
		
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
	    Object source = e.getSource(); // Obtiene el objeto que generó el evento

	    if (source == bFacil) {
	        Thread vac = new Thread(new Runnable() {
				
				@Override
				public void run() {
	        		game.setVisible(true);
	    	    	
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
	        vac.start();
	    } else if (source == bNormal) {
	    	Thread vac = new Thread(new Runnable() {
				
				@Override
				public void run() {
					game.setVisible(true);
	    	    	
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
	        vac.start();
	        
	        
	    } else if (source == bDificil) {
	    	Thread vac = new Thread(new Runnable() {
				
				@Override
				public void run() {
					game.setVisible(true);
	    	    	
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
	        vac.start();
	        
	    } else {
	        System.out.println("Se presionó un botón no identificado");
	    }
	}
}
