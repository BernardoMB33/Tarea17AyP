// Bernardo Marco
// ITAM


import java.util.*;


public class Compania {
	private static int folio = 0;
	private int claveCia;
	private String nombre;
	private String direccion;
	private String ciudad;
	private String director;
	private double[] ventas;
	private double [][] ventasTodo;
	private int totalVentas;
	private final int MESES = 12;
	private final int DEPTOS =4;
	private int[] ventasMes;
	private int[] ventasDepto;
	
	public Compania() {
		claveCia = folio;
		folio++;
		ventas = new double[MESES];
		ventasTodo= new double [MESES][DEPTOS]; //Matriz de 12x4 (Significa 12 Renglones x 4 Columnas)
		totalVentas = 0;
		ventasMes= new int[MESES];
		ventasDepto= new int[DEPTOS];
		
		//{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		//= {0, 0, 0, 0}
		
	}
	
	public Compania(String n, String d, String c, String director) {
		this();
		nombre = n;
		direccion = d;
		ciudad = c;
		this.director = director;
		
		claveCia = folio;
		folio++;
		ventas = new double[MESES];
		ventasTodo= new double [MESES][DEPTOS]; //Matriz de 12x4 (Significa 12 Renglones x 4 Columnas)
		totalVentas = 0;
		ventasMes= new int[MESES];
		ventasDepto= new int[DEPTOS];
	}

	public int getClaveCia() {
		return claveCia;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public String getDirector() {
		return director;
	}

	public int getTotalVentas() {
		return totalVentas;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public void setTotalVentas(int totalVentas) {
		this.totalVentas = totalVentas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(claveCia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compania other = (Compania) obj;
		return claveCia == other.claveCia;
	}
	
	public int compareTo(Compania otra) {
		int respuesta;
		
		if (claveCia == otra.claveCia)
			respuesta = 0;
		else
			if (claveCia > otra.claveCia)
				respuesta = 5;
			else
				respuesta = -10;
		return respuesta;
		//return claveCia.compareTo(otra.claveCia);
	}



	
	public double getUnaVenta(int mes, int depto) {
		double venta;
		
		venta = 0.0;
		if ((mes > 0 && mes <= MESES)&&(depto>0 && depto <= DEPTOS)){
			venta = ventasTodo[mes-1][depto-1];
		}
		return venta;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public  boolean altaVenta(double monto, int mes, int depto) {
		
		
		if ((mes >= 1 && mes <= MESES)&&(depto>=1 && depto<= DEPTOS)) {
			ventasTodo[mes-1][depto-1] = monto;
			ventasMes[mes-1]++;
			ventasDepto[depto-1]++;
						
		}
		return ((mes >= 1 && mes <= MESES)&&(depto>=1 && depto<= DEPTOS));
	}
	
	public double ventasTotales() {
		double suma;
		
		suma = MMat.sumaTotal(ventasTodo, MESES, DEPTOS);
		return suma;
		
	}
	
	// ej a)
	public int mesConMasVentasInt(int depto) {
		int mes=0;
		double mayor=0;
		for (int i=0; i<MESES; i++)
			if (ventasTodo[i][depto-1]>mayor) {
				mayor= ventasTodo[i][depto-1];
				mes=i;
			}
		
		return mes+1;
	}
	
	
	//
	
	// ej b)
	public double promedioVtasMes(int mes) {
		double promedio =0;
		if ((mes>0 && mes<= MESES)&&(ventasMes[mes-1]>0))  {
			promedio=(MMat.sumaRenglon(ventasTodo, mes-1, DEPTOS))/(ventasMes[mes-1]*1.0);
		}
		return promedio;
	}
	
	
	// ej c)
	public double promedioVtasDepto(int depto) {
		double promedio=0;
		
		if ((depto>0 && depto<= DEPTOS)&&(ventasDepto[depto-1]>0)) {
			promedio=(MMat.sumaColumna(ventasTodo, MESES, depto-1)/(ventasDepto[depto-1]*1.0));
		}
		
		return promedio;
	}
	
	// ej c.1
	
	// Al parecer esto es lo que pide el ejercicio, tomando en cuenta los 12 meses del año, el de arriba solo toma en cuenta las vtas registradas
	public double promedioVtasDeptoAno(int depto) {
		
		return (MMat.sumaColumna(ventasTodo, MESES, depto-1)/(12.0));
	}

	public ArrayList<Integer> mesesSinVta(){
		ArrayList<Integer> mesis = new ArrayList<Integer>();
		for (int i=0; i<MESES; i++)
			if ((MMat.sumaRenglon(ventasTodo, i, DEPTOS))==0) { //Considerando que en ningún mes habría ventas negativas
				mesis.add(i+1);
			}
		return mesis;
	}
	
	
	
	
	
	
	
	

}
