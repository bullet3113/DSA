// https://leetcode.com/problems/find-the-duplicate-number

class Solution {
    public int findDuplicate(int[] nums) {
        
        int n = nums.length;

        int val = 0;

        for(int i = 1; i < n; i++) {
            
            if(Math.abs(val) == Math.abs(nums[i-1] - nums[i]) || (nums[i-1] - nums[i]) == 0) return nums[i];
            val = nums[i-1] - nums[i];
            
        }

        return 0;
    }
}