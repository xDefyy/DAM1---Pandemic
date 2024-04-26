package controladores;

import CargaDatos.controlDatos;
import intefaz.partida;

public class controlPartida {
	
	public static int progresoA = Integer.valueOf(controlDatos.desarrolloVacuna);
	public static int progresoB = Integer.valueOf(controlDatos.desarrolloVacuna);
	public static int progresoG = Integer.valueOf(controlDatos.desarrolloVacuna);
	public static int progresoD = Integer.valueOf(controlDatos.desarrolloVacuna);
	public static int aux = Integer.valueOf(controlDatos.desarrolloVacuna);

	public static void iniciar_Partida() {

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

	}

	public static void gestionar_Brote() {

	}

	public static void gestionar_Fin_Partida() {

	}

	public static void gestionar_Frase() {

	}

	public static void gestionar_Cura() {
		System.out.println("hola");
	}

}
