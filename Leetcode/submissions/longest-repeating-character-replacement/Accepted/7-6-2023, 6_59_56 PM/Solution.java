// https://leetcode.com/problems/longest-repeating-character-replacement

class Solution {
    public int characterReplacement(String s, int z) {
        int n = s.length();

        
        int max = -1;

        for(int j = 65; j <= 91; j++) {
            char ch = (char)j;
            int temp = 0;
            int x = 0;
            int k = z;
            for(int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if(c != ch && k >= 0)
                    k--;

                
                while(k < 0 && x <= i) {
                    if(s.charAt(x) != ch) k++;
                    x++;
                }

                if(k >= 0)
                max = Math.max(i - x + 1, max);
            }
        }
        return max;
    }
}