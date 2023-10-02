package patterns.linkedlistreversal.util;

import patterns.linkedlistreversal.model.LinkedListNode;
import patterns.linkedlistreversal.usingiteration.LinkedListIterative;

public class LLUtil {

    public static LinkedListNode getLinkedList() {
        LinkedListNode node = new LinkedListNode(4);// 4 -> NULL
        node.next = new LinkedListNode(6);// 4 -> 6 -> NULL
        node.next.next = new LinkedListNode(7);// 4 -> 6 -> 7 -> NULL
        node.next.next.next = new LinkedListNode(1);// 4 -> 6 -> 7 -> 1-> NULL
        node.next.next.next.next = new LinkedListNode(5);// 4 -> 6 -> 7 -> 1-> 5 -> NULL
        node.next.next.next.next.next = new LinkedListNode(8);// 4 -> 6 -> 7 -> 1-> 5 -> 8 -> NULL
        node.next.next.next.next.next.next = new LinkedListNode(3);// 4 -> 6 -> 7 -> 1-> 5 -> 8 -> 3 -> NULL
        node.next.next.next.next.next.next.next = new LinkedListNode(2);// 4 -> 6 -> 7 -> 1-> 5 -> 8 -> 3 -> 2 -> NULL

        System.out.println("The Linked list before reversal is: ");
        return node;
    }

    public static void printList(LinkedListNode node) {
        while (node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}
