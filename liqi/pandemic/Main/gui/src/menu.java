import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class menu extends JFrame {

	menu() {

		// dimension x pantalla
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

		// llamada al fondo de pantalla
		ImageIcon fondoGame = new ImageIcon("FondoJuego.jpg");
		Image fondoRescalado = fondoGame.getImage().getScaledInstance(screen.width, screen.height, Image.SCALE_SMOOTH);

		// creacion de label para poner fondo de pantalla
		JLabel fondoPantalla = new JLabel();
		fondoPantalla.setIcon(new ImageIcon(fondoRescalado));
		fondoPantalla.setVerticalAlignment(JLabel.TOP);
		fondoPantalla.setHorizontalAlignment(JLabel.LEFT);
		fondoPantalla.setBounds(0, 0, screen.width, screen.height);

		JLabel verCre = new JLabel();
		verCre.setHorizontalTextPosition(JLabel.CENTER);
		verCre.setText("Ver 1.0 @Kader, @Liqi");
		verCre.setFont(new Font("Arial", Font.ITALIC, 10));
		verCre.setForeground(Color.gray);
		FontMetrics metrica = verCre.getFontMetrics(verCre.getFont());
		int difverCrecapas = metrica.getHeight();
		int posyText = screen.height - difverCrecapas - 10;
		int posxText = (screen.width / 4) / 2 - (verCre.getPreferredSize().width / 2);
		verCre.setBounds(posxText, posyText, screen.width / 4, difverCrecapas);

		// llamada al icono y hacer
		ImageIcon iconoIcono = new ImageIcon("virus.png");
		Image imagenIcono = iconoIcono.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon imgFinalIcono = new ImageIcon(imagenIcono);

		JLabel labelIconoTitulo = new JLabel();
		labelIconoTitulo.setBackground(new Color(0, 0, 0, 128));
		labelIconoTitulo.setOpaque(true);
		labelIconoTitulo.setText("PANDEMIC");
		labelIconoTitulo.setIcon(imgFinalIcono);
		labelIconoTitulo.setBounds(0, 0, screen.width / 4, screen.height);
		labelIconoTitulo.setVerticalAlignment(JLabel.TOP);
		labelIconoTitulo.setHorizontalAlignment(JLabel.CENTER);
		labelIconoTitulo.setHorizontalTextPosition(JLabel.CENTER);
		labelIconoTitulo.setVerticalTextPosition(JLabel.BOTTOM);
		labelIconoTitulo.setFont(new Font("Arial", Font.BOLD, 40));
		labelIconoTitulo.setForeground(Color.white);
		labelIconoTitulo.setIconTextGap(25);
		labelIconoTitulo.setBorder(new EmptyBorder(50, 10, 10, 10));

		Dimension labelIcono = labelIconoTitulo.getPreferredSize();
		int labelIconoY = labelIcono.height;
		
		ImageIcon playButtom = new ImageIcon("play.png");
		
		
		// creacion de panel
		JPanel opciones = new JPanel();
		opciones.setBackground(new Color(0,0,0,0));
		opciones.setLayout(null);
		opciones.setBounds(0, labelIconoY, screen.width / 4, screen.height);
		
		// Botones
		JButton play = new JButton();
		JButton rules = new JButton();
		JButton exit = new JButton();
		
		
		play.setOpaque(false);
		play.setContentAreaFilled(false); 
		play.setBorderPainted(false); 
		play.setFocusPainted(false); 
		play.setIcon(playButtom);
		
		
        
		int buttonWidth = 100; 
		int labelCenterX = labelIconoTitulo.getX() + labelIconoTitulo.getWidth() / 2; 

		play.setBounds(labelCenterX - buttonWidth / 2, 10, buttonWidth, 40);
		rules.setBounds(labelCenterX - buttonWidth / 2, 60, buttonWidth, 40);
		exit.setBounds(labelCenterX - buttonWidth / 2, 110, buttonWidth, 40);
		
        
        opciones.add(play);
        opciones.add(rules);
        opciones.add(exit);
        
		// creacion de capas
		JLayeredPane capas = new JLayeredPane();
		capas.setBounds(0, 0, screen.width, screen.height);

		capas.add(fondoPantalla, Integer.valueOf(0));
		capas.add(opciones, Integer.valueOf(1));
		capas.add(labelIconoTitulo, Integer.valueOf(1));
		capas.add(verCre, Integer.valueOf(2));

		this.add(capas);
		
		this.setLayout(null);
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
