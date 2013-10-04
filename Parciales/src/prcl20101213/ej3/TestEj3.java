package prcl20101213.ej3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestEj3 {

	private final int[] v = {8, 3, 10, 9, 4, 2, 6, 7, 1, 51, 15, 22, 364, 48, 10, 5, 2, -5, 17, 18, 19, 25, 11, 159,152 };

	@Test
	public void test() {
		int expected = 152;
		int actual = Ejercicio3.sumaPares(v, v.length - 2, v.length - 1);
		assertEquals(expected, actual);
	}

}
