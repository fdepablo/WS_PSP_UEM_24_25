package util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import modelo.entidad.Correo;

public class GeneradorEmails {
	
	private int contadorId;
	
	public Correo generarEmail() {
		Correo email = new Correo();
		email.setId(generarId());
		email.setDestinatario(generarDestinatario());
		email.setAsunto(generarAsunto());
		email.setCuerpo(generarCuerpoMensaje());
		email.setRemitente(generarRemitente());
		return email;
	}

	private String generarRemitente() {
		List<String> listaNombresRemitentes = new ArrayList<>();
		listaNombresRemitentes.add("astarion@ejemplo.com");
		listaNombresRemitentes.add("karlach@ejemplo.com");
		listaNombresRemitentes.add("shadow@ejemplo.com");
		listaNombresRemitentes.add("minsk@ejemplo.com");
		listaNombresRemitentes.add("jaihira@ejemplo.com");
		listaNombresRemitentes.add("mustio@ejemplo.com");
		listaNombresRemitentes.add("gale@ejemplo.com");
		listaNombresRemitentes.add("will@ejemplo.com");
		listaNombresRemitentes.add("laezhet@ejemplo.com");

		int numero = ThreadLocalRandom.current().nextInt(0, 9);

		return listaNombresRemitentes.get(numero);
	}

	private String generarCuerpoMensaje() {
		List<String> listaCuerpoMensaje = new ArrayList<String>();
		listaCuerpoMensaje.add("Me apetece chuparte la sangre mmmm...");
		listaCuerpoMensaje.add("Matamos a unos cuantos ladrones ");
		listaCuerpoMensaje.add("Selune es la unica que manda en mi");
		listaCuerpoMensaje.add("Bubu a los ojoooooosss");
		listaCuerpoMensaje.add("Tengo mas años que el sol");
		listaCuerpoMensaje.add("Soy un dios XD y nadie se entera");
		listaCuerpoMensaje.add("Tengo una cosa en el pecho que hace pum pum");
		listaCuerpoMensaje.add("Tengo cuernos ahora y no por la novia");
		listaCuerpoMensaje.add("Eres una abobinación");

		int numero = ThreadLocalRandom.current().nextInt(0, 9);

		return listaCuerpoMensaje.get(numero);
	}

	private String generarAsunto() {
		List<String> listaAsuntos = new ArrayList<String>();
		listaAsuntos.add("Asunto urgente");
		listaAsuntos.add("Asunto no urgente");
		listaAsuntos.add("Asunto normal");
		listaAsuntos.add("Muerte");
		listaAsuntos.add("Viagra gratis");

		int numero = ThreadLocalRandom.current().nextInt(0, 5);

		return listaAsuntos.get(numero);
	}

	private String generarDestinatario() {
		List<String>listaNombresDestinatario = new ArrayList<>();
		listaNombresDestinatario.add("noctis@ejemplo.com");
		listaNombresDestinatario.add("cloud@ejemplo.com");
		listaNombresDestinatario.add("tidus@ejemplo.com");
		listaNombresDestinatario.add("sefirot@ejemplo.com");
		listaNombresDestinatario.add("squall@ejemplo.com");
		listaNombresDestinatario.add("tifa@ejemplo.com");
		listaNombresDestinatario.add("pikachu@gmail.com");
		listaNombresDestinatario.add("zack@ejemplo.com");
		listaNombresDestinatario.add("barret@ejemplo.com");
	
		int numero = ThreadLocalRandom.current().nextInt(0, 9);
		
		return listaNombresDestinatario.get(numero);		
	}

	private synchronized int generarId() {
		int numero = contadorId++;
		return numero;		
	}

}
