import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class controlDatos {

	private String url;
	private String user;
	private String password;
	private String ficheroTxt;
	private String ficheroBin;
	private String ficheroXml;
	
	public static ArrayList<ciudad> ciudades_obj = new ArrayList<>();
	public static ArrayList<vacunas> vacunas_obj = new ArrayList<>();
	
	//falta arraylist de objetos
	public static void cargarCiudades() {
		
String nombreFichero = "ciudades.txt";
		
		ArrayList<String[]> colin = new ArrayList<>();
		
		try {
			FileReader fileReader = new FileReader(nombreFichero);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String linea = "";
			String aux[] = linea.split(";");
			
			do {
				
				linea = bufferedReader.readLine();
				
				if (linea != null) {
					aux = linea.split(";");	
					String coordsParse[] = aux[2].split(",");
					String ciudad;
					int[] coordenadas = new int[3];
					String ciudadExtras[] = aux[3].split(",");
					
					colin.add(ciudadExtras);

					//guarda las variables del split a uno exterior
					ciudad = aux[0];
					coordenadas[0] = Integer.valueOf(aux[1]);
					coordenadas[1] = Integer.valueOf(coordsParse[0]);
					coordenadas[2] = Integer.valueOf(coordsParse[1]);
					
					int[] coordenadasXY = {coordenadas[1],coordenadas[2]};
					
					//ciudadExtras[] añadir a objeto de ciudad entre otras cosas
					
					String temp;
					
					if(coordenadas[0] == 0) {
						temp = "Alfa";
					} else if (coordenadas[0] == 1) {
						temp = "Beta";
					} else if (coordenadas[0] == 2){
						temp = "Gamma";
					} else {
						temp = "Delta";
					}
					
					ciudad ciudadnueva = new ciudad(ciudad, coordenadasXY, temp, 0, ciudadExtras);				
					temp = "";					
					ciudades_obj.add(ciudadnueva);
				}	
	
			} while (linea != null);				

			bufferedReader.close();
			fileReader.close();

		} catch (IOException e) {
			System.out.println("Ha habido un error al intentar abrir el fichero" + e);
		}
		
	}
	
	public static void cargarVacunas() { //Pensar nombre potente vacuna VIH CANCER SARS ++  Nucle de inyeccion de generacion de grandes antibioticos (NIGGA)
		
		vacunas vacuna_alpha = new vacunas("Alpha", "Azul", 0);
		vacunas vacuna_beta = new vacunas("Beta", "Rojo", 0);
		vacunas vacuna_gamma = new vacunas("Gamma", "Verde", 0);
		vacunas vacuna_delta = new vacunas("Delta", "Amarillo", 0);
		
		vacunas_obj.add(vacuna_alpha);
		vacunas_obj.add(vacuna_beta);
		vacunas_obj.add(vacuna_gamma);
		vacunas_obj.add(vacuna_delta);
			
	}
	
	public static void cargarVirus() {
		
	}
	
	public static void cargarPartida() {
		
	}
	
	public static void guardarPartida() {
		
	}
	
	public static void cargarRecord() {
		
	}
	
	public static void guardarRecord() {
		
	}
	
}
