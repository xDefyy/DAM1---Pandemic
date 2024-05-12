package CargaDatos;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import controladores.controlPartida;
import intefaz.CargarParty;
import intefaz.usuarioGetName;
import objetos.ciudad;
import objetos.vacunas;
import objetos.virus;

public class controlDatos {

	public static String numCiudadesInfectadasInicio = "";
	public static String numCiudadesInfectadasRonda = "";
	public static String numEnfermedadesActivasDerrota = "";
	public static String numBrotesDerrota = "";
	public static String desarrolloVacuna = "";
	public static ArrayList<ciudad> ciudades = new ArrayList<>();
	public static ArrayList<virus> virus = new ArrayList<>();
	public static ArrayList<vacunas> vacunas = new ArrayList<>();
	public static Connection con = conectarBaseDatos();
	private static String ficheroXml;
	public static String ganar_perder = "NF";

	public static Connection conectarBaseDatos() {
		Connection con = null;
		String url = "jdbc:oracle:thin:@oracle.ilerna.com:1521:xe";
		String user = "DAM1_2324_YAN_LIQIAN";
		String password = "liqian";

		System.out.println("Intentando conectarse a la base de datos");

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("No se ha encontrado el driver " + e);
		} catch (SQLException e) {
			System.out.println("Error en las credenciales o en la URL " + e);
		}

		System.out.println("Conectado a la base de datos");

		return con;
	}

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

					// guarda las variables del split a uno exterior
					ciudad = aux[0];
					coordenadas[0] = Integer.valueOf(aux[1]);
					coordenadas[1] = Integer.valueOf(coordsParse[0]);
					coordenadas[2] = Integer.valueOf(coordsParse[1]);

					int[] coordenadasXY = { coordenadas[1], coordenadas[2] };

					// ciudadExtras[] añadir a objeto de ciudad entre otras cosas

					String temp;

					if (coordenadas[0] == 0) {
						temp = "Alfa";
					} else if (coordenadas[0] == 1) {
						temp = "Beta";
					} else if (coordenadas[0] == 2) {
						temp = "Gamma";
					} else {
						temp = "Delta";
					}

					ciudad ciudadnueva = new ciudad(ciudad, coordenadasXY, temp, 0, ciudadExtras, false);
					temp = "";
					ciudades.add(ciudadnueva);
				}

			} while (linea != null);

			bufferedReader.close();
			fileReader.close();
		} catch (IOException e) {
			System.out.println("Ha habido un error al intentar abrir el fichero" + e);
		}

	}

	public static void cargarVacunas() { // Pensar nombre potente vacuna VIH CANCER SARS ++ Nucle de inyeccion de
											// generacion de grandes antibioticos (NIGGA)

		vacunas vacuna_alpha = new vacunas("VIH", "Azul", 0);
		vacunas vacuna_beta = new vacunas("CANCER", "Rojo", 0);
		vacunas vacuna_gamma = new vacunas("SARS", "Amarillo", 0);
		vacunas vacuna_delta = new vacunas("NIGGA", "Negro", 0);

		vacunas.add(vacuna_alpha);
		vacunas.add(vacuna_beta);
		vacunas.add(vacuna_gamma);
		vacunas.add(vacuna_delta);

	}

	public static void cargarVirus() {

		virus virus_alpha = new virus("0", "Alfa", "Azul");
		virus virus_beta = new virus("1", "Beta", "Rojo");
		virus virus_gamma = new virus("2", "Gamma", "Amarillo");
		virus virus_delta = new virus("3", "Delta", "Negro");

		virus.add(virus_alpha);
		virus.add(virus_beta);
		virus.add(virus_gamma);
		virus.add(virus_delta);

	}

	public static void cargarPartida() {

	}

	public static void guardarPartida() {

		String nombre = usuarioGetName.userFinal;
		newPlayer(nombre, con);
		insertarPartida(con);
		
		
	}
	
	public static void insertarPartida(Connection con) {
        int diff = CargarParty.dificultad;
        int numeroPlayer = getPlayerID();
        int rondas = controlPartida.datos.getRondas();
        int acciones = controlPartida.datos.getAcciones();
        int brotes = controlPartida.datos.getBrotes();
        int puntuacion = 0;

        
        StringBuilder SqlCIUDADES = new StringBuilder();
        for (int i = 0; i < controlPartida.datos.getCiudades().size(); i++) {
            String nombre_ciudad = controlPartida.datos.getCiudades().get(i).getNombre();
            boolean ciudadNuked = controlPartida.datos.getCiudades().get(i).isNuke();
            String nuked = "";
            if (ciudadNuked == true) {
            	nuked = "S";
            } else if (ciudadNuked == false) {
            	nuked = "N";
            }
            int infeccion_ciudad = controlPartida.datos.getCiudades().get(i).getInfeccion();
            SqlCIUDADES.append("CIUDADES('" + nombre_ciudad + "', " + infeccion_ciudad + ",'" + nuked + "'" + ")");
            if (i < controlPartida.datos.getCiudades().size() - 1) {
                SqlCIUDADES.append(", ");
            }
        }

        StringBuilder SqlVACUNAS = new StringBuilder();
        for (int i = 0; i < controlPartida.datos.getVacunas().size(); i++) {
            String color_vacuna = controlPartida.datos.getVacunas().get(i).getColor();
            int pr_vacuna = controlPartida.datos.getVacunas().get(i).getPorcentaje();
            SqlVACUNAS.append("VACUNAS('" + color_vacuna + "', " + pr_vacuna + ")");
            if (i < controlPartida.datos.getVacunas().size() - 1) {
                SqlVACUNAS.append(", ");
            }
        }
        
       
        String sql = "INSERT INTO PARTIDA VALUES(0 ," + numeroPlayer + ", " + puntuacion + ", " + diff + ", " + rondas + ", " + acciones + ", " + brotes
                + ", ARRAY_CIUDADES(" + SqlCIUDADES.toString() + "), ARRAY_VACUNAS(" + SqlVACUNAS.toString() + "), " + "'" + ganar_perder + "'" + ", TO_DATE(SYSDATE,'DD-MM-YYYY,HH24:MI:SS'))";


        try {
            Statement st = con.createStatement();
            st.execute(sql);
        } catch (SQLException e) {
            System.out.println("Ha habido un error en el Insert " + e);
        }
    }

	public static void newPlayer(String nombre,Connection con) {


		int numero_usuario = 0;

		String sql = "INSERT INTO PLAYERS VALUES('" + numero_usuario + "', '" + nombre + "')";

		try {
			Statement st = con.createStatement();
			st.execute(sql);
		} catch (SQLException e) {
			System.out.println("Ha habido un error en el Insert " + e);
		}

	}
	
	public static int getPlayerID() {
		String selectMaxIDP = "SELECT MAX(ID_P) FROM PLAYERS";
		int jugadorID = 0;
		  try {
		        Statement maxIDP = con.createStatement();
		        ResultSet rsMaxIDP = maxIDP.executeQuery(selectMaxIDP);
		        
		        while (rsMaxIDP.next()) {
		        	jugadorID = rsMaxIDP.getInt("MAX(ID_P)");
		        }
		        
		  } catch (SQLException e) {
		        e.printStackTrace();
		        return 0;
		  }
		  return jugadorID;
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
					numCiudadesInfectadasInicio = element.getElementsByTagName("numCiudadesInfectadasInicio").item(0)
							.getTextContent();
					numCiudadesInfectadasRonda = element.getElementsByTagName("numCuidadesInfectadasRonda").item(0)
							.getTextContent();
					numEnfermedadesActivasDerrota = element.getElementsByTagName("numEnfermedadesActivasDerrota")
							.item(0).getTextContent();
					numBrotesDerrota = element.getElementsByTagName("numBrotesDerrota").item(0).getTextContent();
					desarrolloVacuna = element.getElementsByTagName("desarrollovacuna").item(0).getTextContent();

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Font fuenteTitulo() {
		try {
			File fuente = new File("src\\fuente\\fuenteTitulo.ttf");

			Font font = Font.createFont(Font.TRUETYPE_FONT, fuente);

			// Tamaño de la fuente (en puntos)
			float fontSize = 30;

			font = font.deriveFont(fontSize);
			return font;

		} catch (IOException | FontFormatException e) {
			Font defaultFont = new Font("Arial", Font.PLAIN, 30);
			System.err.println("No se pudo cargar la fuente. Se utilizará Arial como fuente predeterminada.");
			e.printStackTrace();
			return defaultFont;
		}
	}

	public static Font fuenteTitulo22() {
		try {
			File fuente = new File("src\\fuente\\fuenteTitulo.ttf");

			Font font = Font.createFont(Font.TRUETYPE_FONT, fuente);

			// Tamaño de la fuente (en puntos)
			float fontSize = 22.5f;

			font = font.deriveFont(fontSize);
			return font;

		} catch (IOException | FontFormatException e) {
			Font defaultFont = new Font("Arial", Font.PLAIN, 30);
			e.printStackTrace();
			return defaultFont;
		}
	}

	public static Font fuenteTexto15() {
		try {
			File fuente = new File("src\\fuente\\fuenteTexto.ttf");

			Font font = Font.createFont(Font.TRUETYPE_FONT, fuente);

			// Tamaño de la fuente (en puntos)
			float fontSize = 15;

			font = font.deriveFont(fontSize);
			return font;

		} catch (IOException | FontFormatException e) {
			Font defaultFont = new Font("Arial", Font.PLAIN, 15);
			e.printStackTrace();
			return defaultFont;
		}
	}

	public static Font fuenteTexto10() {
		try {
			File fuente = new File("src\\fuente\\fuenteTexto.ttf");

			Font font = Font.createFont(Font.TRUETYPE_FONT, fuente);

			// Tamaño de la fuente (en puntos)
			float fontSize = 10;

			font = font.deriveFont(fontSize);
			return font;

		} catch (IOException | FontFormatException e) {
			Font defaultFont = new Font("Arial", Font.PLAIN, 15);
			e.printStackTrace();
			return defaultFont;
		}
	}

	public static Font fuenteMC() {
		try {
			File fuente = new File("src\\fuente\\Minecraft.ttf");

			Font font = Font.createFont(Font.TRUETYPE_FONT, fuente);

			// Tamaño de la fuente (en puntos)
			float fontSize = 15.5f;

			font = font.deriveFont(fontSize);
			GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);
			return font;

		} catch (IOException | FontFormatException e) {
			Font defaultFont = new Font("Arial", Font.PLAIN, 15);
			e.printStackTrace();
			return defaultFont;
		}
	}

	public static Font fuenteMC15() {
		try {
			File fuente = new File("src\\fuente\\Minecraft.ttf");

			Font font = Font.createFont(Font.TRUETYPE_FONT, fuente);

			// Tamaño de la fuente (en puntos)
			float fontSize = 15f;

			font = font.deriveFont(fontSize);
			GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);
			return font;

		} catch (IOException | FontFormatException e) {
			Font defaultFont = new Font("Arial", Font.PLAIN, 15);
			e.printStackTrace();
			return defaultFont;
		}
	}
	
	public static Font fuenteMC12() {
		try {
			File fuente = new File("src\\fuente\\Minecraft.ttf");

			Font font = Font.createFont(Font.TRUETYPE_FONT, fuente);

			// Tamaño de la fuente (en puntos)
			float fontSize = 12f;

			font = font.deriveFont(fontSize);
			GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);
			return font;

		} catch (IOException | FontFormatException e) {
			Font defaultFont = new Font("Arial", Font.PLAIN, 15);
			e.printStackTrace();
			return defaultFont;
		}
	}

	public static Font fuentecargar() {
		try {
			File fuente = new File("src\\fuente\\fuenteCargarParty.ttf");

			Font font = Font.createFont(Font.TRUETYPE_FONT, fuente);

			// Tamaño de la fuente (en puntos)
			float fontSize = 45f;

			font = font.deriveFont(fontSize);
			GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);
			return font;

		} catch (IOException | FontFormatException e) {
			Font defaultFont = new Font("Arial", Font.PLAIN, 15);
			e.printStackTrace();
			return defaultFont;
		}
	}

	public static Font fuentecargar40() {
		try {
			File fuente = new File("src\\fuente\\fuenteCargarParty.ttf");

			Font font = Font.createFont(Font.TRUETYPE_FONT, fuente);

			// Tamaño de la fuente (en puntos)
			float fontSize = 40f;

			font = font.deriveFont(fontSize);
			GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);
			return font;

		} catch (IOException | FontFormatException e) {
			Font defaultFont = new Font("Arial", Font.PLAIN, 15);
			e.printStackTrace();
			return defaultFont;
		}
	}

}
