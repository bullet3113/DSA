// https://leetcode.com/problems/longest-consecutive-sequence

class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        if(n == 0) return 0;
        int ans = 1;
        int j = 0, sum = nums[0];

        for(int i = 1; i < n; i++) {
            if(sum + 1 == nums[i]) {ans = Math.max(ans, i - j + 1); sum++;}
            else {
                // ans = Math.max(ans, i - j + 1);
                j = i;
                sum = nums[i];
            }
        }

        return ans;   
    }
}