// https://leetcode.com/problems/largest-odd-number-in-string

class Solution {
    public String largestOddNumber(String num) {
        String ans = "";

        int n = num.length();
        for(int i = n-1; i >= 0; i--) {
            char ch = num.charAt(i);

            int tempNum = ch - '0';

            if(tempNum % 2 == 1) {
                ans = num.substring(0, i+1);
                return ans;    
            }
        }

        return ans;
    }
}