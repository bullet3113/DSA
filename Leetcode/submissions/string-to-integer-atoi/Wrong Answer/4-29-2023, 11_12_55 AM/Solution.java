// https://leetcode.com/problems/string-to-integer-atoi

class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        char ch = s.charAt(0);
        boolean check = false;
        if(ch == '-') 
            check = true;
        return helper(s, 0, s.length(), check);
    }

    int helper(String s, int ans, int l, boolean check) {
        if(s.isEmpty()) {
            if(check)
            return -ans;
            return ans;
        }

        char ch = s.charAt(0);
        if((int)(ch - '0') >= 0 && (int)(ch - '0') <= 9) {
            return helper(s.substring(1), ans * 10 + ((int)(ch - '0')), l, check);
        }

        return helper(s.substring(1), ans, l, check);
    }
}