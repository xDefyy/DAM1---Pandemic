package intefaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import CargaDatos.controlDatos;
import controladores.controlPartida;
import inicio.Main;

/**
 * @author Liqi y Kader
 * 
 */

public class usuarioGetName extends JFrame implements ActionListener {

	public static JButton submt;
	public static JTextField campoTexto;
	public static String userFinal;

	usuarioGetName() {
		ImageIcon iconoVolver = new ImageIcon("src\\img\\main\\volver.png");
		Image iconoVolverES = iconoVolver.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		ImageIcon iconVolverFIN = new ImageIcon(iconoVolverES);
		ImageIcon iconoVolverOP = new ImageIcon("src\\img\\main\\volverOP.png");
		Image iconoVolverESOP = iconoVolverOP.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		ImageIcon iconVolverOP = new ImageIcon(iconoVolverESOP);
		ImageIcon iconoIcono = new ImageIcon("src\\img\\inGame\\icono.png");
		Image imagenIcono = iconoIcono.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
		ImageIcon imgFinalIcono = new ImageIcon(imagenIcono);

		JPanel fondo = new JPanel(new GridBagLayout()) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				// Dibuja la imagen de fondo
				ImageIcon iconoFondo = new ImageIcon("src\\img\\nuevaPartida\\fondo.jpg");
				Image imagenFondo = iconoFondo.getImage();
				g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
			}
		};

		GridBagConstraints gbcFondo = new GridBagConstraints();

		gbcFondo.gridx = 0;
		gbcFondo.gridy = 0;
		gbcFondo.insets = new Insets(10, 10, 10, 10);

		JLabel labelIcono = new JLabel(imgFinalIcono);
		fondo.add(labelIcono, gbcFondo);

		gbcFondo.gridy = 1;

		JPanel nombre = new JPanel(new FlowLayout());
		nombre.setOpaque(false);
		submt = new JButton("Enviar");
		submt.setIcon(iconVolverFIN);
		submt.setOpaque(false);
		submt.setContentAreaFilled(false);
		submt.setBorderPainted(false);
		submt.setFocusPainted(false);
		submt.setFont(controlDatos.fuentecargar(45f));
		submt.setForeground(new Color(137, 5, 78));

		submt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				submt.setForeground(new Color(200, 5, 78));
				submt.setIcon(iconVolverFIN);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				submt.setForeground(new Color(137, 5, 78));
				submt.setIcon(iconVolverOP);
			}
		});

		campoTexto = new JTextField();
		campoTexto.setText("username");
		campoTexto.setFont(controlDatos.fuenteMC(15.5f));
		campoTexto.setPreferredSize(new Dimension(200, 50));
		campoTexto.setForeground(Color.black);
		campoTexto.setBackground(new Color(240, 240, 240));
		nombre.add(campoTexto);
		nombre.add(submt);

		fondo.add(nombre, gbcFondo);

		submt.addActionListener(this);

		this.add(fondo);

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

		if (source == submt) {
			Thread vac = new Thread(new Runnable() {

				@Override
				public void run() {
					String user = campoTexto.getText();
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
						
						controlDatos.guardarPartida();
						nombreRept = false;
						
						Timer timer = new Timer(100, new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								Main.cargarPrincipal.setVisible(true);
								controlPartida.resetGame = true;
								partida.usuarioNombre.setVisible(false);
								
							}
						});
						timer.setRepeats(false);
						timer.start();
						
					}

					campoTexto.setText("username");
				}
			});
			vac.start();
		}

	}

}
