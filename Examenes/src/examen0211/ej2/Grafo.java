package examen0211.ej2;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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
		int id = ciudad.getIdentificador() - 1;
		if (id < this.maximo && !this.nodosUsados[id]) {
			this.nodosUsados[id] = true;
			this.size++;
		} else {
			throw new NoSuchElementException();
		}
	}

	public boolean esVacio() {
		return this.size == 0;
	}

	public boolean pertenece(int ciudadId) {
		if (ciudadId > this.maximo)
			throw new NoSuchElementException();
		return this.nodosUsados[ciudadId - 1];
	}

	public boolean[] getNodosUsados() {
		return this.nodosUsados;
	}

	public void eliminarCiudad(Ciudad ciudad) {
		final int id = ciudad.getIdentificador() - 1;
		this.nodosUsados[id] = false;
		this.size--;
		for (int i = 0; i <= this.maximo; i++) {
			this.matrizAdyacencia[i][id] = new Arco();
			this.matrizAdyacencia[id][i] = new Arco();
		}
	}

	public boolean existeVuelo(Ciudad ciudad1, Ciudad ciudad2) {
		return this.matrizAdyacencia[ciudad1.getIdentificador() - 1][ciudad2.getIdentificador() - 1].existe;
	}

	public boolean existeVuelo(Vuelo vuelo){
		return this.existeVuelo(vuelo.getCiudad1(), vuelo.getCiudad2());
	}
	/**
	 * 
	 * similar a Agregar Arista
	 */
	public void agregarVuelo(Ciudad ciudad1, Ciudad ciudad2, int precio) {
		if (!ciudad1.equals(ciudad2)) {
			Arco nuevo = new Arco(precio);
			this.matrizAdyacencia[ciudad1.getIdentificador() - 1][ciudad2.getIdentificador() - 1] = nuevo;
		} else {
			throw new NoSuchElementException();
		}
	}
	
	public void agregarVuelo(Vuelo vuelo){
		this.agregarVuelo(vuelo.getCiudad1(), vuelo.getCiudad2(), vuelo.getPrecio());
	}

	public int obtenerPrecio(Ciudad ciudad1, Ciudad ciudad2) {
		int i1 = ciudad1.getIdentificador() - 1;
		int i2 = ciudad2.getIdentificador() - 1;
		return this.matrizAdyacencia[i1][i2].peso;
	}

	public List<Ciudad> comparteVuelos(Ciudad ciudad) {
		ArrayList<Ciudad> lista = new ArrayList<>();
		for (int i = 0; i <= this.maximo; i++) {
			for (int j = 0; j <= this.maximo; j++) {
				if (ciudad.getIdentificador() == i)
					if (this.matrizAdyacencia[i][j].peso > 0)
						lista.add(getCiudad(j));
				if (ciudad.getIdentificador() == j)
					if (this.matrizAdyacencia[i][j].peso > 0)
						lista.add(getCiudad(i));
			}
		}
		return lista;
	}

	private Ciudad getCiudad(int id) {
		return CiudadesMaster.CIUDADES.get(id);
	}

	public List<Ciudad> getCiudades() {
		ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();
		for (int x = 0; x < this.maximo; x++) {
			if (this.nodosUsados[x])
				ciudades.add(getCiudad(x));
		}
		return ciudades;
	}

	public List<Vuelo> getVuelos() {
		final ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();
		for (int i = 0; i < maximo; i++)
			for (int j = 0; j < maximo; j++) {
				if (this.existeVuelo(getCiudad(i), getCiudad(j))) {
					Vuelo v = new Vuelo(getCiudad(i), getCiudad(j),	this.obtenerPrecio(getCiudad(i), getCiudad(j)));
					vuelos.add(v);
				}
			}
		return vuelos;
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
