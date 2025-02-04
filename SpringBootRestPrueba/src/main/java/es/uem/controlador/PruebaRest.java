package es.uem.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PruebaRest {

	private String ashe = "Hola soy ashe y te tiro una flecha de hielo";
	
	@GetMapping("/ashe")
	public String obtenerAshe() {
		return ashe;
	}
	
	@PutMapping("/ashe")
	public void actualizarAshe(@RequestBody String nuevaAshe) {
		this.ashe = nuevaAshe;
	}
}
