// https://leetcode.com/problems/combination-sum-iv

class Solution {
    public int combinationSum4(int[] nums, int target) {
        if(target < 0) {
            return 0;
        }

        if(target == 0) {
            return 1;
        }

        int ans = 0;

        for(int i = 0; i < nums.length; i++) {
            ans += combinationSum4(nums, target-nums[i]);
        }

        return ans;
    }
}