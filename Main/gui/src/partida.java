import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class partida extends JFrame {
	partida() {
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		ImageIcon iconoIcono = new ImageIcon("src\\img\\icono.png");
	    Image imagenIcono = iconoIcono.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
	    ImageIcon imgFinalIcono = new ImageIcon(imagenIcono);
	    
		JPanel game = new JPanel() {
			@Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            // Dibuja la imagen de fondo
	            ImageIcon iconoFondo = new ImageIcon("src\\img\\FondoJuego.jfif");
	            Image imagenFondo = iconoFondo.getImage();
	            g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
	        }
		};
		game.setLayout(new BorderLayout());
		
		JPanel botones = new JPanel();
		botones.setBackground(Color.blue);
		botones.setLayout(new GridBagLayout());
		botones.setOpaque(false);
		botones.setPreferredSize(new Dimension (screen.width / 4, screen.height));
		
		JButton curar = new JButton();
		JButton desarrollarVacuna = new JButton();
//		JButton evento = new JButton(); si nos da tiempo 
		
		
		this.add(botones, BorderLayout.WEST);
		this.add(game, BorderLayout.CENTER);

		
		this.setSize(screen.width, screen.height);
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
