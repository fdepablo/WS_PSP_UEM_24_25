package prueba;

//Convención JavaBean son atributos private y metodos accesores y 
//modificadores publicos. Además debe de tener el constructor por defecto

public class Persona {
	private String nombre;
	private int edad;
	private Direccion direccion;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	
	
}
