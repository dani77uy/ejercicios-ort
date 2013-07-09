package practico3;

import util.ILista;
import util.Lista;

/**
 * 
 * @author daniel
 * 
 */
public class ListaImpl extends Lista {

	/**
	 * 
	 * @param dato
	 * @return void Ejercicio 1
	 */
	public void borrar(int dato) {
		if (!this.esVacia()) {
			if (this.nodoInicial.getDato() == dato) {
				Nodo nodo = this.nodoInicial;
				this.nodoInicial = nodo.getSiguiente();
			} else {
				Nodo nodo = this.nodoInicial;
				Nodo prev = this.nodoInicial;
				while (nodo != null) {
					if (nodo.getDato() == dato) {
						prev.setSiguiente(nodo.getSiguiente());
					} else {
						prev = nodo;
						nodo = nodo.getSiguiente();
					}
				}
			}
		}
	}

	/**
	 * 
	 * @return int Ejercicio 1
	 */
	public int largo() {
		Nodo nodo = this.nodoInicial;
		int size = 0;
		if (!this.esVacia()) {
			while (nodo != null) {
				size++;
				nodo = nodo.getSiguiente();
			}
		}
		return size;
	}

	/**
	 * @return void
	 * @param dato
	 *            Ejercicio 1
	 */
	public void snoc(int dato) {
		Nodo nodo = new Nodo(dato);
		Nodo aux = this.nodoInicial;
		if (aux == null)
			this.nodoInicial = nodo;
		else {
			while (aux.getSiguiente() != null) {
				aux = aux.getSiguiente();
			}
			aux.setSiguiente(nodo);
		}
	}

	/**
	 * 
	 * @return ILista Ejercicio 2
	 */
	public ILista invertir() {
		Lista lista = new ListaImpl();
		if (this.esVacia())
			return null;
		Nodo start = this.getUltimoNodo();
		while (start != null) {
			lista.agregar(start.getDato());
			start = this.getAnterior(start);
		}
		return lista;
	}

	/**
	 * 
	 * @return boolean Ejercicio 2
	 */
	public boolean estaOrdenada() {
		if (this.esVacia())
			return true;
		Nodo aux = this.nodoInicial;
		while (aux != null) {
			if (aux.getDato() > aux.getSiguiente().getDato())
				return false;
			aux = aux.getSiguiente();
		}
		return true;

	}

	/**
	 * 
	 * @param dato
	 *            Ejercicio 2
	 */
	public void insertarOrdenado(int dato) {
		if (this.estaOrdenada()) {
			Nodo aux = this.nodoInicial;
			while (aux != null) {
				if (aux.getDato() >= dato
						&& aux.getSiguiente().getDato() < dato) {
					Nodo nuevo = new Nodo(dato);
					nuevo.setSiguiente(aux.getSiguiente());
					aux.setSiguiente(nuevo);
					return;
				}
				aux = aux.getSiguiente();
			}
		}
	}

	/**
	 * 
	 * @param elemento
	 * @return int Ejercicio 2
	 */
	public int cuenta(int elemento) {
		int cant = 0;
		return this.cuenta(this.nodoInicial, elemento, cant);
	}

	private int cuenta(Nodo nodo, int elemento, Integer cant) {
		if (nodo == null)
			return cant;
		if (nodo.getDato() == elemento)
			cant++;
		return cuenta(nodo.getSiguiente(), elemento, cant);
	}

	/**
	 * 
	 * @return int Ejercicio 2
	 */
	public int maximo() {
		int max = Integer.MIN_VALUE;
		if (!this.esVacia()) {
			Nodo nodo = this.nodoInicial;
			max = nodo.getDato();
			while (nodo.getSiguiente() != null) {
				if (nodo.getDato() >= max)
					max = nodo.getDato();
				nodo = nodo.getSiguiente();
			}
		}
		return max;
	}

	/**
	 * 
	 * @return int Ejercicio 3
	 */
	public int promedio() {
		return this.suma() / this.largo();
	}

	private int suma() {
		int suma = 0;
		if (!this.esVacia()) {
			Nodo nodo = this.nodoInicial;
			while (nodo != null) {
				suma = suma + nodo.getDato();
				nodo = nodo.getSiguiente();
			}
		}
		return suma;
	}

	/**
	 * 
	 * @param n
	 * @return int Ejercicio 2
	 */
	public int tomar_n(int n) {
		if (this.largo() >= n) {
			int cont = 1;
			Nodo nodo = this.nodoInicial;
			while (nodo != null) {
				if (cont == n)
					return nodo.getDato();
				nodo = nodo.getSiguiente();
				cont++;
			}
		} else
			throw new IllegalArgumentException();
		return -1;
	}

	/**
	 * 
	 * @param n
	 * @param m
	 * @return Lista Ejercicio 2
	 */
	public Lista cambiar(int n, int m) {
		if (this.esVacia())
			return null;
		Lista lista = new Lista();
		Nodo nodo = this.nodoInicial;
		while (nodo != null) {
			if (nodo.getDato() == n)
				lista.agregar(m);
			else
				lista.agregar(nodo.getDato());
			nodo = nodo.getSiguiente();
		}
		return lista;
	}

	public Lista quitarInicio() {
		if (this.esVacia())
			return null;
		Lista l = (Lista) this.clone();
		l.nodoInicial = l.nodoInicial.siguiente;
		return l;
	}
	
	/**
	 * 
	 * @param l
	 * @param p
	 * @return boolean Ejercicio 3
	 */
	public static boolean iguales(Lista l, Lista p) {
		if (l.esVacia() && p.esVacia())
			return true;
		return iguales(l.elemento(), p.elemento(), l, p);
	}

	private static boolean iguales(int elemento, int elemento2, Lista l, Lista p) {
		if (l.elemento() != elemento && p.elemento() != elemento2)
			return false;
		else {
			Lista l1 = l.quitarInicio();
			Lista p1 = p.quitarInicio();
			return iguales(l1.elemento(), p1.elemento(), l1, p1);
		}
	}

	public static Lista intercalar(Lista l, Lista p) {
		if (l instanceof ListaImpl && p instanceof ListaImpl) {
			ListaImpl l1 = (ListaImpl) l;
			ListaImpl p1 = (ListaImpl) p;
			if (!l1.estaOrdenada() && !p1.estaOrdenada())
				return null;
			else {
				ListaImpl lista = new ListaImpl();
				return intercalar(lista, l1, p1);
			}
		} else
			return null;

	}

	private static Lista intercalar(ListaImpl lista, ListaImpl l1, ListaImpl p1) {
		if ((p1 == null || p1.largo()==0) && (l1==null && l1.largo() == 0))
			return lista;
		int p1Ini = p1.elemento();
		int l1Ini = l1.elemento();
		if (p1Ini <= l1Ini) {
			lista.agregar(p1Ini);
			return intercalar(lista, l1.quitarInicio(), p1.quitarInicio());
		} else {
			lista.agregar(l1Ini);
		}
	}

}
