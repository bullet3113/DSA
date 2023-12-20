// https://leetcode.com/problems/pascals-triangle

class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j <= i; j++) {
                if(j == 0 || j == i) temp.add(1);
                else {
                    List<Integer> t = list.get(i-1);
                    temp.add(t.get(j-1) + t.get(j));
                }
            }
            list.add(temp);
        }

        return list;
    }
}