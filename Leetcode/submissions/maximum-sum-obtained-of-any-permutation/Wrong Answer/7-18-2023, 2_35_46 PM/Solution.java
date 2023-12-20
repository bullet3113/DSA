// https://leetcode.com/problems/maximum-sum-obtained-of-any-permutation

class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        
        int n = nums.length;
        int[] pref = new int[n];

        for(int[] req: requests) {
            int l = req[0];
            int r = req[1];
            for(int i = l; i <= r; i++) pref[i]++;
            // pref[l]++;
            // if(r+1 < n) pref[r + 1]--;
        }

        // prefix sum
        // for(int i = 1; i < n; i++) pref[i] += pref[i-1];

        // sorting both 
        Arrays.sort(pref);
        Arrays.sort(nums);

        long sum = 0l;
        int mod = (int)10e9+7;
        for(int i = 0; i < n; i++) {
            sum += (long)(pref[i] * nums[i]);
        }
        return (int)(sum % mod);
    }
}