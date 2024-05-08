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

	public static Connection conectarBaseDatos() {
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
	
	
	public static void insertarPersona(Connection con) {
		
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
	
	public static void insertarPartida(Connection con) {
		
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
		
		String color_vacuna0 = controlPartida.datos.getVacunas().get(0).getColor();
		String color_vacuna1 = controlPartida.datos.getVacunas().get(1).getColor();
		String color_vacuna2 = controlPartida.datos.getVacunas().get(2).getColor();
		String color_vacuna3 = controlPartida.datos.getVacunas().get(3).getColor();
		
		int pr_vacuna0 = controlPartida.datos.getVacunas().get(0).getPorcentaje();
		int pr_vacuna1 = controlPartida.datos.getVacunas().get(1).getPorcentaje();
		int pr_vacuna2 = controlPartida.datos.getVacunas().get(2).getPorcentaje();
		int pr_vacuna3 = controlPartida.datos.getVacunas().get(3).getPorcentaje();
		
		String nombre_ciudad = "";
		int infeccion_ciudad = 0;
		String SqlCIUDADES = "";
		
		for (int i = 0; i < controlPartida.datos.getCiudades().size(); i++) {
			nombre_ciudad = controlPartida.datos.getCiudades().get(i).getNombre();
			infeccion_ciudad = controlPartida.datos.getCiudades().get(i).getInfeccion();
			
			SqlCIUDADES += nombre_ciudad + ',' + infeccion_ciudad + ',';
		}
		
		String sql = "INSERT INTO PARTIDA VALUES('" + partida_id + "', '" + numero_usuario + "', '" + diff + "', '" + rondas + "', '" + acciones + "', '" + brotes 
						+ "',  ARRAY_CIUDADES(CIUDADES('" + SqlCIUDADES + "')),  ARRAY_VACUNAS(VACUNAS('" + color_vacuna0 + "', '" + pr_vacuna0 + "'), VACUNAS('" + color_vacuna0 + "', '" + pr_vacuna0 + "'), VACUNAS('" + color_vacuna0 + "', '" + pr_vacuna0 + "'), VACUNAS('" + color_vacuna0 + "', '" + pr_vacuna0 + "')), null)";

		
//		String insert_city = "INSERT INTO PARTIDA VALUES('" + nombre_ciudad + "', '" + infeccion_ciudad + "')";
		
//		String insert_city = "INSERT INTO ARRAY_CIUDADES VALUES('" + nombre_ciudad + "', '" + infeccion_ciudad + "')";
		
//		INSERT INTO PARTIDA VALUES(0, 0, DIFICULTAD, RONDAS, ACCIONES, BROTES, ARRAY_CIUDADES(CIUDADES(NOMBRE, INFECCION)), ARRAY_VACUNAS(VACUNAS(COLOR, PORCENTAJE)), WL);
		
		try {
			Statement st = con.createStatement();
			st.execute(sql);
			
			System.out.println("Insert hecho correctamente correctamente");
		} catch (SQLException e) {
			System.out.println("Ha habido un error en el Insert " + e);
		}
		

		}
	
	 public static void main(String[] args) {
	 
//		 insertarPersona(con);
		 insertarPartida(con);
		 
	 }
		
		//rondas
		//date
		//W or L
		//POINTS
	
}
