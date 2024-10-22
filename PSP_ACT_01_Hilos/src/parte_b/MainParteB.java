package parte_b;

import java.util.Date;
import java.util.Scanner;

public class MainParteB {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca la cadena");
		String cadena = sc.nextLine();
		System.out.println("Introduzca el primer número");
		long n1 = sc.nextLong();
		System.out.println("Introduzca el segundo número");
		long n2 = sc.nextLong();
		
		//------------------
		HiloPrimosRunnable hpr = new HiloPrimosRunnable(n1);
		Thread t1 = new Thread(hpr);
		t1.start();
		
		HiloMostrarNumeros hmn = new HiloMostrarNumeros(n2);
		hmn.start();
		
		//Otra manera de hacerlo con clase anónimas
		Thread hmn2 = new Thread(new Runnable() {//Clase anonima
			
			@Override
			public void run() {
				Date date = new Date();
				
				for(long i = n2;i <= 1_000_000_000;i++) {
					System.out.println("Numero: " + i);
				}
				
				Date date2 = new Date();
				long tiempoTotalProcesamiento = date2.getTime() - date.getTime(); 
				System.out.println("Tiempo total de procesamiento: " + tiempoTotalProcesamiento);
				
			}
		});
		
		//hmn2.start();
		
		//Otra manera de hacerlo con lambdas
		Thread hmn3 = new Thread(() -> {
			Date date = new Date();
			
			for(long i = n2;i <= 1_000_000_000;i++) {
				System.out.println("Numero: " + i);
			}
			
			Date date2 = new Date();
			long tiempoTotalProcesamiento = date2.getTime() - date.getTime(); 
			System.out.println("Tiempo total de procesamiento: " + tiempoTotalProcesamiento);
		});
		//hmn3.start();
		
		Thread hiloMostrarCadena = new Thread(() -> {
			Date date = new Date();
			
			long resta = n1 - n2;
			
			for(long i = 0; i <= resta;i++) {
				System.out.println(Thread.currentThread().getName() + " Cadena: " + cadena);
			}
			
			Date date2 = new Date();
			long tiempoTotalProcesamiento = date2.getTime() - date.getTime(); 
			System.out.println("Tiempo total de procesamiento: " + tiempoTotalProcesamiento);
		});
		
		hiloMostrarCadena.start();
	}

}
