import java.util.Scanner;

public class menu_Parametros {

	public static void main(String[] args) {	
		
		
		Scanner sc = new Scanner(System.in);
		String eleccion = "0";
		
		while (!eleccion.equals("3")) {
			System.out.println("Menu:");
			System.out.println("1.Leer parametros");
			System.out.println("2.Modificar parametros");
			System.out.println("3.Salir");
			eleccion = sc.nextLine();
			
			switch (eleccion) {
				case "1":
					parametros_funciones.leerParametros();
				break;
				case "2":
					parametros_funciones.modifyParametros();
				break;
				case "3":
					System.out.println("Saliendo...");
				break;
			}
		}
	}

}
