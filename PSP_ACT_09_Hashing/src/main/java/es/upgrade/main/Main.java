package es.upgrade.main;

import java.util.Scanner;

import es.upgrade.modelo.entidad.Persona;
import es.upgrade.modelo.gestor.GestorUsuario;

public class Main {
	public static void main(String[] args) {
	      Scanner scanner = new Scanner(System.in);
	        GestorUsuario gestor = new GestorUsuario();

	        while (true) {
	            System.out.println("==================================");
	            System.out.println("        Bienvenido al sistema     ");
	            System.out.println("==================================");
	            System.out.println("1. Sign Up (Registrar usuario)");
	            System.out.println("2. Sign In (Iniciar sesión)");
	            System.out.println("3. Salir");
	            System.out.print("Selecciona una opción: ");

	            int opcion = scanner.nextInt();
	            scanner.nextLine(); 

	            switch (opcion) {
	                case 1:
	                    signUp(scanner, gestor);
	                    break;
	                case 2:
	                    signIn(scanner, gestor);
	                    break;
	                case 3:
	                    System.out.println("Saliendo del sistema...");
	                    gestor.close();
	                    scanner.close();
	                    return;
	                default:
	                    System.out.println("⚠ Opción no válida, intenta de nuevo.");
	            }
	        }
	    }

	    private static void signUp(Scanner scanner, GestorUsuario gestor) {
	        System.out.println("\n=== Registro de usuario ===");
	        System.out.print("Introduce tu nombre de usuario: ");
	        String nombre = scanner.nextLine();
	        System.out.print("Introduce tu contraseña: ");
	        String password = scanner.nextLine();

	        try {
	            Persona p = new Persona();
	            p.setNombre(nombre);
	            p.setPassword(password);
	            gestor.registrarPersona(p);
	            System.out.println("✅ Usuario registrado con éxito.");
	        } catch (RuntimeException e) {
	            System.out.println("❌ Error: " + e.getMessage());
	        }
	    }

	    private static void signIn(Scanner scanner, GestorUsuario gestor) {
	        System.out.println("\n=== Inicio de sesión ===");
	        System.out.print("Nombre de usuario: ");
	        String nombre = scanner.nextLine();
	        System.out.print("Contraseña: ");
	        String password = scanner.nextLine();

	        if (gestor.autenticarUsuario(nombre, password)) {
	            System.out.println("✅ Inicio de sesión exitoso. ¡Bienvenido, " + nombre + "!");
	        } else {
	            System.out.println("❌ Nombre de usuario o contraseña incorrectos.");
	        }
	    }
	}