package pruebaGrafos;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Grafo<T extends Comparable<T>> {

	private int cantidadNodos;
	private Arco[][] matrizAdyacencia;
	private boolean[] nodosUsados;
	private Comparable<T>[] nombresNodos;
	private int size = 0;
	private List<Arco> arcos = new ArrayList<Arco>();
	private T[] vertices;

	private class Arco {
		T desde;
		T hasta;
		int valor;
	}

	@SuppressWarnings("unchecked")
	public Grafo(int cantidadNodos) {
		this.cantidadNodos = cantidadNodos;
		this.matrizAdyacencia = new Grafo.Arco[cantidadNodos][cantidadNodos];
		this.nodosUsados = new boolean[cantidadNodos];
		this.nombresNodos = new Comparable[cantidadNodos];
		this.vertices = (T[]) new Object[cantidadNodos];
	}

	@SuppressWarnings("unchecked")
	public void agregarVertice(T nombre) {
		if (this.size <= this.cantidadNodos) {
			this.nombresNodos[size] = (Comparable<T>) nombre.toString();
			this.nodosUsados[size] = true;
			this.vertices[size] = nombre;
			this.size++;
		} else throw new NoSuchElementException("Grafo completo");
	}

	public void quitarVertice(T nombre) {
		int contador = 0;
		for (Comparable<T> c : this.nombresNodos) {
			if (c.equals(nombre)) {
				c = null;
				if (this.eliminarAristas(nombre)) {
					this.nodosUsados[contador] = false;
					this.nombresNodos[contador] = null;
					this.vertices[contador] = null;
					this.size--;
					return;
				}
			}
			contador++;
		}
	}

	private boolean eliminarAristas(T vertice) {
		for (int i = 0; i < this.cantidadNodos; i++) {
			for (int j = 0; j < this.cantidadNodos; j++) {
				Arco a = this.matrizAdyacencia[i][j];
				if (a.desde.equals(vertice) || a.hasta.equals(vertice)) {
					this.arcos.remove(a);
					this.matrizAdyacencia[i][j] = null;
					return true;
				}
			}
		}
		return false;
	}

	public boolean agregarArista(T desde, T hasta, int peso) {
		Arco arco = new Arco();
		arco.desde = desde;
		arco.hasta = hasta;
		arco.valor = peso;
		try {
			int i = obtenerPosicion(desde);
			int j = obtenerPosicion(hasta);
			this.matrizAdyacencia[i][j] = arco;
			return this.arcos.add(arco);
		} catch (Exception ex) {
			return false;
		}
	}

	public boolean existeVertice(T vertice) {
		return obtenerPosicion(vertice) >= 0;
	}

	private int obtenerPosicion(T vertice) {
		int pos = 0;
		for (Comparable<T> nombre : this.nombresNodos) {
			if (nombre.equals(vertice)) return pos;
			pos++;
		}
		throw new NoSuchElementException("No existe el vértice");
	}

	public void procedimientoDFS(T vertice) {
		final boolean[] verticesMarcados = new boolean[this.cantidadNodos];
		verticesMarcados[this.obtenerPosicion(vertice)] = true;
		for (T ady : this.obtenerAdyacentes(vertice)) {
			if (!verticesMarcados[this.obtenerPosicion(ady)]) procedimientoDFS(ady);
		}
	}

	public void recorridoDFS() {
		final boolean[] verticesMarcados = new boolean[this.cantidadNodos];
		for (T t : this.vertices) {
			if (!verticesMarcados[obtenerPosicion(t)]) {
				procedimientoDFS(t);
				verticesMarcados[obtenerPosicion(t)] = true;
			}
		}
	}

	public void procedimientoBFS(T vertice) {
		final practico4.Queue<T> cola = new practico4.Queue<>();
		final List<T> verticesMarcados = new ArrayList<T>();
		verticesMarcados.add(vertice);
		cola.enqueue(vertice);
		while (!cola.isEmpty()) {
			T u = cola.front();
			cola.dequeue();
			for (T t : this.obtenerAdyacentes(u)) {
				if (!verticesMarcados.contains(t)) {
					verticesMarcados.add(t);
					cola.enqueue(t);
				}
			}
		}
	}

	public void reocorridoBFS() {
		final List<T> verticesMarcados = new ArrayList<T>();
		for (T t : this.vertices) {
			if (!verticesMarcados.contains(t)) {
				verticesMarcados.add(t);
				this.procedimientoBFS(t);
			}
		}
	}

	public int caminoMasCortoDijkstra1(T vertice) {
		int[] distancias = new int[this.cantidadNodos];
		boolean[] vistos = new boolean[this.cantidadNodos];
		int v = this.obtenerPosicion(vertice);
		for (T t : this.vertices) {
			int p = this.obtenerPosicion(t);
			Arco a = this.obtenerArco(t, vertice);
			if (a != null) distancias[p] = a.valor;
			else distancias[p] = Integer.MAX_VALUE;
		}
		distancias[v] = 0;
		vistos[v] = true;
		while (!sonTodosTrue(vistos)) {
			T t = cogerElMinimoQueNoEsteVisto(distancias, vistos);
			for (T w : this.obtenerAdyacentes(t)) {
				int d = distancias[this.obtenerPosicion(t)] + this.obtenerArco(t, w).valor;
				int pw = this.obtenerPosicion(w);
				if (distancias[pw] > d) distancias[pw] = d;
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i : distancias) {
			if (i < min) min = i;
		}
		return min;
	}

	private T cogerElMinimoQueNoEsteVisto(int[] distancias, boolean[] vistos) {
		int dm = Integer.MAX_VALUE;
		final List<Integer> pos = new ArrayList<Integer>();
		for (int i : distancias)
			if (i < dm) dm = i;
		for (int i = 0; i < distancias.length; i++) {
			if (distancias[i] == dm) {
				pos.add(i);
			}
		}
		int v = -1;
		for (int i = 0; i < pos.size(); i++) {
			if (!vistos[pos.get(i)]) v = pos.get(i);
		}
		return this.vertices[v];
	}

	private static boolean sonTodosTrue(boolean[] v) {
		for (boolean b : v) {
			if (!b) return false;
		}
		return true;
	}

	private Arco obtenerArco(T t1, T t2) {
		for (Arco arco : this.arcos)
			if ((arco.desde.equals(t1) && arco.hasta.equals(t2)) || (arco.desde.equals(t2) && arco.hasta.equals(t1))) { return arco; }
		return null;
	}

	private Iterable<T> obtenerAdyacentes(T vertice) {
		List<T> lista = new ArrayList<T>();
		for (int i = 0; i < this.cantidadNodos; i++) {
			for (int j = 0; j < this.cantidadNodos; j++) {
				Arco a = this.matrizAdyacencia[i][j];
				if (a.desde.equals(vertice)) if (!lista.contains(a.hasta)) lista.add(a.hasta);
				if (a.hasta.equals(vertice)) if (!lista.contains(a.desde)) lista.add(a.desde);
			}
		}
		return lista;
	}

}
