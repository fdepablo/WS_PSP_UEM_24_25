package main;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class Main {
	
	public String frase = "";
	public String fraseEncriptada = "";
	public static KeyGenerator generador;
	public static SecretKey escitala;
	public static byte[] bytesFraseEncriptada;
	
	public static KeyPairGenerator generadorKey;
	public static KeyPair claves;
	public static PrivateKey clavePrivada;
	public static PublicKey clavePublica;

	private Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) throws NoSuchAlgorithmException {
		generador = KeyGenerator.getInstance("DES");
		escitala = generador.generateKey();
		
		generadorKey = KeyPairGenerator.getInstance("RSA");
		claves = generadorKey.generateKeyPair();
		clavePrivada = claves.getPrivate();
		clavePublica = claves.getPublic();
		
		Main m = new Main();
		m.menu();

	}
	
	
	public void menu() {
		
		System.out.println("CRIPTOGRAFÍA");
		System.out.println("[1] Encriptar frase");
		System.out.println("[2] Mostrar frase encriptada");
		System.out.println("[3] Desencriptar frase");
		System.out.println("[4] Encriptar frase confidencialidad");
		System.out.println("[5] Encriptar frase autenticidad");
		System.out.println("[6] Desencriptar frase confidencial");
		System.out.println("[7] Desencriptar frase autenticar");
		System.out.println("[0] Salir del programa");
		String opcion = scanner.nextLine();
		
		if(opcion.isBlank()) {
			System.out.println("Opción no valida.");
			menu();
		}
		
		switch(opcion) {
		case "1":
			try {
				encriptarFrase();
			} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException
					| BadPaddingException e) {
				System.out.println("Error inesperado.");
				System.out.println();
				menu();
			}
			break;
		case "2":
			try {
				mostrarFraseEncriptada();
			} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException
					| BadPaddingException e) {
				System.out.println("Error inesperado.");
				System.out.println();
				menu();
			}
			break;
		case "3":
			try {
				desencriptarFrase();
			} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException
					| BadPaddingException e) {
				System.out.println("Error inesperado.");
				System.out.println();
				menu();
			}
			break;
		case "4":
			try {
				encriptarConfidencial();
			} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException
					| BadPaddingException e) {
				System.out.println("Error inesperado.");
				System.out.println();
				menu();
			}
			break;
		case "5":
			try {
				encriptarAutenticidad();
			} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException
					| BadPaddingException e) {
				System.out.println("Error inesperado.");
				System.out.println();
				menu();
			}
			break;
		case "6":
			try {
				desencriptarConfidencial();
			} catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException | NoSuchAlgorithmException
					| NoSuchPaddingException e) {
				System.out.println("Error inesperado.");
				System.out.println();
				menu();
			}
			break;
		case "7":
			try {
				desencriptarAutenticar();
			} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException
					| BadPaddingException e) {
				System.out.println("Error inesperado.");
				System.out.println();
				menu();
			}
			break;
		case "0":
			System.out.println("Fin del programa.");
			break;
			
		}
		
	}
	
	private void encriptarConfidencial() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		Cipher cifrador = Cipher.getInstance("RSA");
		cifrador.init(Cipher.ENCRYPT_MODE, clavePublica);
		frase = pedirFrase();
		byte[] bytesMensajeOriginal = frase.getBytes();
		bytesFraseEncriptada = cifrador.doFinal(bytesMensajeOriginal);
		
		fraseEncriptada = new String(bytesFraseEncriptada);
		
		System.out.println("Se ha encriptado la frase: "  + fraseEncriptada);
		System.out.println();
		menu();
		
	}


	private void desencriptarConfidencial() throws IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
		Cipher descifrador = Cipher.getInstance("RSA");
		descifrador.init(Cipher.DECRYPT_MODE, clavePrivada);
		byte[] bytesMensajeDescifrado = descifrador.doFinal(bytesFraseEncriptada);
		String fraseDescifrada = new String(bytesMensajeDescifrado);
		
		System.out.println(fraseDescifrada);
		System.out.println();
		menu();
		
		
	}


	private void encriptarAutenticidad() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		Cipher cifrador =  Cipher.getInstance("RSA");
		cifrador.init(Cipher.ENCRYPT_MODE, clavePrivada);
		
		frase = pedirFrase();
		
		byte[] byteMensajeOriginal = frase.getBytes();
		
		bytesFraseEncriptada = cifrador.doFinal(byteMensajeOriginal);
		
		fraseEncriptada = new String(bytesFraseEncriptada);
		System.out.println("Se ha encriptado la frase: "  + fraseEncriptada);
		System.out.println();
		menu();
		
		
	}
	
	private void desencriptarAutenticar() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		Cipher descifrador = Cipher.getInstance("RSA");
		descifrador.init(Cipher.DECRYPT_MODE, clavePublica);
		
		byte[] mensajeDescifrado = descifrador.doFinal(bytesFraseEncriptada);
		String fraseDescifrada = new String(mensajeDescifrado);
		
		System.out.println(fraseDescifrada);
		System.out.println();
		menu();
		
		
		
	}


	private void desencriptarFrase() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		Cipher descifrador = Cipher.getInstance("DES");
		descifrador.init(Cipher.DECRYPT_MODE, escitala);
		
		byte[] bytesFraseDescifrado = descifrador.doFinal(bytesFraseEncriptada);
		String fraseDescifrada = new String(bytesFraseDescifrado);
		
		System.out.println(fraseDescifrada);
		System.out.println();
		menu();
		
	}


	private void mostrarFraseEncriptada() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		System.out.println(fraseEncriptada);
		System.out.println();
		menu();
	}


	private void encriptarFrase() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		frase = pedirFrase();
		
		Cipher cifrador = Cipher.getInstance("DES");
		cifrador.init(Cipher.ENCRYPT_MODE, escitala);
		
		byte[] bytesFraseOriginal = frase.getBytes();
		
		bytesFraseEncriptada = cifrador.doFinal(bytesFraseOriginal);
		
		fraseEncriptada = new String(bytesFraseEncriptada);
		
		System.out.println("Se ha encriptado la frase!");
		System.out.println();
		
		menu();
		
	}


	private String pedirFrase() throws NoSuchAlgorithmException {
		String fraseUsuario = "";

		boolean flag = true;
		do {
			
            System.out.println("Ingresa una frase:");
            fraseUsuario = scanner.nextLine();
            
            if(fraseUsuario.isBlank()) {
                System.out.println("La FRASE no puede estar en blanco o contener solo espacios.");
                System.out.println();
            } else {
                flag = false;
            }

        } while(flag);

		return fraseUsuario;
	}

}
