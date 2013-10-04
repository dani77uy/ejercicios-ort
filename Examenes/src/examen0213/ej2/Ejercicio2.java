package examen0213.ej2;

public class Ejercicio2 {

	public static void selectionSort(int v[]) {
		int l = v.length;
		int t1, t2;
		boolean ordenado = false;
		while (!ordenado)
			for (int i = 0; i < l - 1; i++) {
				t1 = v[i];
				t2 = v[i + 1];
				if (t1 > t2) {
					v[i] = t2;
					v[i + 1] = t1;
					break;
				}
				if (i == l - 2) ordenado = true;
			}

	}

	public static void insertionSort(int v[]) {
		int t, j;
		for (int i = 0; i < v.length; i++) {
			t = v[i];
			j = i + 1;
			// while ()
		}
	}

	public static void insertarOrdenado(int numero, int[] v) {
		int[] resultado = new int[v.length + 1];
		for (int i = 0; i < v.length; i++) {
			if (v[i] >= numero) {

			}
		}
	}

	/**
	 * 
	 * No funca
	 * 
	 */
	public static void bubbleSort(int[] v) {
		//FIXME
		int l = v.length - 1;
		int tmp;
		for (int i = 1; i <= l; i++) {
			for (int j = 0; j < l - 2; j++) {
				if (v[j] > v[j + 1]) {
					tmp = v[j];
					v[j] = v[j + 1];
					v[j + 1] = tmp;
				}
			}
		}
	}

	public static void bubbleSort2(int[] v) {
		int i = 1;
		int n = v.length;
		int tmp;
		boolean ordenado = false;
		while (i < n && !ordenado) {
			i = i + 1;
			ordenado = true;
			for (int j = 0; j <= n - i; j++) {
				if (v[j] > v[j + 1]) {
					ordenado = false;
					tmp = v[j];
					v[j] = v[j + 1];
					v[j + 1] = tmp;
				}
			}
		}
	}
}
