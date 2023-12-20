// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        int n = nums.length;

        int i = 0, j = n-1;
        boolean si = true, ei = true;

        while(i <= j) {
            int mid = i + (j - i) / 2;
            
            if(!si && !ei) return ans;
            
            if(nums[mid] == target) {
                if(si) {
                    if(mid > 0 && nums[mid-1] == target) j = mid - 1;
                    else {
                        ans[0] = mid;
                        si = false;
                    }
                } else if(ei) {
                    if(mid < n-1 && nums[mid+1] == target) i = mid + 1;
                    else {
                        ans[1] = mid;
                        ei = false;
                    }
                }

                if(i >= j) {
                if(si) i = 0;
                else if(ei) j = n-1;
            }
            } else if(nums[mid] > target) j = mid - 1;
            else if(nums[mid] < target) i = mid + 1;
        }

        return ans;
    }
}