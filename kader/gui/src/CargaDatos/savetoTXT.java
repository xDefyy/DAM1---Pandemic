package CargaDatos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import objetos.ciudad;
import objetos.vacunas;
import objetos.virus;

public class savetoTXT {

	public static void main(String[] args) {
		
		String nombreFichero = "src\\datos\\ciudades.txt";
		
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
					
					ciudad ciudadnueva = new ciudad(ciudad, coordenadasXY, temp, 0, ciudadExtras);							
					datosPartida.ciudades.add(ciudadnueva);
					
					for (int i = 0; i < datosPartida.ciudades.size; i++) {
						
					}
					
				}	
	
			} while (linea != null);				

			bufferedReader.close();
			fileReader.close();

		} catch (IOException e) {
			System.out.println("Ha habido un error al intentar abrir el fichero" + e);
		}
		
	}


//		String nombreFichero = "ciudades.txt";
//
//		String ciudadExtras[] = {};
//
//		try {
//			FileReader fileReader = new FileReader(nombreFichero);
//			BufferedReader bufferedReader = new BufferedReader(fileReader);
//			String linea = "";
//			String aux[] = linea.split(";");
//
//			do {
//
//				linea = bufferedReader.readLine();
//
//				if (linea != null) {
//					aux = linea.split(";");
//					String coordsParse[] = aux[2].split(",");
//					String ciudad;
//					int[] coordenadas = new int[3];
//					ciudadExtras = aux[3].split(",");
//
//					// guarda las variables del split a uno exterior
//					ciudad = aux[0];
//					ciudades.add(ciudad);
//
//					coordenadas[0] = Integer.valueOf(aux[1]);
//					coordenadas[1] = Integer.valueOf(coordsParse[0]);
//					x.add(coordenadas[1]);
//
//					coordenadas[2] = Integer.valueOf(coordsParse[1]);
//					y.add(coordenadas[2]);
//
//					ciudadesE.add(ciudadExtras);
//
//				}
//
//			} while (linea != null);
//
//			bufferedReader.close();
//			fileReader.close();
//
//		} catch (IOException e) {
//			System.out.println("Ha habido un error al intentar abrir el fichero" + e);
//		}
//		
//		String Fichero = "CiudadesRedactadas.txt";
//		
//		try {
//
//			FileWriter fileWriter = new FileWriter(Fichero, false);
//			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//			
//			for (int i = 0; i < ciudadesE.size(); i++) {
//				String ciudadFinal[] = ciudadesE.get(i);
//				bufferedWriter.write("La ciudad inicial es: " + ciudades.get(i) + " x: " + x.get(i) + " y: " + y.get(i) + "\n");
//				bufferedWriter.newLine();
//				for (int j = 0; j < ciudadFinal.length; j++) {
//					for (int k = 0; k < ciudades.size(); k++) {
//						if (ciudades.get(k).equalsIgnoreCase(ciudadFinal[j])) {
//							bufferedWriter.write(ciudadFinal[j] + " x: " + x.get(k) +  " y: " + y.get(k) 
//							+ " y la distancia es: " + mayor(x.get(i), x.get(k), y.get(i), y.get(k)));
//							bufferedWriter.newLine();
//						}
//					}
//				}
//				bufferedWriter.newLine();
//			}
//				
//			bufferedWriter.close();
//			fileWriter.close();
//			System.out.println("El fichero ha sido modificado correctamente");
//		} catch (IOException e) {
//			System.out.println("Ha habido un error de escritura: " + e);
//		}
//		
//	}


}
