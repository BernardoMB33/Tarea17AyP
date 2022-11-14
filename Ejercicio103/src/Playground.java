// Bernardo MB
// ITAM

import java.io.File;
import java.util.*;


public class Playground {

	public static void main(String[] args) {
	
		Compania ofi= new Compania();
		int mes, registradosMes;
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		System.out.println("Registra el numero de meses de los que se registraran vtas: \t");
		registradosMes= sc.nextInt();
			
			for (int i=1; i<=registradosMes; i++) {
				System.out.println();
				for (int j=1; j<=4; j++ ) {
					System.out.printf("Ventas en el mes %d, del Depto %d: \t $", i, j);
					ofi.altaVenta(sc.nextDouble(), i, j);
				}
			}
			
			System.out.println();
			System.out.printf("Promedio Ventas Depto 1 (Registradas): \t $%.2f \n",ofi.promedioVtasDepto(1));
			System.out.printf("Promedio Ventas Depto 1(Año): \t $%.2f \n",ofi.promedioVtasDeptoAno(1));
			System.out.printf("Mes con mas Ventas del Depto 4: \t %d \n", ofi.mesConMasVentasInt(4));
			System.out.print("Meses sin Venta: \t");
			System.out.print(ofi.mesesSinVta());
			
		}
			
	

}
