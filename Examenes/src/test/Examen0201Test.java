package test;

import static examen0211.ej2.CiudadesMaster.CIUDADES;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import examen0211.ej1.ABB;
import examen0211.ej1.Lista;
import examen0211.ej2.Ciudad;
import examen0211.ej2.Grafo;
import examen0211.ej2.Vuelo;

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

	/**
	 * Construir grafo vacio
	 */
	@Test
	public void testEj2_a() {
		Grafo grafo = new Grafo(10);
		boolean esperado = true;
		boolean actual = grafo.esVacio();
		assertEquals(esperado, actual);
	}

	/**
	 * Ciudad si pertence al grafo
	 */
	@Test/*(expected=NoSuchElementException.class)*/
	public void testEj2_c() {
		Grafo grafo = new Grafo(4);
		for (int i = 0; i < 4; i++)
			grafo.agregarCiudad(CIUDADES.get(i));
		int idC = 4;
		boolean esperado = true;
		boolean actual = grafo.pertenece(idC);
		assertEquals(esperado, actual);
	}

	/**
	 * Agregar una ciudad
	 */
	@Test(expected=NoSuchElementException.class)
	public void testEj2_d(){
		Grafo grafo = new Grafo(4);
		for (int i = 0; i < 4; i++)
			grafo.agregarCiudad(CIUDADES.get(i));
		grafo.agregarCiudad(CIUDADES.get(2));
		List<Ciudad> esperado = Arrays.asList(CIUDADES.get(0),CIUDADES.get(1),CIUDADES.get(2),CIUDADES.get(3));
		List<Ciudad> actual = grafo.getCiudades();
		assertEquals(esperado, actual);
	}

	/**
	 * Eliminar una ciudad del grafo
	 */
	@Test
	public void testEj2_e(){
		final int max = 10;
		final Grafo grafo = new Grafo(max);
		for (int i = 0; i < max; i++)
			grafo.agregarCiudad(CIUDADES.get(i));
		final List<Vuelo> todosVuelos = new ArrayList<Vuelo>();
		final Vuelo vuelo1 = new Vuelo(CIUDADES.get(1), CIUDADES.get(3), 100);
		final Vuelo vuelo2 = new Vuelo(CIUDADES.get(0), CIUDADES.get(4), 365);
		final Vuelo vuelo3 = new Vuelo(CIUDADES.get(2), CIUDADES.get(8), 104);
		final Vuelo vuelo4 = new Vuelo(CIUDADES.get(9), CIUDADES.get(4), 225);
		final Vuelo vuelo5 = new Vuelo(CIUDADES.get(5), CIUDADES.get(6), 489);
		final Vuelo vuelo6 = new Vuelo(CIUDADES.get(2), CIUDADES.get(0), 214);
		final Vuelo vuelo7 = new Vuelo(CIUDADES.get(7), CIUDADES.get(5), 229);
		final Vuelo vuelo8 = new Vuelo(CIUDADES.get(3), CIUDADES.get(4), 199);
		final Vuelo vuelo9 = new Vuelo(CIUDADES.get(9), CIUDADES.get(1), 364);	
		final int idCiudadAQuitar = 2; // bs as
		todosVuelos.add(vuelo1);  // bs as - asu
		todosVuelos.add(vuelo2);  // mvd- san
		todosVuelos.add(vuelo3);  // bra - la paz
		todosVuelos.add(vuelo4);  // car - san
		todosVuelos.add(vuelo5);  // lima - quito
		todosVuelos.add(vuelo6);  // bra - mvd
		todosVuelos.add(vuelo7);  // bog - lima
		todosVuelos.add(vuelo8);  // asu - san
		todosVuelos.add(vuelo9);  // car - bs as
		for(int x=0;x<todosVuelos.size();x++)
			grafo.agregarVuelo(todosVuelos.get(x));
		List<Vuelo> esperadoVuelos = new ArrayList<Vuelo>();
		for(int x=0;x<todosVuelos.size();x++){
			Vuelo v = todosVuelos.get(x);
			if (!(v.getCiudad1().getIdentificador()==idCiudadAQuitar || v.getCiudad2().getIdentificador()==idCiudadAQuitar)){
				esperadoVuelos.add(v);
			}
		}
		grafo.eliminarCiudad(CIUDADES.get(idCiudadAQuitar-1));
		final List<Ciudad> esperado = new ArrayList<Ciudad>();
		for(int x=0;x<max;x++)
			if (x!=idCiudadAQuitar-1)
				esperado.add(CIUDADES.get(x));
		final List<Ciudad> actual = grafo.getCiudades();
		assertEquals(esperado, actual);
		/*	List<Vuelo> actualVuelos = grafo.getVuelos();
		Collections.sort(esperadoVuelos, Vuelo.comparadorDeVuelos);
		Collections.sort(actualVuelos, Vuelo.comparadorDeVuelos);
		System.out.println("TODOS:    " + todosVuelos);
		System.out.println("ESPERADO: " + esperadoVuelos);
		System.out.println("ACTUAL:   " + actualVuelos);
		assertEquals(esperadoVuelos,actualVuelos);
		*/
	}
	
	/**
	 * Verificar vuelos
	 */
	@Test
	public void testEj2_f(){
		final int max = 10;
		final Grafo grafo = new Grafo(max);
		for (int i = 0; i < max; i++)
			grafo.agregarCiudad(CIUDADES.get(i));
		final List<Vuelo> todosVuelos = new ArrayList<Vuelo>();
		final Vuelo vuelo1 = new Vuelo(CIUDADES.get(1), CIUDADES.get(3), 100);
		final Vuelo vuelo2 = new Vuelo(CIUDADES.get(0), CIUDADES.get(4), 365);
		final Vuelo vuelo3 = new Vuelo(CIUDADES.get(2), CIUDADES.get(8), 104);
		final Vuelo vuelo4 = new Vuelo(CIUDADES.get(9), CIUDADES.get(4), 225);
		final Vuelo vuelo5 = new Vuelo(CIUDADES.get(5), CIUDADES.get(6), 489);
		final Vuelo vuelo6 = new Vuelo(CIUDADES.get(2), CIUDADES.get(0), 214);
		final Vuelo vuelo7 = new Vuelo(CIUDADES.get(7), CIUDADES.get(5), 229);
		final Vuelo vuelo8 = new Vuelo(CIUDADES.get(3), CIUDADES.get(4), 199);
		final Vuelo vuelo9 = new Vuelo(CIUDADES.get(9), CIUDADES.get(1), 364);	
		todosVuelos.add(vuelo1);  // bs as - asu
		todosVuelos.add(vuelo2);  // mvd- san
		todosVuelos.add(vuelo3);  // bra - la paz
		todosVuelos.add(vuelo4);  // car - san
		todosVuelos.add(vuelo5);  // lima - quito
		todosVuelos.add(vuelo6);  // bra - mvd
		todosVuelos.add(vuelo7);  // bog - lima
		todosVuelos.add(vuelo8);  // asu - san
		todosVuelos.add(vuelo9);  // car - bs as
		for(int x=0;x<todosVuelos.size();x++)
			grafo.agregarVuelo(todosVuelos.get(x));
		boolean esperado = true;
		boolean actual = grafo.existeVuelo(CIUDADES.get(7), CIUDADES.get(5));
		assertEquals(esperado, actual);
	}
	
	/**
	 * Agregar vuelo
	 */
	@Test
	public void testEj2_g(){
		final int max = 10;
		final Grafo grafo = new Grafo(max);
		Ciudad c1 = CIUDADES.get(11);
		Ciudad c2 = CIUDADES.get(3);
		int precio = 455;
	}



}
