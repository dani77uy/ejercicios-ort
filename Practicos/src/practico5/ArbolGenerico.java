package practico5;

import java.util.StringTokenizer;

public class ArbolGenerico {

	private Nodo raiz;

	private class Nodo {
		private String dato;
		private Nodo primerHijo;
		private Nodo siguienteHermano;

		private Nodo(String dato, Nodo primerHijo, Nodo siguienteHermano) {
			this.dato = dato;
			this.primerHijo = primerHijo;
			this.siguienteHermano = siguienteHermano;
		}

		private Nodo() {
		}
	}

	public void insertar(String padre, String dato) {
		if (this.raiz == null)
			this.raiz = new Nodo(dato, null, null);
		else {
			Nodo tmp = buscarNodo(padre);
			if (tmp != null)
				agregarHermano(tmp, dato);
		}
	}

	private Nodo buscarNodo(String padre) {
		Nodo tmp1 = this.raiz;
		Nodo tmp2 = tmp1;
		StringTokenizer path = new StringTokenizer(padre, "/");
		String s;
		while (path.hasMoreTokens()) {
			s = path.nextToken();
			while (tmp1 != null) {
				if (s.equals(tmp1.dato))
					break;
				else {
					tmp2 = tmp1 = tmp1.primerHijo; // HERMAMO DERECHO
				}
			}
			if (tmp1 == null)
				return tmp1;
			else {
				tmp2 = tmp1;
				tmp1 = tmp1.siguienteHermano; // HIJO IZQUIERDO
			}
		}
		return tmp2;
	}

	private void agregarHermano(Nodo nodo, String dato) {

	}
}
