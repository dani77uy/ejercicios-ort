package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import practico3.ListaImpl;

public class ListTest {

	public ListaImpl lista1;
	
	@Before
	public void setUp(){
		lista1 = new ListaImpl();
		lista1.agregar(2);
		lista1.agregar(56);
		lista1.agregar(13);
		lista1.agregar(21);
		lista1.agregar(15);
		lista1.agregar(7);
		lista1.agregar(13);
		lista1.agregar(16);
	}
	
	@Test
	public void testBorrar1() {
		lista1.borrar(21);
		String expected = "2,56,13,15,7,13,16";
		String actual = lista1.toString();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testBorrar2() {
		lista1.borrar(13);
		String expected = "2,56,21,15,7,13,16";
		String actual = lista1.toString();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testBorrar3() {
		lista1.borrar(2);
		String expected = "56,13,21,15,7,13,16";
		String actual = lista1.toString();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testBorrar4() {
		lista1.borrar(16);
		String expected = "2,56,13,21,15,7,13";
		String actual = lista1.toString();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testBorrar5(){
		lista1.borrar(2);
		lista1.borrar(16);
		lista1.borrar(13);
		lista1.borrar(77);
		String expected = "56,21,15,7,13";
		String actual = lista1.toString();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testBorrar6(){
		lista1.borrar(2);
		lista1.borrar(2);
		lista1.borrar(2);
		String expected = "56,13,21,15,7,13,16";
		String actual = lista1.toString();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testBorrar7(){
		lista1.borrar(2);
		lista1.borrar(56);
		lista1.borrar(13);
		lista1.borrar(21);
		lista1.borrar(15);
		lista1.borrar(7);
		lista1.borrar(13);
		lista1.borrar(16);
		String expected = "";
		String actual = lista1.toString();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testBorrar8(){
		lista1.borrar(21);
		lista1.agregar(86);
		String expected = "2,56,13,15,7,13,16,86";
		String actual = lista1.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void testLargo1() {
		int actual = lista1.largo();
		int expected = 8;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testLargo2() {
		lista1.borrar(56);
		int actual = lista1.largo();
		int expected = 7;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testLargo3(){
		lista1.borrar(21);
		lista1.agregar(86);
		int expected = 8;
		int actual = lista1.largo();
		assertEquals(expected, actual);
	}

	/*@Test
	public void testSnoc() {
		fail("Not yet implemented");
	}*/

	@Test
	public void testInvertir1() {
		String actual = lista1.invertir().toString();
		String expected = "16,13,7,15,21,13,56,2";
		assertEquals(expected, actual);
	}
	
	@Test
	public void testInvertir2() {
		ListaImpl inv = (ListaImpl)lista1.invertir();
		inv.borrar(56);
		String actual = inv.toString();
		String expected = "16,13,7,15,21,13,2";
		assertEquals(expected, actual);
	}

	@Test
	public void testEstaOrdenada() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertarOrdenado() {
		fail("Not yet implemented");
	}

	@Test
	public void testCuenta() {
		fail("Not yet implemented");
	}

	@Test
	public void testMaximo() {
		fail("Not yet implemented");
	}

	@Test
	public void testPromedio() {
		fail("Not yet implemented");
	}

	@Test
	public void testTomar_n() {
		fail("Not yet implemented");
	}

	@Test
	public void testCambiar() {
		fail("Not yet implemented");
	}

	@Test
	public void testIguales() {
		fail("Not yet implemented");
	}

	@Test
	public void testIntercalar() {
		fail("Not yet implemented");
	}

	@Test
	public void testConcatenar() {
		fail("Not yet implemented");
	}

	@Test
	public void testLista() {
		fail("Not yet implemented");
	}

	@Test
	public void testAgregar() {
		fail("Not yet implemented");
	}

	@Test
	public void testEliminar() {
		fail("Not yet implemented");
	}

	@Test
	public void testEsVacia() {
		fail("Not yet implemented");
	}

	@Test
	public void testVaciar() {
		fail("Not yet implemented");
	}

	@Test
	public void testExiste() {
		fail("Not yet implemented");
	}

	@Test
	public void testElementoInicial() {
		fail("Not yet implemented");
	}

	@Test
	public void testClone() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAnterior() {
		fail("Not yet implemented");
	}

	@Test
	public void testMostrar() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUltimoNodo() {
		fail("Not yet implemented");
	}

	@Test
	public void testQuitarInicio() {
		fail("Not yet implemented");
	}

	@Test
	public void testAgregarAlFinal() {
		fail("Not yet implemented");
	}

	@Test
	public void testEstaIncluida() {
		fail("Not yet implemented");
	}

}
