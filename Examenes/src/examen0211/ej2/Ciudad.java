package examen0211.ej2;

public class Ciudad implements Comparable<Integer>{

	private int identificador;
	private String nombre;
	
	public int getIdentificador() {
		return identificador;
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public int compareTo(Integer o) {
		return this.identificador - o;
	}
	
	
}
