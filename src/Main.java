
/**
 * Copyright [2021] [Sebastian Gines]
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing,
software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
implied.
See the License for the specific language governing permissions
and
limitations under the License.
 */

 

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.concurrent.TimeUnit;

/**
 * Clase principal para comenzar el juego de la vida.
 * 
 * @author Sebastian Gines
 * @version segunda práctica
 */

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
    
    /**
     *metodo que guarda la matriz en un fichero
     * 
     * @param  tablero   Tablero que seria siendo la matriz final
     */
    
     
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
    
    

	
} 

