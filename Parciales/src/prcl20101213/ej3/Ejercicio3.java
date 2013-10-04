package prcl20101213.ej3;

public class Ejercicio3 {

	public static int sumaPares(int[] v, Integer izq, Integer der) {
		if (izq == der) {
			int r = v[der];
			if (r % 2 == 0)
				return r;
			else 
				return 0;
		} else {
			int salida = 0;
			if (v[izq] % 2 == 0) 
				salida = salida + v[izq];
			return salida + sumaPares(v, izq+1, der);
		}
	}
}
