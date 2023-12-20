// https://leetcode.com/problems/lexicographical-numbers

class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        
        for(int i = 1; i <= n; i++) list.add(i);
        
        return list;
    }
}