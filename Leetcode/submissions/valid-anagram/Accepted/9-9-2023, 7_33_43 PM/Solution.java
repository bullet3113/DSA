// https://leetcode.com/problems/valid-anagram

class Solution {
    public boolean isAnagram(String s, String t) {
        
        int n = s.length();
        if(n != t.length()) return false;

        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(int i = 0; i < n; i++) {
            char ch = t.charAt(i);

            if(map.containsKey(ch) && map.get(ch) > 0) {
                map.put(ch, map.get(ch) - 1);
            } else return false;

        }

        return true;
    }
}