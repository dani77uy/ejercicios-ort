package examen0713.ej3;

public class ArbolAVL {

//	private Nodo raiz;

	/*private class Nodo {
		int dato;
		Nodo izq;
		Nodo der;
		int altura;

		Nodo(int dato) {
			this(dato, null, null);
		}

		Nodo(int dato, Nodo izq, Nodo der) {
			this.dato = dato;
			this.izq = izq;
			this.der = der;
			this.altura = 0;
		}
	}

	public void insertar(int dato) {
		this.raiz = insertar(dato, this.raiz);
	}

	private Nodo insertar(int dato, Nodo nodo) {
		if (nodo == null) nodo = new Nodo(dato);
		else {
			int cmp = dato - nodo.dato;
			if (cmp < 0) {
				nodo.izq = insertar(dato, nodo.izq);
				if (altura(nodo.izq) - altura(nodo.der) == 2) {
					if (dato - nodo.izq.dato < 0) nodo = rotacionHijoIzquierdo(nodo);
					else nodo = rotacionDobleHijoIzquierdo(nodo);
				}
			} else if (cmp > 0) {
				nodo.der = insertar(dato, nodo.der);
				if (altura(nodo.der) - altura(nodo.izq) == 2) {
					if (dato - nodo.der.dato > 0) nodo = rotacionHijoDerecho(nodo);
					else nodo = rotacionDobleHijoDerecho(nodo);
				}
			}
		}
	}
	
	private static Nodo rotacionHijoIzquierdo(Nodo nodo){
		Nodo aux = nodo.izq;
		nodo.izq = aux.der;
		nodo.altura = 
	}
*/
}
