import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class pantallaPrincipal extends JFrame {

	pantallaPrincipal() {
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		
		ImageIcon iconoIcono = new ImageIcon("virus.png");
		Image imagenIcono = iconoIcono.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon imgFinalIcono = new ImageIcon(imagenIcono);
		
		ImageIcon fondoGame = new ImageIcon("FondoJuego.jpg");
		Image fondoRescalado = fondoGame.getImage().getScaledInstance(screen.width, screen.height, Image.SCALE_SMOOTH);
		
		ImageIcon playButtom = new ImageIcon("play.png");
		ImageIcon rulesButtom = new ImageIcon("rules.png");
		
		JPanel fondo = new JPanel();
		fondo.setSize(screen.width,screen.height);
		fondo.setLayout(new BorderLayout());
		
		JLabel pantalla = new JLabel(new ImageIcon(fondoRescalado));
		fondo.add(pantalla, BorderLayout.CENTER);
		
		JLabel logo = new JLabel();
		logo.setBackground(new Color(0, 0, 0, 0));
		logo.setOpaque(true);
		logo.setText("PANDEMIC");
		logo.setIcon(imgFinalIcono);
		logo.setBounds(0, 0, screen.width / 4, screen.height);
		logo.setVerticalAlignment(JLabel.TOP);
		logo.setHorizontalAlignment(JLabel.CENTER);
		logo.setHorizontalTextPosition(JLabel.CENTER);
		logo.setVerticalTextPosition(JLabel.BOTTOM);
		logo.setFont(new Font("Arial", Font.BOLD, 40));
		logo.setForeground(Color.white);
		logo.setIconTextGap(25);
		logo.setBorder(new EmptyBorder(50, 10, 10, 10));
		
		JPanel opciones = new JPanel();
		opciones.setSize(screen.width/4,screen.height);
		opciones.setBackground(new Color(0,0,0,128));
		opciones.setLayout(new BorderLayout());
		

		
		opciones.add(logo, BorderLayout.NORTH);
		
		fondo.add(opciones, BorderLayout.WEST);
		
        add(fondo, BorderLayout.CENTER);
        
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
