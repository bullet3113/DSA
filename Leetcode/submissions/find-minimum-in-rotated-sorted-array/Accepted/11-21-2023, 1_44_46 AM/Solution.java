// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array

class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        int mid = 0;
        
        while(i <= j) {

            mid = i + (j - i) / 2;
            if(mid > 0 && mid < n-1 && nums[mid] < nums[mid-1] && nums[mid] < nums[mid+1]) break;
            else if(nums[mid] >= nums[0] && nums[mid] > nums[n-1]) i = mid + 1;
            else if(nums[mid] <= nums[0] && nums[mid] < nums[n-1]) j = mid - 1;
            
            else {
                i++;
                j--;
            }
        }

        if(nums[0] < nums[n-1]) return nums[0];
        if(n >= 2 && nums[n-1] < nums[n-2]) return nums[n-1];

        return nums[mid];
    }
}