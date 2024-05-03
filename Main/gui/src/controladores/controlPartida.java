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
	public static boolean desarrolloPush = false;

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
		
		
		partida.DDelta.setEnabled(true);
		partida.DAlfa.setEnabled(true);
		partida.DGamma.setEnabled(true);
		partida.DBeta.setEnabled(true);
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
								datos.getVacunas().get(0).setPorcentaje(partida.Alfa.getValue());
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
								datos.getVacunas().get(1).setPorcentaje(partida.Beta.getValue());
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
								datos.getVacunas().get(2).setPorcentaje(partida.Gamma.getValue());
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
								datos.getVacunas().get(3).setPorcentaje(partida.Delta.getValue());
							}
							progresoD += aux;
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				});
				thread.start();
			}
			gestionAcciones();
	}
	
	public static void gestionAcciones() {
		controlPartida.datos.setAcciones(0);
        partida.acciones.setText("Acciones : " + controlPartida.datos.getAcciones());
        partida.DDelta.setEnabled(false);
        partida.DAlfa.setEnabled(false);
        partida.DGamma.setEnabled(false);
        partida.DBeta.setEnabled(false);
        System.out.println("Has gastado 4 acciones!");
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
					} else if (datos.getCiudades().get(j).getInfeccion() < 3 ) {
						datos.getCiudades().get(j).setInfeccion(datos.getCiudades().get(j).getInfeccion()+1);
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
			System.exit(0);		//cambiar por panel de Franco aparece diciendo muy bien hecho (si pierdes)
		}
		
		for (int i = 0; i < datos.getCiudades().size(); i++) {
			 infeccionTotal += datos.getCiudades().get(i).getInfeccion();
			 if (infeccionTotal == derrotaEnfermedad) {
				 System.exit(0);	//cambiar por panel de GAME OVER
			 }	
		}	
	}

	public static void gestionar_Cura(int x) {
		
		if ((datos.getAcciones() > 0) && (datos.getCiudades().get(x).getInfeccion() > 0)) {  //insertar boton donde liqi llora "0" (el boton va assignado a un objeto de ciudad)
			if (datos.getVacunas().get(x).getPorcentaje() == 100 && datos.getCiudades().get(x).getEnfermedad().equals("Alpha") && datos.getCiudades().get(x).getInfeccion() > 1) {  // && boton ciudad
				datos.getCiudades().get(x).setInfeccion(datos.getCiudades().get(x).getInfeccion()-1);
				datos.setAcciones(0);
			} else if (datos.getVacunas().get(1).getPorcentaje() == 100 && datos.getCiudades().get(x).getEnfermedad().equals("Beta") && datos.getCiudades().get(x).getInfeccion() > 1) {
				datos.getCiudades().get(0).setInfeccion(datos.getCiudades().get(x).getInfeccion()-1);
				datos.setAcciones(0);
			} else if (datos.getVacunas().get(2).getPorcentaje() == 100 && datos.getCiudades().get(x).getEnfermedad().equals("Delta") && datos.getCiudades().get(x).getInfeccion() > 1) {
				datos.getCiudades().get(0).setInfeccion(datos.getCiudades().get(x).getInfeccion()-1);
				datos.setAcciones(0);
			} else if (datos.getVacunas().get(3).getPorcentaje() == 100 && datos.getCiudades().get(x).getEnfermedad().equals("Gamma") && datos.getCiudades().get(x).getInfeccion() > 1) {
				datos.getCiudades().get(0).setInfeccion(datos.getCiudades().get(x).getInfeccion()-1);
				datos.setAcciones(0);	
			}
			
			datos.getCiudades().get(0).setInfeccion(datos.getCiudades().get(0).getInfeccion()-1);
			
			datos.setAcciones(datos.getAcciones()-1);
			partida.acciones.setText("Acciones : " + datos.getAcciones());
			
		}
		
		
	}

}
