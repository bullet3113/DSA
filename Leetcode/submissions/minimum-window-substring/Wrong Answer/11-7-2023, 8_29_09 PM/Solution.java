// https://leetcode.com/problems/minimum-window-substring

class Solution {
    public String minWindow(String s, String t) {

        char[] charsT = t.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < charsT.length; i++) {
            map.put(charsT[i], map.getOrDefault(charsT[i], 0) + 1);
        }   

        char[] chars = s.toCharArray();

        int i = 0;
        int j = 0;
        int n = chars.length;
        int min = n;
        int unique = 0;
        int start = 0;

        while(i < n) {
            char ch = chars[i];

            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if(map.get(ch) == 0) {
                    unique++;
                }
            }

            while(unique == map.size() && j < i) {
                if(unique == map.size()) {
                    start = j;
                    min = Math.min(min, i - j + 1);
                }

                char temp = chars[j];

                if(map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                    if(map.get(temp) > 0) unique--;
                }
                j++;
            }

            i++;
        }

        // System.out.println(start + " " + min);
        if(charsT.length > n) return "";
        if(charsT.length == n && charsT[0] != chars[0]) return "";
        return s.substring(start, start + min);
    }
}