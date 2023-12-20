// https://leetcode.com/problems/combination-sum-iii

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        helper(k, n, list, 1, new ArrayList<>());
        return list;
    }

    void helper(int k, int n, List<List<Integer>> list, int i, List<Integer> temp) {
        if(k == 0) {
            if(n == 0) {
                Collections.sort(temp);
                if(!list.contains(temp))
                list.add(new ArrayList<>(temp));
            }
            return;
        }

        for(int start = i; start <= 9; start++) {
            if(temp.size() > 0 && temp.get(temp.size()-1) == start) continue;
            temp.add(start);
            helper(k-1, n-start, list, i+1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}