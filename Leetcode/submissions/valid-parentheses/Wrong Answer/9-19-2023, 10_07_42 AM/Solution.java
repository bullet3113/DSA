// https://leetcode.com/problems/valid-parentheses

class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if(ch == '[' || ch == '{' || ch == '(') stack.push(ch);
            else {
                if(!stack.empty()) {
                    if(ch == ']' && stack.peek() == '[') stack.pop();
                    else if(ch == '}' && stack.peek() == '{') stack.pop();
                    else if(ch == ')' && stack.peek() == '(') stack.pop();
                    else return false;
                } else return false;
            }
        }

        return true;
    }
}