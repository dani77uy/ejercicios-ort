package prcl20101213.ej1;

import org.junit.Before;
import org.junit.Test;

public class TestGrafo {

	private Grafo grafo = new Grafo(5);

	@Before
	public void setUp() {
		for (int i = 0; i < 5; i++)
			grafo.agregarNodo(i);
		grafo.agregarArco(1, 5, 24);
		grafo.agregarArco(5, 4, 6);
		grafo.agregarArco(1, 2, 10);
		grafo.agregarArco(2, 5, 11);
		grafo.agregarArco(2, 3, 8);
		grafo.agregarArco(3, 5, 12);
	}

	@Test
	public void test() {
		System.out.println(grafo.getMatrizDeAdyadencia());
		System.out.println(grafo.caminosPosibles(1, 4));
		System.out.println(grafo.costoMinimo(1, 4));
	}

}
