import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class panelPrincipal extends JPanel{

	JButton boton1;
	JButton boton2;
	JButton boton3;
	JTextField areaTexto;
	
	panelPrincipal(){
		setLayout(new FlowLayout());
		
		boton1 = new JButton("Jugar");
		boton2 = new JButton("Reglas");
		boton3 = new JButton("Salir");
		areaTexto = new JTextField(20);
		
		add(boton1);
		add(boton2);
		add(boton3);
		add(areaTexto);
		
	}
	
}
