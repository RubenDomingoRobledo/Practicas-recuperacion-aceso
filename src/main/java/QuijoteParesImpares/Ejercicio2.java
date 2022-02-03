package QuijoteParesImpares;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio2 {

	public static void main(String[] args) {

		try {
			BufferedReader lectorPar = new BufferedReader(new FileReader("ficheros\\FragmentoQuijotePar.txt"));
			BufferedReader lectorImpar = new BufferedReader(new FileReader("ficheros\\FragmentoQuijoteImpar.txt"));

			try {
				String lineaPar = lectorPar.readLine();
				String lineaImpar = lectorImpar.readLine();

				BufferedWriter escribir = new BufferedWriter(new FileWriter("C:\\Users\\rubir\\Downloads\\quijote2.txt"));
				while (lineaPar != null || lineaImpar != null) {
					if (lineaImpar != null) {
						escribir.write(lineaImpar);
						escribir.newLine();
					}
					lineaImpar = lectorImpar.readLine();
					if (lineaPar != null) {
						escribir.write(lineaPar);
						escribir.newLine();
					}
					lineaPar = lectorPar.readLine();
				}
				escribir.flush();
				escribir.close();
				lectorPar.close();
				lectorImpar.close();
				System.out.println("Fichero creado correctamente.");

			} catch (FileNotFoundException e1) {
				System.err.println("Error: No se encuentra el fichero");
			} catch (IOException e2) {
				System.err.println("Error leyendo/escribiendo fichero");
			}

		} catch (FileNotFoundException e1) {
			System.err.println("Error: No se encuentra el fichero");
		}
	}
}
