// https://leetcode.com/problems/generate-parentheses

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> x = new ArrayList<>();
        helper(n, n, x, "", n*2);
        return x;
    }

    void helper(int n, int m, List<String> x, String p, int l) {
        if(p.length() == l) {
            // if(!x.contains(p))
            x.add(p);
            return;
        }
 

        if(n > 0 && n <= m)
        helper(n-1, m, x, p+"(", l);
        if(m > 0 && m >= n)
        helper(n, m-1, x, p + ")", l);
    }
}