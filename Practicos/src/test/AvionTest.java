package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import practico4.Avion;
import practico4.Avion.Caso;

public class AvionTest {

	private Avion avion;

	@Before
	public void setUp() throws Exception {
		this.avion = new Avion(10);   	
	}

	@Test
	public void testReservarPara10() {
		this.agregarPasajeros(10);
		String expected = "1,2,3,4,5,6,7,8,9,10";
		String actual = avion.getAsientos().toString();
		assertEquals(expected,actual);
	}

	private void agregarPasajeros(int cant){
		for(int x=1;x<=cant;x++)
			this.avion.reservar(x, Caso.NUEVO);
	}
	
	@Test
	public void testReservarYQuitarYNoHayReservas(){
		this.agregarPasajeros(10);
		this.avion.reservar(7, Caso.DEVUELVE);
		this.avion.reservar(6, Caso.DEVUELVE);
		this.avion.reservar(2, Caso.DEVUELVE);
		String expected = "1,3,4,5,8,9,10";
		String actual = avion.getAsientos().toString();
		assertEquals(expected,actual);
	}
	
	@Test
	public void testReservasYEsperas(){
		this.agregarPasajeros(20);
		String expected1 = "1,2,3,4,5,6,7,8,9,10";
		String actual1 = avion.getAsientos().toString();
		String expected2 = "11,12,13,14,15,16,17,18,19,20";
		String actual2 = avion.getEspera().toString();
		assertEquals(expected1,actual1);
		assertEquals(expected2,actual2);
	}

	@Test
	public void testReservasYEsperasConCola1(){
		this.agregarPasajeros(15);
		this.avion.reservar(7, Caso.DEVUELVE);
		String expected1 = "1,2,3,4,5,6,8,9,10,11";
		String actual1 = avion.getAsientos().toString();
		String expected2 = "12,13,14,15";
		String actual2 = avion.getEspera().toString();
		assertEquals(expected1,actual1);
		assertEquals(expected2,actual2);
	}
	
	@Test
	public void testReservasYEsperasConCola2(){
		this.agregarPasajeros(15);
		this.avion.reservar(7, Caso.DEVUELVE);
		this.avion.reservar(13, Caso.DEVUELVE);
		String expected1 = "1,2,3,4,5,6,8,9,10,11";
		String actual1 = avion.getAsientos().toString();
		String expected2 = "12,13,14,15";
		String actual2 = avion.getEspera().toString();
		assertEquals(expected1,actual1);
		assertEquals(expected2,actual2);
	}
	
	@Test
	public void testReservasYEsperasConCola3(){
		this.agregarPasajeros(15);
		this.avion.reservar(7, Caso.DEVUELVE);
		this.avion.reservar(1, Caso.NUEVO);
		String expected1 = "1,2,3,4,5,6,8,9,10,11";
		String actual1 = avion.getAsientos().toString();
		String expected2 = "12,13,14,15,1";
		String actual2 = avion.getEspera().toString();
		assertEquals(expected1,actual1);
		assertEquals(expected2,actual2);
	}
	
	@Test
	public void testReservasYEsperasConCola4(){
		this.agregarPasajeros(15);
		this.avion.reservar(1, Caso.DEVUELVE);
		this.avion.reservar(3, Caso.DEVUELVE);
		this.avion.reservar(5, Caso.DEVUELVE);
		this.avion.reservar(7, Caso.DEVUELVE);
		this.avion.reservar(9, Caso.DEVUELVE);
		String expected1 = "2,4,6,8,10,11,12,13,14,15";
		String actual1 = avion.getAsientos().toString();
		String expected2 = "";
		String actual2 = avion.getEspera().toString();
		assertEquals(expected1,actual1);
		assertEquals(expected2,actual2);
	}
	
	@Test
	public void testReservasYEsperasConCola5(){
		this.agregarPasajeros(15);
		this.avion.reservar(1, Caso.DEVUELVE);
		this.avion.reservar(3, Caso.DEVUELVE);
		this.avion.reservar(5, Caso.DEVUELVE);
		this.avion.reservar(23, Caso.NUEVO);
		this.avion.reservar(7, Caso.DEVUELVE);
		this.avion.reservar(9, Caso.DEVUELVE);
		String expected1 = "2,4,6,8,10,11,12,13,14,15";
		String actual1 = avion.getAsientos().toString();
		String expected2 = "23";
		String actual2 = avion.getEspera().toString();
		assertEquals(expected1,actual1);
		assertEquals(expected2,actual2);
	}

}
