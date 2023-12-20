// https://leetcode.com/problems/string-to-integer-atoi

class Solution {
    public int myAtoi(String s) {
        // removing whitespaces
        s = s.trim();
        int n = s.length();

        // System.out.println(s);
        int ans = 0;
        boolean isNegative = false;

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
            if(ch >= 49 && ch <= 57) ans = (ans * 10) + (int)(ch - '0');
            else break;

            i++;
        }

        if(isNegative) ans *= -1;

        return ans;
        
    }
}