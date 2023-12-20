// https://leetcode.com/problems/max-consecutive-ones-iii

class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int max = 0;
        
        int j = 0; // first pointer

        for(int i = 0; i < n; i++) {
            int ele = nums[i];

            if(ele == 0 && k >= 0) k--; // decreamenting k if we found 0

            // if k goes -ve then we move first pointer to look for 0 from left
            while(k < 0 && j <= i) {
                if(nums[j] == 0) k++;
                j++;
            }

            if(k >= 0) // not cosidering the -ve case
                max = Math.max(max, i - j + 1);
        }

        return max;
    }
}