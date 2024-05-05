package inicio;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class prueba {
    prueba() {
        JFrame frame = new JFrame("Custom TextArea Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea textArea = new JTextArea(10, 40);
        textArea.setEditable(false); // Hacer el JTextArea no editable
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Obtener el StyledDocument del JTextArea
        StyledDocument styledDocument = (StyledDocument) textArea.getDocument(); // Casting a StyledDocument

        // Crear un estilo para cambiar el color y el tamaño del texto
        Style style = styledDocument.addStyle("CustomStyle", null); // Aquí es styledDocument.addStyle()

        StyleConstants.setForeground(style, Color.RED); // Cambiar el color del texto a rojo
        StyleConstants.setFontSize(style, 16); // Cambiar el tamaño de la fuente a 16 puntos

        // Insertar texto con estilo en el JTextArea
        try {
            styledDocument.insertString(styledDocument.getLength(), "Texto con estilo.\n", style);
            styledDocument.insertString(styledDocument.getLength(), "Otro texto con estilo.\n", style);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new prueba();
        });
    }
}
