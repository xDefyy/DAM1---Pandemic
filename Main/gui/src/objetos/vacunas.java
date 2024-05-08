package objetos;
public class vacunas {
	private String nombre;
	private String color;
	private int porcentaje;
	
	public vacunas(String nombre, String color, int porcentaje) {
		this.nombre = nombre;
		this.color = color;
		this.porcentaje = porcentaje;
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
	
	public int getPorcentaje() {
		return porcentaje;
	}
	
	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	} 
	
}
