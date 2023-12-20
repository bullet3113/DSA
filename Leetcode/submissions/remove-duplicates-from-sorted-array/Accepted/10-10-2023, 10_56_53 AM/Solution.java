// https://leetcode.com/problems/remove-duplicates-from-sorted-array

class Solution {
    public int removeDuplicates(int[] nums) {
        int ans = 0;

        int n = nums.length;
        int i = 0, j = 0; // initial pointer
        int parentIdx = 0;

        while(i < n) {

            if(nums[i] != nums[j]) {
                nums[parentIdx++] = nums[j];
                j = i;
                ans++;
            }

            i++;
        }

        nums[parentIdx] = nums[j];
        return ans+1;
    }
}