package inicio;
import intefaz.CargarParty;
import intefaz.Reglas;
import intefaz.pantallaPrincipal;
import intefaz.partida;


public class Main {
	
	public static CargarParty cargarParty = new CargarParty();
    public static Reglas CargarReglas = new Reglas();
    public static pantallaPrincipal cargarPrincipal = new pantallaPrincipal();
    
	public static void main(String[] args) {
		partida frame = new partida();
	}

}