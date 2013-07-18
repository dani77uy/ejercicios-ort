package practico3;

import util.ILista;
import util.Lista;

/**
 * 
 * @author daniel
 * 
 */
public class ListaImpl extends Lista {

	public ListaImpl(int[] datos, boolean ordenado) {
		this.crearLista(datos, ordenado);
	}

	public ListaImpl() {
	}

	/**
	 * 
	 * @param dato
	 * @return void Ejercicio 1
	 */

	public void borrar(int dato) {
		if (!this.esVacia()) {
			Nodo nodo1 = this.nodoInicial;
			Nodo nodo2 = this.nodoInicial.getSiguiente();
			if (nodo1.getDato() == dato) {
				this.nodoInicial = this.nodoInicial.getSiguiente();
			} else
				this.borrar(nodo1, nodo2, dato);
		}
	}

	private void borrar(Nodo nodo1, Nodo nodo2, int dato) {
		if (nodo1 != null && nodo2 != null)
			if (nodo2.getDato() == dato)
				nodo1.setSiguiente(nodo2.getSiguiente());
			else
				this.borrar(nodo2, nodo2.getSiguiente(), dato);
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
		/*
		 * Lista lista = new ListaImpl(); if (this.esVacia()) return null; Nodo
		 * start = this.getUltimoNodo(); while (start != null) {
		 * lista.insertarInicio(start.getDato()); start =
		 * this.getAnterior(start); } return lista;
		 */
		ListaImpl lista = new ListaImpl();
		if (this.esVacia())
			return null;
		Nodo nodo = this.nodoInicial;
		while (nodo != null) {
			lista.insertarInicio(nodo.getDato());
			nodo = nodo.getSiguiente();
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
		while (aux.getSiguiente() != null) {
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
			Nodo nuevo = new Nodo(dato);
			Nodo nodo = this.nodoInicial;
			if (this.nodoInicial == null)
				this.nodoInicial = new Nodo(dato);
			else {
				if (dato <= nodo.getDato())
					this.insertarInicio(dato);
				else
					while (nodo != null) {
						if (nodo.getSiguiente() != null) {
							if (nodo.getDato() <= dato
									&& nodo.getSiguiente().getDato() >= dato) {
								nuevo.setSiguiente(nodo.getSiguiente());
								nodo.setSiguiente(nuevo);
								return;
							}
						} else {
							nodo.setSiguiente(nuevo);
							return;
						}
						nodo = nodo.getSiguiente();
					}
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
		if (this.esVacia())
			throw new ArithmeticException();
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
			throw new ArrayIndexOutOfBoundsException();
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
			return this;
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

	/**
	 * 
	 * @param l
	 * @param p
	 * @return boolean Ejercicio 3
	 */
	public static boolean iguales(Lista l, Lista p) {
		if (l.esVacia() && p.esVacia())
			return true;
		return iguales(l.getNodoInicial(), p.getNodoInicial());
	}

	private static boolean iguales(Nodo nodo1, Nodo nodo2) {
		if (nodo1 == null && nodo2 == null)
			return true;
		if (nodo1.equals(nodo2))
			return iguales(nodo1.getSiguiente(), nodo2.getSiguiente());
		return false;
	}

	/**
	 * 
	 * @param l
	 * @param p
	 * @return Lista Ejercicio 3
	 */

	public static Lista intercalar(ListaImpl l, ListaImpl p) {
		ListaImpl nueva = new ListaImpl();
		intercalar(l.getNodoInicial(), p.getNodoInicial(), nueva);
		return nueva;
	}

	private static void intercalar(Nodo n1, Nodo n2, ListaImpl nueva) {
		if (n1.getSiguiente() == null && n2.getSiguiente() != null) {
			Nodo aux = n2;
			nueva.insertarOrdenado(n1.getDato());
			while (aux != null) {
				nueva.insertarOrdenado(aux.getDato());
				aux = aux.getSiguiente();
			}
			return;
		}
		if (n2.getSiguiente() == null && n1.getSiguiente() != null) {
			Nodo aux = n1;
			nueva.insertarOrdenado(n2.getDato());
			while (aux != null) {
				nueva.insertarOrdenado(aux.getDato());
				aux = aux.getSiguiente();
			}
			return;
		}
		if (n1.getDato() <= n2.getDato()) {
			nueva.insertarOrdenado(n1.getDato());
			intercalar(n1.getSiguiente(), n2, nueva);
		} else {
			nueva.insertarOrdenado(n2.getDato());
			intercalar(n1, n2.getSiguiente(), nueva);
		} 
	}

	/**
	 * 
	 * @param l
	 * @param p
	 * @return Lista Ejercicio 3
	 */
	public static Lista concatenar(Lista l, Lista p) {
		ListaImpl nueva = new ListaImpl(); 
		concatenar(l.getNodoInicial(),p.getNodoInicial(),nueva);
		return nueva;
	}

	private static void concatenar(Nodo n1, Nodo n2, ListaImpl nueva) {
		while(n2 != null){
       	 nueva.insertarInicio(n2.getDato());
       	 n2 = n2.getSiguiente();
        } 
		while(n1 != null){
        	 nueva.insertarInicio(n1.getDato());
        	 n1 = n1.getSiguiente();
         }
	}

	public void agregar(int dato){
		Nodo nodo = new Nodo(dato);
		if (this.esVacia())
			this.nodoInicial = nodo;
		else {
			Nodo ini = this.nodoInicial;
			while (ini.getSiguiente() != null){
				ini = ini.getSiguiente();
			}
			ini.setSiguiente(nodo);
		}
	}

	/*
	private static Lista agregar(Lista l, Lista p) {
		return l.agregarAlFinal(p);
	}*/

	private void crearLista(int[] datos, boolean ordenado) {
		for (int i : datos) {
			if (ordenado)
				this.insertarOrdenado(i);
			else
				this.insertarInicio(i);
		}
	}

}
