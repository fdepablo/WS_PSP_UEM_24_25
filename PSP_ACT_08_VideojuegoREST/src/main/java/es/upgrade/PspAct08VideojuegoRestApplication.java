package es.upgrade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import es.upgrade.modelo.entidad.Videojuego;
import es.upgrade.modelo.persistencia.VideojuegoDAO;

@SpringBootApplication
public class PspAct08VideojuegoRestApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(PspAct08VideojuegoRestApplication.class, args);
		
		Videojuego v1 = new Videojuego();
		v1.setNombre("Sonic");
		v1.setCompania("Sega");
		v1.setNota(10);
		
		Videojuego v2 = new Videojuego();
		v2.setNombre("Mario Bross");
		v2.setCompania("Nintendo");
		v2.setNota(9.5);
		
		VideojuegoDAO vDAO = context.getBean("videojuegoDAO",VideojuegoDAO.class);
		vDAO.save(v1);
		vDAO.save(v2);
	}

}
