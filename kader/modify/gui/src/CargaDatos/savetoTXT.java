package CargaDatos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.io.File;

import objetos.ciudad;
import objetos.vacunas;
import objetos.virus;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class savetoTXT {
    
    protected static Path dirPath;
    protected static Path folderPath;
    
    public static void crear_directorio() {
        dirPath = Paths.get("C:\\Users\\alumnat\\Desktop\\DAM1---Pandemic\\kader");
        
        // Verifica si el directorio "kader" existe
        if (Files.notExists(dirPath)) {
            try {
                // Crea el directorio "kader" si no existe
                Files.createDirectory(dirPath);
                System.out.println("Directory 'kader' created.");
            } catch (IOException e) {
                System.err.println("Unable to create directory 'kader': " + e.getMessage());
                return;
            }
        } else {
            System.out.println("Directory " + dirPath + " already exists.");
        }
        
        // Nombre de la carpeta que quieres crear dentro de "kader"
        String folderName = "Partida 1";
        folderPath = dirPath.resolve(folderName);
        
        // Verifica si la carpeta con nombre especifico ya existe dentro de "kader"
        if (Files.notExists(folderPath)) {
            try {
                // Crea la carpeta dentro de "kader" si no existe
                Files.createDirectory(folderPath);
                System.out.println("Folder '" + folderName + "' created inside 'kader'.");
            } catch (IOException e) {
                System.err.println("Unable to create folder '" + folderName + "' inside 'kader': " + e.getMessage());
            }
        } else {
            System.out.println("Folder '" + folderName + "' already exists inside 'kader'.");
        }
    }

    public static void guardar_ciudades() {
        controlDatos.cargarCiudades();
        
        String nombreFichero = "try_ciudades.txt";
        
        try {
            FileWriter fileWriter = new FileWriter(folderPath.resolve(nombreFichero).toFile(), false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            for (ciudad ciudad : datosPartida.ciudades) {
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
        
        String nombreFichero = "try_vacunas.txt";
        
        try {
            FileWriter fileWriter = new FileWriter(folderPath.resolve(nombreFichero).toFile(), false);
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
    
    public static void guardar_parametros() {
        String nombreFichero = "try_parametros.txt";
        
        try {
            FileWriter fileWriter = new FileWriter(folderPath.resolve(nombreFichero).toFile(), false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            bufferedWriter.write(datosPartida.brotes + "\n");
            bufferedWriter.write(datosPartida.rondas + "\n");
            bufferedWriter.write(datosPartida.pDesarrollo + "\n");
            bufferedWriter.write(datosPartida.acciones + "\n");
            
            bufferedWriter.close();
            fileWriter.close();
            
            System.out.println("El fichero ha sido modificado correctamente");
        } catch (IOException e) {
            System.out.println("Ha habido un error de escritura: " + e);
        }
    }
    
    public static void main(String args[]) {
        crear_directorio();
        guardar_ciudades();
        guardar_vacunas();  
        guardar_parametros();
    }
}
