package es.upgrade.modelo.persistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.upgrade.modelo.entidad.Videojuego;

@Repository
public interface VideojuegoDAO extends JpaRepository<Videojuego, Integer>{

	public List<Videojuego> findByCompania(String compania);
}
