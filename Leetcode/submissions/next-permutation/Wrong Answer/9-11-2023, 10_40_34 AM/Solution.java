// https://leetcode.com/problems/next-permutation

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        for(int i = n-1; i >  0; i--) {
            if(nums[i] > nums[i-1]) {
                int temp = nums[i];
                nums[i] = nums[i-1];
                nums[i-1] = temp;
                return;
            }
        }

        Arrays.sort(nums);
    }
}