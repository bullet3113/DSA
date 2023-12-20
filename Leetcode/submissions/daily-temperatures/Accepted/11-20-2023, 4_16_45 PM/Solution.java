// https://leetcode.com/problems/daily-temperatures

class Solution {
    public int[] dailyTemperatures(int[] t) {
        
        // simple implementation of the next greater element distance
        Stack<Integer> stack = new Stack<>();
        int n = t.length;
        int ans[] = new int[n];

        for(int i = n-1; i >= 0; i--) {

            int temp = t[i];
            int count = 0;
            Stack<Integer> stack2 = new Stack<>();
            while(!stack.isEmpty() && t[stack.peek()] <= temp) {
                // count++;
                stack2.push(stack.pop());
            }

            if(stack.isEmpty()) {
                ans[i] = 0;
            } else {
                ans[i] = stack.peek() - i;
            }

            // while(!stack2.isEmpty()) stack.push(stack2.pop());

            stack.push(i);
        }

        return ans;
    }
}