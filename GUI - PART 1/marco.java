import javax.swing.JFrame;

public class marco extends JFrame{

	panelPrincipal lamina1;
	
	marco(){
		setBounds(0, 0, 500, 500);	//donde aparece junto con su tamaño
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // finalizar programa al cerrar con la X
		setTitle("Pandemic DAM1");
		
		lamina1 = new panelPrincipal();
		add(lamina1);
		
		setResizable(false);
		setVisible(true);
	}
	
}
