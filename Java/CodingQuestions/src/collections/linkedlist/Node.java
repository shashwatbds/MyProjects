package collections.linkedlist;

import java.util.Objects;

public class Node {

	private Node next;
	private String data;
	
	public Node(String data) {
		this.data = data;
	}
	
	public boolean hasNext() {
		return next != null;
	}
	
	public Node next() {
		return next;
	}
	
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return this.data;
	}

	@Override
	public int hashCode() {
		return Objects.hash(data, next);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		return Objects.equals(data, other.data);
	}
	
	
}
