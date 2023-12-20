// https://leetcode.com/problems/search-insert-position

class Solution {
    public int searchInsert(int[] nums, int target) {
        int i = 0, j = nums.length-1;

        while(i <= j) {
            int mid = i + (j - i) / 2;

            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) {
                if(mid > 0 && nums[mid - 1] < target) return mid;
                else j = mid - 1;
            } else if(nums[mid] < target) {
                if(mid < nums.length-1 && nums[mid + 1] > target) return mid + 1;
                else i = mid + 1;
            }
        }

        if(target < nums[0]) return 0;
        return nums.length;
    }
}