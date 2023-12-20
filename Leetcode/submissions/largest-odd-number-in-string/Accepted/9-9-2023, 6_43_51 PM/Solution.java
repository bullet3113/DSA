// https://leetcode.com/problems/largest-odd-number-in-string

class Solution {
    public String largestOddNumber(String num) {
        String ans = "";

        int n = num.length();
        for(int i = 0; i < n; i++) {
            char ch = num.charAt(i);

            int tempNum = ch - '0';

            if(tempNum % 2 == 1) ans = num.substring(0, i+1);
        }

        return ans;
    }
}