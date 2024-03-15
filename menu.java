package ficheroObjeto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class menu {
	
	public static ArrayList<persona> ciudadano = new ArrayList<persona>();
	public static Scanner sc_l = new Scanner(System.in);
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		inicio();
		
		String eleccion = "0";
		while (!eleccion.equals("5")) {
			System.out.println("1.Añadir nuevos ciudadanos, con su nombre y dni.\n" + "2.Imprimir los ciudadanos.\n"
					+ "3.Modificar un ciudadano por posición.\n"
					+ "4.Eliminar un ciudadano por posición.\n" + "5.Salir");
			eleccion = sc_l.nextLine();
			switch (eleccion) {
			case "1":
				add();
				break;
			case "2":
				imprimir();
				break;
			case "3":
				modify();
				break;
			case "4":
				delete();
				break;
			case "5":
				System.out.println("Saliendo...");
				break;
			}

		}
	}
	
	public static void inicio() {
		String nombreFichero = "Personas.txt";
		try {
			FileReader fileReader = new FileReader(nombreFichero);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String n = "";
			String d = "";
			int e = 0;
			
			do {
					n = bufferedReader.readLine();
					
						if (n == null) {
							break;
						}
					
					d = bufferedReader.readLine();

					e = Integer.valueOf(bufferedReader.readLine());
					
					persona p = new persona(n,d,e);
					
					ciudadano.add(p);
					p.imprimir();
					
			} while (true);

			bufferedReader.close();
			fileReader.close();

		} catch (IOException e) {
			System.out.println("Ha habido un error al intentar abrir el fichero" + e);
		}
	}
	
	public static void add() {

		String nombreFichero = "Personas.txt";
		
		try {

			FileWriter fileWriter = new FileWriter(nombreFichero, true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			System.out.println("Nombre?");
			String nombre = sc_l.nextLine();
			System.out.println("Dni?");
			String dni = sc_l.nextLine();
			System.out.println("Edad?");
			int edad = sc.nextInt();

			persona p = new persona(nombre, dni, edad);
			p.imprimir();
			
			bufferedWriter.write(p.getName());
			bufferedWriter.newLine();
			bufferedWriter.write(p.getDni());
			bufferedWriter.newLine();
			bufferedWriter.write(Integer.toString(p.getAge()));
			bufferedWriter.newLine();
			ciudadano.add(p);
			
			bufferedWriter.close();
			fileWriter.close();
			System.out.println("El fichero ha sido modificado correctamente");
		} catch (IOException e) {
			System.out.println("Ha habido un error de escritura: " + e);
		}

	}
	
	public static void imprimir() {
		if (ciudadano.size() == 0) {
			System.out.println("No hay nada \n" );
		} else {
			for (persona p : ciudadano) {
				p.imprimir();
			}
		}
		
	}
	
	public static void modify() {
		int contador = 0;
		int pos;
		if (ciudadano.size() == 0) {
			System.out.println("No hay nada \n" );
		} else {
			for (persona p : ciudadano) {
				System.out.print("Pos = " + contador + " - ");
				p.imprimir();
				contador++;
			}
			
			do {
				System.out.println("Modifica mediante POSICIÓN");
				pos = sc.nextInt();
			} while (pos > ciudadano.size()-1 || pos < 0);
			
			int aux = 0;
			for (persona p : ciudadano) {
				if (pos == aux) {
					System.out.println("Vas a modificar esto: ");
					p.imprimir();
					
					System.out.println("Nombre?");
					String nombre = sc_l.nextLine();
					System.out.println("Dni?");
					String dni = sc_l.nextLine();
					System.out.println("Edad?");
					int edad = sc.nextInt();
					
					p.setName(nombre);
					p.setAge(edad);
					p.setDni(dni);
					
					System.out.println("Cambios realizados. ");
					p.imprimir();
					
				} else {
					aux++;
				}
			}
			String nombreFichero = "Personas.txt";
			try {

				FileWriter fileWriter = new FileWriter(nombreFichero, false);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				
				for (persona p : ciudadano) {
					
					bufferedWriter.write(p.getName());
					bufferedWriter.newLine();
					bufferedWriter.write(p.getDni());
					bufferedWriter.newLine();
					bufferedWriter.write(Integer.toString(p.getAge()));
					bufferedWriter.newLine();
				}
				
				
				bufferedWriter.close();
				fileWriter.close();
			
				System.out.println("El fichero ha sido modificado correctamente");
			} catch (IOException e) {
				System.out.println("Ha habido un error de escritura: " + e);
			}
		}
		
	}
	
	public static void delete() {
		int contador = 0;
		int pos;
		if (ciudadano.size() == 0) {
			System.out.println("No hay nada \n" );
		} else {
			for (persona p : ciudadano) {
				System.out.print("Pos = " + contador + " - ");
				p.imprimir();
				contador++;
			}
			
			do {
				System.out.println("Elimina mediante POSICIÓN");
				pos = sc.nextInt();
			} while (pos > ciudadano.size()-1 || pos < 0);
			
			int aux = 0;
			for (persona p : ciudadano) {
				if (pos == aux) {
					System.out.println("Vas a eliminar esto: ");
					p.imprimir();
					ciudadano.remove(aux);
					System.out.println("Cambios realizados. ");
					
				} else {
					aux++;
				}
			}
			
			String nombreFichero = "Personas.txt";
			
			try {

				FileWriter fileWriter = new FileWriter(nombreFichero, false);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				
				for (persona p : ciudadano) {
					
					bufferedWriter.write(p.getName());
					bufferedWriter.newLine();
					bufferedWriter.write(p.getDni());
					bufferedWriter.newLine();
					bufferedWriter.write(Integer.toString(p.getAge()));
					bufferedWriter.newLine();
				}
				
				
				bufferedWriter.close();
				fileWriter.close();
			
				System.out.println("El fichero ha sido modificado correctamente");
			} catch (IOException e) {
				System.out.println("Ha habido un error de escritura: " + e);
			}
		}
	}

}
