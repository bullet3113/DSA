// https://leetcode.com/problems/combination-sum

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        helper(list, candidates, target, 0, new ArrayList<>());
        return list;
    }

    void helper(List<List<Integer>> list, int[] arr, int sum, int i, List<Integer> temp) {
        if(i >= arr.length) {
            if(sum == 0) {
                list.add(new ArrayList<>(temp));
                return;
            }

            return;
        }

        if(sum < 0)
            return;

        if(sum == 0) {
            list.add(new ArrayList<>(temp));
            return;
        }

        for(int s = i; s < arr.length; s++) {
            temp.add(arr[s]);
            helper(list, arr, sum - arr[s], s, temp);
            temp.remove(temp.size()-1);
        }

        
    }
}