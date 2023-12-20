// https://leetcode.com/problems/3sum

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums);

        for(int i = 0; i < n; i++) {
            int j = i + 1;
            int k = n - 1;

            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if(sum == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]); temp.add(nums[j]); temp.add(nums[k]);
                    list.add(temp);
                    j++;
                    k--;
                } else if(sum < 0) {
                    while(j < k) {j++; if(nums[j] == nums[k] || nums[j] == nums[i]) j++;}
                } else {
                    while(j < k) {k--; if(nums[j] == nums[k] || nums[k] == nums[i]) k--;}
                }


            }
        }

        return list;
    }
}