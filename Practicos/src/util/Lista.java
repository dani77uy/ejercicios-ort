package util;

/**
 * 
 * @author Vicky
 */
public class Lista implements ILista {

	/**
	 * Nodo inicial
	 */
	protected Nodo nodoInicial;

	public Lista() {
		nodoInicial = null;
	}

	@Override
	public void agregar(int n) {
		if (nodoInicial == null)
			insertarInicio(n);
		else {
			Nodo aux = this.nodoInicial;
			while (aux != null && aux.siguiente != null)
				aux = aux.siguiente;
			Nodo nuevo = new Nodo(n);
			aux.siguiente = nuevo;
		}

	}

	private void insertarInicio(int n) {
		Nodo nuevo = new Nodo(n);
		nuevo.siguiente = nodoInicial;
		nodoInicial = nuevo;

	}

	@Override
	public void eliminar(int n) {
		if (!esVacia()) {
			if (nodoInicial.dato == n)
				nodoInicial = nodoInicial.siguiente;
			else {
				Nodo aux = this.nodoInicial;
				while (aux.siguiente != null && aux.siguiente.dato != n)
					aux = aux.siguiente;
				if (aux.siguiente.dato == n) {
					aux.siguiente = aux.siguiente.siguiente;
				}

			}
		}
	}

	@Override
	public boolean esVacia() {
		return nodoInicial == null;
	}

	@Override
	public void vaciar() {
		nodoInicial = null;
	}

	@Override
	public boolean existe(int n) {
		Nodo aux = this.nodoInicial;
		while (aux != null && aux.dato != n)
			aux = aux.siguiente;
		if (aux == null)
			return false;
		else
			return true;
	}

	/**
	 * Retorna el valor del primer elemento de la lista
	 */
	@Override
	public int elementoInicial() {
		return nodoInicial.dato;
	}

	@Override
	public ILista clone() {
		Lista nueva = new Lista();
		Nodo aux = this.nodoInicial;
		while (aux != null) {
			nueva.agregar(aux.dato);
			aux = aux.siguiente;
		}
		return nueva;
	}

	public Nodo getAnterior(Nodo nodo) {
		Nodo aux = this.nodoInicial;
		if (!(this.esVacia() || aux.equals(nodo)))
			while (aux != null) {
				if (aux.siguiente.equals(nodo))
					return aux;
				aux = aux.siguiente;
			}
		return null;
	}

	@Override
	public void mostrar() {
		Nodo aux = this.nodoInicial;
		while (aux != null) {
			System.out.print(aux.dato + " ");
			aux = aux.siguiente;
		}
	}

	protected Nodo getUltimoNodo() {
		Nodo nodo = this.nodoInicial;
		while (nodo != null) {
			nodo = nodo.getSiguiente();
		}
		return nodo;
	}

	public Lista quitarInicio() {
		if (this.esVacia())
			return null;
		Lista l = (Lista) this.clone();
		l.nodoInicial = l.nodoInicial.getSiguiente();
		return l;
	}

	/************** Clase privada: Especificación del NODO ************/
	protected class Nodo {
		int dato;
		Nodo siguiente;

		public Nodo(int n) {
			dato = n;
			siguiente = null;
		}

		public int getDato() {
			return this.dato;
		}

		public Nodo getSiguiente() {
			return this.siguiente;
		}

		public void setDato(int dato) {
			this.dato = dato;
		}

		public void setSiguiente(Nodo siguiente) {
			this.siguiente = siguiente;
		}

		public boolean equals(Object o) {
			if (!(o instanceof Nodo))
				return false;
			Nodo n = (Nodo) o;
			return n.dato == this.dato
					&& n.siguiente.dato == this.siguiente.dato;
		}
	}

	public Lista agregarAlFinal(Lista p) {
		Nodo nodo = this.nodoInicial;
		if (nodo.siguiente == null) {
			nodo.siguiente = p.nodoInicial;
			return this;
		} else {
			this.quitarInicio();
			return this.agregarAlFinal(p);
		}
	}

	/**
	 * 
	 * @param l
	 * @param p
	 * @return boolean Ejercicio 3
	 */
	public static boolean estaIncluida(Lista l, Lista p) {
		Nodo pIni = p.nodoInicial;
		if (l.existe(pIni.dato)) {
			Nodo lIgualp = l.getNodo(pIni.dato);
			return estaIncluida(lIgualp, pIni);
		} else
			return false;
	}

	private static boolean estaIncluida(Nodo nodo1, Nodo nodo2) {
		if (nodo2 == null)
			return true;
		else if (nodo2.equals(nodo1))
			return estaIncluida(nodo1.siguiente, nodo2.siguiente);
		else
			return false;
	}

	private Nodo getNodo(int dato) {
		Nodo n = this.nodoInicial;
		while (n != null) {
			if (n.getDato() == dato)
				return n;
			n = n.siguiente;
		}
		return null;
	}

	/*
	 * public Lista agregarAlFinal(Lista p) { if (this.esVacia()) return p; if
	 * (p.esVacia()) return this; if (p.esVacia() && this.esVacia()) return
	 * null; return agregarAlFinal(this.nodoInicial,p.nodoInicial); }
	 * 
	 * private Lista agregarAlFinal(Nodo ni1, Nodo ni2) { if (ni1.siguiente ==
	 * null) ni1.siguiente = ni2; else
	 * 
	 * }
	 */

}
