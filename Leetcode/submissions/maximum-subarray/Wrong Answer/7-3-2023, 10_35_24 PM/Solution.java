// https://leetcode.com/problems/maximum-subarray

class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int ans = 0;

        if(n == 1) return nums[0];
        int sum = 0;
        for(int i = 0; i < n; i++) {
            int temp = sum + nums[i];
            if(temp > sum) {
                sum += nums[i];  
            } else if(temp < sum && temp > 0) sum += nums[i];
            else if(temp < 0) sum = 0;

            if(ans < sum) ans = sum;
        }
        return ans;
    }
}