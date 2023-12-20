// https://leetcode.com/problems/intersection-of-two-linked-lists

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ArrayList<String> x = new ArrayList<>();
        while(headA != null) {
            x.add(String.valueOf(headA));
            headA = headA.next;
        }

        while(headB != null) {
            if(x.contains(String.valueOf(headB)))
                break;
            headB = headB.next;
        }

        return headB;
    }
}