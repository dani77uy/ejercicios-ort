package test;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import practico4.Stack;

public class StackTest {

	private Stack stack;
	private Stack stackEmpty;
	
	@Before
	public void setUp() throws Exception {
		stack = new Stack();
		stackEmpty = new Stack();
		stack.push(10);
		stack.push(15);
		stack.push(20);
		stack.push(7);
		stack.push(3);
		stack.push(8);
		stack.push(2);
	}

	@Test
	public void testToString() {
		String expected = "2,8,3,7,20,15,10";
		String actual = stack.toString();
		assertEquals(expected, actual);
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testToStringEmpty(){
		stackEmpty.toString();
	}
	
	@Test
	public void testPush(){
		stack.push(23);
		String expected = "23,2,8,3,7,20,15,10";
		String actual = stack.toString();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testPushEmpty(){
		stackEmpty.push(23);
		String expected = "23";
		String actual = stackEmpty.toString();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testTop(){
		int actual = stack.top();
		int expected = 2;
		assertEquals(expected, actual);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testTopEmpty(){
		int actual = stackEmpty.top();
		System.out.println(actual);
	}
	
	@Test
	public void testPop(){
		stack.pop();
		int actual = stack.top();
		int expected = 8;
		assertEquals(expected, actual);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testClean(){
		stack.clean();
		System.out.println(stack.toString());
	}
	
	@Test
	public void testInsertItemToCleanStack(){
		stack.clean();
		stack.push(13);
		stack.push(45);
		String expected = "45,13";
		String actual = stack.toString();
		assertEquals(expected, actual);
	}

}
