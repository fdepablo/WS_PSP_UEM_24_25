package es.uem.SpringBootPrueba.persistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.uem.SpringBootPrueba.modelo.entidad.Direccion;

//Esto nos implementa toda la funcionalidad para hacer la persistencia
@Repository
public interface DireccionDao extends JpaRepository<Direccion, Integer>{
	
	public List<Direccion> findByTipoVia(String tipoVia);

}
