// https://leetcode.com/problems/subarray-product-less-than-k

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0;
        int n = nums.length;

        int j = 0;
        int pro = 1;
        for(int i = 0; i < n; i++) {
            pro *= nums[i];

            while(pro >= k && j <= i) {
                pro /= nums[j];
                j++;
            }

            ans += i - j + 1;
        }
        return ans;
    }
}