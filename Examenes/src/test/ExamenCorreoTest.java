package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import email.Bandeja;
import email.Correo;

public class ExamenCorreoTest {


	private Correo c1, c2, c3, c4, c5, c6, c7, c8, c9, c10;
	private final Bandeja bandeja = new Bandeja();

	@Before
	public void setUp() throws Exception {
		List<Date> fechas = new ArrayList<Date>();
		fechas.add(new GregorianCalendar(2013, 0, 10).getTime()); //0
		fechas.add(new GregorianCalendar(2013, 1, 10).getTime()); //1
		fechas.add(new GregorianCalendar(2013, 2, 15).getTime()); //2
		fechas.add(new GregorianCalendar(2013, 0, 10).getTime()); //3
		fechas.add(new GregorianCalendar(2013, 2, 20).getTime()); //4
		fechas.add(new GregorianCalendar(2013, 1, 28).getTime()); //5
		fechas.add(new GregorianCalendar(2013, 5, 30).getTime()); //6
		fechas.add(new GregorianCalendar(2013, 4, 31).getTime()); //7
		fechas.add(new GregorianCalendar(2013, 6, 22).getTime()); //8
		fechas.add(new GregorianCalendar(2013, 9, 2).getTime());  //9
		c1 = new Correo(fechas.get(0), "daniel", "asunto1", "hola como te va?");
		c2 = new Correo(fechas.get(3), "roberto", "asunto2", "hola como te va?");
		c3 = new Correo(fechas.get(2), "carlos", "asunto3", "hola como te va?");
		c4 = new Correo(fechas.get(3), "alberto", "asunto4", "hola como te va?");
		c5 = new Correo(fechas.get(1), "diego", "asunto5", "hola como te va?");
		c6 = new Correo(fechas.get(5), "martin", "asunto6", "hola como te va?");
		c7 = new Correo(fechas.get(6), "daniel", "asunto7", "hola como te va?");
		c8 = new Correo(fechas.get(7), "luis", "asunto8", "hola como te va?");
		c9 = new Correo(fechas.get(8), "juan", "asunto9", "hola como te va?");
		c10 = new Correo(fechas.get(9), "pablo", "asunto10", "hola como te va?");
		bandeja.agregarCorreo(c1);
		bandeja.agregarCorreo(c2);
		bandeja.agregarCorreo(c6);
		bandeja.agregarCorreo(c7);
	}

	@Test
	public void testConsultarCorreo() {
		String remitente = "martin";
		boolean expected = true;
		boolean actual = bandeja.consultarCorreo(remitente);
		assertEquals(expected, actual);
	}

	@Test
	public void testListarCorreosDeDia() {
		Date fecha = new GregorianCalendar(2013, 0, 10).getTime();
		List<Correo> actual = bandeja.listarCorreosDeDia(fecha);
		List<Correo> expected = new ArrayList<Correo>();
		expected.add(c1);
		expected.add(c2);
		assertEquals(expected, actual);
	}

	@Test
	public void testHayCorreo() {
		Bandeja b = new Bandeja();
		boolean expected = false;
		boolean actual = b.hayCorreo();
		assertEquals(expected, actual);
	}

	@Test
	public void testCantidadCorreosPorFecha(){
		Date fecha = new GregorianCalendar(2013, 0, 10).getTime();
		int expected = 1;
		int actual = bandeja.getCantidadFecha(fecha);
		assertEquals(expected, actual);
	}
}
