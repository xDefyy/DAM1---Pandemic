package CargaDatos;
import java.util.ArrayList;

import objetos.ciudad;
import objetos.virus;
import objetos.vacunas;

/**
 * @author Liqi y Kader
 * 
 */

public class datosPartida {
	
	private  ArrayList<ciudad> ciudades = new ArrayList<>();
	private  ArrayList<virus> virus = new ArrayList<>();
	private  ArrayList<vacunas> vacunas = new ArrayList<>();
	private int brotes;
	private int rondas;
	private int pDesarrollo;
	private int acciones;
	private int puntuancion;
	
	public datosPartida(ArrayList<ciudad> ciudades, ArrayList<virus> virus, ArrayList<vacunas> vacunas, int brotes,
		int rondas, int pDesarrollo, int acciones, int puntuacion) {
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
	
	public int getpDesarrollo() {
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

	public int getPuntuancion() {
		return puntuancion;
	}

	public void setPuntuancion(int puntuancion) {
		this.puntuancion = puntuancion;
	}
	
	
	
}
