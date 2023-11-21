package py.com.ucsa.utilites;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Archivo {

	public static void escribir(String p_file, String p_texto) {

		try {
			FileWriter output = new FileWriter("C:\\dcsrcjava\\io-lab\\" + p_file);
			BufferedWriter bufOutput = new BufferedWriter(output);

			// write the line out to the output file
			bufOutput.write(p_texto, 0, p_texto.length());

			bufOutput.newLine();

			bufOutput.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void leer(String p_file, String p_texto) {

		try {
			FileWriter output = new FileWriter(p_file);
			BufferedWriter bufOutput = new BufferedWriter(output);

			// write the line out to the output file
			bufOutput.write(p_texto, 0, p_texto.length());

			bufOutput.newLine();

			bufOutput.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static ArrayList<String> leerArchivoAList(String p_archivo) {

		ArrayList<String> listRetorno = new ArrayList<String>();
		try {
			FileReader reader = new FileReader(p_archivo);
			BufferedReader bufReader = new BufferedReader(reader);
			String line = null;
			line = bufReader.readLine();
			
			while (line != null) {
				//System.out.println(line);
				listRetorno.add(line);
				line = bufReader.readLine();
				
			}

			// while((line = bufReader.readLine()) != null)
			// System.out.println(line);
			bufReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("No se encontró el archivo");
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("Error de INPUT/OUTPUT " + e.getMessage());
		}

		return listRetorno;
	}

}
