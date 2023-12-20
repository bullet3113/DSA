// https://leetcode.com/problems/split-array-largest-sum

class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;

        int i = 0;
        int j = 0;
        for(int val: nums) j += val;
        int ans = 0;
        while(i <= j) {

            int mid = i + (j - i) / 2;

            if(isPossible(nums, n, k, mid)) {
                ans = mid;
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        return ans;
    }

    boolean isPossible(int[] nums, int n, int k, int mid) {

        int elementCount = 1;
        int sum = mid;

        for(int i = 0; i < n; i++) {
            if(nums[i] <= sum) {
                sum -= nums[i];
            } else {
                elementCount++;
                sum = mid - nums[i];

                if(sum < 0 || elementCount > k) return false;
            }
        }

        return true;
    }
}