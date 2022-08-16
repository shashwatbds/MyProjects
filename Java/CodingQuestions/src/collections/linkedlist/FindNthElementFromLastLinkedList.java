package collections.linkedlist;

public class FindNthElementFromLastLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = FindMiddleOfLinkedList.addToLinkedList(9);
		System.out.println(findnthElementFromLast(head, 3));
		System.out.println(findnthElementFromLast(head, 2));
	}

	//This will work if the last element is in second half of the list. For other case we need to implement node. previous also.
	private static String findnthElementFromLast(Node head, int i) {

		Node slowPointer = head;
		Node fastPointer = head;
		int fastlen = 1;
		int slowlen = 1;
		while(fastPointer.hasNext() && fastPointer.next().hasNext()) {
			slowPointer = slowPointer.next();
			fastPointer = fastPointer.next().next();
			slowlen+=1;
			fastlen+=2;
		}
		int targetIndex = fastlen-i+1;
		System.out.println(slowlen+" "+fastlen+" "+targetIndex);
		for(int j = slowlen; j<targetIndex; j++) {
			slowPointer = slowPointer.next();
			System.out.println(j+" "+slowPointer.getData());
		}
		return slowPointer.getData();
	}

}
