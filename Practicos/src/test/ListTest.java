package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import practico3.ListaImpl;
import util.Lista;

public class ListTest {

	public ListaImpl lista1, lista2, lista3;

	@Before
	public void setUp() {
		lista1 = new ListaImpl();
		lista2 = new ListaImpl();
		lista3 = new ListaImpl();
		lista1.agregar(2);
		lista1.agregar(56);
		lista1.agregar(13);
		lista1.agregar(21);
		lista1.agregar(15);
		lista1.agregar(7);
		lista1.agregar(13);
		lista1.agregar(16);
		lista2.agregar(5);
		lista2.agregar(7);
		lista2.agregar(15);
		lista2.agregar(22);
		lista2.agregar(33);
		lista2.agregar(34);
		lista2.agregar(36);
		lista2.agregar(40);
		lista2.agregar(44);
		lista3.agregar(5);
		lista3.agregar(5);
		lista3.agregar(2);
		lista3.agregar(5);
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
	public void testBorrar5() {
		lista1.borrar(2);
		lista1.borrar(16);
		lista1.borrar(13);
		lista1.borrar(77);
		String expected = "56,21,15,7,13";
		String actual = lista1.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void testBorrar6() {
		lista1.borrar(2);
		lista1.borrar(2);
		lista1.borrar(2);
		String expected = "56,13,21,15,7,13,16";
		String actual = lista1.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void testBorrar7() {
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
	public void testBorrar8() {
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
	public void testLargo3() {
		lista1.borrar(21);
		lista1.agregar(86);
		int expected = 8;
		int actual = lista1.largo();
		assertEquals(expected, actual);
	}

	/*
	 * @Test public void testSnoc() { fail("Not yet implemented"); }
	 */

	@Test
	public void testInvertir1() {
		String actual = lista1.invertir().toString();
		String expected = "16,13,7,15,21,13,56,2";
		assertEquals(expected, actual);
	}

	@Test
	public void testInvertir2() {
		ListaImpl inv = (ListaImpl) lista1.invertir();
		inv.borrar(56);
		String actual = inv.toString();
		String expected = "16,13,7,15,21,13,2";
		assertEquals(expected, actual);
	}

	@Test
	public void testEstaOrdenada1() {
		boolean expected = true;
		boolean actual = lista2.estaOrdenada();
		assertEquals(expected, actual);
	}

	@Test
	public void testEstaOrdenada2() {
		boolean expected = false;
		boolean actual = lista1.estaOrdenada();
		assertEquals(expected, actual);
	}

	@Test
	public void testInsertarOrdenado1() {
		lista2.insertarOrdenado(26);
		String expected = "5,7,15,22,26,33,34,36,40,44";
		String actual = lista2.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void testInsertarOrdenado2() {
		lista2.insertarOrdenado(45);
		String expected = "5,7,15,22,33,34,36,40,44,45";
		String actual = lista2.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void testInsertarOrdenado3() {
		lista2.insertarOrdenado(2);
		String expected = "2,5,7,15,22,33,34,36,40,44";
		String actual = lista2.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void testInsertarOrdenado4() {
		lista2.insertarOrdenado(15);
		String expected = "5,7,15,15,22,33,34,36,40,44";
		String actual = lista2.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void testCuenta1() {
		int actual = lista1.cuenta(13);
		int expected = 2;
		assertEquals(expected, actual);
	}

	@Test
	public void testCuenta2() {
		lista1.insertarInicio(17);
		lista1.insertarInicio(17);
		lista1.borrar(17);
		lista1.insertarInicio(17);
		lista1.insertarInicio(17);
		int actual = lista1.cuenta(17);
		int expected = 3;
		assertEquals(expected, actual);
	}

	@Test
	public void testCuenta3() {
		int actual = lista1.cuenta(2);
		int expected = 1;
		assertEquals(expected, actual);
	}

	@Test
	public void testCuenta4() {
		int actual = lista1.cuenta(23);
		int expected = 0;
		assertEquals(expected, actual);
	}

	@Test
	public void testMaximo1() {
		int actual = lista1.maximo();
		int expected = 56;
		assertEquals(expected, actual);
	}

	@Test
	public void testMaximo2() {
		int actual = lista3.maximo();
		int expected = 5;
		assertEquals(expected, actual);
	}

	@Test
	public void testPromedio1() {
		int actual = 17;
		int expected = lista1.promedio();
		assertEquals(expected, actual);
	}

	@Test
	public void testPromedio2() {
		lista1.insertarInicio(7);
		int actual = 16;
		int expected = lista1.promedio();
		assertEquals(expected, actual);
	}

	@Test(expected = ArithmeticException.class)
	public void testPromedio3() {
		ListaImpl l = new ListaImpl();
		int expected = l.promedio();
		System.out.println(expected);
	}

	@Test
	public void testPromedio4() {
		ListaImpl l = new ListaImpl();
		final int x = 22;
		l.insertarInicio(x);
		int actual = x;
		int expected = l.promedio();
		assertEquals(expected, actual);
	}

	@Test
	public void testTomar_n1() {
		int actual = 2;
		int expected = lista1.tomar_n(1);
		assertEquals(expected, actual);
	}

	@Test
	public void testTomar_n2() {
		int actual = 21;
		int expected = lista1.tomar_n(4);
		assertEquals(expected, actual);
	}

	@Test
	public void testTomar_n3() {
		int actual = 13;
		int expected = lista1.tomar_n(3);
		assertEquals(expected, actual);
	}

	@Test
	public void testTomar_n4() {
		int actual = 16;
		int expected = lista1.tomar_n(8);
		assertEquals(expected, actual);
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testTomar_n5() {
		int actual = 16;
		int expected = lista1.tomar_n(10);
		assertEquals(expected, actual);
	}

	@Test
	public void testCambiar1() {
		Lista listaCambiada = (Lista) lista1.cambiar(13, 73);
		String actual = listaCambiada.toString();
		String expected = "2,56,73,21,15,7,73,16";
		assertEquals(expected, actual);
	}

	@Test
	public void testCambiar2() {
		Lista listaCambiada = (Lista) lista1.cambiar(42, 73);
		String actual = listaCambiada.toString();
		String expected = "2,56,13,21,15,7,13,16";
		assertEquals(expected, actual);
	}

	@Test
	public void testCambiar3() {
		ListaImpl l = new ListaImpl();
		l.insertarInicio(23);
		l.insertarInicio(23);
		l.insertarInicio(23);
		l.insertarInicio(23);
		Lista lc = l.cambiar(23, 20);
		String expected = "20,20,20,20";
		String actual = lc.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void testCambiar4() {
		ListaImpl v = new ListaImpl();
		Lista lc = v.cambiar(3, 7);
		String expected = "";
		String actual = lc.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void testIguales1() {
		ListaImpl l1 = new ListaImpl();
		l1.agregar(2);
		l1.agregar(56);
		l1.agregar(13);
		l1.agregar(21);
		l1.agregar(15);
		l1.agregar(7);
		l1.agregar(13);
		l1.agregar(16);
		boolean expected = true;
		boolean actual = ListaImpl.iguales(lista1, l1);
		assertEquals(expected, actual);
	}

	@Test
	public void testIguales2() {
		ListaImpl l1 = new ListaImpl(), l2 = new ListaImpl();
		boolean expected = true;
		boolean actual = ListaImpl.iguales(l2, l1);
		assertEquals(expected, actual);
	}

	@Test
	public void testIguales3() {
		ListaImpl l1 = new ListaImpl();
		boolean expected = false;
		boolean actual = ListaImpl.iguales(lista1, l1);
		assertEquals(expected, actual);
	}

	@Test
	public void testIguales4() {
		ListaImpl l1 = new ListaImpl(), l2 = new ListaImpl();
		l1.insertarInicio(12);
		l2.insertarInicio(12);
		boolean expected = true;
		boolean actual = ListaImpl.iguales(l2, l1);
		assertEquals(expected, actual);
	}

	@Test
	public void testIguales5() {
		ListaImpl l1 = new ListaImpl(), l2 = new ListaImpl();
		l1.insertarInicio(12);
		l2.insertarInicio(12);
		l1.insertarInicio(15);
		l2.insertarInicio(14);
		l1.insertarInicio(14);
		l2.insertarInicio(15);
		l1.borrar(15);
		l1.borrar(14);
		l2.borrar(15);
		l2.borrar(14);
		l2.borrar(20);
		boolean expected = true;
		boolean actual = ListaImpl.iguales(l2, l1);
		assertEquals(expected, actual);
	}

	@Test
	public void testIntercalar1() {
		int[] i1 = { 1, 5, 6, 7, 2, 5, 12 };
		int[] i2 = { 7, 4, 11, 0, 3, 5, 10, 12 };
		ListaImpl l = new ListaImpl(i1, true);
		ListaImpl p = new ListaImpl(i2, true);
		String expected = "0,1,2,3,4,5,5,5,6,7,7,10,11,12";
		String actual = ListaImpl.intercalar(l, p).toString();
		assertEquals(expected, actual);
	}

	@Test
	public void testIntercalar2() {
		int[] i1 = { 2, 5, 1, 2 };
		int[] i2 = { 1, 0 };
		ListaImpl l = new ListaImpl(i1, true);
		ListaImpl p = new ListaImpl(i2, true);
		String expected = "0,1,1,2,2,5";
		String actual = ListaImpl.intercalar(l, p).toString();
		assertEquals(expected, actual);
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
