// https://leetcode.com/problems/subsets-ii

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums);
        helper(list, nums, 0, new ArrayList<>());
        return list;
    }

    void helper(List<List<Integer>> list, int[] nums, int i, List<Integer> temp) {
        if(i == nums.length) {
            if(!list.contains(temp))
            list.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[i]);
        helper(list, nums, i+1, temp);
        temp.remove(temp.size() - 1);

        helper(list, nums, i+1, temp);
    }
}