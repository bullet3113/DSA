// https://leetcode.com/problems/daily-temperatures

class Solution {
    public int[] dailyTemperatures(int[] t) {
        
        // simple implementation of the next greater element distance
        Stack<Integer> stack = new Stack<>();
        int n = t.length;

        for(int i = n-1; i >= 0; i--) {

            int temp = t[i];
            int count = 0;
            Stack<Integer> stack2 = new Stack<>();
            while(!stack.isEmpty() && stack.peek() <= temp) {
                count++;
                stack2.push(stack.pop());
            }

            if(stack.isEmpty()) {
                t[i] = 0;
            } else {
                t[i] = count+1;
            }

            while(!stack2.isEmpty()) stack.push(stack2.pop());

            stack.push(temp);
        }

        return t;
    }
}