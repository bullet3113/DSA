// https://leetcode.com/problems/add-two-numbers

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c = 0;
        // reversing the lists
        // l1 = reverseIt(l1);
        // l2 = reverseIt(l2);
        ListNode x = new ListNode(0);
        ListNode t = x;
        while(l1 != null && l2 != null) {
            int sum = (l1.val + l2.val) + c;
            x.next = new ListNode(sum % 10);
            c = sum / 10;
            x = x.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null) {
            int sum = (l1.val) + c;
            x.next = new ListNode(sum % 10);
            c = sum / 10;
            x = x.next;
            l1 = l1.next;
        }

        while(l2 != null) {
            int sum = (l2.val) + c;
            x.next = new ListNode(sum % 10);
            c = sum / 10;
            x = x.next;
            l2 = l2.next;
        }

        if(c > 0) {
            x.next = new ListNode(c);
        }

        // t = reverseIt(t);
        t = t.next;
        return t;
    }

    ListNode reverseIt(ListNode head) {
        ListNode prev = null;
        while(head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }

        return prev;
    }
}