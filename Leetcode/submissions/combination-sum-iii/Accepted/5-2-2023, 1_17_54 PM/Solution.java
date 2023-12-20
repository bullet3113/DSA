// https://leetcode.com/problems/combination-sum-iii

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        helper(k, n, 1, list, new ArrayList<>());
        return list;
    }

    void helper(int k, int sum, int i, List<List<Integer>> list, List<Integer> temp) {
        if(sum == 0 && k == 0) {
            list.add(new ArrayList<>(temp));
            return;
        }

        // if(k == 0)
        //     return;

        for(int start = i; start <= 9; start++) {
            if(start > sum) break;
            temp.add(start);
            helper(k-1, sum - start, start+1, list, temp);
            temp.remove(temp.size() - 1);
        }
    }
} 