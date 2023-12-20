// https://leetcode.com/problems/reverse-string

class Solution {
    public void reverseString(char[] s) {
        helper(s, s.length-1);
    }
    
    void helper(char[] s, int n) {
        if(n <= n/2 + 1)
            return;
        
        // System.out.println(s[n]);
        char temp = s[n];
        s[n] = s[s.length - n - 1];
        s[s.length - n - 1] = temp;
        
        helper(s, n-1);
    }
}