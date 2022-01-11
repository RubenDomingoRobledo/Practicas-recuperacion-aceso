package com.aad.ejercicio2;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccess{
	
	static RandomAccessFile fichero = null;
	static long n_enteros = 0;
	static int n = 0;
	static int i = 0;
	
    public static void main(String[] args) {
        try {
        	fichero = new RandomAccessFile("ficheros/enteros.dat", "rw");    
        	
        	// Muestre el número de enteros contiene el fichero, Ejemplo: el fichero tiene x enteros.
        	n_enteros = fichero.length()/4;
        	System.out.println("El fichero tiene "+ n_enteros + " enteros.");

        	// Imprima los valores de los enteros del fichero
        	mostrarFichero();
        	
        	// Modifique el valor 20 por 99
        	fichero.seek(1*4);
        	fichero.writeInt(99);
        	
            // Imprima los valores de los enteros del fichero
        	mostrarFichero();
        }
        
        // Realice el tratamiento de excepciones correspondientes   
        catch (FileNotFoundException e) {
        	System.out.println("Fichero no encontrado");
        } 
        catch (IOException ex) {
            System.out.println("Error de entrada o de salida");
        } finally {
            try {
                if (fichero != null) {
                    fichero.close();
                }
            } catch (IOException e) {
                System.out.println("Error de entrada o de salida");
            }
        }
    }
    
    public static void mostrarFichero() {
        int n;
        try {
        	int i = 0;
            fichero.seek(i);
            while (true) {
                n = fichero.readInt();                                           
                System.out.format("[%2d] %s",i++,n);
                System.out.println("");
            }
        } 
        catch (EOFException e) {
            System.out.println("Fin de fichero");
        } 
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}