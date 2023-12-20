// https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses

class Solution {
    public int maxDepth(String s) {
        int n = s.length();

        int o = 0, c = 0;
        int max = -1;
        int curr_max = 0;
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if(ch == '(') c++;
            else if(ch == ')') {
                curr_max = Math.max(c, curr_max);
                c--;
            }

            if(c == 0) {
                max = Math.max(curr_max, max);
            }
        }

        return max;
    }
}