// https://leetcode.com/problems/longest-consecutive-sequence

class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        if(n == 0) return 0;
        int ans = 1;
        int j = 0;

        for(int i = 0; i < n-1; i++) {
            if(nums[i+1] - nums[i] != 1 || i == n-2) {
                ans = Math.max(ans, i - j + 1);
                j = i;
            }
        }

        return ans;   
    }
}