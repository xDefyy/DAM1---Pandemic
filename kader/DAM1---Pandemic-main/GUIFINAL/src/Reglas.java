import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.GridLayout;
import javax.swing.*;

public class Reglas extends JFrame {
    
    public static JFrame frame2;
    
    public Reglas() {
        Dimension screen1 = Toolkit.getDefaultToolkit().getScreenSize();
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setResizable(true);
        
        JPanel panelgeneral = new JPanel(); 
        panelgeneral.setLayout(new GridLayout(2,2));
        
        JButton btn1 = new JButton("Nigga  ");
        JButton btn2 = new JButton("Nigga 2");
        JButton btn3 = new JButton("Nigga 3");
       
        
        this.setLocationRelativeTo(null);
        this.setVisible(false);
    }
}
