package controladores;
import intefaz.partida;

public class controlPartida {
	
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
			        //for de 4 
			            for (int i = 0; i <= 20; i++) {
			                partida.Alfa.setValue(i); // Actualiza el valor de la barra de progreso
			                partida.Alfa.setString("Progreso Alfa = " + partida.Alfa.getValue());
			                Thread.sleep(50); // Espera un momento para simular el progreso
			                if (partida.Alfa.getValue() == 100) {
			                	partida.Alfa.setString("ALFA COMPLETADO!");
			                	System.out.println("Bien hecho!");
			                }
			            }
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
			            for (int i = 0; i <= 20; i++) {
			                partida.Beta.setValue(i); // Actualiza el valor de la barra de progreso
			                partida.Beta.setString("Progreso Alfa = " + partida.Beta.getValue());
			                Thread.sleep(50); // Espera un momento para simular el progreso
			                if (partida.Beta.getValue() == 100) {
			                	partida.Beta.setString("BETA COMPLETADO!");
			                	System.out.println("Bien hecho!");
			                }
			            }
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
			            for (int i = 0; i <= 20; i++) {
			                partida.Gamma.setValue(i); // Actualiza el valor de la barra de progreso
			                partida.Gamma.setString("Progreso Alfa = " + partida.Gamma.getValue());
			                Thread.sleep(50); // Espera un momento para simular el progreso
			                if (partida.Gamma.getValue() == 100) {
			                	partida.Gamma.setString("Gamma COMPLETADO!");
			                	System.out.println("Bien hecho!");
			                }
			            }
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
			            for (int i = 0; i <= 20; i++) {
			                partida.Delta.setValue(i); // Actualiza el valor de la barra de progreso
			                partida.Delta.setString("Progreso Alfa = " + partida.Delta.getValue());
			                Thread.sleep(50); // Espera un momento para simular el progreso
			                if (partida.Delta.getValue() == 100) {
			                	partida.Delta.setString("Delta COMPLETADO!");
			                	System.out.println("Bien hecho!");
			                }
			            }
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
