// https://leetcode.com/problems/reverse-string

class Solution {
    public void reverseString(char[] s) {
        helper(s, s.length-1);
    }
    
    void helper(char[] s, int n) {
        if(n == n/2)
            return;
        
        char temp = s[n];
        s[n] = s[s.length - n];
        s[s.length - n] = temp;
        
        helper(s, n-1);
    }
}