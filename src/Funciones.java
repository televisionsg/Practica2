public class Funciones {
    
    
    public Funciones() {}
    
     //Metodo que genera un numero aleatorio
    public static int generarAleatorio(){
        if (Math.random() > 0.5) {
            return 1;
        }
        else{
        return 0;
        }
        
        
    }

    //Metodo que genera la matriz original
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
    
    // Metodo para generar la siguiente matriz segun las reglas de la vida
	static int [][] estadoSiguiente(int tablero[][]) 
                
                
	{   int M = tablero.length;
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
                                // i = -1  (j (-1.0..1)
                                // i = 0 (j (-1.0..1)
                                // i = 1  (j (-1.0..1)
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

