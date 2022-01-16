package com.aad.ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//Ejemplo de uso de las clases:

public class EjemploFlujoCaracteres1 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("ficheros/ejemplo.txt"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("ficheros/ejemplo.txt"));
			
			//Escribimos en el fichero
            bw.write("Esto es una prueba usando BufferedWriter");
            bw.newLine();
            bw.write("Seguimos usando BufferedWriter");
            
            //Guardamos los cambios del fichero
            bw.flush();
            
            //Leemos el fichero y lo mostramos por pantalla
            String linea=br.readLine();
            while(linea!=null){
                System.out.println(linea);
                linea=br.readLine();
            }
            
            br.close();
            bw.close();
		} 
		catch (IOException e) {
			System.out.println("Error de entrada o de salida");
		}
	}
}
