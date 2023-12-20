// https://leetcode.com/problems/majority-element

class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;

        int ele = 0, sum = 0;

        for(int i = 0; i < n; i++) {
            if(sum <= 0) {
                ele = nums[i];
                sum = 1;
            } else if(ele == nums[i]) sum ++;
            else if(ele != nums[i]) sum--;
        }

        return ele;
    }
}