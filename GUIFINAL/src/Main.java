import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {
    
    public static JFrame frameMain = new JFrame();
    public static CargarParty cargarParty = new CargarParty();
    public static Reglas CargarReglas = new Reglas();
    
    public static void main(String args[]){
        
        Dimension screen1 = Toolkit.getDefaultToolkit().getScreenSize();
        
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMain.setSize(screen1.width, screen1.height);
        frameMain.setLocationRelativeTo(null);
        frameMain.setResizable(false);
        
        JPanel panelright = new JPanel(new BorderLayout());
        panelright.setBackground(Color.gray);
        panelright.setPreferredSize(new Dimension(800,600));
        
        ImageIcon iconoFondo = new ImageIcon("FondoJuego.jpg");
        Image imagenFondo = iconoFondo.getImage().getScaledInstance(800, 650, Image.SCALE_SMOOTH);
        ImageIcon imgFinalFondo = new ImageIcon(imagenFondo);
        JLabel labelFondo = new JLabel(imgFinalFondo);
        panelright.add(labelFondo, BorderLayout.CENTER);
        
        JPanel panelleft = new JPanel();
        panelleft.setBackground(Color.black);
        panelleft.setPreferredSize(new Dimension(200, 300));
        
        frameMain.add(panelleft, BorderLayout.WEST);
        frameMain.add(panelright, BorderLayout.EAST);
        
        // Icono
        ImageIcon iconoIcono = new ImageIcon("icono.png");
        Image imagenIcono = iconoIcono.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon imgFinalIcono = new ImageIcon(imagenIcono);
        JLabel labelIcono = new JLabel(imgFinalIcono);
        
        panelleft.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        
        panelleft.add(labelIcono, gbc);
        
        gbc.gridy++;
        JLabel titulo = new JLabel("PANDEMIC");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setForeground(Color.WHITE);
        panelleft.add(titulo, gbc);
        
        gbc.gridy++;
        JButton button1 = new JButton("JUGAR");
        button1.setOpaque(false);
        button1.setContentAreaFilled(false);
        button1.setBorderPainted(false);
        button1.setFocusPainted(false);
        button1.setForeground(Color.WHITE);
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	cargarParty.frameCargarParty.setVisible(true); // Hacer visible frameCargarParty a través de la instancia de CargarParty
            }
        });
        
        panelleft.add(button1, gbc);
        
        gbc.gridy++;
        JButton button2 = new JButton("REGLAS");
        button2.setOpaque(false);
        button2.setContentAreaFilled(false);
        button2.setBorderPainted(false);
        button2.setFocusPainted(false);
        button2.setForeground(Color.WHITE);
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	CargarReglas.frameReglas.setVisible(true); // Muestra el frame de Reglas
            }
        });
        
        panelleft.add(button2, gbc);
        
        gbc.gridy++;
        JButton button3 = new JButton("SALIR");
        button3.setOpaque(false);
        button3.setContentAreaFilled(false);
        button3.setBorderPainted(false);
        button3.setFocusPainted(false);
        button3.setForeground(Color.WHITE);        
        
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                WindowEvent close = new WindowEvent(frameMain, WindowEvent.WINDOW_CLOSING);
                Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(close);
            }
        });
        
        panelleft.add(button3, gbc);
        
        frameMain.setVisible(true);
    }
}
