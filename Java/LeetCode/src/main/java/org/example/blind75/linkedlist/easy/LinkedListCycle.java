package org.example.blind75.linkedlist.easy;

import org.example.blind75.linkedlist.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    public static void main(String[] args) {
        LinkedListCycle obj = new LinkedListCycle();
        ListNode two = null;
        ListNode four = new ListNode(4, two);
        ListNode three = new ListNode(3, four);
        two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);
        System.out.println(Boolean.TRUE.equals(obj.hasCycleUsingVisitedArray(one)));

        ListNode two1 = new ListNode(2, null);
        ListNode one1 = new ListNode(1, two1);
        System.out.println(Boolean.FALSE.equals(obj.hasCycleUsingVisitedArray(one1)));

    }

    /**
     * This algorithm uses two pointers, fast and slow, to traverse the linked list. The fast pointer moves twice as fast as the slow pointer.
     * If there is a cycle, the fast pointer will eventually catch up to the slow pointer. If there is no cycle,
     * the fast pointer will reach the end of the list, and the function will return False.
     * This algorithm is an efficient way to detect cycles in a singly-linked list.
     * Time Complexity: O(n)
     * SpaceComplexity: O(1) - constant.
     * */
    public boolean hasCycleUsingVisitedArray(ListNode head) {

        if(head == null)
            return false;

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && slow != null && fast.next != null) {//We need to check if fast.next is not null so that we do not get null pointer when we reassign fast inside the loop.
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)//Reference matching.
                return true;
        }
        return false;
    }
}
