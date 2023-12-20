// https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters

class Solution {
    public int longestSubstring(String s, int k) {
        
        // traversing to all the unique characters
        int[] count = new int[26];
        int max = 0;

        for(int h = 1; h <= 26; h++) {
            Arrays.fill(count, 0);
            int i = 0, j = 0, unique = 0, greaterOrEqualToK = 0;

            while(j < s.length()) {
                char ch = s.charAt(j);

                if(count[ch - 'a'] == 0) unique++;

                count[ch - 'a']++;

                if(count[ch - 'a'] == k) greaterOrEqualToK++;

                j++;

                while(unique > h) {
                    char ch1 = s.charAt(i);

                    if(count[ch1 - 'a'] == k) greaterOrEqualToK--;

                    count[ch1 - 'a']--;

                    if(count[ch1 - 'a'] == 0) unique--;

                    i++;
                }

                if(unique == greaterOrEqualToK)
                max = Math.max(max, j - i);
            }
        }

        return max;
    }
}