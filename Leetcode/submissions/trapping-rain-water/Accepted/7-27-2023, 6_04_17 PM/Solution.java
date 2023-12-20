// https://leetcode.com/problems/trapping-rain-water

class Solution {
    public int trap(int[] h) {
        
        // calculating right max
        int n = h.length;
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(h[n-1]);
        
        for(int i = n-1; i >= 0; i--) {
            if(stack.peek() > h[i]) {
                right[i] = stack.peek();
            } else {
                while(!stack.empty() && stack.peek() < h[i]) stack.pop();
                if(stack.empty()) {
                    right[i] = h[i];
                    stack.push(h[i]);
                }
                else right[i] = stack.peek();
            }
        }


        stack.clear();
        stack.push(h[0]);

        int[] left = new int[n];

        for(int i = 0; i < n; i++) {
            if(stack.peek() > h[i]) {
                left[i] = stack.peek();
            } else {
                while(!stack.empty() && stack.peek() < h[i]) stack.pop();
                if(stack.empty()) {
                    left[i] = h[i];
                    stack.push(h[i]);
                }
                else left[i] = stack.peek();
            }
        }

        int ans = 0;

        for(int i = 0; i < n; i++) {
            int temp = Math.min(left[i], right[i]) - h[i];
            ans += temp;
        }

        return ans;
    }
}