package parte_a;

import java.util.Scanner;

public class MainParteA {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 3;i++) {
			System.out.println("Introduzca el numero " + i +" para saber si es primo");
			long n = sc.nextLong();
			new HilosPrimos(n).start();
		}

	}

}
