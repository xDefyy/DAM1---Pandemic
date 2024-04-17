import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class panelPrincipal extends JPanel implements ActionListener {

    private JButton buttonPlay;
    private JButton buttonRules;
    private JButton buttonExit;

    public panelPrincipal() {
        setLayout(new BorderLayout());

        buttonPlay = new JButton("Jugar");
        buttonRules = new JButton("Reglas");
        buttonExit = new JButton("Salir");

        buttonPlay.addActionListener(this);
        buttonRules.addActionListener(this);
        buttonExit.addActionListener(this);

        // Panel para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(null); // BoxLayout horizontal
        buttonPanel.add(Box.createHorizontalGlue()); // Espacio rígido al principio
        buttonPanel.add(buttonPlay);
        buttonPlay.setBounds(20, 10, 10, 10);
        buttonPanel.add(buttonRules);
        buttonRules.setBounds(10, 10, 10, 10);
        buttonPanel.add(buttonExit);
        buttonRules.setBounds(0, 100, 10, 10);

        // Panel para centrar los botones verticalmente
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(buttonPanel, BorderLayout.CENTER);

        add(centerPanel, BorderLayout.SOUTH);

        ImageIcon icono = new ImageIcon("C:\\Users\\alumnat\\Desktop\\carti.jpg");
        JLabel etiquetaImagen = new JLabel(icono);
        etiquetaImagen.setHorizontalAlignment(SwingConstants.CENTER);
        add(etiquetaImagen, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonPlay) {
            // Acción para el botón "Jugar"
            // Por ejemplo:
            // textField.setText("¡Has pulsado Jugar!");
        } else if (e.getSource() == buttonExit) {
            // Acción para el botón "Salir"
            // Por ejemplo:
            // JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
            // frame.dispose();
        } else {
            // Acción para otros botones
            // Por ejemplo:
            // System.out.println("Has pulsado otro botón");
        }
    }
}
