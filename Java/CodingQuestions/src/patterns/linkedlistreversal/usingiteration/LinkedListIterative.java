package patterns.linkedlistreversal.usingiteration;

import patterns.linkedlistreversal.model.LinkedListNode;
import patterns.linkedlistreversal.util.LLUtil;

/**
 * Approach -
 * 1. Take 3 pointers (previous, next and Current)
 * 2. Iterate through the linked list.
 *      - for each node set the current previous node as the next node.
 * */
public class LinkedListIterative {

    static LinkedListNode head;

    public LinkedListNode reverse(LinkedListNode node){

        LinkedListNode previous = null;
        LinkedListNode current = node;
        LinkedListNode next = null;

        while(current!=null) {
            next = current.next; //backup
            current.next = previous; // reversing the direction - critical step
            previous = current; // current will become previous
            current = next; // next will become current
        }
        node = previous; // Assign current
        return node;
    }

    public static void main(String[] args) {
        LinkedListIterative listObj = new LinkedListIterative();
        listObj.head = LLUtil.getLinkedList();
        System.out.println("The Linked list before reversal is: ");
        LLUtil.printList(head);
        head = listObj.reverse(head);
        System.out.println("\n");
        System.out.println("After reversal, the linked list is: ");
        LLUtil.printList(head);
    }
}
