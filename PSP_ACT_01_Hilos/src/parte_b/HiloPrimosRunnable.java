package parte_b;

import java.util.Date;

public class HiloPrimosRunnable implements Runnable{

private long numeroPrimo;
	
	public HiloPrimosRunnable(long numeroPrimo) {
		this.numeroPrimo = numeroPrimo;
	}
	
	@Override
	public void run() {
		Date date = new Date();//Toma la hora del sistema con miliegundos, 
							//NOS DICE EL NUMERO DE MILISEGUNDOS QUE HAN PASADO 01/01/1970
		boolean esPrimo = true;
		for(long i = 2;i < numeroPrimo/2;i++) {
			if(numeroPrimo % i == 0) {
				esPrimo = false;
				break;
			}
		}
		
		Date date2 = new Date();
		long tiempoTotalProcesamiento = date2.getTime() - date.getTime(); 
		System.out.println("Hilo: " + Thread.currentThread().getName() + 
				" -> El número " + numeroPrimo + "es primo?" + esPrimo +
				". Tiempo total de procesamiento: " + tiempoTotalProcesamiento);
	}

}
