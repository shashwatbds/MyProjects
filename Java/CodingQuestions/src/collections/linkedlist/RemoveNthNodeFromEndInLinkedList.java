package collections.linkedlist;

public class RemoveNthNodeFromEndInLinkedList {

	public static void main(String[] args) {

		Node head1 = new Node("1");
		Node n11 = new Node("2");head1.setNext(n11);
		Node n12 = new Node("3");n11.setNext(n12);
		Node n13 = new Node("4");n12.setNext(n13);
		Node n14 = new Node("5");n13.setNext(n14);
		head1 = remove(head1, 2);//remove 4 - 1,2,3,4,5 --> 1,2,3,5
	}
	
	private static int countNodes(Node head) {
		int count = 1;
		Node slowPointer = head;
		Node fastPointer = head;
		while(fastPointer.hasNext() && fastPointer.next().hasNext()) {
			slowPointer = slowPointer.getNext();
			fastPointer = fastPointer.getNext().getNext();
			count +=2;
		}
		if(fastPointer.hasNext()) {
			count++;
		}
		return count;
	}

	private static Node removeNodeAtIndex(Node head, int count) {
		
		while(count > 1) {
			head = head.getNext();
			count--;
		}
		head.setNext(head.getNext().getNext());
		return head;
	}
	private static Node remove(Node head, int index) {

		if(head==null) {
			return null;
		}
		if(head.getNext() == null ) {
			return null;
		}
		
		if(index<0) {
			return null;
		}
		
		int count = countNodes(head);
		if(index > count) {
			return null;
		}
		int removeIndex = count - index;
		return removeNodeAtIndex(head, removeIndex);
	}

}
