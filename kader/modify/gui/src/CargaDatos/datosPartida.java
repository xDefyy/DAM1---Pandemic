package CargaDatos;
import java.util.ArrayList;

import objetos.ciudad;
import objetos.virus;
import objetos.vacunas;

public class datosPartida {
	
	protected static ArrayList<ciudad> ciudades = new ArrayList<>();
	protected static ArrayList<virus> virus = new ArrayList<>();
	protected static ArrayList<vacunas> vacunas = new ArrayList<>();
	
	protected static int brotes = 1;
	protected static int rondas = 0;
	protected static int pDesarrollo = 0;
	protected static int acciones = 4;
	
	public datosPartida(ArrayList<ciudad> ciudades, ArrayList<virus> virus, ArrayList<vacunas> vacunas, int brotes,
			int rondas, int pDesarrollo, int acciones) {
		this.ciudades = ciudades;
		this.virus = virus;
		this.vacunas = vacunas;
		this.brotes = brotes;
		this.rondas = rondas;
		this.pDesarrollo = pDesarrollo;
		this.acciones = acciones;
	}

	public ArrayList<ciudad> getCiudades() {
		return ciudades;
	}
	
	public void setCiudades(ArrayList<ciudad> ciudades) {
		this.ciudades = ciudades;
	}
	
	public ArrayList<virus> getVirus() {
		return virus;
	}
	
	public void setVirus(ArrayList<virus> virus) {
		this.virus = virus;
	}
	
	public ArrayList<vacunas> getVacunas() {
		return vacunas;
	}
	
	public void setVacunas(ArrayList<vacunas> vacunas) {
		this.vacunas = vacunas;
	}
	
	public int getBrotes() {
		return brotes;
	}
	
	public void setBrotes(int brotes) {
		this.brotes = brotes;
	}
	
	public int getRondas() {
		return rondas;
	}
	
	public void setRondas(int rondas) {
		this.rondas = rondas;
	}
	
	public double getpDesarrollo() {
		return pDesarrollo;
	}
	
	public void setpDesarrollo(int pDesarrollo) {
		this.pDesarrollo = pDesarrollo;
	}
	
	public int getAcciones() {
		return acciones;
	}
	
	public void setAcciones(int acciones) {
		this.acciones = acciones;
	}
	
	public static void cargarDatos() {
		
		controlDatos.cargarCiudades();
		controlDatos.cargarVacunas();
		controlDatos.cargarVirus();
		
//		controlDatos.cargarRecord();
		
	}
	
}
