// https://leetcode.com/problems/count-number-of-nice-subarrays

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        // converting the problem to BINARY SUBARRAY WITH SUM   
        return helper(nums, k) - helper(nums, k - 1);
    }

    int helper(int nums[], int k) {

        int n = nums.length;
        int max = 0;

        int j = 0; // first pointer
        int sum = 0;

        for(int i = 0; i < n; i++) {
            if(nums[i] % 2 == 1) sum += 1; // decrease k if any odd number found
            else sum += 0;

            while(sum > k && j <= i) {
                if(nums[j] % 2 == 1) sum -= 1;
                j++;
            }

            max += (i - j + 1) ;
        }
        return max;
    }
}