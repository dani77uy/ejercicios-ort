package examen0713.ej4;

public class Ejercicio4 {

	public static int algoritmo2(int[][] m, int[] v){
		int x = m.length;
		for (int i=0;i<x;i++){
			int col[] = obtenerColumna(m,i);
			if (sonIguales(col, v))
				return i+1;
		}
		return -1;
	}

	private static int[] obtenerColumna(int[][] m, int i) {
		int salida[] = new int[m.length];
		for(int x=0;x<m.length;x++){
			salida[x] = m[x][i];
		}
		return salida;
	}
	
	private static boolean sonIguales(int[] m1, int[] m2){
		if (m1.length!=m2.length)
			return false;
		for (int i=0;i<m1.length;i++){
			if (m1[i]!=m2[i])
				return false;
		}
		return true;
	}
}
