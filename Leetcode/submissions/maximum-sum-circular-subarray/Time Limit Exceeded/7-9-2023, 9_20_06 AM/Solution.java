// https://leetcode.com/problems/maximum-sum-circular-subarray

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        // we have to start our index from each element
        int n = nums.length;
        int global_max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            int curr_max = 0;
            int si = i;
            int ei = n + i;

            while(si < ei) {
                curr_max += nums[si % n];
                
                global_max = Math.max(global_max, curr_max);
                curr_max = Math.max(curr_max, 0);
                si++;
            }
        }
        return global_max;
    }
}