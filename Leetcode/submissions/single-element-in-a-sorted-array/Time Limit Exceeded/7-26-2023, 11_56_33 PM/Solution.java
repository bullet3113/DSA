// https://leetcode.com/problems/single-element-in-a-sorted-array

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int i = 0, j = n-1;

        while(i <= j) {
            int mid = i + (j - i) / 2;

            if(mid > 0 && nums[mid] == nums[mid-1]) i = mid + 1;
            else if(mid < n-1 && nums[mid] == nums[mid+1]) j = mid-1;
            else return nums[mid];

            if(i > j) {
                i = 0;
                j = n/2 + 1;
            }
        }

        return -1;
    }
}