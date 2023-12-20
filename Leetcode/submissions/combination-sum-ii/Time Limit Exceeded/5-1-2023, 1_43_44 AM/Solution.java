// https://leetcode.com/problems/combination-sum-ii

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        helper(0, candidates, target, list, new ArrayList<>(), new boolean[candidates.length]);
        return list;
    }

    void helper(int i, int arr[], int sum, List<List<Integer>> list, List<Integer> temp, boolean maps[]) {
        if(sum < 0)
        return;
        
        if(sum == 0 && !list.contains(temp)) {
                list.add(new ArrayList<>(temp));
                return;
            } else if(sum == 0) return;

        if(i == arr.length) {
            if(sum == 0 ) {
                list.add(new ArrayList<>(temp));
            }

            return;
        }

        // if(arr[i] <= sum) {
            if(!maps[i] && sum - arr[i] >= 0) {
                maps[i] = true;
                temp.add(arr[i]);
                helper(i+1, arr, sum - arr[i], list, temp, maps);
                temp.remove(temp.size() - 1);
            }
        // }
        maps[i] = false;
            helper(i + 1, arr, sum, list, temp, maps);

    }
}