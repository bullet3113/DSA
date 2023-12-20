// https://leetcode.com/problems/max-consecutive-ones

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int currSum = 0;
        for(int i = 0; i < n; i++) {
            currSum += nums[i];

            ans = Math.max(ans, currSum);

            if(nums[i] == 0) currSum = 0;
        }
        return ans;
    }
}