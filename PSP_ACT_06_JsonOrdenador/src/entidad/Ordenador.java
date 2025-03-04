package entidad;

import java.util.List;

public class Ordenador {
	private double precio;
	private String nombre;
	private Procesador procesador;
	private DiscoDuro disc;
	private FuenteDeAlimentacion fuente;
	private TarjetaGrafica tarjeta;
	private List<RAM> rams;
	private List<Perifericos> perifericos;

	public Ordenador(double precio, String nombre, Procesador procesador, DiscoDuro disc, FuenteDeAlimentacion fuente,
			TarjetaGrafica tarjeta, List<RAM> rams, List<Perifericos> perifericos) {
		super();
		this.precio = precio;
		this.nombre = nombre;
		this.procesador = procesador;
		this.disc = disc;
		this.fuente = fuente;
		this.tarjeta = tarjeta;
		this.rams = rams;
		this.perifericos = perifericos;

	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Procesador getProcesador() {
		return procesador;
	}

	public void setProcesador(Procesador procesador) {
		this.procesador = procesador;
	}

	public DiscoDuro getDisc() {
		return disc;
	}

	public void setDisc(DiscoDuro disc) {
		this.disc = disc;
	}

	public FuenteDeAlimentacion getFuente() {
		return fuente;
	}

	public void setFuente(FuenteDeAlimentacion fuente) {
		this.fuente = fuente;
	}

	public TarjetaGrafica getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(TarjetaGrafica tarjeta) {
		this.tarjeta = tarjeta;
	}

	public List<RAM> getRams() {
		return rams;
	}

	public void setRams(List<RAM> rams) {
		this.rams = rams;
	}

	public List<Perifericos> getPerifericos() {
		return perifericos;
	}

	public void setPerifericos(List<Perifericos> perifericos) {
		this.perifericos = perifericos;
	}

	@Override
	public String toString() {
		return "ordenador [precio=" + precio + ", nombre=" + nombre + ", procesador=" + procesador + ", disc=" + disc
				+ ", fuente=" + fuente + ", tarjeta=" + tarjeta + ", rams=" + rams + ", perifericos=" + perifericos
				+ "]";
	}

}
