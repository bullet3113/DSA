// https://leetcode.com/problems/k-diff-pairs-in-an-array

class Solution {
    public int findPairs(int[] nums, int k) {
			
		int n = nums.length;
    if(k == 0) return 1;
		Arrays.sort(nums);
		int i = 0, j = 0;
		int ans = 0;
		while(j < n) {
			int diff = nums[i] - nums[j];
			if(Math.abs(diff) == k) {
				i++;
				j++;
				ans++;
			} else if(Math.abs(diff) > k) {
				i++;
			} else j++;
		}
		return ans;
    }
}