// https://leetcode.com/problems/combination-sum

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        helper(0, candidates, target, list, new ArrayList<>());
        return list;
    }

    void helper(int i, int[] arr, int sum, List<List<Integer>> list, List<Integer> temp) {
        

        if(i == arr.length) {
            if(sum == 0) {
                list.add(new ArrayList<>(temp));
            }
            return;
        }

            if(sum > 0 && arr[i] <= sum)
            {temp.add(arr[i]);
            helper(i, arr, sum - arr[i], list, temp);
            temp.remove(temp.size()-1);}
        helper(i+1, arr, sum, list, temp);}
    
}