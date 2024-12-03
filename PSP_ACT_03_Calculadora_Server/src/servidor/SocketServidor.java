package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServidor {
	
	public static final int PUERTO = 20124;
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("      APLICACIÓN DE SERVIDOR      ");
		System.out.println("----------------------------------");

		InputStreamReader entrada = null;
		PrintStream salida = null;

		Socket socketAlCliente = null;
		
		InetSocketAddress direccion = new InetSocketAddress(PUERTO);

		try (ServerSocket serverSocket = new ServerSocket()){			
			serverSocket.bind(direccion);

			while(true){		
				
				System.out.println("SERVIDOR: Esperando peticion por el puerto " + PUERTO);
				socketAlCliente = serverSocket.accept();
				
				System.out.println("SERVIDOR: peticion numero recibida");
				
				entrada = new InputStreamReader(socketAlCliente.getInputStream());
				BufferedReader bf = new BufferedReader(entrada);
								
				//CODIGO_OPERACION-OPERANDO1-OPERANDO2
				//CODIGO_OPERACION: A-SUMA, B-RESTA, C-MULTIPLICACION, D-DIVISION
				String stringRecibido = bf.readLine();//A-3-4
				
				System.out.println("SERVIDOR: Me ha llegado del cliente: " + stringRecibido);

				String[] operadores = stringRecibido.split("-");
				String codigoOperacion = operadores[0];//A
				int iNumero1 = Integer.parseInt(operadores[1]);//3
				int iNumero2 = Integer.parseInt(operadores[2]);//4
				
				int resultado = 0;
				String cadenaEnvio = "resultado:";
				//Es en este momento cuando calculamos la suma
				switch (codigoOperacion) {
				case "A":
					resultado = iNumero1 + iNumero2;//7
					cadenaEnvio += resultado;
					break;
				case "B":
					resultado = iNumero1 - iNumero2;//7
					cadenaEnvio += resultado;
					break;
				case "C":
					resultado = iNumero1 * iNumero2;//7
					cadenaEnvio += resultado;
					break;
				case "D":
					try {
						resultado = iNumero1 / iNumero2;
						cadenaEnvio += resultado;
					} catch (Exception e) {
						cadenaEnvio = "ERROR:" + e.getMessage();
						e.printStackTrace();
					}
					break;
				default:
					break;
				}				
				
				System.out.println("SERVIDOR: Cadena envio: " + cadenaEnvio);

				salida = new PrintStream(socketAlCliente.getOutputStream());
				salida.println(cadenaEnvio);	
				
				//Si hemos llegado hasta aqui, cerramos las conexiones
				socketAlCliente.close();
			}
		} catch (IOException e) {
			System.err.println("SERVIDOR: Error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("SERVIDOR: Error -> " + e);
			e.printStackTrace();
		}
	}//FIN DEL PROGRAMA
}
