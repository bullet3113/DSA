// https://leetcode.com/problems/count-and-say

class Solution {
    public String countAndSay(int n) {
        //Write code here
		String str = "1";
        for(int i = 0; i < n-1; i++) {
            String temp = "";
            int c = 0;
            while(!str.isEmpty()) {
                char ch = str.charAt(0);
                while(str.startsWith(String.valueOf(ch))) {
                    c++;
                    str = str.substring(1);
                }
                temp += String.valueOf(c) + ch;
                c = 0;
            }
            str = temp;
        }
        return str;
    } 
}