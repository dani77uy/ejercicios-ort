package examen0212.ej2;

public class ParteB {

	public static int f(int[] a, int b, int c) {
		if (c - b >= 0)
			return g(a, b, c) / (c - b + 1);
		return 0;
	}

	public static int g(int[] a, int b, int c) {
		if (c - b == 0)
			return a[(b + c) / 2] + g(a, b + 1, (b + c) / 2 - 1) + g(a, (b + c) / 2 + 1, c);
		if (c - b >= 0)
			return a[(b + c) / 2] + g(a, b + 1, (b + c) / 2 - 1) + a[b]	+ g(a, (b + c) / 2 + 1, c);
		return 0;
	}

	public static void main(String[] args) {
		//int a[] = { 104, 98, 88, 53, 23, 20, 18, -1 };
		int a[] = {10,20,30};
		System.out.println(f(a,1,2));
	}
}
