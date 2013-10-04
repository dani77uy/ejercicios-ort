package examen0212.ej2;

public class ParteB {

	public static int f(int[] a, int b, int c) {
		if (c - b >= 0) return g(a, b, c) / (c - b + 1);
		return 0;
	}

	public static int g(int[] a, int b, int c) {
		if (c - b == 0) return a[(b + c) / 2] + g(a, b + 1, (b + c) / 2 - 1) + g(a, (b + c) / 2 + 1, c);
		if (c - b >= 0) return a[(b + c) / 2] + g(a, b + 1, (b + c) / 2 - 1) + a[b] + g(a, (b + c) / 2 + 1, c);
		return 0;
	}

	public static void main(String[] args) {
		int a[] = { 104, 98, 88, 53, 23, 20, 18, -1 };
		int b[] = { 10, 20, 305 };
		int c[] = { 20, 33, 44, 55, 66 };
		System.out.println(f(a, 1, 1));
		System.out.println(f(b, 1, 2));
		System.out.println(f(c, 3, 4));
		int oc[] = { 8, -14, 3, 28, 2, 2, 21 };
		System.out.println(cantidadOcurrencias(oc, 3, 6, 2));
	}

	/*************** EJERCICIO TEORICO ******************************************/

	public static int cantidadOcurrencias(int[] v, int a, int b, int c) {
		if (a == b) {
			if (v[a] == c) return 1;
			else return 0;
		} else {
			if (a < b) {
				while (a < b) {
					if (v[a] == c) return 1 + cantidadOcurrencias(v, a + 1, b, c);
					else return cantidadOcurrencias(v, a + 1, b, c);
				}
			} else {
				while (b < a) {
					if (v[b] == c) return 1 + cantidadOcurrencias(v, a, b + 1, c);
					else return cantidadOcurrencias(v, a, b + 1, c);
				}
			}
		}
		return 0;
	}
	
	public static int encontrarMultiplosDe7(int[] v, int a, int b){
		if (a == b) {
			if (v[a] % 7 == 0) return 1;
			else return 0;
		} else {
			if (a < b) {
				while (a < b) {
					if (v[a] % 7 == 0) return 1 + encontrarMultiplosDe7(v, a + 1, b);
					else return encontrarMultiplosDe7(v, a + 1, b);
				}
			} else {
				while (b < a) {
					if (v[b] % 7 == 0) return 1 + encontrarMultiplosDe7(v, a, b + 1);
					else return encontrarMultiplosDe7(v, a, b + 1);
				}
			}
		}
		return 0;
	}

}