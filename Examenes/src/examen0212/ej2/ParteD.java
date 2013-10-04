package examen0212.ej2;

public class ParteD {

	private static int[] notas = { 10, 11, 7, 3, 4 };
	private int[] alumnos = { 1, 4, 5, 2, 3 };

	private void ordenar() {
		System.out.println(ParteB.f(notas, 3, 4));
	}

	public static void main(String[] args0) {
		ParteD pd = new ParteD();
		int x[] = pd.OrdenaMerge(notas);
		for (int i = 0; i < x.length; i++) {
			System.out.print(x[i]);
		}
	}

	public int[] OrdenaMerge(int[] L) {
		int n = L.length;

		if (n > 1) {
			int m = (int) (Math.ceil(n / 2.0));
			int[] L1 = new int[m];
			int[] L2 = new int[n - m];

			for (int i = 0; i < m; i++) {
				L1[i] = L[i];
			}
			for (int i = m; i < n; i++) {
				L2[i - m] = L[i];
			}
			L = merge(OrdenaMerge(L1), OrdenaMerge(L2));
		}
		return L;
	}

	public int[] eliminar(int[] l) {
		int[] L = new int[l.length - 1];
		for (int i = 1; i < l.length; i++) {
			L[i - 1] = l[i];
		}
		return L;
	}

	public int[] merge(int[] L1, int[] L2) {
		int[] L = new int[L1.length + L2.length];
		int i = 0;
		while ((L1.length != 0) && (L2.length != 0)) {
			if (L1[0] < L2[0]) {
				L[i++] = L1[0];
				L1 = eliminar(L1);
				if (L1.length == 0) {
					while (L2.length != 0) {
						L[i++] = L2[0];
						L2 = eliminar(L2);
					}
				}
			} else {
				L[i++] = L2[0];
				L2 = eliminar(L2);
				if (L2.length == 0) {
					while (L1.length != 0) {
						L[i++] = L1[0];
						L1 = eliminar(L1);
					}
				}
			}
		}
		return L;
	}
}
