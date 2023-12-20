// https://leetcode.com/problems/maximum-subarray

class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int ans = nums[0];
        int sum = nums[0];
        for(int i = 1; i < n; i++) {
            if(sum >= 0) sum += nums[i];
            else sum = nums[i];
            
            if(ans < sum) ans = sum;
        }
        return ans;
    }
}