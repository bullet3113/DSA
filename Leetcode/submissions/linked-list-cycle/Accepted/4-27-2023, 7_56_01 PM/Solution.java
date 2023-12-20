// https://leetcode.com/problems/linked-list-cycle

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // we are using two pointer approach here
        // taking two node slow and fast
        // slow node increment node by 1 and fast by 2
        // so if any loop is not present then fast will terminate the loop 
        // if loop present then fast will keep looping until both slow and fast 
        // became equal
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
            return true;
        }

        return false;
    }
}