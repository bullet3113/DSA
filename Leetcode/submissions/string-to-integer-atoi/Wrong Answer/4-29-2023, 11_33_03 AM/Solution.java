// https://leetcode.com/problems/string-to-integer-atoi

class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        char ch = s.charAt(0);
        boolean check = false;
        if(ch == '-') 
            check = true;
        else if((int)(ch) < 48 || (int)(ch) > 57)
            return 0;
        return helper(s, "0", s.length(), check);
    }

    int helper(String s, String ans, int l, boolean check) {
        if(s.isEmpty()) {
            if(check) {
                if(ans.length() > 9) {
                    return Integer.MIN_VALUE;
                } else {
                    return -(Integer.parseInt(ans));
                }
            }
            
            if(ans.length() > 9) {
                    return Integer.MAX_VALUE;
                } else {
                    return (Integer.parseInt(ans));
                }
        }

        char ch = s.charAt(0);
        if(ch == '.') {
            return helper("", ans, l, check);
        }
        if((int)(ch - '0') >= 0 && (int)(ch - '0') <= 9) {
            int temp = (int)(ans.charAt(ans.length()-1) - '0') * 10 + ((int)(ch - '0'));
            return helper(s.substring(1), ans.substring(0, ans.length()-1) + (String.valueOf(temp)) , l, check);
        }

        return helper(s.substring(1), ans, l, check);
    }
}