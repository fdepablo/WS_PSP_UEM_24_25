package es.uem.SpringBootPrueba;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import es.uem.SpringBootPrueba.modelo.entidad.Direccion;
import es.uem.SpringBootPrueba.modelo.entidad.Persona;
import es.uem.SpringBootPrueba.persistencia.DaoPersona;
import es.uem.SpringBootPrueba.persistencia.DireccionDao;

@SpringBootApplication
public class SpringBootPruebaApplication {

	public static void main(String[] args) {
		//Esta linea inicializa el contexto de spring y te devuelve una refenencia al mismo
		ApplicationContext context = SpringApplication.run(SpringBootPruebaApplication.class, args);
		
		Persona p = context.getBean("persona",Persona.class);
		System.out.println(p.getNombre());//Capi
		System.out.println(p);
		
		p = context.getBean("persona2", Persona.class);
		System.out.println(p.getNombre());
		
		DireccionDao ddao = context.getBean("direccionDao", DireccionDao.class);
		
		Direccion d1 = new Direccion();
		d1.setNombreVia("Fuenterebollo");
		d1.setTipoVia("Avenida");
		ddao.save(d1);
		
		List<Direccion> listaDireciones = ddao.findAll();
		System.out.println(listaDireciones);
		
		listaDireciones = ddao.findByTipoVia("calle");
		System.out.println(listaDireciones);
		
		DaoPersona daop = context.getBean("daoPersona", DaoPersona.class);
		daop.save(p);
		
	}
	
	//Podemos dar de alta objetos en el contexto de Spring mediante anotaciones o mediante
	//JavaConfig con la anotacion @Bean encima de un método dentro de esta clase
	//De esta manera se dará de alta en el contexto de spring con el nombre del método
	@Bean
	public Persona persona2() {
		Persona p = new Persona();
		p.setNombre("Iron Man");
		return p;
	}

}
