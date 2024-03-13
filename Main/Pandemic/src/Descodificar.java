import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Descodificar {

	public static void main(String[] args) {

		String ciudad;
		
		int[] coordenadas = new int[3];
		
		String nombreFichero = "ciudadestest.txt";
		try {
			FileReader fileReader = new FileReader(nombreFichero);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String linea = "";
			String aux[] = linea.split(";");
			
			do {
				
				linea = bufferedReader.readLine();
				
				if (linea != null) {
					aux = linea.split(";");	
				}	
	
			} while (linea != null);				
			
			ciudad = aux[0];
			coordenadas[0] = Integer.valueOf(aux[1]);
			coordenadas[1] = Integer.valueOf(aux[2]);
			coordenadas[2] = Integer.valueOf(aux[3]);
			
			System.out.println(ciudad  + " - " + coordenadas[0] + " - " + coordenadas[1] + " - " + coordenadas[2]);
	
			bufferedReader.close();
			fileReader.close();

		} catch (IOException e) {
			System.out.println("Ha habido un error al intentar abrir el fichero" + e);
		}
	}

}
