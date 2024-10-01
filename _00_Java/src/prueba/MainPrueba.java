package prueba;

import java.util.ArrayList;
import java.util.List;

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
		
		long cp = 0b101;
		System.out.println(cp);
		
		var persona = new Persona();
		Direccion d1 = new Direccion();
		persona.setDireccion(d1);
		persona.getDireccion().setPais("España");
		persona.getDireccion().setPais("Francia");
		System.out.println(d1.getPais());
		d1.setCp("28024");
		
		List<Persona> listaPersonas = new ArrayList<>();
		listaPersonas.add(persona);
		d1.setTipoVia("Calle");
		System.out.println();
		System.out.println(listaPersonas.get(0).getDireccion().getTipoVia());
		var persona3 = new Persona();
		
		listaPersonas.add(persona3);
		persona3.setNombre("Thor");
		System.out.println(listaPersonas.get(1).getNombre());
		listaPersonas.get(0).setDireccion(new Direccion());
		System.out.println(d1.getTipoVia());
		
	}

}
