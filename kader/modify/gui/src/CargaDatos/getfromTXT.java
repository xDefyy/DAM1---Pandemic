package CargaDatos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import objetos.ciudad;
import objetos.vacunas;

public class getfromTXT {

    public static void cargar_ciudades() {

        String nombreFichero = "try_ciudades.txt";

        try {
            FileReader fileReader = new FileReader(nombreFichero);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linea = bufferedReader.readLine();

            do {
                String nombre = "";
                int[] coordenadas = new int[2];
                String enfermedad = "";
                int infeccion = 0;
                ArrayList<String> ciudadesColindantes = new ArrayList<>();

                nombre = linea; // Nombre
                
                linea = bufferedReader.readLine(); // Coordenadas
                String[] coordenadasStr = linea.split(", ");
                coordenadas[0] = Integer.parseInt(coordenadasStr[0]);
                coordenadas[1] = Integer.parseInt(coordenadasStr[1]);
                
                linea = bufferedReader.readLine(); // Enfermedad
                enfermedad = linea;
                
                linea = bufferedReader.readLine(); // Infección
                infeccion = Integer.parseInt(linea);
                
                linea = bufferedReader.readLine(); // Ciudades colindantes
                String[] colindantes = linea.split(",");
                
                for (String colindante : colindantes) {
                    ciudadesColindantes.add(colindante.trim()); // Colindantes
                }

                ciudad ciudadNueva = new ciudad(nombre, coordenadas, enfermedad, infeccion, ciudadesColindantes.toArray(new String[0]));
                datosPartida.ciudades.add(ciudadNueva);

                linea = bufferedReader.readLine();
            } while (linea != null);

            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    public static void cargar_vacunas() {

        String nombreFichero = "try_vacunas.txt";

        try {
            FileReader fileReader = new FileReader(nombreFichero);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linea = bufferedReader.readLine();

            do {
                String nombre = "";
                String color = "";
                double porcentaje = 0;

                nombre = linea; // Nombre
                
                linea = bufferedReader.readLine(); // Enfermedad
                color = linea;
                
                linea = bufferedReader.readLine(); // Enfermedad
                porcentaje = Double.parseDouble(linea);

                vacunas vacunaNueva = new vacunas(nombre, color, porcentaje);
                datosPartida.vacunas.add(vacunaNueva);

                linea = bufferedReader.readLine();
            } while (linea != null);

            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    public static void main(String[] args) {
        cargar_ciudades();
        
        for (ciudad c : datosPartida.ciudades) {
            System.out.print("Nombre de la ciudad: " + c.getNombre() + "\n");
            System.out.print("Coordenadas: (" + c.getCoordenadas()[0] + ", " + c.getCoordenadas()[1] + ")" + "\n");
            System.out.print("Enfermedad: " + c.getEnfermedad() + "\n");
            System.out.print("Infección: " + c.getInfeccion() + "\n");
            System.out.println("Ciudades colindantes:");
            for (String colindante : c.getCiudadesColindantes()) {
                System.out.println(colindante);
            }
            System.out.println();
            
        }
        
        cargar_vacunas();
        
        for (vacunas v : datosPartida.vacunas) {
        	System.out.print(v.getNombre() + "\n");
        	System.out.print(v.getColor() + "\n");
        	System.out.print(v.getPorcentaje() + "\n");
		}
    }
}