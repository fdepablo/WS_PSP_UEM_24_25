package prueba;

import java.util.ArrayList;

public class ClasePrueba2 {

	public static void main(String[] args) {
		new Persona();
		Persona p1 = null;
		p1 = crearPersona();
		
		p1.setEdad(40);
		
		var p2 = new Persona();
		p2.setEdad(55);
		
		p1 = p2;
		p2.setEdad(65);
		
		System.out.println(p1.getEdad());
		System.out.println(p2.getEdad());
		
		int n1 = 5;
		int n2 = 10;
		n1 = n2;
		n2 = 15;
		
		System.out.println(n1);
		System.out.println(n2);
		
		Persona p3 = new Persona();
		p3.setEdad(50);
		modificarEdadPersona(p3);
		System.out.println(p3.getEdad());
		
		var listaNumeros = new ArrayList<Persona>();
		Persona p4 = new Persona();
		
		listaNumeros.add(p4);
		p4.setNombre("Thor");
		System.out.println(listaNumeros.get(0).getNombre());
		Persona p5 = p4;
		p5.setNombre("Natasha");
		System.out.println(listaNumeros.get(0).getNombre());
	}
	
	public static Persona crearPersona() {
		var p1 = new Persona();
		return p1;
	}
	
	public static void modificarEdadPersona(Persona p) {
		p.setEdad(100);
	}

}
