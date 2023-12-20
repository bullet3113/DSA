// https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        
        int n = nums.length;
        int i = 1;

        int j = Integer.MIN_VALUE;
        for(int k = 0; k < n; k++) j = Math.max(j, nums[k]);

        while(i <= j) {

            int mid = i + (j - i) / 2;

            int sum = 0;
            for(int k = 0; k < n; k++) {
                sum += (int)Math.ceil(nums[k] * 1.0 / mid);
            }

            if(sum <= threshold) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        return i;
    }
}