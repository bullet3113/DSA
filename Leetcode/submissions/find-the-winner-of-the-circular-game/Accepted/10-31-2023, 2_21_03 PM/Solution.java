// https://leetcode.com/problems/find-the-winner-of-the-circular-game

class Solution {
    public int findTheWinner(int n, int k) {
        
        List<Integer> list = new ArrayList<>(n);
        for(int i = 1; i <= n; i++) list.add(i);

        return helper(0, k-1, list);
    }

    int helper(int i, int k, List<Integer> list) {
        if(list.size() == 1) return list.get(0);

        i += k;
        i %= list.size();

        list.remove(i);
        return helper(i, k, list);
    }
}