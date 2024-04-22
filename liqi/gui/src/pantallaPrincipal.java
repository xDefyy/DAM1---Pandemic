import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class pantallaPrincipal extends JFrame {
    
	pantallaPrincipal(){
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

        
        // Crear panel de opciones
        JPanel opciones = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Dibuja la imagen de fondo
                ImageIcon iconoFondo = new ImageIcon("src\\img\\FondoJuego.jfif");
                Image imagenFondo = iconoFondo.getImage();
                g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
            }
        };
        opciones.setOpaque(false);
        opciones.setPreferredSize(new Dimension(screen.width/4, screen.height));
        opciones.setLayout(new GridBagLayout());
        
        // Agregar contenido al panel de opciones
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        
        // Icono
        ImageIcon iconoIcono = new ImageIcon("src\\img\\icono.png");
        Image imagenIcono = iconoIcono.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        ImageIcon imgFinalIcono = new ImageIcon(imagenIcono);
        JLabel labelIcono = new JLabel(imgFinalIcono);
        opciones.add(labelIcono, gbc);
        
        
        gbc.gridy++;
        JButton button1 = new JButton("PLAY");
        button1.setBackground(new Color(0,0,0,0));
        button1.setOpaque(false);
        button1.setContentAreaFilled(false);
        button1.setBorderPainted(false);
        button1.setFocusPainted(false);
        opciones.add(button1, gbc);
        
        gbc.gridy++;
        JButton button2 = new JButton("LOAD GAME");
        button2.setBackground(new Color(0,0,0,0));
        button2.setOpaque(false);
        button2.setContentAreaFilled(false);
        button2.setBorderPainted(false);
        button2.setFocusPainted(false);
        opciones.add(button2, gbc);
        
        gbc.gridy++;
        JButton button3 = new JButton("RULES");
        button3.setBackground(new Color(0,0,0,0));
        button3.setOpaque(false);
        button3.setContentAreaFilled(false);
        button3.setBorderPainted(false);
        button3.setFocusPainted(false);
        opciones.add(button3, gbc);
        
        gbc.gridy++;
        JButton button4 = new JButton("EXIT");
        button4.setBackground(new Color(0,0,0,0));
        button4.setOpaque(false);
        button4.setContentAreaFilled(false);
        button4.setBorderPainted(false);
        button4.setFocusPainted(false);
        opciones.add(button4, gbc);
        
        button4.addActionListener(new ActionListener() {  //Esto hace que el boton este a la espera para hacer la funcion de abajo
            public void actionPerformed(ActionEvent e) {
            	System.exit(0);
            }
        });
        
        JLabel verCre = new JLabel();
		verCre.setText("Ver 1.0 @Kader, @Liqi");
		verCre.setFont(new Font("Arial", Font.ITALIC, 10));
		verCre.setForeground(Color.gray);
		verCre.setOpaque(true);
		verCre.setBackground(Color.black);
        
		this.add(verCre, BorderLayout.SOUTH);
        // Agregar el panel de opciones al centro de la ventana principal
        this.getContentPane().add(opciones, BorderLayout.CENTER);
        
        // Establecer el tamaño de la ventana y hacerla visible
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
