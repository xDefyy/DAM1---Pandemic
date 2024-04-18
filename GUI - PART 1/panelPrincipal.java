

	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	public class panelPrincipal extends JPanel implements ActionListener {

	    private JButton buttonPlay;
	    private JButton buttonRules;
	    private JButton buttonExit;

	    public panelPrincipal() {
	        // Configuración del panel principal con GridBagLayout para centrar los botones
	        setLayout(new BorderLayout());
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.gridwidth = GridBagConstraints.REMAINDER;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.insets = new Insets(10, 10, 10, 10);

	        // Creación de los botones
	        buttonPlay = new JButton("Jugar");
	        buttonRules = new JButton("Reglas");
	        buttonExit = new JButton("Salir");

	        // Agregar ActionListener a los botones
	        buttonPlay.addActionListener(this);
	        buttonRules.addActionListener(this);
	        buttonExit.addActionListener(this);

	        // Agregar los botones al panel principal
	        add(buttonPlay, gbc);
	        add(buttonRules, gbc);
	        add(buttonExit, gbc);
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        if (e.getSource() == buttonPlay) {

	        } else if (e.getSource() == buttonExit) {

	        } else {

	        }
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> {
	            JFrame frame = new JFrame("Centrar Botones");
	            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            frame.setSize(800, 700);
	            frame.setLocationRelativeTo(null);
	            frame.getContentPane().add(new panelPrincipal());
	            frame.setVisible(true);
	        });
	    }
	}

