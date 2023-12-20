// https://leetcode.com/problems/find-the-duplicate-number

class Solution {
    public int findDuplicate(int[] nums) {
        
        int n = nums.length;

        int val = 0;

        for(int i = 1; ; i++) {
            
            int k = (i-1) % n;
            int j = i % n;
            if(Math.abs(val) == Math.abs(nums[k] - nums[j]) || (nums[k] - nums[j]) == 0) return nums[j];
            val = nums[k] - nums[j];
            
        }

        // return 0;
    }
}