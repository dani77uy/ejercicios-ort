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

	@Override
	public int elemento() {
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


	public Lista quitarInicio() {
		if (this.esVacia())
			return null;
		Lista l = (Lista) this.clone();
		l.nodoInicial = l.nodoInicial.siguiente;
		return l;
	}

}
