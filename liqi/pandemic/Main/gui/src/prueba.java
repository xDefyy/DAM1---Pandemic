import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class prueba extends JFrame {
    prueba() {
        // Creamos un JPanel para contener los botones
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Orientación vertical

        // Creamos los botones
        JButton button1 = new JButton("Hola");
        button1.setBackground(new Color(0, 0, 0, 0));
        button1.setOpaque(false);
        button1.setContentAreaFilled(false);
        button1.setBorderPainted(false);
        button1.setFocusPainted(false);

        JButton button2 = new JButton("Adios");
        button2.setBackground(new Color(0, 0, 0, 0));
        button2.setOpaque(false);
        button2.setContentAreaFilled(false);
        button2.setBorderPainted(false);
        button2.setFocusPainted(false);

        // Añadimos los botones al panel
        panel.add(button1);
        panel.add(button2);

        // Añadimos el panel al JFrame
        add(panel);

        // Configuramos la ventana
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); // siempre al centro
        this.setResizable(false); // no se puede ajustar
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); // pantalla completa
        this.setUndecorated(true); // quita la barra de arriba
        this.setVisible(true);
        this.setTitle("Pandemic @Kader, @Liqi");
    }
    //TODO 
}
