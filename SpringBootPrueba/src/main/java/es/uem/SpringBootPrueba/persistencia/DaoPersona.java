package es.uem.SpringBootPrueba.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uem.SpringBootPrueba.modelo.entidad.Persona;

public interface DaoPersona extends JpaRepository<Persona, Integer> {

}
