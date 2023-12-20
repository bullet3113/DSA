// https://leetcode.com/problems/permutations

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        permute(list, nums, 0, new ArrayList<Integer>());
        return list;
    }

    void permute(List<List<Integer>> list, int[] nums, int j, List<Integer> temp) {
        if(j == nums.length) {
            List<Integer> deepCopy = new ArrayList<>(temp);
            list.add(deepCopy);
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            
            if(nums[i] != -11) {
                int val = nums[i];
                nums[i] = -11;
                temp.add(val);
                permute(list, nums, j+1, temp);
                temp.remove(temp.size() - 1);
                nums[i] = val;
            }
        }
    }
}