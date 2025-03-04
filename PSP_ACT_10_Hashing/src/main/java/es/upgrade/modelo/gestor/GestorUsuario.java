package es.upgrade.modelo.gestor;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import es.upgrade.modelo.entidad.Persona;
import es.upgrade.modelo.persistencia.DaoUsuario;

public class GestorUsuario {
	private DaoUsuario daoUsuario;
	
	public GestorUsuario() {
		daoUsuario = DaoUsuario.getInstance();
	}
	public boolean elNombreEstaCogido(String nombre) {
        return daoUsuario.findByName(nombre) != null;
    }
	
	/**
	 * Autentica a un usuario verificando si el nombre de usuario existe
	 * en la BBDD y que la contraseña ingresada coincida con la almacenada
	 * en la BBDD
	 * @param nombre El nombre del usuario a buscar en la BBDD
	 * @param password La contraseña ingresada por el usuario
	 * @return Devuelve true si el usuario existe y la contraseña es correcta
	 * y devuelve false en caso contrario
	 */
	public boolean autenticarUsuario(String nombre, String password) {
		Persona p = daoUsuario.findByName(nombre);
		if(p == null) {
			return false; // El usuario no encontrado
		}
		String hashPassword = hashPassword(password);
		return p.getPassword().equals(hashPassword);
	}
	/**
	 * Metodo que registra una Persona en la BBDD
	 * Verifica si el nombre de la Persona ya se encuentra en la BBDD, si no lo esta
	 * lo guarda. La contraseña se almacena de manera hasheada en la BBDD
	 * @param p La persona que se desea registrar, que contiene el nombre y la contraseña
	 */
	public void registrarPersona(Persona p) {
	    if (!elNombreEstaCogido(p.getNombre())) { // Solo verifico si el nombre existe
            String hashPassword = hashPassword(p.getPassword()); // Hasheamos la contraseña antes de guardarla
            p.setPassword(hashPassword);
            daoUsuario.savePersona(p);
        } else {
            throw new RuntimeException("Maquina, el usuario ya está registrado.");
        }
    }
	public void close() {
		daoUsuario.close();
	}
	
	public String hashPassword(String password) {
		try {
			// Creamos un objeto MessageDigest a traves del metodo
			// estatico getInstance al que le pasamos el tipo de 
			// de algoritmo que vamos a usar en este caso SHA-512
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[]passwordBytes = password.getBytes();
			md.update(passwordBytes);
			// Ahora vamos a ejecutar el meotod digest() de nuestro objeto
			// MessageDigest para obtener el resumen 
			byte[]resumen = md.digest();
			return Base64.getEncoder().encodeToString(resumen);
			
		}catch (NoSuchAlgorithmException  e) {
			 throw new RuntimeException("Error al hashear la contraseña con SHA-512", e);
		}
	}
	

}
