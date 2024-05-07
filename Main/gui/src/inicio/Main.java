package inicio;


import controladores.reproductorWav;
import intefaz.CargarParty;
import intefaz.Reglas;
import intefaz.pantallaPrincipal;



public class Main {
	
	public static CargarParty cargarParty = new CargarParty();
    public static Reglas CargarReglas = new Reglas();
    public static pantallaPrincipal cargarPrincipal = new pantallaPrincipal();
    public static reproductorWav reproductor = new reproductorWav();
	public static void main(String[] args) {
		reproductor.cargarSonido("src\\musica\\musicaMenuMC.wav");
		reproductor.reproducirConRepetir();
		
	}
	
}

/*	
 	Prioridad:
 
	Mapa con los botones
	Apartado de reglas
	Records
	Cargar partida
	Guardar partida
	Reset de partida
	Revisar funciones del juego
	
	Gestionar Frases que se muestre en dificultad facil y normal
	
	
	Opcional:
	
	Eventos extras
	GUI 
	Optimizar juego
	Añadir funciones extras
*/