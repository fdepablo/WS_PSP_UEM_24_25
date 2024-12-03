package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketCliente {
	
	public static final int PUERTO = 20124;
	public static final String IP_SERVER = "localhost";
	
	private static Scanner sc = new Scanner(System.in);
	private static InetSocketAddress direccionServidor = new InetSocketAddress(IP_SERVER, PUERTO);
	
	public static void main(String[] args) {
		System.out.println("        APLICACIÓN CLIENTE         ");
		System.out.println("-----------------------------------");
				
		int opcion = menu();
		do {
			if(opcion != 0) {
				System.out.println("CLIENTE: Introduzca los numeros a operar");
				int numero1 = sc.nextInt();//supongamos el numero 3
				int numero2 = sc.nextInt();//supongamos el numero 4
				String resultado = enviarOperacion(opcion,numero1,numero2);
				System.out.println(resultado);
				opcion = menu();
			}			
		}while(opcion != 0);
		
		System.out.println("Saliendo del programa :) bro");
	}

	private static String enviarOperacion(int opcion, int numero1, int numero2) {
		Socket socketAlServidor = new Socket();
		String operacion = "";
		
		if(opcion == 1) {
			operacion = "A";
		}else if(opcion == 2) {
			operacion = "B";
		}else if(opcion == 3) {
			operacion = "C";
		}else if(opcion == 4){
			operacion = "D";
		}
		
		String cadenaAlServidor = operacion + "-" + numero1 + "-" + numero2;
		
		try {
			socketAlServidor.connect(direccionServidor);
			
			PrintStream ps = new PrintStream(socketAlServidor.getOutputStream());
			ps.println(cadenaAlServidor);
			
			InputStreamReader isr = new InputStreamReader(socketAlServidor.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			String cadenaRespuesta = br.readLine();//resultado:7 - ERROR:El error
			
			socketAlServidor.close();
			br.close();
			isr.close();
			
			return cadenaRespuesta;
			
		} catch (IOException e) {
			return "Error de conexion";
		}
		
	}

	private static int menu() {
		System.out.println("Que operacion quiere realizar:");
		System.out.println("1 - Sumar");
		System.out.println("2 - Restar");
		System.out.println("3 - Multiplicar");
		System.out.println("4 - Dividir");
		System.out.println("0 - Salir");
		int opcion = sc.nextInt();
		return opcion;
	}
}
