// https://leetcode.com/problems/number-of-substrings-containing-all-three-characters

class Solution {
    public int numberOfSubstrings(String s) {

     Map<Character, Integer> map = new HashMap<>();
     int n = s.length();
     int j = 0;
     int i = 0;
     int ans = 0;
     
     while(i < n) {
         map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
         if(!map.containsKey('a') || !map.containsKey('b') || !map.containsKey('c')) {
             i++;
         } else {
             while(map.containsKey('a') && map.containsKey('b') && map.containsKey('c')) {
                 ans += n - i;
                 map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                 if(map.get(s.charAt(j)) == 0) map.remove(s.charAt(j));
                 j++;
                }
                i++;
            }
        }

     return ans;   
    }
}