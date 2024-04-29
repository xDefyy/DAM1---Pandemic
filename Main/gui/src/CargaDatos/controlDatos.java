package CargaDatos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import objetos.ciudad;
import objetos.vacunas;
import objetos.virus;
import CargaDatos.datosPartida;

public class controlDatos {
	 
	public static String numCiudadesInfectadasInicio = "";
	public static String numCiudadesInfectadasRonda = "";
	public static String numEnfermedadesActivasDerrota = ""; 
	public static String numBrotesDerrota = "";
    public static String desarrolloVacuna = "";
	private String url;
	private String user;
	private String password;
	private String ficheroTxt;
	private String ficheroBin;
	private static String ficheroXml;
	
	public static void cargarCiudades() {
		
		String nombreFichero = "src\\datos\\ciudades.txt";
		
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
					datosPartida.ciudades.add(ciudadnueva);
				}	
	
			} while (linea != null);				

			bufferedReader.close();
			fileReader.close();

		} catch (IOException e) {
			System.out.println("Ha habido un error al intentar abrir el fichero" + e);
		}
		
	}
	
	public static void cargarVacunas() { //Pensar nombre potente vacuna VIH CANCER SARS ++  Nucle de inyeccion de generacion de grandes antibioticos (NIGGA)

		vacunas vacuna_alpha = new vacunas("VIH", "Azul", 0);
		vacunas vacuna_beta = new vacunas("CANCER", "Rojo", 0);
		vacunas vacuna_gamma = new vacunas("SARS", "Verde", 0);
		vacunas vacuna_delta = new vacunas("NIGGA", "Negro", 0);
		
		datosPartida.vacunas.add(vacuna_alpha);
		datosPartida.vacunas.add(vacuna_beta);
		datosPartida.vacunas.add(vacuna_gamma);
		datosPartida.vacunas.add(vacuna_delta);
		
	}
	
	public static void cargarVirus() {
		
		virus virus_alpha = new virus("0","Alfa","Azul");
		virus virus_beta = new virus("1","Beta","Rojo");
		virus virus_gamma = new virus("2","Gamma","Verde");
		virus virus_delta = new virus("3","Delta","Negro");
		
		datosPartida.virus.add(virus_alpha);
		datosPartida.virus.add(virus_beta);
		datosPartida.virus.add(virus_gamma);
		datosPartida.virus.add(virus_delta);
		
	}
	
	public static void cargarPartida() {
		
	}
	
	public static void guardarPartida() {
		
	}
	
	public static void cargarRecord() {
		
	}
	
	public static void guardarRecord() {
		
	}
	
	public static void controlDificultad(int valor) {
		String nodePrincipal = "";
		if (valor == 0) {
			ficheroXml = "src\\datos\\facil.xml";
			nodePrincipal = "facil";
		} else if (valor == 1) {
			ficheroXml = "src\\datos\\normal.xml";
			nodePrincipal = "normal";
		} else {
			ficheroXml = "src\\datos\\dificil.xml";
			nodePrincipal = "dificil";
		}

		try {
            File inputFile = new File(ficheroXml);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();


            NodeList nodeList = doc.getElementsByTagName(nodePrincipal);

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                     numCiudadesInfectadasInicio = element.getElementsByTagName("numCiudadesInfectadasInicio").item(0).getTextContent();
                     numCiudadesInfectadasRonda = element.getElementsByTagName("numCuidadesInfectadasRonda").item(0).getTextContent();
                     numEnfermedadesActivasDerrota = element.getElementsByTagName("numEnfermedadesActivasDerrota").item(0).getTextContent();
                     numBrotesDerrota = element.getElementsByTagName("numBrotesDerrota").item(0).getTextContent();
                     desarrolloVacuna = element.getElementsByTagName("desarrollovacuna").item(0).getTextContent();
                    

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
}
