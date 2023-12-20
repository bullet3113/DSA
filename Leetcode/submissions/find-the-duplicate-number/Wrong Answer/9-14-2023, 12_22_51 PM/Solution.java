// https://leetcode.com/problems/find-the-duplicate-number

class Solution {
    public int findDuplicate(int[] nums) {
        
        int n = nums.length;

        int sum = 0;
        int currSum = 0;

        for(int i = 0; i < n; i++) {
            sum += i;

            currSum += nums[i];
        }

        return currSum - sum;
    }
}