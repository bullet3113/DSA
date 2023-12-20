// https://leetcode.com/problems/remove-nth-node-from-end-of-list

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // count no. of nodes

        int c = 0;

        ListNode curr = head;

        while(curr != null) {
            c++;
            curr = curr.next;
        }

        if(c == 1) return null;
        c = c - n - 1;

        curr = head;
        while(c > 0) {
            curr = curr.next;
            c--;
        }

        curr.next = curr.next.next;

        return head;
    }
}