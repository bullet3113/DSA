// https://leetcode.com/problems/find-the-pivot-integer

class Solution {
    public int pivotInteger(int n) {
        // calculate prefix and suffix sums
        int[] nums = new int[n];

        for(int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        
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
            if(pre[i] - suf[i] == 0) return nums[i];
        }

        return -1;
    }
}