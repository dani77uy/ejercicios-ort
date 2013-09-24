package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import util.ABB;

public class ArbolTest {

	ABB<Integer> arbolito = new ABB<Integer>();

	@Before
	public void setUp() throws Exception {
		arbolito.insertar(8);
		arbolito.insertar(3);
		arbolito.insertar(6);
		arbolito.insertar(1);
		arbolito.insertar(10);
		arbolito.insertar(4);
		arbolito.insertar(7);
		arbolito.insertar(14);
		arbolito.insertar(13);
	}

	@Test
	public void testInsertar() {
		String expected = "831647101413";
		String actual = arbolito.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void testCantidadNodos() {
		int expected = 9;
		int actual = arbolito.cantidadNodos();
		assertEquals(expected, actual);
	}

	@Test
	public void testPostOrder() {
		String expected = "147631314108";
		String actual = arbolito.postorder();
		assertEquals(expected, actual);
	}

	@Test
	public void testInOrder() {
		String expected = "134678101314";
		String actual = arbolito.inorder();
		assertEquals(expected, actual);
	}

	@Test
	public void testCantidadHojas() {
		int expected = 4;
		int actual = arbolito.cantidadHojas();
		assertEquals(expected, actual);
	}

	@Test
	public void testAltura() {
		int expected = 4;
		int actual = arbolito.altura();
		assertEquals(expected, actual);
	}

	@Test
	public void testPertenece1() {
		boolean expected = true;
		boolean actual = arbolito.pertenece(8) && arbolito.pertenece(3)
				&& arbolito.pertenece(6) && arbolito.pertenece(1)
				&& arbolito.pertenece(10) && arbolito.pertenece(4)
				&& arbolito.pertenece(7) && arbolito.pertenece(14)
				&& arbolito.pertenece(13);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testPertenece2() {
		boolean expected = false;
		boolean actual = arbolito.pertenece(8) && arbolito.pertenece(3)
				&& arbolito.pertenece(6) && arbolito.pertenece(1)
				&& arbolito.pertenece(16) && arbolito.pertenece(4)
				&& arbolito.pertenece(7) && arbolito.pertenece(14)
				&& arbolito.pertenece(13);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testBorrarElemento1(){
		int elemento = 10;
		arbolito.borrarElemento(elemento);
		String expected = "8316471413";
		String actual = arbolito.toString();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testBorrarElemento2(){
		int elemento = 8;
		arbolito.borrarElemento(elemento);
		String expected = "10316471413";
		String actual = arbolito.toString();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testBorrarElemento3(){
		int elemento = 6;
		arbolito.borrarElemento(elemento);
		String expected = "83174101413";
		String actual = arbolito.toString();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testBorrarMinimo(){
		arbolito.borrarMinimo();
		String expected = "83647101413";
		String actual = arbolito.toString();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testListar(){
		arbolito.listarAscendente();
		arbolito.listarDescendente();
	}

}
