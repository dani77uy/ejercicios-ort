package util;

/**
 *
 * @author Vicky
 */
public class Arco {

	public boolean existe;
	public int peso;

	public Arco() {
		super();
		this.existe = false;
		this.peso = 0;
	}

	public Arco(boolean existe, int peso) {
		this.existe = existe;
		this.peso = peso;
	}

}
