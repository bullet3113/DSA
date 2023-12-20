// https://leetcode.com/problems/longest-substring-without-repeating-characters

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n == 0) return -1;
        int max = -1;

        Set<Character> set = new HashSet<>();
        int j = 0;
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            // checking for if the character is already present in answer or not
            if(set.contains(ch)) {
                // remove the duplicate one, using j pointer
                while(s.charAt(j) != ch && j <= i) {
                    if(set.contains(s.charAt(j))) set.remove(s.charAt(j));
                    j++;
                }
                // not removing the character from set just increament j
                j++;
            } else {
                set.add(ch);
            }

            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}