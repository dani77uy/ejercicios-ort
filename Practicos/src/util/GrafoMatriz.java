/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

/**
 * 
 * @author Vicky
 */
public class GrafoMatriz implements IGrafo {
	int size;
	int cantNodos;
	Arco[][] matrizAdyacencia;
	boolean[] nodosUsados;

	// Crea el grafo vacio (sin nodos ni aristas) con capacidad de
	// almacenamiento de n vertices
	public GrafoMatriz(int cantNodos) {
		this.size = 0;
		this.cantNodos = cantNodos;

		this.matrizAdyacencia = new Arco[cantNodos + 1][cantNodos + 1];
		for (int i = 1; i <= cantNodos; i++)
			for (int j = 1; j <= cantNodos; j++)
				this.matrizAdyacencia[i][j] = new Arco();

		this.nodosUsados = new boolean[cantNodos + 1];
	}

	@Override
	public void agregarArista(int origen, int destino, int peso) {
		Arco nuevo = new Arco(true, peso);
		this.matrizAdyacencia[origen][destino] = nuevo;
	}

	@Override
	public void agregarVertice(int v) {
		this.nodosUsados[v] = true;
		this.size++;
	}

	@Override
	public void eliminarArista(int origen, int destino) {
		Arco nuevo = new Arco();
		this.matrizAdyacencia[origen][destino] = nuevo;
	}

	@Override
	public void eliminarVertice(int v) {
		this.nodosUsados[v] = false;
		this.size--;

		// Elimino las aristas donde v es miembro
		for (int i = 1; i <= this.cantNodos; i++) {
			this.matrizAdyacencia[i][v] = new Arco();
			this.matrizAdyacencia[v][i] = new Arco();
		}
	}

	@Override
	public boolean esVacio() {
		return this.size == 0;
	}

	@Override
	public boolean sonAdyacentes(int a, int b) {
		return this.matrizAdyacencia[a][b].existe;
	}

	@Override
	public ILista verticesAdyacentes(int v) {
		ILista listaAdy = new Lista();
		for (int i = 1; i <= cantNodos; i++)
			if (matrizAdyacencia[v][i].existe)
				listaAdy.agregar(i);
		return listaAdy;
	}

	@Override
	public boolean estaVertice(int v) {
		return this.nodosUsados[v];
	}

	/******************** métodos extendidos ****************************/

	/* Recorrido DFS */
	public void Mostrar_DFS(int v) {
		boolean[] visitado = new boolean[cantNodos + 1];
		Mostrar_DFS(v, visitado);
		System.out.println();
	}

	private void Mostrar_DFS(int v, boolean[] visitado) {
		visitado[v] = true;// se marca el nodo actual como visitado
		System.out.print(v + " ");
		ILista adyacentes = this.verticesAdyacentes(v);
		// recorre lista de adyacentes al nodo actual para visitarlos
		while (!adyacentes.esVacia()) {
			int i = adyacentes.elemento();
			if (!visitado[i])
				Mostrar_DFS(i, visitado);// llamada recursiva a los nodos
											// adyacentes para visitarlos
			adyacentes.eliminar(i);
		}
	}

	/* Recorrido Matriz */
	public void Mostrar_Matriz() {
		for (int i = 1; i <= cantNodos; i++) {
			for (int j = 1; j <= cantNodos; j++) {
				if (this.matrizAdyacencia[i][j].existe)
					System.out.print(this.matrizAdyacencia[i][j].peso + " ");
				else
					System.out.print("-- ");
			}
			System.out.println();
		}
		System.out.println();
	}

	/******************** EJERCICIOS DEL PRÁCTICO 6 ************************************/

	/************************************************************************************/
	/********** Ejercicio 6) a) Distancia más corta (aplicación de DIJKSTRA) **********/
	/*******************************************************************************/
	public int caminoMinimo(int o, int d) {
		int[] costo = new int[cantNodos + 1];
		int[] camino = new int[cantNodos + 1];
		boolean[] visitado = new boolean[cantNodos + 1];
		// Inicializo costos con valor INFINITO
		for (int i = 1; i <= cantNodos; i++) {
			if (i != o)
				costo[i] = Integer.MAX_VALUE;
		}

		for (int i = 1; i <= cantNodos; i++) {
			// vertice con la distancia mas corta no visitado
			int u = distanciaMasCorta(costo, visitado, o, d);
			visitado[u] = true;
			for (int j = 1; j <= cantNodos; j++) {
				if (this.sonAdyacentes(u, j) && !visitado[j]) {
					if (this.matrizAdyacencia[u][j].peso + costo[u] < costo[j]) {
						costo[j] = this.matrizAdyacencia[u][j].peso + costo[u];
						camino[j] = u;
					}
				}
			}
		}
		imprimirCaminosAux(o, d, camino);
		return costo[d];
	}

	private int distanciaMasCorta(int[] costo, boolean[] visitado, int o, int d) {
		int minimo = this.matrizAdyacencia[o][d].peso;
		int vertice = d;
		@SuppressWarnings("unused")
		boolean primeraVez = true;

		for (int i = 1; i <= cantNodos; i++) {
			if (!visitado[i] && matrizAdyacencia[o][i].peso < minimo) {
				minimo = matrizAdyacencia[o][i].peso;
				vertice = i;
			}
		}
		return vertice;
	}

	private void imprimirCaminosAux(int v, int i, int[] camino) {
		if (i != v) {
			imprimirCaminosAux(v, camino[i], camino);
		}
		System.out.print(i + " ");
	}

	/************ FIN ej 6) a) ***********************/

	/*******************************************************************************/
	/******** Ejercicio 6) b) todos los caminos de ni a nf (aplicación DFS) *********/
	/*******************************************************************************/
	public void todosCaminos(int nodoInicial, int nodoFinal) {
		ILista caminoActual = new Lista();
		caminoActual.agregar(nodoInicial);
		todosCaminos(nodoInicial, nodoFinal, caminoActual);
	}

	private void todosCaminos(int nodoInicial, int nodoFinal,
			ILista caminoActual) {
		if (nodoInicial == nodoFinal) {// Llegué al fin del camino
			caminoActual.mostrar();
			System.out.println();
		} else {
			ILista adyacentes = this.verticesAdyacentes(nodoInicial);
			while (!adyacentes.esVacia()) {
				int v = adyacentes.elemento();
				adyacentes.eliminar(v);
				boolean visitado = caminoActual.existe(v);

				if (!visitado) {
					caminoActual.agregar(v);
					todosCaminos(v, nodoFinal, caminoActual);
					caminoActual.eliminar(v);
				}
			}
		}
	}

	/*************** FIN ej 6) b) ***********************/

	/********************************************************************************/
	/************* Ej 7) b) camino más largo de ni a nf (aplicación DFS) **************/
	/********************************************************************************/
	// PRE: nodos inicial y final son distintos y ambos pertenecen al grafo.
	// Grafo Conexo
	public ILista masLargo(int nodoInicial, int nodoFinal) {
		ILista caminoMasLargo = new Lista();
		ILista caminoActual = new Lista();
		caminoActual.agregar(nodoInicial);
		// int costoMaximo = 0;
		Integer costoMaximo = new Integer(0);
		caminoMasLargo = CaminoMasLargo(nodoInicial, nodoFinal, caminoMasLargo,
				caminoActual, costoMaximo, 0);
		caminoMasLargo.mostrar();
		return caminoMasLargo;
	}

	private ILista CaminoMasLargo(int nodoInicial, int nodoFinal,
			ILista caminoMasLargo, ILista caminoActual, Integer costoMaximo,
			int costoActual) {
		if (nodoInicial == nodoFinal) {// Llegué al fin del camino
			if (costoMaximo.intValue() < costoActual) {
				caminoMasLargo = caminoActual.clone();
				costoMaximo = costoActual;
			}
		} else {
			ILista adyacentes = this.verticesAdyacentes(nodoInicial);
			while (!adyacentes.esVacia()) {
				int v = adyacentes.elemento();
				adyacentes.eliminar(v);
				boolean visitado = false;
				if (!caminoActual.esVacia())
					visitado = caminoActual.existe(v);
				if (!visitado) {
					caminoActual.agregar(v);
					int costo = matrizAdyacencia[nodoInicial][v].peso;// costo
																		// de la
																		// arista
																		// que
																		// va
																		// desde
																		// nodoInicial
																		// a v
					caminoMasLargo = CaminoMasLargo(v, nodoFinal,
							caminoMasLargo, caminoActual, costoMaximo,
							costoActual + costo);
					caminoActual.eliminar(v);
				}
			}
		}
		return caminoMasLargo;
	}

	/****************** FIN Ej 7) b) **********************/

}
