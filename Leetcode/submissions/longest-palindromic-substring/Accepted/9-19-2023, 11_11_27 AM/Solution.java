// https://leetcode.com/problems/longest-palindromic-substring

class Solution {
    int start = 0;
    int max = 0;
    public String longestPalindrome(String s) {
        int n = s.length();

        char[] chars = s.toCharArray();
        for(int i = 0; i < n; i++) {
            checkPalindrome(chars, i, i);
            checkPalindrome(chars, i, i+1);
        }
        return s.substring(start, start + max);
    }

    void checkPalindrome(char[] chars, int i, int j) {

        while(i >= 0 && j < chars.length && chars[i] == chars[j]) {
            i--;
            j++;
        }
        
        if(max < j - i - 1) {
            max = j - i - 1;
            start = i + 1;
        }
    }
}