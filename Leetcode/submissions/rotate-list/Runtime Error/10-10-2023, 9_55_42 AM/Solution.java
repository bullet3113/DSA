// https://leetcode.com/problems/rotate-list

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
    public ListNode rotateRight(ListNode head, int k) {
        // getting total no. of nodes 
        int n = 0;
        ListNode curr = head;
        while(curr != null) {
            n++;
            curr = curr.next;
        }   

        if(k == 0) return head;
        k = k % n;
        k = n - k;

        if(k == n) return head;

        curr = head;
        while(k > 1) {
            curr = curr.next;
            k--;
        }
        
        // curr has 3 now
        ListNode nextNode = curr.next; // 4

        // making 3 last node
        curr.next = null;

        // getting the new head
        ListNode newHead = nextNode;

        // joining OG head at the end of 5
        while(nextNode.next != null) nextNode = nextNode.next;
        nextNode.next = head;

        return newHead;
    }
}