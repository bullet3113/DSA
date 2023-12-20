// https://leetcode.com/problems/sort-colors

class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            int idx = i, min = nums[i];
            for(int j = i+1; j < n; j++) {
                if(nums[j] < min) {
                    min = nums[j];
                    idx = j;
                }
            }

            // swapping
            int temp = nums[i];
            nums[i] = nums[idx];
            nums[idx] = temp;
        }
    }
}