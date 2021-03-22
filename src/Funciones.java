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

/**
 * Clase funciones que contiene los metodos necesarios para desarollar el juego de la vida.
 * 
 * @author Sebastian Gines
 * @version segunda práctica
 */

public class Funciones {
    
    /**
     *metodo que genera un numero aleatorio
     * 
     * @return un numero aleatorio que puede ser 1 o 0
     */
    
     
    public static int generarAleatorio(){
        if (Math.random() > 0.5) {
            return 1;
        }
        else{
        return 0;
        }
        
        
    }

    /**
     *Metodo que genera la matriz original
     * 
     * @param  M  numero de filas
     * @param  N  numero de columnas
     * @return  La matriz que se genera rellenada de numeros aleatorios
     */

    
    static int[][] generarMatriz(int M, int N) {
        
        int [][] matrizNueva = new int [M][N];
        
        //pondra en cero las celdas de la matriz que representan los bordes
        //genera el numero aleatorio solo para las celdas que se encuentran dentro de los bordes
        //for anidadado (para i = 1 sucede que j = (1,2,3,4,5,6,7,8))
        for (int i = 1; i < M-1; i++) 
		{ 
			for (int j = 1; j < N-1; j++) 
			{ 
				matrizNueva [i][j] = generarAleatorio();
			} 
		}
        return matrizNueva;
    }
    
    /**
     *Metodo para generar la siguiente matriz segun las reglas de la vida
     * 
     * @param  tablero  Representa la matriz anterior
     * 
     * @return  La matriz original despues de que se le apliquen las leyes de la vida
     */

    static int [][] estadoSiguiente(int tablero[][]) {
        
        int M = tablero.length;
            int N = tablero[0].length;
            
            //creacion de la nueva matriz coloca por defecto 0 en todas las celdas
		int[][] futuro = new int[M][N]; 

		// Recorriendo cada celda
                //Importante no comenzar en los indices que representan los extremos de la matriz
		for (int fila = 1; fila < M - 1; fila++) 
		{ 
			for (int columna = 1; columna < N - 1; columna++) 
			{ 
				// buscando la cantidad de celulas vecinas vivas 
                                // dado que las celulas vivas valen 1, las contamos
				int celulasVecinasVivas = 0; 
				for (int i = -1; i <= 1; i++) 
					for (int j = -1; j <= 1; j++) 
                                            //contamos las celulas vivas dado que valen 1 
						celulasVecinasVivas += tablero[fila + i][columna + j]; 

				// tenemos que descontar la propia celula en si, pues se agrego a la suma anterior 
                                
				celulasVecinasVivas -= tablero[fila][columna]; 

				// implementamos las reglas de la vida 

				// si la celula esta viva y solo tiene una celula viva alrededor
                                //LA CELULA MUERE
                                
				if ((tablero[fila][columna] == 1) && (celulasVecinasVivas < 2)) 
					futuro[fila][columna] = 0; 

				// la celula esta viva y tiene mas de 3 vecinas vivas
                                //LA CELULA MUERE
                                
				else if ((tablero[fila][columna] == 1) && (celulasVecinasVivas > 2)) 
					futuro[fila][columna] = 0; 

				// si la celula tiene 3 vecinas vivas y ella esta muerta
                                //LA CELULA VIVE
				else if ((tablero[fila][columna] == 0) && (celulasVecinasVivas == 3)) 
					futuro[fila][columna] = 1; 

				// permanece en el mismo estado que tiene antes 
				else
					futuro[fila][columna] = tablero[fila][columna]; 
			} 
		} 
                return futuro;
		
	} 

    /**
     *metodo que imprime el contenido de una matriz
     * 
     * @param  tablero  Representa la matriz que se va a mostrar en consola.
     */

    //metodo que imprime el contenido de una matriz
    //transformo 0 y 1 en (.) y (V)
    static void imprimir(int[][] tablero) {
        
        for (int i = 0; i < tablero.length; i++) 
		{ 
			for (int j = 0; j < tablero[i].length; j++) 
			{ 
				if (tablero[i][j] == 0) 
					System.out.print(" . "); 
				else
					System.out.print(" V "); 
			} 
			System.out.println(); 
		} 
    }
    
}

