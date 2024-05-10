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
import objetos.ciudad;
import controladores.controlPartida;

public class con__BBDD {

	


	// numero de rondas, nombre jugador, fecha, resultado (W , L), Puntos
	
	
	
	

	

	
	
	public static String ganar_perder = "";
	
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
            boolean ciudadNuked = controlPartida.datos.getCiudades().get(i).isNuke();
            String nuked = "";
            if (ciudadNuked == true) {
            	nuked = "S";
            } else if (ciudadNuked == false) {
            	nuked = "N";
            }
            int infeccion_ciudad = controlPartida.datos.getCiudades().get(i).getInfeccion();
            SqlCIUDADES.append("CIUDADES('" + nombre_ciudad + "', " + infeccion_ciudad + "'," + nuked + "'" + ")");
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

        String sql = "INSERT INTO PARTIDA VALUES(0 ," + 1 + ", " + diff + ", " + rondas + ", " + acciones + ", " + brotes
                + ", ARRAY_CIUDADES(" + SqlCIUDADES.toString() + "), ARRAY_VACUNAS(" + SqlVACUNAS.toString() + "), " + "'" + ganar_perder + "', SYSDATE)";

        try {
            Statement st = con.createStatement();
            st.execute(sql);

            System.out.println("Insert hecho correctamente correctamente");
        } catch (SQLException e) {
            System.out.println("Ha habido un error en el Insert " + e);
        }
    }
	
	public static void selectPartida(Connection con) {
	    String sqlCiudades = "SELECT p.id_p, p.id_partida, p.dificultad, p.rondas, p.acciones, p.brotes, p.wl, c.nombre, c.infeccion FROM PARTIDA p, TABLE(p.ARRAY_CIUDADES) c WHERE ID_PARTIDA = 4";
	    String sqlVacunas = "SELECT v.color, v.porcentaje FROM PARTIDA p, TABLE(p.ARRAY_VACUNAS) v WHERE ID_PARTIDA = 4";

	    try {
	        Statement stCiudades = con.createStatement();
	        ResultSet rsCiudades = stCiudades.executeQuery(sqlCiudades);

	        while (rsCiudades.next()) {
	            String nombreCiudad = rsCiudades.getString("nombre");
	            int infeccionCiudad = rsCiudades.getInt("infeccion");
	            
	            for (int i = 0; i < 48; i++) {
	            	if (controlPartida.datos.getCiudades().get(i).getNombre().equalsIgnoreCase(nombreCiudad)) {
		                controlPartida.datos.getCiudades().get(i).setInfeccion(infeccionCiudad);
	            	}
	            }
	        }

	        Statement stVacunas = con.createStatement();
	        ResultSet rsVacunas = stVacunas.executeQuery(sqlVacunas);

	        while (rsVacunas.next()) {
	            String color = rsVacunas.getString("color");
	            int porcentaje = rsVacunas.getInt("porcentaje");

	            for (int i = 0; i < 4; i++) {
	            	if (controlPartida.datos.getVacunas().get(i).getColor().equalsIgnoreCase(color)) {
	            		controlPartida.datos.getVacunas().get(i).setPorcentaje(porcentaje);
	            	}
//	            	
//	                controlPartida.datos.getVacunas().get(i).setColor(color);
//	                controlPartida.datos.getVacunas().get(i).setPorcentaje(porcentaje);

	            }
	            
	            System.out.println("--------------------");
                System.out.println("soy el 0 " +controlPartida.datos.getVacunas().get(0).getPorcentaje());
                System.out.println("soy el 1:" +controlPartida.datos.getVacunas().get(1).getPorcentaje());
                System.out.println("soy el 2:" +controlPartida.datos.getVacunas().get(2).getPorcentaje());
                System.out.println(controlPartida.datos.getVacunas().get(3).getPorcentaje());
                System.out.println("--------------------");
                
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("MAL");
	    }
	    System.out.println("Select hecho correctamente correctamente");
	}

}
