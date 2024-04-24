import java.awt.*;
import javax.swing.*;

public class CargarParty {

    public static JFrame frameCargarParty;
    
    public CargarParty() {
    	
        Dimension screen1 = Toolkit.getDefaultToolkit().getScreenSize();

        frameCargarParty = new JFrame();
        frameCargarParty.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameCargarParty.setSize(screen1.width, screen1.height);
        frameCargarParty.setUndecorated(true);
        frameCargarParty.setResizable(true);
        
        JPanel panelgeneral = new JPanel(new GridLayout(2, 3));

        ImageIcon iconoFondo = new ImageIcon("fondo.gif");
        Image imagenFondo = iconoFondo.getImage().getScaledInstance(800, 650, Image.SCALE_SMOOTH);
        ImageIcon imgFinalFondo = new ImageIcon(imagenFondo);
        JLabel labelFondo = new JLabel(imgFinalFondo);
        frameCargarParty.add(labelFondo, BorderLayout.CENTER);
        
        
        ImageIcon gifIcon = new ImageIcon("giftry.gif");
        
        
        JLabel gifLabel1 = new JLabel(gifIcon);   
        gifLabel1.setHorizontalAlignment(JLabel.CENTER); // Centrar la imagen horizontalmente
        panelgeneral.add(gifLabel1);

        JLabel gifLabel2 = new JLabel(gifIcon);
        gifLabel2.setHorizontalAlignment(JLabel.CENTER); // Centrar la imagen horizontalmente
        panelgeneral.add(gifLabel2);
        
        JLabel gifLabel3 = new JLabel(gifIcon);
        gifLabel3.setHorizontalAlignment(JLabel.CENTER); // Centrar la imagen horizontalmente
        panelgeneral.add(gifLabel3);

        JPanel panel1 = new JPanel(new BorderLayout());
        JLabel label1 = new JLabel("<html><div style='text-align: center; padding-top: 20px; font-size: 18px;'>¡Bienvenido al modo Chupete! Aquí, las epidemias se manejan con facilidad y los desafíos son prácticamente inexistentes. ¡Relájate mientras te paseas por el jardín de infancia del juego y crees que eres un héroe!");
        JButton button1 = new JButton("JUGAR");
        button1.setOpaque(false);
        button1.setContentAreaFilled(false);
        button1.setBorderPainted(false);
        button1.setFocusPainted(false);
        panel1.add(label1, BorderLayout.NORTH); // Cambié panel1 a label1
        panel1.add(button1, BorderLayout.CENTER);
        label1.setHorizontalAlignment(SwingConstants.CENTER); // Establezco la alineación en label1
        panelgeneral.add(panel1);
        
        JPanel panel2 = new JPanel(new BorderLayout());
        JLabel label2 = new JLabel("<html><div style='text-align: center; padding-top: 20px; font-size: 18px;'>Enfréntate a la pandemia como un adulto decente. Este modo es para aquellos que necesitan un poco de emoción en sus vidas, pero aún así no quieren demasiado estrés. Vamos, ¡ponte los pantalones grandes y afronta el desafío!");
        JButton button2 = new JButton("JUGAR");
        button2.setOpaque(false);
        button2.setContentAreaFilled(false);
        button2.setBorderPainted(false);
        button2.setFocusPainted(false);
        panel2.add(label2, BorderLayout.NORTH);
        panel2.add(button2, BorderLayout.CENTER);
        label2.setHorizontalAlignment(JLabel.CENTER);
        panelgeneral.add(panel2);

        JPanel panel3 = new JPanel(new BorderLayout());
        JLabel label3 = new JLabel("<html><div style='text-align: center; padding-top: 20px; font-size: 18px;'>¿Crees que eres lo suficientemente rudo para este juego? Bienvenido al modo Patea-Traseros, donde cada decisión puede ser tu última. Si quieres jugar con los grandes, prepárate para sufrir, ¡porque aquí solo los más duros sobreviven!");
        JButton button3 = new JButton("JUGAR");
        button3.setOpaque(false);
        button3.setContentAreaFilled(false);
        button3.setBorderPainted(false);
        button3.setFocusPainted(false);
        panel3.add(label3, BorderLayout.NORTH);
        panel3.add(button3, BorderLayout.CENTER);
        label3.setHorizontalAlignment(JLabel.CENTER);
        panelgeneral.add(panel3);

        frameCargarParty.getContentPane().add(panelgeneral, BorderLayout.CENTER);

        frameCargarParty.setVisible(true);
        frameCargarParty.setLocationRelativeTo(null);
        frameCargarParty.setVisible(false);
    }
}
