package examen0211.ej1;

public class ABB {

	private Nodo raiz;

	private class Nodo {
		private int dato;
		private Nodo izquierda;
		private Nodo derecha;
		private Nodo(int dato) {
			this.dato = dato;
		}
	}

	public Lista listaCamino(int k){
		Lista lista = new Lista();
		if (this.raiz!=null)
			if (this.pertence(k)){
               agregarALista(this.raiz,k,lista);
			}
		return lista;
	}
	
	private void agregarALista(Nodo nodo, int dato, Lista lista){
		if (nodo != null){
			lista.agregar(nodo.dato);
			if (dato>nodo.dato)
				agregarALista(nodo.derecha,dato,lista);
			if (dato<nodo.dato)
				agregarALista(nodo.izquierda,dato,lista);
		}
	}
	
	private boolean pertence(int dato){
		return obtener(dato) != null;
	}
	
	private Nodo obtener(int dato){
		return obtener(this.raiz,dato);
	}
	
	private Nodo obtener(Nodo nodo, int dato){
		if (nodo == null) return null;
		int cmp = dato - nodo.dato;
		if (cmp < 0) return obtener(nodo.izquierda,dato);
		else if (cmp > 0) return obtener(nodo.derecha,dato);
		else return nodo;
	}
	
	public void insertar(int dato) {
		this.raiz = insertar(this.raiz, dato);
	}

	private Nodo insertar(Nodo nodo, int dato) {
		if (nodo != null) {
			int cmp = dato - nodo.dato;
			if (cmp < 0) {
				nodo.izquierda = insertar(nodo.izquierda, dato);
			} else if (cmp > 0) {
				nodo.derecha = insertar(nodo.derecha, dato);
			} else {
				nodo.dato = dato;
			}
		} else {
			return new Nodo(dato);
		}
		return nodo;
	}

	
}
