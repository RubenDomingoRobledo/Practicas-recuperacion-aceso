package Directorios;

import java.io.File;

public class Ejercicio1 {
	public static void main(String[] args) {
		try {
			String ruta = System.getProperty("users.dir");
			File fichero = new File(ruta);
			int i = 0;
			for(File f: fichero.listFiles()) {
				System.out.printf("[%2d] %s", i++, f.getName());
				System.out.println();
				if(f.isDirectory()) {
					for(File e : f.listFiles()) {
						System.out.println("-" + e.getName());
					}
				}
			}
		}
		catch(NullPointerException e) {
			System.out.println("Path incorrecto " + e.getMessage());
		}
	}
}
