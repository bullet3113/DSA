// https://leetcode.com/problems/minimum-add-to-make-parentheses-valid

class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int result = 0;
        for(char c: s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if(stack.empty())
                    result++;
                else 
                    stack.pop();
            }
        }

        return result + stack.size();
    }
}