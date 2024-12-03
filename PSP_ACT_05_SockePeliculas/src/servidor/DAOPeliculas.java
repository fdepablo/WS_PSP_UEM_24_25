package servidor;

import java.sql.*;

public class DAOPeliculas {
	private static String url;
	private String proyectPath;

	public DAOPeliculas() {
		this.proyectPath = System.getProperty("user.dir");
		this.url = ("jdbc:h2:file:" + this.proyectPath + "\\bbdd\\src\\Peliculas.db");
	}

	public void crearTablaPeliculas() throws SQLException {
		Connection conexion = DriverManager.getConnection(url);
		String dropTable = "DROP TABLE IF EXISTS TABLAALUMNOS";
		try (PreparedStatement eliminarSentencia = conexion.prepareStatement(dropTable)) {
			eliminarSentencia.execute();
		}
		PreparedStatement sentencia = conexion.prepareStatement("CREATE TABLE IF NOT EXISTS TABLAPELICULAS (ID INT PRIMARY KEY, TITULO VARCHAR(50), DIRECTOR VARCHAR(30), PRECIO DOUBLE)");
		sentencia.execute();
	}

	public static boolean existePelicula(Pelicula a) throws SQLException {
	    Connection conexion = DriverManager.getConnection(url);
	    PreparedStatement sentencia = conexion.prepareStatement("SELECT * FROM TABLAPELICULAS WHERE ID = ?");
	    sentencia.setInt(1, a.getId());
	    ResultSet result = sentencia.executeQuery();
	    boolean existe = result.next();
	    conexion.close();
	    return existe;
	}

	public static synchronized void insertarPelicula(Pelicula a) throws SQLException {
		Connection conexion = DriverManager.getConnection(url);
		if (!existePelicula(a)) {
			a.setId(obtenerSiguienteID());
			PreparedStatement sentencia = conexion
					.prepareStatement("INSERT INTO TABLAPELICULAS (ID, TITULO, DIRECTOR, PRECIO) VALUES(?, ?, ?, ?)");
			sentencia.setInt(1, a.getId());
			sentencia.setString(2, a.getTitulo().toLowerCase()); // TITULO
			sentencia.setString(3, a.getDirector().toLowerCase()); // DIRECTOR
			sentencia.setDouble(4, a.getPrecio()); // PRECIO
			sentencia.execute();
			conexion.close();
			
		} else {
	        System.out.println("Ya existe una película con ese ID.");
		}
	}

	public String mostrarTabla() throws SQLException {
		Connection conexion = DriverManager.getConnection(this.url);
		PreparedStatement sentencia = conexion.prepareStatement("SELECT * FROM TABLAPELICULAS");
		ResultSet resultado = sentencia.executeQuery();
		String output = "";
		while (resultado.next()) {
			output += resultado.getInt("ID");
			output += "-";
			output += resultado.getString("TITULO");
			output += "-";
			output += resultado.getString("DIRECTOR");
			output += "-";
			output += resultado.getDouble("PRECIO");
			output += "_";
		}
		if (output.length() == 0) {
			output += ("No se encontró ninguna película");
		}
		conexion.close();
		return output;
	}

	public String consultarPeliculaID(int id) throws SQLException {
		Connection conexion = DriverManager.getConnection(this.url);
		PreparedStatement sentencia = conexion.prepareStatement("SELECT * FROM TABLAPELICULAS WHERE ID = ?");
		sentencia.setInt(1, id);
		ResultSet resultado = sentencia.executeQuery();
		String output = "";
		while (resultado.next()) {
			output += resultado.getInt("ID");
			output += "-";
			output += resultado.getString("TITULO");
			output += "-";
			output += resultado.getString("DIRECTOR");
			output += "-";
			output += resultado.getDouble("PRECIO");
		}
		if (output.length() == 0) {
			output += ("No se encontró ninguna película con ese id " + id);
		}
		conexion.close();
		System.out.println(output);
		return output;
	}

	public String consultarPeliculaTitulo(String titulo) throws SQLException {
		Connection conexion = DriverManager.getConnection(this.url);
		PreparedStatement sentencia = conexion.prepareStatement("SELECT * FROM TABLAPELICULAS WHERE TITULO = ?");
		sentencia.setString(1, titulo);
		ResultSet resultado = sentencia.executeQuery();
		String output = "";
		while (resultado.next()) {
			output += resultado.getInt("ID");
			output += "-";
			output += resultado.getString("TITULO");
			output += "-";
			output += resultado.getString("DIRECTOR");
			output += "-";
			output += resultado.getDouble("PRECIO");
			output += "_";
		}
		if (output.length() == 0) {
			output += ("No se encontró ninguna película con ese titulo " + titulo);
		}
		conexion.close();
		return output;
	}

	public String consultarPeliculaDirector(String director) throws SQLException {
		Connection conexion = DriverManager.getConnection(this.url);
		PreparedStatement sentencia = conexion.prepareStatement("SELECT * FROM TABLAPELICULAS WHERE DIRECTOR = ?");
		sentencia.setString(1, director);
		ResultSet resultado = sentencia.executeQuery();
		String output = "";
		while (resultado.next()) {
			output += resultado.getInt("ID");
			output += "-";
			output += resultado.getString("TITULO");
			output += "-";
			output += resultado.getString("DIRECTOR");
			output += "-";
			output += resultado.getDouble("PRECIO");
			output += "_";

		}
		if (output.length() == 0) {
			output += ("No se encontró ninguna película con ese director " + director);
		}
		conexion.close();
		return output;
	}
	public void limpiarTabla() throws SQLException {
	    Connection conexion = DriverManager.getConnection(this.url);
	    PreparedStatement stmt = conexion.prepareStatement("DELETE FROM TABLAPELICULAS");
	    stmt.executeUpdate();
	    conexion.close();
	}
	public static int obtenerSiguienteID() throws SQLException {
	    Connection conexion = DriverManager.getConnection(url);
	    String query = "SELECT COUNT(*) AS TOTAL FROM TABLAPELICULAS";
	    PreparedStatement sentencia = conexion.prepareStatement(query);
	    ResultSet resultado = sentencia.executeQuery();
	    int siguienteID = 5;
	    if (resultado.next()) {
	        siguienteID = resultado.getInt("TOTAL") + 1;
	    }
	    conexion.close();
	    return siguienteID;
	}

}
