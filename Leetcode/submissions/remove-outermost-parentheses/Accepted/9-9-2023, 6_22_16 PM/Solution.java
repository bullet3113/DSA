// https://leetcode.com/problems/remove-outermost-parentheses

class Solution {
    public String removeOuterParentheses(String s) {
        // the primitive decomposition has opening and closing 
        // braces in equal quantity
        int n = s.length();
        String ans = "";

        boolean f = false;
        int p = 0, j = 1;
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if(ch == '(') p++;
            else p--; 

            if(p == 0) {
                ans += s.substring(j, i);
                j = i + 2;
            }
        }

        return ans;
    }
}