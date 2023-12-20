// https://leetcode.com/problems/max-number-of-k-sum-pairs

class Solution {
    public int maxOperations(int[] nums, int k) {
        int maxOps = 0;
        int n = nums.length;  
        Arrays.sort(nums);
        int i = 0, j = n - 1;

        while(i < j) {
            int sum = nums[i] + nums[j];

            if(sum == k) {
                i++;
                j--;
                maxOps++;
            } else if(sum < k) {
                i++;
            } else j--;
        }
        return maxOps;
    }
}