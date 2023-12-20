// https://leetcode.com/problems/string-to-integer-atoi

class Solution {
    public int myAtoi(String s) {
        // removing whitespaces
        s = s.trim();
        int n = s.length();

        // System.out.println(s);
        long ans = 0l;
        boolean isNegative = false;
        boolean isMax = false;

        int i = 0;
        if(s.charAt(0) == '-') {
            isNegative = true;
            i++;
        }

        while(i < n && s.charAt(i) =='0') {
            i++;
        }

        while(i < n) {
            char ch = s.charAt(i);
            if(ch >= 49 && ch <= 57) ans = (ans * 10) + (long)(ch - '0');
            else break;

            if(ans > Integer.MAX_VALUE) {
                isMax = true;
                break;
            }
            i++;
        }

        if(isNegative) ans *= -1;

        if(isMax) {
            if(isNegative) ans = Integer.MIN_VALUE;
            else ans = Integer.MAX_VALUE;
        }
        return (int)ans;
        
    }
}