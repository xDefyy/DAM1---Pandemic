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

	public static void cargar_ciudades() {
		controlDatos.cargarCiudades();
		
		System.out.println(datosPartida.ciudades);
		String nombreFichero = "C:\\Users\\alumnat\\Desktop\\DAM1---Pandemic-main\\kader\\modify\\pandemic\\try_ciudades.txt";
		
		ArrayList<String[]> colin = new ArrayList<>();
		
		try {

			FileWriter fileWriter = new FileWriter(nombreFichero, false);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			for (ciudad c : datosPartida.ciudades) {
				bufferedWriter.write("Nombre de la ciudad: " + c.getNombre() + "\n");
				bufferedWriter.write("Coordenadas: (" + c.getCoordenadas()[0] + ", " + c.getCoordenadas()[1] + ")" + "\n");
				bufferedWriter.write("Enfermedad: " + c.getEnfermedad() + "\n");
				bufferedWriter.write("Infección: " + c.getInfeccion() + "\n");
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
		String nombreFichero = "C:\\Users\\alumnat\\Desktop\\DAM1---Pandemic-main\\kader\\modify\\pandemic\\try_vacunas.txt";
		
		try {

			FileWriter fileWriter = new FileWriter(nombreFichero, false);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			for (vacunas v : datosPartida.vacunas) {
				bufferedWriter.write("Nombre: " + v.getNombre() + "\n");
				bufferedWriter.write("Color: " + v.getColor() + "\n");
				bufferedWriter.write("Porcentaje: " + v.getPorcentaje() + "\n");
			}
				
			bufferedWriter.close();
			fileWriter.close();
			System.out.println("El fichero ha sido modificado correctamente");
		} catch (IOException e) {
			System.out.println("Ha habido un error de escritura: " + e);
		}
		
	}
	
	public static void main(String args[]) {
		
		cargar_ciudades();
		cargar_vacunas();
		
	}

}
