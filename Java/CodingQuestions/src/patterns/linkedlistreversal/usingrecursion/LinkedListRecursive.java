package patterns.linkedlistreversal.usingrecursion;

import patterns.linkedlistreversal.model.LinkedListNode;
import patterns.linkedlistreversal.util.LLUtil;

public class LinkedListRecursive {

    public static void main(String[] args) {
        LinkedListNode head = LLUtil.getLinkedList();
        LLUtil.printList(head);
        LinkedListRecursive object = new LinkedListRecursive();
        LLUtil.printList(object.reverse(head));
    }

    public LinkedListNode reverse(LinkedListNode head) {
        if(head == null) {
            return head;
        }
        //last node or only one node
        if(head.next == null) {
            return head;
        }

        LinkedListNode newHeadNode = reverse(head.next);
        //changing the reference of next node
        head.next.next = head;
        head.next = null;

        return newHeadNode;
    }
}
