// https://leetcode.com/problems/isomorphic-strings

class Solution {
    public boolean isIsomorphic(String s, String t) {
        // just find unique characters in each string 
        // if they equal then true else false

        int n = s.length();

        int count_s = 0, count_t = 0;
        int[] arr_s = new int[130];
        int[] arr_t = new int[130];
        for(int i = 0; i < n; i++) {
            char ch_s = s.charAt(i);
            char ch_t = t.charAt(i);

            if(arr_s[ch_s] != arr_t[ch_t]) return false;
            
            if(arr_s[ch_s] == 0) {
                count_s++;
                arr_s[ch_s] = i + 1;    
            }

            if(arr_t[ch_t] == 0) {
                count_t++;
                arr_t[ch_t] = i + 1;    
            }
        }

        return count_s == count_t;
    }
}