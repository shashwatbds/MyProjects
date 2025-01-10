package org.example.blind75.linkedlist.easy;

import org.example.blind75.linkedlist.ListNode;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ReverseLinkedList obj = new ReverseLinkedList();
        ListNode five = new ListNode(5, null);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);
//        ListNode reverse = obj.reverseListIteration(one);
//        System.out.println(reverse.val == 5);
//        System.out.println(reverse.next.val == 4);
//        System.out.println(reverse.next.next.val== 3);
//        System.out.println(reverse.next.next.next.val == 2);
//        System.out.println(reverse.next.next.next.next.val == 1);

        ListNode reverseRecursion = obj.reverseListRecursion(one);
        System.out.println(reverseRecursion.val == 5);
        System.out.println(reverseRecursion.next.val == 4);
        System.out.println(reverseRecursion.next.next.val== 3);
        System.out.println(reverseRecursion.next.next.next.val == 2);
        System.out.println(reverseRecursion.next.next.next.next.val == 1);
    }

    private ListNode reverseListIteration(ListNode head) {

        if(head == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null) {
            ListNode temp = curr.next;//back up of next node
            curr.next = prev;//changing pointer from next to prev
            prev = curr;//for next iteration this will become prev
            curr = temp;//for next iteration preparing next node
        }
        return prev;
    }

    private ListNode reverseListRecursion(ListNode head) {
        if(head == null || head.next == null) {//handled empty linked list and linked list with one node
            return head;
        }

        ListNode rest = reverseListRecursion(head.next);
        head.next.next = head;//uses pass by reference, making it's next node point to itself,
        // currently head.next == rest, and we are setting rest.next to curr at every step and every loop will return rest,
        // interchanging the pointer because our end condition also checks if head.next is null,
        // if it is null then in this step we are setting last element's next as the second last item.
        head.next = null;//currently setting this as null.
        return rest;// at every step we return rest and rest.next would be head.
    }
}
