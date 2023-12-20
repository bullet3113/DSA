// https://leetcode.com/problems/reverse-string

class Solution {
    public void reverseString(char[] s) {
        helper(s, 0, s.length-1);
    }
    
    void helper(char[] s, int b, int e) {
        if(b >= e)
            return;
        
        // System.out.println(s[n]);
        char temp = s[b];
        s[b] = s[e];
        s[e] = temp;
        
        helper(s, b+1, e-1);
    }
}