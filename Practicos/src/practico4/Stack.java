package practico4;

import java.util.NoSuchElementException;

public class Stack {

	private Node first;

	/**
	 * 
	 * @return boolean Ejercicio 2
	 */
	public boolean isEmpty() {
		return first == null;
	}

	/**
	 * Ejercicio 2
	 */
	public Stack() {
		this.first = null;
	}

	/**
	 * 
	 * @param item
	 * Ejercicio 2
	 */
	public void push(int item) {
		Node node = this.first;
		this.first = new Node();
		this.first.item = item;
		this.first.next = node;
	}

	/**
	 * 
	 * @return 
	 * int Ejercicio 2
	 */
	public int top() {
		if (this.isEmpty())
			throw new NoSuchElementException();
		else
			return this.first.item;
	}

	/**
	 * Ejercicio 2
	 */
	public void pop(){
		if (this.isEmpty())
			throw new NoSuchElementException();
		else {
			this.first = this.first.next;
		}
	}

	/**
	 * Ejercicio 2
	 */
	public void clean(){
		this.clean(this);
	}

	private void clean(Stack stack){
		if (!stack.isEmpty()){
			stack.pop();
			this.clean(stack);
		}
	}

	@Override
	public String toString(){
		Node node = this.first;
		if (node == null)
			throw new NoSuchElementException();
		StringBuilder sb = new StringBuilder();
		while (node != null){
			sb.append(node.item);
			if (node.next!=null)
				sb.append(',');
			node = node.next;
		}
		return sb.toString();
	}

	private class Node {
		int item;
		Node next;
		public String toString(){
			return String.valueOf(item);
		}
	}
}
