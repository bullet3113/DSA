// https://leetcode.com/problems/single-number

class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;

        int ans = 0;

        for(int i: nums) ans ^= i;
        return ans;
    }
}