package practico4;

import practico3.ListaImpl;

public class Avion {

	public enum Caso {
		NUEVO, DEVUELVE;
	}

	private ListaImpl asientos;
	private Queue<Integer> espera;
	private int capacidadMaxima;

	public Avion(int capacidadMaxima) {
		this.asientos = new ListaImpl();
		this.espera = new Queue<Integer>();
		this.capacidadMaxima = capacidadMaxima;
	}

	private int getCapacidadActual() {
		return this.asientos.largo();
	}

	public void reservar(int pasajero, Caso caso) {
		switch (caso) {
		case NUEVO:
			if (this.getCapacidadActual() < this.capacidadMaxima)
				this.asientos.agregar(pasajero);
			else
				this.espera.enqueue(pasajero);
			break;
		case DEVUELVE:
			if (this.asientos.existe(pasajero)) {
				this.asientos.eliminar(pasajero);
				if (!this.espera.isEmpty())
					this.asientos.agregar(this.espera.dequeue());
			}
			break;
		}
	}

	public ListaImpl getAsientos(){
		return this.asientos;
	}

	public Queue<Integer> getEspera(){
		return this.espera;
	}

}
