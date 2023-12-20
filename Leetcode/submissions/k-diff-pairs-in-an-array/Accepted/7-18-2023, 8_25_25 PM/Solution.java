// https://leetcode.com/problems/k-diff-pairs-in-an-array

class Solution {
    public int findPairs(int[] nums, int k) {
			
		int n = nums.length;
    // if(k == 0) return 0;
		Arrays.sort(nums);
		int i = 0, j = 1, sum = Integer.MIN_VALUE;
		int ans = 0;
		while(j < n && i < n-1) {
			int diff = nums[j] - nums[i];
			if(diff == k && (nums[i] + nums[j]) != sum) {
				sum = nums[i] + nums[j];
				i++;
				j++;
				ans++;
			} else if(diff < k) {
				j++;
			} else i++;

			if(i == j) j++;
		}
		return ans;
    }
}