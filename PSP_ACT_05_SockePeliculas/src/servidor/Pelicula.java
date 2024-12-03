package servidor;

public class Pelicula {
	private int id;
	private String titulo;
	private String director;
	private double precio;
	
	public Pelicula(int id, String titulo, String director, double precio) {
		this.id = id;
		this.titulo = titulo;
		this.director = director;
		this.precio = precio;
	}
	public Pelicula(String titulo, String director, double precio) {
		this.titulo = titulo;
		this.director = director;
		this.precio = precio;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", titulo=" + titulo + ", director=" + director + ", precio=" + precio + "]";
	}
}
