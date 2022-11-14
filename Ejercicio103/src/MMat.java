// Irma
// 9 noviembre 2022
// clase para generar varios métodos estáticos

public class MMat {
	
	// a) sumar los elementos de una columna
	public static double  sumaColumna(double[][] mat, int ren, int col) {
		double suma;
		
		suma = 0;
		for (int i=0; i<ren; i++) {
			suma += mat[i][col];
		}
		return suma;
	}
	
	//b) sumar los elementos de un renglón
	public static double sumaRenglon(double[][] mat, int ren, int col) {
		double suma;
		
		suma = 0;
		for (int i=0; i<col; i++)
			suma += mat[ren][i];
		return suma;
	}
	
	// c) sumar toda la matriz
	public static double sumaTotal(double mat[][], int ren, int col) {
		double suma;
		
		suma = 0;
		for (int i=0; i<ren; i++) 
			for (int j= 0; j<col; j++)
				suma += mat[i][j];
		return suma;
	}
	
	// d) sumar la diagonal principal
	public static double sumaDiagonal(double mat[][]) {
		double suma;
		
		suma = 0;
		for (int i=0; i<mat.length; i++)
			suma += mat[i][i];
		return suma;
	}
	
	// e) sumar la diagonal secundaria
	public static double sumaDiagSecundaria(double mat[][]) {
		double suma;
		int rengs;
		
		suma = 0;
		rengs = mat.length;
		for (int i= 0; i<rengs; i++) {
			suma += mat[i][rengs-(i+1)];
		}
		return suma;
	}
	
	// f) mostrar la matriz en forma rectangular usando una cadena
	public static String generaCadena(double[][] mat) {
		StringBuilder texto;
		
		texto = new StringBuilder();
		for (int i=0; i<mat.length; i++) {
			for (int j=0; j<mat[0].length; j++)
				texto.append(mat[i][j] + "\t");
			texto.append("\n");		
		}
		return texto.toString();
	}
	
	// g) posición del valor mas grande de una columna
	public static int posMayorCol(double[][] mat, int col) {
		int posicion;
		double max;
		
		posicion = 0;
		max = mat[0][col];
		for (int i=1; i<mat.length; i++) {
			if (mat[i][col] > max) {
				max = mat[i][col];
				posicion = i;
			}
		}
		return posicion;
	}
	
	
	// g-1 posicion del valor más pequeño de una columna
	public static int posMenorCol(double[][] mat, int col) {
		int posicion;
		double min;
		
		posicion = 0;
		min = mat[0][col];
		for (int i=1; i<mat.length; i++) {
			if (mat[i][col] < min) {
				min = mat[i][col];
				posicion = i;
			}
		}
		return posicion;
	}
	
	// BERNARDO MARCO BORGARO
	// ITAM
	// h) posicion del valor más grande de un renglón
	public static int posMayorRen(double[][] matriz, int ren) {
		int posicion;
		double max;
		max= matriz[ren][0];
		posicion=0;
		
		for (int i=1; i<matriz[ren].length; i++) {
			if (matriz[ren][i]>max) {
				max= matriz[ren][i];
				posicion=i;
			}
		}
		
		return posicion;
	}
	// h-1 posición del más pequeño de un renglón
	public static int posMenorRen(double[][] matriz, int ren) {
		int posicion;
		double min;
		min= matriz[ren][0];
		posicion=0;
		
		for (int i=1; i<matriz[ren].length; i++) {
			if (matriz[ren][i]<min) {
				min= matriz[ren][i];
				posicion=i;
			}
		}
		
		return posicion;
	}
}
