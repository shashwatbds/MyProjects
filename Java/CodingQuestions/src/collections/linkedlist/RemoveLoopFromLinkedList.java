package collections.linkedlist;

public class RemoveLoopFromLinkedList {

	public static void main(String[] args) {

		Node head = addToLinkedList(10);
		int i = findCircularReference(head);
		System.out.println("Loop at index "+i);
	}


	private static int findCircularReference(Node head) {

		Node hare = head.getNext(), tortoise=head;
		int index = 1;
		while(tortoise!=hare) {
			if(hare == null || tortoise == null) return 0;
			if(hare.hasNext()) {
				hare = hare.next().next();
				tortoise = tortoise.next();
				index +=1;
			}
		}
		if(index!=0) {
			hare.getPrevious().setNext(null);
			return index;
		}
		return index;
	}


	public static Node addToLinkedList(int n) {

		Node head = new Node("1");
		Node previous = null;
		head.setPrevious(previous);
		Node current = head;
		Node repeatingNode = null;

		for (int i = 2; i <= 9; i++) {
			if(i<9) {
				Node newNode = new Node(String.valueOf(i));
				current.setNext(newNode);
				newNode.setPrevious(current);
				current = newNode;
				if(i==7) {
					repeatingNode = current;
				}
			} else {
				Node newNode = repeatingNode;
				current.setNext(newNode);
				newNode.setPrevious(current);
			}
		}

		return head;
	}
}
