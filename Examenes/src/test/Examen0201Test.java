package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import examen0211.ej1.ABB;
import examen0211.ej1.Lista;

public class Examen0201Test {

	private ABB arbol = new ABB();
	private Lista l1 = new Lista(), l2 = new Lista();

	@Before
	public void setUp() throws Exception {
		arbol.insertar(10);
		arbol.insertar(6);
		arbol.insertar(18);
		arbol.insertar(9);
		arbol.insertar(4);
		arbol.insertar(15);
		arbol.insertar(21);
		int[] datos1 = { 4, 8, 9, 13, 14, 16, 17, 18, 20, 24, 25, 26, 30, 32,
				40, 43, 45, 47, 50 };
		int[] datos2 = { 13, 17, 25, 26, 32, 45 };
		l1.setDatos(datos1);
		l2.setDatos(datos2);
	}

	@Test
	public void testEj1_a1() {
		int k = 15;
		Lista lista = new Lista();
		lista.agregar(10);
		lista.agregar(18);
		lista.agregar(k);
		String esperado = lista.toString();
		String actual = arbol.listaCamino(k).toString();
		assertEquals(esperado, actual);
	}

	@Test
	public void testEj1_a2() {
		int k = 5;
		Lista lista = new Lista();
		// lista.agregar(10);
		// lista.agregar(6);
		// lista.agregar(k);
		String esperado = lista.toString();
		String actual = arbol.listaCamino(k).toString();
		assertEquals(esperado, actual);
	}

	@Test
	public void testEj1_b1() {
		boolean esperado = true;
		boolean actual = Lista.incluida(l1, l2);
		assertEquals(esperado, actual);
	}
	
	@Test
	public void testEj1_b2() {
		l1 = new Lista();
		l1.agregar(10);
		l2 = new Lista();
		boolean esperado = true;
		boolean actual = Lista.incluida(l1, l2);
		assertEquals(esperado, actual);
	}

}
