package es.uem.SpringBootPrueba.modelo.entidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//Con la anotación @Component damos de alta el objeto en el contexto de Spring.
//Ete objeto se dara de alta con el nombre de la clase en lowerCamelCase "persona"
@Component
public class Persona {
	private Integer id;
	private String nombre = "Capi";
	private int edad;
	
	//Con esta anotacion aplicamos la DI y decimos que nos inyecte un objeto de tipo direccion
	//que este en el contexto a esta referncia
	@Autowired
	private Direccion direccion;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", direccion=" + direccion + "]";
	}
	
	
}
