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
        int diff = CargarParty.dificultad;

        int partida_id = 0;
        int numero_usuario = 0;
        int rondas = controlPartida.datos.getRondas();
        int acciones = controlPartida.datos.getAcciones();
        int brotes = controlPartida.datos.getBrotes();

        StringBuilder SqlCIUDADES = new StringBuilder();
        for (int i = 0; i < controlPartida.datos.getCiudades().size(); i++) {
            String nombre_ciudad = controlPartida.datos.getCiudades().get(i).getNombre();
            int infeccion_ciudad = controlPartida.datos.getCiudades().get(i).getInfeccion();
            SqlCIUDADES.append("CIUDADES('" + nombre_ciudad + "', " + infeccion_ciudad + ")");
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

        String sql = "INSERT INTO PARTIDA VALUES(0 , null , " + diff + ", " + rondas + ", " + acciones + ", " + brotes
                + ", ARRAY_CIUDADES(" + SqlCIUDADES.toString() + "), ARRAY_VACUNAS(" + SqlVACUNAS.toString() + "), null)";

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
	
}
