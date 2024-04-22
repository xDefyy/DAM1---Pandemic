public class virus {
	private String identificador;
	private String nombre;
	private String color;
	
	public virus(String identificador, String nombre, String color) {
		this.identificador = identificador;
		this.nombre = nombre;
		this.color = color;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}
