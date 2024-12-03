package cliente;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	private static final int PUERTO = 3000;
	private static final String IP_SERVER = "localhost";

	public static void main(String[] args) {
		System.out.println("            BIENVENIDO AL GESTOR DE PELICULAS            ");
		System.out.println("---------------------------------------------------------");

		// Creamos un objeto con la direccion del servidor "la llave"
		InetSocketAddress direccionServidor = new InetSocketAddress(IP_SERVER, PUERTO);
		try (Scanner sc = new Scanner(System.in)) {
			boolean continuar = true;

			// Primero creamos un socket al servidor "la carretera hacia el servidor"
			try (Socket socketAlServidor = new Socket()) {
				socketAlServidor.connect(direccionServidor);
				System.out.println("CLIENTE: Esperando a que el servidor acepte la conexion");
				System.out.println("CLIENTE: Conexion establecida... a " + IP_SERVER + " por el puerto " + PUERTO);
				System.out.println("\n");

				do {
					// Configuramos los flujos de entrada y salida:

					// Salida
					PrintStream salida = new PrintStream(socketAlServidor.getOutputStream());
					StringBuilder mensaje = new StringBuilder();
					// Entrada
					InputStreamReader entrada = new InputStreamReader(socketAlServidor.getInputStream());
					BufferedReader entradaProcesada = new BufferedReader(entrada);
					String respuesta = "";

					System.out.println("Seleccione una opcion: (Introduzca el número para seleccionar la opción) | Se recomienda si es un primer uso del programa eliminar la base de datos previamente con la opción 5");
					System.out.println("1.Consultar película por ID");
					System.out.println("2.Consultar película por titulo");
					System.out.println("3.Consultar película por director");
					System.out.println("4.Agregar película");
					System.out.println("5.Mostrar tabla");
					System.out.println("6.Salir de la aplicación");
					int opcion = sc.nextInt();
					sc.nextLine();
					switch (opcion) {
					case 1:
						mensaje.append("1-");
						System.out.print("Introduzca un ID: ");
						mensaje.append(sc.nextInt());
						salida.println(mensaje.toString().toUpperCase());
						break;
					case 2:
						mensaje.append("2-");
						System.out.print("Introduzca un titulo: ");
						mensaje.append(sc.nextLine());
						salida.println(mensaje.toString().toUpperCase());
						break;
					case 3:
						mensaje.append("3-");
						System.out.print("Introduzca un director: ");
						mensaje.append(sc.nextLine());
						salida.println(mensaje.toString().toUpperCase());
						break;
					case 4:
						mensaje.append("4-");
						System.out.print("Introduzca un titulo: ");
						mensaje.append(sc.nextLine()).append("-");
						System.out.print("Introduzca un director: ");
						mensaje.append(sc.nextLine()).append("-");
						System.out.print("Introduzca un precio: ");
						mensaje.append(sc.nextLine());
						salida.println(mensaje.toString().toUpperCase());
						break;
					case 5:
						mensaje.append("5");
						salida.println(mensaje.toString().toUpperCase());
						break;
					case 6:
						salida.println("FIN");
						break;
					default:
						System.out.println("Escoja una de las opciones disponibles");
					}

					// Gestionando resultados
					respuesta = entradaProcesada.readLine();
					if (respuesta.equalsIgnoreCase("OK")) {
						continuar = false;
					} else {
						if (respuesta.contains("_")) {
							String[] respuesta1 = respuesta.split("_");
							System.out.println("Películas encontradas: ");
							for (String index : respuesta1) {
								String[] respuesta2 = index.split("-");
								for (String index1 : respuesta2) {
									System.out.print(index1);
									System.out.print(" ");
								}
								System.out.println("");
							}
						} else {
							String[] respuesta1 = respuesta.split("-");
							System.out.println("Películas encontradas: ");
							for (String string : respuesta1) {
								System.out.print(string);
								System.out.print(" ");
							}
						}
						System.out.println(" ");
					}
				} while (continuar);
			}
			System.out.println("Cierre del programa exitoso.");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
