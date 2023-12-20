// https://leetcode.com/problems/string-to-integer-atoi

class Solution {
    public int myAtoi(String s) {
        // removing whitespaces
        s = s.trim();
        int n = s.length();
        if(n == 0) return 0;
        // System.out.println(s);
        long ans = 0l;
        boolean isNegative = false;
        boolean isMax = false;

        int i = 0;
        if(s.charAt(0) == '-') {
            isNegative = true;
            i++;
        } else if(s.charAt(0) == '+') i++;

        while(i < n && s.charAt(i) =='0') {
            i++;
        }

        while(i < n) {
            char ch = s.charAt(i);
            if(ch >= 48 && ch <= 57) ans = (ans * 10) + (long)(ch - '0');
            else break;

            // System.out.println(ans);
            if(ans > Integer.MAX_VALUE) {
                isMax = true;
                break;
            }
            i++;
        }

        if(isNegative) ans *= -1;

        if(isMax) {
            if(isNegative) return Integer.MIN_VALUE;
            else return Integer.MAX_VALUE;
        }
        return (int)ans;
        
    }
}