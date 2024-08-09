package org.example.blind75.linkedlist.medium;

import org.example.blind75.linkedlist.ListNode;

public class ReorderList {

    public static void main(String[] args) {
        ReorderList obj = new ReorderList();
    }

    /**
     * The efficient solution is a 3 part solution -
     * 1. find middle of linked list.
     * 2. when middle is found reverse the second half of the linked list.
     * 3. Merge linked list.
     *
     * Time Complexity: O(n/2) + O(n) + O(n) - for finding middle, reversing list from middle. and merging respectively. similar to O(n)
     * Space Complexity: O(n/2)+O(n)
     * */
    public void reorderList(ListNode head) {

        if(head == null) {
            return;
        }
        //Step 1: find  middle of linked list
        ListNode middle = findMiddle(head);
        //Step 2: reverse linked list
        ListNode reversedList = reverseList(middle);
        //Step 3: merge linked list.
        ListNode first = head, second = reversedList;
        while(second.next != null) {
            ListNode temp = first.next;
            first.next = second;
            first = temp;

            temp = second.next;
            second.next = first;
            second = temp;
        }
    }

    private ListNode findMiddle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next !=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode middle) {

        ListNode curr = middle;
        ListNode prev = null;
        while(curr!=null) {
            ListNode temp = curr.next;//back up of next node
            curr.next = prev;//changing pointer from next to prev
            prev = curr;//for next iteration this will become prev
            curr = temp;//for next iteration preparing next node
        }
        return prev;
    }
}
