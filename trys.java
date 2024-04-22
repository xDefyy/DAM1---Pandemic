package trys;

import javax.swing.*;
import java.awt.*;

public class trys {
    public static void main(String[] args) {
        JFrame frame = new JFrame("MAIN");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Cargar el archivo GIF
        ImageIcon gifIcon = new ImageIcon("src\\3516359429.gif");

        // Crear un JLabel para mostrar el GIF
        JLabel gifLabel = new JLabel(gifIcon);

        // Agregar el JLabel al centro del JFrame
        frame.getContentPane().add(gifLabel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}