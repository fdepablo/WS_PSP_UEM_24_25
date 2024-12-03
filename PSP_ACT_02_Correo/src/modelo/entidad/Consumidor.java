package modelo.entidad;

import hilo.GestorCorreo;

public class Consumidor extends Thread{

	private String nombre;
	private GestorCorreo cola;
	
	public Consumidor(String nombre, GestorCorreo cola){
		super();
		this.nombre = nombre;
		this.cola = cola;
	}
	
	public void run(){
		//Los consumidores están escuchando constantemente
		while(true) {
			Correo mensaje = cola.getMensaje();
			System.out.println("Consumidor: " + nombre + " ha consumido el mensaje: " + mensaje);
		}
	}

}