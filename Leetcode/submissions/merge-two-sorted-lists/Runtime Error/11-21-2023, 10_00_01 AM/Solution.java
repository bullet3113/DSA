// https://leetcode.com/problems/merge-two-sorted-lists

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        if(list1 == null && list2 == null) return list1;
        if(list1 != null && list2 == null) return list1;
        if(list1 == null && list2 != null) return list2;
        if(list1.val > list2.val) return mergeTwoLists(list2, list1);

        ListNode curr = list1;
        while(curr.next != null) {
            int d1 = curr.val;

            if(curr.next.val <= list2.val) {
                curr = curr.next;
            } else {
                ListNode temp = curr.next;
                curr.next = list2;
                list2 = list2.next;
                curr.next.next = temp;
            }
        }

        curr.next = list2;

        return list1;
    }
}