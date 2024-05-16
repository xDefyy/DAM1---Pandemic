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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;
import javax.swing.JButton;
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
import objetos.ciudad;

public class partida extends JFrame implements ActionListener {
	public static usuarioGetName usuarioNombre = new usuarioGetName();
	public static ganarPerder winLoseFrame = new ganarPerder();
	public static JProgressBar Alfa = new JProgressBar();
	public static JProgressBar Beta = new JProgressBar();
	public static JProgressBar Gamma = new JProgressBar();
	public static JProgressBar Delta = new JProgressBar();
	public static JButton DAlfa = new JButton("VIH");
	public static JButton DBeta = new JButton("CANCER");
	public static JButton DGamma = new JButton("SARS");
	public static JButton DDelta = new JButton("NIGGA");
	public static JButton finalizarRonda = new JButton("Finalizar Ronda");
	public static JButton curar = new JButton("Curar");
	public static JLabel rondas = new JLabel();
	public static JTextArea textArea = new JTextArea();
	public static JLabel acciones = new JLabel();
	public static JMenuItem music;
	public static JMenuItem volverAlMenu;
	public static JMenuItem reglas;
	public static JMenuItem guardarSalir;
	public static ImageIcon iconoMus = new ImageIcon("src\\img\\main\\iconoMusica.png");
	public static Image iconoMusica = iconoMus.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	public static ImageIcon iconoMusFinal = new ImageIcon(iconoMusica);
	public static ImageIcon iconoMusDes = new ImageIcon("src\\img\\main\\iconoMusicaTachado.png");
	public static Image iconoMusicaDes = iconoMusDes.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	public static ImageIcon iconoMusFinalDes = new ImageIcon(iconoMusicaDes);
	public static boolean musica = true;
	public static JLabel brotes = new JLabel();
	public static JLabel scoreNum = new JLabel();
	public static JLabel ciudadesInf = new JLabel();
	public static boolean ciudadSeleccionada = false;
	
	// Botones
	public static JButton Francisco;
	public static JButton Chicago;
	public static JButton Atlanta;
	public static JButton Montreal;
	public static JButton York;
	public static JButton Washington;
	public static JButton Londres;
	public static JButton Madrid;
	public static JButton Paris;
	public static JButton Essen;
	public static JButton Milan;
	public static JButton Petersburgo;
	public static JButton Angeles;
	public static JButton Miami;
	public static JButton Mexico;
	public static JButton Bogota;
	public static JButton Lima;
	public static JButton Santiago;
	public static JButton Aires;
	public static JButton Paulo;
	public static JButton Lagos;
	public static JButton Kinsasa;
	public static JButton Jartum;
	public static JButton Johannesburgo;
	public static JButton Argel;
	public static JButton Cairo;
	public static JButton Riad;
	public static JButton Estambul;
	public static JButton Bagdad;
	public static JButton Moscu;
	public static JButton Teheran;
	public static JButton Karachi;
	public static JButton Bombay;
	public static JButton Delhi;
	public static JButton Calcuta;
	public static JButton Madras;
	public static JButton Yakarta;
	public static JButton Bangkok;
	public static JButton Kong;
	public static JButton Shanghai;
	public static JButton Pekin;
	public static JButton Seul;
	public static JButton Tokio;
	public static JButton Osaka;
	public static JButton Taipei;
	public static JButton Minh;
	public static JButton Manila;
	public static JButton Sidney;
	public static JPanel game;
	public static JPopupMenu nombre;
	public static JButton nuke;

	//imagenes
	
	public static ImageIcon azul0 = new ImageIcon("src\\img\\inGame\\virusAzul0.png");
	public static Image Alfa0 = azul0.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
	public static ImageIcon azulVirusCiudad0 = new ImageIcon(Alfa0);

	public static ImageIcon azul = new ImageIcon("src\\img\\inGame\\virusAzul.png");
	public static Image Alfa1 = azul.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
	public static ImageIcon azulVirusCiudad = new ImageIcon(Alfa1);

	public static ImageIcon azul2 = new ImageIcon("src\\img\\inGame\\virusAzul2.png");
	public static Image Alfa2 = azul2.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
	public static ImageIcon azulVirusCiudad2 = new ImageIcon(Alfa2);

	public static ImageIcon azul3 = new ImageIcon("src\\img\\inGame\\virusAzul3.png");
	public static Image Alfa3 = azul3.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
	public static ImageIcon azulVirusCiudad3 = new ImageIcon(Alfa3);

	public static ImageIcon rojo0 = new ImageIcon("src\\img\\inGame\\virusRojo0.png");
	public static Image beta0 = rojo0.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
	public static ImageIcon rojoVirusCiudad0 = new ImageIcon(beta0);

	public static ImageIcon rojo = new ImageIcon("src\\img\\inGame\\virusRojo.png");
	public static Image beta = rojo.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
	public static ImageIcon rojoVirusCiudad = new ImageIcon(beta);

	public static ImageIcon rojo2 = new ImageIcon("src\\img\\inGame\\virusRojo2.png");
	public static Image beta2 = rojo2.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
	public static ImageIcon rojoVirusCiudad2 = new ImageIcon(beta2);

	public static ImageIcon rojo3 = new ImageIcon("src\\img\\inGame\\virusRojo3.png");
	public static Image beta3 = rojo3.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
	public static ImageIcon rojoVirusCiudad3 = new ImageIcon(beta3);

	public static ImageIcon amarillo0 = new ImageIcon("src\\img\\inGame\\virusAmarillo0.png");
	public static Image gamma0 = amarillo0.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
	public static ImageIcon amarilloVirusCiudad0 = new ImageIcon(gamma0);

	public static ImageIcon amarillo = new ImageIcon("src\\img\\inGame\\virusAmarillo.png");
	public static Image gamma = amarillo.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
	public static ImageIcon amarilloVirusCiudad = new ImageIcon(gamma);

	public static ImageIcon amarillo2 = new ImageIcon("src\\img\\inGame\\virusAmarillo2.png");
	public static Image gamma2 = amarillo2.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
	public static ImageIcon amarilloVirusCiudad2 = new ImageIcon(gamma2);

	public static ImageIcon amarillo3 = new ImageIcon("src\\img\\inGame\\virusAmarillo3.png");
	public static Image gamma3 = amarillo3.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
	public static ImageIcon amarilloVirusCiudad3 = new ImageIcon(gamma3);

	public static ImageIcon negro0 = new ImageIcon("src\\img\\inGame\\virusNegro0.png");
	public static Image delta0 = negro0.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
	public static ImageIcon negroVirusCiudad0 = new ImageIcon(delta0);

	public static ImageIcon negro = new ImageIcon("src\\img\\inGame\\virusNegro.png");
	public static Image delta = negro.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
	public static ImageIcon negroVirusCiudad = new ImageIcon(delta);

	public static ImageIcon negro2 = new ImageIcon("src\\img\\inGame\\virusNegro2.png");
	public static Image delta2 = negro2.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
	public static ImageIcon negroVirusCiudad2 = new ImageIcon(delta2);

	public static ImageIcon negro3 = new ImageIcon("src\\img\\inGame\\virusNegro3.png");
	public static Image delta3 = negro3.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
	public static ImageIcon negroVirusCiudad3 = new ImageIcon(delta3);
	public static Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	public static boolean partidaReglas = false;
	public partida()  {
		
		ImageIcon iconoIcono = new ImageIcon("src\\img\\inGame\\icono.png");
		Image imagenIcono = iconoIcono.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
		ImageIcon imgFinalIcono = new ImageIcon(imagenIcono);

		ImageIcon personajes = new ImageIcon("src\\img\\inGame\\hitler.jpg");
		Image IconPersonaje = personajes.getImage().getScaledInstance(screen.height / 7, screen.height / 7,
				Image.SCALE_SMOOTH);
		ImageIcon personajeIcon = new ImageIcon(IconPersonaje);
		

		LineBorder borderRojo = new LineBorder(new Color(137, 5, 78), 3);
		
		ImageIcon iconCurar = new ImageIcon("src\\img\\inGame\\IconoCurar.png");
		Image iconCurarEs = iconCurar.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
		ImageIcon IconCurarFin = new ImageIcon(iconCurarEs);
		
		ImageIcon iconCurarOP = new ImageIcon("src\\img\\inGame\\IconoCurarOP.png");
		Image iconCurarEsOP = iconCurarOP.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
		ImageIcon IconCurarFinop = new ImageIcon(iconCurarEsOP);
		
		ImageIcon iconDesarrolloAzul = new ImageIcon("src\\img\\inGame\\iconoDesarrolloAzul.png");
		Image iconDesarrolloAzulES = iconDesarrolloAzul.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
		ImageIcon iconDesarrolloAzulFIN = new ImageIcon(iconDesarrolloAzulES);
		
		ImageIcon iconDesarrolloAzulOP = new ImageIcon("src\\img\\inGame\\iconoDesarrolloAzulOP.png");
		Image iconDesarrolloAzulOPes = iconDesarrolloAzulOP.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
		ImageIcon iconDesarrolloAzulFINOP = new ImageIcon(iconDesarrolloAzulOPes);
		
		ImageIcon iconDesarrolloAmarillo = new ImageIcon("src\\img\\inGame\\iconoDesarrolloAmarillo.png");
		Image iconDesarrolloAmarilloES = iconDesarrolloAmarillo.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
		ImageIcon iconDesarrolloAmarilloFIN = new ImageIcon(iconDesarrolloAmarilloES);
		
		ImageIcon iconDesarrolloAmarilloOP = new ImageIcon("src\\img\\inGame\\iconoDesarrolloAmarilloOP.png");
		Image iconDesarrolloAmarilloESOP = iconDesarrolloAmarilloOP.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
		ImageIcon iconDesarrolloAmarilloFINOP = new ImageIcon(iconDesarrolloAmarilloESOP);
		
		ImageIcon iconDesarrolloNegro = new ImageIcon("src\\img\\inGame\\iconoDesarrolloNegro.png");
		Image iconDesarrolloNegroES = iconDesarrolloNegro.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
		ImageIcon iconDesarrolloNegroFIN = new ImageIcon(iconDesarrolloNegroES);
		
		ImageIcon iconDesarrolloNegroop = new ImageIcon("src\\img\\inGame\\iconoDesarrolloNegroOP.png");
		Image iconDesarrolloNegroESop = iconDesarrolloNegroop.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
		ImageIcon iconDesarrolloNegroFINop = new ImageIcon(iconDesarrolloNegroESop);
		
		ImageIcon iconDesarrolloRojo = new ImageIcon("src\\img\\inGame\\iconoDesarrolloRojo.png");
		Image iconDesarrolloRojoES = iconDesarrolloRojo.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
		ImageIcon iconDesarrolloRojofin = new ImageIcon(iconDesarrolloRojoES);
		
		ImageIcon iconDesarrolloRojoop = new ImageIcon("src\\img\\inGame\\iconoDesarrolloRojoOP.png");
		Image iconDesarrolloRojoESOP = iconDesarrolloRojoop.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
		ImageIcon iconDesarrolloRojofinOP = new ImageIcon(iconDesarrolloRojoESOP);
		
		ImageIcon iconGuardar = new ImageIcon("src\\img\\main\\iconoGuardar.png");
		Image iconGuardarES = iconGuardar.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
		ImageIcon iconGuardarFIN = new ImageIcon(iconGuardarES);
		
		ImageIcon iconoVolver = new ImageIcon("src\\img\\main\\volver.png");
		Image iconoVolverES = iconoVolver.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
		ImageIcon iconVolverFIN = new ImageIcon(iconoVolverES);
		
		ImageIcon iconoBomba = new ImageIcon("src\\img\\inGame\\bombaIcono.png");
		Image iconoBombaES = iconoBomba.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
		ImageIcon iconoBombaFIN = new ImageIcon(iconoBombaES);
		
		ImageIcon iconoBombaOP = new ImageIcon("src\\img\\inGame\\bombaIconoOP.png");
		Image iconoBombaOPES = iconoBombaOP.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
		ImageIcon iconoBombaFINOP = new ImageIcon(iconoBombaOPES);
		
		ImageIcon iconoReglas = new ImageIcon("src\\img\\inGame\\reglasIcono.png");
		Image iconoReglasES = iconoReglas.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
		ImageIcon iconoReglasFIN = new ImageIcon(iconoReglasES);
		
		ImageIcon iconoMain = new ImageIcon("src\\img\\inGame\\inicioIcono.png");
		Image iconoMainES = iconoMain.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
		ImageIcon iconoMainFIN = new ImageIcon(iconoMainES);
		
		curar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				curar.setForeground(new Color(200,5,78));
				curar.setIcon(IconCurarFinop);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				curar.setForeground(new Color(137,5,78));
				curar.setIcon(IconCurarFin);
			}
		});
		
		finalizarRonda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				finalizarRonda.setForeground(new Color(200,5,78));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				finalizarRonda.setForeground(new Color(137,5,78));

			}
		});
		
		DAlfa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				DAlfa.setForeground(new Color(200,5,78));
				DAlfa.setIcon(iconDesarrolloAzulFINOP);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				DAlfa.setForeground(new Color(137,5,78));
				DAlfa.setIcon(iconDesarrolloAzulFIN);
			}
		});
		
		DGamma.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				DGamma.setForeground(new Color(200,5,78));
				DGamma.setIcon(iconDesarrolloAmarilloFINOP);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				DGamma.setForeground(new Color(137,5,78));
				DGamma.setIcon(iconDesarrolloAmarilloFIN);
			}
		});
		
		DDelta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				DDelta.setForeground(new Color(200,5,78));
				DDelta.setIcon(iconDesarrolloNegroFINop);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				DDelta.setForeground(new Color(137,5,78));
				DDelta.setIcon(iconDesarrolloNegroFIN);
			}
		});
		
		DBeta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				DBeta.setForeground(new Color(200,5,78));
				DBeta.setIcon(iconDesarrolloRojofinOP);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				DBeta.setForeground(new Color(137,5,78));
				DBeta.setIcon(iconDesarrolloRojofin);
			}
		});
		
		
		
		game = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				// Dibuja la imagen de fondo
				ImageIcon iconoFondo = new ImageIcon("src\\img\\inGame\\mar.jpeg");
				Image imagenFondo = iconoFondo.getImage();
				g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
			}
		};
		game.setLayout(null);
		boolean falso = false;
		int x = 50;
		ButtonGroup ciudadesBtn = new ButtonGroup();
		//botones
		Francisco = new JButton();;
		Francisco.setOpaque(falso);
		Francisco.setFocusPainted(falso);
		Francisco.setContentAreaFilled(falso);
		Francisco.setBorderPainted(falso);
		Francisco.setBounds(132,205,x,x);
		Francisco.setName("Francisco");
		Francisco.setIcon(azulVirusCiudad0);
		ciudadesBtn.add(Francisco);
		game.add(Francisco);
		 
		Chicago = new JButton();
		Chicago.setOpaque(falso);
		Chicago.setFocusPainted(falso);
		Chicago.setContentAreaFilled(falso);
		Chicago.setBorderPainted(falso);
		Chicago.setBounds(240,180,x,x);
		Chicago.setIcon(azulVirusCiudad0);
		Chicago.setName("Chicago");
		ciudadesBtn.add(Chicago);
		game.add(Chicago);
		
		Atlanta = new JButton();
		Atlanta.setOpaque(falso);
		Atlanta.setFocusPainted(falso);
		Atlanta.setContentAreaFilled(falso);
		Atlanta.setBorderPainted(falso);
		Atlanta.setBounds(295, 255, x,x);
		Atlanta.setIcon(azulVirusCiudad0);
		Atlanta.setName("Atlanta");
		ciudadesBtn.add(Atlanta);
		game.add(Atlanta);
		
		Montreal = new JButton();
		Montreal.setOpaque(falso);
		Montreal.setFocusPainted(falso);
		Montreal.setContentAreaFilled(falso);
		Montreal.setBorderPainted(falso);
		Montreal.setBounds(365,205,x,x);
		Montreal.setIcon(azulVirusCiudad0);
		Montreal.setName("Montreal");
		ciudadesBtn.add(Montreal);
		game.add(Montreal);
		
		York = new JButton();
		York.setOpaque(falso);
		York.setFocusPainted(falso);
		York.setContentAreaFilled(falso);
		York.setBorderPainted(falso);
		York.setBounds(460, 195, x ,x );
		York.setIcon(azulVirusCiudad0);
		York.setName("York");
		ciudadesBtn.add(York);
		game.add(York);
		
		Washington = new JButton();
		Washington.setOpaque(falso);
		Washington.setFocusPainted(falso);
		Washington.setContentAreaFilled(falso);
		Washington.setBorderPainted(falso);
		Washington.setBounds(442, 275,x,x);
		Washington.setIcon(azulVirusCiudad0);
		Washington.setName("Washington");
		ciudadesBtn.add(Washington);
		game.add(Washington);
		
		Londres = new JButton();
		Londres.setOpaque(falso);
		Londres.setFocusPainted(falso);
		Londres.setContentAreaFilled(falso);
		Londres.setBorderPainted(falso);
		Londres.setBounds(650,180,x,x);
		Londres.setIcon(azulVirusCiudad0);
		Londres.setName("Londres");
		ciudadesBtn.add(Londres);
		game.add(Londres);
		
		Madrid = new JButton();
		Madrid.setOpaque(falso);
		Madrid.setFocusPainted(falso);
		Madrid.setContentAreaFilled(falso);
		Madrid.setBorderPainted(falso);
		Madrid.setIcon(azulVirusCiudad0);
		Madrid.setName("Madrid");
		Madrid.setBounds(633, 265, x,x);
		ciudadesBtn.add(Madrid);
		game.add(Madrid);
		
		Paris = new JButton();
		Paris.setOpaque(falso);
		Paris.setFocusPainted(falso);
		Paris.setContentAreaFilled(falso);
		Paris.setBorderPainted(falso);
		Paris.setBounds(710,225,x,x);
		Paris.setIcon(azulVirusCiudad0);
		Paris.setName("Paris");
		ciudadesBtn.add(Paris);
		game.add(Paris);
		
		Essen = new JButton();
		Essen.setOpaque(falso);
		Essen.setFocusPainted(falso);
		Essen.setContentAreaFilled(falso);
		Essen.setBorderPainted(falso);
		Essen.setBounds(745, 150,x,x);
		Essen.setIcon(azulVirusCiudad0);
		Essen.setName("Essen");
		ciudadesBtn.add(Essen);
		game.add(Essen);
		
		Milan = new JButton();
		Milan.setOpaque(falso);
		Milan.setFocusPainted(falso);
		Milan.setContentAreaFilled(falso);
		Milan.setBorderPainted(falso);
		Milan.setBounds(780, 200,x,x);
		Milan.setIcon(azulVirusCiudad0);
		Milan.setName("Milan");
		ciudadesBtn.add(Milan);
		game.add(Milan);
		
		Petersburgo = new JButton();
		Petersburgo.setOpaque(falso);
		Petersburgo.setFocusPainted(falso);
		Petersburgo.setContentAreaFilled(falso);
		Petersburgo.setBorderPainted(falso);
		Petersburgo.setBounds(870, 125,x,x);
		Petersburgo.setIcon(azulVirusCiudad0);
		Petersburgo.setName("Petersburgo");
		ciudadesBtn.add(Petersburgo);
		game.add(Petersburgo);
		
		
		Angeles = new JButton();
		Angeles.setOpaque(falso);
		Angeles.setFocusPainted(falso);
		Angeles.setContentAreaFilled(falso);
		Angeles.setBorderPainted(falso);
		Angeles.setBounds(165, 280,x,x);
		Angeles.setIcon(amarilloVirusCiudad0);
		Angeles.setName("Angeles");;
		ciudadesBtn.add(Angeles);
		game.add(Angeles);
		
		Miami = new JButton();
		Miami.setOpaque(falso);
		Miami.setFocusPainted(falso);
		Miami.setContentAreaFilled(falso);
		Miami.setBorderPainted(falso);
		Miami.setBounds(350,310,x,x);
		Miami.setIcon(amarilloVirusCiudad0);
		Miami.setName("Miami");
		ciudadesBtn.add(Miami);
		game.add(Miami);
		
		Mexico = new JButton();
		Mexico.setOpaque(falso);
		Mexico.setFocusPainted(falso);
		Mexico.setContentAreaFilled(falso);
		Mexico.setBorderPainted(falso);
		Mexico.setBounds(258,340, x,x);
		Mexico.setIcon(amarilloVirusCiudad0);
		Mexico.setName("Mexico");
		ciudadesBtn.add(Mexico);
		game.add(Mexico);
		
		Bogota = new JButton();
		Bogota.setOpaque(falso);
		Bogota.setFocusPainted(falso);
		Bogota.setContentAreaFilled(falso);
		Bogota.setBorderPainted(falso);
		Bogota.setBounds(380,430,x,x);
		Bogota.setIcon(amarilloVirusCiudad0);
		Bogota.setName("Bogota");
		ciudadesBtn.add(Bogota);
		game.add(Bogota);
		
		Lima = new JButton();
		Lima.setOpaque(falso);
		Lima.setFocusPainted(falso);
		Lima.setContentAreaFilled(falso);
		Lima.setBorderPainted(falso);
		Lima.setBounds(330, 500, x ,x);
		Lima.setIcon(amarilloVirusCiudad0);
		Lima.setName("Lima");
		ciudadesBtn.add(Lima);
		game.add(Lima);
		
		Santiago = new JButton();
		Santiago.setOpaque(falso);
		Santiago.setFocusPainted(falso);
		Santiago.setContentAreaFilled(falso);
		Santiago.setBorderPainted(falso);
		Santiago.setBounds(360, 615, x ,x);
		Santiago.setIcon(amarilloVirusCiudad0);
		Santiago.setName("Santiago");
		ciudadesBtn.add(Santiago);
		game.add(Santiago);
		
		Aires = new JButton();
		Aires.setOpaque(falso);
		Aires.setFocusPainted(falso);
		Aires.setContentAreaFilled(falso);
		Aires.setBorderPainted(falso);
		Aires.setIcon(amarilloVirusCiudad0);
		Aires.setBounds(470, 585,x,x);
		Aires.setName("Aires");
		ciudadesBtn.add(Aires);
		game.add(Aires);
		
		Paulo = new JButton();
		Paulo.setOpaque(falso);
		Paulo.setFocusPainted(falso);
		Paulo.setContentAreaFilled(falso);
		Paulo.setBorderPainted(falso);
		Paulo.setBounds(510,520,x,x);
		Paulo.setIcon(amarilloVirusCiudad0);
		Paulo.setName("Paulo");
		ciudadesBtn.add(Paulo);
		game.add(Paulo);
		
		Lagos = new JButton();
		Lagos.setOpaque(falso);
		Lagos.setFocusPainted(falso);
		Lagos.setContentAreaFilled(falso);
		Lagos.setBorderPainted(falso);
		Lagos.setBounds(688, 420,x,x);
		Lagos.setIcon(amarilloVirusCiudad0);
		Lagos.setName("Lagos");
		ciudadesBtn.add(Lagos);
		game.add(Lagos);
		
		Kinsasa = new JButton();
		Kinsasa.setOpaque(falso);
		Kinsasa.setFocusPainted(falso);
		Kinsasa.setContentAreaFilled(falso);
		Kinsasa.setBorderPainted(falso);
		Kinsasa.setBounds(822,420,x,x);
		Kinsasa.setIcon(amarilloVirusCiudad0);
		Kinsasa.setName("Kinsasa");
		ciudadesBtn.add(Kinsasa);
		game.add(Kinsasa);
		
		Jartum = new JButton();
		Jartum.setOpaque(falso);
		Jartum.setFocusPainted(falso);
		Jartum.setContentAreaFilled(falso);
		Jartum.setBorderPainted(falso);
		Jartum.setBounds(768, 490,x,x);
		Jartum.setIcon(amarilloVirusCiudad0);
		Jartum.setName("Jartum");
		ciudadesBtn.add(Jartum);
		game.add(Jartum);
		
		Johannesburgo = new JButton();
		Johannesburgo.setOpaque(falso);
		Johannesburgo.setFocusPainted(falso);
		Johannesburgo.setContentAreaFilled(falso);
		Johannesburgo.setBorderPainted(falso);
		Johannesburgo.setBounds(805,570,x,x);
		Johannesburgo.setIcon(amarilloVirusCiudad0);
		Johannesburgo.setName("Johannesburgo");
		ciudadesBtn.add(Johannesburgo);
		game.add(Johannesburgo);
		
		Argel = new JButton();
		Argel.setOpaque(falso);
		Argel.setFocusPainted(falso);
		Argel.setContentAreaFilled(falso);
		Argel.setBorderPainted(falso);
		Argel.setBounds(720,323,x,x);
		Argel.setIcon(negroVirusCiudad0);
		Argel.setName("Argel");
		ciudadesBtn.add(Argel);
		game.add(Argel);
		
		Cairo = new JButton();
		Cairo.setOpaque(falso);
		Cairo.setFocusPainted(falso);
		Cairo.setContentAreaFilled(falso);
		Cairo.setBorderPainted(falso);
		Cairo.setBounds(808, 352,x,x);
		Cairo.setIcon(negroVirusCiudad0);
		Cairo.setName("Cairo");
		ciudadesBtn.add(Cairo);
		game.add(Cairo);
		
		
		Riad = new JButton();
		Riad.setOpaque(falso);
		Riad.setFocusPainted(falso);
		Riad.setContentAreaFilled(falso);
		Riad.setBorderPainted(falso);
		Riad.setBounds(905, 380, x ,x);
		Riad.setIcon(negroVirusCiudad0);
		Riad.setName("Riad");
		ciudadesBtn.add(Riad);
		game.add(Riad);
		
		Estambul = new JButton();
		Estambul.setOpaque(falso);
		Estambul.setFocusPainted(falso);
		Estambul.setContentAreaFilled(falso);
		Estambul.setBorderPainted(falso);
		Estambul.setBounds(805, 265,x,x);
		Estambul.setIcon(negroVirusCiudad0);
		Estambul.setName("Estambul");
		ciudadesBtn.add(Estambul);
		game.add(Estambul);
		
		Bagdad = new JButton();
		Bagdad.setOpaque(falso);
		Bagdad.setFocusPainted(falso);
		Bagdad.setContentAreaFilled(falso);
		Bagdad.setBorderPainted(falso);
		Bagdad.setBounds(885, 295, x, x);
		Bagdad.setIcon(negroVirusCiudad0);
		Bagdad.setName("Bagdad");
		ciudadesBtn.add(Bagdad);
		game.add(Bagdad);
		
		Moscu = new JButton();
		Moscu.setOpaque(falso);
		Moscu.setFocusPainted(falso);
		Moscu.setContentAreaFilled(falso);
		Moscu.setBorderPainted(falso);
		Moscu.setBounds(885, 210,x,x);
		Moscu.setName("Moscu");
		Moscu.setIcon(negroVirusCiudad0);
		ciudadesBtn.add(Moscu);
		game.add(Moscu);
		
		Teheran = new JButton();
		Teheran.setOpaque(falso);
		Teheran.setFocusPainted(falso);
		Teheran.setContentAreaFilled(falso);
		Teheran.setBounds(987,215,x,x);
		Teheran.setBorderPainted(falso);
		Teheran.setIcon(negroVirusCiudad0);
		Teheran.setName("Teheran");
		ciudadesBtn.add(Teheran);
		game.add(Teheran);
		
		Karachi = new JButton();
		Karachi.setOpaque(falso);
		Karachi.setFocusPainted(falso);
		Karachi.setContentAreaFilled(falso);
		Karachi.setBorderPainted(falso);
		Karachi.setBounds(965,312,x,x);
		Karachi.setName("Karachi");
		Karachi.setIcon(negroVirusCiudad0);
		ciudadesBtn.add(Karachi);
		game.add(Karachi);
		
		Bombay = new JButton();
		Bombay.setOpaque(falso);
		Bombay.setFocusPainted(falso);
		Bombay.setContentAreaFilled(falso);
		Bombay.setBorderPainted(falso);
		Bombay.setIcon(negroVirusCiudad0);
		Bombay.setBounds(995,385,x,x);
		Bombay.setName("Bombay");
		ciudadesBtn.add(Bombay);
		game.add(Bombay);
		
		Delhi = new JButton();
		Delhi.setOpaque(falso);
		Delhi.setFocusPainted(falso);
		Delhi.setContentAreaFilled(falso);
		Delhi.setBorderPainted(falso);
		Delhi.setIcon(negroVirusCiudad0);
		Delhi.setName("Delhi");
		Delhi.setBounds(1060,275,x,x);
		ciudadesBtn.add(Delhi);
		game.add(Delhi);
		
		Calcuta = new JButton();
		Calcuta.setOpaque(falso);
		Calcuta.setFocusPainted(falso);
		Calcuta.setContentAreaFilled(falso);
		Calcuta.setBorderPainted(falso);
		Calcuta.setIcon(negroVirusCiudad0);
		Calcuta.setBounds(1125,312,x,x);
		Calcuta.setName("Calcuta");
		ciudadesBtn.add(Calcuta);
		game.add(Calcuta);
		
		Madras = new JButton();
		Madras.setOpaque(falso);
		Madras.setFocusPainted(falso);
		Madras.setContentAreaFilled(falso);
		Madras.setBorderPainted(falso);
		Madras.setIcon(negroVirusCiudad0);
		Madras.setBounds(1068,420,x,x);
		Madras.setName("Madras");
		ciudadesBtn.add(Madras);
		game.add(Madras);
		
		Yakarta = new JButton();
		Yakarta.setOpaque(falso);
		Yakarta.setFocusPainted(falso);
		Yakarta.setContentAreaFilled(falso);
		Yakarta.setBorderPainted(falso);
		Yakarta.setIcon(rojoVirusCiudad0);
		Yakarta.setBounds(1130,500,x,x);
		Yakarta.setName("Yakarta");
		ciudadesBtn.add(Yakarta);
		game.add(Yakarta);
		
		Bangkok = new JButton();
		Bangkok.setOpaque(falso);
		Bangkok.setFocusPainted(falso);
		Bangkok.setContentAreaFilled(falso);
		Bangkok.setBounds(1147,390,x,x);
		Bangkok.setBorderPainted(falso);
		Bangkok.setIcon(rojoVirusCiudad0);
		Bangkok.setName("Bangkok");
		ciudadesBtn.add(Bangkok);
		game.add(Bangkok);
		
		Kong = new JButton();
		Kong.setOpaque(falso);
		Kong.setFocusPainted(falso);
		Kong.setContentAreaFilled(falso);
		Kong.setBorderPainted(falso);
		Kong.setBounds(1205,353,x,x);
		Kong.setIcon(rojoVirusCiudad0);
		Kong.setName("Kong");
		ciudadesBtn.add(Kong);
		game.add(Kong);
		
		Shanghai = new JButton();
		Shanghai.setOpaque(falso);
		Shanghai.setFocusPainted(falso);
		Shanghai.setContentAreaFilled(falso);
		Shanghai.setBorderPainted(falso);
		Shanghai.setBounds(1205,270,x,x);
		Shanghai.setIcon(rojoVirusCiudad0);
		Shanghai.setName("Shanghai");
		ciudadesBtn.add(Shanghai);
		game.add(Shanghai);
		
		Pekin = new JButton();
		Pekin.setOpaque(falso);
		Pekin.setFocusPainted(falso);
		Pekin.setContentAreaFilled(falso);
		Pekin.setBorderPainted(falso);
		Pekin.setIcon(rojoVirusCiudad0);
		Pekin.setBounds(1205,200,x,x);
		Pekin.setName("Pekin");
		ciudadesBtn.add(Pekin);
		game.add(Pekin);
		
		Seul = new JButton();
		Seul.setOpaque(falso);
		Seul.setFocusPainted(falso);
		Seul.setContentAreaFilled(falso);
		Seul.setBorderPainted(falso);
		Seul.setIcon(rojoVirusCiudad0);
		Seul.setName("Seul");
		Seul.setBounds(1295,180,x,x);
		ciudadesBtn.add(Seul);
		game.add(Seul);
		
		Tokio = new JButton();
		Tokio.setOpaque(falso);
		Tokio.setFocusPainted(falso);
		Tokio.setContentAreaFilled(falso);
		Tokio.setBorderPainted(falso);
		Tokio.setIcon(rojoVirusCiudad0);
		Tokio.setBounds(1345,240,x,x);
		Tokio.setName("Tokio");
		ciudadesBtn.add(Tokio);
		game.add(Tokio);
		
		
		Osaka = new JButton();
		Osaka.setOpaque(falso);
		Osaka.setFocusPainted(falso);
		Osaka.setContentAreaFilled(falso);
		Osaka.setBorderPainted(falso);
		Osaka.setIcon(rojoVirusCiudad0);
		Osaka.setBounds(1355,305,x,x);
		Osaka.setName("Osaka");
		ciudadesBtn.add(Osaka);
		game.add(Osaka);
		
		Taipei = new JButton();
		Taipei.setOpaque(falso);
		Taipei.setFocusPainted(falso);
		Taipei.setContentAreaFilled(falso);
		Taipei.setIcon(rojoVirusCiudad0);
		Taipei.setBorderPainted(falso);
		Taipei.setName("Taipei");
		Taipei.setBounds(1285,320,x,x);
		ciudadesBtn.add(Taipei);
		game.add(Taipei);
		
		Minh = new JButton();
		Minh.setOpaque(falso);
		Minh.setFocusPainted(falso);
		Minh.setContentAreaFilled(falso);
		Minh.setIcon(rojoVirusCiudad0);
		Minh.setBorderPainted(falso);
		Minh.setName("Minh");
		Minh.setBounds(1197,450,x,x);
		ciudadesBtn.add(Minh);
		game.add(Minh);	
		
		Manila = new JButton();
		Manila.setOpaque(falso);
		Manila.setFocusPainted(falso);
		Manila.setContentAreaFilled(falso);
		Manila.setIcon(rojoVirusCiudad0);
		Manila.setBorderPainted(falso);
		Manila.setName("Manila");
		Manila.setBounds(1293,435,x,x);
		ciudadesBtn.add(Manila);
		game.add(Manila);	
		
		Sidney = new JButton();
		Sidney.setOpaque(falso);
		Sidney.setFocusPainted(falso);
		Sidney.setContentAreaFilled(falso);
		Sidney.setIcon(rojoVirusCiudad0);
		Sidney.setBorderPainted(falso);
		Sidney.setName("Sidney");
		Sidney.setBounds(1328,583,x,x);
		ciudadesBtn.add(Sidney);
		game.add(Sidney);
		
		nuke = new JButton();
		nuke.setOpaque(falso);
		nuke.setFocusPainted(falso);
		nuke.setContentAreaFilled(falso);
		nuke.setBorderPainted(falso);
		nuke.setName("Sidney");
		nuke.setBounds(1450,650,x,x);
		nuke.setEnabled(false);
		nuke.setIcon(iconoBombaFIN);
		game.add(nuke);
		nuke.addActionListener(this);
		
		
		nuke.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				nuke.setIcon(iconoBombaFINOP);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				nuke.setIcon(iconoBombaFIN);
			}
		});
		
		
		
		// panel izquierdo botones
		JPanel botonesTexto = new JPanel();
		botonesTexto.setLayout(new FlowLayout());
		botonesTexto.setOpaque(false);
		botonesTexto.setPreferredSize(new Dimension(screen.width, screen.height / 6));
		botonesTexto.setBorder(borderRojo);

		JPanel botonCurarFinalizar = new JPanel();
		botonCurarFinalizar.setOpaque(false);
		botonCurarFinalizar.setLayout(new GridLayout(2, 1, 10, 7));

		curar.setPreferredSize(new Dimension (200, screen.height/7/2));
		curar.setIcon(IconCurarFin);
		curar.setOpaque(true);
		curar.setContentAreaFilled(false);
		curar.setBorderPainted(true);
		curar.setFocusPainted(false);
		curar.setFont(controlDatos.fuenteMC(15f));
		curar.setForeground(new Color(137,5,78));
		
		
		finalizarRonda.setPreferredSize(new Dimension (200,screen.height/7/2));
		finalizarRonda.setOpaque(true);
		finalizarRonda.setContentAreaFilled(false);
		finalizarRonda.setBorderPainted(true);
		finalizarRonda.setFocusPainted(false);
		finalizarRonda.setFont(controlDatos.fuenteMC(15f));
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
		textArea.setFont(controlDatos.fuenteMC(15.5f));

		// Color de fondo y texto
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setForeground(new Color(137, 5, 78));

		// Bordes personalizados
		Border border = BorderFactory.createLineBorder(Color.GRAY, 2);
		textArea.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(5, 5, 5, 5))); 
		textArea.setMargin(new Insets(5, 5, 5, 5)); 

		botonesTexto.add(textArea);

		JPanel DesarrollarCura = new JPanel();
		DesarrollarCura.setLayout(new GridLayout(2, 2, 10, 2));
		DesarrollarCura.setOpaque(false);
		
		DAlfa.setPreferredSize(new Dimension(200, screen.height/7/2));
		DAlfa.setIcon(iconDesarrolloAzulFIN);
		DAlfa.setOpaque(true);
		DAlfa.setContentAreaFilled(false);
		DAlfa.setBorderPainted(true);
		DAlfa.setFocusPainted(false);
		DAlfa.setFont(controlDatos.fuenteMC(15f));
		DAlfa.setForeground(new Color(137, 5, 78));

		DBeta.setPreferredSize(new Dimension(200, screen.height/7/2));
		DBeta.setIcon(iconDesarrolloRojofin);
		DBeta.setOpaque(true);
		DBeta.setContentAreaFilled(false);
		DBeta.setBorderPainted(true);
		DBeta.setFocusPainted(false);
		DBeta.setFont(controlDatos.fuenteMC(15f));
		DBeta.setForeground(new Color(137, 5, 78));

		DGamma.setPreferredSize(new Dimension(200, screen.height/7/2));
		DGamma.setIcon(iconDesarrolloAmarilloFIN);
		DGamma.setOpaque(true);
		DGamma.setContentAreaFilled(false);
		DGamma.setBorderPainted(true);
		DGamma.setFocusPainted(false);
		DGamma.setFont(controlDatos.fuenteMC(15f));
		DGamma.setForeground(new Color(137, 5, 78));

		DDelta.setPreferredSize(new Dimension(200, screen.height/7/2));
		DDelta.setIcon(iconDesarrolloNegroFIN);
		DDelta.setOpaque(true);
		DDelta.setContentAreaFilled(false);
		DDelta.setBorderPainted(true);
		DDelta.setFocusPainted(false);
		DDelta.setFont(controlDatos.fuenteMC(15f));
		DDelta.setForeground(new Color(137, 5, 78));

		DesarrollarCura.add(DAlfa);
		DesarrollarCura.add(DBeta);
		DesarrollarCura.add(DGamma);
		DesarrollarCura.add(DDelta);
		
		
		botonesTexto.add(DesarrollarCura);

		// panel derecha
		JPanel estadisticas = new JPanel(new GridBagLayout()){
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setColor(new Color(0, 0, 0, 128));
				g2d.fillRect(0, 0, getWidth(), getHeight());
				g2d.dispose();
			}
		};
		estadisticas.setOpaque(false);
		estadisticas.setBounds(0, 0, screen.width, screen.height/7);
		
		GridBagConstraints gbcEstadisticas = new GridBagConstraints();
		
		gbcEstadisticas.gridx = 0;
		gbcEstadisticas.gridy = 0;
		gbcEstadisticas.insets = new Insets(5, 10, 5, 10);
		
		JPanel ciudadesInfBrotes = new JPanel(new FlowLayout());
		ciudadesInfBrotes.setOpaque(false);
		
		JPanel ciudadesInfPanel = new JPanel();
		ciudadesInfPanel.setOpaque(false);
		
		JLabel ciudadesInfTXT = new JLabel();
		ciudadesInfTXT.setFont(controlDatos.fuenteMC(15f));
		ciudadesInfTXT.setHorizontalAlignment(JLabel.CENTER);
		ciudadesInfTXT.setVerticalAlignment(JLabel.CENTER);
		ciudadesInfTXT.setForeground(Color.white);
		ciudadesInfTXT.setText("Infectados: ");
		
		ciudadesInf.setText("0");
		ciudadesInf.setPreferredSize(new Dimension (30,30));
		ciudadesInf.setFont(controlDatos.fuenteMC(15f));
		ciudadesInf.setBorder(border);
		ciudadesInf.setHorizontalAlignment(JLabel.CENTER);
		ciudadesInf.setVerticalAlignment(JLabel.CENTER);
		ciudadesInf.setOpaque(true);
		ciudadesInf.setBackground(Color.LIGHT_GRAY);
		ciudadesInf.setForeground(Color.red);
		
		ciudadesInfPanel.add(ciudadesInfTXT);
		ciudadesInfPanel.add(ciudadesInf);
		
		JPanel brotesPanel = new JPanel(new FlowLayout());
		brotesPanel.setOpaque(false);
		
		JLabel textBrotes = new JLabel();
		textBrotes.setFont(controlDatos.fuenteMC(15f));
		textBrotes.setHorizontalAlignment(JLabel.CENTER);
		textBrotes.setVerticalAlignment(JLabel.CENTER);
		textBrotes.setForeground(Color.white);
		textBrotes.setText("Brotes: ");
		
		brotes.setText("0");
		brotes.setPreferredSize(new Dimension (30,30));
		brotes.setFont(controlDatos.fuenteMC(15f));
		brotes.setBorder(border);
		brotes.setHorizontalAlignment(JLabel.CENTER);
		brotes.setVerticalAlignment(JLabel.CENTER);
		brotes.setOpaque(true);
		brotes.setBackground(Color.LIGHT_GRAY);
		brotes.setForeground(Color.red);
		
		brotesPanel.add(textBrotes);
		brotesPanel.add(brotes);
		
		ciudadesInfBrotes.add(ciudadesInfPanel);
		ciudadesInfBrotes.add(brotesPanel);
		
		estadisticas.add(ciudadesInfBrotes, gbcEstadisticas);
		

		
		gbcEstadisticas.gridx = 1;
		estadisticas.add(brotesPanel, gbcEstadisticas);
		
		
	
		
		gbcEstadisticas.gridx = 2;
		gbcEstadisticas.insets = new Insets(10, 30, 10, 30);
		JPanel barras1 = new JPanel(new GridBagLayout());
		barras1.setOpaque(false);
		
		GridBagConstraints gbcBarras1 = new GridBagConstraints();
		
		gbcBarras1.insets = new Insets(10, 10, 10, 10);
		gbcBarras1.gridx = 0;
		gbcBarras1.gridy = 0;
		
		Alfa.setUI(new javax.swing.plaf.basic.BasicProgressBarUI() {
			protected Color getSelectionForeground() {
				return Color.black; 
			}
		});

		Alfa.setStringPainted(true);
		Alfa.setString("VIH: " + Alfa.getValue() + "%");
		Alfa.setMinimum(0); 
		Alfa.setMaximum(100);
		Alfa.setBorder(new LineBorder(new Color(79, 164, 184),3));
		Alfa.setBackground(Color.LIGHT_GRAY);
		Alfa.setFont(controlDatos.fuenteTexto(10f));
		Alfa.setValue(0);
		
		barras1.add(Alfa,gbcBarras1);
		gbcBarras1.gridy = 1;
		Beta.setStringPainted(true); // Muestra el valor actual de la barra de progreso
		Beta.setString("CANCER: " + Beta.getValue()+"%");
		Beta.setMinimum(0); // Valor mínimo de la barra de progreso
		Beta.setMaximum(100); // Valor máximo de la barra de progreso
		Beta.setValue(0);
		Beta.setBorder(new LineBorder(Color.red,3));
		Beta.setFont(controlDatos.fuenteTexto(10f));
		Beta.setBackground(Color.LIGHT_GRAY);
		Beta.setUI(new javax.swing.plaf.basic.BasicProgressBarUI() {
			protected Color getSelectionForeground() {
				return Color.black; // Cambia el color de la barra cuando progresa
			}
		});
		
		barras1.add(Beta,gbcBarras1);
		
		
		estadisticas.add(barras1, gbcEstadisticas); 
		
		gbcEstadisticas.gridx= 3;
		
		JPanel scorePanel = new JPanel(new GridBagLayout());
		scorePanel.setOpaque(false);
		
		GridBagConstraints gbcScore = new GridBagConstraints();
		
		gbcScore.gridx = 0;
		gbcScore.gridy = 0;
		gbcScore.insets = new Insets(0, 20, 2, 20);
		JLabel scoreTexto = new JLabel();
		scoreTexto.setFont(controlDatos.fuentecargar(40f));
		scoreTexto.setHorizontalAlignment(JLabel.CENTER);
		scoreTexto.setVerticalAlignment(JLabel.CENTER);
		scoreTexto.setForeground(new Color(79, 220, 100));
		scoreTexto.setText("PUNTOS");
		
		scorePanel.add(scoreTexto, gbcScore);
		gbcScore.gridy = 1;
		scoreNum.setText("0");
		scoreNum.setPreferredSize(new Dimension (300,20));
		scoreNum.setFont(controlDatos.fuenteMC(15f));
		scoreNum.setBorder(border);
		scoreNum.setHorizontalAlignment(JLabel.CENTER);
		scoreNum.setVerticalAlignment(JLabel.CENTER);
		scoreNum.setOpaque(true);
		scoreNum.setBackground(Color.LIGHT_GRAY);
		scoreNum.setForeground(Color.black);
		
		scorePanel.add(scoreNum, gbcScore);
		
		gbcScore.gridy = 2;
		
		JPanel botonesConfigInfo = new JPanel(){
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				// Dibuja la imagen de fondo
				ImageIcon iconoFondo = new ImageIcon("src\\img\\inGame\\ajustesIcono.png");
				Image imagenFondo = iconoFondo.getImage();
				g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
			}
		};
		botonesConfigInfo.setOpaque(false);
		
		JButton opciones = new JButton();
		opciones.setPreferredSize(new Dimension(25, 25));
		opciones.setOpaque(true);
		opciones.setBackground(Color.black);
		opciones.setContentAreaFilled(false);
		opciones.setBorderPainted(false);
		opciones.setFocusPainted(false);
		
		
		botonesConfigInfo.add(opciones);
		scorePanel.add(botonesConfigInfo, gbcScore);
		
		estadisticas.add(scorePanel, gbcEstadisticas);
		
		gbcEstadisticas.gridx = 4;
		
		JPanel barras2 = new JPanel(new GridBagLayout());
		barras2.setOpaque(false);
		
		GridBagConstraints gbcBarras2 = new GridBagConstraints();
		
		gbcBarras2.insets = new Insets(10, 10, 10, 10);
		gbcBarras2.gridx = 0;
		gbcBarras2.gridy = 0;
		
		Gamma.setStringPainted(true); // Muestra el valor actual de la barra de progreso
		Gamma.setString("SARS: " + Gamma.getValue()+ "%") ;
		Gamma.setMinimum(0); // Valor mínimo de la barra de progreso
		Gamma.setMaximum(100); // Valor máximo de la barra de progreso
		Gamma.setValue(0);
		Gamma.setBackground(Color.LIGHT_GRAY);
		Gamma.setBorder(new LineBorder(Color.YELLOW,3));
		Gamma.setFont(controlDatos.fuenteTexto(10f));
		Gamma.setUI(new javax.swing.plaf.basic.BasicProgressBarUI() {
			protected Color getSelectionForeground() {
				return Color.black; // Cambia el color de la barra cuando progresa
			}
		});
		
		barras2.add(Gamma, gbcBarras2);
		gbcBarras2.gridy = 1;
		
		Delta.setStringPainted(true); // Muestra el valor actual de la barra de progreso
		Delta.setString("NIGGA: " + Delta.getValue()+ "%");
		Delta.setMinimum(0); // Valor mínimo de la barra de progreso
		Delta.setMaximum(100); // Valor máximo de la barra de progreso
		Delta.setValue(0);
		Delta.setBackground(Color.LIGHT_GRAY);
		Delta.setBorder(new LineBorder(Color.black,3));
		Delta.setFont(controlDatos.fuenteTexto(10f));
		Delta.setUI(new javax.swing.plaf.basic.BasicProgressBarUI() {
			protected Color getSelectionForeground() {
				return Color.black; // Cambia el color de la barra cuando progresa
			}
		});
		
		barras2.add(Delta, gbcBarras2);
		
		estadisticas.add(barras2, gbcEstadisticas);
		
		gbcEstadisticas.gridx = 5;
		
		JPanel accionesRondas = new JPanel(new FlowLayout());
		accionesRondas.setOpaque(false);
		
		JPanel accionesPanel = new JPanel(new FlowLayout());
		accionesPanel.setOpaque(false);
		
		JLabel TextAcciones = new JLabel();
		TextAcciones.setFont(controlDatos.fuenteMC(15f));
		TextAcciones.setHorizontalAlignment(JLabel.CENTER);
		TextAcciones.setVerticalAlignment(JLabel.CENTER);
		TextAcciones.setForeground(Color.white);
		TextAcciones.setText("Acciones: ");
		
		acciones.setText("4");
		acciones.setPreferredSize(new Dimension (30,30));
		acciones.setFont(controlDatos.fuenteMC(15f));
		acciones.setBorder(border);
		acciones.setHorizontalAlignment(JLabel.CENTER);
		acciones.setVerticalAlignment(JLabel.CENTER);
		acciones.setOpaque(true);
		acciones.setBackground(Color.LIGHT_GRAY);
		acciones.setForeground(Color.red);
		
		accionesPanel.add(TextAcciones);
		accionesPanel.add(acciones);
		
		JPanel RondasPanel = new JPanel(new FlowLayout());
		RondasPanel.setOpaque(false);
		
		JLabel textRondas = new JLabel();
		textRondas.setFont(controlDatos.fuenteMC(15f));
		textRondas.setHorizontalAlignment(JLabel.CENTER);
		textRondas.setVerticalAlignment(JLabel.CENTER);
		textRondas.setForeground(Color.white);
		textRondas.setText("Rondas: ");
		
		rondas.setText("0");
		rondas.setPreferredSize(new Dimension (30,30));
		rondas.setFont(controlDatos.fuenteMC(15f));
		rondas.setBorder(border);
		rondas.setHorizontalAlignment(JLabel.CENTER);
		rondas.setVerticalAlignment(JLabel.CENTER);
		rondas.setOpaque(true);
		rondas.setBackground(Color.LIGHT_GRAY);
		rondas.setForeground(Color.red);
		
		RondasPanel.add(textRondas);
		RondasPanel.add(rondas);
		
		accionesRondas.add(accionesPanel);
		accionesRondas.add(RondasPanel);
		
		estadisticas.add(accionesRondas, gbcEstadisticas);
		

		
		game.add(estadisticas);

		JPopupMenu popupMenu = new JPopupMenu() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				// Dibuja la imagen de fondo
				ImageIcon iconoFondo = new ImageIcon("src\\img\\inGame\\fondo.jpg");
				Image imagenFondo = iconoFondo.getImage();
				g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
			}
		};
		
		JLabel iconoOpciones = new JLabel(imgFinalIcono);
		popupMenu.setOpaque(false);
		popupMenu.setPreferredSize(new Dimension(screen.width, screen.height));
		popupMenu.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		popupMenu.setLayout(new GridBagLayout());
		
		volverAlMenu = new JMenuItem("VOLVER AL MENU PRINCIPAL");
		volverAlMenu.setOpaque(false);
		volverAlMenu.setFont(controlDatos.fuentecargar(45f));
		volverAlMenu.setForeground(new Color(173, 216, 240));
		volverAlMenu.setIcon(iconoMainFIN);
		volverAlMenu.setContentAreaFilled(false);
		volverAlMenu.setBorderPainted(false);
		volverAlMenu.setFocusPainted(false);
		
		volverAlMenu.addActionListener(this);
		
		music = new JMenuItem("ACTIVADO");
		music.setOpaque(false);
		music.setFont(controlDatos.fuentecargar(45f));
		music.setForeground(new Color(173, 216, 240));
		music.setIcon(iconoMusFinal);
		music.setContentAreaFilled(false);
		music.setBorderPainted(false);
		music.setFocusPainted(false);
		
		
		
		reglas = new JMenuItem("REGLAS Y INFO");
		reglas.setOpaque(false);
		reglas.setFont(controlDatos.fuentecargar(45f));
		reglas.setForeground(new Color(173, 216, 240));
		reglas.setIcon(iconoReglasFIN);
		reglas.setContentAreaFilled(false);
		reglas.setBorderPainted(false);
		reglas.setFocusPainted(false);
		
		reglas.addActionListener(this);
		
		guardarSalir = new JMenuItem("GUARDAR Y SALIR");
		guardarSalir.setOpaque(false);
		guardarSalir.setFont(controlDatos.fuentecargar(45f));
		guardarSalir.setForeground(new Color(173, 216, 240));
		guardarSalir.setIcon(iconGuardarFIN);
		guardarSalir.setContentAreaFilled(false);
		guardarSalir.setBorderPainted(false);
		guardarSalir.setFocusPainted(false);
		
		JMenuItem volver = new JMenuItem("VOLVER AL JUEGO");
		volver.setOpaque(false);
		volver.setFont(controlDatos.fuentecargar(45f));
		volver.setForeground(new Color(173, 216, 240));
		volver.setIcon(iconVolverFIN);
		volver.setContentAreaFilled(false);
		volver.setBorderPainted(false);
		volver.setFocusPainted(false);
		GridBagConstraints gbcPopUP = new GridBagConstraints();
		
		guardarSalir.addActionListener(this);
		music.addActionListener(this);
		
		gbcPopUP.insets = new Insets(10,10,10,10);
		gbcPopUP.gridx = 0;
		gbcPopUP.gridy = 0;
		
		
		popupMenu.add(iconoOpciones,gbcPopUP);
		gbcPopUP.gridy = 1;
		popupMenu.add(volverAlMenu,gbcPopUP);
		gbcPopUP.gridy = 2;
		popupMenu.add(music,gbcPopUP);
		gbcPopUP.gridy = 3;
		popupMenu.add(reglas,gbcPopUP);
		gbcPopUP.gridy = 4;
		popupMenu.add(volver,gbcPopUP);
		gbcPopUP.gridy = 5;
		popupMenu.add(guardarSalir,gbcPopUP);

		opciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				popupMenu.show(CargarParty.game, (screen.width - screen.width / 6) / 2,
						(screen.height - screen.height / 4) / 2);
			}
		});
		
		nombre = new JPopupMenu();
		nombre.setOpaque(true);
		nombre.setPreferredSize(new Dimension(500, 500));
		nombre.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		nombre.setLayout(new GridBagLayout());



//		PrintStream printStream = new PrintStream(new OutputStream() {
//			@Override
//			public void write(int b) throws IOException {
//				new Thread(() -> {
//					textArea.append(String.valueOf((char) b));
//					int lineCount = textArea.getLineCount();
//					if (lineCount > 6) {
//						try {
//							int endOfFirstLine = textArea.getLineEndOffset(0);
//							textArea.replaceRange("", 0, endOfFirstLine);
//						} catch (Exception ex) {
//							ex.printStackTrace();
//						}
//					}
//					textArea.setCaretPosition(textArea.getDocument().getLength());
//				}).start();
//				try {
//					Thread.sleep(10);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		});
//		System.setOut(printStream);
//		System.setErr(printStream);
		
		
		DAlfa.addActionListener(this);
		DBeta.addActionListener(this);
		DGamma.addActionListener(this);
		DDelta.addActionListener(this);
		finalizarRonda.addActionListener(this);
		curar.addActionListener(this);
		
		
		//action listener de botones de ciudades
		Francisco.addActionListener(this);
		 Chicago.addActionListener(this);
		 Atlanta.addActionListener(this);
		 Montreal.addActionListener(this);
		 York.addActionListener(this);
		 Washington.addActionListener(this);
		 Londres.addActionListener(this);
		 Madrid.addActionListener(this);
		 Paris.addActionListener(this);
		 Essen.addActionListener(this);
		 Milan.addActionListener(this);
		 Petersburgo.addActionListener(this);
		 Angeles.addActionListener(this);
		 Miami.addActionListener(this);
		 Mexico.addActionListener(this);
		 Bogota.addActionListener(this);
		 Lima.addActionListener(this);
		 Santiago.addActionListener(this);
		 Aires.addActionListener(this);
		 Paulo.addActionListener(this);
		 Lagos.addActionListener(this);
		 Kinsasa.addActionListener(this);
		 Jartum.addActionListener(this);
		 Johannesburgo.addActionListener(this);
		 Argel.addActionListener(this);
		 Cairo.addActionListener(this);
		 Riad.addActionListener(this);
		 Estambul.addActionListener(this);
		 Bagdad.addActionListener(this);
		 Moscu.addActionListener(this);
		 Teheran.addActionListener(this);
		 Karachi.addActionListener(this);
		 Bombay.addActionListener(this);
		 Delhi.addActionListener(this);
		 Calcuta.addActionListener(this);
		 Madras.addActionListener(this);
		 Yakarta.addActionListener(this);
		 Bangkok.addActionListener(this);
		 Kong.addActionListener(this);
		 Shanghai.addActionListener(this);
		 Pekin.addActionListener(this);
		 Seul.addActionListener(this);
		 Tokio.addActionListener(this);
		 Osaka.addActionListener(this);
		 Taipei.addActionListener(this);
		 Minh.addActionListener(this);
		 Manila.addActionListener(this);
		 Sidney.addActionListener(this);
		

		 
		this.add(game, BorderLayout.CENTER);
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
	
	public static int ciudadNumero(String nombre) {
		for (int i = 0; i < controlPartida.datos.getCiudades().size(); i++) {
			if (controlPartida.datos.getCiudades().get(i).getNombre().equalsIgnoreCase(nombre)) {
				return i;
			}
		}
		return 0;
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
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					if (ciudadSeleccionada) {
						controlPartida.gestionar_Cura();
					} else {
						System.out.println("Franko: Selecciona una ciudad antes.");
					}

				}
			});
			vac.start();
			
			
		} else if (source == music) {
			if (musica) {
				Thread vac = new Thread(new Runnable() {

					@Override
					public void run() {
						System.out.println("Franko: Quitas lo divertido a la vida.");
						Main.reproductor.detener();
						music.setText("Desactivado");
						music.setIcon(iconoMusFinalDes);
						musica = false;

					}
				});
				vac.start();

			} else {
				Thread vac = new Thread(new Runnable() {

					@Override
					public void run() {
						System.out.println("Franko: Yeee, se siente todo muy cuadrado..");
						musica = true;
						music.setText("Activado");
						music.setIcon(iconoMusFinal);
						Main.reproductor.reproducirConRepetir();

					}
				});
				vac.start();

			}

		} else if (source == Francisco) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado San Francisco");
					controlPartida.ciudadSize = ciudadNumero("San Francisco");
					controlPartida.ciudadNombre = "Francisco";
					ciudadSeleccionada = true;
				}
			});
			vac.start();
		} else if (source == Chicago) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Chicago");
					controlPartida.ciudadSize = ciudadNumero("Chicago");
					controlPartida.ciudadNombre = "Chicago";
					ciudadSeleccionada = true;

				}
			});
			vac.start();
		} else if (source == Atlanta) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Atlanta");
					controlPartida.ciudadSize = ciudadNumero("Atlanta");
					controlPartida.ciudadNombre = "Atlanta";
					ciudadSeleccionada = true;

				}
			});
			vac.start();
		} else if (source == Montreal) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Montreal");
					controlPartida.ciudadSize = ciudadNumero("Montreal");
					controlPartida.ciudadNombre = "Montreal";
					ciudadSeleccionada = true;

				}
			});
			vac.start();
		} else if (source == York) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Nueva York");
					controlPartida.ciudadSize = ciudadNumero("Nueva York");
					controlPartida.ciudadNombre = "York";
					ciudadSeleccionada = true;

				}
			});
			vac.start();
		}  else if (source == Washington) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Washington");
					controlPartida.ciudadSize = ciudadNumero("Washington");
					controlPartida.ciudadNombre = "Washington";
					ciudadSeleccionada = true;

				}
			});
			vac.start();
		}  else if (source == Londres) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Londres");
					controlPartida.ciudadSize = ciudadNumero("Londres");
					controlPartida.ciudadNombre = "Londres";
					ciudadSeleccionada = true;

				}
			});
			vac.start();
		} else if (source == Madrid) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Madrid");
					System.out.println("Franko: Esa es mi ciudad!!");
					controlPartida.ciudadSize = ciudadNumero("Madrid");
					controlPartida.ciudadNombre = "Madrid";
					ciudadSeleccionada = true;
				}
			});
			vac.start();
		} else if (source == Paris) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Paris");
					controlPartida.ciudadSize = ciudadNumero("Paris");
					controlPartida.ciudadNombre = "Paris";
					ciudadSeleccionada = true;

				}
			});
			vac.start();
		} else if (source == Essen) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Essen");
					controlPartida.ciudadSize = ciudadNumero("Essen");
					controlPartida.ciudadNombre = "Essen";
					ciudadSeleccionada = true;


				}
			});
			vac.start();
		} else if (source == Milan) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Milan");
					controlPartida.ciudadSize = ciudadNumero("Milan");
					controlPartida.ciudadNombre = "Milan";
					ciudadSeleccionada = true;


				}
			});
			vac.start();
		} else if (source == Petersburgo) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado San Petersburgo");
					controlPartida.ciudadSize = ciudadNumero("San Petersburgo");
					controlPartida.ciudadNombre = "Petersburgo";
					ciudadSeleccionada = true;
				}
			});
			vac.start();
		} else if (source == Angeles) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Los Angeles");
					controlPartida.ciudadSize = ciudadNumero("Los Angeles");
					controlPartida.ciudadNombre = "Angeles";
					ciudadSeleccionada = true;
				}
			});
			vac.start();
		} else if (source == Miami) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Miami");
					controlPartida.ciudadSize = ciudadNumero("Miami");
					controlPartida.ciudadNombre = "Miami";
					ciudadSeleccionada = true;

				}
			});
			vac.start();
		} else if (source == Mexico) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Mexico DF");
					controlPartida.ciudadSize = ciudadNumero("Mexico DF");
					controlPartida.ciudadNombre = "Mexico";
					ciudadSeleccionada = true;


				}
			});
			vac.start();
		} else if (source == Bogota) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Bogota");
					controlPartida.ciudadSize = ciudadNumero("Bogota");
					controlPartida.ciudadNombre = "Bogota";
					ciudadSeleccionada = true;

				}
			});
			vac.start();
		} else if (source == Lima) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Lima");
					controlPartida.ciudadSize = ciudadNumero("Lima");
					controlPartida.ciudadNombre = "Lima";
					ciudadSeleccionada = true;


				}
			});
			vac.start();
		} else if (source == Santiago) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Santiago de Chile");
					controlPartida.ciudadSize = ciudadNumero("Santiago de Chile");
					controlPartida.ciudadNombre = "Santiago";
					ciudadSeleccionada = true;


				}
			});
			vac.start();
		} else if (source == Aires) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Buenos Aires");
					controlPartida.ciudadSize = ciudadNumero("Buenos Aires");
					controlPartida.ciudadNombre = "Aires";
					ciudadSeleccionada = true;


				}
			});
			vac.start();
		} else if (source == Paulo) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Sao Paulo");
					controlPartida.ciudadSize = ciudadNumero("Sao Paulo");
					controlPartida.ciudadNombre = "Paulo";
					ciudadSeleccionada = true;


				}
			});
			vac.start();
		} else if (source == Lagos) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Lagos");
					controlPartida.ciudadSize = ciudadNumero("Lagos");
					controlPartida.ciudadNombre = "Lagos";
					ciudadSeleccionada = true;


				}
			});
			vac.start();
		} else if (source == Kinsasa) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Kinsasa");
					controlPartida.ciudadSize = ciudadNumero("Kinsasa");
					controlPartida.ciudadNombre = "Kinsasa";
					ciudadSeleccionada = true;


				}
			});
			vac.start();
		} else if (source == Jartum) {
			Thread vac = new Thread(new Runnable() {


				@Override
				public void run() {
					System.out.println("Has seleccionado Jartum");
					controlPartida.ciudadSize = ciudadNumero("Jartum");
					controlPartida.ciudadNombre = "Jartum";
					ciudadSeleccionada = true;


				}
			});
			vac.start();
		} else if (source == Johannesburgo) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Johannesburgo");
					controlPartida.ciudadSize = ciudadNumero("Johannesburgo");
					controlPartida.ciudadNombre = "Johannesburgo";
					ciudadSeleccionada = true;


				}
			});
			vac.start();
		} else if (source == Argel) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Argel");
					controlPartida.ciudadSize = ciudadNumero("Argel");
					controlPartida.ciudadNombre = "Argel";
					ciudadSeleccionada = true;


				}
			});
			vac.start();
		} else if (source == Cairo) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado El Cairo");
					controlPartida.ciudadSize = ciudadNumero("El Cairo");
					controlPartida.ciudadNombre = "Cairo";
					ciudadSeleccionada = true;


				}
			});
			vac.start();
		} else if (source == Riad) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Riad");
					controlPartida.ciudadSize = ciudadNumero("Riad");
					controlPartida.ciudadNombre = "Riad";
					ciudadSeleccionada = true;


				}
			});
			vac.start();
		} else if (source == Estambul) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Estambul");
					controlPartida.ciudadSize = ciudadNumero("Estambul");
					controlPartida.ciudadNombre = "Estambul";
					ciudadSeleccionada = true;


				}
			});
			vac.start();
		} else if (source == Bagdad) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Bagdad");
					controlPartida.ciudadSize = ciudadNumero("Bagdad");
					controlPartida.ciudadNombre = "Bagdad";
					ciudadSeleccionada = true;


				}
			});
			vac.start();
		} else if (source == Moscu) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Moscu");
					controlPartida.ciudadSize = ciudadNumero("Moscu");
					controlPartida.ciudadNombre = "Moscu";
					ciudadSeleccionada = true;


				}
			});
			vac.start();
		} else if (source == Teheran) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Teheran");
					controlPartida.ciudadSize = ciudadNumero("Teheran");
					controlPartida.ciudadNombre = "Teheran";
					ciudadSeleccionada = true;


				}
			});
			vac.start();
		} else if (source == Karachi) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Karachi");
					controlPartida.ciudadSize = ciudadNumero("Karachi");
					controlPartida.ciudadNombre = "Karachi";
					ciudadSeleccionada = true;


				}
			});
			vac.start();
		} else if (source == Bombay) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Bombay");
					controlPartida.ciudadSize = ciudadNumero("Bombay");
					controlPartida.ciudadNombre = "Bombay";
					ciudadSeleccionada = true;


				}
			});
			vac.start();
		} else if (source == Delhi) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Nueva Delhi");
					controlPartida.ciudadSize = ciudadNumero("Nueva Delhi");
					controlPartida.ciudadNombre = "Delhi";
					ciudadSeleccionada = true;


				}
			});
			vac.start();
		} else if (source == Calcuta) {  
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Calcuta");
					controlPartida.ciudadSize = ciudadNumero("Calcuta");
					controlPartida.ciudadNombre = "Calcuta";
					ciudadSeleccionada = true;

				}
			});
			vac.start();
		} else if (source == Madras) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Madras");
					controlPartida.ciudadSize = ciudadNumero("Madras");
					controlPartida.ciudadNombre = "Madras";
					ciudadSeleccionada = true;

				}
			});
			vac.start();
		} else if (source == Yakarta) { 
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Yakarta");
					controlPartida.ciudadSize = ciudadNumero("Yakarta");
					controlPartida.ciudadNombre = "Yakarta";
					ciudadSeleccionada = true;

				}
			});
			vac.start();
		} else if (source == Bangkok) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Bangkok");
					controlPartida.ciudadSize = ciudadNumero("Bangkok");
					controlPartida.ciudadNombre = "Bangkok";
					ciudadSeleccionada = true;

				}
			});
			vac.start();
		} else if (source == Kong) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Hong Kong");
					controlPartida.ciudadSize = ciudadNumero("Hong Kong");
					controlPartida.ciudadNombre = "Kong";
					ciudadSeleccionada = true;

				}
			});
			vac.start();
		} else if (source == Shanghai) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Shanghai");
					controlPartida.ciudadSize = ciudadNumero("Shanghai");
					controlPartida.ciudadNombre = "Shanghai";
					ciudadSeleccionada = true;

				}
			});
			vac.start();
		} else if (source == Pekin) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Pekin");
					controlPartida.ciudadSize = ciudadNumero("Pekin");
					controlPartida.ciudadNombre = "Pekin";
					ciudadSeleccionada = true;

				}
			});
			vac.start();
		}else if (source == Seul) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Seul");
					controlPartida.ciudadSize = ciudadNumero("Seul");
					controlPartida.ciudadNombre = "Seul";
					ciudadSeleccionada = true;

				}
			});
			vac.start();
		}else if (source == Tokio) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Tokio");
					controlPartida.ciudadSize = ciudadNumero("Tokio");
					controlPartida.ciudadNombre = "Tokio";
					ciudadSeleccionada = true;
				}
			});
			vac.start();
		}else if (source == Osaka) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Osaka");
					controlPartida.ciudadSize = ciudadNumero("Osaka");
					controlPartida.ciudadNombre = "Osaka";
					ciudadSeleccionada = true;

				}
			});
			vac.start();
		}else if (source == Taipei) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Taipei");
					controlPartida.ciudadSize = ciudadNumero("Taipei");
					controlPartida.ciudadNombre = "Taipei";
					ciudadSeleccionada = true;

				}
			});
			vac.start();
		}else if (source == Minh) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Ho Chi Minh");
					controlPartida.ciudadSize = ciudadNumero("Ho Chi Minh");
					controlPartida.ciudadNombre = "Minh";
					ciudadSeleccionada = true;

				}
			});
			vac.start();
		}else if (source == Manila) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Manila");
					controlPartida.ciudadSize = ciudadNumero("Manila");
					controlPartida.ciudadNombre = "Manila";
					ciudadSeleccionada = true;

				}
			});
			vac.start();
		} else if (source == Sidney) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Sidney");
					controlPartida.ciudadSize = ciudadNumero("Sidney");
					controlPartida.ciudadNombre = "Sidney";
					ciudadSeleccionada = true;

				}
			});
			vac.start();
		} else if (source == volverAlMenu) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					Main.cargarPrincipal.setVisible(true);
					controlPartida.resetGame = true;
					partidaReglas = false;
	    	        Timer timer = new Timer(300, new ActionListener() {
	    	            public void actionPerformed(ActionEvent e) {
	    					CargarParty.game.setVisible(false);
	    					
	    	            }
	    	        });
	    	        timer.setRepeats(false);
	    	        timer.start();

				}
			});
			vac.start();
		} else if (source == guardarSalir) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					usuarioNombre.setVisible(true);
					CargarParty.game.setVisible(false);
					partidaReglas = false;

				}
			});
			vac.start();
		} else if (source == nuke) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					controlPartida.nuke();
				}
			});
			vac.start();
		} else if (source == reglas) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					Main.CargarReglas.setVisible(true);
					CargarParty.game.setVisible(false);
					partidaReglas = true;


				}
			});
			vac.start();
		}
	}
}
