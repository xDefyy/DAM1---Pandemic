package inicio;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class prueba {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Crear una ventana
            JFrame frame = new JFrame("MatteBorder con Imagen");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1000, 1000);
            
            JPanel v = new JPanel();
            v.setPreferredSize(new Dimension (300,300));
            // Crear una etiqueta para mostrar la imagen
            JLabel imageLabel = new JLabel("Hola, soy una etiqueta con una imagen de fondo");
            imageLabel.setHorizontalAlignment(JLabel.CENTER); // Centrar el texto
            imageLabel.setVerticalAlignment(JLabel.CENTER);
            
            v.add(imageLabel);
            // Cargar la imagen
            ImageIcon icon = new ImageIcon("src\\img\\inGame\\borderJeringa.png"); // Ruta de la imagen
            Image fondo = icon.getImage().getScaledInstance(300, 90, Image.SCALE_SMOOTH);
            ImageIcon asda = new ImageIcon(fondo);
            // Crear un borde MatteBorder con una imagen de fondo
            Border border = BorderFactory.createMatteBorder(30, 30, 10, 30, asda); // Márgenes y la imagen de fondo
            
            // Establecer el borde en la etiqueta de imagen
            imageLabel.setBorder(border);

            // Establecer el diseño de la ventana
            frame.setLayout(new BorderLayout());
            // Agregar la etiqueta de imagen a la ventana
            frame.add(v, BorderLayout.CENTER);

            frame.setVisible(true);
        });
    }
}
