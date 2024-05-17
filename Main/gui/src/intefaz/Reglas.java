package intefaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import CargaDatos.controlDatos;
import inicio.Main;

/**
 * @author Liqi y Kader
 * 
 */

public class Reglas extends JFrame {
	
	public Reglas() {
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		
		double widthScreen = screen.width / 5;
		
		ImageIcon iconoIcono = new ImageIcon("src\\img\\main\\icono.png");
		Image imagenIcono = iconoIcono.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
		ImageIcon imgFinalIcono = new ImageIcon(imagenIcono);
		
		ImageIcon alfa = new ImageIcon("src\\img\\reglas\\iconoDesarrolloAzul.png");
		Image alfaEscalado = alfa.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
		ImageIcon AlfaFIN = new ImageIcon(alfaEscalado);
		
		ImageIcon iconDesarrolloRojo = new ImageIcon("src\\img\\reglas\\iconoDesarrolloRojo.png");
		Image iconDesarrolloRojoES = iconDesarrolloRojo.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
		ImageIcon iconDesarrolloRojofin = new ImageIcon(iconDesarrolloRojoES);
		
		ImageIcon iconCurar = new ImageIcon("src\\img\\reglas\\IconoCurar.png");
		Image iconCurarEs = iconCurar.getImage().getScaledInstance(70,70,Image.SCALE_SMOOTH);
		ImageIcon IconCurarFin = new ImageIcon(iconCurarEs);
		
		ImageIcon iconoBomba = new ImageIcon("src\\img\\reglas\\bombaIcono.png");
		Image iconoBombaES = iconoBomba.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
		ImageIcon iconoBombaFIN = new ImageIcon(iconoBombaES);
		
		ImageIcon iconDesarrolloAmarillo = new ImageIcon("src\\img\\reglas\\iconoDesarrolloAmarillo.png");
		Image iconDesarrolloAmarilloES = iconDesarrolloAmarillo.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
		ImageIcon iconDesarrolloAmarilloFIN = new ImageIcon(iconDesarrolloAmarilloES);
		
		ImageIcon iconDesarrolloNegro = new ImageIcon("src\\img\\reglas\\iconoDesarrolloNegro.png");
		Image iconDesarrolloNegroES = iconDesarrolloNegro.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
		ImageIcon iconDesarrolloNegroFIN = new ImageIcon(iconDesarrolloNegroES);
		
		ImageIcon ciudades = new ImageIcon("src\\img\\reglas\\ciudades.png");
		Image ciudadesES = ciudades.getImage().getScaledInstance(80,70,Image.SCALE_SMOOTH);
		ImageIcon ciudadesFinal = new ImageIcon(ciudadesES);
		
		JPanel reglasGeneral = new JPanel(new GridBagLayout()) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				// Dibuja la imagen de fondo
				ImageIcon iconoFondo = new ImageIcon("src\\img\\nuevaPartida\\fondo.jpg");
				Image imagenFondo = iconoFondo.getImage();
				g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
			}
		};
		
		GridBagConstraints gbcReglas = new GridBagConstraints();
		
		gbcReglas.gridx = 0;
		gbcReglas.gridy = 0;
		
		JPanel logoPanel = new JPanel();
		logoPanel.setOpaque(false);
		
		JLabel logoLabel = new JLabel(imgFinalIcono);
		logoPanel.add(logoLabel);
		
		reglasGeneral.add(logoPanel, gbcReglas);
		
		JPanel CurarPanelGeneral = new JPanel(new GridBagLayout());
		CurarPanelGeneral.setOpaque(false);
		CurarPanelGeneral.setPreferredSize(new Dimension(screen.width, 240));
		
		Border border = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(200,5,78));
		
		JPanel tituloCurarPanel = new JPanel(new FlowLayout());
		tituloCurarPanel.setBorder(border);
		tituloCurarPanel.setOpaque(false);
		
		JLabel textoTituloCurar = new JLabel();
		textoTituloCurar.setText("Curar - Desarrollar Vacunas - Ciudades");
		textoTituloCurar.setFont(controlDatos.fuenteMC(15f));
		textoTituloCurar.setForeground(Color.white);
		
		tituloCurarPanel.add(textoTituloCurar);
		
		GridBagConstraints gbcCurar = new GridBagConstraints();
		
		gbcCurar.gridx = 0;
		gbcCurar.gridy = 0;
		gbcCurar.gridwidth = 4;
		gbcCurar.weightx = 1.0;
		gbcCurar.fill = GridBagConstraints.HORIZONTAL;
		gbcCurar.insets = new Insets(10, 50, 10, 50);
		
		CurarPanelGeneral.add(tituloCurarPanel, gbcCurar);
		
		gbcCurar.gridwidth = 1;
		gbcCurar.weightx = 0.0;
		gbcCurar.fill = GridBagConstraints.NONE;
		
		
		JPanel vacunaAlfa = new JPanel(new FlowLayout()){
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setColor(new Color(167, 255, 255, 128));
				g2d.fillRect(0, 0, getWidth(), getHeight());
				g2d.dispose();
			}
		};
		vacunaAlfa.setOpaque(false);
		vacunaAlfa.setPreferredSize(new Dimension((int) widthScreen, 110));
		vacunaAlfa.setBorder(new LineBorder(Color.LIGHT_GRAY,2));
		
		JLabel imgAlfa = new JLabel(AlfaFIN);
		imgAlfa.setText("<html><center>Boton que sirve para <br> desarrollar la VIH");
		imgAlfa.setForeground(Color.blue);
		imgAlfa.setFont(controlDatos.fuenteMC(15f));
		imgAlfa.setHorizontalAlignment(JLabel.CENTER);
		imgAlfa.setVerticalAlignment(JLabel.CENTER);
		
		JLabel vih = new JLabel("<html><div style=' padding-left: 50px;'>VIH");
		vih.setForeground(Color.blue);
		vih.setFont(controlDatos.fuenteMC(15f));
		vih.setHorizontalAlignment(JLabel.CENTER);
		vih.setVerticalAlignment(JLabel.CENTER);
		
		
		vacunaAlfa.add(imgAlfa);
		vacunaAlfa.add(vih);
		
		
		gbcCurar.gridy = 1;
		CurarPanelGeneral.add(vacunaAlfa, gbcCurar);
		
		gbcCurar.gridx = 1;
		
		JPanel vacunaBeta = new JPanel(new FlowLayout()){
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setColor(new Color(167, 255, 255, 128));
				g2d.fillRect(0, 0, getWidth(), getHeight());
				g2d.dispose();
			}
		};
		vacunaBeta.setOpaque(false);
		vacunaBeta.setPreferredSize(new Dimension((int) widthScreen, 110));
		vacunaBeta.setBorder(new LineBorder(Color.LIGHT_GRAY,2));
		
		JLabel imgBeta = new JLabel(iconDesarrolloRojofin);
		imgBeta.setText("<html><center>Boton que sirve para <br> desarrollar CANCER ");
		imgBeta.setForeground(Color.red);
		imgBeta.setFont(controlDatos.fuenteMC(15f));
		imgBeta.setHorizontalAlignment(JLabel.CENTER);
		imgBeta.setVerticalAlignment(JLabel.CENTER);
		
		JLabel cancer = new JLabel("<html><div style=' padding-left: 50px;'>CANCER");
		cancer.setForeground(Color.red);
		cancer.setFont(controlDatos.fuenteMC(15f));
		cancer.setHorizontalAlignment(JLabel.CENTER);
		cancer.setVerticalAlignment(JLabel.CENTER);
		
		
		vacunaBeta.add(imgBeta);
		vacunaBeta.add(cancer);
		
		
		CurarPanelGeneral.add(vacunaBeta, gbcCurar);
		
		gbcCurar.gridx = 2;
		
		JPanel vacunaGamma = new JPanel(new FlowLayout()){
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setColor(new Color(167, 255, 255, 128));
				g2d.fillRect(0, 0, getWidth(), getHeight());
				g2d.dispose();
			}
		};
		vacunaGamma.setOpaque(false);
		vacunaGamma.setPreferredSize(new Dimension((int) widthScreen, 110));
		vacunaGamma.setBorder(new LineBorder(Color.LIGHT_GRAY,2));
		
		JLabel imgGamma = new JLabel(iconDesarrolloAmarilloFIN);
		imgGamma.setText("<html><center>Boton que sirve para <br> desarrollar SARS");
		imgGamma.setForeground(Color.yellow);
		imgGamma.setFont(controlDatos.fuenteMC(15f));
		imgGamma.setHorizontalAlignment(JLabel.CENTER);
		imgGamma.setVerticalAlignment(JLabel.CENTER);
		
		JLabel sars = new JLabel("<html><div style=' padding-left: 50px;'>SARS");
		sars.setForeground(Color.yellow);
		sars.setFont(controlDatos.fuenteMC(15f));
		sars.setHorizontalAlignment(JLabel.CENTER);
		sars.setVerticalAlignment(JLabel.CENTER);
		
		
		vacunaGamma.add(imgGamma);
		vacunaGamma.add(sars);
		
		
		CurarPanelGeneral.add(vacunaGamma, gbcCurar);
		
		gbcCurar.gridx = 3;
		
		JPanel vacunaNigga = new JPanel(new FlowLayout()){
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setColor(new Color(167, 255, 255, 128));
				g2d.fillRect(0, 0, getWidth(), getHeight());
				g2d.dispose();
			}
		};
		vacunaNigga.setOpaque(false);
		vacunaNigga.setPreferredSize(new Dimension((int) widthScreen, 110));
		vacunaNigga.setBorder(new LineBorder(Color.LIGHT_GRAY,2));
		
		JLabel imgNigga = new JLabel(iconDesarrolloNegroFIN);
		imgNigga.setText("<html><center>Boton que sirve para <br> desarrollar NIGGA");
		imgNigga.setForeground(Color.black);
		imgNigga.setFont(controlDatos.fuenteMC(15f));
		imgNigga.setHorizontalAlignment(JLabel.CENTER);
		imgNigga.setVerticalAlignment(JLabel.CENTER);
		
		JLabel nigga = new JLabel("<html><div style=' padding-left: 50px;'>NIGGA");
		nigga.setForeground(Color.black);
		nigga.setFont(controlDatos.fuenteMC(15f));
		nigga.setHorizontalAlignment(JLabel.CENTER);
		nigga.setVerticalAlignment(JLabel.CENTER);
		
		
		vacunaNigga.add(imgNigga);
		vacunaNigga.add(nigga);
		
		
		CurarPanelGeneral.add(vacunaNigga, gbcCurar);
		
		JPanel curar = new JPanel(new FlowLayout()){
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setColor(new Color(167, 255, 255, 128));
				g2d.fillRect(0, 0, getWidth(), getHeight());
				g2d.dispose();
			}
		};
		
		curar.setOpaque(false);
		curar.setPreferredSize(new Dimension((int) widthScreen , 150));
		curar.setBorder(new LineBorder(Color.LIGHT_GRAY,2));
		
		JLabel imgCurar = new JLabel(IconCurarFin);
		imgCurar.setText("<html><center>Boton que sirve para curar una ciudad");
		imgCurar.setForeground(Color.white);
		imgCurar.setFont(controlDatos.fuenteMC(15f));
		imgCurar.setHorizontalAlignment(JLabel.CENTER);
		imgCurar.setVerticalAlignment(JLabel.CENTER);
		
		curar.add(imgCurar);
		

		gbcCurar.gridx = 0;
		gbcCurar.gridy = 2;
		gbcCurar.gridwidth = 2;
		gbcCurar.weightx = 1.0;
		gbcCurar.fill = GridBagConstraints.HORIZONTAL;
		
		CurarPanelGeneral.add(curar, gbcCurar);
		
		JPanel ciudad = new JPanel(new FlowLayout()){
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setColor(new Color(167, 255, 255, 128));
				g2d.fillRect(0, 0, getWidth(), getHeight());
				g2d.dispose();
			}
		};
		
		ciudad.setOpaque(false);
		ciudad.setPreferredSize(new Dimension((int) widthScreen , 150));
		ciudad.setBorder(new LineBorder(Color.LIGHT_GRAY,2));
		
		JLabel imgCiudad = new JLabel(ciudadesFinal);
		imgCiudad.setText("<html><center>El numero de la imagen de la ciudad muestra el nivel de infeccion, <br> el color representa la enfermedad. En caso de llegar al nivel 3, y se conta-<br>gia otra vez, provoca un brote y se contagia las ciudades colindantes.");
		imgCiudad.setForeground(Color.white);
		imgCiudad.setFont(controlDatos.fuenteMC(13.5f));
		imgCiudad.setHorizontalAlignment(JLabel.CENTER);
		imgCiudad.setVerticalAlignment(JLabel.CENTER);
		
		ciudad.add(imgCiudad);
		

		gbcCurar.gridx = 2;
		gbcCurar.gridy = 2;
		gbcCurar.gridwidth = 2;
		gbcCurar.weightx = 1.0;
		gbcCurar.fill = GridBagConstraints.HORIZONTAL;
		
		CurarPanelGeneral.add(ciudad, gbcCurar);
		
		double widthentre3 = screen.width/2.3;
		
		JPanel ganarPerder = new JPanel(new GridBagLayout());
		ganarPerder.setOpaque(false);
		
		JPanel tituloGanarPerder = new JPanel(new FlowLayout());
		tituloGanarPerder.setBorder(border);
		tituloGanarPerder.setOpaque(false);
		
		JLabel textoGanarPerder = new JLabel();
		textoGanarPerder.setText("Ganar - Perder");
		textoGanarPerder.setFont(controlDatos.fuenteMC(15f));
		textoGanarPerder.setForeground(Color.white);
		
		tituloGanarPerder.add(textoGanarPerder);
		
		GridBagConstraints gbcGanarPerder = new GridBagConstraints();
		
		gbcGanarPerder.gridx = 0;
		gbcGanarPerder.gridy = 0;
		gbcGanarPerder.gridwidth = 4;
		gbcGanarPerder.weightx = 1.0;
		gbcGanarPerder.fill = GridBagConstraints.HORIZONTAL;
		gbcGanarPerder.insets = new Insets(10, 50, 10, 50);
		
		ganarPerder.add(tituloGanarPerder, gbcGanarPerder);
		
		gbcGanarPerder.gridwidth = 2;
		gbcGanarPerder.weightx = 1.0;
		
		JPanel perdido = new JPanel(new GridBagLayout()) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setColor(new Color(167, 255, 255, 128));
				g2d.fillRect(0, 0, getWidth(), getHeight());
				g2d.dispose();
			}
		};
		perdido.setOpaque(false);
		perdido.setBorder(new LineBorder(Color.LIGHT_GRAY,2));
		perdido.setPreferredSize(new Dimension((int) widthentre3, 160));
		
		GridBagConstraints gbcPerdido = new GridBagConstraints();
		
		gbcPerdido.gridx = 1;
		gbcPerdido.gridy = 0;
		gbcPerdido.insets = new Insets(10, 10, 10, 10);
		
		JLabel PerdidoTitulo = new JLabel("GAME OVER");
		PerdidoTitulo.setFont(controlDatos.fuentecargar(40f));
		PerdidoTitulo.setForeground(Color.red);
		
		perdido.add(PerdidoTitulo, gbcPerdido);
		
		gbcPerdido.gridx = 0;
		gbcPerdido.gridy = 1;
		
		JLabel facilPerdido = new JLabel("Facil");
		facilPerdido.setFont(controlDatos.fuenteMC(15f));
		facilPerdido.setForeground(new Color(184,255,144));

		perdido.add(facilPerdido, gbcPerdido);
		
		gbcPerdido.gridy = 2;
		
		JLabel facilCiudadInf = new JLabel ("Nivel de infeccion: 35");
		facilCiudadInf.setFont(controlDatos.fuenteMC(15f));
		facilCiudadInf.setForeground(Color.white);
		
		perdido.add(facilCiudadInf, gbcPerdido);
		
		gbcPerdido.gridy = 3;
		
		JLabel numBroteFacil = new JLabel ("Numero de brote: 10");
		numBroteFacil.setFont(controlDatos.fuenteMC(15f));
		numBroteFacil.setForeground(Color.white);
		
		perdido.add(numBroteFacil, gbcPerdido);
		
		gbcPerdido.gridy = 1;
		gbcPerdido.gridx = 1;
		
		JLabel normalPerdido = new JLabel("Normal");
		normalPerdido.setFont(controlDatos.fuenteMC(15f));
		normalPerdido.setForeground(new Color(173, 216, 240));
		
		perdido.add(normalPerdido, gbcPerdido);
		
		gbcPerdido.gridy = 2;
		
		JLabel normalCiudadInf = new JLabel ("Nivel de infeccion: 30");
		normalCiudadInf.setFont(controlDatos.fuenteMC(15f));
		normalCiudadInf.setForeground(Color.white);
		
		perdido.add(normalCiudadInf, gbcPerdido);
		
		gbcPerdido.gridy = 3;
		
		JLabel numBroteNormal = new JLabel ("Numero de brote: 8");
		numBroteNormal.setFont(controlDatos.fuenteMC(15f));
		numBroteNormal.setForeground(Color.white);
		
		perdido.add(numBroteNormal, gbcPerdido);
		
		gbcPerdido.gridy = 1;
		gbcPerdido.gridx = 2;
		
		JLabel dificilPerdido = new JLabel("Dificil");
		dificilPerdido.setFont(controlDatos.fuenteMC(15f));
		dificilPerdido.setForeground(new Color(230, 70, 79));
		
		perdido.add(dificilPerdido, gbcPerdido);
		
		gbcPerdido.gridy = 2;
		
		JLabel dificilCiudadInf = new JLabel ("Nivel de infeccion: 28");
		dificilCiudadInf.setFont(controlDatos.fuenteMC(15f));
		dificilCiudadInf.setForeground(Color.white);
		
		perdido.add(dificilCiudadInf, gbcPerdido);
		
		gbcPerdido.gridy = 3;
		
		JLabel numBroteDifici = new JLabel ("Numero de brote: 7");
		numBroteDifici.setFont(controlDatos.fuenteMC(15f));
		numBroteDifici.setForeground(Color.white);
		
		perdido.add(numBroteDifici, gbcPerdido);
		
		
		gbcGanarPerder.gridy = 1;
		
		ganarPerder.add(perdido, gbcGanarPerder);
		
		
		JPanel ganar = new JPanel(new GridBagLayout()){
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setColor(new Color(167, 255, 255, 128));
				g2d.fillRect(0, 0, getWidth(), getHeight());
				g2d.dispose();
			}
		};
		ganar.setOpaque(false);
		ganar.setBorder(new LineBorder(Color.LIGHT_GRAY,2));
		ganar.setPreferredSize(new Dimension((int) widthentre3, 160));
		
		GridBagConstraints gbcGanar = new GridBagConstraints();
		
		gbcGanar.gridx = 1;
		gbcGanar.gridy = 0;
		gbcGanar.insets = new Insets(10, 5, 10, 2);
		
		JLabel Ganartitulo = new JLabel("WIN");
		Ganartitulo.setFont(controlDatos.fuentecargar(40f));
		Ganartitulo.setForeground(Color.green);
		
		ganar.add(Ganartitulo, gbcGanar);
		
		gbcGanar.gridy = 1;
		
		JLabel descGanar = new JLabel("<html><center>Para ganar tienes que desarrollar todas las vacunas,<br>cada dificultad tendrá su % de desarrollo.");
		descGanar.setFont(controlDatos.fuenteMC(15f));
		descGanar.setForeground(Color.white);
		
		ganar.add(descGanar, gbcGanar);
		
		gbcGanar.gridy = 2;
		gbcGanar.gridx = 0;
		
		JLabel facilGanado = new JLabel("Facil: 25%/d");
		facilGanado.setFont(controlDatos.fuenteMC(15f));
		facilGanado.setForeground(new Color(184,255,144));
		
		ganar.add(facilGanado, gbcGanar);
		
		gbcGanar.gridx = 1;
		
		JLabel normalGanado = new JLabel("Normal: 20%/d");
		normalGanado.setFont(controlDatos.fuenteMC(15f));
		normalGanado.setForeground(new Color(173, 216, 240));
		ganar.add(normalGanado, gbcGanar);
		
		gbcGanar.gridx = 2;
		JLabel dificilGanado = new JLabel("Dificil: 10%/d");
		dificilGanado.setFont(controlDatos.fuenteMC(15f));
		dificilGanado.setForeground(new Color(230, 70, 79));
		
		ganar.add(dificilGanado, gbcGanar);
		
		gbcGanarPerder.gridx = 2;
		
		ganarPerder.add(ganar,gbcGanarPerder);
		
		double widthAccioneseventos = screen.width/3.3;
		
		JPanel accionesEventos = new JPanel(new GridBagLayout());
		accionesEventos.setOpaque(false);
		
		GridBagConstraints gbcAE = new GridBagConstraints();
		
		gbcAE.gridx = 0;
		gbcAE.gridy = 0;
		gbcAE.gridwidth = 3;
		gbcAE.weightx = 1.0;
		gbcAE.fill = GridBagConstraints.HORIZONTAL;
		gbcAE.insets = new Insets(10, 10, 10, 10);
		
		JPanel tituloAE = new JPanel(new FlowLayout());
		tituloAE.setBorder(border);
		tituloAE.setOpaque(false);
		
		JLabel textoAE = new JLabel();
		textoAE.setText("Acciones - Extras");
		textoAE.setFont(controlDatos.fuenteMC(15f));
		textoAE.setForeground(Color.white);
		
		tituloAE.add(textoAE);
		
		accionesEventos.add(tituloAE, gbcAE);
		
		gbcAE.gridwidth = 1;
		gbcAE.weightx = 1.0;
		gbcAE.fill = GridBagConstraints.HORIZONTAL;
		
		JPanel acciones = new JPanel(new GridBagLayout()){
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setColor(new Color(167, 255, 255, 128));
				g2d.fillRect(0, 0, getWidth(), getHeight());
				g2d.dispose();
			}
		};
		acciones.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		acciones.setOpaque(false);
		acciones.setPreferredSize(new Dimension((int)widthAccioneseventos, 160));
		
		GridBagConstraints gbcA = new GridBagConstraints();
		
		gbcA.gridx = 1;
		gbcA.gridy = 0;
		gbcA.insets = new Insets(10, 10, 10, 10);
		
		JLabel accionesTitulo = new JLabel("LEYENDA DE ACCIONES");
		accionesTitulo.setFont(controlDatos.fuentecargar(30f));
		accionesTitulo.setForeground(Color.lightGray);
		
		acciones.add(accionesTitulo, gbcA);
		
		gbcA.gridy = 1;
		
		JLabel curarAccion = new JLabel("Curar: 1 accion");
		curarAccion.setFont(controlDatos.fuenteMC(15f));
		curarAccion.setForeground(Color.white);
		
		acciones.add(curarAccion, gbcA);
		
		gbcA.gridy = 2;
		
		JLabel desarrolarVacuna = new JLabel("Desarrollar Vacuna: 4 acciones");
		desarrolarVacuna.setFont(controlDatos.fuenteMC(15f));
		desarrolarVacuna.setForeground(Color.white);
		
		acciones.add(desarrolarVacuna, gbcA);
		
		gbcA.gridy = 3;
		
		JLabel nukeAccion = new JLabel("Bomba: 3 acciones");
		nukeAccion.setFont(controlDatos.fuenteMC(15f));
		nukeAccion.setForeground(Color.white);
		
		acciones.add(nukeAccion, gbcA);
		
		gbcAE.gridy = 1;
		
		accionesEventos.add(acciones, gbcAE);
		
		gbcAE.gridx = 2;
		
		JPanel bombaNuke = new JPanel(new GridBagLayout()) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setColor(new Color(167, 255, 255, 128));
				g2d.fillRect(0, 0, getWidth(), getHeight());
				g2d.dispose();
			}
		};
		bombaNuke.setOpaque(false);
		bombaNuke.setBorder(new LineBorder(Color.LIGHT_GRAY,2));
		bombaNuke.setPreferredSize(new Dimension((int)widthAccioneseventos, 160));
		
		GridBagConstraints gbcNuke = new GridBagConstraints();
		
		gbcNuke.gridx = 0;
		gbcNuke.gridy = 0;
		gbcNuke.weighty = 1.0;
		gbcNuke.gridheight = 3;
		gbcNuke.fill = GridBagConstraints.VERTICAL;
		gbcNuke.insets = new Insets(10, 10, 10, 10);
		
		JLabel imgNuke = new JLabel(iconoBombaFIN);
		
		bombaNuke.add(imgNuke, gbcNuke);
		gbcNuke.weighty = 0.0;
		gbcNuke.gridheight = 1;
		gbcNuke.gridx = 1;
		gbcNuke.weightx = 1.0;
		gbcNuke.gridwidth = 2;
		gbcNuke.fill = GridBagConstraints.HORIZONTAL;
		
		JLabel descNuke = new JLabel("<html><center><br>Quita la infeccion en la ciudad y en sus colindantes, deja el efecto 'Atomico'");
		descNuke.setFont(controlDatos.fuenteMC(14.2f));
		descNuke.setForeground(Color.white);
		
		bombaNuke.add(descNuke, gbcNuke);
		
		gbcNuke.gridy = 2;
		
		JLabel atomico = new JLabel("<html><center>Atomico: Se duplica a la hora de infectarse y puede provocar dos brotes.");
		atomico.setFont(controlDatos.fuenteMC(14.2f));
		atomico.setForeground(Color.white);
		
		bombaNuke.add(atomico, gbcNuke);
		
		accionesEventos.add(bombaNuke, gbcAE);
		
		
		JPanel puntos = new JPanel(new GridBagLayout());
		puntos.setOpaque(false);
		
		JPanel panelPE = new JPanel(new FlowLayout());
		panelPE.setOpaque(false);
		panelPE.setBorder(border);
		
		JLabel tituloPE = new JLabel("Puntos");
		tituloPE.setFont(controlDatos.fuenteMC(15f));
		tituloPE.setForeground(Color.white);
		
		panelPE.add(tituloPE);
		
		gbcAE.gridx = 3;
		
		puntos.add(panelPE, gbcAE);
		
		gbcAE.gridy = 0;
		gbcAE.gridwidth = 1;
		gbcAE.weightx = 1.0;
		gbcAE.fill = GridBagConstraints.HORIZONTAL;
		
		accionesEventos.add(puntos,gbcAE);
		
		JPanel puntosDesc = new JPanel(new GridBagLayout()) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setColor(new Color(167, 255, 255, 128));
				g2d.fillRect(0, 0, getWidth(), getHeight());
				g2d.dispose();
			}
		};
		puntosDesc.setOpaque(false);
		puntosDesc.setPreferredSize(new Dimension((int)widthAccioneseventos, 160));
		puntosDesc.setBorder(new LineBorder(Color.LIGHT_GRAY));
		
		GridBagConstraints gbcPdesc = new GridBagConstraints();
		
		gbcPdesc.gridx = 0;
		gbcPdesc.gridy = 0;
		
		JPanel curarpuntosPanel = new JPanel(new FlowLayout());
		curarpuntosPanel.setOpaque(false);
		
		JLabel curarPuntos = new JLabel("Curar: ");
		curarPuntos.setFont(controlDatos.fuenteMC(15f));
		curarPuntos.setForeground(Color.white);
		
		curarpuntosPanel.add(curarPuntos);
		
		JLabel curarNumero = new JLabel("+20p");
		curarNumero.setFont(controlDatos.fuenteMC(15f));
		curarNumero.setForeground(Color.green);
		
		curarpuntosPanel.add(curarNumero);
		
		puntosDesc.add(curarpuntosPanel, gbcPdesc);
		
		gbcPdesc.gridy = 1;
		
		JPanel desarrollarPanel = new JPanel(new FlowLayout());
		desarrollarPanel.setOpaque(false);
		
		JLabel vacunaPuntos = new JLabel("Desarrollar Vacuna: ");
		vacunaPuntos.setFont(controlDatos.fuenteMC(15f));
		vacunaPuntos.setForeground(Color.white);
		
		desarrollarPanel.add(vacunaPuntos);
		
		JLabel vacunaNumero = new JLabel("+75p");
		vacunaNumero.setFont(controlDatos.fuenteMC(15f));
		vacunaNumero.setForeground(Color.green);
		
		desarrollarPanel.add(vacunaNumero);
		
		puntosDesc.add(desarrollarPanel, gbcPdesc);
		gbcPdesc.gridy = 2;
		
		JPanel completarVacuna = new JPanel(new FlowLayout());
		completarVacuna.setOpaque(false);
		
		JLabel completarVacunaText = new JLabel("Completar Vacuna: ");
		completarVacunaText.setFont(controlDatos.fuenteMC(15f));
		completarVacunaText.setForeground(Color.white);
		
		completarVacuna.add(completarVacunaText);
		
		JLabel completarVacunaNUM = new JLabel("+250p");
		completarVacunaNUM.setFont(controlDatos.fuenteMC(15f));
		completarVacunaNUM.setForeground(Color.green);
		
		completarVacuna.add(completarVacunaNUM);
		
		puntosDesc.add(completarVacuna, gbcPdesc);
		
		gbcPdesc.gridx = 1;
		gbcPdesc.gridy = 0;
		
		JPanel rondaPanel = new JPanel(new FlowLayout());
		rondaPanel.setOpaque(false);
		
		JLabel rondaTexto = new JLabel("Ronda 1-6: ");
		rondaTexto.setFont(controlDatos.fuenteMC(15f));
		rondaTexto.setForeground(Color.white);
		
		rondaPanel.add(rondaTexto);
		
		JLabel rondaNum = new JLabel("-50p/r");
		rondaNum.setFont(controlDatos.fuenteMC(15f));
		rondaNum.setForeground(Color.red);
		
		rondaPanel.add(rondaNum);
		
		puntosDesc.add(rondaPanel, gbcPdesc);
		
		gbcPdesc.gridy = 1;
		
		JPanel rondaPanel2 = new JPanel(new FlowLayout());
		rondaPanel2.setOpaque(false);
		
		JLabel rondaTexto2 = new JLabel("Ronda 7-inf: ");
		rondaTexto2.setFont(controlDatos.fuenteMC(15f));
		rondaTexto2.setForeground(Color.white);
		
		rondaPanel2.add(rondaTexto2);
		
		JLabel rondaNum2 = new JLabel("-80p/r");
		rondaNum2.setFont(controlDatos.fuenteMC(15f));
		rondaNum2.setForeground(Color.red);
		
		rondaPanel2.add(rondaNum2);
		
		puntosDesc.add(rondaPanel2, gbcPdesc);
		
		gbcPdesc.gridy = 2;
		
		JPanel nuke = new JPanel(new FlowLayout());
		nuke.setOpaque(false);
		
		JLabel nukeText = new JLabel("Bomba: ");
		nukeText.setFont(controlDatos.fuenteMC(15f));
		nukeText.setForeground(Color.white);
		
		nuke.add(nukeText);
		
		JLabel nukeNum = new JLabel("-100p/b");
		nukeNum.setFont(controlDatos.fuenteMC(15f));
		nukeNum.setForeground(Color.red);
		
		nuke.add(nukeNum);
		
		puntosDesc.add(nuke, gbcPdesc);
		
		gbcAE.gridy = 1;
		
		accionesEventos.add(puntosDesc, gbcAE);
		
		gbcReglas.gridy = 1;
		reglasGeneral.add(ganarPerder, gbcReglas);
		gbcReglas.gridy = 2;
		reglasGeneral.add(CurarPanelGeneral, gbcReglas);
		gbcReglas.gridy = 3;
		reglasGeneral.add(accionesEventos, gbcReglas);

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
				
				if (partida.partidaReglas) {
					CargarParty.game.setVisible(true);
				} else {
					Main.cargarPrincipal.setVisible(true);
				}
				
				
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
		botonVolver.setBackground(Color.black);
		botonVolver.add(volver);
		
		
		this.add(reglasGeneral);
		this.add(botonVolver, BorderLayout.SOUTH);
		
		
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