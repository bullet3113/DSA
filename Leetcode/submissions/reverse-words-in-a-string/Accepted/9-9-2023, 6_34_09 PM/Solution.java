// https://leetcode.com/problems/reverse-words-in-a-string

class Solution {
    public String reverseWords(String s) {
        
        int n = s.length();

        String ans = "";
        String word = "";

        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if(ch == ' ' && word.length() == 0) continue;
            else if(ch == ' ') {
                ans = word + ' ' + ans;
                word = "";
                continue;
            }

            word += ch;
        }
        
        ans = word + ' ' + ans;
        ans = ans.trim();
        return ans;
    }
}