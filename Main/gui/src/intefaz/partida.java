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
	public static JLabel brotes;
	public static JLabel ciudadesInf;
	public static boolean ciudadSeleccionada = false;
	// botones
	JButton Francisco;
	JButton Chicago;
	JButton Atlanta;
	JButton Montreal;
	JButton NuevaYork;
	JButton Washington;
	JButton Londres;
	JButton Madrid;
	JButton Paris;
	JButton Essen;
	JButton Milan;
	JButton Petersburgo;
	JButton Angeles;
	JButton Miami;
	JButton Mexico;
	JButton Bogota;
	JButton Lima;
	JButton Santiago;
	JButton BuenosAires;
	JButton Paulo;
	JButton Lagos;
	JButton Kinsasa;
	JButton Jartum;
	JButton Johannesburgo;
	JButton Argel;
	JButton Cairo;
	JButton Riad;
	JButton Estambul;
	JButton Bagdad;
	JButton Moscu;
	JButton Teheran;
	JButton Karachi;
	JButton Bombay;
	JButton Delhi;
	JButton Calcuta;
	JButton Madras;
	JButton Yakarta;
	JButton Bangkok;
	JButton HongKong;
	JButton Shanghai;
	JButton Pekin;
	JButton Seul;
	JButton Tokio;
	JButton Osaka;
	JButton Taipei;
	JButton Minh;
	JButton Manila;
	JButton Sidney;

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
		boolean falso = false;
		int x = 50;
		ButtonGroup ciudadesBtn = new ButtonGroup();
		//botones
		Francisco = new JButton();
		Francisco.setOpaque(falso);
		Francisco.setFocusPainted(falso);
		Francisco.setContentAreaFilled(falso);
		Francisco.setBorderPainted(falso);
		Francisco.setBounds(105,205,x,x);
		ciudadesBtn.add(Francisco);
		game.add(Francisco);
		 
		Chicago = new JButton();
		Chicago.setOpaque(falso);
		Chicago.setFocusPainted(falso);
		Chicago.setContentAreaFilled(falso);
		Chicago.setBorderPainted(falso);
		Chicago.setBounds(195,175,x,x);
		ciudadesBtn.add(Chicago);
		game.add(Chicago);
		
		Atlanta = new JButton();
		Atlanta.setOpaque(falso);
		Atlanta.setFocusPainted(falso);
		Atlanta.setContentAreaFilled(falso);
		Atlanta.setBorderPainted(falso);
		Atlanta.setBounds(250, 260, x,x);
		ciudadesBtn.add(Atlanta);
		game.add(Atlanta);
		
		Montreal = new JButton();
		Montreal.setOpaque(falso);
		Montreal.setFocusPainted(falso);
		Montreal.setContentAreaFilled(falso);
		Montreal.setBorderPainted(falso);
		Montreal.setBounds(305,205,x,x);
		ciudadesBtn.add(Montreal);
		game.add(Montreal);
		
		NuevaYork = new JButton();
		NuevaYork.setOpaque(falso);
		NuevaYork.setFocusPainted(falso);
		NuevaYork.setContentAreaFilled(falso);
		NuevaYork.setBorderPainted(falso);
		NuevaYork.setBounds(385, 195, x ,x );
		ciudadesBtn.add(NuevaYork);
		game.add(NuevaYork);
		
		Washington = new JButton();
		Washington.setOpaque(falso);
		Washington.setFocusPainted(falso);
		Washington.setContentAreaFilled(falso);
		Washington.setBorderPainted(falso);
		Washington.setBounds(375, 275,x,x);
		ciudadesBtn.add(Washington);
		game.add(Washington);
		
		Londres = new JButton();
		Londres.setOpaque(falso);
		Londres.setFocusPainted(falso);
		Londres.setContentAreaFilled(falso);
		Londres.setBorderPainted(falso);
		Londres.setBounds(550,190,x,x);
		ciudadesBtn.add(Londres);
		game.add(Londres);
		
		Madrid = new JButton();
		Madrid.setOpaque(falso);
		Madrid.setFocusPainted(falso);
		Madrid.setContentAreaFilled(falso);
		Madrid.setBorderPainted(falso);
		Madrid.setBounds(535, 270, x,x);
		ciudadesBtn.add(Madrid);
		game.add(Madrid);
		
		Paris = new JButton();
		Paris.setOpaque(falso);
		Paris.setFocusPainted(falso);
		Paris.setContentAreaFilled(falso);
		Paris.setBorderPainted(falso);
		Paris.setBounds(605,225,x,x);
		ciudadesBtn.add(Paris);
		game.add(Paris);
		
		Essen = new JButton();
		Essen.setOpaque(falso);
		Essen.setFocusPainted(falso);
		Essen.setContentAreaFilled(falso);
		Essen.setBorderPainted(falso);
		Essen.setBounds(630, 155,x,x);
		ciudadesBtn.add(Essen);
		game.add(Essen);
		
		Milan = new JButton();
		Milan.setOpaque(falso);
		Milan.setFocusPainted(falso);
		Milan.setContentAreaFilled(falso);
		Milan.setBorderPainted(falso);
		Milan.setBounds(670, 205,x,x);
		ciudadesBtn.add(Milan);
		game.add(Milan);
		
		Petersburgo = new JButton();
		Petersburgo.setOpaque(falso);
		Petersburgo.setFocusPainted(falso);
		Petersburgo.setContentAreaFilled(falso);
		Petersburgo.setBorderPainted(falso);
		Petersburgo.setBounds(745, 125,x,x);
		ciudadesBtn.add(Petersburgo);
		game.add(Petersburgo);
		
		
		Angeles = new JButton();
		Angeles.setOpaque(falso);
		Angeles.setFocusPainted(falso);
		Angeles.setContentAreaFilled(falso);
		Angeles.setBorderPainted(falso);
		Angeles.setBounds(135, 275,x,x);
		ciudadesBtn.add(Angeles);
		game.add(Angeles);
		
		Miami = new JButton();
		Miami.setOpaque(falso);
		Miami.setFocusPainted(falso);
		Miami.setContentAreaFilled(falso);
		Miami.setBorderPainted(falso);
		Miami.setBounds(300,312,x,x);
		ciudadesBtn.add(Miami);
		game.add(Miami);
		
		Mexico = new JButton();
		Mexico.setOpaque(falso);
		Mexico.setFocusPainted(falso);
		Mexico.setContentAreaFilled(falso);
		Mexico.setBorderPainted(falso);
		Mexico.setBounds(225,335, x,x);
		ciudadesBtn.add(Mexico);
		game.add(Mexico);
		
		Bogota = new JButton();
		Bogota.setOpaque(falso);
		Bogota.setFocusPainted(falso);
		Bogota.setContentAreaFilled(falso);
		Bogota.setBorderPainted(falso);
		Bogota.setBounds(320,430,x,x);
		ciudadesBtn.add(Bogota);
		game.add(Bogota);
		
		Lima = new JButton();
		Lima.setOpaque(falso);
		Lima.setFocusPainted(falso);
		Lima.setContentAreaFilled(falso);
		Lima.setBorderPainted(falso);
		Lima.setBounds(280, 490, x ,x);
		ciudadesBtn.add(Lima);
		game.add(Lima);
		
		Santiago = new JButton();
		Santiago.setOpaque(falso);
		Santiago.setFocusPainted(falso);
		Santiago.setContentAreaFilled(falso);
		Santiago.setBorderPainted(falso);
		Santiago.setBounds(305, 615, x ,x);
		ciudadesBtn.add(Santiago);
		game.add(Santiago);
		
		BuenosAires = new JButton();
		BuenosAires.setOpaque(falso);
		BuenosAires.setFocusPainted(falso);
		BuenosAires.setContentAreaFilled(falso);
		BuenosAires.setBorderPainted(falso);
		BuenosAires.setBounds(390, 590,x,x);
		ciudadesBtn.add(BuenosAires);
		game.add(BuenosAires);
		
		Paulo = new JButton();
		Paulo.setOpaque(falso);
		Paulo.setFocusPainted(falso);
		Paulo.setContentAreaFilled(falso);
		Paulo.setBorderPainted(falso);
		Paulo.setBounds(425,520,x,x);
		ciudadesBtn.add(Paulo);
		game.add(Paulo);
		
		Lagos = new JButton();
		Lagos.setOpaque(falso);
		Lagos.setFocusPainted(falso);
		Lagos.setContentAreaFilled(falso);
		Lagos.setBorderPainted(falso);
		Lagos.setBounds(585, 425,x,x);
		ciudadesBtn.add(Lagos);
		game.add(Lagos);
		
		Kinsasa = new JButton();
		Kinsasa.setOpaque(falso);
		Kinsasa.setFocusPainted(falso);
		Kinsasa.setContentAreaFilled(falso);
		Kinsasa.setBorderPainted(falso);
		Kinsasa.setBounds(695,425,x,x);
		ciudadesBtn.add(Kinsasa);
		game.add(Kinsasa);
		
		Jartum = new JButton();
		Jartum.setOpaque(falso);
		Jartum.setFocusPainted(falso);
		Jartum.setContentAreaFilled(falso);
		Jartum.setBorderPainted(falso);
		Jartum.setBounds(650, 490,x,x);
		ciudadesBtn.add(Jartum);
		game.add(Jartum);
		
		Johannesburgo = new JButton();
		Johannesburgo.setOpaque(falso);
		Johannesburgo.setFocusPainted(falso);
		Johannesburgo.setContentAreaFilled(falso);
		Johannesburgo.setBorderPainted(falso);
		Johannesburgo.setBounds(685,565,x,x);
		ciudadesBtn.add(Johannesburgo);
		game.add(Johannesburgo);
		
		Argel = new JButton();
		Argel.setOpaque(falso);
		Argel.setFocusPainted(falso);
		Argel.setContentAreaFilled(falso);
		Argel.setBorderPainted(falso);
		Argel.setBounds(605,320,x,x);
		ciudadesBtn.add(Argel);
		game.add(Argel);
		
		Cairo = new JButton();
		Cairo.setOpaque(falso);
		Cairo.setFocusPainted(falso);
		Cairo.setContentAreaFilled(falso);
		Cairo.setBorderPainted(falso);
		Cairo.setBounds(675, 355,x,x);
		ciudadesBtn.add(Cairo);
		game.add(Cairo);
		
		
		Riad = new JButton();
		Riad.setOpaque(falso);
		Riad.setFocusPainted(falso);
		Riad.setContentAreaFilled(falso);
		Riad.setBorderPainted(falso);
		Riad.setBounds(765, 385, x ,x);
		ciudadesBtn.add(Riad);
		game.add(Riad);
		
		Estambul = new JButton();
		Estambul.setOpaque(falso);
		Estambul.setFocusPainted(falso);
		Estambul.setContentAreaFilled(falso);
		Estambul.setBorderPainted(falso);
		Estambul.setBounds(680, 270,x,x);
		ciudadesBtn.add(Estambul);
		game.add(Estambul);
		
		Bagdad = new JButton();
		Bagdad.setOpaque(falso);
		Bagdad.setFocusPainted(falso);
		Bagdad.setContentAreaFilled(falso);
		Bagdad.setBorderPainted(falso);
		Bagdad.setBounds(755, 295, x, x);
		ciudadesBtn.add(Bagdad);
		game.add(Bagdad);
		
		Moscu = new JButton();
		Moscu.setOpaque(falso);
		Moscu.setFocusPainted(falso);
		Moscu.setContentAreaFilled(falso);
		Moscu.setBorderPainted(falso);
		Moscu.setBounds(755, 210,x,x);
		ciudadesBtn.add(Moscu);
		game.add(Moscu);
		
		Teheran = new JButton();
		Teheran.setOpaque(falso);
		Teheran.setFocusPainted(falso);
		Teheran.setContentAreaFilled(falso);
		Teheran.setBounds(850,210,x,x);
		Teheran.setBorderPainted(falso);
		ciudadesBtn.add(Teheran);
		game.add(Teheran);
		
		Karachi = new JButton();
		Karachi.setOpaque(falso);
		Karachi.setFocusPainted(falso);
		Karachi.setContentAreaFilled(falso);
		Karachi.setBorderPainted(falso);
		Karachi.setBounds(825,305,x,x);
		ciudadesBtn.add(Karachi);
		game.add(Karachi);
		
		Bombay = new JButton();
		Bombay.setOpaque(falso);
		Bombay.setFocusPainted(falso);
		Bombay.setContentAreaFilled(falso);
		Bombay.setBorderPainted(falso);
		Bombay.setBounds(840,385,x,x);
		ciudadesBtn.add(Bombay);
		game.add(Bombay);
		
		Delhi = new JButton();
		Delhi.setOpaque(falso);
		Delhi.setFocusPainted(falso);
		Delhi.setContentAreaFilled(falso);
		Delhi.setBorderPainted(falso);
		Delhi.setBounds(910,275,x,x);
		ciudadesBtn.add(Delhi);
		game.add(Delhi);
		
		Calcuta = new JButton();
		Calcuta.setOpaque(falso);
		Calcuta.setFocusPainted(falso);
		Calcuta.setContentAreaFilled(falso);
		Calcuta.setBorderPainted(falso);
		Calcuta.setBounds(965,310,x,x);
		ciudadesBtn.add(Calcuta);
		game.add(Calcuta);
		
		Madras = new JButton();
		Madras.setOpaque(falso);
		Madras.setFocusPainted(falso);
		Madras.setContentAreaFilled(falso);
		Madras.setBorderPainted(falso);
		Madras.setBounds(910,425,x,x);
		ciudadesBtn.add(Madras);
		game.add(Madras);
		
		Yakarta = new JButton();
		Yakarta.setOpaque(falso);
		Yakarta.setFocusPainted(falso);
		Yakarta.setContentAreaFilled(falso);
		Yakarta.setBorderPainted(falso);
		Yakarta.setBounds(955,500,x,x);
		ciudadesBtn.add(Yakarta);
		game.add(Yakarta);
		
		Bangkok = new JButton();
		Bangkok.setOpaque(falso);
		Bangkok.setFocusPainted(falso);
		Bangkok.setContentAreaFilled(falso);
		Bangkok.setBounds(975,395,x,x);
		Bangkok.setBorderPainted(falso);
		ciudadesBtn.add(Bangkok);
		game.add(Bangkok);
		
		HongKong = new JButton();
		HongKong.setOpaque(falso);
		HongKong.setFocusPainted(falso);
		HongKong.setContentAreaFilled(falso);
		HongKong.setBorderPainted(falso);
		HongKong.setBounds(1030,355,x,x);
		ciudadesBtn.add(HongKong);
		game.add(HongKong);
		
		Shanghai = new JButton();
		Shanghai.setOpaque(falso);
		Shanghai.setFocusPainted(falso);
		Shanghai.setContentAreaFilled(falso);
		Shanghai.setBorderPainted(falso);
		Shanghai.setBounds(1030,275,x,x);
		ciudadesBtn.add(Shanghai);
		game.add(Shanghai);
		
		Pekin = new JButton();
		Pekin.setOpaque(falso);
		Pekin.setFocusPainted(falso);
		Pekin.setContentAreaFilled(falso);
		Pekin.setBorderPainted(falso);
		Pekin.setBounds(1030,200,x,x);
		ciudadesBtn.add(Pekin);
		game.add(Pekin);
		
		Seul = new JButton();
		Seul.setOpaque(falso);
		Seul.setFocusPainted(falso);
		Seul.setContentAreaFilled(falso);
		Seul.setBorderPainted(falso);
		Seul.setBounds(1100,175,x,x);
		ciudadesBtn.add(Seul);
		game.add(Seul);
		
		Tokio = new JButton();
		Tokio.setOpaque(falso);
		Tokio.setFocusPainted(falso);
		Tokio.setContentAreaFilled(falso);
		Tokio.setBorderPainted(falso);
		Tokio.setBounds(1150,240,x,x);
		ciudadesBtn.add(Tokio);
		game.add(Tokio);
		
		
		Osaka = new JButton();
		Osaka.setOpaque(falso);
		Osaka.setFocusPainted(falso);
		Osaka.setContentAreaFilled(falso);
		Osaka.setBorderPainted(falso);
		Osaka.setBounds(1160,300,x,x);
		ciudadesBtn.add(Osaka);
		game.add(Osaka);
		
		Taipei = new JButton();
		Taipei.setOpaque(falso);
		Taipei.setFocusPainted(falso);
		Taipei.setContentAreaFilled(falso);
		Taipei.setBorderPainted(falso);
		Taipei.setBounds(1100,320,x,x);
		ciudadesBtn.add(Taipei);
		game.add(Taipei);
		
		Minh = new JButton();
		Minh.setOpaque(falso);
		Minh.setFocusPainted(falso);
		Minh.setContentAreaFilled(falso);
		Minh.setBorderPainted(falso);
		Minh.setBounds(1030,450,x,x);
		ciudadesBtn.add(Minh);
		game.add(Minh);	
		
		Manila = new JButton();
		Manila.setOpaque(falso);
		Manila.setFocusPainted(falso);
		Manila.setContentAreaFilled(falso);
		Manila.setBorderPainted(falso);
		Manila.setBounds(1100,430,x,x);
		ciudadesBtn.add(Manila);
		game.add(Manila);	
		
		Sidney = new JButton();
		Sidney.setOpaque(falso);
		Sidney.setFocusPainted(falso);
		Sidney.setContentAreaFilled(falso);
		Sidney.setBorderPainted(falso);
		Sidney.setBounds(1130,580,x,x);
		ciudadesBtn.add(Sidney);
		game.add(Sidney);
		
		
		
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
		textArea.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(5, 5, 5, 5))); 
		textArea.setMargin(new Insets(5, 5, 5, 5)); 

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
		ciudadesInf = new JLabel();
		ciudadesInf.setText("Ciudades Infectadas: " ); 
		ciudadesInf.setFont(new Font("Arial", Font.BOLD, 15));

		stats.add(ciudadesInf, gbcStats);
		
		gbcStats.gridy = 2;
		brotes = new JLabel();
		brotes.setText("Brotes: "); // TODO METER VARIABLE DE SCORE
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
		
		volverAlMenu = new JMenuItem("MENU");
		volverAlMenu.setOpaque(false);
		volverAlMenu.setFont(controlDatos.fuentecargar());
		volverAlMenu.setForeground(new Color(173, 216, 240));
		volverAlMenu.setIcon(iconoMusFinal);
		volverAlMenu.setContentAreaFilled(false);
		volverAlMenu.setBorderPainted(false);
		volverAlMenu.setFocusPainted(false);
		
		volverAlMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Adios");
			}
		});
		
		music = new JMenuItem("ACTIVADO");
		music.setOpaque(false);
		music.setFont(controlDatos.fuentecargar());
		music.setForeground(new Color(173, 216, 240));
		music.setIcon(iconoMusFinal);
		music.setContentAreaFilled(false);
		music.setBorderPainted(false);
		music.setFocusPainted(false);
		
		
		reglas = new JMenuItem("REGLAS");
		reglas.setOpaque(false);
		reglas.setFont(controlDatos.fuentecargar());
		reglas.setForeground(new Color(173, 216, 240));
		reglas.setIcon(iconoMusFinal);
		reglas.setContentAreaFilled(false);
		reglas.setBorderPainted(false);
		reglas.setFocusPainted(false);
		
		guardarSalir = new JMenuItem("GUARDAR Y SALIR");
		guardarSalir.setOpaque(false);
		guardarSalir.setFont(controlDatos.fuentecargar());
		guardarSalir.setForeground(new Color(173, 216, 240));
		guardarSalir.setIcon(iconoMusFinal);
		guardarSalir.setContentAreaFilled(false);
		guardarSalir.setBorderPainted(false);
		guardarSalir.setFocusPainted(false);
		
		GridBagConstraints gbcPopUP = new GridBagConstraints();
		
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
		popupMenu.add(guardarSalir,gbcPopUP);

		opciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				popupMenu.show(CargarParty.game, (screen.width - screen.width / 6) / 2,
						(screen.height - screen.height / 4) / 2);
			}
		});
		
		
		stats.add(opciones, gbcStats);



		PrintStream printStream = new PrintStream(new OutputStream() {
			@Override
			public void write(int b) throws IOException {
				new Thread(() -> {
					textArea.append(String.valueOf((char) b));
					int lineCount = textArea.getLineCount();
					if (lineCount > 6) {
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
		
		
		//action listener de botones de ciudades
		Francisco.addActionListener(this);
		 Chicago.addActionListener(this);
		 Atlanta.addActionListener(this);
		 Montreal.addActionListener(this);
		 NuevaYork.addActionListener(this);
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
		 BuenosAires.addActionListener(this);
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
		 HongKong.addActionListener(this);
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
	
	private static int ciudadNombre(String nombre) {
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
					controlPartida.ciudadSize = ciudadNombre("San Francisco");
					ciudadSeleccionada = true;
				}
			});
			vac.start();
		} else if (source == Chicago) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Chicago");
					controlPartida.ciudadSize = ciudadNombre("Chicago");
					ciudadSeleccionada = true;

				}
			});
			vac.start();
		} else if (source == Atlanta) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Atlanta");
					controlPartida.ciudadSize = ciudadNombre("Atlanta");
					ciudadSeleccionada = true;

				}
			});
			vac.start();
		} else if (source == Montreal) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Montreal");
					controlPartida.ciudadSize = ciudadNombre("Montreal");
					ciudadSeleccionada = true;

				}
			});
			vac.start();
		} else if (source == NuevaYork) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Nueva York");
					controlPartida.ciudadSize = ciudadNombre("Nueva York");
					ciudadSeleccionada = true;

				}
			});
			vac.start();
		}  else if (source == Washington) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Washington");
					controlPartida.ciudadSize = ciudadNombre("Washington");
					ciudadSeleccionada = true;

				}
			});
			vac.start();
		}  else if (source == Londres) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Londres");
					controlPartida.ciudadSize = ciudadNombre("Londres");
					ciudadSeleccionada = true;

				}
			});
			vac.start();
		} else if (source == Madrid) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Madrid");
					System.out.println("Franko: Ese es mi país!!");
					controlPartida.ciudadSize = ciudadNombre("Madrid");
					ciudadSeleccionada = true;
				}
			});
			vac.start();
		} else if (source == Paris) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Paris");
					controlPartida.ciudadSize = ciudadNombre("Paris");
					ciudadSeleccionada = true;

				}
			});
			vac.start();
		} else if (source == Essen) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Essen");
					controlPartida.ciudadSize = ciudadNombre("Essen");
					ciudadSeleccionada = true;


				}
			});
			vac.start();
		} else if (source == Milan) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Milan");
					controlPartida.ciudadSize = ciudadNombre("Milan");
					ciudadSeleccionada = true;


				}
			});
			vac.start();
		} else if (source == Petersburgo) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado San Petersburgo");
					controlPartida.ciudadSize = ciudadNombre("San Petersburgo");
					ciudadSeleccionada = true;
				}
			});
			vac.start();
		} else if (source == Angeles) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Los Angeles");
					controlPartida.ciudadSize = ciudadNombre("Los Angeles");
					ciudadSeleccionada = true;
				}
			});
			vac.start();
		} else if (source == Miami) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Miami");
					controlPartida.ciudadSize = ciudadNombre("Miami");
					ciudadSeleccionada = true;

				}
			});
			vac.start();
		} else if (source == Mexico) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Mexico DF");
					controlPartida.ciudadSize = ciudadNombre("Mexico DF");
					ciudadSeleccionada = true;


				}
			});
			vac.start();
		} else if (source == Bogota) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Bogota");
					controlPartida.ciudadSize = ciudadNombre("Bogota");
					ciudadSeleccionada = true;

				}
			});
			vac.start();
		} else if (source == Lima) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Lima");
					controlPartida.ciudadSize = ciudadNombre("Lima");
					ciudadSeleccionada = true;


				}
			});
			vac.start();
		} else if (source == Santiago) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Santiago de Chile");
					controlPartida.ciudadSize = ciudadNombre("Santiago de Chile");
					ciudadSeleccionada = true;


				}
			});
			vac.start();
		} else if (source == BuenosAires) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Buenos Aires");
					controlPartida.ciudadSize = ciudadNombre("Buenos Aires");
					ciudadSeleccionada = true;


				}
			});
			vac.start();
		} else if (source == Paulo) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Sao Paulo");
					controlPartida.ciudadSize = ciudadNombre("Sao Paulo");
					ciudadSeleccionada = true;


				}
			});
			vac.start();
		} else if (source == Lagos) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Lagos");
					controlPartida.ciudadSize = ciudadNombre("Lagos");
					ciudadSeleccionada = true;


				}
			});
			vac.start();
		} else if (source == Kinsasa) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Kinsasa");
					controlPartida.ciudadSize = ciudadNombre("Kinsasa");
					ciudadSeleccionada = true;


				}
			});
			vac.start();
		} else if (source == Jartum) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Jartum");
					controlPartida.ciudadSize = ciudadNombre("Jartum");
					ciudadSeleccionada = true;


				}
			});
			vac.start();
		} else if (source == Johannesburgo) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Johannesburgo");
					controlPartida.ciudadSize = ciudadNombre("Johannesburgo");
					ciudadSeleccionada = true;


				}
			});
			vac.start();
		} else if (source == Argel) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Argel");
					controlPartida.ciudadSize = ciudadNombre("Argel");
					ciudadSeleccionada = true;


				}
			});
			vac.start();
		} else if (source == Cairo) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado El Cairo");
					controlPartida.ciudadSize = ciudadNombre("El Cairo");
					ciudadSeleccionada = true;


				}
			});
			vac.start();
		} else if (source == Riad) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Riad");
					controlPartida.ciudadSize = ciudadNombre("Riad");
					ciudadSeleccionada = true;


				}
			});
			vac.start();
		} else if (source == Estambul) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Estambul");
					controlPartida.ciudadSize = ciudadNombre("Estambul");
					ciudadSeleccionada = true;


				}
			});
			vac.start();
		} else if (source == Bagdad) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Bagdad");
					controlPartida.ciudadSize = ciudadNombre("Bagdad");
					ciudadSeleccionada = true;


				}
			});
			vac.start();
		} else if (source == Moscu) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Moscu");
					controlPartida.ciudadSize = ciudadNombre("Moscu");
					ciudadSeleccionada = true;


				}
			});
			vac.start();
		} else if (source == Teheran) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Teheran");
					controlPartida.ciudadSize = ciudadNombre("Teheran");
					ciudadSeleccionada = true;


				}
			});
			vac.start();
		} else if (source == Karachi) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Karachi");
					controlPartida.ciudadSize = ciudadNombre("Karachi");
					ciudadSeleccionada = true;


				}
			});
			vac.start();
		} else if (source == Bombay) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Bombay");
					controlPartida.ciudadSize = ciudadNombre("Bombay");
					ciudadSeleccionada = true;


				}
			});
			vac.start();
		} else if (source == Delhi) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Has seleccionado Miami");
					controlPartida.ciudadSize = ciudadNombre("Miami");
					ciudadSeleccionada = true;


				}
			});
			vac.start();
		} else if (source == Calcuta) { //TODO 
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Soy Calcuta");

				}
			});
			vac.start();
		} else if (source == Madras) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Soy Madras");

				}
			});
			vac.start();
		} else if (source == Yakarta) { //TODO
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Soy Yakarta");

				}
			});
			vac.start();
		} else if (source == Bangkok) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Soy Bangkok");

				}
			});
			vac.start();
		} else if (source == HongKong) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Soy HongKong");

				}
			});
			vac.start();
		} else if (source == Shanghai) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Soy Shanghai");

				}
			});
			vac.start();
		} else if (source == Pekin) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Soy Pekin");

				}
			});
			vac.start();
		}else if (source == Seul) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Soy Seul");

				}
			});
			vac.start();
		}else if (source == Tokio) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Soy Tokio");

				}
			});
			vac.start();
		}else if (source == Osaka) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Soy Osaka");

				}
			});
			vac.start();
		}else if (source == Taipei) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Soy Taipei");

				}
			});
			vac.start();
		}else if (source == Minh) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Soy Minh");

				}
			});
			vac.start();
		}else if (source == Manila) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Soy Manila");

				}
			});
			vac.start();
		} else if (source == Sidney) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Soy Sidney");

				}
			});
			vac.start();
		}
	}

}
