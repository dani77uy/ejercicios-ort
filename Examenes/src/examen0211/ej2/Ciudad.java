package examen0211.ej2;

public class Ciudad implements Comparable<Integer> {

	private int identificador;
	private String nombre;

	public int getIdentificador() {
		return identificador;
	}

	public Ciudad setIdentificador(int identificador) {
		this.identificador = identificador;
		return this;
	}

	public String getNombre() {
		return nombre;
	}

	public Ciudad setNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public Ciudad(int id, String n) {
		this.identificador = id;
		this.nombre = n;
	}

	@Override
	public int compareTo(Integer o) {
		return this.identificador - o;
	}

}
