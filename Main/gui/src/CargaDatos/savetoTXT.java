package CargaDatos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import controladores.controlPartida;
import objetos.ciudad;
import objetos.vacunas;
import objetos.virus;

public class savetoTXT {

	public static void guardar_ciudades() {
		controlDatos.cargarCiudades();
		
		System.out.println(controlDatos.ciudades);
		String nombreFichero = ("try_ciudades.txt");
		
		ArrayList<String[]> colin = new ArrayList<>();
		
		try {

			FileWriter fileWriter = new FileWriter(nombreFichero, false);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			for (ciudad ciudad : controlDatos.ciudades) {
			    bufferedWriter.write(ciudad.getNombre() + "\n");
			    bufferedWriter.write(ciudad.getCoordenadas()[0] + ", " + ciudad.getCoordenadas()[1] + "\n");
			    bufferedWriter.write(ciudad.getEnfermedad() + "\n");
			    bufferedWriter.write(ciudad.getInfeccion() + "\n");

			    // Escribir Ciudades Colindantes
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
	
	public static void guardar_vacunas() {
		controlDatos.cargarVacunas();
		
		System.out.println(controlDatos.vacunas);
		String nombreFichero = "try_vacunas.txt";
		
		try {

			FileWriter fileWriter = new FileWriter(nombreFichero, false);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			for (vacunas v : controlDatos.vacunas) {
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
	
	public static void guardar_parametros() {
		
		System.out.println(controlDatos.ciudades);
		String nombreFichero = ("try_parametros.txt");
		
		try {

			FileWriter fileWriter = new FileWriter(nombreFichero, false);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			bufferedWriter.write(controlPartida.datos.getBrotes() + "\n");
			bufferedWriter.write(controlPartida.datos.getRondas() + "\n");
			bufferedWriter.write(controlPartida.datos.getpDesarrollo() + "\n");
			bufferedWriter.write(controlPartida.datos.getAcciones() + "\n");
			
			bufferedWriter.close();
			fileWriter.close();
			
			System.out.println("El fichero ha sido modificado correctamente");
		} catch (IOException e) {
			System.out.println("Ha habido un error de escritura: " + e);
		}
		
	}
	
	public static void main(String args[]) {
		guardar_ciudades();
		guardar_vacunas();	
		guardar_parametros();
	}

}
