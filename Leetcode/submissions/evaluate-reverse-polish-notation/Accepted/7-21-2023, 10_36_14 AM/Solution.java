// https://leetcode.com/problems/evaluate-reverse-polish-notation

class Solution {
    public int evalRPN(String[] tokens) {
        // using stacks

        Stack<Integer> stack = new Stack<>();
        int n = tokens.length;

        for(int i = 0; i < n; i++) {
            String str = tokens[i];

            if(str.equals("+")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a + b);
            } else if(str.equals("*")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a * b);
            } else if(str.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);
            } else if(str.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            } else stack.push(Integer.parseInt(str));
        }
        
        return stack.pop();
    }
}