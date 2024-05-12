package inicio;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import CargaDatos.controlDatos;

public class prueba extends JFrame {

	public prueba() {
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		
		double widthScreen = screen.width / 5;
		
		ImageIcon iconoIcono = new ImageIcon("src\\img\\main\\icono.png");
		Image imagenIcono = iconoIcono.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon imgFinalIcono = new ImageIcon(imagenIcono);
		
		//declarar images
		
		ImageIcon alfa = new ImageIcon("src\\img\\reglas\\iconoDesarrolloAzul.png");
		Image alfaEscalado = alfa.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
		ImageIcon AlfaFIN = new ImageIcon(alfaEscalado);
		
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
		
		Border border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white);
		
		JPanel tituloCurarPanel = new JPanel(new FlowLayout());
		tituloCurarPanel.setBorder(border);
		tituloCurarPanel.setOpaque(false);
		
		JLabel textoTituloCurar = new JLabel();
		textoTituloCurar.setText("Curar - Desarrollar Vacunas - Ciudades");
		textoTituloCurar.setFont(controlDatos.fuenteMC15());
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
		imgAlfa.setFont(controlDatos.fuenteMC15());
		imgAlfa.setHorizontalAlignment(JLabel.CENTER);
		imgAlfa.setVerticalAlignment(JLabel.CENTER);
		
		JLabel vih = new JLabel("<html><div style=' padding-left: 50px;'>VIH");
		vih.setForeground(Color.blue);
		vih.setFont(controlDatos.fuenteMC12());
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
		
		JLabel imgBeta = new JLabel(AlfaFIN);
		imgBeta.setText("<html><center>Boton que sirve para <br> desarrollar CANCER ");
		imgBeta.setForeground(Color.red);
		imgBeta.setFont(controlDatos.fuenteMC15());
		imgBeta.setHorizontalAlignment(JLabel.CENTER);
		imgBeta.setVerticalAlignment(JLabel.CENTER);
		
		JLabel cancer = new JLabel("<html><div style=' padding-left: 50px;'>CANCER");
		cancer.setForeground(Color.red);
		cancer.setFont(controlDatos.fuenteMC15());
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
		
		JLabel imgGamma = new JLabel(AlfaFIN);
		imgGamma.setText("<html><center>Boton que sirve para <br> desarrollar SARS");
		imgGamma.setForeground(Color.yellow);
		imgGamma.setFont(controlDatos.fuenteMC15());
		imgGamma.setHorizontalAlignment(JLabel.CENTER);
		imgGamma.setVerticalAlignment(JLabel.CENTER);
		
		JLabel sars = new JLabel("<html><div style=' padding-left: 50px;'>SARS");
		sars.setForeground(Color.yellow);
		sars.setFont(controlDatos.fuenteMC15());
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
		
		JLabel imgNigga = new JLabel(AlfaFIN);
		imgNigga.setText("<html><center>Boton que sirve para <br> desarrollar NIGGA");
		imgNigga.setForeground(Color.black);
		imgNigga.setFont(controlDatos.fuenteMC15());
		imgNigga.setHorizontalAlignment(JLabel.CENTER);
		imgNigga.setVerticalAlignment(JLabel.CENTER);
		
		JLabel nigga = new JLabel("<html><div style=' padding-left: 50px;'>NIGGA");
		nigga.setForeground(Color.black);
		nigga.setFont(controlDatos.fuenteMC15());
		nigga.setHorizontalAlignment(JLabel.CENTER);
		nigga.setVerticalAlignment(JLabel.CENTER);
		
		
		vacunaNigga.add(imgNigga);
//		vacunaNigga.add(nigga);
		
		
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
		curar.setPreferredSize(new Dimension((int) widthScreen , 100));
		curar.setBorder(new LineBorder(Color.LIGHT_GRAY,2));
		
		JLabel imgCurar = new JLabel(AlfaFIN);
		imgCurar.setText("<html><center>Boton que sirve para curar una ciudad");
		imgCurar.setForeground(Color.white);
		imgCurar.setFont(controlDatos.fuenteMC15());
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
		ciudad.setPreferredSize(new Dimension((int) widthScreen , 100));
		ciudad.setBorder(new LineBorder(Color.LIGHT_GRAY,2));
		
		JLabel imgCiudad = new JLabel(AlfaFIN);
		imgCiudad.setText("<html><center>El numero de la imagen de la ciudad muestra <br> el nivel de infeccion, el color representa la enfermedad");
		imgCiudad.setForeground(Color.white);
		imgCiudad.setFont(controlDatos.fuenteMC15());
		imgCiudad.setHorizontalAlignment(JLabel.CENTER);
		imgCiudad.setVerticalAlignment(JLabel.CENTER);
		
		ciudad.add(imgCiudad);
		

		gbcCurar.gridx = 2;
		gbcCurar.gridy = 2;
		gbcCurar.gridwidth = 2;
		gbcCurar.weightx = 1.0;
		gbcCurar.fill = GridBagConstraints.HORIZONTAL;
		
		CurarPanelGeneral.add(ciudad, gbcCurar);
		
		JPanel ganarPerder = new JPanel(new GridBagLayout());
		ganarPerder.setOpaque(false);
		
		JPanel tituloGanarPerder = new JPanel(new FlowLayout());
		tituloGanarPerder.setBorder(border);
		tituloGanarPerder.setOpaque(false);
		
		JLabel textoGanarPerder = new JLabel();
		textoGanarPerder.setText("Ganar - Perder - Puntos");
		textoGanarPerder.setFont(controlDatos.fuenteMC15());
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
		
		
		gbcReglas.gridy = 1;
		reglasGeneral.add(CurarPanelGeneral, gbcReglas);
		gbcReglas.gridy = 2;
		reglasGeneral.add(ganarPerder, gbcReglas);
		
		this.add(reglasGeneral);
		
		
		
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

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                prueba p = new prueba();
                p.setVisible(true);
            }
        });

	}
}