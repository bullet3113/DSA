// https://leetcode.com/problems/longest-palindromic-substring

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int ans = -1;
        int idx = 0;

        for(int i = 0; i < n; i++) {
            for(int j = i+1; j <= n; j++) {
                if(checkPalindrome(s.substring(i, j))) {
                    if(ans < j - i) {
                        ans = j - i;
                        idx = i;
                    }
                }
            }
        }
        return s.substring(idx, idx + ans);
    }

    boolean checkPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);

        String temp = sb.reverse().toString();

        return temp.equals(s);
    }
}