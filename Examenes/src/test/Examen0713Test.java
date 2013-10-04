package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import examen0713.ej4.Ejercicio4;

public class Examen0713Test {

	int matriz[][] = new int[4][4];
	int vector[] = { 3, 7, 11, 15 };

	@Before
	public void setUp() throws Exception {
		int c = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				matriz[i][j] = c + 1;
				c++;
			}
		}
	}

	@Test
	public void testAlgoritmo2() {
		int actual = Ejercicio4.algoritmo2(matriz, vector);
		int expected = 3;
		assertEquals(expected, actual);
	}

}
