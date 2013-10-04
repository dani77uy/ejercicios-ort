package examen0213.ej3;


public class Lista {

	protected class Nodo {
		int elem;
		Nodo sig;

		@Override
		public String toString() {
			return String.valueOf(elem);
		}
	}

	protected Nodo raiz;

	public void agregar(int dato) {
		if (raiz == null) {
			raiz = new Nodo();
			raiz.elem = dato;
		} else {
			Nodo nodo = this.raiz;
			while (nodo.sig != null) {
				nodo = nodo.sig;
			}
			nodo.sig = new Nodo();
			nodo.sig.elem = dato;
		}
	}

	public String toString() {
		Nodo node = this.raiz;
		if (node == null) return "";
		StringBuilder sb = new StringBuilder();
		while (node != null) {
			sb.append(node.elem);
			if (node.sig != null) sb.append(',');
			node = node.sig;
		}
		return sb.toString();
	}

}
