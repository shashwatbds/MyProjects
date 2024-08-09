package org.example.blind75.linkedlist.easy;

import org.example.blind75.linkedlist.ListNode;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        MergeTwoSortedLists obj = new MergeTwoSortedLists();
        System.out.println(obj.mergeTwoLists());
    }

    /**
     * Time Complexity: O(m+n) - where m and n is size of list 1 and list 2 respectively.
     * Space Complexity: O(1) - constant space taken.
     * */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy =  new ListNode(1);// Trick: creating this dummy variable since we will be at the last element in the linked list by the end of this method.
        ListNode merge = dummy;
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                merge.next = list1;
                list1 = list1.next;
            } else {
                merge.next = list2;
                list2 = list2.next;
            }
            merge = merge.next;
        }
        if(merge.next == list1 && list1==null) { // This means the last element added in list was from list1 and now it is empty, now we need to add all remaining elements from list2 to merge list
            merge.next = list2;
        } else {
            merge.next = list1;
        }
        return dummy.next;
    }
}
