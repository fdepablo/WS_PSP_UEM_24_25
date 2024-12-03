package modelo.entidad;

import hilo.GestorCorreo;
import util.GeneradorEmails;

public class Productor extends Thread{

	private String nombre;
	private GestorCorreo cola;
	private GeneradorEmails ge;
	
	public Productor(String nombre, GestorCorreo cola, GeneradorEmails ge){
		super();
		this.nombre = nombre;
		this.cola = cola;
		this.ge = ge;
	}
	
	//Cada productor produce 10 mensajes
	public void run(){
		for(int i = 1;i <= 10;i++){
			Correo correo = ge.generarEmail();
			System.out.println("Productor " + nombre + " generando: " + correo);
			cola.addMensaje(correo);
		}
	}

}