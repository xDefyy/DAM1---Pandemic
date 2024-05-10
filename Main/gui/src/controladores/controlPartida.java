package controladores;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

import CargaDatos.controlDatos;
import inicio.Main;
import intefaz.CargarParty;
import intefaz.partida;
import objetos.ciudad;
import CargaDatos.datosPartida;

public class controlPartida {

	public static datosPartida datos;
	public static int progresoA;
	public static int progresoB;
	public static int progresoG;
	public static int progresoD;
	public static int aux;
	public static int random;
	public static int ciudadSize = 0;
	public static String ciudadNombre = "";
	public static boolean resetGame = false;

	public static void iniciar_Partida() {
		
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

		if (!resetGame) {
			gestionar_InfeccionNewGame();
		} else if (resetGame) {
			resetGame();
			gestionar_InfeccionNewGame();
		}
		
		
		
		partida.ciudadesInf.setText("" + ciudadesInfectadas());
		partida.rondas.setText("" + datos.getRondas());
		partida.brotes.setText("" + datos.getBrotes());
		
		try {
			Thread.sleep(500);
			partida.nuke.setEnabled(true);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public static void resetGame() {

		for (int i = 0; i < datos.getCiudades().size(); i++) {
			
			if (datos.getCiudades().get(i).getInfeccion() != 0) {
				datos.getCiudades().get(i).setInfeccion(0);
				ponerImages(i, comprobacionNombreBoton(datos.getCiudades().get(i).getNombre()));
			} else if (datos.getCiudades().get(i).isNuke()) {
				datos.getCiudades().get(i).setNuke(false);
			}
		}
		partida.textArea.setText("");
		partida.DAlfa.setEnabled(true);
		partida.DBeta.setEnabled(true);
		partida.DGamma.setEnabled(true);
		partida.DDelta.setEnabled(true);
		partida.Alfa.setValue(0);
		partida.Beta.setValue(0);
		partida.Delta.setValue(0);
		partida.Gamma.setValue(0);
		partida.Alfa.setString("VIH: " + partida.Alfa.getValue() + "%");
		partida.Gamma.setString("SARS: " + partida.Beta.getValue() + "%");
		partida.Gamma.setString("SARS: " + partida.Beta.getValue() + "%");
		partida.Delta.setString("NIGGA: " + partida.Beta.getValue() + "%");
		for (int i = 0; i < datos.getVacunas().size(); i++) {
			if (datos.getVacunas().get(i).getPorcentaje() != 0) {
				datos.getVacunas().get(i).setPorcentaje(0);
			}
		}
		datos.setBrotes(0);
		partida.brotes.setText("0");
		partida.acciones.setText("4");
		partida.rondas.setText("0");
		for (Component c : partida.game.getComponents()) {

			if (c instanceof JButton) {
				((JButton) c).setBorderPainted(false);
				((JButton) c).setBorder(null);
			}
		}
	}

	public static void iniciar_Partida_Guardada(String id) {

		int pdesarrollo = Integer.valueOf(controlDatos.desarrolloVacuna);
		
		controlDatos.cargarCiudades();
		controlDatos.cargarVacunas();
		controlDatos.cargarVirus();
		
		datos = new datosPartida(controlDatos.ciudades, controlDatos.virus, controlDatos.vacunas, 0, 0, pdesarrollo, 4);

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

				int turno = datos.getRondas();
				turno++;

				// infeccion por ronda en ciudades
				datos.setRondas(turno);
				partida.rondas.setText("" + datos.getRondas());

				datos.setAcciones(4);

				partida.acciones.setText("" + datos.getAcciones());
				// limpia el texto
				gestionar_InfeccionNewRound();
				try {
					Thread.sleep(1800);
					partida.finalizarRonda.setEnabled(true);
					if (datos.getVacunas().get(0).getPorcentaje() != 100) {
						partida.DAlfa.setEnabled(true);
					}
					if (datos.getVacunas().get(1).getPorcentaje() != 100) {
						partida.DBeta.setEnabled(true);
					}
					if (datos.getVacunas().get(2).getPorcentaje() != 100) {
						partida.DGamma.setEnabled(true);
					}
					if (datos.getVacunas().get(3).getPorcentaje() != 100) {
						partida.DDelta.setEnabled(true);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				partida.ciudadesInf.setText("" + ciudadesInfectadas());
				
				//TODO 
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
								partida.Alfa.setString("VIH: " + partida.Alfa.getValue() + "%");
								Thread.sleep(50); // Espera un momento para simular el progreso
								if (partida.Alfa.getValue() == 100) {
									partida.Alfa.setString("Completado VIH");
									System.out.println("Franko: Bien hecho!");
									partida.DAlfa.setEnabled(false);
								}
								if (partida.Alfa.getValue() == progresoA) {
									System.out.println("Franko: Has desarrolado el " + partida.Alfa.getValue()
											+ "% y gastado todas tus acciones.");
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
								partida.Beta.setString("CANCER: " + partida.Beta.getValue() + "%");
								Thread.sleep(50); // Espera un momento para simular el progreso
								if (partida.Beta.getValue() == 100) {
									partida.Beta.setString("Completado Cancer");
									System.out.println("Franko: Bien hecho!");
									partida.DBeta.setEnabled(false);
								}
								if (partida.Beta.getValue() == progresoB) {
									System.out.println("Franko: Has desarrolado el " + partida.Beta.getValue()
											+ "% y gastado todas tus acciones.");
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
								partida.Gamma.setString("SARS: " + partida.Gamma.getValue() + "%");
								Thread.sleep(50); // Espera un momento para simular el progreso
								if (partida.Gamma.getValue() == 100) {
									partida.Gamma.setString("Completado SARS");
									System.out.println("Franko: Bien hecho!");
									partida.DGamma.setEnabled(false);
								}
								if (partida.Gamma.getValue() == progresoG) {
									System.out.println("Franko: Has desarrolado el " + partida.Gamma.getValue()
											+ "% y gastado todas tus acciones.");
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
								partida.Delta.setString("NIGGA: " + partida.Delta.getValue() + "%");
								Thread.sleep(50); // Espera un momento para simular el progreso
								if (partida.Delta.getValue() == 100) {
									partida.Delta.setString("Completado NIGGA");
									System.out.println("Franko: Bien hecho!");
									partida.DDelta.setEnabled(false);

								}
								if (partida.Delta.getValue() == progresoD) {
									System.out.println("Franko: Has desarrolado el " + partida.Delta.getValue()
											+ "% y gastado todas tus acciones.");
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
		partida.acciones.setText("" + controlPartida.datos.getAcciones());
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
		System.out.println("Franko: La partida se inicio con las siguientes infecciones:");
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
		}
		for (int i = 0; i < infectadoStart; i++) {
			random = rand.nextInt(48);

			int nivel = datos.getCiudades().get(random).getInfeccion();
			if (nivel == 1) {
				infectadoStart++;
			} else {
				nivel++;
				datos.getCiudades().get(random).setInfeccion(nivel);
				System.out.println("Franko: Ciudad: " + datos.getCiudades().get(random).getNombre());
				try {
					Thread.sleep(350);
				} catch (InterruptedException e) {
				}
				ponerImages(random, comprobacionNombreBoton(datos.getCiudades().get(random).getNombre()));
			}
		}
	}

	public static String comprobacionNombreBoton(String CiudadNombre) {
		for (Component c : partida.game.getComponents()) {

			if (c instanceof JButton) {
				if (c.getName().contains(CiudadNombre)) {
					return c.getName();
				} else if (CiudadNombre.contains(c.getName())) {
					return c.getName();
				}
			}
		}
		return "";
	}

	public static void gestionar_InfeccionNewRound() {
		int numCiudadesxRonda = Integer.valueOf(controlDatos.numCiudadesInfectadasRonda);
		Random rand = new Random();
		random = 0;

		for (int i = 0; i < numCiudadesxRonda; i++) {
			random = rand.nextInt(48);
			int nivel = datos.getCiudades().get(random).getInfeccion();
			if (datos.getCiudades().get(random).isNuke()) {
				nivel++;
				nivel++;
				datos.getCiudades().get(random).setInfeccion(nivel);
				gestionar_Brote();
			} else if (!datos.getCiudades().get(random).isNuke()) {
				nivel++;
				datos.getCiudades().get(random).setInfeccion(nivel);
				if (datos.getCiudades().get(random).getInfeccion() < 4) {
					System.out.println("Se ha infectado " + datos.getCiudades().get(random).getNombre() + " con el nivel "
							+ datos.getCiudades().get(random).getInfeccion());
				}
			}
			
			ponerImages(random, comprobacionNombreBoton(datos.getCiudades().get(random).getNombre()));
			
			

			gestionar_Brote();
			try {
				Thread.sleep(350);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void gestionar_Brote() {

		// comprobacion de brote
		if (datos.getCiudades().get(random).getInfeccion() >= 4) {
			if (datos.getCiudades().get(random).getInfeccion() == 4) {
				datos.setBrotes(datos.getBrotes() + 1);
				System.out.println(
						"Se ha infectado " + datos.getCiudades().get(random).getNombre() + " y se ha producido un brote.");
			} else if (datos.getCiudades().get(random).getInfeccion() == 5) {
				datos.setBrotes(datos.getBrotes() + 2);
				System.out.println("Debido a la ciudad atomica se ha producido 2 brotes al ser infectada.");
			}
			
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			datos.getCiudades().get(random).setInfeccion(3);
			partida.brotes.setText("" + datos.getBrotes());
			gestionar_Fin_Partida();
			for (int i = 0; i < datos.getCiudades().get(random).getCiudadesColindantes().length; i++) {
				for (int j = 0; j < datos.getCiudades().size(); j++) {
					if (datos.getCiudades().get(random).getCiudadesColindantes()[i]
							.equalsIgnoreCase(datos.getCiudades().get(j).getNombre())) {

						if (datos.getCiudades().get(j).getInfeccion() == 3) {

							datos.setBrotes(datos.getBrotes() + 1);
							partida.brotes.setText("" + datos.getBrotes());
							System.out.println("De las colindades se ha creado otro brote en: "
									+ datos.getCiudades().get(j).getNombre());
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							gestionar_Fin_Partida();

						} else {
							if (datos.getCiudades().get(j).isNuke()) {
								if (datos.getCiudades().get(j).getInfeccion() < 2) {
									datos.getCiudades().get(j).setInfeccion(datos.getCiudades().get(j).getInfeccion() + 2);
									System.out.println("Ciudad atomico: " + datos.getCiudades().get(j).getNombre() + " se ha subido a nivel: " + datos.getCiudades().get(j).getInfeccion());
									gestionar_Fin_Partida();
								} else {
									datos.getCiudades().get(j).setInfeccion(3);
									datos.setBrotes(datos.getBrotes()+2);
									gestionar_Fin_Partida();
								}
								
							} else  if (!datos.getCiudades().get(j).isNuke()){
								datos.getCiudades().get(j).setInfeccion(datos.getCiudades().get(j).getInfeccion() + 1);
								System.out.println("Por el brote se ha infectado: " + datos.getCiudades().get(j).getNombre()
										+ " al nivel " + datos.getCiudades().get(j).getInfeccion());
								gestionar_Fin_Partida();
							}
							
							ponerImages(j, comprobacionNombreBoton(datos.getCiudades().get(j).getNombre()));
							
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
			System.out.println("Has perdido por los brotes"); // cambiar por panel de Franco aparece diciendo muy bien
																// hecho (si pierdes)
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
				if ((datos.getAcciones() > 0) && (datos.getCiudades().get(ciudadSize)).getInfeccion() > 0
						|| datos.getCiudades().get(ciudadSize).getInfeccion() < 0
								&& partida.ciudadSeleccionada == true) {
					// funcion de curar con vacuna desarrollada
					if (datos.getCiudades().get(ciudadSize).getEnfermedad().equalsIgnoreCase("Alfa")
							&& datos.getVacunas().get(0).getPorcentaje() == 100) {
						// ALFA azul
						datos.getCiudades().get(ciudadSize).setInfeccion(0);
						System.out.println("Has curado la ciudad " + datos.getCiudades().get(ciudadSize).getNombre()
								+ " con la vacuna " + datos.getVacunas().get(0).getNombre()
								+ " y has dejado el nivel de infeccion en: "
								+ datos.getCiudades().get(ciudadSize).getInfeccion());
						datos.setAcciones(datos.getAcciones() - 1);
						partida.acciones.setText("" + datos.getAcciones());
						partida.ciudadesInf.setText("" + ciudadesInfectadas());
						ponerImages(ciudadSize, ciudadNombre);

					} else if (datos.getCiudades().get(ciudadSize).getEnfermedad().equalsIgnoreCase("Beta")
							&& datos.getVacunas().get(1).getPorcentaje() == 100) {
						// BETA rojo
						datos.getCiudades().get(ciudadSize).setInfeccion(0);
						System.out.println("Has curado la ciudad " + datos.getCiudades().get(ciudadSize).getNombre()
								+ " con la vacuna " + datos.getVacunas().get(1).getNombre()
								+ " y has dejado el nivel de infeccion en: "
								+ datos.getCiudades().get(ciudadSize).getInfeccion());
						datos.setAcciones(datos.getAcciones() - 1);
						partida.acciones.setText("" + datos.getAcciones());
						partida.ciudadesInf.setText("" + ciudadesInfectadas());
						ponerImages(ciudadSize, ciudadNombre);

					} else if (datos.getCiudades().get(ciudadSize).getEnfermedad().equalsIgnoreCase("Delta")
							&& datos.getVacunas().get(2).getPorcentaje() == 100) {
						// DELTA negro
						datos.getCiudades().get(ciudadSize).setInfeccion(0);
						System.out.println("Has curado la ciudad " + datos.getCiudades().get(ciudadSize).getNombre()
								+ " con la vacuna " + datos.getVacunas().get(2).getNombre()
								+ " y has dejado el nivel de infeccion en: "
								+ datos.getCiudades().get(ciudadSize).getInfeccion());
						datos.setAcciones(datos.getAcciones() - 1);
						partida.acciones.setText("" + datos.getAcciones());
						partida.ciudadesInf.setText("" + ciudadesInfectadas());
						ponerImages(ciudadSize, ciudadNombre);

					} else if (datos.getCiudades().get(ciudadSize).getEnfermedad().equalsIgnoreCase("Gamma")
							&& datos.getVacunas().get(3).getPorcentaje() == 100) {
						// GAMMA amarrillo
						datos.getCiudades().get(ciudadSize).setInfeccion(0);
						System.out.println("Has curado la ciudad " + datos.getCiudades().get(ciudadSize).getNombre()
								+ " con la vacuna " + datos.getVacunas().get(3).getNombre()
								+ " y has dejado el nivel de infeccion en: "
								+ datos.getCiudades().get(ciudadSize).getInfeccion());
						datos.setAcciones(datos.getAcciones() - 1);
						partida.acciones.setText("" + datos.getAcciones());
						partida.ciudadesInf.setText("" + ciudadesInfectadas());
						ponerImages(ciudadSize, ciudadNombre);

					} else if (datos.getCiudades().get(ciudadSize).getEnfermedad().equalsIgnoreCase("Alfa")
							&& datos.getVacunas().get(0).getPorcentaje() != 100) {

						datos.getCiudades().get(ciudadSize)
								.setInfeccion(datos.getCiudades().get(ciudadSize).getInfeccion() - 1);
						System.out.println("Has curado la ciudad " + datos.getCiudades().get(ciudadSize).getNombre()
								+ " sin la vacuna " + datos.getVacunas().get(0).getNombre()
								+ " y has dejado el nivel de infeccion en: "
								+ datos.getCiudades().get(ciudadSize).getInfeccion());
						datos.setAcciones(datos.getAcciones() - 1);
						partida.acciones.setText("" + datos.getAcciones());
						partida.ciudadesInf.setText("" + ciudadesInfectadas());
						ponerImages(ciudadSize, ciudadNombre);

					} else if (datos.getCiudades().get(ciudadSize).getEnfermedad().equalsIgnoreCase("Beta")
							&& datos.getVacunas().get(1).getPorcentaje() != 100) {

						datos.getCiudades().get(ciudadSize)
								.setInfeccion(datos.getCiudades().get(ciudadSize).getInfeccion() - 1);
						System.out.println("Has curado la ciudad " + datos.getCiudades().get(ciudadSize).getNombre()
								+ " sin la vacuna " + datos.getVacunas().get(1).getNombre()
								+ " y has dejado el nivel de infeccion en: "
								+ datos.getCiudades().get(ciudadSize).getInfeccion());
						datos.setAcciones(datos.getAcciones() - 1);
						partida.acciones.setText("" + datos.getAcciones());
						partida.ciudadesInf.setText("" + ciudadesInfectadas());
						ponerImages(ciudadSize, ciudadNombre);

					} else if (datos.getCiudades().get(ciudadSize).getEnfermedad().equalsIgnoreCase("Delta")
							&& datos.getVacunas().get(2).getPorcentaje() != 100) {

						datos.getCiudades().get(ciudadSize)
								.setInfeccion(datos.getCiudades().get(ciudadSize).getInfeccion() - 1);
						System.out.println("Has curado la ciudad " + datos.getCiudades().get(ciudadSize).getNombre()
								+ " sin la vacuna " + datos.getVacunas().get(2).getNombre()
								+ " y has dejado el nivel de infeccion en: "
								+ datos.getCiudades().get(ciudadSize).getInfeccion());
						datos.setAcciones(datos.getAcciones() - 1);
						partida.acciones.setText("" + datos.getAcciones());
						partida.ciudadesInf.setText("" + ciudadesInfectadas());
						ponerImages(ciudadSize, ciudadNombre);

					} else if (datos.getCiudades().get(ciudadSize).getEnfermedad().equalsIgnoreCase("Gamma")
							&& datos.getVacunas().get(3).getPorcentaje() != 100) {

						datos.getCiudades().get(ciudadSize)
								.setInfeccion(datos.getCiudades().get(ciudadSize).getInfeccion() - 1);
						System.out.println("Has curado la ciudad " + datos.getCiudades().get(ciudadSize).getNombre()
								+ " sin la vacuna " + datos.getVacunas().get(3).getNombre()
								+ " y has dejado el nivel de infeccion en: "
								+ datos.getCiudades().get(ciudadSize).getInfeccion());
						datos.setAcciones(datos.getAcciones() - 1);
						partida.acciones.setText("" + datos.getAcciones());
						partida.ciudadesInf.setText("" + ciudadesInfectadas());
						ponerImages(ciudadSize, ciudadNombre);
					}
				} else if (datos.getAcciones() == 0) {
					System.out.println("Franko: No tienes acciones...");
				} else if (datos.getCiudades().get(ciudadSize).getInfeccion() == 0) {
					System.out.println(
							"Franko: No esta infectado la ciudad: " + datos.getCiudades().get(ciudadSize).getNombre());
				}
			}
		});
		vac.start();

	}
	
	public static void nuke() {
		if (partida.ciudadSeleccionada && datos.getAcciones() > 2 && !datos.getCiudades().get(ciudadSize).isNuke() && datos.getCiudades().get(ciudadSize).getInfeccion() > 0) {
			for (int i = 0; i < datos.getCiudades().get(ciudadSize).getCiudadesColindantes().length; i++) {
				datos.getCiudades().get(ciudadSize).setNuke(true);
				datos.getCiudades().get(ciudadSize).setInfeccion(0);
				ponerImages(ciudadSize, comprobacionNombreBoton(datos.getCiudades().get(ciudadSize).getNombre()));
				
				for (Component c : partida.game.getComponents()) {
					if (c instanceof JButton) {
						if (c.getName().equals(comprobacionNombreBoton(ciudadNombre))) {
							((JButton) c).setBorderPainted(true);
							((JButton) c).setBorder(new LineBorder(Color.red,2));
							break;
						}
					}
				}
				
				for (int j = 0; j < datos.getCiudades().size(); j++) {
					if (datos.getCiudades().get(j).getNombre().equals(datos.getCiudades().get(ciudadSize).getCiudadesColindantes()[i])) {
						datos.getCiudades().get(j).setInfeccion(0);
						datos.getCiudades().get(j).setNuke(true);
						for (Component c : partida.game.getComponents()) {
							if (c instanceof JButton) {
								if (c.getName().equals(comprobacionNombreBoton(datos.getCiudades().get(j).getNombre()))) {
									((JButton) c).setBorderPainted(true);
									((JButton) c).setBorder(new LineBorder(Color.red,2));
									break;
								}
							}
						}
						ponerImages(j, comprobacionNombreBoton(datos.getCiudades().get(j).getNombre()));
					}
				}
				
			}
			datos.setAcciones(datos.getAcciones() - 3);
			partida.acciones.setText("" + datos.getAcciones());
			//restar puntos TODO
		} else if (datos.getAcciones() < 2) {
			System.out.println("Franko: No tienes acciones...");
		} else if (datos.getCiudades().get(ciudadSize).isNuke()) {
			System.out.println("Franko: No puedes tirar la bomba donde ya la tiraste o donde se haya expandido la bomba.");
		} else if (!partida.ciudadSeleccionada) {
			System.out.println("Franko: Selecciona una ciudad antes.");
		} else if (datos.getCiudades().get(ciudadSize).getInfeccion() == 0) {
			System.out.println("Franko: Terrorista, porque intentarias tirar una bomba a una ciudad que no tiene infeccion.");
		}
	}

	public static void ponerImages(int ciudadPos, String nombreBtn) {

		switch (datos.getCiudades().get(ciudadPos).getInfeccion()) {
		case 0:
			if (datos.getCiudades().get(ciudadPos).getNombre().contains(nombreBtn)) {
				for (Component c : partida.game.getComponents()) {
					if (c instanceof JButton) {
						if (c.getName().equals(nombreBtn)
								&& datos.getCiudades().get(ciudadPos).getEnfermedad().equals("Alfa")) {
							((JButton) c).setIcon(partida.azulVirusCiudad0);
							break;
						} else if (c.getName().equals(nombreBtn)
								&& datos.getCiudades().get(ciudadPos).getEnfermedad().equals("Beta")) {
							((JButton) c).setIcon(partida.rojoVirusCiudad0);
							break;
						} else if (c.getName().equals(nombreBtn)
								&& datos.getCiudades().get(ciudadPos).getEnfermedad().equals("Delta")) {
							((JButton) c).setIcon(partida.amarilloVirusCiudad0);
							break;
						} else if (c.getName().equals(nombreBtn)
								&& datos.getCiudades().get(ciudadPos).getEnfermedad().equals("Gamma")) {
							((JButton) c).setIcon(partida.negroVirusCiudad0);
							break;
						}

					}
				}
			}
			break;
		case 1:
			if (datos.getCiudades().get(ciudadPos).getNombre().contains(nombreBtn)) {
				if (datos.getCiudades().get(ciudadPos).getNombre().contains(nombreBtn)) {
					for (Component c : partida.game.getComponents()) {
						if (c instanceof JButton) {
							if (c.getName().equals(nombreBtn)
									&& datos.getCiudades().get(ciudadPos).getEnfermedad().equals("Alfa")) {
								((JButton) c).setIcon(partida.azulVirusCiudad);
								break;
							} else if (c.getName().equals(nombreBtn)
									&& datos.getCiudades().get(ciudadPos).getEnfermedad().equals("Beta")) {
								((JButton) c).setIcon(partida.rojoVirusCiudad);
								break;
							} else if (c.getName().equals(nombreBtn)
									&& datos.getCiudades().get(ciudadPos).getEnfermedad().equals("Delta")) {
								((JButton) c).setIcon(partida.amarilloVirusCiudad);
								break;
							} else if (c.getName().equals(nombreBtn)
									&& datos.getCiudades().get(ciudadPos).getEnfermedad().equals("Gamma")) {
								((JButton) c).setIcon(partida.negroVirusCiudad);
								break;
							}

						}
					}
				}
			}
			break;
		case 2:
			if (datos.getCiudades().get(ciudadPos).getNombre().contains(nombreBtn)) {
				if (datos.getCiudades().get(ciudadPos).getNombre().contains(nombreBtn)) {
					for (Component c : partida.game.getComponents()) {
						if (c instanceof JButton) {
							if (c.getName().equals(nombreBtn)
									&& datos.getCiudades().get(ciudadPos).getEnfermedad().equals("Alfa")) {
								((JButton) c).setIcon(partida.azulVirusCiudad2);
								break;
							} else if (c.getName().equals(nombreBtn)
									&& datos.getCiudades().get(ciudadPos).getEnfermedad().equals("Beta")) {
								((JButton) c).setIcon(partida.rojoVirusCiudad2);
								break;
							} else if (c.getName().equals(nombreBtn)
									&& datos.getCiudades().get(ciudadPos).getEnfermedad().equals("Delta")) {
								((JButton) c).setIcon(partida.amarilloVirusCiudad2);
								break;
							} else if (c.getName().equals(nombreBtn)
									&& datos.getCiudades().get(ciudadPos).getEnfermedad().equals("Gamma")) {
								((JButton) c).setIcon(partida.negroVirusCiudad2);
								break;
							}

						}
					}
				}
			}
			break;
		case 3:
			if (datos.getCiudades().get(ciudadPos).getNombre().contains(nombreBtn)) {
				if (datos.getCiudades().get(ciudadPos).getNombre().contains(nombreBtn)) {
					for (Component c : partida.game.getComponents()) {
						if (c instanceof JButton) {
							if (c.getName().equals(nombreBtn)
									&& datos.getCiudades().get(ciudadPos).getEnfermedad().equals("Alfa")) {
								((JButton) c).setIcon(partida.azulVirusCiudad3);
								break;
							} else if (c.getName().equals(nombreBtn)
									&& datos.getCiudades().get(ciudadPos).getEnfermedad().equals("Beta")) {
								((JButton) c).setIcon(partida.rojoVirusCiudad3);
								break;
							} else if (c.getName().equals(nombreBtn)
									&& datos.getCiudades().get(ciudadPos).getEnfermedad().equals("Delta")) {
								((JButton) c).setIcon(partida.amarilloVirusCiudad3);
								break;
							} else if (c.getName().equals(nombreBtn)
									&& datos.getCiudades().get(ciudadPos).getEnfermedad().equals("Gamma")) {
								((JButton) c).setIcon(partida.negroVirusCiudad3);
								break;
							}

						}
					}
				}
			}
			break;
		}
	}
}
