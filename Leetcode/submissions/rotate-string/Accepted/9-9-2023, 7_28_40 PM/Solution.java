// https://leetcode.com/problems/rotate-string

class Solution {
    public boolean rotateString(String s, String g) {
        int n = s.length();
        
        if(n != g.length()) return false;

        char c = g.charAt(0);
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if(ch == c) {
                String temp = s.substring(i);
                temp += s.substring(0, i);

                if(temp.equals(g)) return true;
            }
        }

        return false;
    }
}