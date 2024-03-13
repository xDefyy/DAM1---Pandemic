import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Descodificar {

	public static void main(String[] args) {
		
		String nombreFichero = "ciudades";
		try {
			FileReader fileReader = new FileReader(nombreFichero);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String linea = null;
			

				

			bufferedReader.close();
			fileReader.close();

		} catch (IOException e) {
			System.out.println("Ha habido un error al intentar abrir el fichero" + e);
		}
	}

}
