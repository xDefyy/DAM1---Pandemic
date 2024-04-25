package objetos;
public class vacunas {
	private String nombre;
	private String color;
	private double porcentaje;
	
	public vacunas(String nombre, String color, double porcentaje) {
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
	
	public double getPorcentaje() {
		return porcentaje;
	}
	
	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	} 
	
	public static void desarrollarVacuna(double porcentaje) {
		
	}
}
