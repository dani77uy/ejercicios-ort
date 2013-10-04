package prcl20101213.ej1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Grafo {

	private Arco[][] matrizAdyacencia;
	private int maximo;
	private Boolean[] nodosUsados;
	private final Stack<Integer> path = new Stack<Integer>();
	private final Set<Integer> onPath = new HashSet<Integer>();

	private class Arco {
		int desde;
		int hasta;
		int peso;

		Arco(int desde, int hasta, int peso) {
			this.desde = desde;
			this.hasta = hasta;
			this.peso = peso;
		}
		
		Arco getArco(int desde, int hasta){
			if (this.desde==desde && this.hasta==hasta)
				return this;
			return null;
		}

		public String toString() {
			if (peso >= 10) return String.valueOf(this.peso);
			else return "0" + String.valueOf(this.peso);
		}
	}

	@SuppressWarnings("unused")
	public Grafo(int maximo) {
		this.maximo = maximo;
		this.matrizAdyacencia = new Arco[maximo][maximo];
		this.nodosUsados = new Boolean[maximo];
		for (Boolean elemento : this.nodosUsados) {
			elemento = Boolean.FALSE;
		}
	}

	public void agregarNodo(int nodo) {
		if (nodo < maximo) this.nodosUsados[nodo] = true;
	}

	public void agregarArco(int desde, int hasta, int peso) {
		if (this.nodosUsados[desde - 1] && this.nodosUsados[hasta - 1]) {
			this.matrizAdyacencia[desde - 1][hasta - 1] = new Arco(desde, hasta, peso);
		}
	}

	public String getMatrizDeAdyadencia() {
		String salida = "    01 02 03 04 05 \n------------------";
		int i = 0;
		while (i < maximo) {
			String linea = "0" + (i + 1) + "|";
			for (int j = 0; j < maximo; j++) {
				String coma = linea.trim().equals("") ? "" : " ";
				String arco = this.matrizAdyacencia[i][j] == null ? "- " : this.matrizAdyacencia[i][j].toString();
				linea = linea + coma + arco;
			}
			String salto = salida.trim().equals("") ? "" : "\n";
			salida = salida + salto + linea;
			i++;
		}
		return salida;
	}
	
	public Arco[][] getMatrizAdyacencia(){
		return this.matrizAdyacencia;
	}

	public List<String> getListaDeAdyacencia() {
		List<String> salida = new ArrayList<String>();
		for (int j = 0; j < maximo; j++) {
			int i = 0;
			while (i < maximo) {

			}
		}
		return salida;
	}

	public List<Stack<Integer>> caminosPosibles(int origen, int destino) {
		List<Stack<Integer>> lista = new ArrayList<Stack<Integer>>();
		caminosPosibles(origen, destino, lista);
		return lista;
	}

	@SuppressWarnings("unchecked")
	private void caminosPosibles(int origen, int destino, List<Stack<Integer>> lista) {
		path.push(origen);
		onPath.add(origen);
		if (origen == destino) {
			Stack<Integer> st = (Stack<Integer>) path.clone();
			lista.add(st);
		} else for (int i : this.adyacentes(origen)) {
			if (!onPath.contains(i)) caminosPosibles(i, destino, lista);
		}
		path.pop();
		onPath.remove(origen);
	}

	private List<Integer> adyacentes(int origen) {
		List<Integer> salida = new ArrayList<Integer>();
		for (int x = 0; x < maximo; x++) {
			if (this.matrizAdyacencia[origen - 1][x] != null) salida.add(x + 1);
		}
		return salida;
	}

	public int costoMinimo(int origen, int destino) {
		int minimo = Integer.MAX_VALUE;
		List<Stack<Integer>> caminos = this.caminosPosibles(origen, destino);
		for (Stack<Integer> stack : caminos) {
			int suma = obtenerPesos(stack);
			if (suma < minimo) minimo = suma;
		}
		return minimo;
	}

	private int obtenerPesos(Stack<Integer> stack) {
		int total = 0;
		for (int x = 0; x < stack.size() - 1; x++) {
			total = total + this.matrizAdyacencia[stack.get(x)-1][stack.get(x + 1)-1].peso;
		}
		return total;
	}

}
