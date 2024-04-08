import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class lecturaCCP {

	public static ArrayList<Integer> idEnfermedad = new ArrayList<>();
	public static ArrayList<String> ciudades = new ArrayList<>();
	
	public static void main(String[] args) {
		String nombreFichero = "CCP.bin";
		String nombreFichero2 = "ciudades.txt";
		
		
		try {
			FileReader fileReader = new FileReader(nombreFichero2);
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
					ciudad = aux[0];
					ciudades.add(ciudad);
					coordenadas[0] = Integer.valueOf(aux[1]);
					int idEnfer = coordenadas[0];
					idEnfermedad.add(idEnfer);
				}	
	
			} while (linea != null);				
			
			bufferedReader.close();
			fileReader.close();

		} catch (IOException e) {
			System.out.println("Ha habido un error al intentar abrir el fichero" + e);
		}
				
		
		
		try {

			FileInputStream fi = new FileInputStream(nombreFichero);
			DataInputStream di = new DataInputStream(fi);
			while (true) {
					String explicacion = di.readUTF();
					System.out.println(explicacion);
					for (int i = 0; i < 4 ; i ++) {
							int codigoEnfermedad = di.readInt();
							System.out.println();
							System.out.println("Codigo de la enfermedad: " + codigoEnfermedad);
							String nombreEnfermedad = di.readUTF();
							System.out.println("Nombre de la enfermedad: " + nombreEnfermedad);
							String colorEnfermedad = di.readUTF();
							System.out.println("Color de la enfermedad: " + colorEnfermedad);
							System.out.println();
							
								if (codigoEnfermedad == 0) {
									comprobar(nombreEnfermedad, codigoEnfermedad);
								} else if (codigoEnfermedad == 1) {
									comprobar(nombreEnfermedad, codigoEnfermedad);
								} else if (codigoEnfermedad == 2) {
									comprobar(nombreEnfermedad, codigoEnfermedad);
								} else {
									comprobar(nombreEnfermedad, codigoEnfermedad);
								}
					}
					int coordsx = di.readInt();
					int coordsy = di.readInt();
					System.out.println("Cooredenadas en el eje X: " + coordsx + ", Cooredenadas en el eje Y: " + coordsy);
			}

		} catch (EOFException e1) {
			System.out.println();
			System.out.println("Has llegado al final");
		} catch (IOException e2) { 

		}
	}
	
	public static void comprobar (String nombreEnfermedad, int codigoEnfermedad) {
		String nombreFichero = "ciudades-enfermedad.bin";
		
		
		try {
			FileOutputStream fs = new FileOutputStream(nombreFichero, true);
			DataOutputStream ds = new DataOutputStream(fs);
			for (int x = 0; x < ciudades.size(); x++) {
				if (idEnfermedad.get(x) == codigoEnfermedad ) {
					ds.writeUTF(ciudades.get(x) + ": " + nombreEnfermedad);
					System.out.println(ciudades.get(x) + ": " + nombreEnfermedad);
					
				}
			
			}
		
			ds.close();
			fs.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
