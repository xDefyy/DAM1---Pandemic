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
	public static int random;
	public static boolean newGame = false;
	public static int ciudadSize = 0;

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
		gestionar_InfeccionNewGame();
		partida.ciudadesInf.setText("Ciudades Infectadas: " + ciudadesInfectadas());
		partida.rondas.setText("Ronda: " + datos.getRondas());
		partida.brotes.setText("Brotes:" + datos.getBrotes());
		
	}
	
	public static void iniciar_Partida_Guardada(String id) {

	}
	
	public static int ciudadesInfectadas() {
		int x = 0;
		for (int i = 0; i < datos.getCiudades().size(); i++) {
			 x += datos.getCiudades().get(i).getInfeccion();
		}
		
		return x;
	}

	public static void gestionar_Turno() {
		Thread vac = new Thread(new Runnable() {

			@Override
			public void run() {
				partida.finalizarRonda.setEnabled(false);
				gestionar_InfeccionNewRound();
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

				partida.acciones.setText("Acciones: " + datos.getAcciones());
				// limpia el texto
				gestionar_InfeccionNewRound();
				try {
					Thread.sleep(1800);
					partida.finalizarRonda.setEnabled(true);
				} catch (InterruptedException e) {
			        e.printStackTrace();
			    }
				partida.ciudadesInf.setText("Ciudades Infectadas: " + ciudadesInfectadas());
			}
		});
		vac.start();
		

	}
	
	
	
	public static void gestionar_Vacuna(int valor) {
		if (datos.getAcciones() == 4) {
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
								}	if (partida.Alfa.getValue() == progresoA) {
									System.out.println("Franko: Has desarrolado el " + partida.Alfa.getValue() + "% y gastado todas tus acciones.");
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
								}  if (partida.Beta.getValue() == progresoB) {
									System.out.println("Franko: Has desarrolado el " + partida.Beta.getValue() + "% y gastado todas tus acciones.");
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
								}  if (partida.Gamma.getValue() == progresoG) {
									System.out.println("Franko: Has desarrolado el " + partida.Gamma.getValue() + "% y gastado todas tus acciones.");
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
									
								}  if (partida.Delta.getValue() == progresoD) {
									System.out.println("Franko: Has desarrolado el " + partida.Delta.getValue() + "% y gastado todas tus acciones.");
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
		} else {
			System.out.println("Franko: No tienes acciones suficientes.");
		}
			
	}
	
	public static void gestionAcciones() {
		controlPartida.datos.setAcciones(0);
        partida.acciones.setText("Acciones : " + controlPartida.datos.getAcciones());
        partida.DDelta.setEnabled(false);
        partida.DAlfa.setEnabled(false);
        partida.DGamma.setEnabled(false);
        partida.DBeta.setEnabled(false);
	}
	
	public static void gestionar_InfeccionNewGame() {
		int infectadoStart = Integer.valueOf(controlDatos.numCiudadesInfectadasInicio);


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
	public static void gestionar_InfeccionNewRound() {
		int numCiudadesxRonda = Integer.valueOf(controlDatos.numCiudadesInfectadasRonda);
		Random rand = new Random();
		random = 0;

		for (int i = 0; i < numCiudadesxRonda; i++) {
			random = rand.nextInt(48);
			int nivel = datos.getCiudades().get(random).getInfeccion();
				nivel++;
				datos.getCiudades().get(random).setInfeccion(nivel);
				if (datos.getCiudades().get(random).getInfeccion() < 4) {
					System.out.println("Se ha infectado " + datos.getCiudades().get(random).getNombre() + " con el nivel " + datos.getCiudades().get(random).getInfeccion());
				}
				
				gestionar_Brote();
				try {
			        Thread.sleep(350); 
			    } catch (InterruptedException e) {
			        e.printStackTrace();
			    }
		}
	}

	public static void gestionar_Brote() {
		
		//comprobacion de brote
		if (datos.getCiudades().get(random).getInfeccion() == 4) {
			datos.setBrotes(datos.getBrotes()+1);
			System.out.println("Se ha infectado " + datos.getCiudades().get(random).getNombre() + " se ha producido un brote.");
			try {
		        Thread.sleep(500); 
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
			datos.getCiudades().get(random).setInfeccion(3);
			partida.brotes.setText("Brotes:" + datos.getBrotes());
			gestionar_Fin_Partida();
			for (int i = 0; i < datos.getCiudades().get(random).getCiudadesColindantes().length; i++) {
				for (int j = 0; j < datos.getCiudades().size(); j++) {
					if (datos.getCiudades().get(random).getCiudadesColindantes()[i].equalsIgnoreCase(datos.getCiudades().get(j).getNombre())) {
						datos.getCiudades().get(j).setInfeccion(datos.getCiudades().get(j).getInfeccion()+1);
						if (datos.getCiudades().get(j).getInfeccion() == 3) {
							datos.setBrotes(datos.getBrotes() + 1);
							partida.brotes.setText("Brotes:" + datos.getBrotes());
							System.out.println("De las colindades se ha creado otro brote en: " + datos.getCiudades().get(j).getNombre());
							try {
						        Thread.sleep(1000); 
						    } catch (InterruptedException e) {
						        e.printStackTrace();
						    }
							gestionar_Fin_Partida();
							
						} else {
							datos.getCiudades().get(j).setInfeccion(datos.getCiudades().get(j).getInfeccion()+1);
						}
					}
				}
				
			}
		}
	}

	public static void gestionar_Fin_Partida() {
		int derrotaBrote = Integer.valueOf(controlDatos.numBrotesDerrota);
		int derrotaEnfermedad = Integer.valueOf(controlDatos.numEnfermedadesActivasDerrota);
		int infeccionTotal = 0;

		if (datos.getBrotes() >= derrotaBrote) {
			System.out.println("Has perdido por los brotes");		//cambiar por panel de Franco aparece diciendo muy bien hecho (si pierdes)
		}
		
		for (int i = 0; i < datos.getCiudades().size(); i++) {
			 infeccionTotal += datos.getCiudades().get(i).getInfeccion();
			 if (infeccionTotal >= derrotaEnfermedad) {
				 System.out.println("has perdido por infecciones");
				 break;
			 } else {
				 infeccionTotal = 0;
			 }
		}	
	}

	public static void gestionar_Cura() {
		Thread vac = new Thread(new Runnable() {

			@Override
			public void run() {
				if ((datos.getAcciones() > 0) && (datos.getCiudades().get(ciudadSize)).getInfeccion() > 0 || datos.getCiudades().get(ciudadSize).getInfeccion() < 0 && partida.ciudadSeleccionada == true)  {
					//funcion de curar con vacuna desarrollada
					if (datos.getCiudades().get(ciudadSize).getEnfermedad().equalsIgnoreCase("Alfa") && datos.getVacunas().get(0).getPorcentaje() == 100) {
						datos.getCiudades().get(ciudadSize).setInfeccion(0);
						System.out.println("Has curado la ciudad " + datos.getCiudades().get(ciudadSize).getNombre() + " con la vacuna " + datos.getVacunas().get(0).getNombre() + " y has dejado el nivel de infeccion en: " + datos.getCiudades().get(ciudadSize).getInfeccion());
						datos.setAcciones(datos.getAcciones()-1);
						partida.acciones.setText("Acciones: " + datos.getAcciones());
					} else if (datos.getCiudades().get(ciudadSize).getEnfermedad().equalsIgnoreCase("Beta") && datos.getVacunas().get(1).getPorcentaje() == 100) {
						datos.getCiudades().get(ciudadSize).setInfeccion(0);
						System.out.println("Has curado la ciudad " + datos.getCiudades().get(ciudadSize).getNombre() + " con la vacuna " + datos.getVacunas().get(1).getNombre() + " y has dejado el nivel de infeccion en: " + datos.getCiudades().get(ciudadSize).getInfeccion());
						datos.setAcciones(datos.getAcciones()-1);
						partida.acciones.setText("Acciones: " + datos.getAcciones());
					} else if (datos.getCiudades().get(ciudadSize).getEnfermedad().equalsIgnoreCase("Gamma") && datos.getVacunas().get(2).getPorcentaje() == 100) {
						datos.getCiudades().get(ciudadSize).setInfeccion(0);
						System.out.println("Has curado la ciudad " + datos.getCiudades().get(ciudadSize).getNombre() + " con la vacuna " + datos.getVacunas().get(2).getNombre() + " y has dejado el nivel de infeccion en: " + datos.getCiudades().get(ciudadSize).getInfeccion());
						datos.setAcciones(datos.getAcciones()-1);
						partida.acciones.setText("Acciones: " + datos.getAcciones());
					} else if (datos.getCiudades().get(ciudadSize).getEnfermedad().equalsIgnoreCase("Delta") && datos.getVacunas().get(3).getPorcentaje() == 100) {
						datos.getCiudades().get(ciudadSize).setInfeccion(0);
						System.out.println("Has curado la ciudad " + datos.getCiudades().get(ciudadSize).getNombre() + " con la vacuna " + datos.getVacunas().get(3).getNombre() + " y has dejado el nivel de infeccion en: " + datos.getCiudades().get(ciudadSize).getInfeccion());
						datos.setAcciones(datos.getAcciones()-1);
						partida.acciones.setText("Acciones: " + datos.getAcciones());
					} else if (datos.getCiudades().get(ciudadSize).getEnfermedad().equalsIgnoreCase("Alfa") && datos.getVacunas().get(0).getPorcentaje() != 100) {
						datos.getCiudades().get(ciudadSize).setInfeccion(datos.getCiudades().get(ciudadSize).getInfeccion()-1);
						System.out.println("Has curado la ciudad " + datos.getCiudades().get(ciudadSize).getNombre() + " sin la vacuna " + datos.getVacunas().get(0).getNombre() + " y has dejado el nivel de infeccion en: " + datos.getCiudades().get(ciudadSize).getInfeccion());
						datos.setAcciones(datos.getAcciones()-1);
						partida.acciones.setText("Acciones: " + datos.getAcciones());
					} else if (datos.getCiudades().get(ciudadSize).getEnfermedad().equalsIgnoreCase("Beta") && datos.getVacunas().get(1).getPorcentaje() != 100) {
						datos.getCiudades().get(ciudadSize).setInfeccion(datos.getCiudades().get(ciudadSize).getInfeccion()-1);
						System.out.println("Has curado la ciudad " + datos.getCiudades().get(ciudadSize).getNombre() + " sin la vacuna " + datos.getVacunas().get(1).getNombre() + " y has dejado el nivel de infeccion en: " + datos.getCiudades().get(ciudadSize).getInfeccion());
						datos.setAcciones(datos.getAcciones()-1);
						partida.acciones.setText("Acciones: " + datos.getAcciones());
					} else if (datos.getCiudades().get(ciudadSize).getEnfermedad().equalsIgnoreCase("Gamma") && datos.getVacunas().get(2).getPorcentaje() != 100) {
						datos.getCiudades().get(ciudadSize).setInfeccion(datos.getCiudades().get(ciudadSize).getInfeccion()-1);
						System.out.println("Has curado la ciudad " + datos.getCiudades().get(ciudadSize).getNombre() + " sin la vacuna " + datos.getVacunas().get(2).getNombre() + " y has dejado el nivel de infeccion en: " + datos.getCiudades().get(ciudadSize).getInfeccion());
						datos.setAcciones(datos.getAcciones()-1);
						partida.acciones.setText("Acciones: " + datos.getAcciones());
					} else if (datos.getCiudades().get(ciudadSize).getEnfermedad().equalsIgnoreCase("Delta") && datos.getVacunas().get(3).getPorcentaje() != 100) {
						datos.getCiudades().get(ciudadSize).setInfeccion(datos.getCiudades().get(ciudadSize).getInfeccion()-1);
						System.out.println("Has curado la ciudad " + datos.getCiudades().get(ciudadSize).getNombre() + " sin la vacuna " + datos.getVacunas().get(3).getNombre() + " y has dejado el nivel de infeccion en: " + datos.getCiudades().get(ciudadSize).getInfeccion());
						datos.setAcciones(datos.getAcciones()-1);
						partida.acciones.setText("Acciones: " + datos.getAcciones());
					} 
				} else if (datos.getAcciones() == 0) {
					System.out.println("Franko: No tienes acciones...");
				} else if (datos.getCiudades().get(ciudadSize).getInfeccion() == 0) {
					System.out.println("Franko: No esta infectado la ciudad: " + datos.getCiudades().get(ciudadSize).getNombre());
				} 
			}
		});
		vac.start();
		
		
	}

}
