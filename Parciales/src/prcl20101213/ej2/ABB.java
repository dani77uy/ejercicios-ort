package prcl20101213.ej2;

public class ABB {

	private int niveles;

	private Nodo raiz;

	public ABB(int niveles) {
		this.niveles = niveles;
	}

	public int getNiveles() {
		if (this.esVacio()) return -1;
		return this.niveles;
	}

	public boolean esVacio() {
		return this.raiz == null;
	}

	private class Nodo {
		private int dato;
		private Nodo izquierda;
		private Nodo derecha;
		private int nivel;

		private Nodo(int dato) {
			this.dato = dato;
		}

		private Nodo setNivel(int nivel) {
			this.nivel = nivel;
			return this;
		}
	}

	public void insertar(int dato) {
		this.raiz = insertar(this.raiz, dato, 0);
	}

	private Nodo insertar(Nodo nodo, int dato, Integer nivel) {
		if (nodo != null) {
			int cmp = dato - nodo.dato;
			if (cmp < 0) {
				nodo.izquierda = insertar(nodo.izquierda, dato, nivel + 1);
				nodo.izquierda.nivel = nivel + 1;
			} else if (cmp > 0) {
				nodo.derecha = insertar(nodo.derecha, dato, nivel + 1);
				nodo.derecha.nivel = nivel + 1;
			} else {
				nodo.dato = dato;
			}
		} else {
			return new Nodo(dato).setNivel(nivel);
		}
		return nodo;
	}

	private int nivelConMasNodos(Nodo nodo, int cantidadNiveles){
		return 0;
	}
}
