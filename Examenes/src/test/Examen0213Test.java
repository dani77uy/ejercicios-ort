package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import examen0213.ej2.Ejercicio2;
import examen0213.ej3.Ejercicio3;
import examen0213.ej3.Lista;

public class Examen0213Test {

	private Lista lista = new Lista();

	@Before
	public void setUp() throws Exception {
		lista.agregar(4);
		lista.agregar(3);
		lista.agregar(5);
		lista.agregar(2);
		lista.agregar(6);
	}

	@Test
	public void testSumaEnteros() {
		int expected = 15;
		int actual = Ejercicio3.sumaEnteros(lista, 3);
		assertEquals(expected, actual);
	}

	@Test
	public void testSelectionSort() {
		int v[] = { 27, 3, 12, 34, 56, 2, 5, 9, 8, 26 };
		int expected[] = { 2, 3, 5, 8, 9, 12, 26, 27, 34, 56 };
		Ejercicio2.selectionSort(v);
		int actual[] = v;
//		assertEquals(expected, actual);
	}


	@Test
	public void testBubbleSort(){
		int v[] = { 27, 3, 12, 34, 56, 2, 5, 9, 8, 26 };
		int expected[] = { 2, 3, 5, 8, 9, 12, 26, 27, 34, 56 };
		Ejercicio2.bubbleSort2(v);
		int actual[] = v;
		assertEquals(expected, actual);
	}
	
	
	
}
