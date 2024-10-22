package parte_b;

import java.util.Date;

public class HiloMostrarNumeros extends Thread{

	private long numero;
	
	public HiloMostrarNumeros(long numero) {
		this.numero = numero;
	}
	
	@Override
	public void run() {
		Date date = new Date();
	
		for(long i = numero;i <= 1_000_000_000;i++) {
			System.out.println("Numero: " + i);
		}
		
		Date date2 = new Date();
		long tiempoTotalProcesamiento = date2.getTime() - date.getTime(); 
		System.out.println("Tiempo total de procesamiento: " + tiempoTotalProcesamiento);
	}

}
