import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.math.*;

public class ciudadesCercano {
	public static ArrayList<String> ciudades = new ArrayList<String>();
	public static ArrayList<Integer> x = new ArrayList<Integer>();
	public static ArrayList<Integer> y = new ArrayList<Integer>();
	public static ArrayList<String[]> ciudadesE = new ArrayList<String[]>();	
	
	
	
	public static void main(String[] args) {

		String nombreFichero = "ciudad_as.txt";
		
		
		String ciudadExtras[] = {};
		
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
					ciudadExtras = aux[3].split(","); 
					
					
					
					//guarda las variables del split a uno exterior
					ciudad = aux[0];
					ciudades.add(ciudad);
					
					coordenadas[0] = Integer.valueOf(aux[1]);
					coordenadas[1] = Integer.valueOf(coordsParse[0]);
					x.add(coordenadas[1]);
					
					coordenadas[2] = Integer.valueOf(coordsParse[1]);
					y.add(coordenadas[2]);
					
					ciudadesE.add(ciudadExtras);
					
					System.out.print( ciudad + " "
					+ coordenadas[0] + ", " + coordenadas[1] + " y " + coordenadas[2] 
							+ " - ");							
					
					for (int i = 0; i < ciudadExtras.length; i++) {
						if (i != ciudadExtras.length-1) {
							System.out.print(ciudadExtras[i] + " - " );
						} else {
							System.out.print(ciudadExtras[i] + "." );
						}
					}
					System.out.println();
					
					
				}	
	
			} while (linea != null);
			
			
			
			
			bufferedReader.close();
			fileReader.close();

		} catch (IOException e) {
			System.out.println("Ha habido un error al intentar abrir el fichero" + e);
		}
		
		
//		for (String c : ciudades) {
//			System.out.println(c);
//		}
//		
//		for (Integer ekis : x) {
//			System.out.println(ekis);
//		}
//		
//		for (Integer ei : y) {
//			System.out.println(ei);
//		}
//		
//		for (int i = 0; i < ciudadesE.size(); i++) {
//			String ciudadFinal[] = ciudadesE.get(i);
//			for (String ciudad: ciudadFinal) {
//				System.out.print(ciudad + " ");
//			}
//			System.out.println();
//		}
		
		for (int i = 0; i < ciudades.size(); i++) {
			System.out.println("La ciudad: " + ciudades.get(i) + 
					" esta en las cordenadas " + x.get(i) + ", " + y.get(i));
			
			for (int j = 0; j < ciudadesE.size(); j++) {
				String ciudadFinal[] = ciudadesE.get(i);
				
				for (int k = 0; k < ciudadFinal.length; k++) {
					if (ciudades.get(i).equalsIgnoreCase(ciudadFinal[k])) {
						mayor(x.get(i), x.get(k), y.get(i), y.get(k));
					}
				}
			}
		}
	}
	//TODO CAMBIAR FOR 
	
	public static void mayor(int equis1, int ei1, int equis2, int ei2) {
		
		Math.max(equis1, equis2);
		Math.max(ei1, ei2);
		
		//ACABAR FUNCION DE VER MAYOR PARA PODER HACER LAS OPERACIONES
		
		System.out.println(equis1 + " " + ei1 + " " + equis2 + " " + ei2);
	}
	
	public static void distancia (int equis, int ei) {
		

		
	}

}