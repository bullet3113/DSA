// https://leetcode.com/problems/valid-parenthesis-string

class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        int sc = 0, cb = 0;
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if(ch == '(' || ch == '*') {stack.push(ch); sc++;}
            else {
                cb++;
                Stack<Character> tempStack = new Stack<>();

                while(!stack.isEmpty() && stack.peek() == '*') tempStack.push(stack.pop());

                if(stack.empty()) {
                    if(tempStack.empty()) return false;
                    tempStack.pop();
                } else {
                    stack.pop();
                }

                while(!tempStack.isEmpty()) stack.push(tempStack.pop());
            }
        }

        int starCount = 0;
        int openBracketCount = 0;
        while(!stack.isEmpty()) {
            char ch = stack.pop();
            if(ch == '*') starCount++;
            else starCount--;

            if(starCount < 0) return false;
        }

        System.out.println(starCount + " " + openBracketCount);
        System.out.println(sc + " " + cb);
        if(starCount < openBracketCount) return false;

        return true;
    }
}