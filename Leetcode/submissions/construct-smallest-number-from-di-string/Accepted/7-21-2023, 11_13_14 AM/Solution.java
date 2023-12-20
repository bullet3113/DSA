// https://leetcode.com/problems/construct-smallest-number-from-di-string

class Solution {
    public String smallestNumber(String pattern) {
        // Dry run the code for better understanding
        StringBuilder temp = new StringBuilder();
        StringBuilder ans = new StringBuilder();

        char ch = '1';

        for(int i = 0; i < pattern.length(); i++) {
            char curr = pattern.charAt(i);

            temp.append(ch++);
            if(curr == 'I') {
                ans.append(temp.reverse());
                temp = new StringBuilder();
            }
        }

        temp.append(ch++); // for handling n+1 case
        ans.append(temp.reverse());

        return ans.toString();
    }
}