// https://leetcode.com/problems/reverse-linked-list

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
    public ListNode reverseList(ListNode head) {
        
        // creating a dummy node to track previous node
        ListNode prev = null;

        while(head != null) {
            // storing next node in a temp node
            ListNode temp = head.next;
            // initializing current head.next to previous node
            head.next = prev;
            // intitalizing current node to prev node
            prev = head;
            // storing original next node to head
            head = temp;
        }

        return prev;
    }
}