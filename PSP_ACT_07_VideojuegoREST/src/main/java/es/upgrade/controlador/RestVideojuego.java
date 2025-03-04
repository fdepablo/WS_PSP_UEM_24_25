package es.upgrade.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.upgrade.modelo.entidad.Videojuego;
import es.upgrade.modelo.negocio.GestorVideojuego;

@RestController
public class RestVideojuego {
	
	@Autowired
	private GestorVideojuego gv;

	@GetMapping("videojuegos/{id}")
	public ResponseEntity<Videojuego> obtener(@PathVariable int id){
		Optional<Videojuego> v = gv.obtener(id);
		if(v.isEmpty()) {
			return new ResponseEntity<Videojuego>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Videojuego>(v.get(), HttpStatus.OK);
		}
	}
	
	@PostMapping(path="videojuegos",consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Videojuego> alta(@RequestBody Videojuego v) {
		try {
			gv.altaModificar(v);
			return new ResponseEntity<Videojuego>(v,HttpStatus.CREATED);//201 CREATED
		} catch (Exception e) {
			return new ResponseEntity<Videojuego>(HttpStatus.BAD_REQUEST);
		}

	}
	
	@GetMapping(path="videojuegos",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Videojuego>> listar(
			@RequestParam(name="compania",required=false) String compania) {
		List<Videojuego> listaVideojuegos = null;
		//Si no me viene el nombre, devolvemos toda la lista
		if(compania == null) {
			System.out.println("Listando las personas");
			listaVideojuegos = gv.listar();		
		}else {
			listaVideojuegos = gv.listarPorCompania(compania);
		}
		if(listaVideojuegos == null) {
			return new ResponseEntity<List<Videojuego>>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<Videojuego>>(listaVideojuegos,HttpStatus.OK);
		}
	}
	
	@PutMapping(path="videojuegos/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Videojuego> modificarPersona(
			@PathVariable int id, 
			@RequestBody Videojuego v) {

		v.setId(id);
		
		try {
			gv.altaModificar(v);
			return new ResponseEntity<Videojuego>(v,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Videojuego>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping(path="videojuegos/{id}")
	public ResponseEntity<Videojuego> borrarPersona(@PathVariable int id) {
		gv.borrar(id);
		return new ResponseEntity<Videojuego>(HttpStatus.OK);//200 OK
	}
}
