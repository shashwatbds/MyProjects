package patterns.linkedlistreversal.usingstack;

import patterns.linkedlistreversal.model.LinkedListNode;
import patterns.linkedlistreversal.util.LLUtil;
import java.util.Stack;

public class LinkedListStack {

    private static LinkedListNode head;

    public LinkedListNode reverse(LinkedListNode head, Stack<Integer> stack) {

        // if the head is null or the list
        // contains only one element then reversing the list
        // does not have any impact on the list. Therefore, we
        // can return the original list without performing any operation
        if(head == null || head.next == null) {
            return head;
        }

        while(head != null) {
            stack.push(head.val);
            head = head.next; // when iterating the stack the first element will be null
        }

        //new Linked List
        LinkedListNode head1 = null;
        while(!stack.isEmpty()) {
            if(head == null) { // First iteration
                head1 = new LinkedListNode(stack.peek());
                head = head1;
                stack.pop();
            } else {
                head.next = new LinkedListNode(stack.peek());
                stack.pop();
                head = head.next;
            }
        }
        return head1;
    }

    public static void main(String[] args) {
        LinkedListStack listObj = new LinkedListStack();
        head = LLUtil.getLinkedList();
        // creating an object of the class Stack
        // the created stack will be empty
        Stack<Integer> stk = new Stack<Integer>();

        System.out.println("The Linked list before reversal is: ");
        LLUtil.printList(head);

        head = listObj.reverse(head, stk);
        System.out.println(" ");
        System.out.println("After reversal, the linked list is: ");
        LLUtil.printList(head);
    }
}
