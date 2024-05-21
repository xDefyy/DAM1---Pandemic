package intefaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import CargaDatos.controlDatos;
import controladores.controlPartida;
import inicio.Main;

/**
 * @author Liqi y Kader
 * 
 */

public class ganarPerder extends JFrame implements ActionListener {
	
	public static String userFinal = "";
	public static JPanel general = new JPanel();
	
	ganarPerder() {
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		
		ImageIcon iconoIcono = new ImageIcon("src\\img\\inGame\\icono.png");
		Image imagenIcono = iconoIcono.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
		ImageIcon imgFinalIcono = new ImageIcon(imagenIcono);
		
		general = new JPanel(new BorderLayout()) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				// Dibuja la imagen de fondo
				ImageIcon iconoFondo = new ImageIcon("src\\img\\nuevaPartida\\fondo.jpg");
				Image imagenFondo = iconoFondo.getImage();
				g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
			}
		};
		general.setOpaque(false);
		general.setPreferredSize(screen);
		
		
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
				general.removeAll();
				Timer timer = new Timer(300, new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						partida.winLoseFrame.setVisible(false);
					}
				});
				timer.setRepeats(false);
				timer.start();
			}
		});
		
		JPanel botonVolver = new JPanel();
		botonVolver.setBackground(Color.black);
		botonVolver.add(volver);
		
		
		this.add(general, BorderLayout.CENTER);
		this.add(botonVolver, BorderLayout.SOUTH);
		
		
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
		Object source = e.getSource();
		
		if (source == pantallaCargar.btnConfirmar) {
			controlDatos.deleteGame(pantallaCargar.idpartida2, pantallaCargar.idPlayer);
			partida.winLoseFrame.setVisible(false);
			Main.cargarPrincipal.setVisible(true);
			general.removeAll();
			general.repaint();
			general.revalidate();
			
			
		} else if (source == controlPartida.enviar) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					String user = controlPartida.text.getText();
					userFinal = user;
					
					ArrayList<String> usuarios = new ArrayList<>(controlDatos.nombresUser());
					boolean nombreRept = false;
					for (int i = 0; i < usuarios.size(); i++) {
						if (userFinal.equalsIgnoreCase(usuarios.get(i))) {
							JOptionPane.showMessageDialog(null, "Nombre Existente", "Alerta",
									JOptionPane.ERROR_MESSAGE);
							nombreRept = true;
							break;
						}
 					}
					
					if (userFinal.length() > 10 || userFinal.length() == 0 || userFinal.contains(" ")) {
						JOptionPane.showMessageDialog(null, "NO se puede más de 10 letras, o dejarlo en blanco, ni espacios", "Alerta",
								JOptionPane.ERROR_MESSAGE);
					} else if (userFinal.length() < 10 && userFinal.length() > 0 && !nombreRept) {
						JOptionPane.showMessageDialog(null, "Se ha guardado como: " + userFinal, "Info",
								JOptionPane.INFORMATION_MESSAGE);
						
						controlDatos.guardarPartida(userFinal);
						nombreRept = false;
						controlDatos.ganar_perder = "W";
						Timer timer = new Timer(100, new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								Main.cargarPrincipal.setVisible(true);
								controlPartida.resetGame = true;
								partida.winLoseFrame.setVisible(false);
								general.removeAll();
								general.repaint();
								general.revalidate();
								controlPartida.resetGame();
								
							}
						});
						timer.setRepeats(false);
						timer.start();
						
					}

					controlPartida.text.setText("username");
				}
			});
			vac.start();
		}
		
	}
	
}
