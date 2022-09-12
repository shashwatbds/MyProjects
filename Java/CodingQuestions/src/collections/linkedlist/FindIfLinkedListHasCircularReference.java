package collections.linkedlist;

public class FindIfLinkedListHasCircularReference {

	public static boolean hasCircularReference(Node head) {
		Node hare = head.next();
        Node tortoise = head;
        while( hare != tortoise )
        {
            if(hare==null || hare.next()==null) return false;
            hare = hare.next().next();
            tortoise = tortoise.next();
        }
        return true;
	}

	public static void main(String[] args) {
		Node head = addToLinkedList(10);
		Node current = head;
		while(current.hasNext()) {
			System.out.println(current);
			current = current.next();
		}
		System.out.println(hasCircularReference(head));
//		System.out.println(hasCircularReference(FindMiddleOfLinkedList.addToLinkedList(10)));
	}

	public static Node addToLinkedList(int n) {

		Node head = new Node("1");
		Node current = head;

		for (int i = 2; i <= 10; i++) {
			if(i<9) {
				Node newNode = new Node(String.valueOf(i));
				current.setNext(newNode);
				current = newNode;
			} else {
				Node newNode = new Node(String.valueOf(7));
				current.setNext(newNode);
				current = newNode;
			}
		}

		return head;
	}

}
