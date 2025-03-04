package es.upgrade.modelo.negocio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.upgrade.modelo.entidad.Videojuego;
import es.upgrade.modelo.persistencia.VideojuegoDAO;

@Service
public class GestorVideojuego {

	@Autowired
	private VideojuegoDAO vDao;
	
	/**
	 * Si el parámetro tiene el id, modificarmos, si no lo tiene, lo damos de alta
	 * @param v
	 * @return
	 * @throws Exception
	 */
	public Videojuego altaModificar(Videojuego v) throws Exception{
		if(v.getNombre().isBlank()) {
			return null;
		}
		return vDao.save(v);
	}
	
	public void borrar(int id) {
		vDao.deleteById(id);
	}
	
	public Optional<Videojuego> obtener(int id) {
		return vDao.findById(id);
	}
	
	public List<Videojuego> listar(){
		return vDao.findAll();
	}
	
	public List<Videojuego> listarPorCompania(String compania){
		return vDao.findByCompania(compania);
	}

}
