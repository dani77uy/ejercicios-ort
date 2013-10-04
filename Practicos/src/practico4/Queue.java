package practico4;

import java.util.NoSuchElementException;

public class Queue<K extends Comparable<K>> {

	private Node first;
	private Node last;

	public Queue() {
	}

	public void enqueue(K k) {
		Node oldLast = this.last;
		this.last = new Node();
		this.last.item = k;
		if (this.isEmpty())
			this.first = this.last;
		else
			oldLast.next = this.last;
	}

	public boolean isEmpty() {
		return this.first == null;
	}

	public K front() {
		if (this.isEmpty())
			throw new NoSuchElementException();
		return this.first.item;
	}

	public K back() {
		return this.last.item;
	}

	public K dequeue() {
		if (this.isEmpty())
			throw new NoSuchElementException();
		K item = this.first.item;
		this.first = this.first.next;
		if (this.isEmpty())
			this.last = null;
		return item;
	}

	private class Node {
		K item;
		Node next;

		@Override
		public String toString() {
			return this.item.toString();
		}
	}

	@Override
	public String toString() {
		if (this.isEmpty())
			return "";
		StringBuilder s = new StringBuilder();
		Node node1 = this.first;
		Node node2 = this.last;
		if (node1!=node2)
			do {
				s.append(node1.item + ",");
				node1 = node1.next;
			} while (node1 != node2);
		s.append(this.last);
		return s.toString();
	}



}
