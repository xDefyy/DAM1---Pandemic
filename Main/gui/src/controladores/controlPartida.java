package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;

import CargaDatos.controlDatos;
import inicio.Main;
import intefaz.CargarParty;
import intefaz.partida;
import CargaDatos.datosPartida;
import CargaDatos.savetoTXT;

public class controlPartida {

	public static datosPartida datos;
	public static int progresoA;
	public static int progresoB; 
	public static int progresoG;
	public static int progresoD; 
	public static int aux;
	public static boolean newGame = false;
	
	public static void iniciar_Partida() {
		
		newGame = true;
		int pdesarrollo = Integer.valueOf(controlDatos.desarrolloVacuna);
		
		controlDatos.cargarCiudades();
		controlDatos.cargarVacunas();
		controlDatos.cargarVirus();
		
		datos = new datosPartida(datosPartida.ciudades, datosPartida.virus, datosPartida.vacunas, 0,0,pdesarrollo,4);
    	System.out.println(controlPartida.datos.getpDesarrollo());
    	progresoA = datos.getpDesarrollo();
    	progresoB = datos.	getpDesarrollo();
    	progresoG = datos.getpDesarrollo();
    	progresoD = datos.getpDesarrollo();
    	aux = datos.getpDesarrollo();
		

    	gestionar_Infeccion();
	}
	
	public static void iniciar_Partida_Guardada(String id) {

	}

	public static void gestionar_Turno() {

	}

	public static void gestionar_Vacuna(int valor) {
		if (valor == 0) {
			Thread thread = new Thread(new Runnable() {
				public void run() {
					try {
						for (int i = partida.Alfa.getValue(); i <= progresoA; i++) {
							partida.Alfa.setValue(i); // Actualiza el valor de la barra de progreso
							partida.Alfa.setString("Progreso VIH = " + partida.Alfa.getValue());
							Thread.sleep(50); // Espera un momento para simular el progreso
							if (partida.Alfa.getValue() == 100) {
								partida.Alfa.setString("VIH COMPLETADO!");
								System.out.println("¡Bien hecho!");
								partida.DAlfa.setEnabled(false);
							}
							if (partida.Alfa.getValue() == aux) {
								for (objetos.vacunas vacuna : datos.getVacunas()) {
									if (vacuna.getColor().equalsIgnoreCase("azul")) {
										vacuna.setPorcentaje(partida.Alfa.getValue());
										System.out.println(vacuna.getPorcentaje());
									}
								}
							}
						}
						progresoA += aux;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			thread.start();
		} else if (valor == 1) {
			Thread thread = new Thread(new Runnable() {
				public void run() {
					try {
						for (int i = partida.Beta.getValue(); i <= progresoB; i++) {
							partida.Beta.setValue(i); // Actualiza el valor de la barra de progreso
							partida.Beta.setString("Progreso CANCER = " + partida.Beta.getValue());
							Thread.sleep(50); // Espera un momento para simular el progreso
							if (partida.Beta.getValue() == 100) {
								partida.Beta.setString("CANCER COMPLETADO!");
								System.out.println("¡Bien hecho!");
								partida.DBeta.setEnabled(false);
							}
							if (partida.Beta.getValue() == aux) {
								for (objetos.vacunas vacuna : datos.getVacunas()) {
									if (vacuna.getColor().equalsIgnoreCase("azul")) {
										vacuna.setPorcentaje(partida.Beta.getValue());
										System.out.println(vacuna.getPorcentaje());
									}
								}
							}
						}
						progresoB += aux;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			thread.start();
		} else if (valor == 2) {
			Thread thread = new Thread(new Runnable() {
				public void run() {
					try {
						for (int i = partida.Gamma.getValue(); i <= progresoG; i++) {
							partida.Gamma.setValue(i); // Actualiza el valor de la barra de progreso
							partida.Gamma.setString("Progreso SARS = " + partida.Gamma.getValue());
							Thread.sleep(50); // Espera un momento para simular el progreso
							if (partida.Gamma.getValue() == 100) {
								partida.Gamma.setString("SARS COMPLETADO!");
								System.out.println("¡Bien hecho!");
								partida.DGamma.setEnabled(false);
							}
							if (partida.Gamma.getValue() == aux) {
								for (objetos.vacunas vacuna : datos.getVacunas()) {
									if (vacuna.getColor().equalsIgnoreCase("azul")) {
										vacuna.setPorcentaje(partida.Gamma.getValue());
										System.out.println(vacuna.getPorcentaje());
									}
								}
							}
						}
						progresoG += aux;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			thread.start();
		} else {
			Thread thread = new Thread(new Runnable() {
				public void run() {
					try {
						for (int i = partida.Delta.getValue(); i <= progresoD; i++) {
							partida.Delta.setValue(i); // Actualiza el valor de la barra de progreso
							partida.Delta.setString("Progreso NIGGA = " + partida.Delta.getValue());
							Thread.sleep(50); // Espera un momento para simular el progreso
							if (partida.Delta.getValue() == 100) {
								partida.Delta.setString("NIGGA COMPLETADO!");
								System.out.println("¡Bien hecho!");
								partida.DDelta.setEnabled(false);
							}
							if (partida.Delta.getValue() == aux) {
								for (objetos.vacunas vacuna : datos.getVacunas()) {
									if (vacuna.getColor().equalsIgnoreCase("azul")) {
										vacuna.setPorcentaje(partida.Delta.getValue());
										System.out.println(vacuna.getPorcentaje());
									}
								}
							}
						}
						progresoD += aux;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			thread.start();
		}
	}

	public static void gestionar_Infeccion() {
		int infectadoStart = Integer.valueOf(controlDatos.numCiudadesInfectadasInicio);
		int numCiudadesxRonda = Integer.valueOf(controlDatos.numCiudadesInfectadasRonda);
		
		if (newGame) {
			//random para infectar las ciudades determinada por la dificultad
			Random rand = new Random();
			int random = 0;
			
			for (int i = 0; i < infectadoStart; i++) {
				random = rand.nextInt(48);
				for (int j = 0; j < datos.getCiudades().size(); j++) {
					if (j == random) {
						int nivel = datos.ciudades.get(j).getInfeccion();
						if (nivel == 1) {
							infectadoStart++;	
						} else {
							nivel++;
							datos.ciudades.get(j).setInfeccion(nivel);
						}
					}
				}
			}
			savetoTXT.guardar_ciudades();
			savetoTXT.guardar_parametros();
			savetoTXT.guardar_vacunas();
			
		}
		
	}

	public static void gestionar_Brote() {

	}

	public static void gestionar_Fin_Partida() {
		int derrotaBrote = Integer.valueOf(controlDatos.numBrotesDerrota);
		int derrotaEnfermedad = Integer.valueOf(controlDatos.numEnfermedadesActivasDerrota);
	}

	public static void gestionar_Frase() {

	}

	public static void gestionar_Cura() {
		System.out.println("hola");
	}

}
