import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import java.awt.BorderLayout;

public class progressBar {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Progress Bar Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel(new BorderLayout());

        JProgressBar progressBar = new JProgressBar();
        progressBar.setStringPainted(true); // Muestra el valor actual de la barra de progreso
        progressBar.setMinimum(0); // Valor mínimo de la barra de progreso
        progressBar.setMaximum(100); // Valor máximo de la barra de progreso
        progressBar.setValue(0); // Valor inicial de la barra de progreso
        
        panel.add(progressBar, BorderLayout.CENTER);

        frame.getContentPane().add(panel);
        frame.setVisible(true);

        // Simula el progreso
        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    for (int i = 0; i <= 100; i++) {
                        progressBar.setValue(i); // Actualiza el valor de la barra de progreso
                        Thread.sleep(50); // Espera un momento para simular el progreso
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}



//Thread thread = new Thread(new Runnable() {
//    public void run() {
//        try {
//            for (int i = 0; i <= 100; i++) {
//                Alfa.setValue(i); // Actualiza el valor de la barra de progreso
//                Alfa.setString("Progreso Alfa = " + Alfa.getValue());
//                Thread.sleep(50); // Espera un momento para simular el progreso
//                if (Alfa.getValue() == 100) {
//                	Alfa.setString("ALFA COMPLETADO!");
//                	System.out.println("Bien hecho!");
//                }
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//});
//thread.start();
