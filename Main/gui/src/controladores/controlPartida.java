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

		datos = new datosPartida(controlDatos.ciudades, controlDatos.virus, controlDatos.vacunas, 0, 0, pdesarrollo, 4);
		
		progresoA = datos.getpDesarrollo();
		progresoB = datos.getpDesarrollo();
		progresoG = datos.getpDesarrollo();
		progresoD = datos.getpDesarrollo();
		aux = datos.getpDesarrollo();

		partida.rondas.setText("Ronda: " + datos.getRondas());

		gestionar_Infeccion();
	}

	public static void iniciar_Partida_Guardada(String id) {

	}

	public static void gestionar_Turno() {

		int turno = datos.getRondas();
		turno++;
		
		// infeccion por ronda en ciudades
		datos.setRondas(turno);
		partida.rondas.setText("Ronda: " + datos.getRondas());

		datos.setAcciones(4);

		partida.acciones.setText("Acciones = " + datos.getAcciones());
		// limpia el texto
		partida.textArea.setText("");

	}

	public static void gestionar_Vacuna(int valor) {
		int acciones = datos.getAcciones();
		if (acciones == 4) {
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
											System.out.println("Has realizado el " + vacuna.getPorcentaje() + "% de la vacuna " + vacuna.getNombre());
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
										if (vacuna.getColor().equalsIgnoreCase("rojo")) {
											vacuna.setPorcentaje(partida.Beta.getValue());
											System.out.println("Has realizado el " + vacuna.getPorcentaje() + "% de la vacuna " + vacuna.getNombre());
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
										if (vacuna.getColor().equalsIgnoreCase("verde")) {
											vacuna.setPorcentaje(partida.Gamma.getValue());
											System.out.println("Has realizado el " + vacuna.getPorcentaje() + "% de la vacuna " + vacuna.getNombre());
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
										if (vacuna.getColor().equalsIgnoreCase("negro")) {
											vacuna.setPorcentaje(partida.Delta.getValue());
											System.out.println("Has realizado el " + vacuna.getPorcentaje() + "% de la vacuna " + vacuna.getNombre());
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
			datos.setAcciones(0);
			partida.acciones.setText("Acciones : " + datos.getAcciones());
		} else {
			
		}
	}

	public static void gestionar_Infeccion() {
		int infectadoStart = Integer.valueOf(controlDatos.numCiudadesInfectadasInicio);
		int numCiudadesxRonda = Integer.valueOf(controlDatos.numCiudadesInfectadasRonda);

		if (newGame) {
			// random para infectar las ciudades determinada por la dificultad
			Random rand = new Random();
			int random = 0;

			for (int i = 0; i < infectadoStart; i++) {
				random = rand.nextInt(48);
				int nivel = datos.getCiudades().get(random).getInfeccion();
				if (nivel == 1) {
					infectadoStart++;
				} else {
					nivel++;
					datos.getCiudades().get(random).setInfeccion(nivel);
				}
			}
		}
	}

	public static void gestionar_Brote() {

//		for (objetos.ciudad ciudad : datos.getCiudades()) {	
//			datos.getCiudades().get(ciudad).getInfeccion();
//		}

		// Confio en que funciona
		for (int i = 0; i < datos.getCiudades().size(); i++) {
			if (datos.getCiudades().get(i).getInfeccion() == 4) {
				for (int j = 0; j < datos.getCiudades().get(i).getCiudadesColindantes().length; j++) {
					if (datos.getCiudades().get(j).getInfeccion() == 3) {
						datos.setBrotes(datos.getBrotes() + 1);
					}
				}

			}

		}

	}

	public static void gestionar_Fin_Partida() {
		int derrotaBrote = Integer.valueOf(controlDatos.numBrotesDerrota);
		int derrotaEnfermedad = Integer.valueOf(controlDatos.numEnfermedadesActivasDerrota);
		int infeccionTotal = 0;

		if (datos.getBrotes() == derrotaBrote) {
			//Salir de la partida
		}
		
		for (int i = 0; i < datos.getCiudades().size(); i++) {
			 infeccionTotal += datos.getCiudades().get(i).getInfeccion();
			 if (infeccionTotal == derrotaEnfermedad) {
				 //Salir de la partida
			 }	
		}
		
	}


	public static void gestionar_Cura() {
		
		if ((datos.getAcciones() > 0) && (datos.getCiudades().get(0).getInfeccion() > 0)) {  //insertar boton donde liqi llora (el boton va assignado a un objeto de ciudad)
				
			datos.getCiudades().get(0).setInfeccion(datos.getCiudades().get(0).getInfeccion()-1);
			
			//vacuna + comprobacion de enfermedad de ciudad
			
			datos.setAcciones(datos.getAcciones()-1);
			partida.acciones.setText("Acciones : " + datos.getAcciones());
			
		}
		
		
	}

}
