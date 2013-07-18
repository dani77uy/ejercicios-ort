package practico4;

import java.util.NoSuchElementException;

public class Queue<K> {

	private Node first;
	private Node last;
	
	public Queue(){}

	public void enqueue(K k){
		Node oldLast = this.last;
		this.last = new Node();
		this.last.item = k;
		if (this.isEmpty())
			this.first = this.last;
		else
			oldLast.next = this.last;
	}
	
	public boolean isEmpty(){
		return this.first == null;
	}
	
	public K front(){
		if (this.isEmpty())
			throw new NoSuchElementException();
		return this.first.item;
	}
	
	public K back(){
		return this.last.item;
	}
	
	public K dequeue(){
		if (this.isEmpty())
			throw new NoSuchElementException();
		K item = this.first.item;
		this.first = this.first.next;
		if (this.isEmpty())
			this.last = null;
		return item;
	}
	
	private class Node{
		K item;
		Node next;
	}
	
}
