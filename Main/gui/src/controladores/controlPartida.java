package controladores;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import CargaDatos.controlDatos;
import inicio.Main;
import intefaz.CargarParty;
import intefaz.ganarPerder;
//import intefaz.ganarPerder;
import intefaz.pantallaCargar;
import intefaz.partida;
import intefaz.records;
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
	public static boolean datosCargados = false;
	public static boolean datosCargadosPartida = false;

	public static void iniciar_Partida() {
		
		int pdesarrollo = Integer.valueOf(controlDatos.desarrolloVacuna);
		
		if (!datosCargados) {
			controlDatos.cargarCiudades();
			controlDatos.cargarVacunas();
			controlDatos.cargarVirus();
			datosCargados = true;
		}
		

		datos = new datosPartida(controlDatos.ciudades, controlDatos.virus, controlDatos.vacunas, 0, 0, pdesarrollo, 4, 0);

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
		
		partida.scoreNum.setText("0");
		datos.setPuntuancion(0);
		
		
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

	public static void iniciar_Partida_Guardada() {

		int pdesarrollo = Integer.valueOf(controlDatos.desarrolloVacuna);
		
		if (!datosCargadosPartida) {
			controlDatos.cargarCiudades();
			controlDatos.cargarVacunas();
			controlDatos.cargarVirus();
			datosCargadosPartida = true;
		}
		
		datos = new datosPartida(controlDatos.ciudades, controlDatos.virus, controlDatos.vacunas, 0, 0, pdesarrollo, 4, 0);
		
		progresoA = datos.getpDesarrollo();
		progresoB = datos.getpDesarrollo();
		progresoG = datos.getpDesarrollo();
		progresoD = datos.getpDesarrollo();
		aux = datos.getpDesarrollo();
		
		partida.nuke.setEnabled(true);

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
				
				if (datos.getRondas() <= 6) {
					
					datos.setPuntuancion(datos.getPuntuancion() - 50);
					partida.scoreNum.setText("" + datos.getPuntuancion());
					
				} else if (datos.getRondas() > 6) {
					
					datos.setPuntuancion(datos.getPuntuancion() - 80);
					partida.scoreNum.setText("" + datos.getPuntuancion());
					
				}
				
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
					Thread.sleep(1500);
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
				
				//TODO desactivar boton de nuke
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
								partida.Alfa.setValue(i); 
								partida.Alfa.setString("VIH: " + partida.Alfa.getValue() + "%");
								Thread.sleep(50); 
								if (partida.Alfa.getValue() == 100) {
									partida.Alfa.setString("VIH 100%");
									System.out.println("Franko: Bien hecho! Has conseguido 250 puntos!");
									partida.DAlfa.setEnabled(false);
									
									datos.setPuntuancion(datos.getPuntuancion()+250);
									partida.scoreNum.setText(""+ datos.getPuntuancion());
									
								}
								if (partida.Alfa.getValue() == progresoA) {
									System.out.println("Franko: Has desarrolado el " + partida.Alfa.getValue()
											+ "% y gastado todas tus acciones, has conseguido 75 puntos.");
									
									datos.setPuntuancion(datos.getPuntuancion()+75);
									partida.scoreNum.setText(""+ datos.getPuntuancion());
									
									
								}
								datos.getVacunas().get(0).setPorcentaje(partida.Alfa.getValue());
							}
							progresoA += aux;
							gestionar_Ganar();
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
									partida.Beta.setString("CANCER 100%");
									System.out.println("Franko: Bien hecho! Has conseguido 250 puntos!");
									partida.DBeta.setEnabled(false);
									
									datos.setPuntuancion(datos.getPuntuancion()+250);
									partida.scoreNum.setText(""+ datos.getPuntuancion());
									
								}
								if (partida.Beta.getValue() == progresoB) {
									System.out.println("Franko: Has desarrolado el " + partida.Beta.getValue()
											+ "% y gastado todas tus acciones, has conseguido 75 puntos");
									
									
									datos.setPuntuancion(datos.getPuntuancion()+75);
									partida.scoreNum.setText(""+ datos.getPuntuancion());
									
									
									
								}
								datos.getVacunas().get(1).setPorcentaje(partida.Beta.getValue());
							}
							progresoB += aux;
							gestionar_Ganar();
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
									partida.Gamma.setString("SARS 100%");
									System.out.println("Franko: Bien hecho! Has conseguido 250 puntos!");
									partida.DGamma.setEnabled(false);
									
									
									datos.setPuntuancion(datos.getPuntuancion()+250);
									partida.scoreNum.setText(""+ datos.getPuntuancion());
									
								}
								if (partida.Gamma.getValue() == progresoG) {
									System.out.println("Franko: Has desarrolado el " + partida.Gamma.getValue()
											+ "% y gastado todas tus acciones, has conseguido 75 puntos!");
									
									datos.setPuntuancion(datos.getPuntuancion()+75);
									partida.scoreNum.setText(""+ datos.getPuntuancion());
									
								}
								datos.getVacunas().get(2).setPorcentaje(partida.Gamma.getValue());
							}
							progresoG += aux;
							gestionar_Ganar();
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
									partida.Delta.setString("NIGGA 100%");
									System.out.println("Franko: Bien hecho! Has conseguido 250 puntos!");
									partida.DDelta.setEnabled(false);

									datos.setPuntuancion(datos.getPuntuancion()+250);
									partida.scoreNum.setText(""+ datos.getPuntuancion());
									
									
								}
								if (partida.Delta.getValue() == progresoD) {
									System.out.println("Franko: Has desarrolado el " + partida.Delta.getValue()
											+ "% y gastado todas tus acciones, has conseguido 75 puntos!");
									
									datos.setPuntuancion(datos.getPuntuancion()+75);
									partida.scoreNum.setText(""+ datos.getPuntuancion());
									
								}
								datos.getVacunas().get(3).setPorcentaje(partida.Delta.getValue());
							}
							gestionar_Ganar();
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
			
			gestionar_Fin_Partida();
			
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
								} else if (datos.getCiudades().get(j).getInfeccion() == 3) {
									datos.getCiudades().get(j).setInfeccion(3);
									datos.setBrotes(datos.getBrotes()+2);
									gestionar_Fin_Partida();
								} else if (datos.getCiudades().get(j).getInfeccion() == 2) {
									datos.getCiudades().get(j).setInfeccion(3);
									datos.setBrotes(datos.getBrotes()+1);
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
	
	//TODO ACTUALIZAR GUI CUANDO CARGA PARTIDA, COMPROBAR SI VOLVER AL MENU FUNCIONA CUANDO CARGA LA PARTIDA
	//TODO HACER QUE LOS BTNS FUNCIONEN DE CARGAR Y ELIMINAR PARTIDA
	
	public static void gestionar_Fin_Partida() {
		int derrotaBrote = Integer.valueOf(controlDatos.numBrotesDerrota);
		int derrotaEnfermedad = Integer.valueOf(controlDatos.numEnfermedadesActivasDerrota);
		int infeccionTotal = 0;

		if (datos.getBrotes() >= derrotaBrote) {
			JLabel win = new JLabel("<html><center>HAS PERDIDO POR BROTES :/");
			win.setFont(controlDatos.fuentecargar(150f));
			win.setForeground(Color.red);
			win.setHorizontalAlignment(SwingConstants.CENTER);
			ganarPerder.general.add(win, BorderLayout.CENTER);
			
			CargarParty.game.setVisible(false);
			partida.winLoseFrame.setVisible(true);
			resetGame(); 
		}

		for (int i = 0; i < datos.getCiudades().size(); i++) {
			infeccionTotal += datos.getCiudades().get(i).getInfeccion();
			if (infeccionTotal >= derrotaEnfermedad) {
				JLabel win = new JLabel("<html><center>HAS PERDIDO POR INFECCIONES :/");
				win.setFont(controlDatos.fuentecargar(150f));
				win.setForeground(Color.RED);
				win.setHorizontalAlignment(SwingConstants.CENTER);
				ganarPerder.general.add(win, BorderLayout.CENTER);
				
				CargarParty.game.setVisible(false);
				partida.winLoseFrame.setVisible(true);
				resetGame();
				break;
			} 
		}
	}
	
	public static void gestionar_Ganar() {
		
		Thread vac = new Thread(new Runnable() {

			@Override
			public void run() {
				if (datos.getVacunas().get(0).getPorcentaje() == 100 && datos.getVacunas().get(1).getPorcentaje() == 100 && datos.getVacunas().get(2).getPorcentaje() == 100 && datos.getVacunas().get(3).getPorcentaje() == 100) {
					
					JLabel win = new JLabel("HAS GANADO!!");
					win.setFont(controlDatos.fuentecargar(150f));
					win.setForeground(Color.green);
					win.setHorizontalAlignment(SwingConstants.CENTER);
//					ganarPerder.general.add(win, BorderLayout.CENTER);
					CargarParty.game.setVisible(false);
//					partida.winLoseFrame.setVisible(true);
					resetGame();
					
				}
				


			}
		});
		vac.start();
		
		
		
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
					
					datos.setPuntuancion(datos.getPuntuancion() + 20);
					partida.scoreNum.setText(""+datos.getPuntuancion());
					System.out.println("Franko: Has ganado 20 puntos.");
					
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
			partida.ciudadesInf.setText("" + ciudadesInfectadas());
			
			datos.setPuntuancion(datos.getPuntuancion()-100);
			partida.scoreNum.setText("" + datos.getPuntuancion());
			
			
			
		} else if (datos.getAcciones() < 2) {
			System.out.println("Franko: No tienes acciones...");
		} else if (datos.getCiudades().get(ciudadSize).isNuke()) {
			System.out.println("Franko: No puedes tirar la bomba donde ya la tiraste o donde se haya expandido la bomba.");
			datos.setPuntuancion(datos.getPuntuancion() - 1);
			partida.scoreNum.setText("" + datos.getPuntuancion());
		} else if (!partida.ciudadSeleccionada) {
			System.out.println("Franko: Selecciona una ciudad antes.");
		} else if (datos.getCiudades().get(ciudadSize).getInfeccion() == 0) {
			System.out.println("Franko: Terrorista, porque intentarias tirar una bomba a una ciudad que no tiene infeccion.");
			datos.setPuntuancion(datos.getPuntuancion() - 2);
			partida.scoreNum.setText("" + datos.getPuntuancion());
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
	
	public static void GUIpantallaCargar() {
		
		ArrayList<String[]> info = new ArrayList<>(controlDatos.mostrarInfoCargar(0));
		
		ImageIcon botonPlay = new ImageIcon("src\\img\\partidasGuardadas\\botonPlay.png");
		Image botonPlayES = botonPlay.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon botonPlayFin = new ImageIcon(botonPlayES);

		ImageIcon botonPlayOP = new ImageIcon("src\\img\\partidasGuardadas\\botonPlayOP.png");
		Image botonPlayESOP = botonPlayOP.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon botonPlayFinOP = new ImageIcon(botonPlayESOP);

		ImageIcon botonEliminar = new ImageIcon("src\\img\\partidasGuardadas\\botonEliminar.png");
		Image botonEliminarES = botonEliminar.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon botonEliminarFIN = new ImageIcon(botonEliminarES);

		ImageIcon botonEliminarOP = new ImageIcon("src\\img\\partidasGuardadas\\botonEliminarOP.png");
		Image botonEliminarOPES = botonEliminarOP.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon botonEliminarFINOP = new ImageIcon(botonEliminarOPES);
		
		pantallaCargar.Partidas.removeAll();
		
		pantallaCargar.Partidas = new JPanel(new GridBagLayout()) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setColor(new Color(0, 0, 0, 0));
				g2d.fillRect(0, 0, getWidth(), getHeight());
				g2d.dispose();
			}
		};
		pantallaCargar.Partidas.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pantallaCargar.Partidas.setOpaque(false);
		GridBagConstraints gbcpartidas = new GridBagConstraints();

		gbcpartidas.gridx = 0;
		gbcpartidas.gridy = 0;

		

		for (int i = 0; i < info.size(); i++) {

			JPanel partidaPanel = new JPanel(new GridBagLayout()) {
				@Override
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					Graphics2D g2d = (Graphics2D) g.create();
					g2d.setColor(new Color(0, 51, 102, 128));
					g2d.fillRect(0, 0, getWidth(), getHeight());
					g2d.dispose();
				}
			};
			partidaPanel.setPreferredSize(new Dimension(375, 100));
			partidaPanel.setOpaque(false);
			partidaPanel.setBorder(new LineBorder(Color.LIGHT_GRAY));

			GridBagConstraints gbcPartidaPanel = new GridBagConstraints();

			gbcPartidaPanel.gridx = 0;
			gbcPartidaPanel.gridy = 0;
			gbcPartidaPanel.weighty = 1.0;
			gbcPartidaPanel.gridheight = 4;
			gbcPartidaPanel.fill = GridBagConstraints.VERTICAL;

			pantallaCargar.eliminar = new JButton(botonEliminarFIN);
			pantallaCargar.eliminar.setContentAreaFilled(false);
			pantallaCargar.eliminar.setFocusPainted(false);
			pantallaCargar.eliminar.setBorderPainted(false);
			
			pantallaCargar.play = new JButton(botonPlayFin);
			pantallaCargar.play.setContentAreaFilled(false);
			pantallaCargar.play.setFocusPainted(false);
			pantallaCargar.play.setBorderPainted(false);

			pantallaCargar.eliminar.addActionListener(Main.partidas);

			partidaPanel.add(pantallaCargar.eliminar, gbcPartidaPanel);

			final JButton eliminarFinal = pantallaCargar.eliminar;
			
			pantallaCargar.eliminar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					eliminarFinal.setIcon(botonEliminarFINOP);
					partidaPanel.setBorder(new LineBorder(Color.pink, 2));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					eliminarFinal.setIcon(botonEliminarFIN);
					partidaPanel.setBorder(new LineBorder(Color.lightGray, 2));
				}
			});

			gbcPartidaPanel.weighty = 0.0;
			gbcPartidaPanel.gridheight = 1;
			gbcPartidaPanel.fill = GridBagConstraints.NONE;

			for (int j = 0; j < info.get(i).length + 1; j++) {

				switch (j) {
				case 0:
					JPanel usuarioPanel = new JPanel(new FlowLayout());
					usuarioPanel.setOpaque(false);

					JLabel jugador = new JLabel("Jugador: ");
					jugador.setFont(controlDatos.fuenteMC(15f));
					jugador.setForeground(Color.white);

					JLabel username = new JLabel("" + info.get(i)[j].toUpperCase());
					username.setFont(controlDatos.fuenteMC(15f));
					username.setForeground(new Color(79, 240, 100));
					pantallaCargar.play.setName(info.get(i)[j]);
					pantallaCargar.eliminar.setName(info.get(i)[j]);
					
					
					usuarioPanel.add(jugador);
					usuarioPanel.add(username);
					gbcPartidaPanel.gridy = 0;
					gbcPartidaPanel.gridx = 1;
					partidaPanel.add(usuarioPanel, gbcPartidaPanel);
					break;
				case 1:
					JPanel rondasPanel = new JPanel(new FlowLayout());
					rondasPanel.setOpaque(false);

					JLabel rondas = new JLabel("N. Ronda: ");
					rondas.setFont(controlDatos.fuenteMC(12f));
					rondas.setForeground(Color.lightGray);

					int rondasNum = Integer.valueOf(info.get(i)[j]);
					JLabel num = new JLabel("" + rondasNum);
					num.setFont(controlDatos.fuenteMC(12f));
					num.setForeground(Color.lightGray);

					rondasPanel.add(rondas);
					rondasPanel.add(num);

					gbcPartidaPanel.gridy = 1;
					gbcPartidaPanel.gridx = 1;
					partidaPanel.add(rondasPanel, gbcPartidaPanel);
					break;
				case 2:
					int puntuacionNum = Integer.valueOf(info.get(i)[j]);
					JLabel puntuacion = new JLabel("Puntos: " + puntuacionNum);
					puntuacion.setFont(controlDatos.fuenteMC(12f));
					puntuacion.setForeground(Color.lightGray);
					gbcPartidaPanel.gridy = 2;
					gbcPartidaPanel.gridx = 1;
					partidaPanel.add(puntuacion, gbcPartidaPanel);
					break;
				case 3:
					JLabel dia = new JLabel("Ult. Jugado: (" + info.get(i)[j] + ")");
					dia.setFont(controlDatos.fuenteMC(10f));
					dia.setForeground(Color.lightGray);
					gbcPartidaPanel.gridy = 3;
					gbcPartidaPanel.gridx = 1;
					partidaPanel.add(dia, gbcPartidaPanel);
					break;
				}

			}

			gbcPartidaPanel.gridx = 2;
			gbcPartidaPanel.gridy = 0;
			gbcPartidaPanel.weighty = 1.0;
			gbcPartidaPanel.gridheight = 4;
			gbcPartidaPanel.fill = GridBagConstraints.VERTICAL;

			

			pantallaCargar.play.addActionListener(Main.partidas);

			partidaPanel.add(pantallaCargar.play, gbcPartidaPanel);

			final JButton playFinal = pantallaCargar.play;
			
			pantallaCargar.play.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					playFinal.setIcon(botonPlayFinOP);
					partidaPanel.setBorder(new LineBorder(Color.green, 2));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					playFinal.setIcon(botonPlayFin);
					partidaPanel.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
				}
			});

			gbcPartidaPanel.weighty = 0.0;
			gbcPartidaPanel.gridheight = 1;
			gbcPartidaPanel.fill = GridBagConstraints.NONE;

			gbcpartidas.insets = new Insets(10, 10, 10, 10);

			pantallaCargar.Partidas.add(partidaPanel, gbcpartidas);
			gbcpartidas.gridy++;
		}

		pantallaCargar.scroll.setOpaque(false);
		pantallaCargar.scroll.getVerticalScrollBar().setUnitIncrement(30);
		pantallaCargar.scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		pantallaCargar.scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		JViewport viewport = pantallaCargar.scroll.getViewport();
		viewport.setOpaque(false);

		
		
		
		if (info.size() == 0) {
			JPanel noGameEz = new JPanel() {
				@Override
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					Graphics2D g2d = (Graphics2D) g.create();
					g2d.setColor(new Color(0, 0, 0, 0));
					g2d.fillRect(0, 0, getWidth(), getHeight());
					g2d.dispose();
				}
			};
			noGameEz.setPreferredSize(new Dimension(300, 75));
			noGameEz.setOpaque(false);
			noGameEz.setBorder(new LineBorder(Color.LIGHT_GRAY));

			JLabel noGameText = new JLabel("NO HAY PARTIDAS GUARDADAS");
			noGameText.setVerticalAlignment(JLabel.CENTER);
			noGameText.setHorizontalAlignment(JLabel.CENTER);
			noGameText.setFont(controlDatos.fuentecargar(30f));
			noGameText.setForeground(Color.white);

			noGameEz.add(noGameText);

			pantallaCargar.scroll.setViewportView(noGameEz);
		} else {
			pantallaCargar.scroll.setViewportView(pantallaCargar.Partidas);
		}
		
		
		
		
		
		
		
		pantallaCargar.PartidasNormal.removeAll();
		
		
		
		
		pantallaCargar.PartidasNormal = new JPanel(new GridBagLayout()) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setColor(new Color(0, 0, 0, 0));
				g2d.fillRect(0, 0, getWidth(), getHeight());
				g2d.dispose();
			}
		};
		pantallaCargar.PartidasNormal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pantallaCargar.PartidasNormal.setOpaque(false);
		
		
		
		ArrayList<String[]> infoNor = new ArrayList<>(controlDatos.mostrarInfoCargar(1));
		
		for (int i = 0; i < infoNor.size(); i++) {

			JPanel partidaPanel = new JPanel(new GridBagLayout()) {
				@Override
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					Graphics2D g2d = (Graphics2D) g.create();
					g2d.setColor(new Color(0, 51, 102, 128));
					g2d.fillRect(0, 0, getWidth(), getHeight());
					g2d.dispose();
				}
			};
			partidaPanel.setPreferredSize(new Dimension(375, 100));
			partidaPanel.setOpaque(false);
			partidaPanel.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));

			GridBagConstraints gbcPartidaPanel = new GridBagConstraints();

			gbcPartidaPanel.gridx = 0;
			gbcPartidaPanel.gridy = 0;
			gbcPartidaPanel.weighty = 1.0;
			gbcPartidaPanel.gridheight = 4;
			gbcPartidaPanel.fill = GridBagConstraints.VERTICAL;

			pantallaCargar.eliminarNor = new JButton(botonEliminarFIN);
			pantallaCargar.eliminarNor.setContentAreaFilled(false);
			pantallaCargar.eliminarNor.setFocusPainted(false);
			pantallaCargar.eliminarNor.setBorderPainted(false);

			pantallaCargar.playNor = new JButton(botonPlayFin);
			pantallaCargar.playNor.setContentAreaFilled(false);
			pantallaCargar.playNor.setFocusPainted(false);
			pantallaCargar.playNor.setBorderPainted(false);
			
			pantallaCargar.eliminarNor.addActionListener(Main.partidas);

			partidaPanel.add(pantallaCargar.eliminarNor, gbcPartidaPanel);
			
			final JButton eliminarNorFinal = pantallaCargar.eliminarNor;
			
			pantallaCargar.eliminarNor.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					eliminarNorFinal.setIcon(botonEliminarFINOP);
					partidaPanel.setBorder(new LineBorder(Color.pink, 2));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					eliminarNorFinal.setIcon(botonEliminarFIN);
					partidaPanel.setBorder(new LineBorder(Color.lightGray, 2));
				}
			});

			pantallaCargar.eliminarNor.addActionListener(Main.partidas);

			gbcPartidaPanel.weighty = 0.0;
			gbcPartidaPanel.gridheight = 1;
			gbcPartidaPanel.fill = GridBagConstraints.NONE;

			for (int j = 0; j < infoNor.get(i).length + 1; j++) {

				switch (j) {
				case 0:
					JPanel usuarioPanel = new JPanel(new FlowLayout());
					usuarioPanel.setOpaque(false);

					JLabel jugador = new JLabel("Jugador: ");
					jugador.setFont(controlDatos.fuenteMC(15f));
					jugador.setForeground(Color.white);

					JLabel username = new JLabel("" + infoNor.get(i)[j].toUpperCase());
					username.setFont(controlDatos.fuenteMC(15f));
					username.setForeground(new Color(79, 240, 100));
					pantallaCargar.playNor.setName(infoNor.get(i)[j]);
					pantallaCargar.eliminarNor.setName(infoNor.get(i)[j]);
					
					
					usuarioPanel.add(jugador);
					usuarioPanel.add(username);
					gbcPartidaPanel.gridy = 0;
					gbcPartidaPanel.gridx = 1;
					partidaPanel.add(usuarioPanel, gbcPartidaPanel);
					break;
				case 1:
					JPanel rondasPanel = new JPanel(new FlowLayout());
					rondasPanel.setOpaque(false);

					JLabel rondas = new JLabel("N. Ronda: ");
					rondas.setFont(controlDatos.fuenteMC(12f));
					rondas.setForeground(Color.lightGray);

					int rondasNum = Integer.valueOf(infoNor.get(i)[j]);
					JLabel num = new JLabel("" + rondasNum);
					num.setFont(controlDatos.fuenteMC(12f));
					num.setForeground(Color.lightGray);

					rondasPanel.add(rondas);
					rondasPanel.add(num);

					gbcPartidaPanel.gridy = 1;
					gbcPartidaPanel.gridx = 1;
					partidaPanel.add(rondasPanel, gbcPartidaPanel);
					break;
				case 2:
					int puntuacionNum = Integer.valueOf(infoNor.get(i)[j]);
					JLabel puntuacion = new JLabel("Puntos: " + puntuacionNum);
					puntuacion.setFont(controlDatos.fuenteMC(12f));
					puntuacion.setForeground(Color.lightGray);
					gbcPartidaPanel.gridy = 2;
					gbcPartidaPanel.gridx = 1;
					partidaPanel.add(puntuacion, gbcPartidaPanel);
					break;
				case 3:
					JLabel dia = new JLabel("Ult. Jugado: (" + infoNor.get(i)[j] + ")");
					dia.setFont(controlDatos.fuenteMC(10f));
					dia.setForeground(Color.lightGray);
					gbcPartidaPanel.gridy = 3;
					gbcPartidaPanel.gridx = 1;
					partidaPanel.add(dia, gbcPartidaPanel);
					break;
				}

			}

			gbcPartidaPanel.gridx = 2;
			gbcPartidaPanel.gridy = 0;
			gbcPartidaPanel.weighty = 1.0;
			gbcPartidaPanel.gridheight = 4;
			gbcPartidaPanel.fill = GridBagConstraints.VERTICAL;

			pantallaCargar.playNor.addActionListener(Main.partidas);

			partidaPanel.add(pantallaCargar.playNor, gbcPartidaPanel);
			
			final JButton playNorFinal = pantallaCargar.playNor;
			
			pantallaCargar.playNor.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					playNorFinal.setIcon(botonPlayFinOP);
					partidaPanel.setBorder(new LineBorder(Color.green, 2));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					playNorFinal.setIcon(botonPlayFin);
					partidaPanel.setBorder(new LineBorder(Color.lightGray, 2));
				}
			});

			gbcPartidaPanel.weighty = 0.0;
			gbcPartidaPanel.gridheight = 1;
			gbcPartidaPanel.fill = GridBagConstraints.NONE;

			pantallaCargar.gbcPartidasNor.insets = new Insets(10, 10, 10, 10);

			pantallaCargar.PartidasNormal.add(partidaPanel, pantallaCargar.gbcPartidasNor);
			pantallaCargar.gbcPartidasNor.gridy++;
		}

		pantallaCargar.scrollNor.setOpaque(false);

		if (infoNor.size() == 0) {
			JPanel noGameEz = new JPanel() {
				@Override
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					Graphics2D g2d = (Graphics2D) g.create();
					g2d.setColor(new Color(0, 0, 0, 0));
					g2d.fillRect(0, 0, getWidth(), getHeight());
					g2d.dispose();
				}
			};
			noGameEz.setPreferredSize(new Dimension(300, 75));
			noGameEz.setOpaque(false);
			noGameEz.setBorder(new LineBorder(Color.LIGHT_GRAY));

			JLabel noGameText = new JLabel("NO HAY PARTIDAS GUARDADAS");
			noGameText.setVerticalAlignment(JLabel.CENTER);
			noGameText.setHorizontalAlignment(JLabel.CENTER);
			noGameText.setFont(controlDatos.fuentecargar(30f));
			noGameText.setForeground(Color.white);

			noGameEz.add(noGameText);

			pantallaCargar.scrollNor.setViewportView(noGameEz);
		} else {
			pantallaCargar.scrollNor.setViewportView(pantallaCargar.PartidasNormal);
		}
		pantallaCargar.scrollNor.getVerticalScrollBar().setUnitIncrement(50);
		pantallaCargar.scrollNor.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		pantallaCargar.scrollNor.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		
		
		
		
		
		pantallaCargar.PartidasDificil.removeAll();
		
		
		ArrayList<String[]> infoDif = new ArrayList<>(controlDatos.mostrarInfoCargar(2));
		
		
		pantallaCargar.PartidasDificil = new JPanel(new GridBagLayout()) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setColor(new Color(0, 0, 0, 0));
				g2d.fillRect(0, 0, getWidth(), getHeight());
				g2d.dispose();
			}
		};
		pantallaCargar.PartidasDificil.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pantallaCargar.PartidasDificil.setOpaque(false);
		
		
		for (int i = 0; i < infoDif.size(); i++) {

			JPanel partidaPanel = new JPanel(new GridBagLayout()) {
				@Override
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					Graphics2D g2d = (Graphics2D) g.create();
					g2d.setColor(new Color(0, 51, 102, 128));
					g2d.fillRect(0, 0, getWidth(), getHeight());
					g2d.dispose();
				}
			};
			partidaPanel.setPreferredSize(new Dimension(375, 100));
			partidaPanel.setOpaque(false);
			partidaPanel.setBorder(new LineBorder(Color.LIGHT_GRAY));

			GridBagConstraints gbcPartidaPanel = new GridBagConstraints();

			gbcPartidaPanel.gridx = 0;
			gbcPartidaPanel.gridy = 0;
			gbcPartidaPanel.weighty = 1.0;
			gbcPartidaPanel.gridheight = 4;
			gbcPartidaPanel.fill = GridBagConstraints.VERTICAL;

			pantallaCargar.eliminarDif = new JButton(botonEliminarFIN);
			pantallaCargar.eliminarDif.setContentAreaFilled(false);
			pantallaCargar.eliminarDif.setFocusPainted(false);
			pantallaCargar.eliminarDif.setBorderPainted(false);

			pantallaCargar.playDif = new JButton(botonPlayFin);
			pantallaCargar.playDif.setContentAreaFilled(false);
			pantallaCargar.playDif.setFocusPainted(false);
			pantallaCargar.playDif.setBorderPainted(false);
			
			pantallaCargar.eliminarDif.addActionListener(Main.partidas);

			partidaPanel.add(pantallaCargar.eliminarDif, gbcPartidaPanel);

			final JButton finalEliminarDif = pantallaCargar.eliminarDif;
			
			pantallaCargar.eliminarDif.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					finalEliminarDif.setIcon(botonEliminarFINOP);
					partidaPanel.setBorder(new LineBorder(Color.pink, 2));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					finalEliminarDif.setIcon(botonEliminarFIN);
					partidaPanel.setBorder(new LineBorder(Color.lightGray, 2));
				}
			});

			gbcPartidaPanel.weighty = 0.0;
			gbcPartidaPanel.gridheight = 1;
			gbcPartidaPanel.fill = GridBagConstraints.NONE;

			for (int j = 0; j < infoDif.get(i).length + 1; j++) {

				switch (j) {
				case 0:
					JPanel usuarioPanel = new JPanel(new FlowLayout());
					usuarioPanel.setOpaque(false);

					JLabel jugador = new JLabel("Jugador: ");
					jugador.setFont(controlDatos.fuenteMC(15f));
					jugador.setForeground(Color.white);

					JLabel username = new JLabel("" + infoDif.get(i)[j].toUpperCase());
					username.setFont(controlDatos.fuenteMC(15f));
					username.setForeground(new Color(79, 240, 100));
					pantallaCargar.playDif.setName(infoDif.get(i)[j]);
					pantallaCargar.eliminarDif.setName(infoDif.get(i)[j]);
					
					
					usuarioPanel.add(jugador);
					usuarioPanel.add(username);
					gbcPartidaPanel.gridy = 0;
					gbcPartidaPanel.gridx = 1;
					partidaPanel.add(usuarioPanel, gbcPartidaPanel);
					break;
				case 1:
					JPanel rondasPanel = new JPanel(new FlowLayout());
					rondasPanel.setOpaque(false);

					JLabel rondas = new JLabel("N. Ronda: ");
					rondas.setFont(controlDatos.fuenteMC(12f));
					rondas.setForeground(Color.lightGray);

					int rondasNum = Integer.valueOf(infoDif.get(i)[j]);
					JLabel num = new JLabel("" + rondasNum);
					num.setFont(controlDatos.fuenteMC(12f));
					num.setForeground(Color.lightGray);

					rondasPanel.add(rondas);
					rondasPanel.add(num);

					gbcPartidaPanel.gridy = 1;
					gbcPartidaPanel.gridx = 1;
					partidaPanel.add(rondasPanel, gbcPartidaPanel);
					break;
				case 2:
					int puntuacionNum = Integer.valueOf(infoDif.get(i)[j]);
					JLabel puntuacion = new JLabel("Puntos: " + puntuacionNum);
					puntuacion.setFont(controlDatos.fuenteMC(12f));
					puntuacion.setForeground(Color.lightGray);
					gbcPartidaPanel.gridy = 2;
					gbcPartidaPanel.gridx = 1;
					partidaPanel.add(puntuacion, gbcPartidaPanel);
					break;
				case 3:
					JLabel dia = new JLabel("Ult. Jugado: (" + infoDif.get(i)[j] + ")");
					dia.setFont(controlDatos.fuenteMC(10f));
					dia.setForeground(Color.lightGray);
					gbcPartidaPanel.gridy = 3;
					gbcPartidaPanel.gridx = 1;
					partidaPanel.add(dia, gbcPartidaPanel);
					break;
				}

			}

			gbcPartidaPanel.gridx = 2;
			gbcPartidaPanel.gridy = 0;
			gbcPartidaPanel.weighty = 1.0;
			gbcPartidaPanel.gridheight = 4;
			gbcPartidaPanel.fill = GridBagConstraints.VERTICAL;


			
			pantallaCargar.playDif.addActionListener(Main.partidas);

			partidaPanel.add(pantallaCargar.playDif, gbcPartidaPanel);
			
			final JButton finalPlayDif = pantallaCargar.playDif;
			
			pantallaCargar.playDif.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					finalPlayDif.setIcon(botonPlayFinOP);
					partidaPanel.setBorder(new LineBorder(Color.green, 2));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					finalPlayDif.setIcon(botonPlayFin);
					partidaPanel.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
				}
			});

			gbcPartidaPanel.weighty = 0.0;
			gbcPartidaPanel.gridheight = 1;
			gbcPartidaPanel.fill = GridBagConstraints.NONE;

			pantallaCargar.gbcpartidasDif.insets = new Insets(10, 10, 10, 10);

			pantallaCargar.PartidasDificil.add(partidaPanel, pantallaCargar.gbcpartidasDif);
			pantallaCargar.gbcpartidasDif.gridy++;
		}

		pantallaCargar.scrollDif.setOpaque(false);
		if (infoDif.size() == 0) {
			JPanel noGameEz = new JPanel() {
				@Override
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					Graphics2D g2d = (Graphics2D) g.create();
					g2d.setColor(new Color(0, 0, 0, 0));
					g2d.fillRect(0, 0, getWidth(), getHeight());
					g2d.dispose();
				}
			};
			noGameEz.setPreferredSize(new Dimension(300, 75));
			noGameEz.setOpaque(false);
			noGameEz.setBorder(new LineBorder(Color.LIGHT_GRAY));

			JLabel noGameText = new JLabel("NO HAY PARTIDAS GUARDADAS");
			noGameText.setVerticalAlignment(JLabel.CENTER);
			noGameText.setHorizontalAlignment(JLabel.CENTER);
			noGameText.setFont(controlDatos.fuentecargar(30f));
			noGameText.setForeground(Color.white);

			noGameEz.add(noGameText);

			pantallaCargar.scrollDif.setViewportView(noGameEz);
		} else {
			pantallaCargar.scrollDif.setViewportView(pantallaCargar.PartidasDificil);
		}

		pantallaCargar.scrollDif.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		pantallaCargar.scrollDif.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		pantallaCargar.scrollDif.getVerticalScrollBar().setUnitIncrement(50);
		JViewport viewport3 = pantallaCargar.scrollDif.getViewport();
		viewport3.setOpaque(false);
		
		
		
	}
	
	
	public static void GUIrecordsActualizar() {
		
		records.topFacil.removeAll();
		records.topNormal.removeAll();
		records.topDificil.removeAll();
		
		records.gbcTopFacil.gridx = 0;
		records.gbcTopFacil.gridy = 0;
		records.gbcTopFacil.insets = new Insets(10,10,10,10);
		
		for (int i = 1; i < 6; i ++) {
			
			String textoTop = i + ". ";
			JPanel topPanel = new JPanel(new FlowLayout());
			topPanel.setOpaque(false);
			
			JLabel top = new JLabel(textoTop + controlDatos.topEz(0)[i-1]);
			top.setFont(controlDatos.fuenteMC(26f));
			top.setForeground(Color.white);
			
			topPanel.add(top);
			
			records.topFacil.add(top, records.gbcTopFacil);
			records.gbcTopFacil.gridy++;
			
		}
		
		
		records.topNormal.removeAll();
		
		records.gbcTopNormal.gridx = 0;
		records.gbcTopNormal.gridy = 0;
		records.gbcTopNormal.insets = new Insets(10,10,10,10);
		
		for (int i = 1; i < 6; i ++) {
			
			String textoTop = i + ". ";
			JPanel topPanel = new JPanel(new FlowLayout());
			topPanel.setOpaque(false);
			
			JLabel top = new JLabel(textoTop + controlDatos.topEz(1)[i-1]);
			top.setFont(controlDatos.fuenteMC(26f));
			top.setForeground(Color.white);
			
			topPanel.add(top);
			
			records.topNormal.add(top, records.gbcTopNormal);
			records.gbcTopNormal.gridy++;
			
		}
		
		records.topDificil.removeAll();
		
		records.gbcTopDificil.gridx = 0;
		records.gbcTopDificil.gridy = 0;
		records.gbcTopDificil.insets = new Insets(10,10,10,10);
		
		for (int i = 1; i < 6; i ++) {
			
			String textoTop = i + ". ";
			JPanel topPanel = new JPanel(new FlowLayout());
			topPanel.setOpaque(false);
			
			JLabel top = new JLabel(textoTop + controlDatos.topEz(2)[i-1]);
			top.setFont(controlDatos.fuenteMC(26f));
			top.setForeground(Color.white);
			
			topPanel.add(top);
			
			records.topDificil.add(top, records.gbcTopDificil);
			records.gbcTopDificil.gridy++;
			
		}
		
	}
	
	public static void actualizarGuiPartidaCargado() {
		
//		System.out.println(datos.getAcciones());
//		System.out.println(datos.getRondas());
		
		partida.acciones.setText("" + datos.getAcciones());
		partida.brotes.setText("" + datos.getBrotes());
		partida.rondas.setText("" + datos.getRondas());
		partida.scoreNum.setText("" + datos.getPuntuancion());
		
		partida.Alfa.setValue(datos.getVacunas().get(0).getPorcentaje());
		partida.Beta.setValue(datos.getVacunas().get(1).getPorcentaje());
		partida.Gamma.setValue(datos.getVacunas().get(2).getPorcentaje());
		partida.Delta.setValue(datos.getVacunas().get(3).getPorcentaje());
		
		partida.Alfa.setString("VIH: " + datos.getVacunas().get(0).getPorcentaje() + "%");
		partida.Beta.setString("CANCER: " + datos.getVacunas().get(1).getPorcentaje() + "%");
		partida.Gamma.setString("SARS: " + datos.getVacunas().get(2).getPorcentaje() + "%");
		partida.Delta.setString("NIGGA: " + datos.getVacunas().get(3).getPorcentaje() + "%");
		
		partida.ciudadesInf.setText("" + controlPartida.ciudadesInfectadas());
		
		for (int i = 0; i < datos.getCiudades().size(); i++) {
			
			ponerImages(i, comprobacionNombreBoton(datos.getCiudades().get(i).getNombre()));
			for (Component c : partida.game.getComponents()) {

				if (c instanceof JButton) {
					if (c.getName().equalsIgnoreCase(comprobacionNombreBoton(datos.getCiudades().get(i).getNombre())) && datos.getCiudades().get(i).isNuke()) {
						
						((JButton) c).setBorderPainted(true);
						((JButton) c).setBorder(new LineBorder(Color.red));

					}

				}
			}
		}
		
		
		
	}
	
}
