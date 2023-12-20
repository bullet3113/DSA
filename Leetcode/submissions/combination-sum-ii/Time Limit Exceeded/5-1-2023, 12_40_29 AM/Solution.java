// https://leetcode.com/problems/combination-sum-ii

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        helper(0, candidates, target, list, new ArrayList<>());
        return list;
    }

    void helper(int i, int arr[], int sum, List<List<Integer>> list, List<Integer> temp) {
        if(sum < 0)
        return;
        
        if(i == arr.length) {
            if(sum == 0 && !list.contains(temp)) {
                list.add(new ArrayList<>(temp));
            }

            return;
        }

        if(arr[i] <= sum) {
            temp.add(arr[i]);
            helper(i+1, arr, sum - arr[i], list, temp);
            temp.remove(temp.size() - 1);        
        }
            helper(i + 1, arr, sum, list, temp);

    }
}