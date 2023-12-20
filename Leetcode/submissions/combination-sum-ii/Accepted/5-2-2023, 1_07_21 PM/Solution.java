// https://leetcode.com/problems/combination-sum-ii

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, list, new ArrayList<>());
        return list;
    }

    void helper(int a[], int sum, int i, List<List<Integer>> list, List<Integer> temp) {
        if(sum == 0) {
            list.add(new ArrayList<>(temp));
            return;
        }

        // if(i == a.length || sum < 0)
        //     return;

        for(int start = i; start < a.length; start++) {
            if(start > i && a[start] == a[start-1]) continue;
            if(a[start] > sum) break;
            temp.add(a[start]);
            helper(a, sum-a[start], start+1, list, temp);
            temp.remove(temp.size() - 1);
            // helper(a, sum, start, list, temp);
        }
    }
}