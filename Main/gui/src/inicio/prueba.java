package inicio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class prueba {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Menú de Opciones");
        JButton button = new JButton("Abrir Menú");

        // Crear un menú emergente
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem menuItem1 = new JMenuItem("Opción 1");
        JMenuItem menuItem2 = new JMenuItem("Opción 2");
        JMenuItem menuItem3 = new JMenuItem("Opción 3");
        popupMenu.add(menuItem1);
        popupMenu.add(menuItem2);
        popupMenu.add(menuItem3);

        // Agregar un evento al botón para mostrar el menú emergente
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener la posición del botón
                int x = button.getLocationOnScreen().x;
                int y = button.getLocationOnScreen().y;

                // Calcular la posición para centrar el menú emergente
                x += (button.getWidth() - popupMenu.getWidth()) / 2;
                y += (button.getHeight() - popupMenu.getHeight()) / 2;

                // Mostrar el menú emergente en la posición centrada
                popupMenu.show(frame, x, y);
            }
        });

        // Agregar el botón al marco
        frame.add(button);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Centrar el marco en la pantalla
        frame.setVisible(true);
    }
}
