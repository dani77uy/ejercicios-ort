package util;

import java.util.NoSuchElementException;

public class LinkedList {

	private Node first;
	private Node last;

	public void linkFirst(int element) {
		final Node f = this.first;
		final Node newNode = new Node(f, null, element);
		this.first = newNode;
		if (f == null)
			this.last = newNode;
		else
			f.prev = newNode;
	}

	public void linkLast(int element) {
		final Node l = this.last;
		final Node newNode = new Node(null, l, element);
		this.last = newNode;
		if (l == null)
			this.first = newNode;
		else
			l.next = newNode;
	}

	public int getFirst() {
		final Node f = this.first;
		if (f == null)
			throw new NoSuchElementException();
		return f.element;
	}
	
	public int getLast(){
		final Node l = this.last;
		if (l == null)
			throw new NoSuchElementException();
		return l.element;
	}
	
	public void insertFirst(int element){
		final Node f = this.first;
		final Node newNode = new Node(f,null,element);
		this.first = newNode;
		if (f == null)
			last = newNode;
		else
			f.prev = newNode;
		
	}

	private static class Node {
		Node next;
		Node prev;
		int element;

		Node(Node next, Node prev, int element) {
			this.next = next;
			this.prev = prev;
			this.element = element;
		}
	}

}
