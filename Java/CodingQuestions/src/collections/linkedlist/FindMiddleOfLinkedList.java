package collections.linkedlist;

import java.util.Optional;

public class FindMiddleOfLinkedList {

	public static void main(String[] args) {

		Node linkedList = addToLinkedList(9);
		System.out.println(linkedList);
		Optional<String> middle = findMiddle(linkedList);
		System.out.println("Middle of Linked List is : "+middle.get());
	}

	private static Optional<String> findMiddle(Node head) {
		
		Node slowPointer = head;
		Node fastPointer = head;	
		while(fastPointer.hasNext() && fastPointer.next().hasNext()) {// checking if there are two elements after fast pointer node.
			slowPointer = slowPointer.next();
			fastPointer = fastPointer.next().next();
		}	
		return Optional.ofNullable(slowPointer.getData());
	}

	public static Node addToLinkedList(int n) {

		Node head = new Node("1");
	    Node current = head;

	    for (int i = 2; i <= n; i++) {
	        Node newNode = new Node(String.valueOf(i));
	        current.setNext(newNode);
	        current = newNode;
	    }

	    return head;
	}
}
