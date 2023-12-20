// https://leetcode.com/problems/two-sum

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] ans = {0, 0};

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int comp = target - nums[i];
            if(map.containsKey(comp)) {
                ans[0] = i;
                ans[1] = map.get(comp);
            } else {
                map.put(nums[i], i);
            }
        }
        return ans;
    }
}