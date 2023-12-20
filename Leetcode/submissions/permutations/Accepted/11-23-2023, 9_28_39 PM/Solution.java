// https://leetcode.com/problems/permutations

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();

        helper(nums, n, new ArrayList<>(), list, new boolean[n]);
        return list;
    }

    void helper(int[] nums, int n, List<Integer> temp, List<List<Integer>> list, boolean[] vis) {

        if(temp.size() == n) {
            list.add(new ArrayList(temp));
            return;
        } 

        for(int i = 0; i < n; i++) {
            if(vis[i]) continue;
            vis[i] = true;
            temp.add(nums[i]);
            helper(nums, n, temp, list, vis);
            vis[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}