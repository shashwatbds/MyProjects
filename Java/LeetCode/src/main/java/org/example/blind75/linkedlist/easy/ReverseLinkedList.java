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
        head.next.next = head;//uses pass by reference
        head.next = null;
        return rest;
    }
}
