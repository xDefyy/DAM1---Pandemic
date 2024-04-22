import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Descodificar {

	public static void main(String[] args) {

		String nombreFichero = "ciudades.txt";
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
					
					//guarda las variables del split a uno exterior
					ciudad = aux[0];
					coordenadas[0] = Integer.valueOf(aux[1]);
					coordenadas[1] = Integer.valueOf(coordsParse[0]);
					coordenadas[2] = Integer.valueOf(coordsParse[1]);
					
					
					System.out.print("Silco actúa en " + ciudad  + " con los numeros " 
					+ coordenadas[0] + ", " + coordenadas[1] + " y " + coordenadas[2] 
							+ ", y cuyas ciudades colindantes son ");
							
					
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
	}

}