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
        // ArrayList<String> x = new ArrayList<>();
        // while(headA != null) {
        //     x.add(String.valueOf(headA));
        //     headA = headA.next;
        // }

        // while(headB != null) {
        //     if(x.contains(String.valueOf(headB)))
        //         break;
        //     headB = headB.next;
        // }

        // return headB;

        // getting middle of both
        // ListNode midA = findMid(headA);
        // ListNode midB = findMid(headB);

        // if(midA == midB) {
        //     return midA;
        // } else if(midA.next == midB) {
        //     return midB;
        // } else if(midB.next == midA) {
        //     return midA;
        // }

        // return null;

        // using concatenation approach

        // ListNode a = headA;
        // ListNode b = headB;

        // while(a.next != null) {
        //     a = a.next;
        // }

        // while(b.next != null) {
        //     b = b.next;
        // }

        // a.next = headB;
        // b.next = headA;

        // a = headA;
        // b = headB;

        // while(a != null && b != null) {
        //     if(a.next == b.next) {
        //         return a.next;
        //     }

        //     a = a.next;
        //     b = b.next;
        // } 

        // return null;
            
if(headA == null || headB == null) return null;
    
    ListNode a = headA;
    ListNode b = headB;
    
    //if a & b have different len, then we will stop the loop after second iteration
    while( a != b){
    	//for the end of first iteration, we just reset the pointer to the head of another linkedlist
        a = a == null? headB : a.next;
        b = b == null? headA : b.next;    
    }
    
    return a;

    }

    ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}