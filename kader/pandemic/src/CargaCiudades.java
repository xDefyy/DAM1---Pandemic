import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.*;

public class CargaCiudades {

	public static ArrayList<ciudad> ciudades_obj = new ArrayList<>();
	
	public static void main(String[] args) {

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

		for (ciudad c : CargaCiudades.ciudades_obj) {
		    System.out.println("Nombre de la ciudad: " + c.getNombre());
		    System.out.println("Coordenadas: (" + c.getCoordenadas()[0] + ", " + c.getCoordenadas()[1] + ")");
		    System.out.println("Enfermedad: " + c.getEnfermedad());
		    System.out.println("Infección: " + c.getInfeccion());
		    System.out.print("Ciudades colindantes: ");
		    
		    String[] colindantes = c.getCiudadesColindantes();
		    for (int i = 0; i < colindantes.length; i++) {
		        if (i != colindantes.length - 1) {
		            System.out.print(colindantes[i] + ", ");
		        } else {
		            System.out.print(colindantes[i]);
		        }
		    }
		    System.out.println("\n");
		}




	}
	
}
