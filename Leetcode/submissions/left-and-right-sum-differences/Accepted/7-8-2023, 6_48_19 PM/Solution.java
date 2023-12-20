// https://leetcode.com/problems/left-and-right-sum-differences

class Solution {
    public int[] leftRightDifference(int[] nums) {
        // calculate prefix and suffix sums
        int n = nums.length;
        int pre[] = new int[n];
        int suf[] = new int[n];

        int sum_pre = 0;
        int sum_suf = 0;
        for(int i = 1; i < n; i++) {
            sum_pre += nums[i-1];
            pre[i] = sum_pre;
            
            // suffix sum
            sum_suf += nums[n - i];
            suf[n - i - 1] = sum_suf;
        }

        int[] ans = new int[n];

        // calculating answer array values
        for(int i = 0; i < n; i++) {
            ans[i] = Math.abs(pre[i] - suf[i]);
        }

        return ans;
    }
}