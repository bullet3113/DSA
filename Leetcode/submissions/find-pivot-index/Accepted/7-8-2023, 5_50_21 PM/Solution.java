// https://leetcode.com/problems/find-pivot-index

class Solution {
    public int pivotIndex(int[] nums) {
        // calculate prefix and suffix sums
        int n = nums.length;
        int pre[] = new int[n];
        int suf[] = new int[n];

        int sum_pre = 0;
        int sum_suf = 0;
        for(int i = 0; i < n; i++) {
            sum_pre += nums[i];
            pre[i] = sum_pre;
            
            // suffix sum
            sum_suf += nums[n - i - 1];
            suf[n - i - 1] = sum_suf;
        }

        // searching for pivot index
        for(int i = 0; i < n; i++) {
            if(pre[i] - suf[i] == 0) return i;
        }

        return -1;
    }
}