package main;

import hilo.GestorCorreo;
import modelo.entidad.Consumidor;
import modelo.entidad.Productor;
import util.GeneradorEmails;

public class MainColaCorreo {

	public static void main(String[] args) {
		GestorCorreo cola = new GestorCorreo();
		GeneradorEmails ge = new GeneradorEmails();
		
		Productor p1 = new Productor("Producto 1",cola,ge);
		Productor p2 = new Productor("Producto 2",cola,ge);
		Productor p3 = new Productor("Producto 3",cola,ge);
		
		Consumidor c1 = new Consumidor("Consumidor 1",cola);
		Consumidor c2 = new Consumidor("Consumidor 2",cola);
		
		p1.start();
		p2.start();
		p3.start();
		
		c1.start();
		c2.start();
	}

}
