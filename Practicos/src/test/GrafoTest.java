package test;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import util.GrafoMatriz;

public class GrafoTest {

	private static final int NODOS = 10;
	GrafoMatriz grafo = new GrafoMatriz(NODOS);

	@Before
	public void setUp() {
		for (int x = 1; x <= NODOS; x++)
			grafo.agregarVertice(x);
		Random r = new Random();
		for (int i = 0; i < NODOS; i++) {
			for (int j = 0; j < NODOS; j++) {
				if (i % 2 == 0 && j % 2 != 0) grafo.agregarArista(i, j, r.nextInt(100));
			}
		}
	}

	@Test
	public void testAgregar() {
		grafo.Mostrar_Matriz();
		System.out.println(grafo.caminoMinimo(2, 7));
	}

}
