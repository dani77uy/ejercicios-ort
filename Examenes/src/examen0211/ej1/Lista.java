package examen0211.ej1;

public class Lista {

	private Nodo inicio;

	private class Nodo {
		private int dato;
		private Nodo siguiente;

		public String toString() {
			return String.valueOf(dato);
		}
	}

	public void agregar(int dato) {
		if (inicio == null) {
			inicio = new Nodo();
			inicio.dato = dato;
		} else {
			Nodo nodo = this.inicio;
			while (nodo.siguiente != null) {
				nodo = nodo.siguiente;
			}
			nodo.siguiente = new Nodo();
			nodo.siguiente.dato = dato;
		}
	}

	public String toString() {
		Nodo node = this.inicio;
		if (node == null)
			return "";
		StringBuilder sb = new StringBuilder();
		while (node != null) {
			sb.append(node.dato);
			if (node.siguiente != null)
				sb.append(',');
			node = node.siguiente;
		}
		return sb.toString();
	}

	public static boolean incluida(Lista l1, Lista l2) {
		if (l2.inicio == null && l1.inicio != null)
			return true;
		if (l1.esConsistente() && l2.esConsistente()) {
			return verificarInclusion(l1.inicio, l2.inicio);
		} else
			return false;
	}

	private static boolean verificarInclusion(Nodo nodo1, Nodo nodo2) {
		if (nodo2 == null)
			return true;
		if (nodo1 == null)
			return false;
		if (nodo2.dato != nodo1.dato) {
			return verificarInclusion(nodo1.siguiente, nodo2);
		} else {
			return verificarInclusion(nodo1.siguiente, nodo2.siguiente);
		}
	}

	private boolean esConsistente() {
		return esConsistente(this.inicio);
	}

	private boolean esConsistente(Nodo nodo) {
		if (nodo == null || nodo.siguiente == null)
			return true;
		else {
			if (nodo.siguiente.dato > nodo.dato)
				return esConsistente(nodo.siguiente);
			else
				return false;
		}
	}

	public void setDatos(int[] datos) {
		if (this.inicio != null)
			this.inicio = null;
		for (int d : datos) {
			this.agregar(d);
		}
	}

}
