// https://leetcode.com/problems/reorder-list

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
    public void reorderList(ListNode head) {
        
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;

        while(curr != null) {
            stack.push(curr);
            curr = curr.next;
        }

        int size = stack.size();
        curr = head;
        while(size > 0) {
            ListNode temp = curr.next;
            curr.next = stack.pop();
            curr.next.next = temp;
            curr = curr.next.next;
            size -= 2;
        }

        curr.next = null;
    }
}