package prueba;

public class MainPrueba {

	public static void main(String[] args) {
		var cadena = "Esto es un string";
		String cadena2 = "Esto es otra cadena";
		var numero = 2;
		
		var persona1 = new Persona();
		persona1 = null;
		System.gc();
		
		{
			var persona2 = new Persona();
			persona2.setNombre("Tony Stark");
		}

	}

}
