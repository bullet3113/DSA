// https://leetcode.com/problems/maximum-subarray

class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;

        int currMax = 0;
        int globalMax = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            currMax += nums[i];
            
            globalMax = Math.max(globalMax, currMax);
            currMax = Math.max(currMax, 0);
            
        }   

        return globalMax;
    }
}