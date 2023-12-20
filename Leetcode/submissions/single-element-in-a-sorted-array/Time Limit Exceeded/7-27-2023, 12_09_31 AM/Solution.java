// https://leetcode.com/problems/single-element-in-a-sorted-array

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int i = 0, j = n-1;
        boolean check = true;

        if(n > 2) {
            if(nums[0] != nums[1] && nums[1] == nums[2]) return nums[0];
            else if(nums[n-1] != nums[n-2] && nums[n-2] == nums[n-3]) return nums[n-1];
        }
        while(i <= j) {
            int mid = i + (j - i) / 2;

            if(mid > 0 && nums[mid] == nums[mid-1]) i++;
            else if(mid < n-1 && nums[mid] == nums[mid+1]) j--;
            else return nums[mid];

            if(i > j && check) {
                i = 0;
                j = n/2 + 1;
                check = false;
            } else if(i > j && !check) {
                i = n/2 + 1;
                j = n-1;
            }
        }

        return -1;
    }
}