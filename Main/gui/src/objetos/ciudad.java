package objetos;
public class ciudad {

	/**
	 * @author Liqi y Kader
	 * 
	 */
	private String nombre;
	private int[] coordenadas;
	private String enfermedad;
	private int infeccion;
	private String[] ciudadesColindantes;
	private boolean nuke;
	
	public ciudad(String nombre, int[] coordenadas, String enfermedad, int infeccion, String[] ciudadesColindantes, boolean nuke) {
		this.nombre = nombre;
		this.coordenadas = coordenadas;
		this.enfermedad = enfermedad;
		this.infeccion = infeccion;
		this.ciudadesColindantes = ciudadesColindantes;
		this.nuke = nuke;
	}

	public boolean isNuke() {
		return nuke;
	}

	public void setNuke(boolean nuke) {
		this.nuke = nuke;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int[] getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(int[] coordenadas) {
		this.coordenadas = coordenadas;
	}

	public String getEnfermedad() {
		return enfermedad;
	}

	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}

	public int getInfeccion() {
		return infeccion;
	}

	public void setInfeccion(int infeccion) {
		this.infeccion = infeccion;
	}

	public String[] getCiudadesColindantes() {
		return ciudadesColindantes;
	}

	public void setCiudadesColindantes(String[] ciudadesColindantes) {
		this.ciudadesColindantes = ciudadesColindantes;
	}
	
	public static void aumentar_Infeccion () {
		
	}
	
	public static void disminuir_Infeccion () {
		
	}
	
	public static void propagar_Infeccion () {
		
	}
	
}
