package CargaDatos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import objetos.ciudad;
import objetos.vacunas;
import objetos.virus;

public class controlDatos {

	private String url;
	private String user;
	private String password;
	private String ficheroTxt;
	private String ficheroBin;
	private String ficheroXml;
	
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
					datosPartida.ciudades.add(ciudadnueva);
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
		
		datosPartida.vacunas.add(vacuna_alpha);
		datosPartida.vacunas.add(vacuna_beta);
		datosPartida.vacunas.add(vacuna_gamma);
		datosPartida.vacunas.add(vacuna_delta);
			
	}
	
	public static void cargarVirus() {
		
		virus virus_alpha = new virus("0","Alfa","Azul");
		virus virus_beta = new virus("1","Beta","Rojo");
		virus virus_gamma = new virus("2","Gamma","Verde");
		virus virus_delta = new virus("3","Delta","Amarillo");
		
		datosPartida.virus.add(virus_alpha);
		datosPartida.virus.add(virus_beta);
		datosPartida.virus.add(virus_gamma);
		datosPartida.virus.add(virus_delta);
		
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
