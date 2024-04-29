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

	public static void guardar_ciudades() {
		controlDatos.cargarCiudades();
		
		System.out.println(datosPartida.ciudades);
		String nombreFichero = "try_ciudades.txt";
		
		ArrayList<String[]> colin = new ArrayList<>();
		
		try {

			FileWriter fileWriter = new FileWriter(nombreFichero, false);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			for (ciudad ciudad : datosPartida.ciudades) {
			    bufferedWriter.write(ciudad.getNombre() + "\n");
			    bufferedWriter.write(ciudad.getCoordenadas()[0] + ", " + ciudad.getCoordenadas()[1] + "\n");
			    bufferedWriter.write(ciudad.getEnfermedad() + "\n");
			    bufferedWriter.write(ciudad.getInfeccion() + "\n");

			    // Escribir ciudades colindantes
			    for (String colindante : ciudad.getCiudadesColindantes()) {
			        bufferedWriter.write(colindante + ",");
			    }
			    bufferedWriter.write("\n");
			}

			
			bufferedWriter.close();
			fileWriter.close();
			System.out.println("El fichero ha sido modificado correctamente");
		} catch (IOException e) {
			System.out.println("Ha habido un error de escritura: " + e);
		}
		
	}
	
	public static void cargar_vacunas() {
		controlDatos.cargarVacunas();
		
		System.out.println(datosPartida.vacunas);
		String nombreFichero = "try_vacunas.txt";
		
		try {

			FileWriter fileWriter = new FileWriter(nombreFichero, false);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			for (vacunas v : datosPartida.vacunas) {
				bufferedWriter.write(v.getNombre() + "\n");
				bufferedWriter.write(v.getColor() + "\n");
				bufferedWriter.write(v.getPorcentaje() + "\n");
			}
				
			bufferedWriter.close();
			fileWriter.close();
			System.out.println("El fichero ha sido modificado correctamente");
		} catch (IOException e) {
			System.out.println("Ha habido un error de escritura: " + e);
		}
		
	}
	
	public static void main(String args[]) {
		
		guardar_ciudades();
		cargar_vacunas();
		
	}

}
