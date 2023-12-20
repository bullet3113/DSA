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
        if (head == null || head.next == null)  
{  
return head;  
}  
  
// reverse the rest (r) of the list and place  
// the first element of the list at the last   
ListNode r = reverseList(head.next);  
head.next.next = head;  
  
  
head.next = null;  
  
// fixing the head pointer  
return r; 
    }
}