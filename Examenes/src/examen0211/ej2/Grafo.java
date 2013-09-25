package examen0211.ej2;

import java.util.ArrayList;
import java.util.List;

public class Grafo {

	private int maximo;
	private int size;
	private Arco[][] matrizAdyacencia;
	private boolean[] nodosUsados;

	/**
	 * 
	 * construye el grafo vacio
	 */
	public Grafo(int maximo) {
		this.size = 0;
		this.maximo = maximo;
		this.matrizAdyacencia = new Arco[maximo + 1][maximo + 1];
		for (int i = 0; i <= maximo; i++) {
			for (int j = 0; j < maximo; j++) {
				this.matrizAdyacencia[i][j] = new Arco();
			}
		}
		this.nodosUsados = new boolean[maximo + 1];
	}

	public void agregarCiudad(Ciudad ciudad) {
		int id = ciudad.getIdentificador();
		if (id <= this.maximo) {
			this.nodosUsados[id] = true;
			this.size++;
		}
	}

	public boolean esVacio() {
		return this.size == 0;
	}

	public boolean pertenece(int ciudadId) {
		return this.nodosUsados[ciudadId];
	}

	public void eliminarCiudad(Ciudad ciudad) {
		final int id = ciudad.getIdentificador();
		this.nodosUsados[id] = false;
		this.size--;
		for(int i=0;i<=this.maximo;i++){
			this.matrizAdyacencia[i][id] = new Arco();
			this.matrizAdyacencia[id][i] = new Arco();
		}
	}

	public boolean existeVuelo(Ciudad ciudad1, Ciudad ciudad2) {
        return this.matrizAdyacencia[ciudad1.getIdentificador()][ciudad2.getIdentificador()].existe;
	}

	/**
	 * 
	 * similar a Agregar Arista
	 */
	public void agregarVuelo(Ciudad ciudad1, Ciudad ciudad2, int precio) {
          Arco nuevo = new Arco(precio);
          this.matrizAdyacencia[ciudad1.getIdentificador()][ciudad2.getIdentificador()] = nuevo;
	}

	public int obtenerPrecio(Ciudad ciudad1, Ciudad ciudad2) {
          int i1 = ciudad1.getIdentificador();
          int i2 = ciudad2.getIdentificador();
          return this.matrizAdyacencia[i1][i2].peso;
	}

	public List<Ciudad> comparteVuelos(Ciudad ciudad) {
         ArrayList<Ciudad> lista = new ArrayList<>();
         for(int i=0;i<=this.maximo;i++){
        	 for(int j=0;j<=this.maximo;j++){
        		 if (ciudad.getIdentificador() == i)
        			 if (this.matrizAdyacencia[i][j].peso>0)
        				 lista.add(getCiudad(j));
        		 if (ciudad.getIdentificador() == j)
        			 if (this.matrizAdyacencia[i][j].peso>0)
        				 lista.add(getCiudad(i));
        	 }
         }
         return lista;
	}
	
	private Ciudad getCiudad(int id){
		return CiudadesMaster.CIUDADES.get(id);
	}

	private class Arco {
		boolean existe;
		int peso;

		Arco() {
			this.existe = false;
			this.peso = 0;
		}

		Arco(int peso) {
			this.existe = true;
			this.peso = peso;
		}
	}
}
