package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import practico4.Queue;

public class QueueTest {
	
	private Queue<String> queue,queue1;

	@Before
	public void setUp() throws Exception {
		this.queue = new Queue<String>();
		this.queue1 = new Queue<String>();
		queue.enqueue("daniel");
		queue.enqueue("sergio");
		queue.enqueue("fabiana");
		queue.enqueue("cristina");
		queue.enqueue("silvana");
		queue.enqueue("shake");
		queue1.enqueue("fabrizio");
	}

	@Test
	public void testEnqueue1() {
		String expected = "daniel,sergio,fabiana,cristina,silvana,shake";
		String actual = queue.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void testEnqueue2(){
		String expected = "fabrizio";
		String actual = queue1.toString();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testEnqueue3(){
		String expected = "";
		Queue<Integer> qi = new Queue<Integer>();
		String actual = qi.toString();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIsEmpty() {
		boolean expected = true;
		Queue<Integer> qi = new Queue<Integer>();
		boolean actual = qi.isEmpty();
		assertEquals(expected, actual);
	}

	@Test
	public void testFront() {
		String expected = "daniel";
		String actual = this.queue.front();
		assertEquals(expected, actual);
	}

	@Test
	public void testBack() {
		String expected = "shake";
		String actual = this.queue.back();
		assertEquals(expected, actual);
	}

	@Test
	public void testDequeue() {
		fail("Not yet implemented");
	}

}
