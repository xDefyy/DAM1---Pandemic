import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class fondo extends JFrame {
	fondo() {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		
		JLayeredPane capas = new JLayeredPane();
		capas.setPreferredSize(new Dimension(screen));
		capas.setBackground(Color.gray);
		
		JPanel panelFondo = new JPanel();
        panelFondo.setBackground(new Color(0, 0, 0, 128)); // Color de fondo transparente con un poco de opacidad
        panelFondo.setBounds(0, 0, screen.width, screen.height); // Establece el tamaño y la posición del panel
        
        capas.add(panelFondo, JLayeredPane.DEFAULT_LAYER);
		
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLUE); // Color de fondo azul para el panel
        panel.setBounds(100, 100, 200, 200); // Establece el tamaño y la posición del panel dentro del JLayeredPane
        ImageIcon playButtom = new ImageIcon("play.png");
        capas.add(panel, JLayeredPane.DEFAULT_LAYER);
        Font buttonFont = new Font("Arial", Font.BOLD, 14);
		Color buttonForeground = new Color(0,0,0,0);
		JButton play = new JButton("JUGAR");
		play.setIcon(playButtom);
		play.setBackground(buttonForeground);
		play.setOpaque(false);
		play.setContentAreaFilled(false);
		play.setBorderPainted(false);
		play.setFocusPainted(false);
		play.setFocusPainted(false);
		
		add(capas);
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); //siempre centro
		setResizable(false); //no se puede ajustar
		setExtendedState(JFrame.MAXIMIZED_BOTH); //pantalla completa
		setUndecorated(true); //quita la barra de arriba
		setVisible(true);
		setTitle("Pandemic @Kader, @Liqi");
	}
}
