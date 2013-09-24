package util;

import java.util.ArrayList;
import java.util.List;

import practico3.ListaImpl;

public class ABB<V extends Comparable<V>> {

	private Nodo root;
	private ListaImpl nodos = new ListaImpl();

	private class Nodo {
		private V elemento;
		private Nodo izquierda, derecha;

		Nodo(V e) {
			this.elemento = e;
		}

		@Override
		public String toString() {
			return this.elemento.toString();
		}

		@Override
		public boolean equals(Object o) {
			if (!(o instanceof ABB.Nodo))
				return false;
			@SuppressWarnings({ "rawtypes" })
			ABB.Nodo nodo = (ABB.Nodo) o;
			return nodo.elemento.equals(this.elemento);
		}
	}

	public boolean esVacio() {
		return this.root == null;
	}

	public void insertar(V elemento) {
		if (!esVacio() && elemento instanceof Integer)
			nodos.agregar(Integer.parseInt(elemento.toString()));
		this.root = insertar(this.root, elemento);
	}

	private Nodo insertar(Nodo nodo, V elemento) {
		if (nodo != null) {
			int cmp = elemento.compareTo(nodo.elemento);
			if (cmp < 0) {
				nodo.izquierda = insertar(nodo.izquierda, elemento);
			} else if (cmp > 0) {
				nodo.derecha = insertar(nodo.derecha, elemento);
			} else {
				nodo.elemento = elemento;
			}
		} else {
			return new Nodo(elemento);
		}
		return nodo;
	}

	public int cantidadNodos() {
		if (root == null)
			return 0;
		return cantidadNodos(this.root);
	}

	private int cantidadNodos(Nodo nodo) {
		if (nodo.izquierda == null && nodo.derecha == null)
			return 1;
		else {
			int n = 0, m = 0;
			if (nodo.derecha != null)
				n = cantidadNodos(nodo.derecha);
			if (nodo.izquierda != null)
				m = cantidadNodos(nodo.izquierda);
			return n + m + 1;
		}
	}

	public int cantidadHojas() {
		return cantidadHojas(this.root);
	}

	private int cantidadHojas(Nodo nodo) {
		if (nodo == null)
			return 0;
		if (nodo.izquierda == null && nodo.derecha == null)
			return 1;
		else
			return cantidadHojas(nodo.izquierda) + cantidadHojas(nodo.derecha);

	}

	public int altura() {
		return altura(this.root);
	}

	private int altura(Nodo nodo) {
		if (nodo == null)
			return 0;
		else {
			int i = altura(nodo.izquierda);
			int d = altura(nodo.derecha);
			return max(i, d) + 1;
		}
	}

	private int max(int n1, int n2) {
		if (n1 > n2)
			return n1;
		if (n2 > n1)
			return n2;
		if (n2 == n1)
			return n1;
		return 0;
	}

	public void borrarMinimo() {
		this.root = borrarMinimo(this.root);
	}

	public void borrarElemento(V elemento) {
		this.root = this.borrarElemento(elemento, this.root);
	}

	private Nodo borrarElemento(V elemento, Nodo nodo) {
		if (nodo == null)
			return null;
		int cmp = elemento.compareTo(nodo.elemento);
		if (cmp < 0)
			nodo.izquierda = borrarElemento(elemento, nodo.izquierda);
		else if (cmp > 0)
			nodo.derecha = borrarElemento(elemento, nodo.derecha);
		else {
			if (nodo.derecha == null)
				return nodo.izquierda;
			if (nodo.izquierda == null)
				return nodo.derecha;
			Nodo t = nodo;
			nodo = min(t.derecha);
			nodo.derecha = borrarMinimo(t.derecha);
			nodo.izquierda = t.izquierda;
		}
		return nodo;
	}

	private Nodo min(Nodo nodo) {
		if (nodo.izquierda == null)
			return nodo;
		else
			return min(nodo.izquierda);
	}

	private Nodo borrarMinimo(Nodo nodo) {
		if (nodo.izquierda == null)
			return nodo.derecha;
		nodo.izquierda = borrarMinimo(nodo.izquierda);
		return nodo;
	}

	public boolean pertenece(V elemento) {
		return pertenece(this.root, elemento);
	}

	private boolean pertenece(Nodo nodo, V e) {
		if (nodo != null)
			if (nodo.elemento.equals(e))
				return true;
			else
				return pertenece(nodo.izquierda, e)
						|| pertenece(nodo.derecha, e);
		return false;
	}

	public void listarAscendente() {
		System.out.println(inorder());
	}

	public void listarDescendente() {
		if (this.root == null)
			System.out.println("");
		else {
			listarDescendente(this.root);
			for (V v : lista) {
				System.out.println(v.toString());
			}
		}
	}

	private List<V> lista = new ArrayList<V>();

	private void listarDescendente(Nodo nodo) {
		if (nodo != null)
			if (!lista.contains(nodo.elemento)) {
				listarDescendente(nodo.derecha);
				lista.add(nodo.elemento);
				listarDescendente(nodo.izquierda);
				lista.add(nodo.elemento);
			}
	}

	@Override
	public String toString() {
		return preorder();
	}

	public String preorder() {
		return preorder(this.root, new StringBuilder());
	}

	private String preorder(Nodo nodo, StringBuilder s) {
		if (nodo == null)
			return s.toString();
		s.append(nodo.toString());
		this.preorder(nodo.izquierda, s);
		this.preorder(nodo.derecha, s);
		return s.toString();
	}

	public String postorder() {
		return postorder(this.root, new StringBuilder());
	}

	private String postorder(Nodo nodo, StringBuilder s) {
		if (nodo == null)
			return s.toString();
		this.postorder(nodo.izquierda, s);
		this.postorder(nodo.derecha, s);
		s.append(nodo.toString());
		return s.toString();
	}

	public String inorder() {
		return inorder(this.root, new StringBuilder());
	}

	private String inorder(Nodo nodo, StringBuilder s) {
		if (nodo == null)
			return s.toString();
		this.inorder(nodo.izquierda, s);
		s.append(nodo.toString());
		this.inorder(nodo.derecha, s);
		return s.toString();
	}
	
	
}
