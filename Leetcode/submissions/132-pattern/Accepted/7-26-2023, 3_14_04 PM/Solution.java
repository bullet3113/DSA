// https://leetcode.com/problems/132-pattern

class Solution {
    public boolean find132pattern(int[] nums) {
        
        int n = nums.length;
        int[] minValues = new int[n];

        minValues[0] = nums[0];

        for(int i = 1; i < n; i++) {
            minValues[i] = Math.min(minValues[i-1], nums[i]);
        }

        Stack<Integer> stack = new Stack<>();
        for(int j = n-1; j >= 0; j--) {
            if(nums[j] > minValues[j]) {
                while(!stack.empty() && minValues[j] >= stack.peek()) stack.pop();

                if(!stack.empty() && nums[j] > stack.peek()) return true;
                stack.push(nums[j]);
            }

            
        }

        return false;
    }
}