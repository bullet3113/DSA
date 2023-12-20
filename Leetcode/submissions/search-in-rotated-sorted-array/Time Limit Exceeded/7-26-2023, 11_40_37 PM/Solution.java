// https://leetcode.com/problems/search-in-rotated-sorted-array

class Solution {
    public int search(int[] nums, int target) {
        // finding the pivot index;

        int pivotIdx = findPivot(nums);

        // finding the element
        int eleIdx = bSearch(nums, 0, pivotIdx, target);

        if(eleIdx == -1) eleIdx = bSearch(nums, pivotIdx+1, nums.length-1, target);

        return eleIdx;
    }

    int bSearch(int[] nums, int i, int j, int target) {
        
        while(i <= j) {
            int mid = i + (j - i) / 2;

            if(nums[mid] > target) {
                j = mid - 1;
            } else if(nums[mid] < target) {
                i = mid + 1;
            } else return mid;
        }

        return -1;
    }

    int findPivot(int[] nums) {
        int n = nums.length;
        int i = 1, j = n-2;

        if(n > 1)
        if(nums[0] > nums[i]) return 0;

        while(i <= j) {
            int mid = i + (j - i) / 2;

            if(mid > 0 && mid < n - 1) {
                if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) return mid;
                else if(nums[mid] > nums[mid-1] && nums[mid] < nums[mid+1] && nums[mid] > nums[0]) i = mid + 1;
                else if(nums[mid] > nums[mid-1] && nums[mid] < nums[mid+1] && nums[mid] < nums[0]) j = mid - 1;
            } 
        }

        return n - 1;
    }
}