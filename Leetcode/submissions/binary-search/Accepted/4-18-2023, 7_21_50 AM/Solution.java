// https://leetcode.com/problems/binary-search

class Solution {
    public int search(int[] nums, int target) {
        return binary(nums, target);
    }

    int binary(int[] nums, int t) {
        int i = 0, j = nums.length;
        while(i < j) {
            int m = i + (j - i) / 2;
            if(nums[m] > t) {
                j = m;
            } else if(nums[m] < t) {
                i = m+1;
            } else {
                return m;
            }
        }

        return -1;
    }
}