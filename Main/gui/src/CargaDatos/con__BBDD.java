package CargaDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.Scanner;

import CargaDatos.controlDatos;
import intefaz.CargarParty;
import controladores.controlPartida;

public class con__BBDD {

	private static Connection conectarBaseDatos() {
	Connection con = null;

	System.out.println("Intentando conectarse a la base de datos");

	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.3.26:1521:xe" ,"DAM1_2324_MAY_KADER", "kader");
	} catch (ClassNotFoundException e) {
		System.out.println("No se ha encontrado el driver " + e);
	} catch (SQLException e) {
		System.out.println("Error en las credenciales o en la URL " + e);
	}

	System.out.println("Conectados a la base de datos");

	return con;
}

	
//	private static ArrayList<controlDatos> select(Connection con) {
//		
//	String sql = "SELECT p.* FROM PERSONA p";
//	
//	ArrayList<Persona> p = new ArrayList<Persona>();
//
//	try {
//		Statement st = con.createStatement();
//		ResultSet rs = st.executeQuery(sql);
//
//		if (rs.isBeforeFirst()) {
//			while (rs.next()) {
//				String dni = rs.getString("DNI");
//				String nombre = rs.getString("NOMBRE");
//
//				Struct domicilio = (Struct) rs.getObject("DOMICILIO");
//				Object[] valoresDireccion = domicilio.getAttributes();
//				String calle = (String) valoresDireccion[0];
//				String ciudad = (String) valoresDireccion[1];
//				String pais = (String) valoresDireccion[2];
//
//				Direccion direccion = new Direccion(calle, ciudad, pais);
//				Persona persona = new Persona(dni, nombre, direccion);
//
//				System.out.println(persona.toString());
//				p.add(persona);				}
//		} else {
//			System.out.println("No he encontrado nada");
//		}
//		
//		
//
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
//	return p;
//	}

	// numero de rondas, nombre jugador, fecha, resultado (W , L), Puntos
	
	public static Connection con = conectarBaseDatos();
	
	
	private static void insertarPersona(Connection con) {
		
	Scanner scanner = new Scanner(System.in);
	
	System.out.println("Introduce tu nombre: ");
	String Username = scanner.nextLine();
	int numero_usuario = 0;

	String sql = "INSERT INTO PLAYERS VALUES('" + numero_usuario + "', '" + Username + "')";
	
	try {
		Statement st = con.createStatement();
		st.execute(sql);
		
		System.out.println("Player registrado correctamente");
	} catch (SQLException e) {
		System.out.println("Ha habido un error en el Insert " + e);
	}
	
	scanner.close();

	}
	
	private static void insertarPartida(Connection con) {
		
		int diff = 0;
		
		if (CargarParty.dificultad == 0) {
			diff = 0;
		} else if (CargarParty.dificultad == 1) {
			diff = 1;
		} else if (CargarParty.dificultad == 2) {
			diff = 2; 
		}
		
		int partida_id = 0;
		int numero_usuario = 0;
		int rondas = controlPartida.datos.getRondas();
		int acciones = controlPartida.datos.getAcciones();
		int brotes = controlPartida.datos.getBrotes();

		String sql = "INSERT INTO PLAYERS VALUES('" + partida_id + "', '" + numero_usuario + "', '" + diff + "', '" + rondas + "', '" + acciones + "', '" + brotes + "', '" + brotes + "' )";
		
		String nombre_ciudad = "";
		int infeccion_ciudad = 0;
		
		for (int i = 0; i < controlPartida.datos.getCiudades().size(); i++) {
			nombre_ciudad = controlPartida.datos.getCiudades().get(i).getNombre();
			infeccion_ciudad = controlPartida.datos.getCiudades().get(i).getInfeccion();
		}

		
		String insert_city = "INSERT INTO CIUDADES VALUES('" + nombre_ciudad + "', '" + infeccion_ciudad + "')";

		
		try {
			Statement st = con.createStatement();
			st.execute(sql);
			
			System.out.println("Player registrado correctamente");
		} catch (SQLException e) {
			System.out.println("Ha habido un error en el Insert " + e);
		}
		

		}
	
	 public static void main(String[] args) {
	 
		 insertarPersona(con);
		 
	 }
		
		//rondas
		//date
		//W or L
		//POINTS
	
}
