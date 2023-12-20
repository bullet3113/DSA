// https://leetcode.com/problems/combinations

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        helper(n, k, list, new ArrayList<>(), 1);
        return list;
    }

    void helper(int n, int k, List<List<Integer>> list, ArrayList<Integer> temp, int start) {

        if(k == 0) {
            list.add(new ArrayList<>(temp));
            return;
        }

        for(int i = start; i <= n; i++) {
            // if(temp.contains(i)) continue;
            // if(temp.size() > 0 && temp.get(0) > i) continue;
            temp.add(i);
            helper(n, k-1, list, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}