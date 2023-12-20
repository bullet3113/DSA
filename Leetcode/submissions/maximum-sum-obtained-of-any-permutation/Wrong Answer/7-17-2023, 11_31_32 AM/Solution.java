// https://leetcode.com/problems/maximum-sum-obtained-of-any-permutation

class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        
        int n = nums.length;
        int[] pref = new int[n];

        for(int[] req: requests) {
            int l = req[0];
            int r = req[1];

            pref[l]++;
            if(r+1 < n) pref[r + 1]--;
        }

        // prefix sum
        for(int i = 1; i < n; i++) pref[i] += pref[i-1];

        // sorting both 
        Arrays.sort(pref);
        Arrays.sort(nums);

        int sum = 0;
        int mod = (int)10e9+7;
        for(int i = 0; i < n; i++) {
            sum = sum % mod + (pref[i] * nums[i]) % mod;
        }
        return sum;
    }
}