package examen0213.ej3;

import examen0213.ej3.Lista.Nodo;

public class Ejercicio3 {

	public static int sumaEnteros(Lista lista, int valor) {
		return sumaEnteros(lista.raiz, valor, 0);
	}

	private static int sumaEnteros(Nodo nodo, int valor, Integer suma) {
		if (nodo != null) {
			if (nodo.elem > valor) 
				suma = suma + nodo.elem;
			return sumaEnteros(nodo.sig, valor, suma);
		}
		return suma;
	}
}
