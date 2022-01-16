package com.aad.ejercicio1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//Ejemplo de uso de las clases:

public class EjemploFlujoBytes1 {
	public static void main(String[] args) {
		try {
			FileInputStream fis= new FileInputStream("ficheros/ejemplo.ddr");
			FileOutputStream fos= new FileOutputStream("ficheros/ejemplo.ddr");
			
			String texto="Esto es una prueba para ficheros binarios";
			 
            //Copiamos el texto en un array de bytes
            byte codigos[]=texto.getBytes();
 
            fos.write(codigos);
            
            //Leemos el texto
            int valor=fis.read();
            while(valor!=-1){
                System.out.print((char)valor);
                valor=fis.read();
            }
            
            fis.close();
            fos.close();
		} 
		catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");;
		} 
		catch (IOException e) {
			System.out.println("Error de entrada o de salida");
		}
	}
}
