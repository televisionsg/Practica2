

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.TimeUnit;

public class Main 
{ 
    private static int[][] tablero;
    
	public static void main(String[] args) 
	{ 
		int M = 32, N = 32;              
            
		// Inicializando la matriz 
                tablero = Funciones.generarMatriz(M,N);	
                
                //guarda la matriz en un fichero
                guardarMatriz(tablero);

		// Mostrando la matriz
		System.out.println("Tablero Original"); 
                Funciones.imprimir(tablero);
                //imprime un espacio en blanco
		System.out.println(); 
		
                //Generamos la siguiente Matriz
                int [][] siguienteMatriz = Funciones.estadoSiguiente(tablero);
                
               //Simulamos 5 matrices siguiente
                for(int i = 0; i <= 5; i++)
                {
                    try {
                        //definimos 1 segundo entre una matriz y la otra
                        TimeUnit.SECONDS.sleep(1);
                        //Generamos la siguiente generacion
                        
                        System.out.println("Simulacion "+(i+1));
                        Funciones.imprimir(siguienteMatriz);
                        siguienteMatriz = Funciones.estadoSiguiente(siguienteMatriz);
                        } 
                    catch (InterruptedException ex) {
                        System.out.println("Error: " + ex.getMessage());
                    }
                }
                
                guardarMatriz(siguienteMatriz);
                
	} 

    //metodo que guarda la matriz en un fichero
    private static void guardarMatriz(int[][] tablero) {
        
         try {
            
                FileOutputStream ostreamTablero = new FileOutputStream("datosMatriz.dat");
                ObjectOutputStream oosMatriz = new ObjectOutputStream(ostreamTablero);
                oosMatriz.writeObject(tablero);
                ostreamTablero.close();
           
            System.out.println("SE HA GUARDADO LA MATRIZ");
            
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    //Metodo que lee la matriz desde un fichero    
      public static void cargarMatriz() {
        try {
            //Lectura de los objetos de tipo persona
            FileInputStream fisMatriz = new FileInputStream("datosMatriz.dat");
            ObjectInputStream oisMatriz = new ObjectInputStream(fisMatriz);
            tablero = (int[][]) oisMatriz.readObject();
            fisMatriz.close();
            System.out.println("SE HA LEIDO LA MATRIZ DEL FICHERO");
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

	
} 

