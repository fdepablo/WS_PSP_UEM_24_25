package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;

import entidad.Ordenador;

public class MainJson {
	public static void main(String[] args) throws IOException {
		File file = new File("ejerciciojson.json");
		Gson gson = new Gson();
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		Ordenador ordenador = gson.fromJson(br, Ordenador.class);
		System.out.println(ordenador);
		
		String json = gson.toJson(ordenador);
		FileWriter writer = new FileWriter("ordenador_serializado.json");
		writer.write(json);
		writer.close();
		System.out.println("Objeto serializado guardado");

	}
}
