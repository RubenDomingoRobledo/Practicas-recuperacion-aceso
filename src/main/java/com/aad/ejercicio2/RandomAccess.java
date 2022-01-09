package com.aad.ejercicio2;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

public class RandomAccess{
    public static void main(String[] args) {
    	
    	RandomAccessFile fichero = null;
    	int n_enteros = 0;
    	int n = 0;
    	int i = 0;
        try {
        	fichero = new RandomAccessFile("ficheros/enteros.dat", "rw");    
        	
            // Muestre el número de enteros contiene el fichero, Ejemplo: el fichero tiene x enteros.
        	fichero.seek(0);
        	while (fichero.readInt() != 0) {
        		n_enteros++;
                System.out.println("El fichero tiene " + n_enteros + " enteros");
            }
        	
            // Imprima los valores de los enteros del fichero
        	fichero.seek(0);
        	while (fichero.readInt() != 0) {
                n = fichero.readInt();
                System.out.format("[%2d] %s",i++,n);
                System.out.format("\n");
            }
        	// Modifique el valor 20 por 99
        	
            // Imprima los valores de los enteros del fichero

            // Realice el tratamiento de excepciones correspondientes
           
        }
            
        catch (FileNotFoundException e) {
        	System.out.println("Fichero no encontrado");
        } 
        catch (EOFException e) {
            System.out.println("Fin de fichero");
        } 
        catch (IOException e) {
            System.out.println(e.getMessage());
        } 
    }
}