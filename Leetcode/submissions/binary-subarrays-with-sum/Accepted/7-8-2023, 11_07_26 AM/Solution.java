// https://leetcode.com/problems/binary-subarrays-with-sum

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return helper(nums, goal) - helper(nums, goal-1);        
    }

    int helper(int nums[], int goal) {
        int n = nums.length;

        int j = 0; // first pointer
        int ans = 0;

        int sum = 0; // to store current sum
        for(int i = 0; i < n; i++) {
            sum += nums[i];

            

            // if at any point sum goes above the target
            while(sum > goal && j <= i) {
                sum -= nums[j];
                j++;
            }

            ans += (i - j + 1);
        }

        return ans;
    }
}