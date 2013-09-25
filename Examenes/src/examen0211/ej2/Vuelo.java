package examen0211.ej2;

import java.util.Comparator;


public class Vuelo {

	private Ciudad ciudad1;
	private Ciudad ciudad2;
	private int precio;

	public Ciudad getCiudad1() {
		return ciudad1;
	}

	public void setCiudad1(Ciudad ciudad1) {
		this.ciudad1 = ciudad1;
	}

	public Ciudad getCiudad2() {
		return ciudad2;
	}

	public void setCiudad2(Ciudad ciudad2) {
		this.ciudad2 = ciudad2;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public Vuelo(Ciudad ciudad1, Ciudad ciudad2, int precio) {
		this.ciudad1 = ciudad1;
		this.ciudad2 = ciudad2;
		this.precio = precio;
	}

	public String toString() {
		return this.ciudad1 + " - " + this.ciudad2 + " - " + this.precio;
	}

	public boolean equals(Object o) {
		Vuelo v = (Vuelo) o;
		return ((v.ciudad1.equals(this.ciudad1)
				&& v.ciudad2.equals(this.ciudad2) && v.precio == this.precio) || (v.ciudad2
				.equals(this.ciudad1) && v.ciudad1.equals(this.ciudad2) && v.precio == this.precio));
	}

	public static Comparator<Vuelo> comparadorDeVuelos = new Comparator<Vuelo>() {

		@Override
		public int compare(Vuelo o1, Vuelo o2) {
			int v1 = o1.ciudad1.getIdentificador();
			int v2 = o2.ciudad2.getIdentificador();
			return v1 - v2;
		}
	};

	


}
