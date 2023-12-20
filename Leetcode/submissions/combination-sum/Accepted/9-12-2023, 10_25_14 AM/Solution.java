// https://leetcode.com/problems/combination-sum

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> list = new ArrayList<>();
        helper(candidates, target, 0, 0, new ArrayList<>(), list);

        return list;
    }

    void helper(int[] a, int t, int i, int sum, List<Integer> temp, List<List<Integer>> list) {

        if(sum > t) return;

        if(sum == t) {
            // Collections.sort(temp);
            // if(!list.contains(temp)) {
                list.add(new ArrayList(temp));            
            // }

            return;
        }

        if(i == a.length) return;

        // for(int j = 0; j <= i; j++) {
            temp.add(a[i]);
            helper(a, t, i, sum + a[i], temp, list);
            temp.remove(temp.size() - 1);
            helper(a, t, i+1, sum, temp, list);
        // }
    }
}